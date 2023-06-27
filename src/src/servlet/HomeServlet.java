package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CalenderDao;
import model.Calender;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/komatsukita/LoginServlet");
			return;
		}*/
//		HttpSession session = request.getSession();
//		//自分のidを読み込む。本来はセッションスコープ等から取り出すが今回は変数で固定している
//		LoginUser user_id_login = (LoginUser)session.getAttribute("id");
//		String my_id = user_id_login.getUser_id();
//		//String my_id = "B";
////
//		String user_id = (String)session.getAttribute("user_id");
		
		CalenderDao cDao = new CalenderDao();
		ArrayList<Calender> calenderList = new ArrayList<>();
		calenderList = cDao.selectTrainings("health");
		request.setAttribute("calenderList",calenderList);

		
		
		
		

		// ホーム画面ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
