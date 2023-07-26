package ylevchenko.gfit.mobile.gui.utils;

import com.google.common.collect.ImmutableMap;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Collections;

public class MobileShellCommands implements IDriverPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private String packageName = "com.google.android.apps.fitness";

    private final String pidCommand = "pidof -s %s";
    private final String cpuCommand = "top -n 1 | grep -E \"%s|%s\"";
    private final String GFXCommand = "dumpsys gfxinfo %s framestats";

    public String getGFXOutput() {
        String GFXOutput;

        try {
            GFXOutput = (String) ((JavascriptExecutor) getDriver()).executeScript("mobile: shell",
                    ImmutableMap.of("command", "", "args", Collections.singletonList(String.format(GFXCommand, packageName))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return GFXOutput;
    }

    public String getCpuMemOutput() {
        String cpuOutput = "";

        String p1 = packageName.substring(0, 14).concat("+");
        String p2 = packageName.substring(0, 15).concat("+");

        for (int i = 0; i < 4; i++) {
            try {
                cpuOutput = (String) ((JavascriptExecutor) getDriver()).executeScript("mobile: shell",
                        ImmutableMap.of("command", "", "args", Collections.singletonList(String.format(cpuCommand, p1, p2))));
            } catch (Exception e) {
                LOGGER.warn("Command hasn't executed properly");
            }
            if (!cpuOutput.isEmpty()) break;
        }

        if (cpuOutput.isEmpty()) {
            throw new RuntimeException();
        }
        return cpuOutput;
    }

    public String getPidOutput() {
        String pid;

        try {
            pid = (String) ((JavascriptExecutor) getDriver()).executeScript("mobile: shell",
                    ImmutableMap.of("command", "", "args", Collections.singletonList(String.format(pidCommand, packageName))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pid.trim();
    }

}
