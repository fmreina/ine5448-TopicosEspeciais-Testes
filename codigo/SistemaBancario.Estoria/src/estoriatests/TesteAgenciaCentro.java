package estoriatests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;

@FixtureSetup(TesteBancoBB.class)
public class TesteAgenciaCentro {

	@Fixture 
	private Banco bancoDoBrasil;
	
	private Agencia agenciaCentro;
	
	@Before
	public void configurar(){
		agenciaCentro = bancoDoBrasil.criarAgencia("Centro");
	}
	
	@Test
	public void testeBancoDoBrasil(){
		assertEquals("001", agenciaCentro.obterIdentificador());
		assertEquals("Centro", agenciaCentro.obterNome());
		assertEquals("Banco do Brasil", agenciaCentro.obterBanco().obterNome());
	}

}
