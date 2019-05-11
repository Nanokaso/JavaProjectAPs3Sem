package Negocio;

import conexao.DAO;
import TOs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Endereco {

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

	private static List<EnderecoTO> consultar(String sql) {

		List<EnderecoTO> l = new ArrayList<EnderecoTO>();
		DAO.Conectar();
		try {
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
