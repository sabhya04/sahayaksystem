package comm;

public class Coustmer {
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String fname;
private String lname; 
private String pass; 
private String cpass; 
private String gender; 
private String email;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getCpass() {
	return cpass;
}
public void setCpass(String cpass) {
	this.cpass = cpass;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "CoustmerDao [fname=" + fname + ", lname=" + lname + ", pass=" + pass + ", cpass=" + cpass + ", gender="
			+ gender + ", email=" + email + "]";
}
public String getDatabase() throws Exception
{
	CoustmerDao ct=new CoustmerDao();
	String s=ct.storeToDatabase(fname,lname,pass,cpass,gender,email);
	return s; 
}
}
