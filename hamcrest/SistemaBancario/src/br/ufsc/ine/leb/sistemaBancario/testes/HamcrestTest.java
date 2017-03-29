package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import javax.naming.InvalidNameException;

import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Entrada;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Saida;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.Transacao;
import br.ufsc.ine.leb.sistemaBancario.TransacaoNaoRealizada;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class HamcrestTest {

	@Test
	public void comparaConta() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");

		Conta contaMaria = bbCentro.criarConta("Maria");
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);

		assertEquals("0001-5", contaMaria.obterIdentificador());
		assertEquals("Maria", contaMaria.obterTitular());
		assertEquals(zero, contaMaria.calcularSaldo());
		assertEquals(bbCentro, contaMaria.obterAgencia());
	}
	
}
