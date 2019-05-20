package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Negocio.Endereco;
import Negocio.PacienteDoenca;
import TOs.DoencaTO;
import TOs.EnderecoTO;
import TOs.PacienteDoencaTO;
import TOs.PacienteTO;
import models.IAction;
import models.IActionItem;

public class PacienteDoencaAdicionar extends BaseController {
	public void Index() {

		List<IActionItem> itens = new ArrayList<IActionItem>();
		itens.add(new IActionItem("btnVoltar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Dashboard().Index();
			}
		}));
		itens.add(new IActionItem("btnAdicionar", new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				String idDoenca = views.templatePacienteDoencaAdicionar.txtIdDoenca.getText();
				String cPFPaciente = views.templatePacienteDoencaAdicionar.txtCPFPaciente.getText();
				String idEndereco = views.templatePacienteDoencaAdicionar.txtIdEndereco.getText();
				String dtInicio = views.templatePacienteDoencaAdicionar.txtDtInicio.getText();
				String dtTermino = views.templatePacienteDoencaAdicionar.txtDtTermino.getText();
				String flgMedicado = views.templatePacienteDoencaAdicionar.txtFlgMedicado.getText();
				String flgFalecido = views.templatePacienteDoencaAdicionar.txtFlgFalecido.getText();
				String dtObito = views.templatePacienteDoencaAdicionar.txtDtObito.getText();

				try {

					if (idDoenca.isBlank() || cPFPaciente.isBlank() || idEndereco.isBlank() || dtInicio.isBlank()
							|| dtTermino.isBlank() || flgMedicado.isBlank() || flgFalecido.isBlank()) {
						throw new Exception("Um ou mais campos vazios!");
					}

					Date dtIni = new Date();
					try {
						String[] data = dtInicio.split("/");
						dtIni = new Date(Integer.parseInt(data[2]), Integer.parseInt(data[1]),
								Integer.parseInt(data[0]));
					} catch (Exception e3) {
						throw new Exception("Data Inicio invalida!");
					}
					Date dtTer = new Date();
					try {
						String[] data = dtTermino.split("/");
						dtTer = new Date(Integer.parseInt(data[2]), Integer.parseInt(data[1]),
								Integer.parseInt(data[0]));
					} catch (Exception e3) {
						throw new Exception("Data Termino invalida!");
					}
					Date dtObi = new Date();
					try {
						if (!dtObito.isBlank()) {
							String[] data = dtObito.split("/");
							dtObi = new Date(Integer.parseInt(data[2]), Integer.parseInt(data[1]),
									Integer.parseInt(data[0]));
							flgFalecido = "1";
						} else {
							dtObi = null;
						}

					} catch (Exception e3) {
						throw new Exception("Data Obito invalida!");
					}

					DoencaTO doenca = null;
					{
						doenca = Negocio.Doenca.consultar(Integer.parseInt(idDoenca));
						if (doenca == null) {
							throw new Exception("Registro de Doenca não localizado!");
						}
					}
					PacienteTO paciente = null;
					{
						paciente = Negocio.Paciente.consultarByCPF(cPFPaciente);
						if (paciente == null) {
							throw new Exception("Registro de Paciente não localizado!");
						}
					}
					EnderecoTO endereco = null;
					{
						endereco = Negocio.Endereco.consultar(Integer.parseInt(idEndereco));
						if (endereco == null) {
							throw new Exception("Registro de Endereco não localizado!");
						}
					}

					try {

						PacienteDoencaTO pac = new PacienteDoencaTO();
						pac.DOENCA = doenca;
						pac.PACIENTE = paciente;
						pac.ENDERECO = endereco;
						pac.DT_INICIO = dtIni;
						pac.DT_TERMINO = dtTer;
						pac.FLG_MEDICADO = Integer.parseInt(flgMedicado) == 1 ? true: false;
						pac.FLG_FALECIDO = Integer.parseInt(flgFalecido) == 1 ? true: false;
						pac.DT_OBITO = dtObi;
						PacienteDoenca.incluir(pac);
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

					} catch (Exception e1) {
						throw new Exception("Erro ao adicionar registro! Verifique os campos e tente novamente!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		}));
		super.GenerateView(new IAction(this.getClass(), itens));
	}
}