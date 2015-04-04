//NAME        : P PUJITHA SRI LAKSHMI PALADUGU
//NET ID      : PXP142730
//DATE STARTED: 9/20/2014.
//PURPOSE     : This is the assignment for the class CS6301.02. < CONTACT MANAGER>. 
//The user can Add, delete, Update and View the contact.
//DESCRPTION   :This module mainly handles the view part. All the users action are handled 
//in the module. The User interface is designed. User can interact with view. He is unaware 
//of the background process.


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


                                                                                                                                                                                                                                                                                                                                 
public class Viewfile extends JFrame {
	//declares all the jlabels which are to be shown to the user.
	private JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11,jl12,jl13,jl14,jl15;
	//declares all the textfields which are to be to the user.
	private JTextField jt1, jt2, jt3, jt5, jt6, jt7, jt8, jt9, jt10, jt11,jt12,jt13;
	//declares button to be shown to the user
	private JButton jb1, jb2, jb3,jb4;
	//All the panels 
	private JPanel  jp1, jp2, jp3, jp4, jp5,jp6,jp7,jp8,jp0;
	//All the fields for which the user has to enter data
	private String  fname, mname, lname, address1, address2, city, state,
			        zipcode, phoneNo, gender, tempname;
	private Scanner file1;
	//declares the listdata
	JList filelist;
	//declares the combobox to select gender
	JComboBox Gender;
	int i;
	int m=0;
	int counter1=0;
	//Scrollpane to add to the list.
	private JScrollPane scrollPane;
	String[][]  columnFields;
	String[]    firstname;
	DefaultListModel filemodel = new DefaultListModel();
	private JProgressBar progressbar;
	

//This constructor has the labels and textfields and uses the gridbaglayout to display all the
//textfields,buttons,lists and label in a particular order. 

public Viewfile() {
	
	super("Contact Manager");
	
	jp1 = new JPanel(new GridBagLayout());
	jp1.setSize(600, 800);
	progressbar=new JProgressBar(0,100);
	
	GridBagConstraints gc = new GridBagConstraints();
	jl1 = new JLabel("First Name* ", JLabel.RIGHT);
	jl1.setToolTipText("Special character/Numbers not allowed");
	jt1 = new JTextField(20);
	jt1.setDocument(new TextCharlimit(20));
//Each text field has a key listener to restrict special characters,if user enters any.	
	
	jt1.addKeyListener(new KeyAdapter() {
	   public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if  ( c =='@'|| c=='*' || c== '&'|| c== '%' || Character.isDigit(c)|| c == e.VK_BACK_SPACE
				|| c == e.VK_DELETE || c== '#' || c== '^'|| c== '!'|| c== '$'|| c=='/'|| c== e.VK_PASTE) 
			{
				getToolkit().beep();
				e.consume();
			}
			
		}

	});
	jl2 = new JLabel("Last Name* ", JLabel.RIGHT);
	jl2.setToolTipText("Special character/Numbers not allowed");
	jt2 = new JTextField(20);
	jt2.setDocument(new TextCharlimit(20));
	jt2.addKeyListener(new KeyAdapter() {
		   public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if  ( c =='@'|| c=='*' || c== '&'|| c== '%' || Character.isDigit(c)|| c == e.VK_BACK_SPACE
						|| c == e.VK_DELETE || c== '#' || c== '^'|| c== '!'|| c== '$'|| c=='/'||c== e.VK_PASTE)
				{
					getToolkit().beep();
					e.consume();
				}
			}

		});



	jl3 = new JLabel("Middle Initial  ", JLabel.RIGHT);
	jl3.setToolTipText("Special character/Numbers not allowed");
	jt3 = new JTextField(20);
	jt3.setDocument(new TextCharlimit(1));
	jt3.addKeyListener(new KeyAdapter() {
		   public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if  ( c =='@'|| c=='*' || c== '&'|| c== '%' || Character.isDigit(c)|| c == e.VK_BACK_SPACE
				|| c == e.VK_DELETE || c== '#' || c== '^' || c== '!'|| c== '$'|| c=='/'|| c== e.VK_PASTE) {
					getToolkit().beep();
					e.consume();
				}
			}

		});

	jl5 = new JLabel("Address1*", JLabel.RIGHT);
	jt5 = new JTextField(20);
	jt5.setDocument(new TextCharlimit(35));
	jt5.addKeyListener(new KeyAdapter() {
		   public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if  ( c=='/') {
					getToolkit().beep();
					e.consume();
				}
			}

		});
	

	jl6 = new JLabel("Address2");
	jt6 = new JTextField(20);
	jt6.setDocument(new TextCharlimit(35));

    	
	jl7 = new JLabel("City*");
	jt7 = new JTextField(20);
	jt7.setDocument(new TextCharlimit(25));
	jl8 = new JLabel("State*");
	jt8 = new JTextField(20);
	jt8.setDocument(new TextCharlimit(2));
   
	jl9 = new JLabel("Zipcode*");
	jl9.setToolTipText("Only digits allowed");
	jt9 = new JTextField(20);
	jt9.setDocument(new TextCharlimit(9));
    jt9.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (!(Character.isDigit(c)) || c == e.VK_BACK_SPACE
					|| c == e.VK_DELETE|| c== e.VK_PASTE) {
				getToolkit().beep();
				e.consume();
			}
		}

	});

    
 	jl10 = new JLabel("Phone Number*  ");
	jl10.setToolTipText("Only digits allowed");
	jt10 = new JTextField(20);
	jt10.setDocument(new TextCharlimit(21));
	jt10.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (!(Character.isDigit(c)) || c == e.VK_BACK_SPACE
					|| c == e.VK_DELETE || c== e.VK_PASTE) {
				getToolkit().beep();
				e.consume();
			}
		}

	});



	jl11=new JLabel("Gender*  ");
	jl13=new JLabel("Country* ");
    jt11=new JTextField(20);
    jt11.setDocument(new TextCharlimit(30));
    jt11.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if( c =='@'|| c=='*' || c== '&'|| c== '%' || Character.isDigit(c)|| c == e.VK_BACK_SPACE
				|| c == e.VK_DELETE || c== '#' || c== '^'|| c== '!'|| c== '$'|| c=='/'|| c== e.VK_PASTE)
				
			   {
				getToolkit().beep();
				e.consume();
			}
		}

	});

    jl14=new JLabel("Email* ");
    jt13=new JTextField(20);
   
    jt13.setDocument(new TextCharlimit(30));
    
    
    
    
    Gender= new JComboBox();
    DefaultComboBoxModel GenderModel = new DefaultComboBoxModel();
    GenderModel.addElement("M");
    GenderModel.addElement("F");
    Gender.setModel(GenderModel);
    
    
    
    

    jl12=new JLabel("The above fields with *  are mandatory");
    jl12.setVisible(false);
    jl12.setForeground(Color.red);
    jl15=new JLabel("Duplicate Entry");
    jl15.setVisible(false);
    jl15.setForeground(Color.red);
	
	jb1 = new JButton("ADD");
	jb4=  new JButton("UPDATE"); 
	jp0 =new JPanel(new FlowLayout());
	progressbar.setPreferredSize( new Dimension( 200,20  ) );
	jb4.setEnabled(false);
	jp0.add(progressbar);
	gc.anchor = (GridBagConstraints.LINE_START);
	gc.weightx = 3.0;
	gc.weighty = 0.5;
	gc.anchor = (GridBagConstraints.LINE_START);
	
	
	//This displays the first column in panel1
	gc.gridx=0;
	gc.gridy=0;
	jp1.add(jp0,gc);
	
	gc.weightx = 0.5;
	gc.weighty = (0.5);
	gc.gridx = 0;
	gc.gridy = 1;
    jp1.add(jl1, gc);
    gc.gridx = 0;
	gc.gridy = 2;
	jp1.add(jl2, gc);
    gc.gridx = 0;
	gc.gridy = 3;
	jp1.add(jl3, gc); 
    gc.gridx = 0;
	gc.gridy = 4;
	jp1.add(jl5, gc); 
    gc.gridx = 0;
	gc.gridy = 5;
	jp1.add(jl6, gc);         
	gc.gridx = 0;
	gc.gridy = 6;		
	jp1.add(jl7, gc);
    gc.gridx = 0;
	gc.gridy = 7;
	jp1.add(jl8, gc); 
    gc.gridx = 0;
	gc.gridy = 8;
	jp1.add(jl9, gc);
    gc.gridx = 0;
	gc.gridy = 9;
	jp1.add(jl10, gc); 
    gc.gridx=0;
	gc.gridy=10;
	jp1.add(jl11,gc);
	
	gc.gridx=0;
	gc.gridy=11;
	jp1.add(jl13,gc);
	
	gc.gridx=0;
	gc.gridy=12;
	jp1.add(jl14,gc);
			
			

//	To display second column in panel1
	gc.anchor = (GridBagConstraints.LINE_START);
	gc.gridx = 1;
	gc.gridy = 1;
	jp1.add(jt1, gc);
    gc.gridx = 1;
	gc.gridy = 2;
	jp1.add(jt2, gc);
    gc.gridx = 1;
	gc.gridy = 3;
	jp1.add(jt3, gc);
    gc.gridx = 1;
	gc.gridy = 4;
	jp1.add(jt5, gc);    
    gc.gridx = 1;
    gc.gridy = 5;
    jp1.add(jt6, gc);   
    gc.gridx = 1;
    gc.gridy = 6;
    jp1.add(jt7, gc); 
    gc.gridx = 1;
    gc.gridy = 7;
    jp1.add(jt8, gc);
    gc.gridx = 1;
    gc.gridy = 8;
    jp1.add(jt9, gc);
    gc.gridx = 1;
    gc.gridy = 9;
    jp1.add(jt10, gc);    
    gc.gridx=1;
    gc.gridy=10;
    jp1.add(Gender,gc);
    
    gc.gridx=1;
    gc.gridy=11;
    jp1.add(jt11,gc);
    gc.gridx=1;
    gc.gridy=12;
    jp1.add(jt13,gc);
    
    gc.gridx=1;
    gc.gridy=13;
    jp1.add(jl12,gc);
    
    gc.gridx=1;
    gc.gridy=14;
    jp1.add(jl15,gc);
    
    gc.anchor = GridBagConstraints.FIRST_LINE_START;
    gc.gridx = 1;
    gc.gridy = 15;
    jp5 =new JPanel(new FlowLayout());
    jp5.add(jb1);
    jp5.add(jb4);
    jp1.add(jp5, gc);        
	
	jl4 = new JLabel("CONTACT LIST");
	jp2 = new JPanel(new BorderLayout());
	jb2 = new JButton("VIEW");
	jb3 = new JButton("DELETE");
    
	filelist = new JList();
	DefaultListModel filemodel = new DefaultListModel();
	filelist.setModel(filemodel);
     
    
//To Display buttons, file list and label in second Panel
	
	filelist.setBorder(BorderFactory.createEtchedBorder());

	filelist.setSelectedIndex(1);
    filelist.ensureIndexIsVisible(1);
	jp7=new JPanel();
	
    jp2.setSize(600,800);
    
	jp3 = new JPanel(new FlowLayout());
	jp4 = new JPanel();
    jp3.setSize(600,200);
 	jp3.add(jb2);
    jp3.add(jb3);
	jp7.add(jl4);
	jp4.setSize(600,1000);
	jp8=new JPanel(new BorderLayout());
	filelist.setPreferredSize(new Dimension(500,600));

	filelist.setVisibleRowCount(9);
	scrollPane = new JScrollPane();
	scrollPane.setViewportView(filelist);
	jp4.add(scrollPane);
	jp8.add(jp4,BorderLayout.NORTH);
	jp8.add(jp3,BorderLayout.CENTER);
    
    jp2.add(jp7,BorderLayout.NORTH);
	jp2.add(jp8, BorderLayout.CENTER);

   //splitpane splits the jp1,jp2 in to two equal halfs  
	JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
			jp1, jp2);
	
	jsplit.setOneTouchExpandable(true);
	getContentPane().add(jsplit);
	
	jt12=new JTextField("line number");
	jt12.setVisible(false);
	
 MyFocusEvent feo=new MyFocusEvent();
 
 jt1.addFocusListener(feo);
 jt2.addFocusListener(feo);
 jt5.addFocusListener(feo); 
 jt7.addFocusListener(feo);
 jt8.addFocusListener(feo);
 jt9.addFocusListener(feo);
 jt10.addFocusListener(feo);
 jt11.addFocusListener(feo);
 jt13.addFocusListener(feo);
}
void buttonlistener(ActionListener listenforbutton)
{
//All the actions are performed by calling the controller and the controller takes care of action part.	
	jb1.addActionListener(listenforbutton);
	jb2.addActionListener(listenforbutton);
	jb3.addActionListener(listenforbutton);
	jb4.addActionListener(listenforbutton);
	
}


//returns all the below textfields to the controller,when it calls corresponding textfields
public String getTextField1(){
         
        return (jt1.getText());
}

public String getTextField2(){
    
    return (jt2.getText());
}

public String getTextField3(){
    
    return (jt3.getText());
}

public String getTextField4(){
    
    return (jt5.getText());
}

public String getTextField5(){
    
    return (jt6.getText());
}

public String getTextField6(){
    
    return (jt6.getText());
}
public String getTextField7(){
    
    return (jt7.getText());
}

public String getTextField8(){
    
    return (jt8.getText());
}
public String getTextField9(){
    
   System.out.println(jt9.getText());	
    return (jt9.getText());
}
public String getTextField10(){
    
	   System.out.println(jt10.getText());	
	    return (jt10.getText());
	}
public String getTextField11(){
	System.out.println(jt12.getText());
    
    return (jt12.getText());
}
public String getTextField12(){
    
	   System.out.println(jt11.getText());	
	    return (jt11.getText());
	}
public String getTextField13(){
    
	   System.out.println(jt13.getText());	
	    return (jt13.getText());
	}

public String getgenderlist(){
	
	return(Gender.getSelectedItem().toString());
}
public int getfilelist(){

	
	return(filelist.getSelectedIndex());
}

//Checks and validates all the mandatory. It checks, if all the mandatory text fields are present or 
//not.
public boolean checktextfields()
{
	
	boolean check= true;
	
	if (jt1.getText().equals("") ||jt2.getText().equals("")||
			  jt5.getText().equals("")||jt7.getText().equals("")||
			  jt8.getText().equals("")||jt9.getText().equals("")||
			  jt10.getText().equals("")|| jt11.getText().equals("") || jt13.getText().equals(""))
	  { 
	       check = false;

         jl12.setText("The above fields with *  are mandatory");  
		 jl12.setVisible(true);   
		 jl15.setVisible(false);
	  }		
	
	
	  else
	{
		  
	     jl12.setVisible(false);

	}
	if(jt1.getText().contains("/") || jt2.getText().contains("/")|| jt3.getText().contains("/") ||
			jt5.getText().contains("/")	|| jt7.getText().contains("/")	|| jt8.getText().contains("/")	
			|| jt9.getText().contains("/")	|| jt10.getText().contains("/")	|| jt11.getText().contains("/")	
			|| jt13.getText().contains("/")	|| jt6.getText().contains("/")	
			)
	{
				check =false;
				jl12.setText("Wrong Character entered");
				jl12.setVisible(true);

				
	}	
	
	return check;
}

//sets the jlabel for duplicate entry to true and makes it visible.
public void setduplicate(boolean value)
{
	if (value== true){
		jl15.setVisible(true);
	}
	else
	{
		jl15.setVisible(false);
	}
}

//Sets the corresponding values into the textfields
public void  setTextFields(String textfield1, String textfield2, String textfield3, String textfield4, String textfield5, String textfield6, String textfield7,
		String textfield8, String textfield9,String textfield10,String textfield12,String textfield13,String textfield11){
	m=0;
	progressbar.setValue(m);
	
	    
    if(!textfield1.equals(" "))
    { 	
    jt1.setText(textfield1);
    m=m+11;
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
    	jt1.setText(textfield1);
    }	
    
    if (!textfield2.equals(" "))
    {	
    jt2.setText(textfield2);
    m=m+11;
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
    	jt2.setText(textfield1);
    }	
    
    jt3.setText(textfield3);
    
    if(!textfield4.equals(" "))
    {	
    jt5.setText(textfield4);
    m=m+11;
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
    	jt5.setText(textfield1);
    }	
   
    jt6.setText(textfield5);
    
    if(!textfield6.equals(" "))
    {
    jt7.setText(textfield6);
    m=m+11;
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
    	
     jt7.setText(textfield1);
     }
    if(!textfield7.equals(" "))
    {	
    jt8.setText(textfield7);
    m=m+11;
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
     jt8.setText(textfield1);
     }
    if(!textfield8.equals(" "))
    {
    m=m+11;
    jt9.setText(textfield8);
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
    	jt9.setText(textfield8);
    }
    if(!textfield9.equals(" "))
    {
    m=m+11;	
    jt10.setText(textfield9);
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
    	jt10.setText(textfield9);
    }
    System.out.println("undetermined" +textfield11);
    if ( textfield11.equals("M"))
    {
    	System.out.println("hai");
    //	System.out.println(textfield11);
    	Gender.setSelectedIndex(0);
    }
    else
    {
       Gender.setSelectedIndex(1);
    }
    
    int k       =filelist.getSelectedIndex();
    textfield11 = Integer.toString(k);
    jt12.setText(textfield11);
    
    if(!textfield12.equals(" "))
    {
    m=m+11;	
    jt11.setText(textfield12);
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
    	jt11.setText(textfield12);
    }
    if(!textfield13.equals(" "))
    {
    m=m+12;	
    jt13.setText(textfield13);
    progressbar.setValue(m);
    System.out.println(m);
    progressbar.setStringPainted(true);
    }
    else
    {
    	jt13.setText(textfield13);
    }
    
}

//Disables  and enables the button, when needed and when called by controller.
public void disablebutton(String Button)
{
if (Button=="B1")
{
	jb1.setEnabled(false);
}


if (Button=="B3")
{
	jb2.setEnabled(false);
}
if (Button=="B4")
{
	jb3.setEnabled(false);
	

}

if (Button=="B2")
{
	jb4.setEnabled(false);
}
}
public void enablebutton(String Button)
{
if (Button=="B1")
{
	jb1.setEnabled(true);
}
if (Button=="B3")
{
	jb2.setEnabled(true);
}
if (Button=="B4")
{
	jb3.setEnabled(true);
}
if (Button=="B2")
{
	jb4.setEnabled(true);
}

}

//This method is invoked by the controller class,when the listdata has to be displayed. This is called 
//when user adds,updates and deletes the record from the JFrame
public void displaylist(String name, String phone,int m,int n)
{
    if (n==0)
    {
    	columnFields=new String[m+1][2];
    	columnFields[0][0]="NAME";
    	columnFields[0][1]="PHONE NUMBER";
    			
    }
   
//	filelist.setModel(filemodel);
	System.out.println(filemodel);
    filelist.setVisibleRowCount(9);
    if (n<m)
    {	
      columnFields[n+1][0]=name;
	  System.out.println(name);
	  columnFields[n+1][1]=phone;
	  filelist.setListData(columnFields);
	  filelist.setCellRenderer(new MyCellRenderer());
    }
    
    }

//Removes the corresponding line from the list
public void removelistelement()
{
	
	int k=filelist.getSelectedIndex();
	System.out.println(k);
	                            

	System.out.println(filelist);
	
  
}
//This class mainly sets a limit to the number of character entered by the user.
//it restricts extra  characters,if user enters any. 
public class TextCharlimit extends PlainDocument {
	
	private int charlimit;
	
	public TextCharlimit(int limit)
	{
		this.charlimit=limit;
		
	}
	public void insertString(int Offset, String str, AttributeSet set) throws BadLocationException
	{
		if (str== null)
		{
			return;
	    }else if (str.length()+getLength()<=charlimit)
	    {
	    	
	    	super.insertString(Offset, str, set);
	    }
		
	}

}
//This class is called by every text field and progress bar is set based on the data entered in the mandatory text fields

public class MyFocusEvent implements FocusListener
{

	@Override
	public void focusGained(FocusEvent fe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent fe) {
		// TODO Auto-generated method stub
		m=0;
		progressbar.setValue(m);

		if(jt1.getText().trim().length()!=0)
		{
		

     	 m=m+11;

		 progressbar.setValue(m);

		 progressbar.setStringPainted(true);
		}
		
		
		if(jt2.getText().trim().length()!=0)
		{			
		 
		 m=m+11;
		 progressbar.setValue(m);
		 progressbar.setStringPainted(true);
		}
		
		if(jt5.getText().trim().length()!=0)
		{			
		 
		 m=m+11;
		 progressbar.setValue(m);
		 progressbar.setStringPainted(true);
		}

		if(jt7.getText().trim().length()!=0)
		{			
		 
		 m=m+11;
		 progressbar.setValue(m);
		 progressbar.setStringPainted(true);
		}
		if(jt8.getText().trim().length()!=0)
		{			
		 

		 m=m+11;
		 progressbar.setValue(m);
		 progressbar.setStringPainted(true);
		}
		if(jt9.getText().trim().length()!=0)
		{			
		 
		 m=m+11;
		 progressbar.setValue(m);
		 progressbar.setStringPainted(true);
		}
		if(jt10.getText().trim().length()!=0)
		{			
		 
		 m=m+11;
		 progressbar.setValue(m);
		 progressbar.setStringPainted(true);
		}
		if(jt11.getText().trim().length()!=0)
		{			
		 
		 m=m+11;
		 progressbar.setValue(m);
		 progressbar.setStringPainted(true);
		}
		if(jt13.getText().trim().length()!=0)
		{			
		 
		 m=m+12;
		 progressbar.setValue(m);
		 progressbar.setStringPainted(true);
		}	
	
	}
	
}
//This class is called when the list data has to be displayed in the listbox.

static class MyCellRenderer extends JPanel implements ListCellRenderer {

	// @Override
//Creates two labels for the filelist.
	
	JLabel firstcolumn, secondcolumn;

	MyCellRenderer() {
		setLayout(new GridLayout(1, 2));
		firstcolumn = new JLabel();
		secondcolumn = new JLabel();
		firstcolumn.setOpaque(true);
		secondcolumn.setOpaque(true);
		add(firstcolumn);
		add(secondcolumn);

	}

	public Component getListCellRendererComponent(JList filelist,
			Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
      //Displays the corresponding labels created in the filelist.
		String leftData = ((String[]) value)[0];
		String middleData = ((String[]) value)[1];
		firstcolumn.setText(leftData);
		secondcolumn.setText(middleData);

		if (isSelected) {

			String Column1 = firstcolumn.getText();
			String Column2 = secondcolumn.getText();

			firstcolumn.setBackground(filelist.getSelectionBackground());
			secondcolumn.setForeground(filelist.getSelectionForeground());

			firstcolumn.setBackground(filelist.getSelectionBackground());
			secondcolumn.setForeground(filelist.getSelectionForeground());
		} else {
			firstcolumn.setBackground(filelist.getBackground());
			firstcolumn.setForeground(filelist.getForeground());
			secondcolumn.setBackground(filelist.getBackground());
			secondcolumn.setForeground(filelist.getForeground());
		}
		setEnabled(filelist.isEnabled());
		setFont(filelist.getFont());
	
		return this;
	}

}
}



