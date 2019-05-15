package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import TOs.UsuarioTO;
import models.IAction;
import models.IActionItem;

public class Login extends BaseController {

	public void Index() {

		List<IActionItem> itens = new ArrayList<IActionItem>();
		itens.add(new IActionItem("btnLogar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String login = views.templateLogin.txtLogin.getText();
				String senha = views.templateLogin.txtSenha.getText();

				try {
					UsuarioTO usu = Negocio.Acesso.Logar(login, senha);
					if (usu != null) {
						JOptionPane.showMessageDialog(null, "Logado!");
					} else {
						throw new Exception("");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Login ou Senha inválidos!");
					e1.printStackTrace();
				}

			}
		}));
		super.GenerateView(new IAction(this.getClass(), itens));
	}
}
