package ylevchenko.gfit.mobile.gui.utils;

import com.google.common.collect.ImmutableMap;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Collections;

public class MobileShellCommands implements IDriverPool {
    private String packageName = "com.google.android.apps.fitness";

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
        String cpuOutput;

        String p1 = packageName.substring(0, 14).concat("+");
        String p2 = packageName.substring(0, 15).concat("+");

        try {
                cpuOutput = (String) ((JavascriptExecutor) getDriver()).executeScript("mobile: shell",
                        ImmutableMap.of("command", "", "args", Collections.singletonList(String.format(cpuCommand, p1, p2))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cpuOutput;
    }

}
