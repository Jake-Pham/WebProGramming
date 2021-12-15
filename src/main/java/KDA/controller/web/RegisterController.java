package KDA.controller.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import KDA.model.UserModel;
import KDA.service.RegisterService;
import KDA.service.impl.RegisterServiceImpl;
@WebServlet(urlPatterns= {"/register"})
public class RegisterController extends HttpServlet{

	/**
	 * 
	 */
	RegisterService registerService=new RegisterServiceImpl();
	private static final long serialVersionUID = -2019366814290058759L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel account=new UserModel();
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
					account.setFname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("lname")) {
					account.setLname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("email")) {
					account.setEmail(item.getString("UTF-8"));;
				} else if (item.getFieldName().equals("pass")) {
					account.setPass(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("adrs")) {
					account.setAdrs(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("isAdmin")) {
					account.setIsAdmin(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("isSell")) {
					account.setIsSell(Integer.parseInt(item.getString()));
				}
			}
			registerService.register(account);
			req.setAttribute("alert", 1);
			req.getRequestDispatcher("/views/web/registertemp.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
