package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import TOs.UsuarioTO;
import models.IAction;
import models.IActionItem;

public class UsuarioAtivarDesativar extends BaseController {
	public void Index() {

		List<IActionItem> itens = new ArrayList<IActionItem>();
		itens.add(new IActionItem("btnVoltar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Dashboard().Index();
			}
		}));
		itens.add(new IActionItem("btnDesativar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String login = views.templateUsuarioAtivarDesativar.txtLogin.getText();

				try {

					UsuarioTO usu = Negocio.Acesso.consultarByLogin(login);
					if (usu == null) {
						throw new Exception("Usuario não existe!");
					}
					if (!usu.FLG_ATIVO) {
						throw new Exception("Usuario ja desativado!");
					}

					try {
						usu.FLG_ATIVO = false;
						Negocio.Acesso.alterar(usu);
						JOptionPane.showMessageDialog(null, "Usuario desativado com sucesso!");
						views.templateUsuarioAtivarDesativar.txtLogin.setText("");

					} catch (Exception e1) {
						throw new Exception("Erro ao atualizar usuario!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		}));
		itens.add(new IActionItem("btnAtivar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String login = views.templateUsuarioAtivarDesativar.txtLogin.getText();

				try {

					UsuarioTO usu = Negocio.Acesso.consultarByLogin(login);
					if (usu == null) {
						throw new Exception("Usuario não existe!");
					}
					if (usu.FLG_ATIVO) {
						throw new Exception("Usuario ja ativado!");
					}

					try {
						usu.FLG_ATIVO = true;
						Negocio.Acesso.alterar(usu);
						JOptionPane.showMessageDialog(null, "Usuario ativado com sucesso!");
						views.templateUsuarioAtivarDesativar.txtLogin.setText("");

					} catch (Exception e1) {
						throw new Exception("Erro ao atualizar usuario!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		}));
		super.GenerateView(new IAction(this.getClass(), itens));
	}
}
