import java.util.*;
import java.awt.*;
import java.awt.event.*;

class AWTPaintTest{

	static class MainFrame extends Frame{

		public MainFrame(){
			super("Hello AWT");
			setSize(400, 400);
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		}

		@Override
		public void paint(Graphics g){
			g.setColor(Color.RED); //g.setColor(new Color(255, 0, 0));
			g.drawRect(40, 80, 200, 20);
			g.setColor(Color.BLUE);
			Date now = new Date();
			g.drawString(now.toString(), 45, 95);
		}

		@Override
		protected void processWindowEvent(WindowEvent e){
			if(e.getID() == WindowEvent.WINDOW_CLOSING)
				System.exit(0);
			super.processWindowEvent(e);
		}
	}

	public static void main(String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		for(;;){
			Thread.sleep(1000);
			frame.repaint();
		}
	}
}

