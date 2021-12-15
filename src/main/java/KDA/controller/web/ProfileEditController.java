package KDA.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import KDA.model.CategoryModel;
import KDA.model.ProductModel;
import KDA.model.UserModel;
import KDA.service.CategoryService;
import KDA.service.ProductService;
import KDA.service.UserService;
import KDA.service.impl.CategoryServiceImpl;
import KDA.service.impl.ProductServiceImpl;
import KDA.service.impl.UserServiceImpl;
@WebServlet(urlPatterns = { "/profile/edit" })

public class ProfileEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4865143363901072036L;
	UserService userService = new UserServiceImpl();
	CategoryService cateService=new CategoryServiceImpl();
	ProductService productService=new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String uid = req.getParameter("uid");
		String cid = req.getParameter("cid");
		String pid = req.getParameter("pid");
		
		List<CategoryModel> listc=cateService.getAllcategory();
		ProductModel product =productService.getProductByID(pid);
		List<ProductModel> listpcid=productService.getAllProductByCID(cid);
		UserModel user = userService.get(Integer.parseInt(uid));
		
		req.setAttribute("listProductByCID", listpcid);
		req.setAttribute("product", product);
		req.setAttribute("listAllcategory", listc);
		req.setAttribute("userinf", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/edit-profile.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel user = new UserModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");

		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);

			for (FileItem item : items) {

				if (item.getFieldName().equals("id")) {
					user.setUid(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("fname")) {
					user.setFname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("fname")) {
					user.setFname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("lname")) {
					user.setLname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("email")) {
					user.setEmail(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("pass")) {
					user.setPass(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("adrs")) {
					user.setAdrs(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("isadmin")) {
					user.setIsAdmin(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("isseller")) {
					user.setIsSell(Integer.parseInt(item.getString()));
				}
			}
			userService.edit(user);
			resp.sendRedirect(req.getContextPath() + "/home");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
