package KDA.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns= {"/logout"})
public class LogoutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4620311157234481603L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session != null) {
			session.removeAttribute("acc");
			session.removeAttribute("cart");
			resp.sendRedirect("login");
		}
	}
}
