package views;

import java.awt.*;

import javax.swing.*;

import models.IAction;
import models.IActionItem;

public class templateLogin {

	public static JButton btnLogar;
	public static JTextField txtLogin;
	public static JTextField txtSenha;

	public static void init(IAction action) {
		// setando layout

		appStart.Frame.frame.setLayout(new GridBagLayout());

		// tamanho pro login -> opcional
		appStart.Frame.SetNewSize(350, 450);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		btnLogar = new templateBase().BaseBtn;
		templateBase.setColorButton(btnLogar, templateBase.enColorButton.Primary);
		btnLogar.setName("btnLogar");
		btnLogar.setText("Logar");

		txtLogin = new templateBase().BaseTxt;
		txtLogin.setName("txtLogin");

		txtSenha = new templateBase().BaseTxtPass;
		txtSenha.setName("txtSenha");

		JLabel lblLogin = new templateBase().BaseLbl;
		lblLogin.setText("Login:");
		appStart.Frame.frame.add(lblLogin, gbc);

		appStart.Frame.frame.add(txtLogin, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);

		JLabel lblSenha = new templateBase().BaseLbl;
		lblSenha.setText("Senha:");
		appStart.Frame.frame.add(lblSenha, gbc);

		appStart.Frame.frame.add(txtSenha, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);

		for (IActionItem acao : action.acoes) {
			if ("btnLogar".contains(acao.idElement)) {
				btnLogar.addActionListener(acao.acao);
				appStart.Frame.frame.add(btnLogar, gbc);

			}
		}

	}
}
