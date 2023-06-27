package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ModalDAO2;


/**
 * Servlet implementation class ModalServlset
 */
@WebServlet("/FriendmodalreiServlet")
public class FriendmodalreiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendmodalreiServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// friend_searchにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/friend.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");


		// id検索を行う
		ModalDAO2 mDao = new ModalDAO2();
		String user_name = mDao.selectId(user_id);
		if (!user_name.equals("")) {	// id発見。

			session.setAttribute("user_id", user_id);
			request.setAttribute("user_name", user_name);
			doGet(request, response);

		}

		doGet(request, response);
	}

}
