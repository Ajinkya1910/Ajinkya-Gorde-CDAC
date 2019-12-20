package edu.met.tourism;

import java.awt.event.*;

public class VisitorController implements ActionListener{

	private VisitorModel model;
	private VisitorView view;

	public void actionPerformed(ActionEvent e){
		String name = view.getNameToRegister();
		if(name.length() > 0)
			model.writeVisitor(name);
	}

	private void run(){
		model = new VisitorModel();
		view = new VisitorView(this, model);
	}

	public static void main(String[] args){
		VisitorController controller = new VisitorController();
		controller.run();
	}	
}

