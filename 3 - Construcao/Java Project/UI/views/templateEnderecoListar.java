package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import TOs.EnderecoTO;
import TOs.PacienteTO;
import models.IAction;

public class templateEnderecoListar {
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
		int totalColunas = 8;
		appStart.Frame.frame.setLayout(new GridLayout(0, totalColunas));

		btnVoltar = new templateBase().BaseBtn;
		btnVoltar.setName("btnVoltar");
		btnVoltar.setText("Voltar");
		btnVoltar.addActionListener(action.getActionByIdElement("btnVoltar", action.acoes));
		appStart.Frame.frame.add(btnVoltar);

		for (int i = 0; i < totalColunas - 1; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("ID ENDERECO:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("ENDERECO:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("BAIRRO:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("NUMERO:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("CEP:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("COMPLEMENTO:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("CIDADE:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("UF:"));

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		int quantidadeRegistro = 0;
		try {
			
			List<EnderecoTO> listagem = Negocio.Endereco.listarTodos();	
			
			if (listagem != null) {

				quantidadeRegistro = listagem.size();
				for (EnderecoTO obj : listagem) {
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.ID_ENDERECO+""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.ENDERECO+""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.BAIRRO+""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.NUMERO+""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.CEP+""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.COMPLEMENTO+""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.CIDADE+""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.UF+""));
				}
			}
		} catch (Exception e) {
		}

		for (int i = 0; i < totalColunas * (15 - quantidadeRegistro); i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

	}
}