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
import KDA.service.CategoryService;
import KDA.service.ProductService;
import KDA.service.impl.CategoryServiceImpl;
import KDA.service.impl.ProductServiceImpl;



@WebServlet(urlPatterns= {"/cart"})
public class CartController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6890431907484717345L;
	ProductService productService=new ProductServiceImpl();
	CategoryService cateService=new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<CategoryModel> listc=cateService.getAllcategory();
		req.setAttribute("listAllcategory", listc);
		RequestDispatcher rq=req.getRequestDispatcher("/views/web/cart-list.jsp");
		rq.forward(req, resp);
	}
}
