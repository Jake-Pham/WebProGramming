package KDA.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KDA.model.CategoryModel;
import KDA.model.ShipModel;
import KDA.service.CartService;
import KDA.service.CategoryService;
import KDA.service.InformationService;
import KDA.service.ShipService;
import KDA.service.impl.CartServiceImpl;
import KDA.service.impl.CategoryServiceImpl;
import KDA.service.impl.InformationServiceImpl;
import KDA.service.impl.ShipServiceImpl;



@WebServlet(urlPatterns = { "/checkout" })
public class CheckoutController extends HttpServlet {
	/**
	 * 
	 */
	CategoryService cateService = new CategoryServiceImpl();
	ShipService shipService = new ShipServiceImpl();
	InformationService infService = new InformationServiceImpl();
	CartService cartService = new CartServiceImpl();
	private static final long serialVersionUID = -3153844045609069111L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		List<CategoryModel> listc = cateService.getAllcategory();
		List<ShipModel> lists = shipService.listAllCity();
		ShipModel city = shipService.getCityByID(id);
		req.setAttribute("getCity", city);
		req.setAttribute("listAllcategory", listc);
		req.setAttribute("listAllCity", lists);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/checkout.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}