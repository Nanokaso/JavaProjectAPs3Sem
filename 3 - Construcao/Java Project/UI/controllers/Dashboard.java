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
import models.UsuarioAtual;

public class Dashboard extends BaseController {
	public void Index() {

		List<IActionItem> itens = new ArrayList<IActionItem>();
		itens.add(new IActionItem("onload", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "on load");
			}
		}));
		itens.add(new IActionItem("btnSair", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioAtual.usuario = null;
				new controllers.Login().Index();
			}
		}));

		itens.add(new IActionItem("btnAddUsuario", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UsuarioAdicionar().Index();
			}
		}));
		itens.add(new IActionItem("btnDesativarUsuario", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UsuarioAtivarDesativar().Index();
			}
		}));
		itens.add(new IActionItem("btnListarUsuario", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UsuarioListar().Index();
			}
		}));
		itens.add(new IActionItem("btnAddPaciente", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PacienteAdicionar().Index();
			}
		}));
		itens.add(new IActionItem("btnListarPaciente", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new controllers.PacienteListar().Index();
			}
		}));
		itens.add(new IActionItem("btnListarDoencas", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DoencaListar().Index();
			}
		}));
		itens.add(new IActionItem("btnAdicionarEndereco", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EnderecoAdicionar().Index();
			}
		}));
		itens.add(new IActionItem("btnListarEndereco", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EnderecoListar().Index();
			}
		}));
		itens.add(new IActionItem("btnPacienteDoencaAdicionar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PacienteDoencaAdicionar().Index();
			}
		}));

		itens.add(new IActionItem("btnRelatorioUmaCidade", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RelatorioCidades().Index(1);
			}
		}));

		itens.add(new IActionItem("btnRelatorioDuasCidade", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RelatorioCidades().Index(2);
			}
		}));

		itens.add(new IActionItem("btnRelatorioTodasCidade", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RelatorioCidadesMostrar().Index(null);
			}
		}));

		super.GenerateView(new IAction(this.getClass(), itens));
	}
}
