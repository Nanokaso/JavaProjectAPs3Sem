package conexao;

import java.sql.*;

public class DAO {

	public static String format(String sql, String identifier, java.util.Date value) {
		if (value == null) {
			return sql.replace("@" + identifier, "NULL");
		} else {

			String data = "STR_TO_DATE('" + value.getDay() + "-" + value.getMonth() + "-" + value.getYear()
					+ "','%d-%m-%Y')";
			return sql.replace("@" + identifier, data);
		}
	}

	public static String format(String sql, String identifier, String value) {
		if (value == null) {
			return sql.replace("@" + identifier, "NULL");
		} else {
			return sql.replace("@" + identifier, "'" + value + "'");
		}
	}

	public static String format(String sql, String identifier, Boolean value) {
		if (value == null) {
			return sql.replace("@" + identifier, "NULL");
		} else {
			String valuen = (value ? 1 : 0) + "";
			return sql.replace("@" + identifier, valuen);
		}
	}

	public static String format(String sql, String identifier, int value) {
		String valuen = value + "";
		return sql.replace("@" + identifier, valuen);

	}

	public static String format(String sql, String identifier, Double value) {
		String valuen = value.toString();
		return sql.replace("@" + identifier, valuen);
	}
	// -------------------------------------------------------------------

	public static void Conectar() {
		try {
			ConexaoMySql.Conectar();
		} catch (Exception e) {
			System.out.print("Erro! " + e.getMessage());
		}
	}

	public static void Fechar() {
		ConexaoMySql.Fechar();
	}

	public static Savepoint IniciarSQL() {
		try {
			ConexaoMySql.connection.beginRequest();
			ConexaoMySql.connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Savepoint save = null;
		try {
			// save =
			// ConexaoMySql.connection.setSavepoint(java.util.UUID.randomUUID().toString());
			save = ConexaoMySql.connection.setSavepoint();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return save;
	}

	public static void CancelarSQL(Savepoint save) {
		try {
			ConexaoMySql.connection.rollback(save);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ConfirmarSQL() throws SQLException {
		ConexaoMySql.connection.commit();
	}

	public static ResultSet Executar(String sql) throws SQLException {
		Statement stmt = null;
		try {
			stmt = ConexaoMySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.print("Erro! " + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return null;
	}

	public static Statement NewStm() throws SQLException {

		return ConexaoMySql.connection.createStatement();
	}
}
