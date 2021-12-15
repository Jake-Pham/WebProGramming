package KDA.controller.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import KDA.model.CartItemModel;
import KDA.model.ProductModel;
import KDA.service.ProductService;
import KDA.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/cart-add" })
public class CartAddController extends HttpServlet {

	/**
	 * 
	 */
	ProductService productService=new ProductServiceImpl();
	private static final long serialVersionUID = -7208055547633137443L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String pid = req.getParameter("pid");
		String quantity = req.getParameter("quantity");
		ProductModel product = productService.getProductByID(pid);
		CartItemModel cartItem = new CartItemModel();
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice(product.getPrice());
		cartItem.setProduct(product);
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		if (obj == null) {
			Map<Integer, CartItemModel> map = new HashMap<Integer, CartItemModel>();
			map.put(cartItem.getProduct().getId(), cartItem);
			httpSession.setAttribute("cart", map);
		} else {
			Map<Integer, CartItemModel> map = extracted(obj);
			CartItemModel existedCartItem = map.get(Integer.valueOf(pid));
			if (existedCartItem == null) {
				map.put(product.getId(), cartItem);
			} else {
				existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
			}
			httpSession.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj) {
		return (Map<Integer, CartItemModel>) obj;
	}
}
