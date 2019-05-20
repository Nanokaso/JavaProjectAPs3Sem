package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import models.IAction;
import models.IActionItem;

public class EnderecoListar extends BaseController {

	public void Index() {

		List<IActionItem> itens = new ArrayList<IActionItem>();
		itens.add(new IActionItem("btnVoltar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Dashboard().Index();
			}
		}));
		super.GenerateView(new IAction(this.getClass(), itens));
	}

}