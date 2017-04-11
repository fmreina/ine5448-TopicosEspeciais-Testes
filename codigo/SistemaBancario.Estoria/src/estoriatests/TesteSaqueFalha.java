package estoriatests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Saida;
import br.ufsc.ine.leb.sistemaBancario.TransacaoNaoRealizada;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

@FixtureSetup(TesteSaque.class)
public class TesteSaqueFalha {

	@Fixture
	private Conta contaMaria;
	
	@Fixture
	private Dinheiro seisReais;
	
	@Fixture
	private ValorMonetario valorQuatro;

	private TransacaoNaoRealizada trans;
	
	@Before
	public void configurar(){
		trans = new TransacaoNaoRealizada(new Saida(contaMaria, seisReais));
	}
	
	@Test
	public void testeDeposito(){
		assertEquals(valorQuatro.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
}
