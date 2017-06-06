package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entity.FuncionarioExample;

public class TestesFuncionarioExample {

	@Test
	public void fabio() throws Exception {
		FuncionarioExample fabio = new FuncionarioExample(1, "Fabio");
		assertEquals("Fabio, (1)", fabio.toString());
	}

	@Test
	public void igualdade() throws Exception {
		FuncionarioExample fabio1 = new FuncionarioExample(1, "Fabio");
		FuncionarioExample fabio2 = new FuncionarioExample(1, "Fabio2");
		FuncionarioExample luiz = new FuncionarioExample(1, "Luiz");

		assertEquals(fabio1, fabio2);
		assertEquals(fabio1, luiz);
	}

}
