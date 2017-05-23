package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import entity.Funcionario;
import entity.Gerenciador;
import exception.funcionarioComMesmoIdException;

public class TestesCadastrarFuncionario {

	private Funcionario fabio, fabio2, maria;
	private Gerenciador gerenciador;

	@Before
	public void before() {
		this.fabio = new Funcionario(1L, "Fabio");
		this.fabio2 = new Funcionario(1L, "Fabio2");
		this.maria = new Funcionario(1L, "Maria");
		this.gerenciador = new Gerenciador();
	}

	@Test
	public void funcionarioFabio() throws Exception {
		assertEquals("Fabio, (1)", this.fabio.toString());
	}

	// teste repetido. funcionarioFabio() já verifica esta funcionalidade.
	@Test
	public void funcionariaMaria() throws Exception {
		assertEquals("Maria, (1)", this.maria.toString());
	}

	@Test
	public void igualdadeEntreFuncionarios() throws Exception {
		assertEquals(this.fabio, this.fabio2);
		assertEquals(this.fabio, this.maria);
	}

	@Test
	public void iniciarGerenciador() throws Exception {
		assertNotNull(this.gerenciador);
	}

	@Test
	public void gerenciadorTemListaFuncionario() throws Exception {
		assertNotNull(this.gerenciador.getListaFuncionarios());
	}

	// teste semelhante ao gerenciadorTemListaFuncionario()
	@Test
	public void gerenciadorSemFuncionarios() throws Exception {
		assertEquals(0, this.gerenciador.getListaFuncionarios().size());
	}

	@Test
	public void cadastraFuncionario() throws Exception {
		this.gerenciador.cadastrarFuncionario(new Funcionario(1L, "Lucas"));
		assertEquals(1, this.gerenciador.getListaFuncionarios().size());
	}

	@Test(expected = funcionarioComMesmoIdException.class)
	public void cadastrarFuncionarioComMesmoId() throws Exception {
		this.gerenciador.cadastrarFuncionario(this.fabio);
		this.gerenciador.cadastrarFuncionario(this.fabio2);
	}
}
