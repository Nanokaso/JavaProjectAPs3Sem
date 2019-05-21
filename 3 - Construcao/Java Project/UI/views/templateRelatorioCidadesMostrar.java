package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import TOs.EnderecoTO;
import TOs.GenericTO;
import TOs.PacienteDoencaTO;
import TOs.UsuarioTO;
import models.IAction;

public class templateRelatorioCidadesMostrar {
	public static JButton btnVoltar;
	public static List<GenericTO<String, String>> cidadesToDoit;

	public static void init(IAction action) {
		// setando layout

		JPanel contentPanel = new JPanel();
		int emcimaBaixo = 5;
		int lados = 10;
		Border padding = BorderFactory.createEmptyBorder(emcimaBaixo, lados, emcimaBaixo, lados);
		contentPanel.setBorder(padding);
		contentPanel.setBackground(new Color(20, 30, 40));
		appStart.Frame.frame.setContentPane(contentPanel);
		int totalColunas = 2;
		appStart.Frame.frame.setLayout(new GridLayout(0, totalColunas));

		btnVoltar = new templateBase().BaseBtn;
		btnVoltar.setName("btnVoltar");
		btnVoltar.setText("Voltar");
		btnVoltar.addActionListener(action.getActionByIdElement("btnVoltar", action.acoes));
		appStart.Frame.frame.add(btnVoltar);

		for (int i = 0; i < totalColunas - 1; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// -----------------------------------------

		if (cidadesToDoit != null) {

			// 1 ou 2

			if (cidadesToDoit.size() == 1) {

				List<EnderecoTO> enderecos = new ArrayList<EnderecoTO>();
				for (GenericTO<String, String> genericTO : cidadesToDoit) {
					List<EnderecoTO> ends = Negocio.Endereco.consultar(genericTO.getT1(), genericTO.getT2(), 0);
					for (EnderecoTO enderecoTO : ends) {
						enderecos.add(enderecoTO);
					}
				}

				appStart.Frame.frame
						.add(new templateBase().basicTextLabelCenterMR(enderecos.size() + " endereços localizados!"));

				List<PacienteDoencaTO> pacientesD = new ArrayList<PacienteDoencaTO>();

				int qtdHomens = 0;
				int qtdMulheres = 0;
				int sum = 0;
				int pacSizes = 0;
				int mediaIdade = 0;
				for (EnderecoTO enderecoTO : enderecos) {

					List<PacienteDoencaTO> pac = Negocio.PacienteDoenca.consultar(0, 0, enderecoTO.ID_ENDERECO, false);
					if (pac != null) {
						for (PacienteDoencaTO pacienteDoencaTO : pac) {
							pacientesD.add(pacienteDoencaTO);
							int Idade = LocalDate.now().getYear()
									- (Integer.parseInt((pacienteDoencaTO.PACIENTE.DT_NASCIMENTO + "").split("-")[0]));
							sum += Idade;
							pacSizes++;
							if (pacienteDoencaTO.PACIENTE.SEXO.equals("M")) {
								qtdHomens++;
							} else {
								qtdMulheres++;
							}
						}
					}
				}

				mediaIdade = sum / pacSizes;

				appStart.Frame.frame
						.add(new templateBase().basicTextLabelCenterMR(pacientesD.size() + " pacientes localizados!"));

				List<PacienteDoencaTO> pacientesTodos = Negocio.PacienteDoenca.listarTodos();
				appStart.Frame.frame
						.add(new templateBase().basicTextLabelCenterMR(pacientesTodos.size() + " pacientes total!"));

				int per = (100 * pacientesD.size()) / pacientesTodos.size();

				appStart.Frame.frame
						.add(new templateBase().basicTextLabelCenterMR(per + "% dos infectados na cidade!"));

				appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(qtdHomens + " Homens na cidade!"));
				appStart.Frame.frame
						.add(new templateBase().basicTextLabelCenterMR(qtdMulheres + " Mulheres na cidade!"));

				appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(mediaIdade + " Idade média!"));

			}

			if (cidadesToDoit.size() == 2) {

				List<EnderecoTO> enderecosCidade1 = Negocio.Endereco.consultar(cidadesToDoit.get(0).getT1(),
						cidadesToDoit.get(0).getT2(), 0);

				List<EnderecoTO> enderecosCidade2 = Negocio.Endereco.consultar(cidadesToDoit.get(1).getT1(),
						cidadesToDoit.get(1).getT2(), 0);

				appStart.Frame.frame.add(new templateBase()
						.basicTextLabelCenterMR(enderecosCidade1.size() + " endereços na 1º cidade!"));
				appStart.Frame.frame.add(new templateBase()
						.basicTextLabelCenterMR(enderecosCidade2.size() + " endereços na 2º cidade!"));

				// cidade 1
				{
					List<PacienteDoencaTO> pacientes1 = new ArrayList<PacienteDoencaTO>();
					List<PacienteDoencaTO> pacientes2 = new ArrayList<PacienteDoencaTO>();

					int qtdHomens1 = 0;
					int qtdMulheres1 = 0;
					int sum1 = 0;
					int pacSizes1 = 0;
					int mediaIdade1 = 0;
					for (EnderecoTO enderecoTO : enderecosCidade1) {
						List<PacienteDoencaTO> pac = Negocio.PacienteDoenca.consultar(0, 0, enderecoTO.ID_ENDERECO,
								false);
						if (pac != null) {
							for (PacienteDoencaTO pacienteDoencaTO : pac) {
								pacientes1.add(pacienteDoencaTO);
								int Idade = LocalDate.now().getYear() - (Integer
										.parseInt((pacienteDoencaTO.PACIENTE.DT_NASCIMENTO + "").split("-")[0]));
								sum1 += Idade;
								pacSizes1++;
								if (pacienteDoencaTO.PACIENTE.SEXO.equals("M")) {
									qtdHomens1++;
								} else {
									qtdMulheres1++;
								}
							}
						}
					}

					mediaIdade1 = sum1 / pacSizes1;

					int qtdHomens2 = 0;
					int qtdMulheres2 = 0;
					int sum2 = 0;
					int pacSizes2 = 0;
					int mediaIdade2 = 0;

					for (EnderecoTO enderecoTO : enderecosCidade2) {
						List<PacienteDoencaTO> pac = Negocio.PacienteDoenca.consultar(0, 0, enderecoTO.ID_ENDERECO,
								false);
						if (pac != null) {
							for (PacienteDoencaTO pacienteDoencaTO : pac) {
								pacientes2.add(pacienteDoencaTO);
								int Idade = LocalDate.now().getYear() - (Integer
										.parseInt((pacienteDoencaTO.PACIENTE.DT_NASCIMENTO + "").split("-")[0]));
								sum2 += Idade;
								pacSizes2++;
								if (pacienteDoencaTO.PACIENTE.SEXO.equals("M")) {
									qtdHomens2++;
								} else {
									qtdMulheres2++;
								}
							}
						}
					}
					mediaIdade2 = sum2 / pacSizes2;

					appStart.Frame.frame.add(new templateBase()
							.basicTextLabelCenterMR(pacientes1.size() + " pacientes localizados! 1º Cidade"));
					
					appStart.Frame.frame.add(new templateBase()
							.basicTextLabelCenterMR(pacientes2.size() + " pacientes localizados! 2º Cidade"));

					List<PacienteDoencaTO> pacientesTodos = Negocio.PacienteDoenca.listarTodos();

					int per1 = (100 * pacientes1.size()) / pacientesTodos.size();
					int per2 = (100 * pacientes2.size()) / pacientesTodos.size();

					appStart.Frame.frame
							.add(new templateBase().basicTextLabelCenterMR(per1 + "% dos infectados na 1º cidade!"));
					
					appStart.Frame.frame
					.add(new templateBase().basicTextLabelCenterMR(per2 + "% dos infectados na 2º cidade!"));

					appStart.Frame.frame
							.add(new templateBase().basicTextLabelCenterMR(qtdHomens1 + " Homens na 1º cidade!"));
					
					appStart.Frame.frame
					.add(new templateBase().basicTextLabelCenterMR(qtdHomens2 + " Homens na 2º cidade!"));
					
					appStart.Frame.frame
							.add(new templateBase().basicTextLabelCenterMR(qtdMulheres1 + " Mulheres na 1º cidade!"));
					
					appStart.Frame.frame
					.add(new templateBase().basicTextLabelCenterMR(qtdMulheres2 + " Mulheres na 2º cidade!"));

					appStart.Frame.frame
							.add(new templateBase().basicTextLabelCenterMR(mediaIdade1 + " Idade média! 1º Cidade"));
					
					appStart.Frame.frame
					.add(new templateBase().basicTextLabelCenterMR(mediaIdade2 + " Idade média! 2º Cidade"));

				}				

				List<PacienteDoencaTO> pacientesTodos2 = Negocio.PacienteDoenca.listarTodos();
				appStart.Frame.frame
						.add(new templateBase().basicTextLabelCenterMR(pacientesTodos2.size() + " pacientes total!"));
			}

		} else {
			// todas
			
			int qtdUsuarioDes = 0;
			try {
			    qtdUsuarioDes = Negocio.Acesso.listar(false).size();
			} catch (Exception e) {
			}

			appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(qtdUsuarioDes + "<br/> Usuarios cadastrados"));

			int qtdUsuario = 0;
			try {
			    qtdUsuario = Negocio.Acesso.listar(true).size();
			} catch (Exception e) {
			}

			appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(qtdUsuario + "<br/> Usuarios Ativos"));

			int qtdDoencas = 0;
			try {
			    qtdDoencas = Negocio.Doenca.listarTodos().size();
			} catch (Exception e) {
			}

			appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(qtdDoencas + "<br/> Doenças"));

			int qtdPacientes = 0;
			try {
			    qtdPacientes = Negocio.Paciente.listarTodos().size();
			} catch (Exception e) {
			}

			appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(qtdPacientes + "<br/> Pacientes"));

			int qtdInfectados = 0;
			try {
			    qtdInfectados = Negocio.PacienteDoenca.listarTodos().size();
			} catch (Exception e) {

			}

			appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(qtdInfectados + "<br/> Historico Doentes"));

			int qtdMortos = 0;
			try {
			    qtdMortos = Negocio.PacienteDoenca.consultar(0, 0, 0, true).size();
			} catch (Exception e) {
			}

			appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(qtdMortos + "<br/> Falecidos"));

			int qtdCidades = 0;
			try {
			    qtdCidades = Negocio.Endereco.getCidadesUF().size();
			} catch (Exception e) {
			    System.err.println(e.getMessage());
			}

			appStart.Frame.frame.add(new templateBase().basicTextLabelCenterMR(qtdCidades + "<br/> Cidades<br/>Registradas"));

		}

		// -----------------------------------------

		for (int i = 0; i < totalColunas * (2); i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

	}
}