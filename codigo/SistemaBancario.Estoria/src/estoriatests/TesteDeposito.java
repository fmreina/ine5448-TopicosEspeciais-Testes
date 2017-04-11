package estoriatests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Entrada;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

@FixtureSetup(TesteContaMaria.class)
public class TesteDeposito {

	@Fixture
	private Conta contaMaria;
	
	@Fixture
	private ValorMonetario valorZero;
	
	private Dinheiro dezReais;
	
	private Entrada deposito;
	
	@Before
	public void configurar(){
		dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		deposito = new Entrada(contaMaria, dezReais);
		contaMaria.adicionarTransacao(deposito);
	}
	
	@Test
	public void testeDeposito(){
		assertNotEquals(valorZero.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
	
}
