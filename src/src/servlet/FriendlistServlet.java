package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class FriendlistServlet
 */
@WebServlet("/FriendlistServlet")
public class FriendlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/komatsukita/LoginServlet");
				return;
			}*/
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
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String user_id = request.getParameter("USER_ID");
		String friends_id = request.getParameter("FRIENDS_ID");

//		FriendsDAO fDao = new FriendsDAO();
//		List<Friends> cardList = fDao.select(new Friends(id, user_id, friends_id));
	}

}
