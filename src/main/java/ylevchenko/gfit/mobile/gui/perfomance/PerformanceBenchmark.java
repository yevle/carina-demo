package ylevchenko.gfit.mobile.gui.perfomance;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;

import java.time.Instant;

public class PerformanceBenchmark {

    private final Instant time;
    private final double cpuBenchmark;
    private final double memBenchmark;

    private double runTime;

    public PerformanceBenchmark(double cpuBenchmark, double memBenchmark, Instant time) {
        this.cpuBenchmark = cpuBenchmark;
        this.memBenchmark = memBenchmark;
        this.time = time;
    }

    public Instant getTime() {
        return time;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    public Point getPoint() {
        return Point
                .measurement("mem")
                .addTag("Benchmarks", "CPU, MEM")
                .addField("CPU", cpuBenchmark)
                .addField("MEM", memBenchmark)
                .addField("RUN", runTime)
                .time(time, WritePrecision.NS);
    }

    @Override
    public String toString() {
        return "TIME:" + time.toString() + " CPU:" + cpuBenchmark + " MEM:" + memBenchmark + "RUN:" + runTime;
    }

}
