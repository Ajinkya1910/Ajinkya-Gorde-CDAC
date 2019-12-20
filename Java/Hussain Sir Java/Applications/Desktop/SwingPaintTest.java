import java.util.*;
import java.awt.*;
import javax.swing.*;

class SwingPaintTest{

	static class ClockPane extends JPanel{

		@Override
		public void paintComponent(Graphics g){
			g.setColor(Color.RED);
			g.drawRect(40, 80, 200, 20);
			g.setColor(Color.BLUE);
			Date now = new Date();
			g.drawString(now.toString(), 45, 95);
		}
	}

	static class MainFrame extends JFrame{

		public MainFrame(){
			super("Hello Swing");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(400, 400);
			setContentPane(new ClockPane());
		}
	}

	public static void main(String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		for(;;){
			Thread.sleep(1000);
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					frame.repaint();
				}
			});
		}
	}
}


