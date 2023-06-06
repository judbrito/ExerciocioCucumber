package test.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/main/resources/feature/siteTravelPhp.feature", glue = "test.business.formulario", plugin = {
		"pretty", "html:target/reporthtml",
		"json:target/report.json" }, snippets = SnippetType.CAMELCASE, monochrome = false, dryRun = false, strict = false)
public class Runner {

	@AfterClass
	public static void fecharPagina() {
		// tearDown();

	}
}
