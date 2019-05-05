package conexao;

import java.sql.*;

public class ConexaoMySql {

	protected static Connection connection = null;

	@SuppressWarnings("deprecation")
	public static void Conectar() throws InstantiationException, IllegalAccessException {
		if (connection == null) {
			try {
				Class.forName(_config.driver).newInstance();
				connection = DriverManager.getConnection(_config.url, _config.usuario, _config.senha);
				if (connection == null) {
					System.out.println("Erro ao conectar!");
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Erro Driver. " + e.getMessage());
			} catch (SQLException e) {
				System.out.println("Erro Banco. " + e.getMessage());
			}
		}
	}

	public static boolean Fechar() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
				return true;
			} catch (Exception e) {
				return false;
			}

		} else {
			return true;
		}
	}

	public static void Reiniciar() throws InstantiationException, IllegalAccessException {
		Fechar();
		Conectar();
	}

}
