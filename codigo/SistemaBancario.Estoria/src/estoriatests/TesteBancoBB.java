package estoriatests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.*;

public class TesteBancoBB {

	private Banco bancoDoBrasil;

	@Before
	public void configurar(){
		SistemaBancario sis = new SistemaBancario();
		bancoDoBrasil = sis.criarBanco("Banco do Brasil", Moeda.BRL);
	}
	
	@Test
	public void testeBancoDoBrasil(){
		assertEquals("Banco do Brasil", bancoDoBrasil.obterNome());
		assertEquals(Moeda.BRL, bancoDoBrasil.obterMoeda());
	}
}
