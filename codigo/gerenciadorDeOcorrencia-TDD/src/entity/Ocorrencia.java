package entity;

import tipos.TipoOcorrencia;
import tipos.TipoPrioridade;

public class Ocorrencia {

	private Long id;
	private String resumo;
	private Funcionario responsavel;
	private TipoPrioridade prioridade;
	private TipoOcorrencia tipoOcorrencia;

	public Ocorrencia(Long id, String resumo, Funcionario responsavel, TipoPrioridade prioridade, TipoOcorrencia tipoOcorrencia) {
		this.id = id;
		this.resumo = resumo;
		this.responsavel = responsavel;
		this.prioridade = prioridade;
		this.tipoOcorrencia = tipoOcorrencia;
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
}
