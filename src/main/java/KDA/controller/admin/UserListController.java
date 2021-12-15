package KDA.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KDA.model.CategoryModel;
import KDA.model.UserModel;
import KDA.service.UserService;
import KDA.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/user/list" })
public class UserListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3558461488857631493L;
	UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserModel> userList = userService.getAlluser();
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-user.jsp");
		dispatcher.forward(req, resp);
	}
}
