package ylevchenko.gfit.mobile.gui.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADBUtils {

    private static String packageName = "com.google.android.apps.fitness";

    private static String executeAdbCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString();
    }

    public static String getCpuUsageOutput() throws IOException {
        String p1 = packageName.substring(0, 14).concat("+");
        String p2 = packageName.substring(0, 15).concat("+");
        return executeAdbCommand(String.format("adb shell top -n 1 | grep -E \"%s|%s\"", p1, p2));
    }

    public static String getMemoryUsageOutput() throws IOException {
        return executeAdbCommand("adb shell dumpsys meminfo " + packageName);
    }

    public static String getNetworkUsageOutput() throws IOException {
        return executeAdbCommand("adb shell dumpsys netstats --package " + packageName);
    }

    public static String getBatteryUsageOutput() throws IOException {
        return executeAdbCommand("adb shell dumpsys battery");
    }

}


