package br.com.fiap.model;

//trabalhando com o oracle, sempre chamar .sql e não .util
import java.sql.Date;

//javabens
public class Usuario {

	private long id;
	private String nome;
	private String email;
	private Date dataCadastro;

	// construtor
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.dataCadastro = new Date(System.currentTimeMillis());
	}

	public Usuario(Long id, String nome, String email, Date dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataCadastro = new Date(0);
	}

	public Usuario() {
	}

	// Começo: getters and Setters:
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	// Fim: Getters and Setters

}
