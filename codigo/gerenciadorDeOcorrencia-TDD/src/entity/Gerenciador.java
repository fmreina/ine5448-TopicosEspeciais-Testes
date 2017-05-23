package entity;

import java.util.ArrayList;
import java.util.List;

import exception.funcionarioComMesmoIdException;

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

	public void cadastrarFuncionario(Funcionario funcionario) {
		if (this.listaFuncionarios.contains(funcionario)) {
			throw new funcionarioComMesmoIdException();
		}
		this.listaFuncionarios.add(funcionario);
	}

	public List<Projeto> getListaProjetos() {
		return this.listaProjetos;
	}

	public void addProject(Projeto projeto) {
		this.listaProjetos.add(projeto);
	}
}
