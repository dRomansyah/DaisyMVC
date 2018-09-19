package com.dewanto.view.component.browsepanel;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class BrowsePanelActionListener implements ActionListener {
	TextField pathText;
	JFileChooser folderChooser;
	Component parentComponent;


	public BrowsePanelActionListener(TextField pathText,
			JFileChooser folderChooser, Component parentComponent) {
		super();
		this.pathText = pathText;
		this.folderChooser = folderChooser;
		this.parentComponent = parentComponent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		folderChooser.setCurrentDirectory(new java.io.File(""));
		folderChooser.setDialogTitle("Fodler chooser");
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//
		// disable the "All files" option.
		//
		folderChooser.setAcceptAllFileFilterUsed(false);

		if (folderChooser.showOpenDialog(parentComponent) == JFileChooser.APPROVE_OPTION) { 
			pathText.setText(folderChooser.getSelectedFile().getAbsolutePath());
//			System.out.println("getCurrentDirectory(): " 
//					+  folderChooser.getCurrentDirectory());
//			System.out.println("getSelectedFile() : " 
//					+  folderChooser.getSelectedFile());
		}
	}

}
