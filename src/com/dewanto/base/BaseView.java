/**
 * Extend this class on View Code
 * @author User Kokog Dewanto Budi Romansyah
 */
package com.dewanto.base;

import javax.swing.JFrame;



public abstract class BaseView extends JFrame {
	private BaseController baseController;
	protected abstract void initializeView();
	protected abstract void setController(BaseController baseController);
	protected void registerController(BaseController baseController){
		this.baseController = baseController;
		setController(baseController);
	}
}
