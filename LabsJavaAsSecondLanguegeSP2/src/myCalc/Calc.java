package myCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Calc extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JFrame frm;
	JTextField t;
	JLabel lab;
	JLabel imageLabel;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmul,bsub,badd,bdec,beq,bdel,bclr;
	JCheckBox cb1,cb2,cb3,cb4;
	JRadioButton rb1,rb2,rb3;
	JComboBox combo;
	
	String date;
	int frmX=375;
	int frmY=640;
 
	static double a=0,b=0,result=0;
	static int operator=0;
	
	Calc() 	{
		
		frm=new JFrame("Calculator");
		t=new JTextField();
		lab=new JLabel();
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		b0=new JButton("0");
		bdiv=new JButton("/");
		bmul=new JButton("*");
		bsub=new JButton("-");
		badd=new JButton("+");
		bdec=new JButton(".");
		beq=new JButton("=");
		bdel=new JButton("Delete");
		bclr=new JButton("Clear");
		
		ButtonGroup bg=new ButtonGroup(); 
		cb1=new JCheckBox("Add Date");
		cb2=new JCheckBox("Not Resizable");
		cb3=new JCheckBox("Emoji");
		rb1=new JRadioButton("Light Backgroud Color");
		rb2=new JRadioButton("Green Backgroud Color");
		rb3=new JRadioButton("Reset Background Color");
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		t.setBounds(30,40,280,30);
		b7.setBounds(40,100,50,40);
		b8.setBounds(110,100,50,40);
		b9.setBounds(180,100,50,40);
		bdiv.setBounds(250,100,50,40);
		
		b4.setBounds(40,170,50,40);
		b5.setBounds(110,170,50,40);
		b6.setBounds(180,170,50,40);
		bmul.setBounds(250,170,50,40);
		
		b1.setBounds(40,240,50,40);
		b2.setBounds(110,240,50,40);
		b3.setBounds(180,240,50,40);
		bsub.setBounds(250,240,50,40);
		
		bdec.setBounds(40,310,50,40);
		b0.setBounds(110,310,50,40);
		beq.setBounds(180,310,50,40);
		badd.setBounds(250,310,50,40);
		
		bdel.setBounds(60,380,100,40);
		bclr.setBounds(180,380,100,40);
		
		cb1.setBounds(10, 440, 150, 20);
		cb2.setBounds(10, 460, 150, 20);
		cb3.setBounds(10, 480, 150, 20);
		
		rb1.setBounds(160, 440, 200, 20);
		rb2.setBounds(160, 460, 200, 20);
		rb3.setBounds(160, 480, 200, 20);
		
		String place[]={"Left","Center","Right"};        
		combo=new JComboBox(place);    
		combo.setBounds(10, 510,90,20);
		combo.setBackground(Color.WHITE);
		combo.setSelectedIndex(0);
		combo.addActionListener(this);
		
		lab.setForeground(Color.BLUE);
		lab.setFont(new Font("Serif", Font.BOLD, 18));         //Set the font of label lab
		lab.setText("CalcApp");
		
		String fmt = "MMM-d-yyyy";                                         //Format for a date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fmt);   //instantiate the SimpleDateFormat class
		date = simpleDateFormat.format(new Date());
		
		ImageIcon imageIcon = new ImageIcon("src/myCalc/face-smile.png");
		imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(150, 500, 100, 100);
        imageLabel.setIcon(imageIcon);
        imageLabel.setVisible(false);
		
		frm.add(t);
		frm.add(lab);
		frm.add(b7);
		frm.add(b8);
		frm.add(b9);
		frm.add(bdiv);
		frm.add(b4);
		frm.add(b5);
		frm.add(b6);
		frm.add(bmul);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		frm.add(bsub);
		frm.add(bdec);
		frm.add(b0);
		frm.add(beq);
		frm.add(badd);
		frm.add(bdel);
		frm.add(bclr);
		frm.add(cb1);
		frm.add(cb2);
		frm.add(cb3);
		frm.add(rb1);
		frm.add(rb2);
		frm.add(rb3);
		frm.add(combo);
		frm.add(imageLabel);
				
		frm.setLayout(null);
		frm.setVisible(true);
		frm.setSize(frmX,frmY);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		frm.setResizable(false);
		frm.getContentPane().setBackground(null);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		badd.addActionListener(this);
		bdiv.addActionListener(this);
		bmul.addActionListener(this);
		bsub.addActionListener(this);
		bdec.addActionListener(this);
		beq.addActionListener(this);
		bdel.addActionListener(this);
		bclr.addActionListener(this);
		
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		cb3.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);	
		lab.setBounds(1, 1, 85, 20);
		
	}
	
	public void actionPerformed(ActionEvent e) {      //Test which component was clicked and run the functionality
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			t.setText(t.getText().concat("1"));
		}	
		if(e.getSource()==b2) {
			t.setText(t.getText().concat("2"));
		}
		if(e.getSource()==b3) {
			t.setText(t.getText().concat("3"));
		}
		if(e.getSource()==b4) {
			t.setText(t.getText().concat("4"));
		}
		if(e.getSource()==b5) {
			t.setText(t.getText().concat("5"));
		}
		if(e.getSource()==b6) {
			t.setText(t.getText().concat("6"));
		}
		if(e.getSource()==b7) {
			t.setText(t.getText().concat("7"));
		}
		if(e.getSource()==b8) {
			t.setText(t.getText().concat("8"));
		}
		if(e.getSource()==b9) {
			t.setText(t.getText().concat("9"));
		}
		if(e.getSource()==b0) {
			t.setText(t.getText().concat("0"));
		}
		if(e.getSource()==bdec) {
			t.setText(t.getText().concat("."));
		}
		if(e.getSource()==badd) {
			a=Double.parseDouble(t.getText());
			operator=1;
			t.setText("");
		} 		
		if(e.getSource()==bsub)	{
			a=Double.parseDouble(t.getText());
			operator=2;
			t.setText("");
		}		
		if(e.getSource()==bmul)	{
			a=Double.parseDouble(t.getText());
			operator=3;
			t.setText("");
		}		
		if(e.getSource()==bdiv)	{
			a=Double.parseDouble(t.getText());
			operator=4;
			t.setText("");
		}		
		if(e.getSource()==beq) {
			b=Double.parseDouble(t.getText());
		
			switch(operator) {
				case 1: result=a+b;
					break;
		
				case 2: result=a-b;
					break;
		
				case 3: result=a*b;
					break;
		
				case 4: result=a/b;
					break;
		
				default: result=0;
			}
		
			t.setText(""+result);
		}
		
		if(e.getSource()==bclr) {           //if JButton bclr is clicked, clear text field t.
			t.setText("");
		}
		if(e.getSource()==bdel) {
			String s=t.getText();
			t.setText("");
			for(int i=0;i<s.length()-1;i++) {
				t.setText(t.getText()+s.charAt(i));
			}
		}	
		if(cb1.isSelected()){  
            
    		frm.setTitle("Calculator: " + date);
        }else if(!cb1.isSelected()) {
        	frm.setTitle("Calculator");
        }
		if(cb2.isSelected()){
			
			frm.setResizable(false);
			frm.setSize(frmX,frmY);
			frm.setLocationRelativeTo(null); 
			
		}else if(!cb2.isSelected()) {
			frm.setResizable(true); 
		}
		if(cb3.isSelected()) {
			
	        imageLabel.setVisible(true);
		}else if(!cb3.isSelected()) {
			
			imageLabel.setVisible(false);
		}
		if(rb1.isSelected()){    
			
			frm.getContentPane().setBackground(Color.WHITE);
			cb1.setBackground(Color.WHITE);
			cb2.setBackground(Color.WHITE);
			cb3.setBackground(Color.WHITE);
			rb1.setBackground(Color.WHITE);
			rb2.setBackground(Color.WHITE);
			rb3.setBackground(Color.WHITE);
	    }else if(rb2.isSelected()) {
	    	
	    	frm.getContentPane().setBackground(Color.GREEN);
	    	cb1.setBackground(Color.GREEN);
	    	cb2.setBackground(Color.GREEN);
	    	cb3.setBackground(Color.GREEN);
	    	rb1.setBackground(Color.GREEN);
	    	rb2.setBackground(Color.GREEN);
	    	rb3.setBackground(Color.GREEN);
	    }else if(rb3.isSelected()) {
	    	
	    	frm.getContentPane().setBackground(null);
			cb1.setBackground(null);
			cb2.setBackground(null);
			cb3.setBackground(null);
			rb1.setBackground(null);
	    	rb2.setBackground(null);
	    	rb3.setBackground(null);
	    }
		if(e.getSource() == combo) {
		
			if(combo.getSelectedItem() == "Right") {
				lab.setBounds((frm.getWidth()-lab.getWidth()), 1, 70, 20);
			}else if(combo.getSelectedItem() == "Center") {
				lab.setBounds((frm.getWidth()-lab.getWidth())/2, 1, 70, 20);
				
			}else if(combo.getSelectedItem() == "Left") {
				lab.setBounds(1, 1, 70, 20);
			}else {
				
				lab.setBounds((frm.getWidth()-lab.getWidth())/2, 1, 70, 20);
			}
		}

	}
	
	 public static void main(String args[]) {
	 //public static void main(String...s)	{
		Calc calculadora = new Calc();
	}

}
