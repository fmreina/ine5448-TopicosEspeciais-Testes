package entity;

public class FuncionarioExample {

	private Integer identificador;
	private String nome;

	public FuncionarioExample(Integer id, String nome) {
		this.identificador = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format("%s, (%s)", this.nome, this.identificador.toString());
	}

	@Override
	public boolean equals(Object objeto) {
		// Decisão de projeto: commparação feita apenas pelo identificador do funcionário.
		if (objeto instanceof FuncionarioExample) {
			FuncionarioExample funcionario = (FuncionarioExample) objeto;
			return this.identificador.equals(funcionario.identificador);
		}
		return false;
	}
}
