package Negocio;

import conexao.DAO;
import TOs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
	
	private static List<PacienteTO> consultar(String sql) {

		List<PacienteTO> l = new ArrayList<PacienteTO>();
		DAO.Conectar();
		try {
			ResultSet rs = DAO.NewStm().executeQuery(sql);
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
