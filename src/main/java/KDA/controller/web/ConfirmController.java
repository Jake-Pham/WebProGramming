package KDA.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import KDA.model.CategoryModel;
import KDA.model.InformationModel;
import KDA.model.ShipModel;
import KDA.service.CategoryService;
import KDA.service.ShipService;
import KDA.service.impl.CategoryServiceImpl;
import KDA.service.impl.ShipServiceImpl;





@WebServlet(urlPatterns = { "/confirm" })
public class ConfirmController extends HttpServlet {

	/**
	 * 
	 */
	CategoryService cateService = new CategoryServiceImpl();
	ShipService shipService = new ShipServiceImpl();
	private static final long serialVersionUID = 9110228104811275393L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession();
		String id = req.getParameter("selectcity");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String adrs = req.getParameter("adrs");
		InformationModel information = new InformationModel();
		information.setFname(fname);
		information.setLname(lname);
		information.setEmail(email);
		information.setPhone(phone);
		information.setAdrs(adrs);
		httpSession.setAttribute("inf", information);
		ShipModel city = shipService.getCityByID(id);
		httpSession.setAttribute("city", city);
		List<CategoryModel> listc = cateService.getAllcategory();
		req.setAttribute("listAllcategory", listc);
		req.setAttribute("getCity", city);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/confirm.jsp");
		dispatcher.forward(req, resp);
	}
}