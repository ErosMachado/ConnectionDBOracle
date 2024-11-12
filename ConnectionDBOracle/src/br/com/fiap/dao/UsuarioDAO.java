package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().conectar();

	}

	// insert
	public void insert(Usuario usuario) {
		String sql = "insert into usuario (nome, email, dataCadastro) values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete
	public void delete(long id) {

	}

	// update
	public void update(Usuario usuario) {

	}

	// selectAll
	public List<Usuario> selectAll() {
		return null;
	}

	// selectById
	public Usuario selectById(long id) {
		return null;
	}

}
