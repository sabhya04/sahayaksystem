package comm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgetSahayak extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		PrintWriter out=response.getWriter();
 		int id=Integer.parseInt(request.getParameter("id"));
 		String email=request.getParameter("email");
 		 Sahayak s=new Sahayak();
 		 s.setId(id);
 		s.setEmail(email);
 		ObtaintIdSahayak si=new ObtaintIdSahayak();
 		
 		try {
 			String pass=si.getPassword(s);
 			out.println("<html><body>");
 			out.println("<h1> Your password is sent to your email.Thank You!! </h1>");
 			out.println("</html></body>");
 			EmailNotify en=new EmailNotify();
 			en.sendPasswordResetEmail(s,pass);
 		} 
 		catch (Exception e) {
 			e.printStackTrace();
 		}

 	}

}
