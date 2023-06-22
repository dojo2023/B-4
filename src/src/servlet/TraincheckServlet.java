package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// セッションスコープからデータを取得
        String partsName = (String) request.getSession().getAttribute("parts_name");

        // JSPにデータを渡す
        request.setAttribute("parts_name", partsName);

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
//		request.setCharacterEncoding("UTF-8");
//		//セッションスコープに保持されてるため不要？
//		String id = request.getParameter("USER_ID");
//		String parts = request.getParameter("PARTS_NAME");

		//idと取得した部位を引数にしてtrainsテーブルにデータを追加するdaoを呼び出す
//		TrainingDao tDao = new TrainingDao();
////		tDao.insert(id, parts);
//		if (tDao.insert(id, parts)) {	// 登録成功
////			request.setAttribute("result",
////			new Result("登録成功！", "レコードを登録しました。", "/komatsukita/HomeServlet"));
////			Trainings t=new Trainings(id,parts);
//			// セッションスコープにID,parts_nameを格納する
////			HttpSession session = request.getSession();
////			session.setAttribute("parts", t);
//			response.sendRedirect("/komatsukita/HomeServlet");
//		}
//		else {												// 登録失敗
//			request.setAttribute("result",
//			new Result("登録できません", "必須項目を入力してください", "/simpleBC/MenuServlet"));
//		}

		// セッションオブジェクトを取得
//		HttpSession session = request.getSession();
//
//		// セッションスコープから「parts_name」データを取得
//		String partsnames = (String) session.getAttribute("parts_name");

		//
//		String id="id"; //今はテストサンプルとして「００１」とする
//		//鍛えたいブイのデータを取得する
//		//idと取得した部位を引数にしてtrainsテーブルにデータを追加するdaoを呼び出す
//		TrainingDao tDao = new TrainingDao();
//		tDao.insert(id, parts);




	}

}
