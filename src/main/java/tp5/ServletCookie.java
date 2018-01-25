package tp5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCookie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("idCookie", "valueCookie"); // il faudrait generer des cookies automatiquement
		resp.addCookie(cookie);
		resp.sendRedirect("formAvecCookie.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String age = req.getParameter("age");
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("idCookie")){
				System.out.println("Cookie trouve : on a identifé le navigateur qui a reçu le formulaire");
			}
		}
		
	}

	
}
