package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BcDAO;
import model.Bc;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/komatsukita/LoginServlet");
					return;
			}
		// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
				dispatcher.forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
	HttpSession session = request.getSession();
	if (session.getAttribute("id") == null) {
		response.sendRedirect("/komatsukita/LoginServlet");
		return;
	}

	// リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("ID");
	String password=request.getParameter("PASSWORD");
	String repass=request.getParameter("REPASS");

	// 登録処理を行う
			BcDAO bDao = new BcDAO();
			if (bDao.insert(new Bc(id, password, repass
					))) {
	// 登録成功
				request.setAttribute("result",
				new Result("登録成功！", "/komatsukita/Homervlet"));
			}
			else {
	// 登録失敗
				request.setAttribute("result",
				new Result("登録失敗！", "/komatsukita/HomeServlet"));
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
	}
}

