package tipos;

public enum TipoStatus {

	ABERTA("Aberta"),
	FECHADA("Fechada");

	private String status;

	private TipoStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return this.status;
	}
}
