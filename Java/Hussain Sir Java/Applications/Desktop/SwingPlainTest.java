import javax.swing.*;

class SwingPlainTest{

	static class MainFrame extends JFrame{

		public MainFrame(){
			super("Hello Swing");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(400, 400);
		}
	}

	public static void main(String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}


