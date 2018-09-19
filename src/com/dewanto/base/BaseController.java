/**
 * Extend this class for Controller, in you controller\
 * Applied that action command in your component(in view swing) is exist in controller as method 
 * @author Kokoh Dewanto Budi Romansyah
 */
package com.dewanto.base;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class BaseController implements ActionListener {
	private BaseView activeView;
	private Map componentMap;
	protected BasePanelModel panelModel;
	private BaseController clazz;
	private ActionEvent actionEvent;
	
	protected void loadView(Class viewClass){
		try {
			activeView = (BaseView) viewClass.newInstance();
			activeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			activeView.initializeView();
			activeView.setVisible(true);
			activeView.registerController(this);
			componentMap= componentToMap(activeView);
			panelModel= new BasePanelModel(componentMap);
			

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Map componentToMap(Container c) {
	    Component[] comps = c.getComponents();
//	    List<Component> compList = new ArrayList<Component>();
	    Map componentMap= new HashMap<String, Component>();
	    for (Component comp : comps) {
	    	if(comp.getName()!=null || !"".equals(comp.getName())){
	    		componentMap.put(comp.getName(), comp);
	    	}
	      if (comp instanceof Container) {
	    	  componentMap.putAll(componentToMap((Container) comp));
	      }
	    }
	    return componentMap;
	  }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		clazz= this;
		actionEvent=e;
		BackgroundSwing bs = null;
		try {
			 bs = new BackgroundSwing();
			bs.execute();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private class BackgroundSwing extends SwingWorker<Integer, String> {

		@Override
		protected Integer doInBackground() throws Exception {
			try {
				Method runtimeMethod=clazz.getClass().getMethod(actionEvent.getActionCommand(),null);
				runtimeMethod.invoke(clazz, null);
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				System.gc();
			}
			return null;
		}}
}
