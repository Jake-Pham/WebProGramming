package KDA.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import KDA.service.CategoryService;
import KDA.service.impl.CategoryServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryDeleteController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		cateService.delete(Integer.parseInt(cid));
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}

}
