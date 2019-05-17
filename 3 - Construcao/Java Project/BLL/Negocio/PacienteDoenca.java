package Negocio;

import conexao.DAO;
import TOs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDoenca {

	public static List<PacienteDoencaTO> listarTodos() throws Exception {
		List<PacienteDoencaTO> u = null;
		String sql = "SELECT * FROM PACIENTE_DOENCA ";
		List<PacienteDoencaTO> r = consultar(sql);
		if (r != null) {
			u = r;
		} else {
			throw new Exception("Nenhum paciente doenca localizado!");
		}
		return u;
	}

	public static List<PacienteDoencaTO> consultar(int IdDoenca, int IdPaciente, int IdEndereco, boolean onlyFalecidos) throws Exception {
		List<PacienteDoencaTO> u = null;
		String sql = "SELECT * FROM PACIENTE_DOENCA " + "WHERE 1=1 ";
		if (IdDoenca > 0) {
			sql += " AND Id_Doenca = @IdDoenca";
			sql = DAO.format(sql, "IdDoenca", IdDoenca);
		}

		if (IdPaciente > 0) {
			sql += " AND Id_Paciente = @IdPaciente";
			sql = DAO.format(sql, "IdPaciente", IdPaciente);
		}

		if (IdEndereco > 0) {
			sql += " AND Id_Endereco = @IdEndereco";
			sql = DAO.format(sql, "IdEndereco", IdEndereco);
		}
		if(onlyFalecidos)
		{
			sql += " AND FLG_FALECIDO = @Falecido";
			sql = DAO.format(sql, "Falecido", onlyFalecidos);
		}

		List<PacienteDoencaTO> r = consultar(sql);
		if (r != null) {
			u = r;
		} else {
			throw new Exception("Nenhum paciente doenca localizado!");
		}
		return u;
	}

	private static List<PacienteDoencaTO> consultar(String sql) {

		List<PacienteDoencaTO> l = new ArrayList<PacienteDoencaTO>();
		DAO.Conectar();
		try {
			sql += " ";
			ResultSet rs = DAO.NewStm().executeQuery(sql + ";");
			while (rs.next()) {

				PacienteDoencaTO c = new PacienteDoencaTO();
				c.ID_PACIENTEDOENCA = rs.getInt("ID_PACIENTEDOENCA");
				c.DT_INICIO = rs.getDate("DT_INICIO");
				c.DT_TERMINO = rs.getDate("DT_TERMINO");
				c.FLG_MEDICADO = rs.getBoolean("FLG_MEDICADO");
				c.FLG_FALECIDO = rs.getBoolean("FLG_FALECIDO");
				c.DT_OBITO = rs.getDate("DT_OBITO");

				c.ENDERECO = new EnderecoTO();
				c.ENDERECO.ID_ENDERECO = rs.getInt("ID_ENDERECO");
				c.DOENCA = new DoencaTO();
				c.DOENCA.ID_DOENCA = rs.getInt("ID_DOENCA");
				c.PACIENTE = new PacienteTO();
				c.PACIENTE.ID_PACIENTE = rs.getInt("ID_PACIENTE");
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
			for (PacienteDoencaTO pacienteDoencaTO : l) {

				try {
					pacienteDoencaTO.DOENCA = Doenca.consultar(pacienteDoencaTO.DOENCA.ID_DOENCA);
				} catch (Exception e) {
				}

				try {
					pacienteDoencaTO.PACIENTE = Paciente.consultar(pacienteDoencaTO.PACIENTE.ID_PACIENTE);
				} catch (Exception e) {
				}

				try {
					pacienteDoencaTO.ENDERECO = Endereco.consultar(pacienteDoencaTO.ENDERECO.ID_ENDERECO);
				} catch (Exception e) {
				}
			}
			return l;
		}
	}

}
