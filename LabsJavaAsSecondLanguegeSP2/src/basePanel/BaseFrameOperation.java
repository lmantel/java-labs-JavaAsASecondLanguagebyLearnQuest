package basePanel;

import javax.swing.*;

public class BaseFrameOperation extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JFrame f;
	
	public void simpleFrame() {
		
		JButton b = new JButton("Start");
		b.setBounds(130, 100, 100, 40);
		
		add(b);
		setSize(400, 500);
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		BaseFrameOperation bfo = new BaseFrameOperation();
		bfo.simpleFrame();
	}

	
}
