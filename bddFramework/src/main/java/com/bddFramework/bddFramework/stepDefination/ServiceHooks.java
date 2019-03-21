package com.bddFramework.bddFramework.stepDefination;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks {

	com.bddFramework.bddFramework.testBase.TestBase testBase;

	Logger log = Logger.getLogger(ServiceHooks.class);

	@Before
	public void initializeTest() {
		testBase = new com.bddFramework.bddFramework.testBase.TestBase();
		testBase.selectBrowser(com.bddFramework.bddFramework.enums.Browsers.CHROME.name());
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) com.bddFramework.bddFramework.testBase.TestBase.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) com.bddFramework.bddFramework.testBase.TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		com.bddFramework.bddFramework.testBase.TestBase.driver.quit();
	}
}
