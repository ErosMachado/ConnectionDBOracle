package br.com.fiap.jdbc.teste;


import java.util.List;
import br.com.fiap.jdbc.dao.CandidatoDAO;
import br.com.fiap.jdbc.model.Candidato;
import br.com.fiap.jdbc.model.Genero;

public class Teste {

	public static void main(String[] args) {

		CandidatoDAO daoCandidato = new CandidatoDAO();

		// 1. Teste de Inserção
		System.out.println("Inserindo candidatos...");
		Candidato emerson = new Candidato("Emerson", "99999-0000", "emerson@gmail.com", "Rua A", "Engenheiro",
				"13/11/1978", Genero.MASCULINO, 20, 1);
		Candidato adriane = new Candidato("Adriane", "88888-1111", "adriane@gmail.com", "Rua B", "Analista",
				"13/11/1977", Genero.FEMININO, 10, 2);
		daoCandidato.insert(emerson);
		daoCandidato.insert(adriane);
		System.out.println("Inserção concluída.\n");

		// 2. Teste de Consulta
		System.out.println("Consultando todos os candidatos:");
		List<Candidato> lista = daoCandidato.selectAll();
		for (Candidato candidato : lista) {
			System.out.println("Id: " + candidato.getIdCandidato());
			System.out.println("Nome: " + candidato.getNome());
			System.out.println("Email: " + candidato.getEmail());
			System.out.println("Data Nascimento: " + candidato.getDataNasc());
			System.out.println("Gênero: " + candidato.getGenero());
			System.out.println("----");
		}

		// Consulta por ID
		System.out.println("\nConsultando candidato por ID:");
		Candidato candidatoPorId = daoCandidato.selectById(5);
		if (candidatoPorId != null) {
			System.out.println("Candidato encontrado: " + candidatoPorId.getNome());
		} else {
			System.out.println("Candidato com ID especificado não encontrado.");
		}

		// Consulta por Área
		System.out.println("\nConsultando candidatos por Área de Atuação:");
		List<Candidato> candidatosPorArea = daoCandidato.selectCandidatoByArea(1);
		for (Candidato candidato : candidatosPorArea) {
			System.out.println("Id: " + candidato.getIdCandidato() + " - Nome: " + candidato.getNome());
		}

		// 3. Teste de Atualização 
		System.out.println("\nAtualizando candidato:");
		//emerson.setNome("Emerson Silva");
		//emerson.setEmail("emerson.silva@gmail.com");
		//daoCandidato.update(emerson);
		System.out.println("Candidato atualizado.\n");

		// 4. Teste de Exclusão
		System.out.println("Excluindo candidato:");
		//daoCandidato.delete(adriane.getIdCandidato());
		System.out.println("Candidato excluído.\n");

		// Consulta final para verificar exclusão
		System.out.println("Consultando todos os candidatos após exclusão:");
		lista = daoCandidato.selectAll();
		for (Candidato candidato : lista) {
			System.out.println("Id: " + candidato.getIdCandidato());
			System.out.println("Nome: " + candidato.getNome());
			System.out.println("Email: " + candidato.getEmail());
			System.out.println("----");
		}
	}
}
