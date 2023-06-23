package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Friends;

/**
 * Servlet implementation class FriendServlet
 */
/**
 *
 *
 *
 *
 * @author user
 *
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
/**   public FriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/komatsukita/LoginServlet");
//			return;
//		}
		//友達登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/friend.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/komatsukita/LoginServlet");
//			return;
//		}

		request.setCharacterEncoding("UTF-8");
		//今ログインしている人のユーザーIDを取得
		HttpSession session = request.getSession();


		// リクエストパラメータを取得する
		//友達になる人のユーザーIDを取得
		String friends_id = request.getParameter("user_id");
		UsersDAO uDao = new UsersDAO();
		//友達になる人のユーザーIDから名前を検索
		 uDao.setUser_id(friends_id);

		//friendsデータを作る
		Friends f = new Friends();
		//
		f.setId("");

		// 登録処理を行う
//		FriendsDao
	}


}
