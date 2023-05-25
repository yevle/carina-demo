package ylevchenko.gfit.mobile.gui.perfomance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;
import java.util.List;

public class PerfListener implements WebDriverListener {

    private static PerformanceCollector performanceCollector;

    private Long start;

    private boolean isClick = false;

    public static void startPerformanceTracking() {
        performanceCollector = new PerformanceCollector();
    }

    public static void stopPerformanceTracking() {
        performanceCollector.writeGFXData();
    }

    @Override
    public void afterClick(WebElement element) {
        performanceCollector.addPerformanceBenchmark();
        start = System.currentTimeMillis();
        isClick = true;
    }

    @Override
    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
        if (isClick) {
            performanceCollector.setTimeToLastBenchmark(System.currentTimeMillis()-start);
            isClick = false;
        }
    }

    public static List<PerformanceBenchmark> collect() {
        return performanceCollector.getBenchmarksList();
    }

}
