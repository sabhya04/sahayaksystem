package comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCoustmer
 */
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		String pass=request.getParameter("pass");
		Coustmer c=new Coustmer();
		Coustmer c1=new Coustmer();
		c.setId(id);
		c.setPass(pass);
		CoustmerDao cd=new CoustmerDao();
		try {
			Boolean value=cd.verifyUser(c);
			if(value){
				c1=cd.getCoustmerDetails(c);
				request.setAttribute("coustmer", c1);
				RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("Loginuser.html");
			}
		}
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
	}

}
