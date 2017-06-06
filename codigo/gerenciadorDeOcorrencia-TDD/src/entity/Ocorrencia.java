package entity;

import tipos.TipoOcorrencia;
import tipos.TipoPrioridade;
import tipos.TipoStatus;

public class Ocorrencia {

	private Long id;
	private String resumo;
	private Funcionario responsavel;
	private TipoPrioridade prioridade;
	private TipoOcorrencia tipoOcorrencia;
	private TipoStatus tipoStatus;

	public Ocorrencia(Long id, String resumo, TipoPrioridade prioridade, TipoOcorrencia tipoOcorrencia, TipoStatus tipoStatus) {
		this.id = id;
		this.resumo = resumo;
		this.prioridade = prioridade;
		this.tipoOcorrencia = tipoOcorrencia;
		this.tipoStatus = tipoStatus;
	}

	@Override
	public String toString() {
		return String.format("(%s) : %s", this.id, this.resumo);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ocorrencia) {
			return this.id.equals(((Ocorrencia) obj).id);
		}
		return false;
	}

	public Funcionario obterResponsavel() {
		return this.responsavel;
	}

	public TipoPrioridade obterPrioridade() {
		return this.prioridade;
	}

	public TipoOcorrencia obterTipoOcorrencia() {
		return this.tipoOcorrencia;
	}

	public TipoStatus getStatus() {
		return this.tipoStatus;
	}

	public void setResponsavel(Funcionario fabio) {
		this.responsavel = fabio;
	}
}
