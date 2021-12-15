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
import KDA.model.CommentModel;
import KDA.model.ProductModel;
import KDA.service.CategoryService;
import KDA.service.CommentService;
import KDA.service.ProductService;
import KDA.service.impl.CategoryServiceImpl;
import KDA.service.impl.CommentServiceImpl;
import KDA.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/productdetail" })
public class ProductDetailController extends HttpServlet {

	/**
	 * 
	 */
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	CommentService commentService = new CommentServiceImpl();
	private static final long serialVersionUID = -3117395947152301480L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String pid = req.getParameter("pid");
		String cid = req.getParameter("cid");

		List<CategoryModel> listc = cateService.getAllcategory();
		List<ProductModel> list3 = productService.getTop3Product();
		ProductModel product = productService.getProductByID(pid);
		List<ProductModel> listpcid = productService.getAllProductByCID(cid);
		List<CommentModel> listcomment = commentService.getbyPid(pid);

		req.setAttribute("listAllcategory", listc);
		req.setAttribute("listTop3Product", list3);
		req.setAttribute("product", product);
		// req.setAttribute("category", category);
		req.setAttribute("listProductByCID", listpcid);
		req.setAttribute("listcomment", listcomment);

		RequestDispatcher rq = req.getRequestDispatcher("/views/web/productdetail.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentModel comment = new CommentModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");

		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);

			for (FileItem item : items) {

				if (item.getFieldName().equals("uid")) {
					comment.setUid(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("pid")) {
					comment.setPid(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("review")) {
					comment.setContent(item.getString("UTF-8"));
				}
			}
			commentService.insert(comment);
			req.setAttribute("alert", 1);
			req.getRequestDispatcher("/views/web/tmp.jsp");
		} catch (

		FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
