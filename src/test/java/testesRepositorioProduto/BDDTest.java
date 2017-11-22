package testesRepositorioProduto;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/featuresRepositorioProdutos")
public class BDDTest {

}
