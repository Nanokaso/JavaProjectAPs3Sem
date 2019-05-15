package models;

import java.util.*;

public class IAction {

	// entidades
	public List<IActionItem> acoes;
	public String TitlePage;
	public Class<?> classe;

	// metodo construtor sem title page
	public IAction(Class<?> classe, List<IActionItem> acoes) {
		setData(classe, acoes, classe.getName().replace("controllers.", ""));
	}

	public IAction(Class<?> classe, List<IActionItem> acoes, String titlePage) {
		setData(classe, acoes, titlePage);
	}

	private void setData(Class<?> classe, List<IActionItem> acoes, String titlePage) {
		this.acoes = acoes;
		this.classe = classe;
		this.TitlePage = titlePage;
	}

}
