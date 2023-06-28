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

import dao.ChartDAO;
import model.LoginUser;
import model.Result;
import model.Target;
import model.Weight;
//Chartjsのサンプル
/**
 * Servlet implementation class ChartjsServlet
 */
@WebServlet("/WeightServlet")
public class WeightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//users_weightテーブルからuser_id(今回は「１」に固定）のuser_id,体重のリスト,作成日を取得。
		ChartDAO cDao = new ChartDAO();

		ArrayList<Weight> Weights = new ArrayList<>();
		Weights = cDao.select(1);
		request.setAttribute("weights", Weights);
		//users_targetsテーブルからuser_id(今回は「１」に固定）のuser_id,目標体重,作成日を取得。
		ArrayList<Target> Targets = new ArrayList<>();
		Targets = cDao.select_target(1);
		request.setAttribute("target", Targets);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chart_weight.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


    	// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String weights = request.getParameter("REALWEIGHTS");

		//セッションスコープからIDを取得する

		HttpSession session = request.getSession();
		LoginUser id_login = (LoginUser)session.getAttribute("id");
		String id = id_login.getUser_id();
//		String id ="a";
    	// 登録処理を行う
		System.out.println("id:"+id);
		ChartDAO cDao = new ChartDAO();
		if (cDao.insert(id,weights)) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/komatsukita/HomeServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録できません", "必須項目を入力してください", "/WEB-INF/jsp/result.jsp"));
		}
		//戻る
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

}
