package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import TOs.UsuarioTO;
import models.IAction;
import models.IActionItem;

public class UsuarioAdicionar extends BaseController {
	public void Index() {

		List<IActionItem> itens = new ArrayList<IActionItem>();
		itens.add(new IActionItem("btnVoltar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Dashboard().Index();
			}
		}));
		itens.add(new IActionItem("btnAdicionar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String login = views.templateUsuarioAdicionar.txtLogin.getText();
				String senha = views.templateUsuarioAdicionar.txtSenha.getText();
				String senha2 = views.templateUsuarioAdicionar.txtSenha2.getText();

				try {

					if (!senha.equals(senha2) || senha.isBlank() || senha2.isBlank()) {
						throw new Exception("Senhas não são iguais ou são vazias!");
					}

					UsuarioTO usu = Negocio.Acesso.consultarByLogin(login);
					if (usu != null) {
						throw new Exception("Login em uso!");
					}

					try {
						UsuarioTO u = new UsuarioTO();
						u.LOGIN = login;
						u.SENHA = senha;
						u.FLG_ATIVO = true;						
						Negocio.Acesso.incluir(u);
						JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
						views.templateUsuarioAdicionar.txtLogin.setText("");
						views.templateUsuarioAdicionar.txtSenha.setText("");
						views.templateUsuarioAdicionar.txtSenha2.setText("");
						
					} catch (Exception e1) {
						throw new Exception("Erro ao adicionar usuario!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		}));
		super.GenerateView(new IAction(this.getClass(), itens));
	}
}
