package tipos;

public enum TipoPrioridade {

	ALTA("Alta"),
	MEDIA("Media"),
	BAIXA("Baixa");

	private String nome;

	private TipoPrioridade(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
