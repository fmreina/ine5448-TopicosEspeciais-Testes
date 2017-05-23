package tests;

import static org.junit.Assert.assertEquals;

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

	// TODO:
	// trabalha em uma occorencia
	// trabalha em 10 ou menos ocorrencias
}
