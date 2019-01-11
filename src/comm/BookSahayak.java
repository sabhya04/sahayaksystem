package comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookSahayak
 */
public class BookSahayak extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		//String s=request.getParameter("star");
		//Object fname=request.getAttribute("fname");
		SahayakDao sd=new SahayakDao();
		EmailNotify en=new EmailNotify();
		//String email;
		Object obj;
		//HttpSession ses=request.getSession();
		try {
			//obj=sd.getSahayakEmail();
			//email=obj.toString();
			en.sendEmail(email);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		out.println("Your Sahayak Has Been Booked");
	}

}
