package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;

public class UsuarioDAO {
	private Connection connection;
	private Usuario usuario;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().conectar();

	}

	// insert
	public void insert(Usuario usuario) {
		String sql = "insert into usuario (nome, email, dataCadastro) values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setDate(3, usuario.getDataCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete
	public void delete(Long id) {
		String sql = "delete * from usuario where nome=?, email=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update
	public void update(Usuario usuario) {
		String sql = "update * from usuario where nome=?,email=?,dataCadastro=?, id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setDate(3, usuario.getDataCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// selectAll
	public List<Usuario> selectAll() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario order by nome";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataCadastro(rs.getDate("dataCadastro"));
				listaUsuarios.add(usuario);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	// selectById
	public Usuario selectById(long id) {
		
		String sql = "select * from usuario where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataCadastro(rs.getDate("dataCadastro"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
