package tipos;

public enum TipoOcorrencia {
	TAREFA("Tarefa"),
	BUG("Bug"),
	MELHORIA("Melhoria");

	private String nome;

	private TipoOcorrencia(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
