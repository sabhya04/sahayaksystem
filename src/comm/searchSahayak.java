package comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class searchSahayak
 */
public class searchSahayak extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String city=request.getParameter("city");
		SahayakDao sd=new SahayakDao();
		Sahayak s=new Sahayak();
		s.setCity(city);
		List<Sahayak> l=sd.getAllSahayaks(s);
		//List<Sahayak> li=sd.getAllDetails();
		
		/*Object m[]=sd.getSahayakFname(s);
		out.println("<center><h1>The Sahayak available are:</h1></center>");

		for(Object i:m){
			out.println("<form action=\"BookSahayak\" method=\"post\" ");
			out.println("<table><tr>");
			out.println("<li>");
			//ses.setAttribute("fname", i);
			out.println("<ol>The Available Sahayaks Are:  "+i+"    Book here:    "+"<input type=\"submit\"value="+i+" name=\"star\"></ol>");
			out.println("</li>");
			out.println("</tr></table>");
			out.println("</form>");*/
		for(Sahayak s2:l)
		{
			out.println("<table>");
			out.println("<tr><th>"+s2.getFname()+"</th><td>"+s2.getCity() +"</td><td><a href=\"BookSahayak?email="+s2.getEmail()+"\">"+"Book Here:"+"</a></td>");
			out.println("</table>");
		}
	}

}
