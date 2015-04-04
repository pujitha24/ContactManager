
//NAME        : P PUJITHA SRI LAKSHMI PALADUGU
//NET ID      : PXP142730
//DATE STARTED: 9/20/2014.
//PURPOSE     : This is the assignment for the class CS6301.02. < CONTACT MANAGER>. 
//The user can Add, delete, Update and View the contact.
//DESCRPTION   :This module mainly controls the view class and model class.  It gets the user entered data from the view class. 
//and send it to the database class and to store the data. It also gets and sets the records in the model class. It mainly handles three basic 
//operations like 'ADD','DELETE', 'VIEW' AND 'UPDATE'



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Controllerfile {

	private Viewfile theview; 
	private Modelfile themodel;
	Database d = new Database(); //new instance for the database class
	
// All the list data to be displayed present in the file	
	String fname[];
	String firstname[]; 
	String phone[]; 
	String filedata;
    String name[];
    String lname[];
    String mname[];
    String Address1[]; 
    String Address2[];
    String City[];
    String State[];
    String ZipCode[];
    String Gender[];
    String Country[];
    String Email[];
    String Lno[];
    int i;
  //This is store the number of records in the file and the records. which can be splitted. 
	ArrayList<String> records1;
//All the textfields recieved from the view file	
	String textfield1, textfield2, textfield3, textfield4, textfield5, textfield6, textfield7, textfield8, textfield9, textfield10,textfield11,textfield12,textfield13;

	public Controllerfile(Viewfile theview, Modelfile themodel) {
		this.theview = theview;
		this.themodel = themodel;
		this.theview.buttonlistener(new buttonlistener());
		getfiledata();
		for (i = 0; i < records1.size(); i++) {
			System.out.println(phone[i]);
			theview.displaylist(fname[i], phone[i], records1.size(), i);
		}

	}

//This class has all the operations performed by the view file.	
	class buttonlistener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			
// When the user clicks on the 'ADD' method. This method is called. It first check if all the mandatory fields are empty or not. if not 
//stores the entire data in a string buffer and passes the data to write method in the 	database class. It also send all the fields to
//to the list in view class.			
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("ADD")) {
                 
				boolean check = theview.checktextfields();
				System.out.println(check);
				if (check == true) {
					StringBuffer sb = new StringBuffer();
					StringBuffer sb4 = new StringBuffer();
					textfield1 = theview.getTextField1();
					sb.append(textfield1);
					sb.append("/");
					textfield2 = theview.getTextField2();
					sb.append(textfield2);
					sb.append("/");
					textfield3 = theview.getTextField3();
					sb.append(textfield3);
					sb.append("/");
					textfield4 = theview.getTextField4();
					sb.append(textfield4);
					sb.append("/");
					textfield5 = theview.getTextField5();
					sb.append(textfield5);
					sb.append("/");
					textfield6 = theview.getTextField6();
					sb.append(textfield6);
					sb.append("/");
					textfield7 = theview.getTextField7();
					sb.append(textfield7);
					sb.append("/");
					textfield8 = theview.getTextField8();
					sb.append(textfield8);
					sb.append("/");
					textfield9 = theview.getTextField9();
					sb.append(textfield9);
					sb.append("/");
					textfield10 = theview.getTextField10();
					sb.append(textfield10);
					sb.append("/");
					
					sb.append(theview.getgenderlist());
					sb.append("/");
				    textfield12=theview.getTextField12();
				    sb.append(textfield12);
				 	sb.append("/");
					textfield13=theview.getTextField13();
					sb.append(textfield13);
					sb.append("/");
					getfiledata();
					sb.append(records1.size()+1);
					sb.append("/");
					String s = sb.toString();

					firstname = themodel.getfirstname();

					sb4.append(textfield1);
					sb4.append("/");
					sb4.append(textfield2);
					sb4.append("/");
					sb4.append(textfield3);
					sb4.append("/");
					String D = sb4.toString();
					System.out.println(D);

					int l, duplicates = 0;
//check if the new entry is a duplicate entry or not. Use a counter duplicate to check find 
//the count of duplicates in the file.
					for (l = 0; l < (records1.size()); l++) {
						if (firstname[l] != null && D != null
								&& firstname[l].compareTo(D) == 0) {

							duplicates++;
							System.out.println(D);
							System.out.println(duplicates);
						}
					}
// if the new entry is not duplicate. Write the data into the file and display the name 
//and phone to the user by calling view.  
					if (duplicates == 0) {
						String K = D.replaceAll("/", " ");
						d.writefile(s);
						getfiledata();
						phone = themodel.getphone();
						fname = themodel.getfname();
//Gets each record from the file and and displays it to the user					
						for (i = 0; i < records1.size(); i++) {
							System.out.println(phone[i]);
							theview.displaylist(fname[i], phone[i],
									records1.size(), i);
							theview.setTextFields(" ", " ", " ", " ", " ", " ",
									" ", " ", " ", " ", " "," "," ");
							theview.setduplicate(false);
						}
						
			
					}
//if duplicate entry is present,notify to the view, that the entry is a duplicate.
					else
					{
					  theview.setduplicate(true);
					}

				}

			}
//The view gets the corresponding row,when the user clicks on the view button and display it to the user.
			
			if (e.getActionCommand().equals("VIEW")) {
				
				int x=theview.getfilelist();
				getfiledata();
			    for (i=0; i<records1.size()+1;i++)
			    {
			    	if (i==x) 			    	
			    	{
			    	if(i-1< 0)	
			    	{	
			 
			    	System.out.println("idiot");
			    	}
			    	else
			    	{	
			    	System.out.println(Lno[i-1]);	
			        theview.setTextFields(name[i-1], lname[i-1], mname[i-1], Address1[i-1], Address2[i-1], City[i-1], State[i-1], ZipCode[i-1],phone[i-1],Gender[i-1],Country[i-1],Email[i-1],Lno[i-1]);
			    	}
			    }
			}
//Validates all the textfields			    
			    boolean check= theview.checktextfields();
			    String Button = "B1";
//disable add and delete button, to restrict user not to perform other operation			    
			    theview.disablebutton(Button);
			    Button = "B2";
			    theview.enablebutton(Button);
			    Button = "B4";
			    theview.disablebutton(Button);
			    
			    theview.setduplicate(false);


			}
//This updates the contact, when user updates the contact.It gets the corresponding line number and updates in the 
//file.			
			if(e.getActionCommand().equals("UPDATE"))
			{
	//checks and validates all the mandatory fields			
			boolean check = theview.checktextfields();	
			if (check == true) {
			   int x=Integer.parseInt(theview.getTextField11());
			   String sb3 = null;
			   System.out.print("PROPER LINE NO TO BE DELETED"+x);
			   sb3 = d.deletefile(x);
		       System.out.println(check);
	// writes all the textfields to a string Buffer sb4	       
				StringBuffer sb = new StringBuffer();
				StringBuffer sb4 = new StringBuffer();
				textfield1 = theview.getTextField1();
				sb.append(textfield1);
				sb.append("/");
				textfield2 = theview.getTextField2();
				sb.append(textfield2);
				sb.append("/");
				textfield3 = theview.getTextField3();
				sb.append(textfield3);
				sb.append("/");
				textfield4 = theview.getTextField4();
				sb.append(textfield4);
				sb.append("/");
				textfield5 = theview.getTextField5();
				sb.append(textfield5);
				sb.append("/");
				textfield6 = theview.getTextField6();
				sb.append(textfield6);
				sb.append("/");
				textfield7 = theview.getTextField7();
				sb.append(textfield7);
				sb.append("/");
				textfield8 = theview.getTextField8();
				sb.append(textfield8);
				sb.append("/");
				textfield9 = theview.getTextField9();
				sb.append(textfield9);
				sb.append("/");
				textfield10 = theview.getTextField10();
				sb.append(textfield10);
				sb.append("/");
			    sb.append(theview.getgenderlist());
				sb.append("/");
				textfield12=theview.getTextField12();
				sb.append(textfield12);
				sb.append("/");
				textfield13=theview.getTextField13();
				sb.append(textfield13);
				sb.append("/");
				textfield11	 = theview.getTextField11();
				sb.append(textfield11);
				sb.append("/");
	            getfiledata();			
				String s = sb.toString();
				sb4.append(textfield1);
				sb4.append("/");
				sb4.append(textfield2);
				sb4.append("/");
				sb4.append(textfield3);
				sb4.append("/");
				String D = sb4.toString();
	  			System.out.println(D);
       			int l, duplicates = 0;
//Counts the number of duplicates,if present in the file.
				for (l = 0; l < (records1.size()); l++) {
					if (firstname[l] != null && D != null
								&& firstname[l].compareTo(D) == 0) {

							duplicates++;
							System.out.println(D);
							System.out.println(duplicates);
						}
					}
//if no duplicate is present, writes the data in to the file.
				if (duplicates == 0) {
						String K = D.replaceAll("/", " ");
						d.writefile(s);
						getfiledata();
						for (i = 0; i < records1.size(); i++) {
							System.out.println(phone[i]);
							theview.displaylist(fname[i], phone[i],
									records1.size(), i);
				}
				System.out.println("common");
				theview.setTextFields(" ", " ", " ", " ", " ", " ",
									" ", " ", " "," ", " "," "," ");
				theview.setduplicate(false);	
				String Button = "B1";
				theview.enablebutton(Button);
				Button = "B3";
			    theview.enablebutton(Button);
			    Button = "B4";
			    theview.enablebutton(Button);	
			    Button="B2";
			    theview.disablebutton(Button);
				}
				if(duplicates > 0)
				{
					
				System.out.println("uncommon");
	              theview.setduplicate(true);				
				}
	
					
										
				}


			 
				
			}
				
//Deletes the corresponding line from the file.	Sends delete message to the database class to delete the corresponding
//row			
			if (e.getActionCommand().equals("DELETE")) {
				int x = theview.getfilelist();
    			String sb3 = null;
    			sb3 = d.deletefile(x);
				System.out.println(sb3);
				records1 = d.readfile();
				getfiledata();
				for (i = 0; i < records1.size(); i++) {
					System.out.println(phone[i]);
					theview.displaylist(fname[i], phone[i], records1.size(), i);
				}

				System.out.println("hello");
				System.out.print(x);
				System.out.println(sb3);

			}
		}

	}
	
	
//Splits all the records in file and stores in corresponding fields. It also sets all the fields in
//model class.	
	public void splitlist(ArrayList<String> records1) {
		firstname = new String[records1.size() + 1];
		fname = new String[records1.size() + 1];
		phone = new String[records1.size() + 1];
		name=new String[records1.size() + 1];
		mname=new String[records1.size() + 1];
		lname=new String[records1.size() + 1];
		Address1 = new String[records1.size() + 1];
		Address2 = new String[records1.size() + 1];
		City=new String[records1.size() + 1];
		State=new String[records1.size() + 1];
		ZipCode=new String[records1.size() + 1];
		Gender=new String[records1.size()+1];
		Country=new String[records1.size()+1];
		Email=new String[records1.size()+1];
		Lno=new String[records1.size()+1];

		// Remove white spaces from the lines
		for (int j = 0; j < records1.size(); j++) {
			if (records1.get(j).trim().length() == 0) {
				records1.remove(j);
			}
		}

		
		for (int i = 0; i < records1.size(); i++) {

			String[] array = records1.get(i).split("/");

			StringBuffer sb2 = new StringBuffer();
			StringBuffer sb3 = new StringBuffer();
			name[i] = array[0].trim();
			lname[i] = array[1].trim();
			mname[i] = array[2].trim();
			Address1[i] = array[3].trim();
			Address2[i]=array[4].trim();
			City[i]=array[6].trim();
			State[i]=array[7].trim();
			ZipCode[i]=array[8].trim();
			phone[i] = array[9].trim();
			Gender[i]=array[10].trim();
			Country[i]=array[11].trim();
			Email[i]=array[12].trim();
			System.out.println(Email[i]);
			Lno[i]=array[13].trim();
	        sb2.append(name[i]);
			sb2.append("/");
			sb2.append(lname[i]);
			sb2.append("/");
			sb2.append(mname[i]);
			sb2.append("/");
			sb3.append(name[i]);
			sb3.append(" ");
			sb3.append(lname[i]);
			sb3.append(" ");
			sb3.append(mname[i]);
			sb3.append(" ");
			firstname[i] = sb2.toString();
			fname[i] = sb3.toString();
			
			System.out.println("hai");
			System.out.println(firstname[i]);

		}
		  themodel.setAddress1(Address1);
		  themodel.setName(name);
		  themodel.setLname(lname);
		  themodel.setMname(mname);
		  themodel.setAddress2(Address2);
		  themodel.setCity(City);
		  themodel.setState(State);
		  themodel.setZipcode(ZipCode);
		  themodel.setFirstname(firstname);
		  themodel.setFname(fname);
		  themodel.setPhone(phone);
		  themodel.setGender(Gender);
		  themodel.setLno(Lno);
          themodel.setCountry(Country); 
          themodel.setEmail(Email);
	}

	
	//This method calls readfile and splitlist methods and gets the corresponding records from the
	//model class
	public void getfiledata()
	{
		records1 = new ArrayList<String>();
		records1 = d.readfile();
		splitlist(records1);
	    phone    = themodel.getphone();
		fname    = themodel.getfname();
		Address1 =themodel.getAddress1();
	    name     =  themodel.getName();
	    lname    =themodel.getLname();
	    mname    =themodel.getMname();
	    Address2 =themodel.getAddress2();
	    City     =themodel.getCity();
        State    =themodel.getState();
	    ZipCode  =themodel.getZipcode();
	    firstname= themodel.getFirstname();
	    Gender   =themodel.getGender();
	    Country  =themodel.getCountry();
	    Email    =themodel.getEmail();
	}

}


