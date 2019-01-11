package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.sun.mail.iap.Response;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class SahayakDao {
	static Connection con;
static
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lavi");
		} 
	catch (Exception e) {
						e.printStackTrace();
						}
}
public String storeToDatabase(String fname,String lname,String pass,String cpass,String gender,String email,String city)
		throws Exception{
		String res="";
		Sahayak s=new Sahayak();
		PreparedStatement ps=con.prepareStatement("select seq_sahayak.nextval from dual");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			s.setId(rs.getInt(1));
		}
		
		ps=con.prepareStatement("insert into sahayak values(?,?,?,?,?,?,?,?)");
		ps.setInt(1,s.getId() );
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setString(4, pass);
		ps.setString(5, cpass);
		ps.setString(6, gender);
		ps.setString(7, email);
		ps.setString(8, city);
		int j=ps.executeUpdate();
		if(j>0)
		{
	res="User Registered Sucessfully and Id is:"+s.getId();
		}
		else{
			res="User Not Registered Sucessfully";
		}
		return res;
}
public Boolean verifyUser(Sahayak s) throws SQLException
{
	PreparedStatement ps=con.prepareStatement("select * from sahayak where id=? and pass=?");
	ps.setInt(1, s.getId());
	ps.setString(2, s.getPass());
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		return true;
	}
	else 
		return false;
}
public Object[] getSahayakFname(Sahayak s) throws SQLException{
		int i=0,j=0;
	PreparedStatement ps=con.prepareStatement("select fname from sahayak where city=?");
	//System.out.println(m.getCity());
	ps.setString(1,s.getCity());
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		i++;
	}
	Object o[]=new Object[i];
	PreparedStatement	ps1=con.prepareStatement("select fname from sahayak where city=?");
	ps1.setString(1,s.getCity());
	ResultSet rs1=ps1.executeQuery();
	while(rs1.next()){
		System.out.println(j);
		System.out.println(rs1.getString(1));
		o[j]=rs1.getString(1);
		j++;
	}
	return o;
}
public Object getSahayakEmail(Object fname) throws SQLException{
	String res=fname.toString();
	Object o;
	PreparedStatement ps=con.prepareStatement("select email from sahayak where fname=?");
	ps.setString(1, res);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		System.out.println(rs.getString(1));
		o=rs.getString(1);
		return o;
	}
	else {
		return null;
	}
}
/*public Object[] showSahayakProfile()
{
	PreparedStatement ps=con.prepareStatement("select * from sahayak where id=?");
	ps.setInt()
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		s.setId(rs.getInt(1));
	}

	return null;
	
}*/
public Sahayak getSahayakDeatails(Sahayak s) throws SQLException {
	PreparedStatement ps=con.prepareStatement("select * from sahayak where id=?");
	ps.setInt(1,s.getId());
	ResultSet rs=ps.executeQuery();
	Sahayak s1=new Sahayak();
	if(rs.next()){
		s1.setId(rs.getInt(1));
		s1.setFname(rs.getString(2));
		s1.setLname(rs.getString(3));
		s1.setPass(rs.getString(4));
		s1.setCity(rs.getString(8));
		s1.setGender(rs.getString(6));
		s1.setEmail(rs.getString(7));
		return s1;
	}
else{
	return null;
}
}
	public List<Sahayak> getAllDetails()
	{
		List<Sahayak> li=new ArrayList<Sahayak>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from sahayak");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Sahayak s1=new Sahayak();
				s1.setId(rs.getInt(1));
				s1.setFname(rs.getString(2));
				s1.setLname(rs.getString(3));
				s1.setPass(rs.getString(4));
				s1.setCity(rs.getString(8));
				s1.setGender(rs.getString(6));
				s1.setEmail(rs.getString(7));
				li.add(s1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	public List<Sahayak> getAllSahayaks(Sahayak s) {
		List<Sahayak> li=new ArrayList<Sahayak>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from sahayak where city=?");
			ps.setString(1, s.getCity());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Sahayak s1=new Sahayak();
				s1.setId(rs.getInt(1));
				s1.setFname(rs.getString(2));
				s1.setLname(rs.getString(3));
				s1.setPass(rs.getString(4));
				s1.setCity(rs.getString(8));
				s1.setGender(rs.getString(6));
				s1.setEmail(rs.getString(7));
				li.add(s1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
}

