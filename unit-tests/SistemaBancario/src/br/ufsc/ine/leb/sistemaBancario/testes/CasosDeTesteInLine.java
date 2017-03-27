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

public class CasosDeTesteInLine {

	// caso de teste 1
	@Test
	public void bancoDoBrasil() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		
		assertEquals("Banco do Brasil", bb.obterNome());
		assertEquals(Moeda.BRL, bb.obterMoeda());
	}
	
	@Test 
	public void bancoDoBrasilErro() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		
		assertNotEquals("Banco Brasil", bb.obterNome());
		assertNotEquals(Moeda.USD, bb.obterMoeda());
	}
	
	// caso de teste 2
	@Test
	public void agenciaCetro() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		
		Agencia bbCentro = bb.criarAgencia("Centro");
		
		assertEquals("001", bbCentro.obterIdentificador());
		assertEquals("Centro", bbCentro.obterNome());
		assertEquals("Banco do Brasil", bbCentro.obterBanco().obterNome());
	}
	
	@Test
	public void agenciaCetroErro() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		
		Agencia bbCentro = bb.criarAgencia("Centro");
		
		assertNotEquals("002", bbCentro.obterIdentificador());
		assertNotEquals("Trindade", bbCentro.obterNome());
		assertNotEquals("Banco Brasil", bbCentro.obterBanco().obterNome());
	}
	
	// caso de teste 3
	@Test
	public void contaMaria() throws Exception {
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
	
	@Test
	public void contaMariaErro() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");
		
		Conta contaMaria = bbCentro.criarConta("Maria");
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		
		assertNotEquals("0001-6", contaMaria.obterIdentificador());
		assertNotEquals("Mario", contaMaria.obterTitular());
		assertNotEquals(zero.somar(new Dinheiro(Moeda.BRL, 5, 0)), contaMaria.calcularSaldo());
		assertNotEquals(bb.criarAgencia("Blah"), contaMaria.obterAgencia());
	}
	
	// caso de teste 4
	@Test
	public void saldoAposDepositoSucesso() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");
		Conta contaMaria = bbCentro.criarConta("Maria");
		
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Entrada deposito = new Entrada(contaMaria, dezReais);
		contaMaria.adicionarTransacao(deposito);
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		ValorMonetario dez = zero.somar(dezReais);
		
		// assertEquals("+10,00 BRL", contaMaria.calcularSaldo().formatado());
		assertEquals(dez.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
	
	@Test
	public void saldoAposDepositoSucessoErro() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");
		Conta contaMaria = bbCentro.criarConta("Maria");
		
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Entrada deposito = new Entrada(contaMaria, dezReais);
		contaMaria.adicionarTransacao(deposito);
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		
		assertNotEquals(zero.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
	
	// caso de teste 5
	@Test
	public void saqueSucesso() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");
		Conta contaMaria = bbCentro.criarConta("Maria");
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Entrada deposito = new Entrada(contaMaria, dezReais);
		contaMaria.adicionarTransacao(deposito);
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		
		Dinheiro seisReais = new Dinheiro(Moeda.BRL, 6, 0);
		Saida saque = new Saida(contaMaria, seisReais);
		contaMaria.adicionarTransacao(saque);
		Dinheiro quatroReais = new Dinheiro(Moeda.BRL, 4, 0);
		ValorMonetario quatro = zero.somar(quatroReais);
		
		// assertEquals("+4,00 BRL", contaMaria.calcularSaldo().formatado());
		assertEquals(quatro.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
	
	@Test
	public void saqueSucessoErro() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");
		Conta contaMaria = bbCentro.criarConta("Maria");
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Entrada deposito = new Entrada(contaMaria, dezReais);
		contaMaria.adicionarTransacao(deposito);
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		
		Dinheiro seisReais = new Dinheiro(Moeda.BRL, 6, 0);
		Saida saque = new Saida(contaMaria, seisReais);
		contaMaria.adicionarTransacao(saque);
		Dinheiro quatroReais = new Dinheiro(Moeda.BRL, 4, 0);
		ValorMonetario quatro = zero.somar(quatroReais);
		
		assertNotEquals(zero.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
	
	// caso de teste 6
	@Test
	public void saqueFalha() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");
		Conta contaMaria = bbCentro.criarConta("Maria");
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		Dinheiro seisReais = new Dinheiro(Moeda.BRL, 6, 0);
		Dinheiro quatroReais = new Dinheiro(Moeda.BRL, 4, 0);
		ValorMonetario quatro = zero.somar(quatroReais);
		Entrada deposito = new Entrada(contaMaria, quatroReais);
		contaMaria.adicionarTransacao(deposito);
		
		TransacaoNaoRealizada trans = new TransacaoNaoRealizada(new Saida(contaMaria, seisReais));
		contaMaria.adicionarTransacao(trans);
		
		// assertEquals("+4,00 BRL", contaMaria.calcularSaldo().formatado());
		assertEquals(quatro.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
	
	@Test
	public void saqueFalhaErro() throws Exception {
		SistemaBancario sis = new SistemaBancario();
		Banco bb = sis.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");
		Conta contaMaria = bbCentro.criarConta("Maria");
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		Dinheiro seisReais = new Dinheiro(Moeda.BRL, 6, 0);
		Dinheiro quatroReais = new Dinheiro(Moeda.BRL, 4, 0);
		ValorMonetario quatro = zero.somar(quatroReais);
		Entrada deposito = new Entrada(contaMaria, quatroReais);
		contaMaria.adicionarTransacao(deposito);
		
		TransacaoNaoRealizada trans = new TransacaoNaoRealizada(new Saida(contaMaria, seisReais));
		contaMaria.adicionarTransacao(trans);
		
		assertNotEquals(zero.obterQuantia().formatado(), contaMaria.calcularSaldo().obterQuantia().formatado());
	}
}
