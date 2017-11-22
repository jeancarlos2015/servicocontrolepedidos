package testesRepositorioProduto;



import com.sistex.App;
import com.sistex.cdp.Produto;
import com.sistex.cgd.ProdutoRepositorio;
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
public class DefinitionsOperacaoProduto {

    private final Fabrica fabrica = Fabrica.make(Tipo.PRODUTO);
    private final Produto produto = fabrica.criaProduto();
    private String operacao;

    @Autowired
    ProdutoRepositorio repositorio;

    @Given("^I have (\\d+) by (\\d+) by unit of the product (\\w+)")
    public void i_have_user_and_password(String quantidade, String preco, String nome) throws Throwable {
       produto.setDescricao("Teste");
       produto.setImageStr("teste");
       produto.setNome(nome);
       produto.setPreco(Float.parseFloat(""+preco));
       produto.setQuantidade(Integer.parseInt(""+quantidade));
    }

    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;

    }

    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Produto novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(produto);
                result2 = Boolean.toString(repositorio.exists(novo.getIdproduto()));
                repositorio.delete(novo.getIdproduto());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(produto);
                repositorio.delete(novo.getIdproduto());
                result2 = Boolean.toString(!repositorio.exists(novo.getIdproduto()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(produto);
                result2 = Boolean.toString(repositorio.exists(novo.getIdproduto()));
                repositorio.delete(novo.getIdproduto());
                assertThat(result, is(result2));
                break;
                
            default:
                break;
        }
        
    }

}
