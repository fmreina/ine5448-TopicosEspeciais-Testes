package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import entity.Gerenciador;
import entity.Projeto;

public class TetesCadastrarProjeto {

	@Test
	public void criaProjeto() throws Exception {
		Projeto projeto = new Projeto("ArquivoX");
		assertEquals("ArquivoX", projeto.getNome());
	}

	@Test
	public void gerenciadorHasListaProjetos() throws Exception {
		Gerenciador gerenciador = new Gerenciador();
		assertNotNull(gerenciador.getListaProjetos());
	}

	@Test
	public void addProjeto() throws Exception {
		Gerenciador gerenciador = new Gerenciador();
		gerenciador.addProject(new Projeto("Teste"));
		assertEquals(1, gerenciador.getListaProjetos().size());
	}
}
