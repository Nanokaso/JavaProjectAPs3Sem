package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import TOs.GenericTO;
import TOs.UsuarioTO;
import controllers.RelatorioCidadesMostrar;
import models.IAction;

public class templateRelatorioCidades {
	public static JButton btnVoltar;
	public static JButton btnContinuar;
	public static int qtdCidades;

	public static void init(IAction action) {
		// setando layout

		JPanel contentPanel = new JPanel();
		int emcimaBaixo = 10;
		int lados = 50;
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

		for (int i = 0; i < totalColunas - 2; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		btnContinuar = new templateBase().BaseBtn;
		btnContinuar.setName("btnContinuar");
		templateBase.setColorButton(btnContinuar, templateBase.enColorButton.Success);
		btnContinuar.setText("Continuar");
		btnContinuar.addActionListener(action.getActionByIdElement("btnContinuar", action.acoes));
		appStart.Frame.frame.add(btnContinuar);

		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("Escolha a(s) cidade(s):"));

		// pula uma linha
		for (int i = 0; i < totalColunas - 1; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// ---------------------------

		List<String> cidadesListaClick = new ArrayList<String>();
		List<JButton> botoes = new ArrayList<JButton>();

		int quantidadeRegistro = 0;
		String separate = "-------";
		try {

			List<GenericTO<String, String>> cidades = Negocio.Endereco.getCidadesUF();
			if (cidades != null && cidades.size() > 0) {

				quantidadeRegistro = cidades.size();
				for (GenericTO<String, String> cid : cidades) {

					JButton btn = new templateBase().BaseBtn;
					templateBase.setColorButton(btn, templateBase.enColorButton.Secondary);

					btn.setName(cid.getT1() + separate + cid.getT2());
					btn.setActionCommand(cid.getT1() + separate + cid.getT2());
					btn.setText(cid.getT1() + " " + cid.getT2());
					btn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton button = (JButton) e.getSource();
							String command = button.getActionCommand();

							if (templateRelatorioCidades.qtdCidades == 1) {
								cidadesListaClick.clear();
								for (JButton b : botoes) {
									templateBase.setColorButton(b, templateBase.enColorButton.Secondary);
								}
								cidadesListaClick.add(command);

								templateBase.setColorButton(button, templateBase.enColorButton.Info);
							}
							if (templateRelatorioCidades.qtdCidades == 2) {

								if (cidadesListaClick.size() < 2) {
									cidadesListaClick.add(command);
								}else
								{
									cidadesListaClick.remove(0);
									cidadesListaClick.add(command);
								}
								
								// muda as cores vizualmentes
								for (JButton b : botoes) {
									templateBase.setColorButton(b, templateBase.enColorButton.Secondary);
									
									for (String s : cidadesListaClick) {
										
										if(b.getActionCommand().equals(s))
										{
											templateBase.setColorButton(b, templateBase.enColorButton.Info);											
										}
									}
								}

							}
						}
					});

					botoes.add(btn);
					appStart.Frame.frame.add(btn);
					appStart.Frame.frame.add(new templateBase().BaseEspace);										
				}

			}
			
			btnContinuar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (cidadesListaClick.size() < templateRelatorioCidades.qtdCidades)
					{
						JOptionPane.showMessageDialog(null, "Quantidade de cidades inválida!");
					}
					else
					{
						List<GenericTO<String, String>> cidadesToDoit = new ArrayList<GenericTO<String, String>>();
						
						for (String s : cidadesListaClick) {									
							String[] sa = s.split(separate);									
							cidadesToDoit.add(new GenericTO<String, String>().SetAll(sa[0], sa[1]));
						}						
						new RelatorioCidadesMostrar().Index(cidadesToDoit);						
					}
				}
			});

		} catch (Exception e) {

		}

		for (int i = 0; i < totalColunas * (15 - quantidadeRegistro); i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

	}

}