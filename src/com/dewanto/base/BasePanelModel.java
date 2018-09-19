package com.dewanto.base;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JProgressBar;

public class BasePanelModel extends HashMap{
	Map componentMap;


	public BasePanelModel(Map componentMap) {
		super();
		this.componentMap = componentMap;
	}
	public void set(String name, String value){
		if (componentMap.containsKey(name)) {
			Component component=(Component) componentMap.get(name);
			if(component instanceof TextField ){
				((TextField)component).setText(value);
			}else if(component instanceof JProgressBar){
				((JProgressBar)component).setValue(Integer.valueOf(value));
			}
		}
	}
	public String get(String name){
		if (componentMap.containsKey(name)) {
			Component component=(Component) componentMap.get(name);
			if(component instanceof TextField ){
				return ((TextField)component).getText();
			}else if(component instanceof JProgressBar){
				return String.valueOf(((JProgressBar)component).getValue());
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public Dimension getDimension(String name){
		if (componentMap.containsKey(name)) {
			Component component=(Component) componentMap.get(name);
			return component.getSize();
		}else{
			return null;
		}
	}
	
	public void setProperties(String name, String method, boolean value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if (componentMap.containsKey(name)) {
			Component component=(Component) componentMap.get(name);
			Method componentMethod=component.getClass().getMethod(method, boolean.class);
			componentMethod.invoke(component, value);
		}
	}
	public void setProperties(String name, String method, int value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if (componentMap.containsKey(name)) {
			Component component=(Component) componentMap.get(name);
			Method componentMethod=component.getClass().getMethod(method, int.class);
			componentMethod.invoke(component, value);
		}
	}
	public void setProperties(String name, String method, String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if (componentMap.containsKey(name)) {
			Component component=(Component) componentMap.get(name);
			Method componentMethod=component.getClass().getMethod(method, String.class);
			componentMethod.invoke(component, value);
		}
	}
	
	
	
}
