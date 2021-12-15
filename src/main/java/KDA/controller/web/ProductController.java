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


@WebServlet(urlPatterns= {"/product"})
public class ProductController extends HttpServlet{
	/**
	 * 
	 */
	ProductService productService=new ProductServiceImpl();
	CategoryService cateService=new CategoryServiceImpl();
	private static final long serialVersionUID = -1936111011815436927L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String cid= req.getParameter("cid");
		
		List<ProductModel> listall=productService.getAllproduct();
		List<CategoryModel> listc=cateService.getAllcategory();
		List<ProductModel> list3=productService.getTop3Product();
		List<ProductModel> listpcid=productService.getAllProductByCID(cid);
		
		String indexPage=req.getParameter("index");
		if(indexPage==null) {
			indexPage="1";
		}
		if ("0".equals(cid)) {
			int count=productService.countAll();
			int endPage=count/6;
			if(count%6 !=0) {
				endPage++;
			}
			req.setAttribute("endP", endPage);
		}
		else
		{
			int count=productService.countProductByCID(cid);
			int endPage=count/6;
			if(count%6 !=0) {
				endPage++;
			}
			req.setAttribute("endP", endPage);
		}
		int index=Integer.parseInt(indexPage);
		List<ProductModel> listp=productService.pagingProduct(index);
		List<ProductModel> listpbycid=productService.pagingProductByCID(index, cid);
		
		if ("0".equals(cid)) {
			req.setAttribute("listAllProduct", listp);
		}
		else {
			req.setAttribute("listAllProduct", listpbycid);
		}
		req.setAttribute("listAllcategory", listc);
		req.setAttribute("listTop3Product", list3);
		req.setAttribute("cid", cid);
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		
		RequestDispatcher rq=req.getRequestDispatcher("/views/web/product.jsp");
		rq.forward(req, resp);
	}
}
