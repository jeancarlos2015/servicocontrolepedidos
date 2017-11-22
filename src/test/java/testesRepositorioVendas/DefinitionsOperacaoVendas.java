package testesRepositorioVendas;

import com.sistex.App;
import com.sistex.cdp.Venda;
import com.sistex.cgd.VendaRepositorio;
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
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@SuppressWarnings("deprecation")
public class DefinitionsOperacaoVendas {

    private final Fabrica fabrica = Fabrica.make(Tipo.VENDA);
    private final Venda venda = fabrica.criaVenda();
    private String operacao;

    @Autowired
    VendaRepositorio repositorio;

    @Given("^sell (\\d+) for price (\\d+) of the (\\w+)")
    public void i_have_user_and_password(int qt, int preco, String nome) throws Throwable {
        venda.setPrecounidade(Float.parseFloat(""+preco));
        venda.setMarcaproduto(nome);
        venda.setNomeproduto(nome);
        venda.setQuantidade(Integer.parseInt(""+qt));
    }

    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;

    }

    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Venda novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(venda);
                result2 = Boolean.toString(repositorio.exists(novo.getIdvenda()));
                repositorio.delete(novo.getIdvenda());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(venda);
                repositorio.delete(venda.getIdvenda());
                result2 = Boolean.toString(!repositorio.exists(novo.getIdvenda()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(venda);
                result2 = Boolean.toString(repositorio.exists(novo.getIdvenda()));
                repositorio.delete(novo.getIdvenda());
                assertThat(result, is(result2));
                break;
                
            default:
                break;
        }
        
    }

}
