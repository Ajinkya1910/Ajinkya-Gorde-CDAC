import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SwingChildTest{

	static class MainFrame extends JFrame{

		JButton timeButton = new JButton("Time");

		public MainFrame(){
			super("Hello Swing");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(400, 400);
			setUndecorated(true);
			rootPane.setWindowDecorationStyle(JRootPane.FRAME);
			setLayout(new FlowLayout());
			add(timeButton);
			timeButton.addActionListener(e -> 
			{
				Date now = new Date();
				JOptionPane.showMessageDialog(this, now, "HelloSwing", JOptionPane.INFORMATION_MESSAGE);
			});
		}
	}

	public static void main(String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}


