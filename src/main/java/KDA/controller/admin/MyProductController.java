package KDA.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import KDA.model.ProductModel;
import KDA.model.UserModel;
import KDA.service.ProductService;
import KDA.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = { "/admin/product/my-product"})
public class MyProductController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3372406244317057220L;
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserModel user =(UserModel) session.getAttribute("acc");
		int uid = user.getUid();
		List<ProductModel> myproduct = productService.getMyproduct(uid);
		req.setAttribute("myproduct", myproduct);
		RequestDispatcher rq = req.getRequestDispatcher("/views/admin/my-product.jsp");
		rq.forward(req, resp);
	}
}
