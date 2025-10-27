package com.testautomation.steps;

import com.testautomation.utils.BaseClass;
import com.testautomation.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
    private ConfigReader config;

    @Before
    public void beforeScenario() {
        init();
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
