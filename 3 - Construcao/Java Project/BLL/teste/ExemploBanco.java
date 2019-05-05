package teste;

import java.sql.*;
import conexao.DAO;

public class ExemploBanco {

	// execute normal
	public static void Exemplo1() {

		DAO.Conectar();
		try {

			String sql = "Select * from aaa;";
			ResultSet rs = DAO.NewStm().executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String ds = rs.getString("DS");
				System.out.println(id + "     " + ds);
			}
			// stmt.close(); // nao tao necessario se fecha a conexao antes de outra execucao
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			DAO.Fechar();
		}
	}

	// execute with roolback
	public static void Exemplo2() {
		DAO.Conectar();
		Savepoint savePoint = DAO.IniciarSQL();
		try {

			String sql = "insert into aaa(ds) values(0);";
			DAO.NewStm().executeUpdate(sql);
			throw new Exception("a");
			// DAO.ConfirmarSQL(); 
		} catch (Exception e) {
			DAO.CancelarSQL(savePoint);
			System.out.print(e.getMessage());
		} finally {
			DAO.Fechar();
		}
	}
}
