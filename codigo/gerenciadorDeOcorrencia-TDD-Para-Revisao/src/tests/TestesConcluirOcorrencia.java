package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entity.Gerenciador;
import entity.Ocorrencia;
import tipos.TipoOcorrencia;
import tipos.TipoPrioridade;
import tipos.TipoStatus;

public class TestesConcluirOcorrencia {

	private Gerenciador gerenciador;
	private Ocorrencia ocorrencia;

	@Before
	public void before() {
		this.gerenciador = new Gerenciador();
		this.ocorrencia = new Ocorrencia(1L, "Resumo 1", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA);
	}

	@Test
	public void concluirOcorrencia() throws Exception {
		this.gerenciador.concluirOcorrencia(this.ocorrencia);
		assertEquals(TipoStatus.FECHADA, this.ocorrencia.getStatus());
	}
}
