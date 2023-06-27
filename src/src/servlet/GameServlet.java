package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CharaDao;
import model.Serifus;

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
		//画像のデータを取ってくる(user_idを使ってdaoに命令して)

		//本当はセッションスコープから取ってくる
		String user_id = "health";
		//user_idを使ってファイル名を取り出すsqlをdaoで作る
		//SELECT ch.chara_file  FROM userCharas  as uc  join charas as ch on uc.chara_id = ch.chara_id where  uc.user_id = 'health' ;
		CharaDao cDao = new CharaDao();
		Serifus sf = cDao.select(user_id);
		int chara_id = Integer.parseInt(cDao.selectId(user_id));

		request.setAttribute("chara_id", chara_id);
		//取ってきたファイル名をリクエストスコープに格納する
		request.setAttribute("serif_chara", sf);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    request.setCharacterEncoding("UTF-8");
    String user_id = "health";
    String chara_id = request.getParameter("chara_id");
    //daoを使ってusercharaidテーブルのデータを上書きする
    //update userscharas set chara_id  = うえの変数chara_id where user_id = "health"

    doGet(request,response);


	}
}
