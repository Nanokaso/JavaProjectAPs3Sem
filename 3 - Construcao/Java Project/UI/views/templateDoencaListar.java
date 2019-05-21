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
import TOs.TratamentoTO;
import TOs.UsuarioTO;
import models.IAction;

public class templateDoencaListar {
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
		int totalColunas = 12;
		appStart.Frame.frame.setLayout(new GridLayout(0, totalColunas));

		btnVoltar = new templateBase().BaseBtn;
		btnVoltar.setName("btnVoltar");
		btnVoltar.setText("Voltar");
		btnVoltar.addActionListener(action.getActionByIdElement("btnVoltar", action.acoes));
		appStart.Frame.frame.add(btnVoltar);

		for (int i = 0; i < totalColunas - 1; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("ID:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("NOME:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("DESCRICAO:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("SINTOMAS:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("MEDIA DIAS CURA:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("COMUM:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("TRATA COM VACINA:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("TRATADO POR PESSOA:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("PROPAGA FACIL:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("REQUER EXAME:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("GRAVE:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("TRATAMENTO:"));

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		int quantidadeRegistro = 0;
		try {
			List<DoencaTO> doencas = Negocio.Doenca.listarTodos();
			if (doencas != null) {

				quantidadeRegistro = doencas.size();
				for (DoencaTO obj : doencas) {

					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.ID_DOENCA + ""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.NOME_DOENCA + ""));
					
					JButton btnDs = new templateBase().BaseBtn;
					btnDs.setText("Clique aqui!");
					templateBase.setColorButton(btnDs, templateBase.enColorButton.Invisible);

					btnDs.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String texto = "\n \n---   "+obj.DESCRICAO.replace(",", "\n")+"    \n \n";							
							JOptionPane.showMessageDialog(null, texto);
						}
					});
					appStart.Frame.frame.add(btnDs);
					
					JButton btnS = new templateBase().BaseBtn;
					btnS.setText("Clique aqui!");
					templateBase.setColorButton(btnS, templateBase.enColorButton.Invisible);

					btnS.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String texto = "\n \n---   "+obj.SINTOMAS.replace(",", "\n")+"    \n \n";							
							JOptionPane.showMessageDialog(null, texto);
						}
					});
					appStart.Frame.frame.add(btnS);					
					
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.MEDIADIASCURA + ""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.FLG_COMUM ? "Sim" : "Não"));
					appStart.Frame.frame
							.add(new templateBase().basicTextLabelCenter(obj.FLG_TRATACOMVACINA ? "Sim" : "Não"));
					appStart.Frame.frame
							.add(new templateBase().basicTextLabelCenter(obj.FLG_TRATADOPORPESSOA ? "Sim" : "Não"));
					appStart.Frame.frame
							.add(new templateBase().basicTextLabelCenter(obj.FLG_PROPAGAFACIL ? "Sim" : "Não"));
					appStart.Frame.frame
							.add(new templateBase().basicTextLabelCenter(obj.FLG_REQUEREXAME ? "Sim" : "Não"));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(obj.FLG_GRAVE ? "Sim" : "Não"));

					// -----------

					JButton btn = new templateBase().BaseBtn;
					btn.setText("Clique aqui!");
					templateBase.setColorButton(btn, templateBase.enColorButton.Invisible);

					btn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String texto = "";

							if (obj.Tratamentos != null) {
								for (TratamentoTO trat : obj.Tratamentos) {
									texto += "\n     " + trat.DS_TIPOTRATAMENTO + " - " + trat.DS_TRATAMENTO
											+ "          ";
								}
							}
							JOptionPane.showMessageDialog(null, texto.replace(",", "\n"));
						}
					});
					appStart.Frame.frame.add(btn);

					// -----------

				}
			}
		} catch (Exception e) {
		}

		for (int i = 0; i < totalColunas * (5); i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

	}
}