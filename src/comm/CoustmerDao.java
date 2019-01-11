package comm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoustmerDao {
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
public String storeToDatabase(String fname,String lname,String pass,String cpass,String gender,String email)
		throws Exception{
		String res="";
		Coustmer c=new Coustmer();
		PreparedStatement ps=con.prepareStatement("select seq_employee.nextval from dual");
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			c.setId(rs.getInt(1));
		}
		
		ps=con.prepareStatement("insert into coustmer values(?,?,?,?,?,?,?)");
		ps.setInt(1,c.getId() );
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setString(4, pass);
		ps.setString(5, cpass);
		ps.setString(6, gender);
		ps.setString(7, email);
		int j=ps.executeUpdate();
		if(j>0)
		{
	res="User Registered Sucessfully and Id is:"+c.getId();
		}
		else{
			res="User Not Registered Sucessfully";
		}
		return res;
}
public Boolean verifyUser(Coustmer c) throws SQLException
{
	PreparedStatement ps=con.prepareStatement("select * from coustmer where id=? and pass=?");
	ps.setInt(1, c.getId());
	ps.setString(2, c.getPass());
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		return true;
	}
	else 
		return false;

}
public Coustmer getCoustmerDetails(Coustmer c) throws SQLException {
	PreparedStatement ps=con.prepareStatement("select * from coustmer where id=?");
	ps.setInt(1,c.getId());
	ResultSet rs=ps.executeQuery();
	Coustmer s1=new Coustmer();
	if(rs.next()){
		s1.setId(rs.getInt(1));
		s1.setFname(rs.getString(2));
		s1.setLname(rs.getString(3));
		s1.setPass(rs.getString(4));
		s1.setGender(rs.getString(6));
		s1.setEmail(rs.getString(7));
		return s1;
	}
else{
	return null;
}
}
}
