package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import entity.Funcionario;
import entity.Gerenciador;

public class TestesCadastrarFuncionario {

	@Test
	public void funcionarioFabio() throws Exception {
		Funcionario funcionario = new Funcionario("Fabio");
		assertEquals("Fabio", funcionario.getNome());
	}

	@Test
	public void funcionariaMaria() throws Exception {
		Funcionario funcionario = new Funcionario("Maria");
		assertEquals("Maria", funcionario.getNome());
	}

	@Test
	public void iniciarGerenciador() throws Exception {
		Gerenciador gerenciador = new Gerenciador();
		assertNotNull(gerenciador);
	}

	@Test
	public void gerenciadorHasListaFuncionario() throws Exception {
		Gerenciador gerenciador = new Gerenciador();
		assertNotNull(gerenciador.getListaFuncionarios());
	}

	@Test
	public void addFuncionario() throws Exception {
		Gerenciador gerenciador = new Gerenciador();
		gerenciador.addFuncionario(new Funcionario("Lucas"));
		assertEquals(1, gerenciador.getListaFuncionarios().size());
	}
}
