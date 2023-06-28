package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CharaDao;
import model.LoginUser;

/**
 * Servlet implementation class CharaChangeServlet
 */
@WebServlet("/CharaChangeServlet")
public class CharaChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharaChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		//String chara_id = request.getParameter("chara_id");
		LoginUser user_id_login=(LoginUser)session.getAttribute("id");
		int chara_id_int=(Integer)session.getAttribute("chara_id");
		String chara_id = String.valueOf(chara_id_int);
		String user_id = user_id_login.getUser_id();

		//user_id,chara_idをuserscharaテーブルのデータに上書きするdaoを作って実行
		CharaDao cDao = new CharaDao();
		cDao.update(chara_id,user_id);

		//処理をGameServletに移行する
		response.sendRedirect("/komatsukita/GameServlet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
