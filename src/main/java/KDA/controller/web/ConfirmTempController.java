package KDA.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import KDA.model.CartModel;
import KDA.model.InformationModel;
import KDA.service.CartService;
import KDA.service.InformationService;
import KDA.service.ShipService;
import KDA.service.impl.CartServiceImpl;
import KDA.service.impl.InformationServiceImpl;
import KDA.service.impl.ShipServiceImpl;

@WebServlet(urlPatterns = { "/confirmtemp" })
public class ConfirmTempController extends HttpServlet {
	/**
	 * 
	 */
	ShipService shipService = new ShipServiceImpl();
	InformationService infService = new InformationServiceImpl();
	CartService cartService = new CartServiceImpl();
	private static final long serialVersionUID = 2559648484085824551L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InformationModel information = new InformationModel();
		CartModel cart = new CartModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("fname")) {
					information.setFname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("lname")) {
					information.setLname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("email")) {
					information.setEmail(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("phone")) {
					information.setPhone(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("adrs")) {
					information.setAdrs(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("city")) {
					information.setCity(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("pname")) {
					cart.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("image")) {
					cart.setImage(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("unitP")) {
					cart.setUnitPrice(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("quantity")) {
					cart.setQuantity(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("price")) {
					cart.setPrice(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("billID")) {
					cart.setBillID(Integer.parseInt(item.getString()));
				}
			}
			infService.insert(information);
			InformationModel inf = infService.getInformation();
			cart.setBillID(inf.getId());
			cartService.insert(cart);
			req.setCharacterEncoding("UTF-8");
			HttpSession session = req.getSession();
			if (session != null) {
				session.removeAttribute("cart");
			}
			req.setAttribute("alert", 1);
			req.getRequestDispatcher("/views/web/confirmtemp.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}