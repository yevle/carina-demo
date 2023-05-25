package ylevchenko.gfit.mobile.gui.perfomance;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface IPerformanceTest extends IAbstractTest {

    @BeforeSuite
    default void setPerformanceListener() {
        R.CONFIG.put("driver_event_listeners", "ylevchenko.gfit.mobile.gui.perfomance.PerfListener");
        PerfListener.startPerformanceTracking();
    }

    @AfterMethod
    default void stopPerformanceTracking() {
        PerfListener.stopPerformanceTracking();
    }

    @AfterSuite
    default void printPerfBench() {
        PerfListener.collect();
    }

}
