package entity;

import java.util.LinkedList;
import java.util.List;

public class Projeto {

	private Long id;
	private String nome;

	public Projeto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format("%s, (%s)", this.nome, this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Projeto) {
			return this.id.equals(((Projeto) obj).id);
		}
		return false;
	}

	public List<Projeto> obterOcorrencias() {
		// TODO Auto-generated method stub
		return new LinkedList<>();
	}
}
