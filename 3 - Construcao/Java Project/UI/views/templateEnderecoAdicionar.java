package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import models.IAction;

public class templateEnderecoAdicionar {
	public static JButton btnAdicionar;
	public static JButton btnVoltar;
	public static JTextField txtENDERECO;
	public static JTextField txtBAIRRO;
	public static JTextField txtNUMERO;
	public static JTextField txtCEP;
	public static JTextField txtCOMPLEMENTO;
	public static JTextField txtCIDADE;
	public static JTextField txtUF;

	public static void init(IAction action) {
		// setando layout

		// tamanho pra page -> opcional
		// appStart.Frame.SetNewSize(400, 500);

		// appStart.Frame.frame.setLayout(new GridBagLayout());
		// GridBagConstraints gbc = new GridBagConstraints();
		// gbc.gridwidth = GridBagConstraints.REMAINDER;
		// gbc.fill = GridBagConstraints.HORIZONTAL;

		JPanel contentPanel = new JPanel();
		int emcimaBaixo = 5;
		int lados = 5;
		Border padding = BorderFactory.createEmptyBorder(emcimaBaixo, lados, emcimaBaixo, lados);
		contentPanel.setBorder(padding);
		contentPanel.setBackground(new Color(20, 30, 40));
		appStart.Frame.frame.setContentPane(contentPanel);
		int totalColunas = 5;
		appStart.Frame.frame.setLayout(new GridLayout(0, totalColunas));

		btnVoltar = new templateBase().BaseBtn;
		btnVoltar.setName("btnVoltar");
		btnVoltar.setText("Voltar");
		btnVoltar.addActionListener(action.getActionByIdElement("btnVoltar", action.acoes));
		appStart.Frame.frame.add(btnVoltar);

		for (int i = 0; i < totalColunas - 1; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		for (int i = 0; i < totalColunas*2; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// -------------
		// full dir
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center dir
		JLabel lblENDERECO = new templateBase().BaseLbl;
		lblENDERECO.setText("Endereco:");
		appStart.Frame.frame.add(lblENDERECO);

		// center
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center esq
		JLabel lblBAIRRO = new templateBase().BaseLbl;
		lblBAIRRO.setText("Bairro:");
		appStart.Frame.frame.add(lblBAIRRO);

		// full esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ------------

		// fd
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// cd
		txtENDERECO = new templateBase().BaseTxt;
		txtENDERECO.setName("txtENDERECO");
		appStart.Frame.frame.add(txtENDERECO);

		// c
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ce
		txtBAIRRO = new templateBase().BaseTxt;
		txtBAIRRO.setName("txtBAIRRO");
		appStart.Frame.frame.add(txtBAIRRO);

		// fe
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// full dir
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center dir
		JLabel lblNUMERO = new templateBase().BaseLbl;
		lblNUMERO.setText("Nº:");
		appStart.Frame.frame.add(lblNUMERO);

		// center
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center esq
		JLabel lblCEP = new templateBase().BaseLbl;
		lblCEP.setText("CEP:");
		appStart.Frame.frame.add(lblCEP);

		// full esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ------------

		appStart.Frame.frame.add(new templateBase().BaseEspace);
		
		txtNUMERO = new templateBase().BaseTxt;
		txtNUMERO.setName("txtNUMERO");
		appStart.Frame.frame.add(txtNUMERO);		

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtCEP = new templateBase().BaseTxt;
		txtCEP.setName("txtCEP");
		appStart.Frame.frame.add(txtCEP);
		
		appStart.Frame.frame.add(new templateBase().BaseEspace);


		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// -------------
		// full dir
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center dir
		JLabel lblCOMPLEMENTO = new templateBase().BaseLbl;
		lblCOMPLEMENTO.setText("Complemento:");
		appStart.Frame.frame.add(lblCOMPLEMENTO);

		// center
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center esq
		JLabel lblCIDADE = new templateBase().BaseLbl;
		lblCIDADE.setText("Cidade:");
		appStart.Frame.frame.add(lblCIDADE);

		// full esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ------------

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtCOMPLEMENTO = new templateBase().BaseTxt;
		txtCOMPLEMENTO.setName("txtCOMPLEMENTO");
		appStart.Frame.frame.add(txtCOMPLEMENTO);
		

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtCIDADE = new templateBase().BaseTxt;
		txtCIDADE.setName("txtCIDADE");
		appStart.Frame.frame.add(txtCIDADE);		

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// -------------
		// full dir
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center dir
		JLabel lblUF = new templateBase().BaseLbl;
		lblUF.setText("UF:");
		appStart.Frame.frame.add(lblUF);

		// center
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// full esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ------------

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtUF = new templateBase().BaseTxt;
		txtUF.setName("txtUF");
		appStart.Frame.frame.add(txtUF);
		
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		appStart.Frame.frame.add(new templateBase().BaseEspace);
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		
		btnAdicionar = new templateBase().BaseBtn;
		templateBase.setColorButton(btnAdicionar, templateBase.enColorButton.Success);
		btnAdicionar.setName("btnAdicionar");
		btnAdicionar.setText("Adicionar");
		btnAdicionar.addActionListener(action.getActionByIdElement("btnAdicionar", action.acoes));
		appStart.Frame.frame.add(btnAdicionar);

	}
}