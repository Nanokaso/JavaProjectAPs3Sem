package Negocio;

import conexao.DAO;
import TOs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Endereco {

	public static List<GenericTO<String, String>> getCidadesUF() {
		List<GenericTO<String, String>> l = new ArrayList<GenericTO<String, String>>();

		DAO.Conectar();
		try {
			String sql = " SELECT DISTINCT(E.CIDADE) AS CIDADE, E.UF FROM ENDERECO AS E "
					+ "INNER JOIN PACIENTE_DOENCA AS PC ON PC.ID_ENDERECO = E.ID_ENDERECO "
					+ "ORDER BY E.UF ASC, E.CIDADE ASC;";
			ResultSet rs = DAO.NewStm().executeQuery(sql + ";");
			while (rs.next()) {
				GenericTO<String, String> c = new GenericTO<String, String>();				
				c.SetAll(rs.getString("CIDADE"), rs.getString("UF"));
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
	
	public static List<EnderecoTO> listarTodos(){
		List<EnderecoTO> u = null;
		String sql = "SELECT * FROM ENDERECO ";
		List<EnderecoTO> r = consultar(sql);
		if (r != null) {
			u = r;
		} else {
			return null;
		}
		return u;
	}


	public static List<EnderecoTO> consultar(String cidade, String uf, int cep) {
		List<EnderecoTO> u = null;
		String sql = "SELECT * FROM ENDERECO " + "WHERE 1=1 ";
		if (cep > 0) {
			sql += " AND CEP = @cep";
			sql = DAO.format(sql, "cep", cep);
		}

		if (!cidade.isEmpty()) {
			sql += " AND CIDADE = @cidade";
			sql = DAO.format(sql, "cidade", cidade);
		}

		if (!uf.isEmpty()) {
			sql += " AND UF = @uf";
			sql = DAO.format(sql, "uf", uf);
		}

		List<EnderecoTO> r = consultar(sql);
		if (r != null) {
			u = r;
		} else {
			return null;
		}
		return u;
	}

	public static EnderecoTO consultar(int id) throws Exception {
		EnderecoTO u = null;

		String sql = "SELECT * FROM ENDERECO " + " WHERE 1=1" + " AND  ID_ENDERECO = @IDPARAMETRO";
		sql = DAO.format(sql, "IDPARAMETRO", id);

		List<EnderecoTO> r = consultar(sql);
		if (r != null) {
			u = r.get(0);
		} else {
			throw new Exception("Nenhum endereço localizado!");
		}
		return u;
	}
	
	public static void incluir(EnderecoTO obj) {
		DAO.Conectar();
		Savepoint savePoint = DAO.IniciarSQL();
		try {
			String sql = "INSERT INTO Endereco (ENDERECO,BAIRRO,NUMERO,CEP,COMPLEMENTO,CIDADE,UF) "
					+ " VALUES (@ENDERECO, @BAIRRO, @NUMERO, @CEP, @COMPLEMENTO, @CIDADE, @UF);";
			
			sql = DAO.format(sql, "ENDERECO", obj.ENDERECO);
			sql = DAO.format(sql, "BAIRRO", obj.BAIRRO);
			sql = DAO.format(sql, "NUMERO", obj.NUMERO);
			sql = DAO.format(sql, "CEP", obj.CEP);
			sql = DAO.format(sql, "COMPLEMENTO", obj.COMPLEMENTO);
			sql = DAO.format(sql, "CIDADE", obj.CIDADE);
			sql = DAO.format(sql, "UF", obj.UF);		
			
			DAO.NewStm().executeUpdate(sql);
			DAO.ConfirmarSQL(); 
		} catch (Exception e) {
			DAO.CancelarSQL(savePoint);
			System.out.print(e.getMessage());
		} finally {
			DAO.Fechar();
		}
	}
	

	private static List<EnderecoTO> consultar(String sql) {

		List<EnderecoTO> l = new ArrayList<EnderecoTO>();
		DAO.Conectar();
		try {
			sql += " ORDER BY UF, CIDADE, BAIRRO, ENDERECO, NUMERO, COMPLEMENTO";
			ResultSet rs = DAO.NewStm().executeQuery(sql + ";");
			while (rs.next()) {

				EnderecoTO c = new EnderecoTO();

				c.ID_ENDERECO = rs.getInt("ID_ENDERECO");
				c.ENDERECO = rs.getString("ENDERECO");
				c.BAIRRO = rs.getString("BAIRRO");
				c.NUMERO = rs.getInt("NUMERO");
				c.CEP = rs.getString("CEP");
				c.COMPLEMENTO = rs.getString("COMPLEMENTO");
				c.CIDADE = rs.getString("CIDADE");
				c.UF = rs.getString("UF");
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
