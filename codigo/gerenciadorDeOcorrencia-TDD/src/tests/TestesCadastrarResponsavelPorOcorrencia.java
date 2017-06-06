package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entity.Funcionario;
import entity.Gerenciador;
import entity.Ocorrencia;
import exception.EntidadeoComMesmoIdException;
import exception.TamanhoMaximoExcedidoException;
import tipos.TipoOcorrencia;
import tipos.TipoPrioridade;
import tipos.TipoStatus;

public class TestesCadastrarResponsavelPorOcorrencia {

	private Gerenciador gerenciador;
	private Funcionario fabio, luana;
	private Ocorrencia ocorrencia1;

	@Before
	public void before() {
		this.fabio = new Funcionario(1L, "Fabio");
		this.luana = new Funcionario(2L, "Luana");
		this.gerenciador = new Gerenciador();
		this.ocorrencia1 = new Ocorrencia(1L, "Resumo 1", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA);
	}

	@Test
	public void cadastrarResponsavelPorOcorrencia() throws Exception {
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, this.ocorrencia1);
		assertEquals(this.fabio, this.ocorrencia1.obterResponsavel());
		assertTrue(this.fabio.getListaOcorrencias().contains(this.ocorrencia1));
		assertEquals(1, this.fabio.getListaOcorrencias().size());
	}

	@Test
	public void alterarResponsavel() throws Exception {
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, this.ocorrencia1);
		this.gerenciador.alteraResponsavelOcorrencia(this.fabio, this.luana, this.ocorrencia1);

		assertEquals(this.luana, this.ocorrencia1.obterResponsavel());
		assertTrue(this.luana.getListaOcorrencias().contains(this.ocorrencia1));
		assertEquals(1, this.luana.getListaOcorrencias().size());

		assertNotEquals(this.fabio, this.ocorrencia1.obterResponsavel());
		assertFalse(this.fabio.getListaOcorrencias().contains(this.ocorrencia1));
		assertEquals(0, this.fabio.getListaOcorrencias().size());
	}

	@Test(expected = EntidadeoComMesmoIdException.class)
	public void atribuirMesmaOcorrenciaAoFuncionario() throws Exception {
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, this.ocorrencia1);
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, this.ocorrencia1);
	}

	@Test
	public void trabalheEmDezOcorrencias() throws Exception {
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(1L, "Resumo 1", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(2L, "Resumo 2", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(3L, "Resumo 3", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(4L, "Resumo 4", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(5L, "Resumo 5", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(6L, "Resumo 6", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(7L, "Resumo 7", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(8L, "Resumo 8", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(9L, "Resumo 9", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(10L, "Resumo 10", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		assertEquals(10, this.fabio.getListaOcorrencias().size());
	}

	@Test(expected = TamanhoMaximoExcedidoException.class)
	public void trabalheEmNoMaximoDezOcorrencias() throws Exception {
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(1L, "Resumo 1", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(2L, "Resumo 2", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(3L, "Resumo 3", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(4L, "Resumo 4", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(5L, "Resumo 5", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(6L, "Resumo 6", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(7L, "Resumo 7", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(8L, "Resumo 8", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(9L, "Resumo 9", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(10L, "Resumo 10", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
		this.gerenciador.cadastrarResponsavelPorOcorrencia(this.fabio, new Ocorrencia(11L, "Resumo 11", TipoPrioridade.ALTA, TipoOcorrencia.TAREFA, TipoStatus.ABERTA));
	}
}
