package findIP;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class NetworkDemo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	int FindIPCount=0;                                //int for debugging
	int noCount=0;                                    //int for debugging
	int listCnt=0;                                    //int for debugging
	String sdate = "";                                //String for date data

	String myList = "";                               //String for domain listing
	JFrame frm ;                                      //JFrame Window frm 
	JTextField tf;                                    //Declare a label for output                               
	JLabel l;                                         //Declare a label for output
	JLabel lab;                                       //Declare a label for information
	JTextArea txta;                                   //Declare a text area for listing domains
	JButton b;                                        //Declare a button b
	JButton b0;                                       //Declare a button b0
	JButton b2;                                       //Declare a button b2
	JLabel txtLab;                                    //Declare a label 
	
	public String getDate() {
		
		String fmt = "MMM-dd-yyyy HH:MM:SS";                             //Format for a date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fmt);   //instantiate the SimpleDateFormat class
		String date = simpleDateFormat.format(new Date());               //call format on simpleDateFormat object and pass Date class
		
		return date;                                                     //return the date as String data
	}
	
    NetworkDemo(){                                             //NetworkDemo class constructor
    	
    	frm = new JFrame();                                    //Instantiate a new JFrame frm
    	
    	tf=new JTextField();                                   //Instantiate a new text field tf
    	tf.setBounds(50,50, 150,20);                           //set location for text field tf
    	l=new JLabel();                                        //Instantiate a new label l                       
    	l.setBounds(50,100, 250,20);                           //Set location of label l
    	lab = new JLabel();                                    //Instantiate a new label lab
    	lab.setBounds(250, 120, 100, 200);                     //Set location of label lab
    	lab.setFont(new Font("Serif", Font.BOLD, 18));         //Set the font of label lab
    	
    	txtLab = new JLabel();                                 //Instantiate a new label txtLab   
    	txtLab.setBounds(220, 150, 100, 20);                   //Set location of label txtLabel
    	txtLab.setFont(new Font("Serif", Font.BOLD, 16));      //Set the font of label txtlab
    	txtLab.setForeground(Color.BLUE);                      //Set the color of the label txtLab
    	txtLab.setText("Sites Visited");                       //set the text of the label txtLab
    	txta = new JTextArea();                                //Instantiate a new text area txta 
    	txta.setBounds(185, 180, 170, 150);                    //Set the text area location
 
    	b=new JButton("Find IP");    	                       //Instantiate a new button, b, with caption "Find IP"                 
    	b.setBounds(50,150,95,30);                             //set location of button b
    	b.addActionListener(this);                             //add the action listener to button b
    	b0=new JButton ("List It");                            //Instantiate a new button, b0, with caption "List It"     
    	b0.setBounds(50, 200, 100, 30);                        //set location of button b0
    	b0.addActionListener(this);                            //add the action listener to button b0
    	b2 = new JButton("Clear");                             //Instantiate a new button, b2, with caption "List It"    
    	b2.setBounds(50, 250, 100, 30);                        //set location of button b2
    	b2.addActionListener(this);                            //add the action listener to button b2
    	JButton Button = new JButton("Close");                 //Instantiate a new button, Button, with caption "Close"
    	Button.setBounds(50, 300, 100, 40);                    //set location of button Button
    	
    	frm.add(b);                                            //add button b to JFrame frm
    	frm.add(b0);                                           //add button b0 to JFrame frm
    	frm.add(b2);                                           //add button b2 to JFrame frm
    	frm.add(txtLab);                                       //add label txtLab to JFrame frm
    	frm.add(tf);                                           //add textfield tf to JFrame frm
    	frm.add(l);                                            //add label l to JFrame frm
    	frm.add(lab);                                          //add label lab to JFrame frm
    	frm.add(txta);                                         //add text area txta to JFrame frm
    	frm.add(Button);                                       //add button Button to JFrame frm
    	
    	frm.setTitle("IP Finder");                             //Set the title of JFrame frm
    	frm.setSize(400,400);                                  //Set the size of JFrame frm
    	frm.setLayout(null);                                   //call set Layout
    	frm.setVisible(true);                                  //Make the JFrame frm visible
    	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //set the default close X on the frm 
    	frm.setLocationRelativeTo(null);                       //Center the JFrame frm relative to the screen
        
    	Button.addActionListener((event) ->System.exit(0));    //Set the action of button Button
    	
    }  
    
	public void actionPerformed(ActionEvent e) {  
        try{  
        	     	
        	JButton src = (JButton) e.getSource();                                   //returned the source of the JButton to src object
        	  if(src.getActionCommand().equals("Find IP")) {                         //Test if src action command is "Find IP"
        		  
        		String host=tf.getText();                                            //return the text in test box tf to String host
              	String ip=java.net.InetAddress.getByName(host).getHostAddress();     //Build the IP address String response
              	l.setText("IP of "+host+" is: "+ip);                                 //Set the text of label l with the above response
    
        		FindIPCount ++;                                                      //increment FindIPCount for debugging
        	    System.out.println("FindIPCount is: " + FindIPCount);                //Output the FindIPCount to the console for debugging
        	  } else if(src.getActionCommand().equals("List It")) {                  //test if button action command is "List It"
        		  listCnt++;                                                         //increment listCnt for debugging
        		  System.out.println("List Count is: " + listCnt);                   //Output the FindIPCount to the console for debugging                          
        		  String site = tf.getText();                                        //Return text in text field tf to String site
        		  site = site + "\n";                                                //add a new line to String site
        		  myList += site;                                                    //Concatenate the string of sites                       
        		  System.out.println(myList);                                        //Output the FindIPCount to the console for debugging
        		  txta.setText(myList);                                              //Set the text of the text field 
        	  }  else if(src.getActionCommand().equals("Clear")) {                   //Test the action command of button for "Clear"
        		  
        		  System.out.println("Clearing Fields");                             //Output the "Clearing Fields" to the console for debugging
        		  myList = "";                                                       //Set myList back to null
        		  tf.setText(null);                                                  //Clear text field
        		  l.setText(null);                                                   //Clear label text
        		  txta.setText(null);                                                //Clear listing of text area txta
        	  }
        	  else {
        	    noCount++;                                                           //Increment counter for debugging
        	  }  
        }catch(Exception ex){System.out.println(ex);}                                //Output Exception error text
    }  
    
    public static void main(String[] args) {  
        //Run the Window
    	
        //Return the date to the console for debugging purposes.
        NetworkDemo nd = new NetworkDemo();                                      //Instantiate the NetworkDemo class and create object nd
    	String dtm = nd.getDate();                                               //Call getDate on object nd and return String date to dtm
    	System.out.println("Thanks for using the app today, " + dtm);            //Output String to the console for debugging
    } 

}
