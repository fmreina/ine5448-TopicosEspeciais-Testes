package estoriatests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Entrada;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Saida;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

@FixtureSetup(TesteDeposito.class)
public class TesteSaque {

	@Fixture
	private Conta contaMaria;
	
	@Fixture
	private ValorMonetario valorZero;
	
	private Dinheiro seisReais;
	
	private Dinheiro quatroReais;
	
	private ValorMonetario valorQuatro;
	
	private Saida saque;
	
	@Before
	public void configurar(){
		seisReais = new Dinheiro(Moeda.BRL, 6, 0);
		quatroReais = new Dinheiro(Moeda.BRL, 4, 0);
		saque = new Saida(contaMaria, seisReais);
		contaMaria.adicionarTransacao(saque);
		valorQuatro = valorZero.somar(quatroReais);
	}
	
	@Test
	public void testeDeposito(){
		assertEquals(valorQuatro.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
	
}
