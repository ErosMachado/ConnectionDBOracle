package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.jdbc.dao.AreaAtuacaoDAO;
import br.com.fiap.jdbc.dao.CandidatoDAO;
import br.com.fiap.jdbc.model.AreaAtuacao;
import br.com.fiap.jdbc.model.Candidato;
import br.com.fiap.jdbc.factory.ConnectionFactory;

public class AppController {

	private static AppController instance;
	private Connection connection;
	private CandidatoDAO candidatoDAO;
	private AreaAtuacaoDAO areaDAO;

	// Construtor privado para Singleton
	private AppController() throws SQLException {
		this.connection = new ConnectionFactory().conectar();
		this.candidatoDAO = new CandidatoDAO(connection);
		this.areaDAO = new AreaAtuacaoDAO(connection);
	}

	// Método para obter a instância única do AppController
	public static AppController getInstance() throws SQLException {
		if (instance == null) {
			instance = new AppController();
		}
		return instance;
	}

	// Método para fechar a conexão quando o AppController não for mais necessário
	public void closeConnection() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

	public void adicionarCandidato(Candidato candidato) throws SQLException {
		candidatoDAO.insert(candidato);
	}

	public void alterarCandidato(Candidato candidato) throws SQLException {
		candidatoDAO.update(candidato);
	}

	public void excluirCandidato(int id) throws SQLException {
		candidatoDAO.delete(id);
	}

	public void buscarTodosCandidatos() throws SQLException {
		List<Candidato> lista = candidatoDAO.selectAll();
		for (Candidato candidato : lista) {
			System.out.println("Id: " + candidato.getIdCandidato());
			System.out.println("Nome: " + candidato.getNome());
			System.out.println("Email: " + candidato.getEmail());
			System.out.println("Data Nascimento: " + candidato.getDataNasc());
			System.out.println("Gênero: " + candidato.getGenero());
			System.out.println("----");
		}
	}

	public void buscarCandidato(int id) throws SQLException {
		Candidato candidatoPorId = candidatoDAO.selectById(id);
		if (candidatoPorId != null) {
			System.out.println("Candidato encontrado: " + candidatoPorId.getNome());
		} else {
			System.out.println("Candidato com ID especificado não encontrado.");
		}
	}

	public void buscarCandidatoPorArea(int id) {
		List<Candidato> candidatosPorArea = candidatoDAO.selectCandidatoByArea(id);
		for (Candidato candidato : candidatosPorArea) {
			System.out.println("Id: " + candidato.getIdCandidato() + " - Nome: " + candidato.getNome());
		}
	}

	public List<AreaAtuacao> listarAreaAtuacaoComCandidato() {
		return areaDAO.selectAreaAtuacaoCandidato();
	}
}
