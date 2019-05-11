package controllers;

import appStart.myView;

public class BaseController {

	public String Controller = this.getClass().getName();
	public String Action = Thread.currentThread().getStackTrace()[1].getMethodName();

	public myView View(Object model, String action) {		
		return new myView(model, action, Controller);
	}

}
