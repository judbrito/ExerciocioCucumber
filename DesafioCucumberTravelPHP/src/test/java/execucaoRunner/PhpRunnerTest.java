package execucaoRunner;

import static excucaoWeb.DriverWeb.ativarNavegador;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/main/resources/feature/siteTravelPhp.feature", glue = "execucaoSteps", plugin = {
		"pretty", "html:target/reporthtml",
		"json:target/report.json" }, snippets = SnippetType.CAMELCASE, monochrome = false, dryRun = false, strict = false)
public class PhpRunnerTest {
	@AfterClass
	public static void fecharPagina() {
		if (ativarNavegador() != null) {
			ativarNavegador().quit();
		}
	}
}