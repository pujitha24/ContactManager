//NAME        : P PUJITHA SRI LAKSHMI PALADUGU
//NET ID      : PXP142730
//DATE STARTED: 9/20/2014.
//PURPOSE     : This is the assignment for the class CS6301.02. < CONTACT MANAGER>. 
//The user can Add, delete, Update and View the contact.
//DESCRPTION   :This module mainly handles the Model part.  This class basically
//sets and gets all the records to be used by the controller.


public class Modelfile {
	
// All the the fields which are in the view should be in the model file.	
	private String fname[];
	private String name[];
	private String mname[];
	private String lname[];
	private String firstname[];
	private String phone[];
	private String Address1[];
	private String Address2[];
	private String City[];
	private String State[];
	private String Zipcode[];
	private String Gender[];
	private String Country[];
	private String Email[];
	private String Lno[];
	
	
	//Gets and sets all the records which are read from the file and written into the file

	
	public String[] getName() {
		return name;
	}
	
	
		public void setName(String[] name) {
		this.name = name;
	}

	public String[] getMname() {
		return mname;
	}

	public void setMname(String[] mname) {
		this.mname = mname;
	}

	public String[] getLname() {
		return lname;
	}

	public void setLname(String[] lname) {
		this.lname = lname;
	}

	public String[] getAddress1() {
		return Address1;
	}

	public void setAddress1(String[] address1) {
		Address1 = address1;
	}

	public String[] getAddress2() {
		return Address2;
	}

	public void setAddress2(String[] address2) {
		Address2 = address2;
	}

	public String[] getCity() {
		return City;
	}

	public void setCity(String[] city) {
		City = city;
	}

	public String[] getState() {
		return State;
	}

	public void setState(String[] state) {
		State = state;
	}

	public String[] getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String[] zipcode) {
		Zipcode = zipcode;
	}

	
	

	public String[] getFname() {
		return fname;
	}

	public void setFname(String[] fname) {
		this.fname = fname;
	}

	public String[] getFirstname() {
		return firstname;
	}

	public void setFirstname(String[] firstname) {
		this.firstname = firstname;
	}

	public String[] getPhone() {
		return phone;
	}

	public void setPhone(String[] phone) {
		this.phone = phone;
	}

	
	

	public String[] getfirstname() {
		return firstname;
	}

	public String[] getphone() {
		return phone;
	}

	public String[] getfname() {
		return fname;
	}
	
	public String[] getGender() {
		return Gender;
	}

	public void setGender(String[] gender) {
		Gender = gender;
	}



	public String[] getCountry() {
		return Country;
	}

	public void setCountry(String[] country) {
		Country = country;
	}

	public String[] getEmail() {
		return Email;
	}

	public void setEmail(String[] email) {
		Email = email;
	}

	
	public String[] getLno() {
		return Lno;
	}

	public void setLno(String[] lno) {
		Lno = lno;
	}
	
	

}
