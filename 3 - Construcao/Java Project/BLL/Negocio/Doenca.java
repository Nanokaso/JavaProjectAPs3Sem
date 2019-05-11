package Negocio;

import conexao.DAO;
import TOs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Doenca {

	private static List<TratamentoTO> consultarTratamento(int IdDoenca) {
		List<TratamentoTO> l = new ArrayList<TratamentoTO>();
		DAO.Conectar();
		try {
			String sql = "";

			sql += " SELECT T.*, TT.DS_TIPOTRATAMENTO FROM DOENCA_TRATAMENTO AS DT ";
			sql += " INNER JOIN TRATAMENTO AS T ON T.ID_TRATAMENTO = DT.ID_TRATAMENTO ";
			sql += " INNER JOIN TIPOTRATAMENTO AS TT ON T.ID_TIPOTRATAMENTO = TT.ID_TIPOTRATAMENTO ";
			sql += " WHERE 1=1 ";
			sql += " AND DT.ID_DOENCA = @iddoenca ";

			sql = DAO.format(sql, "iddoenca", IdDoenca);

			ResultSet rs = DAO.NewStm().executeQuery(sql + ";");
			while (rs.next()) {
				TratamentoTO c = new TratamentoTO();

				c.ID_TRATAMENTO = rs.getInt("ID_TRATAMENTO");
				c.DS_TRATAMENTO = rs.getString("DS_TRATAMENTO");

				c.ID_TIPOTRATAMENTO = rs.getInt("ID_TIPOTRATAMENTO");
				c.DS_TIPOTRATAMENTO = rs.getString("DS_TIPOTRATAMENTO");

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

	private static List<DoencaTO> consultar(String sql) {

		List<DoencaTO> l = new ArrayList<DoencaTO>();
		DAO.Conectar();
		try {
			ResultSet rs = DAO.NewStm().executeQuery(sql + ";");
			while (rs.next()) {
				DoencaTO c = new DoencaTO();
				c.ID_DOENCA = rs.getInt("ID_DOENCA");
				c.NOME_DOENCA = rs.getString("NOME_DOENCA");
				c.DESCRICAO = rs.getString("DESCRICAO");
				c.SINTOMAS = rs.getString("SINTOMAS");
				c.FLG_COMUM = rs.getBoolean("FLG_COMUM");
				c.FLG_TRATACOMVACINA = rs.getBoolean("FLG_TRATACOMVACINA");
				c.FLG_TRATADOPORPESSOA = rs.getBoolean("FLG_TRATADOPORPESSOA");
				c.FLG_PROPAGAFACIL = rs.getBoolean("FLG_PROPAGAFACIL");
				c.FLG_REQUEREXAME = rs.getBoolean("FLG_REQUEREXAME");
				c.MEDIADIASCURA = rs.getInt("MEDIADIASCURA");
				c.FLG_GRAVE = rs.getBoolean("FLG_GRAVE");
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
			for (DoencaTO doencaTO : l) {
				doencaTO.Tratamentos = consultarTratamento(doencaTO.ID_DOENCA);
			}
			return l;
		}
	}

	public static List<DoencaTO> listarTodos() throws Exception {
		List<DoencaTO> u = null;
		String sql = "SELECT * FROM DOENCA ";
		List<DoencaTO> r = consultar(sql);
		if (r != null) {
			u = r;
		} else {
			throw new Exception("Nenhuma doença localizada!");
		}
		return u;
	}
	
	public static DoencaTO consultar(int IdDoenca) throws Exception {
		DoencaTO u = null;
		
		String sql = "SELECT * FROM DOENCA " 
		+ " WHERE 1=1" 
		+ " AND  ID_DOENCA = @IDDOENCA";
		sql = DAO.format(sql, "IDDOENCA", IdDoenca);		
	
		List<DoencaTO> r = consultar(sql);
		if (r != null) {
			u = r.get(0);
		} else {
			throw new Exception("Nenhuma doença localizada!");
		}
		return u;
	}
}
