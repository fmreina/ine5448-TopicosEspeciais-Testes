package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import entity.Funcionario;

public class TestesFuncionario {

	private Funcionario fabio;

	@Before
	public void before() {
		this.fabio = new Funcionario(1L, "Fabio");
	}

	@Test
	public void funcionarioTrabalhaEmZeroOcorrencia() throws Exception {
		assertEquals(0, this.fabio.obterOcorrenciasEmExecucao().size());
	}

	@Test
	public void funcionarioTemListaDeOcorrencias() throws Exception {
		assertNotNull(this.fabio.getListaOcorrencias());
	}

	@Test
	public void trabalheEmZeroOcorrencias() throws Exception {
		assertEquals(0, this.fabio.getListaOcorrencias().size());
	}

}
