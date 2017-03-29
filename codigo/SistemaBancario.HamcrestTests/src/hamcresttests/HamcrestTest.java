package hamcresttests;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class HamcrestTest {

	@Test
	public void comparaContaIgual() throws Exception {
		// configuração
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");

		// exercício
		Conta contaMaria = bbCentro.criarConta("Maria");
		Conta contaJoao = bbCentro.criarConta("João");
		
		// verificação
		assertThat(contaMaria, new ContaMatcher(contaMaria.obterIdentificador(), contaMaria.obterTitular(),
				contaMaria.obterAgencia().obterBanco().obterNome(), contaMaria.obterAgencia().obterNome()));
		
		// finalização
	}

	@Test
	public void comparaContaDiferente() throws Exception {
		// configuração
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");

		// exercício
		Conta contaMaria = bbCentro.criarConta("Maria");
		Conta contaJoao = bbCentro.criarConta("João");
		
		// verificação
		assertThat(contaMaria, not(new ContaMatcher(contaJoao.obterIdentificador(), contaJoao.obterTitular(),
				contaJoao.obterAgencia().obterBanco().obterNome(), contaJoao.obterAgencia().obterNome())));
		
		// finalização
	}
}
