package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.jdbc.model.Candidato;

public class CandidatoDAO {

	private Connection connection;

	public CandidatoDAO() {
		this.connection = new ConnectionFactory().conectar();
	}

	// insert
	public void insert(Candidato candidato) {
		String sql = "insert into candidato (nome, telefone, email, endereco, formacao, dataNasc, genero, tempoExperiencia, idArea) values (?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getTelefone());
			stmt.setString(3, candidato.getEmail());
			stmt.setString(4, candidato.getEndereco());
			stmt.setString(5, candidato.getFormacao());
			stmt.setObject(6, candidato.getDataNasc());
			stmt.setString(7, candidato.getGenero().getCodigo());
			stmt.setInt(8, candidato.getTempoExperiencia());
			stmt.setLong(9, candidato.getIdArea());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete
	public void delete(long id) {
		String sql = "delete from candidato where idCandidato=?";
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
	public void update(Candidato candidato) {
		String sql = "update candidato set nome=?, telefone=?, email=?, endereco=?, formacao=?, dataNasc=?, genero=?, tempoExperiencia=?, idArea=? where idCandidato=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getTelefone());
			stmt.setString(3, candidato.getEmail());
			stmt.setString(4, candidato.getEndereco());
			stmt.setString(5, candidato.getFormacao());
			stmt.setObject(6, candidato.getDataNasc());
			stmt.setString(7, candidato.getGenero().getCodigo());
			stmt.setInt(8, candidato.getTempoExperiencia());
			stmt.setLong(9, candidato.getIdArea());
			stmt.setLong(10, candidato.getIdCandidato());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// selectAll
	public List<Candidato> selectAll() {
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		Candidato candidato;
		String sql = "select * from candidato order by nome";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {		
				candidato = new Candidato();
				candidato.setIdCandidato(rs.getLong("idCandidato"));
				candidato.setNome(rs.getString("nome"));
				candidato.setTelefone(rs.getString("telefone"));
				candidato.setEmail(rs.getString("email"));
				candidato.setEndereco(rs.getString("endereco"));
				candidato.setFormacao(rs.getString("formacao"));
				candidato.setDataNasc(rs.getTimestamp("dataNasc").toLocalDateTime().toLocalDate());
				candidato.setGenero(rs.getString("genero"));
				candidato.setTempoExperiencia(rs.getInt("tempoExperiencia"));
				candidato.setIdArea(rs.getLong("idArea"));
				listaCandidatos.add(candidato);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCandidatos;
	}

	// selectById
	public Candidato selectById(long id) {
		Candidato candidato = null;
		String sql = "select * from candidato where idCandidato=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				candidato = new Candidato();
				candidato.setIdCandidato(rs.getLong("idCandidato"));
				candidato.setNome(rs.getString("nome"));
				candidato.setTelefone(rs.getString("telefone"));
				candidato.setEmail(rs.getString("email"));
				candidato.setEndereco(rs.getString("endereco"));
				candidato.setDataNasc(rs.getTimestamp("dataNasc").toLocalDateTime().toLocalDate());
				candidato.setGenero(rs.getString("genero"));
				candidato.setTempoExperiencia(rs.getInt("tempoExperiencia"));
				candidato.setIdArea(rs.getLong("idArea"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidato;
	}
	
	public List<Candidato> selectCandidatoByArea(int idArea) {
		List<Candidato> candidatos = new ArrayList<Candidato>();
		Candidato candidato = null;
		try {
			String sql = "SELECT * FROM candidato WHERE idArea = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idArea);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				candidato = new Candidato();
				candidato.setIdCandidato(rs.getLong("idCandidato"));
				candidato.setNome(rs.getString("nome"));
				candidato.setTelefone(rs.getString("telefone"));
				candidato.setEmail(rs.getString("email"));
				candidato.setEndereco(rs.getString("endereco"));
				candidato.setDataNasc(rs.getTimestamp("dataNasc").toLocalDateTime().toLocalDate());
				candidato.setGenero(rs.getString("genero"));
				candidato.setTempoExperiencia(rs.getInt("tempoExperiencia"));
				candidato.setIdArea(rs.getLong("idArea"));
				candidatos.add(candidato);
			}
			stmt.close();
			rs.close();
			return candidatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
