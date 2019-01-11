package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ObtaintIdUser {
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
	public String getPassword(Coustmer f) throws Exception{
		String pass="";
		PreparedStatement ps=con.prepareStatement("select pass from coustmer where id=? and email=?");
		ps.setInt(1, f.getId());
		ps.setString(2, f.getEmail());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		pass=rs.getString(1);
		}
	return pass;
	}

}
