package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entity.FuncionarioExample;
import entity.GerenciadorExample;
import exception.ExcecaoFuncionarioComIdentificadorJaCadastrado;

public class TestesCadastroFuncionariosExample {

	GerenciadorExample gerenciador;

	@Before
	public void before() {
		this.gerenciador = new GerenciadorExample();

	}

	@Test
	public void semFuncionarioCadastrado() throws Exception {
		List<FuncionarioExample> funcionarios = this.gerenciador.obterFuncionarios();
		assertEquals(0, funcionarios.size());
	}

	@Test
	public void cadastrarFabio() throws Exception {
		FuncionarioExample fabio = new FuncionarioExample(1, "Fabio");

		this.gerenciador.cadastrarFuncionario(fabio);

		List<FuncionarioExample> funcionarios = this.gerenciador.obterFuncionarios();

		assertEquals(1, funcionarios.size());
		assertEquals(fabio, funcionarios.get(0));
	}

	@Test(expected = ExcecaoFuncionarioComIdentificadorJaCadastrado.class)
	public void cadastrarFuncionarioComMesmoId() throws Exception {
		FuncionarioExample fabio = new FuncionarioExample(1, "Fabio");
		FuncionarioExample luiz = new FuncionarioExample(1, "Luiz");

		this.gerenciador.cadastrarFuncionario(fabio);
		this.gerenciador.cadastrarFuncionario(luiz);

	}
}
