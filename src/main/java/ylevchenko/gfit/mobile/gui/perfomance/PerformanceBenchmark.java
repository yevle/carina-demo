package ylevchenko.gfit.mobile.gui.perfomance;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import ylevchenko.gfit.mobile.gui.service.IPerformanceCredits;

import java.time.Instant;

public class PerformanceBenchmark implements IPerformanceCredits {

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
                .measurement(MEASUREMENT_NAME)
                .addTag(BENCHMARKS, "Resources over time")
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
