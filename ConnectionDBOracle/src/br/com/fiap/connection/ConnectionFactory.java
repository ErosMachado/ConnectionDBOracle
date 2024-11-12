package br.com.fiap.connection;

//configurações para o banco:
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection conectar() {
		try {
			// Obtém o URL, o usuário e a senha do BD a partir das variáveis de ambiente
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			// lembrar de, caso dê erro, há duas possibilidades:
			// 1. confuguração no eclipse: run as --> Run Configurations --> Environment
			// 2. adicionar no CMD (se for windows) com o comando "set"
			String user = System.getenv("DB_USER");
			String password = System.getenv("DB_PASSWORD");

			// Estabelece a conexão usando as credenciais das variáveis de ambiente
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
