package controllers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import appStart.Frame;
import models.IAction;
import models.IActionItem;

public class BaseController {

	public void GenerateView(IAction action) {
		// montar a view e gerar os listeners
		try {
			
			// prepara o frame
			Frame.PrepareNewFrame(action);

			// procurar o template
			Class<?> template = Class.forName("views.template" + action.classe.getName().replace("controllers.", ""));

			Method initMethod = template.getDeclaredMethod("init", IAction.class);

			initMethod.invoke(null, action);
						
			// mostra frame
			Frame.ShowFrame();
			
			for (IActionItem acao : action.acoes) {
				if ("onload".equals(acao.idElement)) {				
					acao.acao.actionPerformed(null);
				}
			}
		} catch (Exception e) {
			System.out.print("Não foi possivel montar a view! " + e.getMessage());
		}

	}
}
