package comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSahayak
 */
public class LoginSahayak extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		String pass=request.getParameter("pass");
		Sahayak s=new Sahayak();
		Sahayak s1=new Sahayak();
		s.setId(id);
		s.setPass(pass);
		SahayakDao cd=new SahayakDao();
		try {
			Boolean value=cd.verifyUser(s);
			if(value){
				s1=cd.getSahayakDeatails(s);
				request.setAttribute("sahayak", s1);
				RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
		/*	s=cd.getSahayakDeatails(s);
			request.setAttribute("sahayak", s);
				RequestDispatcher rd1=request.getRequestDispatcher("profile.html");
				rd.forward(request, response);
			*/}
			else
			{
				response.sendRedirect("LoginSahayak.html");
				/*RequestDispatcher rd=request.getRequestDispatcher("LoginSahayak.html");
				out.println("<h1> You entered Wrong UserId and Password");
				rd.include(request, response);*/
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
}

}
