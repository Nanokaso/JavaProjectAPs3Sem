package models;

import java.awt.event.ActionListener;
public class IActionItem {
	
	public String idElement;
	public String title;
	public ActionListener acao;

	public IActionItem() {

	}

	public IActionItem(String id, ActionListener acao) {
		this.idElement = id;
		this.acao = acao;
	}
}
