package ylevchenko.gsmarena.mobile.gui.utils;

import com.google.common.collect.ImmutableMap;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Collections;

public class MobileShellCommands implements IDriverPool {

        private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

        private String packageName = "com.gsmarena.android";

        private final String enterCmd = "input keyevent 66";

        private void executeCmd(String cmd) {
            try {
                ((JavascriptExecutor) getDriver()).executeScript("mobile: shell",
                        ImmutableMap.of("command", "", "args", Collections.singletonList(String.format(cmd, packageName))));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void pressEnter(){
            executeCmd(enterCmd);
        }

}
