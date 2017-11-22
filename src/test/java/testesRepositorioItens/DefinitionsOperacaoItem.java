package testesRepositorioItens;



import com.sistex.App;
import com.sistex.cdp.Item;
import com.sistex.cgd.ItemRepositorio;
import com.sistex.util.Fabrica;
import com.sistex.util.Tipo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@SuppressWarnings("deprecation")
public class DefinitionsOperacaoItem {

    private final Fabrica fabrica = Fabrica.make(Tipo.ITEM);
    private final Item item = fabrica.criaItem();
    private String operacao;

    @Autowired
    ItemRepositorio repositorio;

    @Given("^I have a plate that is composed by (\\w+) by price (\\d+)")
    public void i_have_user_and_password(String nome, String preco) throws Throwable {
        item.setCategoria("massa");
        item.setDescricao("nenhum");
        item.setMarca("YAQUISOBA");
        item.setNome(nome);
        item.setPreco(Float.parseFloat(preco));
        item.setQuantidade(1);
    }

    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;

    }

    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Item novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(item);
                result2 = Boolean.toString(repositorio.exists(novo.getIditem()));
                repositorio.delete(novo.getIditem());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(item);
                repositorio.delete(novo.getIditem());
                result2 = Boolean.toString(!repositorio.exists(novo.getIditem()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(item);
                result2 = Boolean.toString(repositorio.exists(novo.getIditem()));
                repositorio.delete(novo.getIditem());
                assertThat(result, is(result2));
                break;
                
            default:
                break;
        }
        
    }

}
