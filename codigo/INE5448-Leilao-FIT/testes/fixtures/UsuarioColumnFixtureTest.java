package fixtures;

import fit.ColumnFixture;
import modelo.FachadaMercadoLeilaoComSerializacao;

public class UsuarioColumnFixtureTest extends ColumnFixture {

	public String nome;
	public String endereco;
	public String email;
	public String cpf;

	FachadaMercadoLeilaoComSerializacao fachada = new FachadaMercadoLeilaoComSerializacao();

	public UsuarioColumnFixtureTest() {
		super();
	}

	public Boolean cadastrarUsuario() {
		try {
			this.fachada.cadastrarUsuario(this.nome, this.endereco, this.email, this.cpf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean verificarUsuarioExiste() {
		try {
			this.fachada.getUsuarioPor(this.cpf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void clear() {
		this.fachada.limparMercado();
	}
}
