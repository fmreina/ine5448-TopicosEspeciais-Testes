package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entity.Funcionario;
import entity.Gerenciador;
import entity.Ocorrencia;
import tipos.TipoOcorrencia;
import tipos.TipoPrioridade;
import tipos.TipoStatus;

public class TestesCadastrarResponsavelPorOcorrencia {

	private Gerenciador gerenciador;
	private Funcionario fabio;
	private Ocorrencia ocorrencia1, ocorrencia2;

	@Before
	public void before() {
		this.fabio = new Funcionario(1L, "Fabio");
		this.gerenciador = new Gerenciador();
		this.ocorrencia1 = new Ocorrencia(1L, "Resumo 1", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA);
		this.ocorrencia2 = new Ocorrencia(1L, "Resumo 2", TipoPrioridade.MEDIA, TipoOcorrencia.BUG, TipoStatus.ABERTA);
	}

	@Test
	public void cadastrarResponsavelPorOcorrencia() throws Exception {
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, this.ocorrencia1);
		assertEquals(this.fabio, this.ocorrencia1.obterResponsavel());
		assertTrue(this.fabio.getListaOcorrencias().contains(this.ocorrencia1));
	}

	// @Test
	// public void trabalheEmUmaOcorrencias() throws Exception {
	// assertEquals(1, this.fabio.getListaOcorrencias().size());
	// }
	//
	// @Test
	// public void trabalheEmDezOcorrencias() throws Exception {
	// assertEquals(10, this.fabio.getListaOcorrencias().size());
	// }
	//
	// @Test
	// public void trabalheEmNoMaximoDezOcorrencias() throws Exception {
	// assertTrue(this.fabio.getListaOcorrencias().size() <= 10);
	// }
}
