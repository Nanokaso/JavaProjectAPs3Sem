package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.IAction;

public class templatePacienteAdicionar {
	public static JButton btnAdicionar;
	public static JButton btnVoltar;
	public static JTextField txtNome;
	public static JTextField txtDt;
	public static JTextField txtCPF;
	public static JTextField txtRG;
	public static JTextField txtSexo;
	
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

		JLabel lblNome = new templateBase().BaseLbl;
		lblNome.setText("Nome:");
		appStart.Frame.frame.add(lblNome, gbc);		
		txtNome = new templateBase().BaseTxt;
		txtNome.setName("txtNome");
		appStart.Frame.frame.add(txtNome, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);
		
		JLabel lbldt = new templateBase().BaseLbl;
		lbldt.setText("Dt Nascimento (dd/mm/yyyy):");
		appStart.Frame.frame.add(lbldt, gbc);		
		txtDt = new templateBase().BaseTxt;
		txtDt.setName("txtDt");
		appStart.Frame.frame.add(txtDt, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);
		
		JLabel lblcpf = new templateBase().BaseLbl;
		lblcpf.setText("CPF:");
		appStart.Frame.frame.add(lblcpf, gbc);		
		txtCPF = new templateBase().BaseTxt;
		txtCPF.setName("txtCPF");
		appStart.Frame.frame.add(txtCPF, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);
		
		JLabel lblrg = new templateBase().BaseLbl;
		lblrg.setText("RG:");
		appStart.Frame.frame.add(lblrg, gbc);		
		txtRG = new templateBase().BaseTxt;
		txtRG.setName("txtRG");
		appStart.Frame.frame.add(txtRG, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);
		
		JLabel lblsexo = new templateBase().BaseLbl;
		lblsexo.setText("Sexo (M/F):");
		appStart.Frame.frame.add(lblsexo, gbc);		
		txtSexo = new templateBase().BaseTxt;
		txtSexo.setName("txtSexo");
		appStart.Frame.frame.add(txtSexo, gbc);
		appStart.Frame.frame.add(new templateBase().BaseEspace, gbc);
		
		btnAdicionar = new templateBase().BaseBtn;
		templateBase.setColorButton(btnAdicionar, templateBase.enColorButton.Success);
		btnAdicionar.setName("btnAdicionar");
		btnAdicionar.setText("Adicionar");
		btnAdicionar.addActionListener(action.getActionByIdElement("btnAdicionar", action.acoes));
		appStart.Frame.frame.add(btnAdicionar, gbc);
		

	}
}
