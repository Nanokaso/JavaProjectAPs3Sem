package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import models.IAction;
import models.IActionItem;
import views.templateRelatorioCidades;

public class RelatorioCidades extends BaseController {

	public void Index(int qtdCidades) {

		qtdCidades = qtdCidades == 0 ? 1 : qtdCidades;		
		templateRelatorioCidades.qtdCidades = qtdCidades;

		List<IActionItem> itens = new ArrayList<IActionItem>();
		itens.add(new IActionItem("btnVoltar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Dashboard().Index();
			}
		}));
		itens.add(new IActionItem("btnContinuar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		}));	
		super.GenerateView(new IAction(this.getClass(), itens));
	}

}
