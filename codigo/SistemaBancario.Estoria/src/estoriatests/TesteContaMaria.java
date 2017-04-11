package estoriatests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

@FixtureSetup(TesteAgenciaCentro.class)
public class TesteContaMaria {

	@Fixture
	private Agencia agenciaCentro;
	
	private Conta contaMaria;
	
	private ValorMonetario valorZero;
	
	@Before
	public void configurar(){
		contaMaria = agenciaCentro.criarConta("Maria");
		valorZero = new ValorMonetario(Moeda.BRL);
	}
	
	@Test
	public void testeContaMaria(){
		assertEquals("0001-5", contaMaria.obterIdentificador());
		assertEquals("Maria", contaMaria.obterTitular());
		assertEquals(valorZero, contaMaria.calcularSaldo());
		assertEquals(agenciaCentro, contaMaria.obterAgencia());
	}
}
