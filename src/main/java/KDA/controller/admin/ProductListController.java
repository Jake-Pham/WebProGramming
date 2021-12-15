package KDA.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KDA.model.ProductModel;
import KDA.service.ProductService;
import KDA.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = { "/admin/product/list"})
public class ProductListController extends HttpServlet{
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> productList = productService.getAllproduct();
		req.setAttribute("productList", productList);
		RequestDispatcher rq = req.getRequestDispatcher("/views/admin/list-product.jsp");
		rq.forward(req, resp);
	}
}
