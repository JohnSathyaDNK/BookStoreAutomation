package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.AllureReportConfigurationSetup;

@RunWith(Cucumber.class)

@CucumberOptions(	
		features = {"src/test/resources/features/" }, 
		glue={"stepDefinition"},
		plugin = { "html:target/report.html"
				//,"html:target/cucumber-reports.html"
				,"pretty"
		},
		monochrome = true)

public class TestRunner {
	@AfterClass
	public static void setup()
	{
//		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
//		//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
//		Reporter.setSystemInfo("User Name", "AJ");
//		Reporter.setSystemInfo("Application Name", "Test App ");
//		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
//		Reporter.setSystemInfo("Environment", "Production");
//		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		
		AllureReportConfigurationSetup.prepareAllureResultsFolder();

	}
}