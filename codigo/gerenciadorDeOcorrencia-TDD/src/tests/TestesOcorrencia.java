package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entity.Funcionario;
import entity.Ocorrencia;
import tipos.TipoOcorrencia;
import tipos.TipoPrioridade;

public class TestesOcorrencia {

	private Ocorrencia ocorrencia1, ocorrencia2, ocorrencia3;
	private Funcionario fabio;

	@Before
	public void before() {
		this.fabio = new Funcionario(1L, "Fabio");
		this.ocorrencia1 = new Ocorrencia(1L, "Resumo 1", this.fabio, TipoPrioridade.ALTA, TipoOcorrencia.TAREFA);
		this.ocorrencia2 = new Ocorrencia(1L, "Resumo 2", this.fabio, TipoPrioridade.MEDIA, TipoOcorrencia.BUG);
		this.ocorrencia3 = new Ocorrencia(3L, "Resumo 3", this.fabio, TipoPrioridade.BAIXA, TipoOcorrencia.MELHORIA);
	}

	@Test
	public void novaOcorrencia() throws Exception {
		assertEquals("(1) : Resumo 1", this.ocorrencia1.toString());
	}

	@Test
	public void igualdadeEntreOcorrencias() throws Exception {
		assertEquals(this.ocorrencia1, this.ocorrencia2);
	}

	@Test
	public void temResponsavel() throws Exception {
		assertEquals(this.fabio, this.ocorrencia1.obterResponsavel());
	}

	@Test
	public void prioridadeAlta() throws Exception {
		assertEquals("Alta", this.ocorrencia1.obterPrioridade().toString());
	}

	@Test
	public void prioridadeMedia() throws Exception {
		assertEquals("Media", this.ocorrencia2.obterPrioridade().toString());
	}

	@Test
	public void prioridadeBaixa() throws Exception {
		assertEquals("Baixa", this.ocorrencia3.obterPrioridade().toString());
	}

	@Test
	public void tipoTarefa() throws Exception {
		assertEquals("Tarefa", this.ocorrencia1.obterTipoOcorrencia().toString());
	}

	@Test
	public void tipoBug() throws Exception {
		assertEquals("Bug", this.ocorrencia2.obterTipoOcorrencia().toString());
	}

	@Test
	public void tipomelhoria() throws Exception {
		assertEquals("Melhoria", this.ocorrencia3.obterTipoOcorrencia().toString());
	}
}
