package entity;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {

	private List<Funcionario> listaFuncionarios;
	private List<Projeto> listaProjetos;

	public Gerenciador() {
		this.listaFuncionarios = new ArrayList<>();
		this.listaProjetos = new ArrayList<>();

	}

	public List<Funcionario> getListaFuncionarios() {
		return this.listaFuncionarios;
	}

	public void addFuncionario(Funcionario funcionario) {
		this.listaFuncionarios.add(funcionario);
	}

	public List<Projeto> getListaProjetos() {
		return this.listaProjetos;
	}

	public void addProject(Projeto projeto) {
		this.listaProjetos.add(projeto);
	}
}
