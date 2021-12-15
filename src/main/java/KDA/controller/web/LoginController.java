package KDA.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import KDA.model.UserModel;
import KDA.service.LoginService;
import KDA.service.impl.LoginServiceImpl;


@WebServlet(urlPatterns= {"/login"})
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	LoginService loginService=new LoginServiceImpl();
	private static final long serialVersionUID = -4213448360630274246L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		UserModel account=loginService.login(email, password);
		if(account==null) {
			req.setAttribute("mess", "Sai tài khoản hoặc mật khẩu");
			req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
		}
		else {
			HttpSession sesstion=req.getSession();
			sesstion.setAttribute("acc", account);
			//sesstion.setMaxInactiveInterval(1000);
			resp.sendRedirect("home");
		}
	}
}
