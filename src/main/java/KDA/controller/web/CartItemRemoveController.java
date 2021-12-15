package KDA.controller.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import KDA.model.CartItemModel;
@WebServlet(urlPatterns = { "/cart-remove" })
public class CartItemRemoveController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5827567955782384129L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		String pid = req.getParameter("pid");
		if (obj != null) {
			@SuppressWarnings("unchecked")
			Map<Integer, CartItemModel> map = (Map<Integer, CartItemModel>) obj;
			map.remove(Integer.parseInt(pid));
			httpSession.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
