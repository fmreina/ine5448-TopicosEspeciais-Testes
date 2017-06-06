package entity;

import java.util.LinkedList;
import java.util.List;

import exception.TamanhoMaximoExcedidoException;

public class Funcionario {

	private Long id;
	private String nome;
	private List<Ocorrencia> listaOcorrencias;

	public Funcionario(Long id, String nome) {
		this.id = id;
		this.nome = nome;
		this.listaOcorrencias = new LinkedList<>();
	}

	@Override
	public String toString() {
		return String.format("%s, (%s)", this.nome, this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Funcionario) {
			return this.id.equals(((Funcionario) obj).id);
		}
		return false;
	}

	public List<Ocorrencia> obterOcorrenciasEmExecucao() {
		return new LinkedList<>();
	}

	public List<Ocorrencia> getListaOcorrencias() {
		return this.listaOcorrencias;
	}

	public void addOcorencia(Ocorrencia ocorrencia) {
		if (this.listaOcorrencias.size() > 10) {
			throw new TamanhoMaximoExcedidoException();
		}
		this.listaOcorrencias.add(ocorrencia);
	}
}
