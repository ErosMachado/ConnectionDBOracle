package br.com.fiap.jdbc.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Candidato {

	private long idCandidato; // PK
	private String nome, telefone, email, endereco, formacao;
	private LocalDate dataNasc;
	private Genero genero;
	private int tempoExperiencia;
	private long idArea; // FK

	public Candidato(String nome, String telefone, String email, String endereco, String formacao, String dataNasc,
			Genero genero, int tempoExperiencia, long idArea) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.formacao = formacao;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataNasc = LocalDate.parse(dataNasc, formato);
		this.genero = genero;
		this.tempoExperiencia = tempoExperiencia;
		this.idArea = idArea;
	}

	public Candidato() {

	}

	public long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(long idCandidato) {
		this.idCandidato = idCandidato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Genero getGenero() {
		return genero;
	}
	
	// Setter que recebe uma String (do banco de dados) e converte para o Enum
    public void setGenero(String genero) {
        this.genero = Genero.fromCodigo(genero);
    }

	public int getTempoExperiencia() {
		return tempoExperiencia;
	}

	public void setTempoExperiencia(int tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}

	public long getIdArea() {
		return idArea;
	}

	public void setIdArea(long idArea) {
		this.idArea = idArea;
	}

}
