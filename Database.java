//NAME        : P PUJITHA SRI LAKSHMI PALADUGU
//NET ID      : PXP142730
//DATE STARTED: 9/20/2014.
//PURPOSE     : This is the assignment for the class CS6301.02. < CONTACT MANAGER>. 
//The user can Add, delete, Update and View the contact.
//DESCRPTION   :This module mainly handles the back end database part. All the file operations are handled 
//in the module. The basic file operations like "ADD", "DELETE" are done in this class



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;


public class Database {
	private String filedata; 
	
//Reads entire file,stores it in the variable 'filedata', also counts no of lines in the files	
public ArrayList<String> readfile() {

		 	
			ArrayList<String> records = new ArrayList<String>();
			try {
				FileReader fr = new FileReader("filedata.txt");
				BufferedReader br = new BufferedReader(fr);
				int count = 0;
				while ((filedata = br.readLine()) != null) {
					records.add(filedata);
					System.out.println(filedata);
					

				}

				System.out.println(count);
				

			} catch (IOException ae1) {
				System.out.println("error in reading file");
			}
			return records;
	}
		
//Recieves the entire line to written from the controller class and 
//Writes the entire data into the file "fieldata.txt"	
public void writefile(String nline) {
		
    BufferedWriter w = null;
    DefaultListModel filemodel = new DefaultListModel();
    try {
	  FileWriter f = new FileWriter("filedata.txt", true);
    	 		w = new BufferedWriter(f);
    			f.write(nline);
                w.newLine();
			    w.close();
		} catch (IOException ae) {
			System.out.println("Error" + ae.getMessage());
		}
}
//deletes the corresponding line from the file by copying entire data to the new file and
//and renaming the file with existing file name and deletes the old file.
public String deletefile(int x) {
	
	// deletes the corresponding line from the file. To do that we use temp file, write all the rows except corresponding
	//line and rename the file
	String sb1 = null;
	try {

		File infile = new File("filedata.txt");
		File temfile = new File("tempfile.txt");
		BufferedReader b = new BufferedReader(new FileReader(infile));
		BufferedWriter f6 = new BufferedWriter(new FileWriter(temfile));
		String currentline;
		System.out.println("the line no to be deleted" +x);
		int count1 = 0;
		while ((currentline = b.readLine()) != null) {

			count1++;
			if (count1 == x ) {
				sb1 = currentline;
			} else {
				
				f6.write(currentline);
				f6.newLine();
			}
		}
		System.gc();
		b.close();
		f6.close();

		infile.delete();
		boolean successful = temfile.renameTo(infile);
		System.out.println("delete" +successful);
	}

	catch (IOException ae) {
		System.out.println("eror" + ae.getMessage());

	}

	
	return sb1;
}

}
