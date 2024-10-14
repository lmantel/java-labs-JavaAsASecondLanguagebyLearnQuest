package order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrderIt extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;   //Declare the components used in the application
	JFrame frm;
	JLabel l,labq, labItm, labGetIt;
	JCheckBox cb1,cb2,cb3;  
	JButton btn;
	JTextField tf2, tf3;
	JRadioButton rbDel, rbPickUp, rbInStore;
	JComboBox combo;
	
	double pizza = 10.00;                             //Double data for cost calculation
	double burger = 5.00;
	double soda = 2.00; 
	
	double pizzatot;                                 //Subtotals for each item ordered qty* item cost
	double burgtot;
	double sodaTotal;
	double grandTotal;                                //The full total of all ordered items
	
	int frmX=500;                                    //int variable to use to set JFrame width
	int frmY=400;                                    //int variable to use to set JFrame height
	String pizzaCaption = "Pizza for $" + pizza;     //Build RadioButton caption with item price variable
	String burgerCaption = "Burger for $" + burger;
	String sodaCaption = "Drink for $" + soda;
	String theOrder="";                         //Confirmation String built to output the full order to user 
	String getIt="";                            //String variable to hold user selected delivery method
	int orderNum=100;                          //Initialize the start for an order number
	
	OrderIt() {                                      //Class constructor to initialize 
		frm=new JFrame();                            //Instantiate the classes for the JFrame
		frm.setTitle("Place Your Order");   
		tf2=new JTextField();
		tf3=new JTextField();
		rbDel=new JRadioButton("Delivery");
		rbPickUp=new JRadioButton("Curb Side Pickup");
		rbInStore=new JRadioButton("In Store Pickup");
		ButtonGroup bg=new ButtonGroup();              //Instantiate a ButtonGroup to group the radio buttons
		bg.add(rbDel);                                 //Add the radio buttons to the button group
		bg.add(rbPickUp);
		bg.add(rbInStore);
				
		String amt[]={"","1","2","3","4","5","6","7","8","9","10"};   //String array for ComboBox listing
		combo=new JComboBox(amt);  //Instantiate the ComboBox, pass the String array amt, create combo object
		combo.setSelectedIndex(0); //Initialize the combobox selection to 0th member of String array amt
		
		l=new JLabel("Food Ordering System");  //Instantiate labels and pass in Strings for the captions 
		labq=new JLabel("QTY");
		labItm=new JLabel("Items");
		labGetIt=new JLabel("Get It");
		cb1=new JCheckBox(pizzaCaption);    //Instantiate checkboxes and pass in Strings for the captions
		cb2=new JCheckBox(burgerCaption);
		cb3=new JCheckBox(sodaCaption);
		btn=new JButton("Submit Order");   //Instantiate button and pass in a String for the caption
		
		l.setBounds(170,5,300,20);         //Set the components' locations
		labq.setBounds(150, 35, 35, 25);
		labItm.setBounds(195, 35, 50, 25);
		labGetIt.setBounds(50, 210, 160, 25);
		cb1.setBounds(190, 60, 200, 25);
		cb2.setBounds(190, 90, 200, 25);
		cb3.setBounds(190, 120, 200, 25);
		btn.setBounds(150, 189, 150, 40);
		rbDel.setBounds(60, 230, 150, 25);
		rbPickUp.setBounds(60, 250, 150, 25);
		rbInStore.setBounds(60, 270, 150, 25);
		rbInStore.setSelected(true);             //Initialize the radio button selected at startup
		labGetIt.setText("Get It:");             //Create a label for the JFrame, and pass in the text
		combo.setBounds(128, 63, 45, 22);        //Set the components' locations
		tf2.setBounds(150, 90, 25, 22);
		tf3.setBounds(150, 120, 25, 22);
		
		frm.add(l);                    //Add the components to the form, frm
		frm.add(labq);
		frm.add(labItm);
		frm.add(labGetIt);
		frm.add(cb1);
		frm.add(cb2);
		frm.add(cb3);
		frm.add(btn);
		frm.add(tf2);
		frm.add(tf3);
		frm.add(rbDel);
		frm.add(rbInStore);
		frm.add(rbPickUp);
		frm.add(combo);
		frm.setLayout(null);                               //Disable Flow Layout. Enable developer Layout
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set the standard JFrame close button operation
		frm.setSize(frmX, frmY);                            //Pass in variables to size the JFrame, frm
		frm.setLocationRelativeTo(null);                    //Locate frm relative to the screen center
		frm.setVisible(true);                               //Make JFrame frm visible
		
		btn.addActionListener(this);                        //Set the user actions Listener on the button
	}
	
	public void actionPerformed(ActionEvent e) { //Process the action the user takes
		if(e.getSource()==btn) {                 //Test to see if the button, btn, was clicked
			if(cb1.isSelected()) {               //test if checkbox 1 is selected
				try {
					//pizza
					String sel = combo.getSelectedItem().toString(); //Get the ComboBox selection as a String
					int qty = Integer.parseInt(sel); //Parse the ComboBox selection to int data. Test for success or failure
					pizzatot = qty*pizza;  //Calculate the total cost of all pizzas
					grandTotal += pizzatot;  //Update the grand total cost and add the pizza subtotal
					theOrder = theOrder + qty + " pizzas @ $" + pizza + ", subTotal $" + pizzatot + "\n";  //Build a string for output to the use for order confirmation
				}catch (Exception ex) {   //in the event of integer parse failure
					JOptionPane.showMessageDialog(this,"Pizza checked, but no qty selected for pizza"); //Output message box to the user
					combo.setSelectedIndex(0);    //Reinitialize the totals and strings
					pizzatot=0;
					grandTotal=0;
					getIt="";
					theOrder="";
					return;                    //Exit the if block and continue to run the application
				}
			} //if cb1.isSelected()
			if(cb2.isSelected()) {
				try {
					int qty = Integer.parseInt(tf2.getText());  //Parse the ComboBox selection to int data. Test for success or failure
					burgtot = burger*qty;   //Calculate the total cost of all burgers
					grandTotal += burgtot;  //Update the grand total cost and add the burger subtotal
					theOrder = theOrder + qty + " burgers @ $" + burger + ", subTotal $" + burgtot + "\n"; //Build a string for output to the use for order confirmation
				}catch (Exception ex) {  //in the event of integer parse failure
					JOptionPane.showMessageDialog(this,"Burger checked, but no qty entered for burger"); //Output message box to the user
					tf2.setText(null);       //Reinitialize the totals, components, totals and strings
					burgtot=0;
					grandTotal=0;
					getIt="";
					theOrder="";
					return;                 //Exit the if block and continue to run the application
				}
			}
			if(cb3.isSelected()) {
				try {
					int qty = Integer.parseInt(tf3.getText()); //Parse the ComboBox selection to int data. Test for success or failure
					sodaTotal = qty*soda;       //Calculate the total cost of all sodas
					grandTotal += sodaTotal;   //Update the grand total cost and add the soda subtotal
					theOrder = theOrder + qty + " sodas @ $" + soda + ", subTotal $" + sodaTotal + "\n"; 
				}catch (Exception ex) {  //in the event of integer parse failure
					JOptionPane.showMessageDialog(this,"Soda checked, but no qty entered for soda"); //Output message box to the user
					tf3.setText(null);       //Reinitialize the totals, components, totals and strings
					sodaTotal=0;
					grandTotal=0;
					getIt="";
					theOrder="";
					return;                 //Exit the if block and continue to run the application
				} //catch
			}
			if(rbDel.isSelected()) {           //Test to see if radio button for delivery is selected 
				getIt="Delivery\n";             //Update the getIt String for confirmation output to the user
			}else if(rbPickUp.isSelected()) {  //Test to see if radio button for "Curb side pickup" is selected 
				getIt="Curb Side Pickup\n";    //Update the getIt String for confirmation output to the user
			}else if(rbInStore.isSelected()) {  //Test to see if radio button for in store pickup is selected 
				getIt="In Store Pickup\n";      //Update the getIt String for confirmation output to the user
			}
		} //if getSource
		if(cb1.isSelected()==false && cb2.isSelected()==false && cb3.isSelected()==false) { //Test to make sure at least 1 checkbox is selected
			JOptionPane.showMessageDialog(this,"No items selected"); //Message box alerts the user no checkboxes are selected
			return;  //Exit if block a resume the application
		}else {
		    String seperator = "\n" + getIt + "--------------------------\n"; //Build a String with delivery method, new lines, and  "--" characters for formatting
		    orderNum++;  //increment orderNum by 1 for the next order number
		    JOptionPane.showMessageDialog(this, "Thanks.  Order Submited.\n Order Number: " + orderNum + "\n\n" + theOrder + seperator + "Grant total: $"+ grandTotal + "\n\n"); //Build a String for the message box to output order cost and confirmation to the user
		    pizzatot=0;         //Reinitialize the totals, components, totals and strings for the next execution of the application
		    burgtot=0;
		    sodaTotal=0;
		    grandTotal=0;
		    getIt="";
		    theOrder="";
		    combo.setSelectedIndex(0);
		    tf2.setText(null);
		    tf3.setText(null);
		    cb1.setSelected(false);
		    cb2.setSelected(false);
		    cb3.setSelected(false);
		    rbInStore.setSelected(true);
		} //else
	} //actionPerformed
	
	public static void main(String[] args) { //Run the application
		// TODO Auto-generated method stub
		OrderIt order = new OrderIt();       //Instantiate the OrderIt class and create order object
	}

}