package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ObtaintIdSahayak {
	static Connection con;
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lavi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getPassword(Sahayak s) throws Exception{
		String pass="";
		PreparedStatement ps=con.prepareStatement("select pass from sahayak where id=? and email=?");
		ps.setInt(1, s.getId());
		ps.setString(2, s.getEmail());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		pass=rs.getString(1);
		}
	return pass;
	}

}
