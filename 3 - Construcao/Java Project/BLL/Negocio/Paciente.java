package Negocio;

import conexao.DAO;
import TOs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Paciente {

	public static List<PacienteTO> listarTodos() throws Exception {
		List<PacienteTO> u = null;
		String sql = "SELECT * FROM PACIENTE ";
		List<PacienteTO> r = consultar(sql);
		if (r != null) {
			u = r;
		} else {
			throw new Exception("Nenhum paciente localizado!");
		}
		return u;
	}

	public static PacienteTO consultar(int IdPaciente) throws Exception {
		PacienteTO u = null;

		String sql = "SELECT * FROM PACIENTE " + " WHERE 1=1" + " AND  ID_PACIENTE = @IDPARAMETRO";
		sql = DAO.format(sql, "IDPARAMETRO", IdPaciente);

		List<PacienteTO> r = consultar(sql);
		if (r != null) {
			u = r.get(0);
		} else {
			throw new Exception("Nenhum paciente localizado!");
		}
		return u;
	}
	
	public static PacienteTO consultarByRgOrCPF(String rg, String cpf) {
		PacienteTO u = null;

		String sql = "SELECT * FROM PACIENTE " + " WHERE 1=1" + " AND  "
				+ "( RG = @RG"
				+ " OR CPF = @CPF) ";
		sql = DAO.format(sql, "RG", rg);
		sql = DAO.format(sql, "CPF", cpf);

		List<PacienteTO> r = consultar(sql);
		if (r != null) {
			u = r.get(0);
		} else {
			return null;
		}
		return u;
	}
	
	public static PacienteTO consultarByCPF(String cpf) {
		PacienteTO u = null;

		String sql = "SELECT * FROM PACIENTE " + " WHERE 1=1" + " AND  "				
				+ " CPF = @CPF ";		
		sql = DAO.format(sql, "CPF", cpf);

		List<PacienteTO> r = consultar(sql);
		if (r != null) {
			u = r.get(0);
		} else {
			return null;
		}
		return u;
	}
	
	
	public static void incluir(PacienteTO obj) {
		DAO.Conectar();
		Savepoint savePoint = DAO.IniciarSQL();
		try {
			String sql = "INSERT INTO PACIENTE( NOME_PACIENTE , DT_NASCIMENTO , CPF , RG , SEXO ) "
					+ " VALUES ( @NOMEPACIENTE , @DTNASCIMENTO , @CPF , @RG , @SEXO );";
			
			sql = DAO.format(sql, "NOMEPACIENTE", obj.NOME_PACIENTE);
			sql = DAO.format(sql, "DTNASCIMENTO", obj.DT_NASCIMENTO);
			sql = DAO.format(sql, "CPF", obj.CPF);
			sql = DAO.format(sql, "RG", obj.RG);
			sql = DAO.format(sql, "SEXO", obj.SEXO);			
			
			DAO.NewStm().executeUpdate(sql);
			DAO.ConfirmarSQL(); 
		} catch (Exception e) {
			DAO.CancelarSQL(savePoint);
			System.out.print(e.getMessage());
		} finally {
			DAO.Fechar();
		}
	}

	private static List<PacienteTO> consultar(String sql) {

		List<PacienteTO> l = new ArrayList<PacienteTO>();
		DAO.Conectar();
		try {
			sql += " ORDER BY NOME_PACIENTE ASC";
			ResultSet rs = DAO.NewStm().executeQuery(sql + ";");
			while (rs.next()) {

				PacienteTO c = new PacienteTO();

				c.ID_PACIENTE = rs.getInt("ID_PACIENTE");
				c.NOME_PACIENTE = rs.getString("NOME_PACIENTE");
				c.DT_NASCIMENTO = rs.getDate("DT_NASCIMENTO");
				c.CPF = rs.getString("CPF");
				c.RG = rs.getString("RG");
				c.SEXO = rs.getString("SEXO");

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
