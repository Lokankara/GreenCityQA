package com.softserve.greencity.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.softserve.greencity.ui.tools.testing.TestNgListeners;
import com.softserve.greencity.api.google.ValueProvider;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeOptions;

@Listeners(TestNgListeners.class)
public class BaseTestRunner {
    protected static final String BASE_URL = ValueProvider.getBaseUrl();
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected SoftAssert softAssert;
    ChromeOptions options = new ChromeOptions();
}
