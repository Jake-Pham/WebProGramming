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
import KDA.model.ProductModel;
import KDA.service.CategoryService;
import KDA.service.ProductService;
import KDA.service.impl.CategoryServiceImpl;
import KDA.service.impl.ProductServiceImpl;



@WebServlet(urlPatterns= {"/home"})
public class HomeController extends HttpServlet{
	/**
	 * 
	 */
	ProductService productService=new ProductServiceImpl();
	CategoryService cateService=new CategoryServiceImpl();
	private static final long serialVersionUID = 4684292259283592147L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		List<ProductModel> list5=productService.get5NewProduct();
		List<ProductModel> list3=productService.getTop3Product();
		List<ProductModel> list2=productService.getFirst2Product();
		List<CategoryModel> listc=cateService.getAllcategory();
		
		req.setAttribute("list5NewProduct", list5);
		req.setAttribute("listTop3Product", list3);
		req.setAttribute("listFirst2Product", list2);
		req.setAttribute("listAllcategory", listc);
		
		RequestDispatcher rd=req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
