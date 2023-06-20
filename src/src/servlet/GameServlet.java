package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CharaDao;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 育成ゲームページにフォワードする


				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    request.setCharacterEncoding("UTF-8");
    String points = request.getParameter("POINTS");
    String chara_file = request.getParameter("CHARA_FILE");
    String serif = request.getParameter("SERIF");

    CharaDao cDao = new CharaDao();
    String a = cDao.select("health");
    System.out.println(a);
	}
}
