package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jdbc.model.AreaAtuacao;
import br.com.fiap.jdbc.model.Candidato;

public class AreaAtuacaoDAO {

	private Connection connection;

	public AreaAtuacaoDAO(Connection connection) {
		this.connection = connection;
	}

	public List<AreaAtuacao> selectAreaAtuacaoCandidato() {
		try {
			AreaAtuacao areaAtual = null;
			Candidato candidato = null;
			List<AreaAtuacao> areas = new ArrayList<AreaAtuacao>();
			String sql = "SELECT A.idArea, A.nome, A.descricao, C.idCandidato, C.nome,  C.telefone, C.email, C.endereco, C.formacao, C.dataNasc, C.genero, C.tempoExperiencia, C.idArea"
					+ "FROM AREA A INNER JOIN CANDIDATO C ON A.idArea = C.idArea order by C.idArea";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				if (areaAtual == null || !areaAtual.getNome().equals(rs.getString(2))) {
					AreaAtuacao area = new AreaAtuacao();
					area.setIdArea(rs.getLong(1));
					area.setNome(rs.getString(2));
					area.setDescricao(rs.getString(3));
					areas.add(area);
					areaAtual = area;
				}
				candidato = new Candidato();
				candidato.setIdCandidato(rs.getLong(4));
				candidato.setNome(rs.getString(5));
				candidato.setTelefone(rs.getString(6));
				candidato.setEmail(rs.getString(7));
				candidato.setEndereco(rs.getString(8));
				candidato.setFormacao(rs.getString(9));
				candidato.setDataNasc((LocalDate) rs.getObject(10));
				candidato.setGenero(rs.getString(11));
				candidato.setTempoExperiencia(rs.getInt(12));
				candidato.setIdArea(rs.getLong(13));
				areaAtual.adicionaCandidato(candidato);
			}
			rs.close();
			stmt.close();
			return areas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
