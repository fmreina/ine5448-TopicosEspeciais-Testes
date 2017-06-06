package entity;

import java.util.LinkedList;
import java.util.List;

import exception.EntidadeoComMesmoIdException;
import exception.TamanhoMaximoExcedidoException;

public class Gerenciador {

	private List<Funcionario> listaFuncionarios;
	private List<Projeto> listaProjetos;
	private List<Ocorrencia> listaOcorrencias;

	public Gerenciador() {
		this.listaFuncionarios = new LinkedList<>();
		this.listaProjetos = new LinkedList<>();
		this.listaOcorrencias = new LinkedList<>();
	}

	public List<Funcionario> getListaFuncionarios() {
		return this.listaFuncionarios;
	}

	public void cadastrarFuncionario(Funcionario funcionario) {
		if (this.listaFuncionarios.contains(funcionario)) {
			throw new EntidadeoComMesmoIdException();
		}
		this.listaFuncionarios.add(funcionario);
	}

	public List<Projeto> getListaProjetos() {
		return this.listaProjetos;
	}

	public void cadastrarProject(Projeto projeto) {
		if (this.listaProjetos.contains(projeto)) {
			throw new EntidadeoComMesmoIdException();
		}
		this.listaProjetos.add(projeto);
	}

	public List<Ocorrencia> getListaOcorrencias() {
		return this.listaOcorrencias;
	}

	public void cadastrarOcorrencia(Ocorrencia ocorrencia) {
		if (this.listaOcorrencias.contains(ocorrencia)) {
			throw new EntidadeoComMesmoIdException();
		}
		this.listaOcorrencias.add(ocorrencia);
	}

	public void cadastrarResponsavelPorOcorrencia(Funcionario funcionario, Ocorrencia ocorrencia) {
		if (funcionario.getListaOcorrencias().size() == 10) {
			throw new TamanhoMaximoExcedidoException();
		}
		if (funcionario.getListaOcorrencias().contains(ocorrencia)) {
			throw new EntidadeoComMesmoIdException();
		}
		ocorrencia.setResponsavel(funcionario);
		funcionario.addOcorencia(ocorrencia);
	}

	public void concluirOcorrencia(Ocorrencia ocorrencia) {
		ocorrencia.concluir();
	}

	public void alteraResponsavelOcorrencia(Funcionario antigo, Funcionario novo, Ocorrencia ocorrencia) {
		antigo.removeOcorrencia(ocorrencia);
		cadastrarResponsavelPorOcorrencia(novo, ocorrencia);
	}

}
