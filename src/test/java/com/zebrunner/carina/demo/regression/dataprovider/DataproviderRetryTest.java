/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.regression.dataprovider;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Carina regression test with retries and it's registration in Zafira.
 * It just generate failure in 50% of cases and on retry should improve statistic
 *
 * @author qpsdemo
 */
public class DataproviderRetryTest implements IAbstractTest {

    @Test(dataProvider = "DP1")
    @MethodOwner(owner = "qpsdemo")
    public void testDataproviderRetry(String testRailColumn, int a, int b, int c) {
        boolean isPassed = (new Random().nextInt(2) == 1) ? true : false;
        Assert.assertTrue(isPassed);

        setCases(testRailColumn.split(","));
        int actual = a * b;
        int expected = c;
        Assert.assertEquals(actual, expected, "Invalid sum result!");
    }

    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36},
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36},
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36},
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36},
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36}};
    }

}
