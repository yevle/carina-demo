package ylevchenko.perfomance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.List;

public class PerformanceListener implements WebDriverListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static PerformanceCollector performanceCollector;

    private boolean isClick = false;

    private boolean isEnvRead = false;

    public static void startPerformanceTracking() {
        performanceCollector = new PerformanceCollector();
        LOGGER.info("Start tracking metrics: {}", performanceCollector.grafanaStartLink(5));
    }

    public static void stopPerformanceTracking() {
        performanceCollector.setTimeToLastBenchmark();
        performanceCollector.writeGFXData();
        LOGGER.info("Final performance metrics: {}", performanceCollector.grafanaFinalLink());
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
        isClick = true;
    }

    @Override
    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
        if (isClick) {
            performanceCollector.setTimeToLastBenchmark();
            isClick = false;
        }
    }

    public static List<PerformanceBenchmark> collect() {
        return performanceCollector.getBenchmarksList();
    }

}
