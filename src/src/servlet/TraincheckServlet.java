package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainingDao;

/**
 * Servlet implementation class TraincheckServlet
 */
@WebServlet("/TraincheckServlet")
public class TraincheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// トレーニング確認画面ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/traincheck.jsp");
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
		//鍛えたい部位のデータを取得する
		request.setCharacterEncoding("UTF-8");
		//セッションスコープに保持されてるため不要？
		String id = request.getParameter("USER_ID");
		String parts = request.getParameter("PARTS_NAME");

		//idと取得した部位を引数にしてtrainsテーブルにデータを追加するdaoを呼び出す
		TrainingDao tDao = new TrainingDao();
		tDao.insert(id, parts);

//		String id="id"; //今はテストサンプルとして「００１」とする
//		//鍛えたいブイのデータを取得する
//		String parts="お腹";
//		//idと取得した部位を引数にしてtrainsテーブルにデータを追加するdaoを呼び出す
//		TrainingDao tDao = new TrainingDao();
//		tDao.insert(id, parts);




	}

}
