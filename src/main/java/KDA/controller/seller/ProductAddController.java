package KDA.controller.seller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import KDA.model.CategoryModel;
import KDA.model.ProductModel;
import KDA.model.UserModel;
import KDA.service.CategoryService;
import KDA.service.ProductService;
import KDA.service.impl.CategoryServiceImpl;
import KDA.service.impl.ProductServiceImpl;
import KDA.util.Constant;

@WebServlet(urlPatterns = { "/seller/product/add" })
public class ProductAddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6931577403126751545L;
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> cateList = cateService.getAllcategory();
		req.setAttribute("cateList", cateList);
		RequestDispatcher rq = req.getRequestDispatcher("/views/seller/add-product.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductModel product = new ProductModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");

		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);

			for (FileItem item : items) {

				if (item.getFieldName().equals("name")) {
					product.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("description")) {
					product.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("imagelink")) {
					product.setImage(item.getString());
				} else if (item.getFieldName().equals("icons")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);
					product.setImage("product/" + fileName);
				} else if (item.getFieldName().equals("cateid")) {
					product.setCategoryID(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("sid")) {
					product.setSellerID(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("amount")) {
					product.setAmount(Integer.parseInt(item.getString()));
				}
			}
			productService.insert(product);
			resp.sendRedirect(req.getContextPath() + "/seller/product/my-product");
		} catch (

		FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
