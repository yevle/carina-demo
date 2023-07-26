package ylevchenko.perfomance;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import ylevchenko.gfit.mobile.gui.service.IPerformanceCredits;

import java.time.Instant;

public class PerformanceBenchmark implements IPerformanceCredits {

    private final Instant time;
    private final double cpuBenchmark;
    private final double memBenchmark;
    private double loadTime;

    public PerformanceBenchmark(double cpuBenchmark, double memBenchmark, Instant time) {
        this.cpuBenchmark = cpuBenchmark;
        this.memBenchmark = memBenchmark;
        this.time = time;
    }

    public Instant getTime() {
        return time;
    }

    public void setLoadTime(double loadTime) {
        this.loadTime = loadTime;
    }

    public Point getPoint() {
        return Point
                .measurement(MEASUREMENT_NAME)
                .addTag(BENCHMARKS, "Resources over time")
                .addField("CPU", cpuBenchmark)
                .addField("Memory", memBenchmark)
                .addField("Load time", loadTime)
                .time(time, WritePrecision.NS);
    }

    @Override
    public String toString() {
        return "TIME:" + time.toString() + " CPU:" + cpuBenchmark + " MEM:" + memBenchmark + "RUN:" + loadTime;
    }

}
