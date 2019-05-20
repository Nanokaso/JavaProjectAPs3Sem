package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import TOs.DoencaTO;
import TOs.PacienteTO;
import TOs.TratamentoTO;
import models.IAction;

public class templatePacienteListar {
	public static JButton btnVoltar;

	public static void init(IAction action) {
		// setando layout

		JPanel contentPanel = new JPanel();
		int emcimaBaixo = 5;
		int lados = 0;
		Border padding = BorderFactory.createEmptyBorder(emcimaBaixo, lados, emcimaBaixo, lados);
		contentPanel.setBorder(padding);
		contentPanel.setBackground(new Color(20, 30, 40));
		appStart.Frame.frame.setContentPane(contentPanel);
		int totalColunas = 6;
		appStart.Frame.frame.setLayout(new GridLayout(0, totalColunas));

		btnVoltar = new templateBase().BaseBtn;
		btnVoltar.setName("btnVoltar");
		btnVoltar.setText("Voltar");
		btnVoltar.addActionListener(action.getActionByIdElement("btnVoltar", action.acoes));
		appStart.Frame.frame.add(btnVoltar);

		for (int i = 0; i < totalColunas - 1; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("ID PACIENTE:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("NOME PACIENTE:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("DT NASCIMENTO:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("CPF:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("RG:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("SEXO:"));

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		int quantidadeRegistro = 0;
		try {
			
			List<PacienteTO> listagem = Negocio.Paciente.listarTodos();	
			
			if (listagem != null) {

				quantidadeRegistro = listagem.size();
				for (PacienteTO obj : listagem) {

					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.ID_PACIENTE+ ""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.NOME_PACIENTE+ ""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.DT_NASCIMENTO+ ""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.CPF+ ""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.RG+ ""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.SEXO+ "")); 

				}
			}
		} catch (Exception e) {
		}

		for (int i = 0; i < totalColunas * (15 - quantidadeRegistro); i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

	}
}