package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Weight;

/**
 * Servlet implementation class WeightServlet
 */
@WebServlet("/WeightServlet")
public class WeightServlet extends HttpServlet {
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
//		ChartDataモデルの初期化
		Weight cd = new Weight(110,20,30);
		//ChartData格納リストの初期化
		List<Weight> dl = new ArrayList<>();
		dl.add(cd);
		Weight cd1 = new Weight(50,60,70);
		dl.add(cd1);

//		リクエストスコープへのデータの格納
		request.setAttribute("weight", dl);

				// トレーニング選択ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/weight.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
