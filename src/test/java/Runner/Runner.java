package Runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},glue ={"StepDefinition"},
tags = "@search-book or @select-menu",
//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//plugin = {"pretty","html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
monochrome = true
//strict = true, 
//dryRun = false
)

public class Runner {
	

}

