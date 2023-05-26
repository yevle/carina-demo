package ylevchenko.gfit.mobile.gui.perfomance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;
import java.util.List;

public class PerformanceListener implements WebDriverListener {

    private static PerformanceCollector performanceCollector;

    private Long start;

    private boolean isClick = false;

    private boolean isEnvRead = false;

    public static void startPerformanceTracking() {
        performanceCollector = new PerformanceCollector();
    }

    public static void stopPerformanceTracking() {
        performanceCollector.writeGFXData();
    }

    @Override
    public void beforeClick(WebElement element) {
        if (!isEnvRead) {
            performanceCollector.writeEnvironmentInfo();
            isEnvRead = true;
        }
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
