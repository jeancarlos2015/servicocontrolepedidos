package testesRepositorioPedidos;

import com.sistex.App;
import com.sistex.cdp.Pedido;
import com.sistex.cgd.PedidoRepositorio;
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
public class DefinitionsOperacaoPedido {
    
    private final Fabrica fabrica = Fabrica.make(Tipo.PEDIDO);
    private final Pedido pedido = fabrica.criaPedido();
    private String operacao;
    
    @Autowired
    PedidoRepositorio repositorio;
    
    @Given("^I have a pedido with preco (\\d+) and status (\\w+)")
    public void i_have_user_and_password(String preco, String status) throws Throwable {
        pedido.setDatapedido("10-10-2017");
        pedido.setPrecototal(Float.parseFloat(preco));
        pedido.setStatus(status);
    }
    
    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;
        
    }
    
    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Pedido novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(pedido);
                result2 = Boolean.toString(repositorio.exists(novo.getIdpedido()));
                repositorio.delete(novo.getIdpedido());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(pedido);
                repositorio.delete(novo.getIdpedido());
                result2 = Boolean.toString(!repositorio.exists(novo.getIdpedido()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(pedido);
                result2 = Boolean.toString(repositorio.exists(novo.getIdpedido()));
                repositorio.delete(novo.getIdpedido());
                assertThat(result, is(result2));
                break;
            
            default:
                break;
        }
        
    }
    
}
