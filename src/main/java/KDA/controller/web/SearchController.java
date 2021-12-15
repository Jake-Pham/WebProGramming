package KDA.controller.web;

import java.io.IOException;
import java.util.List;

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

;
@WebServlet(urlPatterns = { "/search" })
public class SearchController extends HttpServlet{

	/**
	 * 
	 */
	ProductService productService=new ProductServiceImpl();
	CategoryService cateService=new CategoryServiceImpl();
	private static final long serialVersionUID = -3396705369329066180L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txt1 = req.getParameter("txt");
		String cid= req.getParameter("cid");
		List<ProductModel> list = productService.searchByProductName(txt1);
		List<CategoryModel> listc=cateService.getAllcategory();
		List<ProductModel> list3=productService.getTop3Product();
		req.setAttribute("listAllcategory", listc);
		req.setAttribute("listAllProduct", list);
		req.setAttribute("listTop3Product", list3);
		req.setAttribute("txtS", txt1);
		req.getRequestDispatcher("/views/web/searchresult.jsp").forward(req, resp);
	}
}
