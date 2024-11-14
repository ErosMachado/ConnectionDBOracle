package br.com.fiap.jdbc.model;

import java.util.List;

public class AreaAtuacao {

	private long idArea; // PK
	private String nome, descricao;
	private List<Candidato> candidatos;

	public AreaAtuacao(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public AreaAtuacao() {
	}

	public long getIdArea() {
		return idArea;
	}

	public void setIdArea(long idArea) {
		this.idArea = idArea;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public void adicionaCandidato(Candidato candidato) {
		candidatos.add(candidato);

	}
}
