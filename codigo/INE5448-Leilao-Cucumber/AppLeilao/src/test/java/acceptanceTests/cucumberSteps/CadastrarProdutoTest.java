package acceptanceTests.cucumberSteps;

import java.util.Date;

import org.junit.Assert;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;
import modelo.FachadaMercadoLeilaoComSerializacao;

@StepDefAnnotation
@CucumberOptions(glue = "acceptanceTests.cucumberSteps", features = "AppLeilao/src/test/java/features/CadastrarProduto_Test.feature", monochrome = true)
public class CadastrarProdutoTest {

	private String nome = "";
	private String descricao = "";
	// private String lanceMinimo = "";
	private Double lanceMinimo = 0.0;
	private String cpfLeiloador = "";
	// private String dataLimite = "";
	private Date dataLimite;
	private Boolean expectedResult = true;

	private FachadaMercadoLeilaoComSerializacao fachada = new FachadaMercadoLeilaoComSerializacao();

	@Before
	public void steup() throws Exception {
		this.fachada.montarMercado();
		this.fachada.limparMercado();

		this.fachada.cadastrarUsuario("Fabio", "UFSC", "emal@email.com", "021.993.711-74");
	}

	@Given("^O nome do produto \"([^\"]*)\"$")
	public void o_nome_do_produto(String arg1) throws Throwable {
		this.nome = arg1;
	}

	@Given("^a descricao do produto \"([^\"]*)\"$")
	public void a_descricao_do_produto(String arg1) throws Throwable {
		this.descricao = arg1;
	}

	@Given("^o lance minimo \"([^\"]*)\"$")
	public void o_lance_minimo(String arg1) throws Throwable {
		// this.lanceMinimo = arg1;
		this.lanceMinimo = Double.valueOf(arg1);
	}

	@Given("^o cpf do leiloador \"([^\"]*)\"$")
	public void o_cpf_do_leiloador(String arg1) throws Throwable {
		this.cpfLeiloador = arg1;
	}

	@Given("^a data limite \"([^\"]*)\"$")
	public void a_data_limite(String arg1) throws Throwable {
		// this.dataLimite = arg1;
		this.dataLimite = new Date(arg1);
	}

	@When("^O produto nao existir anteriormente$")
	public void o_produto_nao_existir_anteriormente() throws Throwable {
		if (this.fachada.verificaSeOProdutoJaExiste(this.nome)) {
			// System.out.println("Produto já existe");
			this.expectedResult = false;
		} else {
			// System.out.println("Produto ainda não existe");
			this.expectedResult = true;
		}
	}

	@When("^o leiloador existir$")
	public void o_leiloador_existir() throws Throwable {
		if (this.fachada.getUsuarioPor("021.993.711-74") != null) {
			// System.out.println("Usuário encontrado");
			this.expectedResult = true;
		} else {
			// System.out.println("Usuário não encontrado");
			this.expectedResult = false;
		}
	}

	@Then("^O sistema deve cadastrar o produto com sucesso$")
	public void o_sistema_deve_cadastrar_o_produto_com_sucesso() throws Throwable {
		Boolean cadastro = false;
		try {
			this.fachada.cadastrarProduto(this.nome, this.descricao, this.lanceMinimo, this.cpfLeiloador, this.dataLimite);
			cadastro = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(this.expectedResult, cadastro);
	}

}
