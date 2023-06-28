package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FriendListDao;
import model.Friends;
import model.LoginUser;



/**
 * Servlet implementation class FriendlistServlet
 */
@WebServlet("/FriendlistServlet")
public class FriendlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/komatsukita/LoginServlet");
				return;
			}*/
		
		//セッションスコープに格納されているIDを取得する
		HttpSession session = request.getSession();
        LoginUser id = (LoginUser) session.getAttribute("user_id");
		
		//リクエストパラメータ（user_id）を取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("USER_ID");
		String friends_id = request.getParameter("FRIENDS_ID");
		String user_name = request.getParameter("USER_NAME");
		
		//Daoのインスタンスを作成　
		FriendListDao fDao = new FriendListDao();
		
		//FriendListを作成　データベースから取得したデータを入れる
		ArrayList<Friends> FriendList = new ArrayList<>();
		
		//("")のキーワードに基づいてデータベースから情報を抜き出す
		FriendList = fDao.selectModal_users_friends("id");
		
		//FriendListをオブジェクトの属性として設定
		request.setAttribute("FriendList",FriendList);
		
		
//		//daoを操作する
//		FriendListDao fDao = new FriendListDao();
//		List<Friends> FriendList = fDao.select(new Friends());
		
		
		request.setAttribute("FriendList", FriendList);
		
		// フレンドリストページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/friendlist.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/komatsukita/LoginServlet");
				return;
			}*/

		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("ID");
//		String user_id = request.getParameter("USER_ID");
//		String friends_id = request.getParameter("FRIENDS_ID");

//		FriendsDAO fDao = new FriendsDAO();
//		List<Friends> cardList = fDao.select(new Friends(id, user_id, friends_id));
	}

}
