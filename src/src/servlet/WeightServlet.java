package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChartDAO;
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
		doGet(request,response);
	}

}
