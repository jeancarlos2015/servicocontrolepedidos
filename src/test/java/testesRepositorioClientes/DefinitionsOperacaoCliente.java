package testesRepositorioClientes;



import com.sistex.App;
import com.sistex.cdp.Cliente;
import com.sistex.cgd.ClienteRepositorio;
import com.sistex.util.Fabrica;
import com.sistex.util.Tipo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@SuppressWarnings("deprecation")
public class DefinitionsOperacaoCliente {

    private final Fabrica fabrica = Fabrica.make(Tipo.CLIENTE);
    private final Cliente cliente = fabrica.criaCliente();
    private String operacao;

    @Autowired
    ClienteRepositorio repositorio;

    @Given("^I have a cliente with name (\\w+) and cpf (\\d+)")
    public void i_have_user_and_password(String nome, String cpf) throws Throwable {
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setDatanascimento("10-10-1971");
        cliente.setEmail(nome + "@gmail.com");
        cliente.setEndereco("Rua Almeida 288");
        cliente.setTelefone("3344-4433");
    }

    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;

    }

    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Cliente novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(cliente);
                result2 = Boolean.toString(repositorio.exists(novo.getIdcliente()));
                repositorio.delete(novo.getIdcliente());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(cliente);
                repositorio.delete(novo.getIdcliente());
                result2 = Boolean.toString(!repositorio.exists(novo.getIdcliente()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(cliente);
                result2 = Boolean.toString(repositorio.exists(novo.getIdcliente()));
                repositorio.delete(novo.getIdcliente());
                assertThat(result, is(result2));
                break;
                
            default:
                break;
        }
        
    }

}
