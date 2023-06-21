package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LogindataDAO;
import model.LoginUser;
import model.Logindata;
import model.Result;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("USER_ID");
		String user_password = request.getParameter("USER_PASSWORD");

		// ログイン処理を行う
		LogindataDAO iDao = new LogindataDAO();
		if (iDao.isLoginOK(new Logindata(user_id,user_password))) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new LoginUser(user_id));

			// ホームサーブレットにリダイレクトする
			response.sendRedirect("/komatsukita/HomeServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/komatsukita/LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}



		    // ログイン処理を行い、ログインボーナスのポイント数を取得する
		    int points =getPoins(user_id, user_password);




		    // ログインボーナスのポイント数をリクエスト属性に設定
		    request.setAttribute("points", points);

		    // JSPにフォワードして表示
		    RequestDispatcher dispatcher = request.getRequestDispatcher("loginbonus.jsp");
		    dispatcher.forward(request, response);
		    }

	 private int getPoins(String user_id, String user_password) {
				return 0;
			}


	}

