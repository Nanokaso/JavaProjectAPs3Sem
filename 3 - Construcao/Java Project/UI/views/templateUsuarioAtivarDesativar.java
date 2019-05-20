package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.IAction;

public class templateUsuarioAtivarDesativar {
	public static JButton btnDesativar;
	public static JButton btnAtivar;
	public static JButton btnVoltar;
	public static JTextField txtLogin;
	
	public static void init(IAction action) {
		// setando layout

		appStart.Frame.frame.setLayout(new GridBagLayout());


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
		lblLogin.setText("Digite o login para ativar/desativar:");
		appStart.Frame.frame.add(lblLogin, gbc);		
		txtLogin = new templateBase().BaseTxt;
		txtLogin.setName("txtLogin");
		appStart.Frame.frame.add(txtLogin, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);	
		
		
		btnAtivar = new templateBase().BaseBtn;
		btnAtivar.setName("btnAtivar");
		templateBase.setColorButton(btnAtivar, templateBase.enColorButton.Success);
		btnAtivar.setText("Ativar");
		btnAtivar.addActionListener(action.getActionByIdElement("btnAtivar", action.acoes));
		appStart.Frame.frame.add(btnAtivar, gbc);	
		
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);	
		
		btnDesativar = new templateBase().BaseBtn;
		templateBase.setColorButton(btnDesativar, templateBase.enColorButton.Danger);
		btnDesativar.setName("btnDesativar");
		btnDesativar.setText("Desativar");
		btnDesativar.addActionListener(action.getActionByIdElement("btnDesativar", action.acoes));
		appStart.Frame.frame.add(btnDesativar, gbc);
		

	}
	
}
