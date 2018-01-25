package tp4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletListBean extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> names = req.getParameterNames();
		String name;
		String nom;
		List<Animal> animaux = new ArrayList<Animal>();
		Animal animal;
		while(names.hasMoreElements()) {
			name = names.nextElement();
			nom = req.getParameter(name);
			animal = new Animal(nom);
			animaux.add(animal);
		}
		req.setAttribute("animaux", animaux);
		getServletContext().getRequestDispatcher("/jspListBean.jsp").forward(req, resp);
	}

	
}
