package acceptanceTests.cucumberSteps;

import java.util.Date;
import java.util.List;

import org.junit.Assert;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;
import modelo.FachadaMercadoLeilaoComSerializacao;
import modelo.ProdutoLeilao;

@StepDefAnnotation
@CucumberOptions(glue = "acceptanceTests.cucumberSteps", features = "AppLeilao/src/test/java/features/ValidarLance_Test.feature", monochrome = true)
public class ValidarLanceTest {

	private String nomeProduto = "";
	private Double lance = 0.0;
	private String cpfComprador = "";

	private Boolean expectedResult = true;

	private FachadaMercadoLeilaoComSerializacao fachada = new FachadaMercadoLeilaoComSerializacao();

	@Before
	public void steup() throws Exception {
		this.fachada.montarMercado();
		this.fachada.limparMercado();

		this.fachada.cadastrarUsuario("Fabio", "UFSC", "emal@email.com", "021.993.711-74");
		this.fachada.cadastrarProduto("cama de gato", "cama de gato velha", 100.00, "021.993.711-74", new Date("26/06/2017"));
	}

	@Given("^O produto \"([^\"]*)\"$")
	public void o_produto(String arg1) throws Throwable {
		this.nomeProduto = arg1;
	}

	@When("^o leiloador$")
	public void o_leiloador() throws Throwable {
		if (this.fachada.getUsuarioPor("021.993.711-74") != null) {
			// System.out.println("Usuário encontrado");
			this.expectedResult = true;
		} else {
			// System.out.println("Usuário não encontrado");
			this.expectedResult = false;
		}
	}

	@Given("^o cpf do comprados \"([^\"]*)\"$")
	public void o_cpf_do_comprados(String arg1) throws Throwable {
		this.cpfComprador = arg1;
	}

	@Given("^o lance \"([^\"]*)\"$")
	public void o_lance(String arg1) throws Throwable {
		this.lance = Double.valueOf(arg1);
	}

	@When("^O produto existir$")
	public void o_produto_existir() throws Throwable {
		this.expectedResult = this.fachada.verificaSeOProdutoJaExiste(this.nomeProduto);
	}

	@When("^o lance for maior que o valor minimo$")
	public void o_lance_for_maior_que_o_valor_minimo() throws Throwable {
		List<ProdutoLeilao> produtos = (List<ProdutoLeilao>) this.fachada.getProdutosEmLeilao();
		for (ProdutoLeilao p : produtos) {
			if (p.getNome().equals(this.nomeProduto)) {
				if (p.getLanceMinimo() < this.lance) {
					this.expectedResult = true;
					break;
				} else {
					this.expectedResult = false;
				}
			}
		}
	}

	@When("^o lance for maior que o anterior$")
	public void o_lance_for_maior_que_o_anterior() throws Throwable {
		List<ProdutoLeilao> produtos = (List<ProdutoLeilao>) this.fachada.getProdutosEmLeilao();
		for (ProdutoLeilao p : produtos) {
			if (p.getNome().equals(this.nomeProduto)) {
				if (p.getValorUltimoLance() < this.lance) {
					this.expectedResult = true;
					break;
				} else {
					this.expectedResult = false;
				}
			}
		}
	}

	@Then("^O sistema deve registrar o lance$")
	public void o_sistema_deve_registrar_o_lance() throws Throwable {
		Boolean registro = false;
		try {
			this.fachada.daLance(this.nomeProduto, this.cpfComprador, this.lance);
			registro = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(this.expectedResult, registro);
	}
}
