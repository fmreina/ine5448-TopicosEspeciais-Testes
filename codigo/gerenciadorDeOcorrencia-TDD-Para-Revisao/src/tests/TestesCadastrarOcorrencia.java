package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import entity.Gerenciador;
import entity.Ocorrencia;
import exception.EntidadeoComMesmoIdException;
import tipos.TipoOcorrencia;
import tipos.TipoPrioridade;
import tipos.TipoStatus;

public class TestesCadastrarOcorrencia {

	private Gerenciador gerenciador;
	private Ocorrencia ocorrencia1, ocorrencia2;

	@Before
	public void before() {
		this.gerenciador = new Gerenciador();
		this.ocorrencia1 = new Ocorrencia(1L, "Resumo 1", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA);
		this.ocorrencia2 = new Ocorrencia(1L, "Resumo 2", TipoPrioridade.MEDIA, TipoOcorrencia.BUG, TipoStatus.ABERTA);
	}

	@Test
	public void temListaDeOcorrencias() throws Exception {
		assertNotNull(this.gerenciador.getListaOcorrencias());
	}

	@Test
	public void gerenciadorSemOcorrencias() throws Exception {
		assertEquals(0, this.gerenciador.getListaOcorrencias().size());
	}

	@Test
	public void cadastrarOcorrencia() throws Exception {
		this.gerenciador.cadastrarOcorrencia(this.ocorrencia1);
		assertEquals(1, this.gerenciador.getListaOcorrencias().size());
	}

	@Test(expected = EntidadeoComMesmoIdException.class)
	public void cadastrarOcorrenciaComMesmoId() throws Exception {
		this.gerenciador.cadastrarOcorrencia(this.ocorrencia1);
		this.gerenciador.cadastrarOcorrencia(this.ocorrencia2);
	}

}
