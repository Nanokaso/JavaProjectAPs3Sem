package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import models.IAction;

public class templatePacienteDoencaAdicionar  {
	public static JButton btnAdicionar;
	public static JButton btnVoltar;
	public static JTextField txtIdDoenca;
	public static JTextField txtCPFPaciente;
	public static JTextField txtIdEndereco;
	public static JTextField txtDtInicio;
	public static JTextField txtDtTermino;
	public static JTextField txtFlgMedicado;
	public static JTextField txtFlgFalecido;
	public static JTextField txtDtObito;

	public static void init(IAction action) {		
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
		JLabel lblIdDoenca = new templateBase().BaseLbl;
		lblIdDoenca.setText("Id Doenca:");
		appStart.Frame.frame.add(lblIdDoenca);

		// center
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center esq
		JLabel lblCPFPaciente = new templateBase().BaseLbl;
		lblCPFPaciente.setText("CPF Paciente:");
		appStart.Frame.frame.add(lblCPFPaciente);

		// full esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ------------

		// fd
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// cd
		txtIdDoenca = new templateBase().BaseTxt;
		txtIdDoenca.setName("txtIdDoenca");
		appStart.Frame.frame.add(txtIdDoenca);

		// c
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ce
		txtCPFPaciente = new templateBase().BaseTxt;
		txtCPFPaciente.setName("txtCPFPaciente");
		appStart.Frame.frame.add(txtCPFPaciente);

		// fe
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// full dir
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center dir
		JLabel lblIdEndereco = new templateBase().BaseLbl;
		lblIdEndereco.setText("Id Endereco:");
		appStart.Frame.frame.add(lblIdEndereco);

		// center
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center esq
		JLabel lblDtInicio = new templateBase().BaseLbl;
		lblDtInicio.setText("Dt Inicio  (dd/mm/yyyy):");
		appStart.Frame.frame.add(lblDtInicio);

		// full esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ------------

		appStart.Frame.frame.add(new templateBase().BaseEspace);
		
		txtIdEndereco = new templateBase().BaseTxt;
		txtIdEndereco.setName("txtIdEndereco");
		appStart.Frame.frame.add(txtIdEndereco);		

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtDtInicio = new templateBase().BaseTxt;
		txtDtInicio.setName("txtDtInicio");
		appStart.Frame.frame.add(txtDtInicio);
		
		appStart.Frame.frame.add(new templateBase().BaseEspace);


		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// -------------
		// full dir
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center dir
		JLabel lblDtTermino = new templateBase().BaseLbl;
		lblDtTermino.setText("Dt Termino  (dd/mm/yyyy):");
		appStart.Frame.frame.add(lblDtTermino);

		// center
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center esq
		JLabel lblFlgMedicado = new templateBase().BaseLbl;
		lblFlgMedicado.setText("Medicado ? (1/0):");
		appStart.Frame.frame.add(lblFlgMedicado);

		// full esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ------------

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtDtTermino = new templateBase().BaseTxt;
		txtDtTermino.setName("txtDtTermino");
		appStart.Frame.frame.add(txtDtTermino);
		

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtFlgMedicado = new templateBase().BaseTxt;
		txtFlgMedicado.setName("txtFlgMedicado");
		appStart.Frame.frame.add(txtFlgMedicado);		

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		for (int i = 0; i < totalColunas; i++) {
			appStart.Frame.frame.add(new templateBase().BaseEspace);
		}

		// -------------
		// full dir
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center dir
		JLabel lblFlgFalecido = new templateBase().BaseLbl;
		lblFlgFalecido.setText("Falecido? (1/0)");
		appStart.Frame.frame.add(lblFlgFalecido);

		// center
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// center esq
		JLabel lblDtObito = new templateBase().BaseLbl;
		lblDtObito.setText("Dt Obito (dd/mm/yyyy):");
		appStart.Frame.frame.add(lblDtObito);

		// full esq
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		// ------------

		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtFlgFalecido = new templateBase().BaseTxt;
		txtFlgFalecido.setName("txtFlgFalecido");
		appStart.Frame.frame.add(txtFlgFalecido);
		
		appStart.Frame.frame.add(new templateBase().BaseEspace);

		txtDtObito = new templateBase().BaseTxt;
		txtDtObito.setName("txtDtObito");
		appStart.Frame.frame.add(txtDtObito);

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