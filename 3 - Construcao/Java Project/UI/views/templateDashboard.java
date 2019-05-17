package views;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import models.IAction;
import models.IActionItem;
import models.UsuarioAtual;

public class templateDashboard {

	public static JButton btnSair;
	public static JButton btnAddUsuario;
	public static JButton btnDesativarUsuario;
	public static JButton btnAddPaciente;
	public static JButton btnListarPaciente;
	public static JButton btnListarDoencas;

	public static void init(IAction action) {

		// setando layout
		JPanel contentPanel = new JPanel();
		int emcimaBaixo = 60;
		int lados = 60;
		Border padding = BorderFactory.createEmptyBorder(emcimaBaixo, lados, emcimaBaixo, lados);
		contentPanel.setBorder(padding);
		appStart.Frame.frame.setContentPane(contentPanel);
		int totalColunas = 6;
		appStart.Frame.frame.setLayout(new GridLayout(0, totalColunas));

		for (int i = 0; i < totalColunas - 2; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		JLabel lblsaud = new templateBase().BaseLblTextCenter;
		lblsaud.setText("Ola! " + UsuarioAtual.usuario.LOGIN);
		appStart.Frame.frame.add(lblsaud);

		btnSair = new templateBase().BaseBtnMargin;
		btnSair.setName("btnSair");
		btnSair.setText("Sair");
		btnSair.setToolTipText("Voltar para login");
		addActionIfExists(action, "btnSair", btnSair);
		appStart.Frame.frame.add(btnSair);

		// pula uma linha inteira
		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		int qtdUsuario = 0;
		try {
			qtdUsuario = Negocio.Acesso.listar().size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel lbl1 = new templateBase().BaseLblTextCenter;
		lbl1.setText(appStart.UtilsString.setText(qtdUsuario + "<br/> Usuarios"));
		appStart.Frame.frame.add(lbl1);

		int qtdDoencas = 0;
		try {
			qtdDoencas = Negocio.Doenca.listarTodos().size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel lbl2 = new templateBase().BaseLblTextCenter;
		lbl2.setText(appStart.UtilsString.setText(qtdDoencas + "<br/> Doenças"));
		appStart.Frame.frame.add(lbl2);

		int qtdPacientes = 0;
		try {
			qtdPacientes = Negocio.Paciente.listarTodos().size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel lbl3 = new templateBase().BaseLblTextCenter;
		lbl3.setText(appStart.UtilsString.setText(qtdPacientes + "<br/> Pacientes"));
		appStart.Frame.frame.add(lbl3);

		int qtdInfectados = 0;
		try {
			qtdInfectados = Negocio.PacienteDoenca.listarTodos().size();
		} catch (Exception e) {

		}
		JLabel lbl4 = new templateBase().BaseLblTextCenter;
		lbl4.setText(appStart.UtilsString.setText(qtdInfectados + "<br/> Historico Doentes"));
		appStart.Frame.frame.add(lbl4);

		int qtdMortos = 0;
		try {
			qtdMortos = Negocio.PacienteDoenca.consultar(0, 0, 0, true).size();
		} catch (Exception e) {			
		}
		JLabel lbl5 = new templateBase().BaseLblTextCenter;
		lbl5.setText(appStart.UtilsString.setText(qtdMortos + "<br/> Falecidos"));
		appStart.Frame.frame.add(lbl5);

		int qtdCidades = 0;
		try {
			qtdCidades = Negocio.Endereco.getCidadesUF().size();
		} catch (Exception e) {		
			System.err.println(e.getMessage());
		}
		JLabel lbl6 = new templateBase().BaseLblTextCenter;
		lbl6.setText(appStart.UtilsString.setText(qtdCidades + "<br/> Cidades<br/>Registradas"));
		appStart.Frame.frame.add(lbl6);

		// pula uma linha inteira
		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		btnAddUsuario = new templateBase().BaseBtn;
		btnAddUsuario.setName("btnAddUsuario");
		btnAddUsuario.setText("Adicionar Usuario");
		btnAddUsuario.setToolTipText("");
		addActionIfExists(action, "btnAddUsuario", btnAddUsuario);
		appStart.Frame.frame.add(btnAddUsuario);
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		btnDesativarUsuario = new templateBase().BaseBtn;
		btnDesativarUsuario.setName("btnDesativarUsuario");
		btnDesativarUsuario.setText("Desativar Usuario");
		btnDesativarUsuario.setToolTipText("");
		addActionIfExists(action, "btnDesativarUsuario", btnDesativarUsuario);
		appStart.Frame.frame.add(btnDesativarUsuario);
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		appStart.Frame.frame.add(new templateBase().BaseEspace);
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// pula uma linha inteira
		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		btnAddPaciente = new templateBase().BaseBtn;
		btnAddPaciente.setName("btnAddPaciente");
		btnAddPaciente.setText("Adicionar Paciente");
		btnAddPaciente.setToolTipText("");
		addActionIfExists(action, "btnAddPaciente", btnAddPaciente);
		appStart.Frame.frame.add(btnAddPaciente);
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		btnListarPaciente = new templateBase().BaseBtn;
		btnListarPaciente.setName("btnListarPaciente");
		btnListarPaciente.setText("Listar Pacientes");
		btnListarPaciente.setToolTipText("");
		addActionIfExists(action, "btnListarPaciente", btnListarPaciente);
		appStart.Frame.frame.add(btnListarPaciente);
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		btnListarDoencas = new templateBase().BaseBtn;
		btnListarDoencas.setName("btnListarDoencas");
		btnListarDoencas.setText("Listar Doencas");
		btnListarDoencas.setToolTipText("");
		addActionIfExists(action, "btnListarDoencas", btnListarDoencas);
		appStart.Frame.frame.add(btnListarDoencas);
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		for (IActionItem acao : action.acoes) {
			if ("btnLogar".contains(acao.idElement)) {

			}
		}

		for (int i = 0; i < 30; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

	}

	public static void addActionIfExists(IAction action, String idElement, JButton element) {
		for (IActionItem acao : action.acoes) {
			if (idElement.contains(acao.idElement)) {
				element.addActionListener(acao.acao);
			}
		}
	}
}
