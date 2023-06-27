package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FriendListDao;
import model.LoginUser;

/**
 * Servlet implementation class FriendInsertServlet
 */
@WebServlet("/FriendinsertreiServlet")
public class FriendinsertreiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendinsertreiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//自分のidを読み込む。本来はセッションスコープ等から取り出すが今回は変数で固定している
		LoginUser user_id_login = (LoginUser)session.getAttribute("id");
		String my_id = user_id_login.getUser_id();
		//String my_id = "B";
//
		String user_id = (String)session.getAttribute("user_id");

		FriendListDao mDao = new FriendListDao();
		//自分のidとfriendのidを渡してテーブルに挿入
		mDao.insertFriend(my_id,user_id);

//FriendmodalreiServletにredirectする処理を書く
		response.sendRedirect("/komatsukita/FriendmodalreiServlet");

//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/friendlist.jsp");
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
