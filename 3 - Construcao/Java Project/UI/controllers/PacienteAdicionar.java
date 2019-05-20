package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Negocio.Paciente;
import TOs.PacienteTO;
import TOs.UsuarioTO;
import models.IAction;
import models.IActionItem;

public class PacienteAdicionar extends BaseController {
	public void Index() {

		List<IActionItem> itens = new ArrayList<IActionItem>();
		itens.add(new IActionItem("btnVoltar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Dashboard().Index();
			}
		}));
		itens.add(new IActionItem("btnAdicionar", new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				String nome = views.templatePacienteAdicionar.txtNome.getText();
				String dt = views.templatePacienteAdicionar.txtDt.getText();
				String cPF = views.templatePacienteAdicionar.txtCPF.getText();
				String rG = views.templatePacienteAdicionar.txtRG.getText();
				String sexo = views.templatePacienteAdicionar.txtSexo.getText();

				try {

					if (nome.isBlank() || dt.isBlank() || rG.isBlank() || sexo.isBlank() || cPF.isBlank()) {
						throw new Exception("Um ou mais campos vazios!");
					}
					
					if (!sexo.equals("M") && !sexo.equals("F")) {
						throw new Exception("Campo sexo invalido!");
					}

					PacienteTO obj = Negocio.Paciente.consultarByRgOrCPF(rG, cPF);
					if (obj != null) {
						throw new Exception("Paciente com CPF ou RG ja existe!");
					}
					
					try {
						Float.parseFloat(cPF);
						Float.parseFloat(rG);
					} catch (Exception e3) {
						throw new Exception("Campo de Cpf ou RG invalidos");
					}

					Date Dtnasc = new Date();
					try {
						String[] data = dt.split("/");
						Dtnasc = new Date(Integer.parseInt(data[2]), Integer.parseInt(data[1]),
								Integer.parseInt(data[0]));
					} catch (Exception e3) {
						throw new Exception("Data invalida!");
					}

					try {

						PacienteTO pac = new PacienteTO();
						pac.NOME_PACIENTE = nome;
						pac.DT_NASCIMENTO = Dtnasc;
						pac.RG = rG;
						pac.CPF = cPF;
						pac.SEXO = sexo;						
						Paciente.incluir(pac);	
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

					} catch (Exception e1) {
						throw new Exception("Erro ao adicionar Paciente!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		}));
		super.GenerateView(new IAction(this.getClass(), itens));
	}
}