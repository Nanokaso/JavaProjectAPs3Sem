package Negocio;

import conexao.DAO;
import TOs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Acesso {

	public static UsuarioTO Logar(String login, String senha) throws Exception {
		UsuarioTO u = null;
		String sql = "SELECT * FROM USUARIO " + " WHERE 1=1" + " AND  LOGIN = @LOGIN" + " AND SENHA = @SENHA";

		sql = DAO.format(sql, "LOGIN", login);
		sql = DAO.format(sql, "SENHA", senha);
		List<UsuarioTO> r = consultar(sql);
		if (r != null) {
			u = r.get(0);
		} else {
			throw new Exception("Usuario não localizado!");
		}
		return u;
	}

	public static UsuarioTO consultarById(int id) throws Exception {
		UsuarioTO u = null;
		String sql = "SELECT * FROM USUARIO " + " WHERE 1=1" + " AND  ID_USUARIO = @id ";

		sql = DAO.format(sql, "id", id);
		List<UsuarioTO> r = consultar(sql);
		if (r != null) {
			u = r.get(0);
		} else {
			throw new Exception("Usuario não localizado!");
		}
		return u;
	}
	
	public static List<UsuarioTO> listar() throws Exception {
		List<UsuarioTO> u = null;
		String sql = "SELECT * FROM USUARIO " + " WHERE 1=1" + " AND  FLG_ATIVO = @id ";

		sql = DAO.format(sql, "id", true);
		List<UsuarioTO> r = consultar(sql);
		if (r != null) {
			u = r;
		} else {
			throw new Exception("Usuarios não localizado!");
		}
		return u;
	}

	private static List<UsuarioTO> consultar(String sql) {

		List<UsuarioTO> l = new ArrayList<UsuarioTO>();
		DAO.Conectar();
		try {
			ResultSet rs = DAO.NewStm().executeQuery(sql + ";");
			while (rs.next()) {
				UsuarioTO c = new UsuarioTO();
				c.ID_USUARIO = rs.getInt("ID_USUARIO");
				c.LOGIN = rs.getString("LOGIN");
				c.SENHA = rs.getString("SENHA");
				c.FLG_ATIVO = rs.getBoolean("FLG_ATIVO");
				l.add(c);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			DAO.Fechar();
		}
		if (l.size() <= 0) {
			return null;
		} else {
			return l;
		}
	}

}
