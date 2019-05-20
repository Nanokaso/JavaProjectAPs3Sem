package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.IAction;

public class templateUsuarioAdicionar {
	public static JButton btnAdicionar;
	public static JButton btnVoltar;
	public static JTextField txtLogin;
	public static JTextField txtSenha;
	public static JTextField txtSenha2;
	
	public static void init(IAction action) {
		// setando layout

		appStart.Frame.frame.setLayout(new GridBagLayout());

		// tamanho pra page -> opcional
		//appStart.Frame.SetNewSize(400, 500);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		btnVoltar = new templateBase().BaseBtn;
		btnVoltar.setName("btnVoltar");
		btnVoltar.setText("Voltar");
		btnVoltar.addActionListener(action.getActionByIdElement("btnVoltar", action.acoes));
		appStart.Frame.frame.add(btnVoltar, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);	
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);	

		JLabel lblLogin = new templateBase().BaseLbl;
		lblLogin.setText("Login:");
		appStart.Frame.frame.add(lblLogin, gbc);		
		txtLogin = new templateBase().BaseTxt;
		txtLogin.setName("txtLogin");
		appStart.Frame.frame.add(txtLogin, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);	
		

		JLabel lblSenha = new templateBase().BaseLbl;
		lblSenha.setText("Senha:");
		appStart.Frame.frame.add(lblSenha, gbc);
		txtSenha = new templateBase().BaseTxtPass;
		txtSenha.setName("txtSenha");
		appStart.Frame.frame.add(txtSenha, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);	
		
		JLabel lblSenha2 = new templateBase().BaseLbl;
		lblSenha2.setText("Confirme a Senha:");
		appStart.Frame.frame.add(lblSenha2, gbc);
		txtSenha2 = new templateBase().BaseTxtPass;
		txtSenha2.setName("txtSenha2");
		appStart.Frame.frame.add(txtSenha2, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);	
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);	
		
		btnAdicionar = new templateBase().BaseBtn;
		templateBase.setColorButton(btnAdicionar, templateBase.enColorButton.Success);
		btnAdicionar.setName("btnAdicionar");
		btnAdicionar.setText("Adicionar");
		btnAdicionar.addActionListener(action.getActionByIdElement("btnAdicionar", action.acoes));
		appStart.Frame.frame.add(btnAdicionar, gbc);
		

	}
}
