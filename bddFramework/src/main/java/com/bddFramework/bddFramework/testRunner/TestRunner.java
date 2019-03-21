package com.bddFramework.bddFramework.testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resource/featuresFile", glue = {
		"com.bddFramework.bddFramework.stepDefination" }, plugin = { "pretty",
				"html: target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json",
				"rerun: target/cucumber-reports/rerun.txt" })
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberReunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberReunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberReunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberReunner.provideFeatures();
	}

	@AfterClass
	public void testDownClass() {
		testNGCucumberReunner.finish();
	}
}
