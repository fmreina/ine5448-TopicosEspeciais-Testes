package fixtures;

import java.util.Date;

import fit.ColumnFixture;
import modelo.FachadaMercadoLeilaoComSerializacao;

public class ProdutoColumnFixtureTest extends ColumnFixture {

	private String nome;
	private String descricao;
	private Double lanceMinimo;
	private String cpfLeiloador;
	private Date dataLimite;

	FachadaMercadoLeilaoComSerializacao fachada = new FachadaMercadoLeilaoComSerializacao();

	public ProdutoColumnFixtureTest() {
		super();
	}

	public Boolean cadastrarProduto() {
		try {
			this.fachada.cadastrarProduto(this.nome, this.descricao, this.lanceMinimo, this.cpfLeiloador, this.dataLimite);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return false;
		}
	}

	public Boolean verificarProdutoExiste() {
		return this.fachada.verificaSeOProdutoJaExiste(this.nome);
	}

	public Boolean temUsuario() {
		try {
			this.fachada.retornaProdutosDeUmLeiloador(this.cpfLeiloador);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return false;
		}
	}
}
