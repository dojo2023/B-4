package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistdataDAO;
import model.Registdata;
import model.Result;

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
		// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
				dispatcher.forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	// リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("ID");
	String password=request.getParameter("PASSWORD");
	String repass=request.getParameter("REPASS");

	// 登録処理を行う
			RegistdataDAO bDao = new RegistdataDAO();
			if (bDao.insert(new Registdata(id, password, repass
					))) {
	// 登録成功
				request.setAttribute("result",
				new Result());
			}
			else {
	// 登録失敗
				request.setAttribute("result",
				new Result());
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
	}
}

