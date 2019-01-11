package comm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Forget extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	int id=Integer.parseInt(request.getParameter("id"));
	String email=request.getParameter("email");
	 Coustmer c=new Coustmer();
	c.setId(id);
	c.setEmail(email);
	ObtaintIdUser fi=new ObtaintIdUser();
	try {
		String pass=fi.getPassword(c);
		out.println("<html><body>");
		out.println("<h1> your password is -->"+pass+"</h1>");
		out.println("</html></body>");
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	}

	
	
}


