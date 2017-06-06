package entity;

import java.util.LinkedList;
import java.util.List;

import exception.ExcecaoFuncionarioComIdentificadorJaCadastrado;

public class GerenciadorExample {

	private LinkedList<FuncionarioExample> funcionarios;

	public GerenciadorExample() {
		this.funcionarios = new LinkedList<>();
	}

	public List<FuncionarioExample> obterFuncionarios() {
		return this.funcionarios;
	}

	public void cadastrarFuncionario(FuncionarioExample funcionario) {
		if (this.funcionarios.contains(funcionario)) {
			throw new ExcecaoFuncionarioComIdentificadorJaCadastrado();
		}
		this.funcionarios.add(funcionario);
	}

}
