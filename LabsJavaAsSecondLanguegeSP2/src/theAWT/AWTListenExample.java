package theAWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AWTListenExample {
	
	public String frmText( ) {
		
		Date dt = new Date(0);
		String dtxt = dt.toString();
		return dtxt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AWTListenExample ale = new AWTListenExample();
		
		Frame f = new Frame("ActionListener Demo");
		final TextField mytf = new TextField();
		mytf.setBounds(10, 50, 375, 20);
		Button b = new Button("Click here");
		b.setBounds(50, 100, 85, 30);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				mytf.setText("Welcome to his java awt lesson");
				String dtext = ale.frmText();
				mytf.setText("Welcome: Java AWT Lesson " + dtext);
				}
		});
		
		f.add(b);
		f.add(mytf);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);

	}

}
