package ylevchenko.perfomance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ylevchenko.gfit.mobile.gui.service.IPerformanceCredits;
import ylevchenko.gfit.mobile.gui.utils.MobileShellCommands;

import java.lang.invoke.MethodHandles;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PerformanceCollector implements IPerformanceCredits {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Instant startTime;

    private Instant stopTime;

    private String pid;

    private final String grafanaLink = GRAFANA_BASE_URL;

    private final InfluxDBService influxDBService = new InfluxDBService();

    private PerformanceBenchmark lastBenchmark;

    private long lastLoadStartTime;

    MobileShellCommands shellCommands = new MobileShellCommands();

    private final List<PerformanceBenchmark> benchmarksList = new ArrayList<>();

    public void addPerformanceBenchmark() {
        Instant time = Instant.now();
        String output = "";
        try {
            output = shellCommands.getCpuMemOutput();
        } catch (RuntimeException e) {
            LOGGER.warn("No data for CPU and MEM are collected");
        }

        lastLoadStartTime = System.currentTimeMillis();
        if (pid == null) {
            pid = shellCommands.getPidOutput();
        }

        benchmarksList.add(lastBenchmark = createPerformanceBenchmark(output, time));
    }

    public void addPerformanceBenchmarkWithTime(Long runTime) {
        Instant time = Instant.now();
        String output = shellCommands.getCpuMemOutput();
        PerformanceBenchmark benchmark = createPerformanceBenchmark(output, time);
        benchmark.setLoadTime(runTime);
        benchmarksList.add(benchmark);
    }

    public void setTimeToLastBenchmark() {
        lastBenchmark.setLoadTime(System.currentTimeMillis() - lastLoadStartTime);
        influxDBService.writePoint(lastBenchmark.getPoint());
    }

    public PerformanceBenchmark createPerformanceBenchmark(String output, Instant time) {
        String[] values = ShellOutputParser.parseCpuMemOutput(output, pid);

        double cpu = Double.parseDouble(values[0]);
        double mem = Double.parseDouble(values[1].substring(0, values[1].indexOf("M")) + ".0");

        return new PerformanceBenchmark(cpu, mem, time);
    }

    public PerformanceBenchmark createPerformanceBenchmark1(String output, Instant time) {
        String[] rows = output.split("\n");
        String firstRow = rows[0];
        String[] tokens = firstRow.split("\\s+");

        String cpuValue = tokens[9];
        String resValue = tokens[6];
        double cpu = Double.parseDouble(cpuValue);
        double mem = Double.parseDouble(resValue.substring(0, resValue.indexOf("M")) + ".0");

        return new PerformanceBenchmark(cpu, mem, time);
    }

    public void writeEnvironmentInfo() {
        if (startTime == null) {
            startTime = Instant.now();
        }
        influxDBService.writePoint(new EnvironmentParser().getPoint());
    }

    public void writeGFXData() {
        influxDBService.writePoint(ShellOutputParser.getGFXPoint(shellCommands.getGFXOutput()));
        if (stopTime == null) {
            stopTime = Instant.now();
        }
    }

    public List<PerformanceBenchmark> getBenchmarksList() {
        return benchmarksList;
    }

    public String grafanaFinalLink() {
        return String.format("%s?orgId=%s&from=%s&to=%s",
                grafanaLink, ORG_ID, startTime.toEpochMilli(), stopTime.toEpochMilli());
    }

    public String grafanaStartLink(int refreshRate) {
        String from = "now-5m";
        String to = "now";
        String refreshTime = refreshRate >= 60 ? "1m" : refreshRate + "s";
        return String.format("%s?orgId=%s&refresh=%s&from=%s&to=%s",
                grafanaLink, ORG_ID, refreshTime, from, to);
    }

}
