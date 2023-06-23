package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.Result;
import model.Users;

/**
 * Servlet implementation class RegistServlet1
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	String user_id=request.getParameter("ID");
	String user_password=request.getParameter("PW");
	String user_name=request.getParameter("USER");

	// 登録処理を行う
			UsersDAO bDao = new UsersDAO();
			if (bDao.insert(new Users(user_id, user_password, user_name
					))) {
	// 登録成功
				request.setAttribute("result",
				new Result("登録成功！", "登録しました。", "/komatsukita/LoginServlet"));
			}
			else {
	// 登録失敗
				request.setAttribute("result",
				new Result("登録失敗！", "登録できませんでした。", "/komatsukita/LoginServlet"));
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
	}

}