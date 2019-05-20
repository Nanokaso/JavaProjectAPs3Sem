package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Negocio.Endereco;
import Negocio.Paciente;
import TOs.EnderecoTO;
import TOs.PacienteTO;
import models.IAction;
import models.IActionItem;

public class EnderecoAdicionar extends BaseController {
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

				String endereco = views.templateEnderecoAdicionar.txtENDERECO.getText();
				String bairro = views.templateEnderecoAdicionar.txtBAIRRO.getText();
				String numero = views.templateEnderecoAdicionar.txtNUMERO.getText();
				String cep = views.templateEnderecoAdicionar.txtCEP.getText();
				String complemento = views.templateEnderecoAdicionar.txtCOMPLEMENTO.getText();
				String cidade = views.templateEnderecoAdicionar.txtCIDADE.getText();
				String uf = views.templateEnderecoAdicionar.txtUF.getText();

				try {

					if (endereco.isBlank() || bairro.isBlank() || numero.isBlank() || cep.isBlank()
							|| complemento.isBlank() || cidade.isBlank() || uf.isBlank()) {
						throw new Exception("Um ou mais campos vazios!");
					}
					try {

						EnderecoTO pac = new EnderecoTO();
						pac.ENDERECO = endereco;
						pac.BAIRRO = bairro;
						pac.NUMERO = Integer.parseInt(numero);
						pac.CEP = cep;
						pac.COMPLEMENTO = complemento;
						pac.CIDADE = cidade;
						pac.UF = uf;
						Endereco.incluir(pac);
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

					} catch (Exception e1) {
						throw new Exception("Erro ao adicionar registro! Verifique os campos e tente novamente!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		}));
		super.GenerateView(new IAction(this.getClass(), itens));
	}
}