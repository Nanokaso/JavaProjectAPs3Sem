package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import TOs.UsuarioTO;
import models.IAction;

public class templateUsuarioListar {
	public static JButton btnVoltar;

	public static void init(IAction action) {
		// setando layout

		JPanel contentPanel = new JPanel();
		int emcimaBaixo = 5;
		int lados = 10;
		Border padding = BorderFactory.createEmptyBorder(emcimaBaixo, lados, emcimaBaixo, lados);
		contentPanel.setBorder(padding);
		contentPanel.setBackground(new Color(20, 30, 40));
		appStart.Frame.frame.setContentPane(contentPanel);
		int totalColunas = 4;
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
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("LOGIN:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("SENHA:"));
		appStart.Frame.frame.add(new templateBase().basicTextLabelCenter("ATIVO:"));
		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}
		int quantidadeRegistro =0;
		try {
			List<UsuarioTO> usuarios = Negocio.Acesso.listar(false);
			if (usuarios != null) {

				quantidadeRegistro = usuarios.size();
				for (UsuarioTO usu : usuarios) {
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(usu.ID_USUARIO + ""));
					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(usu.LOGIN + ""));

					JButton btn = new templateBase().BaseBtn;
					btn.setText("Clique aqui para ver!");
					templateBase.setColorButton(btn, templateBase.enColorButton.Invisible);
					btn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, ">>>   " + usu.SENHA + "");

						}
					});
					appStart.Frame.frame.add(btn);
					// appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(usu.SENHA +
					// ""));

					appStart.Frame.frame.add(new templateBase().basicTextLabelCenter(usu.FLG_ATIVO ? "Sim" : "Não"));
				}
			}
		} catch (Exception e) {
		}

		for (int i = 0; i < totalColunas * (15 - quantidadeRegistro); i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

	}
}
