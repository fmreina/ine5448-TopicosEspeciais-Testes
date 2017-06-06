package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import entity.Gerenciador;
import entity.Projeto;
import exception.EntidadeoComMesmoIdException;

public class TetesCadastrarProjeto {

	private Projeto arquivoX, arquivoX2, armaY;
	private Gerenciador gerenciador;

	@Before
	public void before() {
		this.arquivoX = new Projeto(1L, "ArquivoX");
		this.arquivoX2 = new Projeto(1L, "ArquivoX2");
		this.armaY = new Projeto(1L, "ArmaY");
		this.gerenciador = new Gerenciador();
	}

	@Test
	public void criaProjeto() throws Exception {
		assertEquals("ArquivoX, (1)", this.arquivoX.toString());
	}

	@Test
	public void igualdadeEntreProjetos() throws Exception {
		assertEquals(this.arquivoX, this.arquivoX2);
		assertEquals(this.arquivoX, this.armaY);
	}

	@Test
	public void gerenciadorHasListaProjetos() throws Exception {
		assertNotNull(this.gerenciador.getListaProjetos());
	}

	@Test
	public void gerenciadorSemProjeto() throws Exception {
		assertEquals(0, this.gerenciador.getListaFuncionarios().size());
	}

	@Test
	public void cadastrarProjeto() throws Exception {
		this.gerenciador.cadastrarProject(this.arquivoX);
		assertEquals(1, this.gerenciador.getListaProjetos().size());
	}

	@Test(expected = EntidadeoComMesmoIdException.class)
	public void cadastrarProjetoComMesmoId() throws Exception {
		this.gerenciador.cadastrarProject(this.arquivoX);
		this.gerenciador.cadastrarProject(this.armaY);
	}

	@Test
	public void projetoSemOcorrencias() throws Exception {
		assertEquals(0, this.arquivoX.obterOcorrencias().size());
	}

}
