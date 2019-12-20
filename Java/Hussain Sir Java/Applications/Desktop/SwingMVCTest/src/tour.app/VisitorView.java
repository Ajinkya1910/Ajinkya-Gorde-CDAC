package edu.met.tourism;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class VisitorView extends JFrame{

	private JTextField nameTextField = new JTextField();

	public VisitorView(ActionListener listener, TableModel model){
		super("SwingMVCTest");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		rootPane.setWindowDecorationStyle(JRootPane.FRAME);
		JLabel nameLabel = new JLabel("Name:");
		JButton registerButton = new JButton("Register");
		JTable visitorsTable = new JTable();
		registerButton.addActionListener(listener);
		visitorsTable.setModel(model);
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(nameLabel, BorderLayout.WEST);
		topPanel.add(registerButton, BorderLayout.EAST);
		topPanel.add(nameTextField);
		add(topPanel, BorderLayout.NORTH);
		add(new JScrollPane(visitorsTable));
		setVisible(true);
	}

	public String getNameToRegister(){
		return nameTextField.getText();
	}
}

