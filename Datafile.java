//NAME        : P PUJITHA SRI LAKSHMI PALADUGU
//NET ID      : PXP142730
//DATE STARTED: 9/20/2014.
//PURPOSE     : This is the assignment for the class CS6301.02. < CONTACT MANAGER>. 
//The user can Add, delete, Update and View the contact.
//DESCRPTION   :This is the main class which handles all the three model,view,controller file
//it also sets the size of the main panel.



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Datafile {
	
	public static void main(String[] args) {
		Viewfile theview=new Viewfile();
		
		Modelfile themodel=new Modelfile();
		Controllerfile thecontroller=new Controllerfile(theview,themodel);
		
		theview.setSize(1200,600);
		theview.setVisible(true);
		theview.setLocationRelativeTo(null);
		theview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
	}
	

}
