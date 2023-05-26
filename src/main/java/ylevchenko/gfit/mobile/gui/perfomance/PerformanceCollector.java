package ylevchenko.gfit.mobile.gui.perfomance;

import ylevchenko.gfit.mobile.gui.utils.MobileShellCommands;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PerformanceCollector {

    private final InfluxDBService influxDBService = new InfluxDBService();

    private PerformanceBenchmark lastBenchmark;

    MobileShellCommands shellCommands = new MobileShellCommands();

    private final List<PerformanceBenchmark> benchmarksList = new ArrayList<>();

    public void addPerformanceBenchmark() {
        Instant time = Instant.now();
        String output = shellCommands.getCpuMemOutput();
        benchmarksList.add(lastBenchmark = createPerfomanceBenchmark(output, time));
    }

    public void addPerformanceBenchmarkWithTime(Long runTime) {
        Instant time = Instant.now();
        String output = shellCommands.getCpuMemOutput();
        PerformanceBenchmark benchmark = createPerfomanceBenchmark(output, time);
        benchmark.setRunTime(runTime);
        benchmarksList.add(benchmark);
    }

    public void setTimeToLastBenchmark(Long time) {
        lastBenchmark.setRunTime(time);
        influxDBService.writePoint(lastBenchmark.getPoint());
    }

    public PerformanceBenchmark createPerfomanceBenchmark(String output, Instant time) {

        String[] rows = output.split("\n");
        String firstRow = rows[0];
        String[] tokens = firstRow.split("\\s+");

        String cpuValue = tokens[9];
        String resValue = tokens[6];
        double cpu = Double.parseDouble(cpuValue);
        double mem = Double.parseDouble(resValue.substring(0, resValue.indexOf("M")) + ".0");

        return new PerformanceBenchmark(cpu, mem, time);
    }

    public void writeEnvironmentInfo(){
        influxDBService.writePoint(new EnvironmentParser().getPoint());
    }

    public void writeGFXData() {
        influxDBService.writePoint(GFXParser.getGFXPoint(shellCommands.getGFXOutput()));
    }

    public List<PerformanceBenchmark> getBenchmarksList() {
        return benchmarksList;
    }

}
