package ylevchenko.gfit.mobile.gui.perfomance;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.zebrunner.agent.core.registrar.CurrentTestRun;
import com.zebrunner.carina.utils.R;
import ylevchenko.gfit.mobile.gui.service.IPerformanceCredits;

import java.time.Instant;

public class EnvironmentParser implements IDriverPool, IPerformanceCredits {

    private final String environment;
    private final String locale;
    private final String osVersion;
    private final String deviceName;
    private final String platformName;
    private final long testRun;
    private final Instant time;

    public EnvironmentParser() {
        this.time = Instant.now();
        this.environment = R.CONFIG.get("env");
        this.locale = R.CONFIG.get("locale");
        this.osVersion = getDevice().getOsVersion();
        System.out.println(osVersion);
        this.deviceName = getDevice().getName();
        System.out.println(deviceName);
        this.platformName = R.CONFIG.get("capabilities.platformName");
        this.testRun = CurrentTestRun.getId().orElse(0L);
    }

    public Point getPoint() {
        return new Point(MEASUREMENT_NAME)
                .addTag(BENCHMARKS, "Environment")
                .addField("ENV", environment)
                .addField("Locale", locale)
                .addField("OS_Version", osVersion)
                .addField("Device_Name", deviceName)
                .addField("Platform_Name", platformName)
                .addField("Test_Run", testRun)
                .time(time, WritePrecision.NS);
    }

}
