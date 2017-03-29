package hamcresttests;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;

public class ContaMatcher extends BaseMatcher<Conta> implements Matcher<Conta>{

	private String identificador, titular, nomeBanco, nomeAgencia;
	// private Banco banco;
	// private Agencia agencia;
	
	public ContaMatcher(String identificador, String titular, String banco, String agencia) {
		this.identificador = identificador;
		this.titular = titular;
		this.nomeBanco = banco;
		this.nomeAgencia = agencia;
	}
	
	
	@Override
	public boolean matches(Object conta) {
		if(conta != null && conta instanceof Conta){
			Conta outra = (Conta) conta;
			//formatter:off
			return outra.obterIdentificador().equals(this.identificador)
					&& outra.obterTitular().equals(this.titular)
					&& outra.obterAgencia().obterNome().equals(this.nomeAgencia)
					&& outra.obterAgencia().obterBanco().obterNome().equals(this.nomeBanco);
			//formatter:on		
		}
		return false;
	}
	
	@Override
	public void describeTo(Description descricao) {
		descricao.appendText("Conta de Identificador: ");
		descricao.appendValue(identificador);
		descricao.appendText(" e Titular: ");
		descricao.appendValue(titular);
		descricao.appendText(" e Agência: ");
		descricao.appendValue(nomeAgencia);
		descricao.appendText(" e Banco: ");
		descricao.appendValue(nomeBanco);
	}
	
	@Override
	public void describeMismatch(Object item, Description descricao) {
		if( item != null && item instanceof Conta ){
			Conta outra = (Conta) item;
			descricao.appendText("Conta de Identificador: ");
			descricao.appendValue(outra.obterIdentificador());
			descricao.appendText(" e Titular: ");
			descricao.appendValue(outra.obterTitular());
			descricao.appendText(" e Agência: ");
			descricao.appendValue(outra.obterAgencia().obterNome());
			descricao.appendText(" e Banco: ");
			descricao.appendValue(outra.obterAgencia().obterBanco().obterNome());
		} else {
			super.describeMismatch(item, descricao);
		}
	}
	
}
