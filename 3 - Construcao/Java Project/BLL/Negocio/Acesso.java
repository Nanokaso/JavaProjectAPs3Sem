package Negocio;

import conexao.DAO;
import TOs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Acesso {

	public static UsuarioTO Logar(String login, String senha) throws Exception {
		UsuarioTO u = null;
		String sql = "SELECT * FROM USUARIO " 
		+ " WHERE 1=1" 
		+ " AND  LOGIN = @LOGIN" 
		+ " AND SENHA = @SENHA"
		+ " AND FLG_ATIVO = 1";

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
	
	public static UsuarioTO consultarByLogin(String login) throws Exception {
		UsuarioTO u = null;
		String sql = "SELECT * FROM USUARIO " + " WHERE 1=1" + " AND  LOGIN = @LOGIN";
		sql = DAO.format(sql, "LOGIN", login);		
		List<UsuarioTO> r = consultar(sql);
		if (r != null) {
			u = r.get(0);
		} else {
			return null;
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
			return null;
		}
		return u;
	}
	
	public static List<UsuarioTO> listar(boolean somenteAtivos) {
		List<UsuarioTO> u = null;
		String sql = "SELECT * FROM USUARIO " + " WHERE 1=1";
		if (somenteAtivos)
		{
			sql+=" AND  FLG_ATIVO = @id ";
			sql = DAO.format(sql, "id", true);		
		}

		List<UsuarioTO> r = consultar(sql);
		if (r != null) {
			u = r;
		} else {
			return null;
		}
		return u;
	}
	
	
	
	public static void incluir(UsuarioTO usuario) {
		DAO.Conectar();
		Savepoint savePoint = DAO.IniciarSQL();
		try {
			String sql = "INSERT INTO usuario(LOGIN, SENHA, FLG_ATIVO) values(@LOGIN, @SENHA, @ATIVO);";
			sql = DAO.format(sql, "LOGIN", usuario.LOGIN);
			sql = DAO.format(sql, "SENHA", usuario.SENHA);
			sql = DAO.format(sql, "ATIVO", usuario.FLG_ATIVO);			
			DAO.NewStm().executeUpdate(sql);
			DAO.ConfirmarSQL(); 
		} catch (Exception e) {
			DAO.CancelarSQL(savePoint);
			System.out.print(e.getMessage());
		} finally {
			DAO.Fechar();
		}
	}
	
	public static void alterar(UsuarioTO usuario) {
		DAO.Conectar();
		Savepoint savePoint = DAO.IniciarSQL();
		try {
			String sql = "UPDATE usuario SET "
					+ " LOGIN = @LOGIN, "
					+ " SENHA = @SENHA, "
					+ " FLG_ATIVO = @ATIVO "
					+ " WHERE ID_USUARIO = @IDUSU;";
			sql = DAO.format(sql, "LOGIN", usuario.LOGIN);
			sql = DAO.format(sql, "SENHA", usuario.SENHA);
			sql = DAO.format(sql, "ATIVO", usuario.FLG_ATIVO);
			sql = DAO.format(sql, "IDUSU", usuario.ID_USUARIO);
			DAO.NewStm().executeUpdate(sql);
			DAO.ConfirmarSQL(); 
		} catch (Exception e) {
			DAO.CancelarSQL(savePoint);
			System.out.print(e.getMessage());
		} finally {
			DAO.Fechar();
		}
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
