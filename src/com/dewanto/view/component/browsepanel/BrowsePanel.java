package com.dewanto.view.component.browsepanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BrowsePanel extends JPanel {
	String tittle;
	public BrowsePanel(String tittle){
		this.tittle =tittle;
	}
	public Component render(){
		TitledBorder border = new TitledBorder(this.tittle);
	    border.setTitleJustification(TitledBorder.LEFT);
	    border.setTitlePosition(TitledBorder.TOP);
	    
	    JPanel panel = new JPanel();
	    panel.setBorder(border);
	    panel.setLayout(new GridBagLayout());
	    
	    GridBagConstraints browsePanelGridBagConstraints = new GridBagConstraints();
        browsePanelGridBagConstraints.anchor = GridBagConstraints.LINE_START;
        browsePanelGridBagConstraints.weightx = 1;
        browsePanelGridBagConstraints.weighty = 1;
	    
	    TextField pathText= new TextField();
	    pathText.setName(tittle);
	    pathText.setPreferredSize(new Dimension(300,20));
	    browsePanelGridBagConstraints.gridx = 2;
        browsePanelGridBagConstraints.gridy = 0;
	    panel.add(pathText,browsePanelGridBagConstraints);
	    
	    
	    JButton browseButton= new JButton("Browse");
	    JFileChooser fileChooser= new JFileChooser();
	    browseButton.addActionListener(new BrowsePanelActionListener(pathText, fileChooser, this));
	    browsePanelGridBagConstraints.gridx = 3;
        browsePanelGridBagConstraints.gridy = 0;
        browsePanelGridBagConstraints.insets = new Insets(0, 5, 0, 0);
	    panel.add(browseButton,browsePanelGridBagConstraints);
	    
		return panel;
	}
}
