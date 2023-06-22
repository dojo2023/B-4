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
		request.setCharacterEncoding("UTF-8");
//    	String id = "";    
        String parts = "";    
        
        // jspから送られてきた値を受け取る
        parts = request.getParameter("parts_name");    
        
        // 次の画面(jsp)に値を渡す
        request.setAttribute("parts_name", parts);
        
        request.getRequestDispatcher("/Traincheck.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public class HomeServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	
	    	// トレーニング選択ページにフォワードする
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/traincheck.jsp");
	        dispatcher.forward(request, response);
	    	
//	    	String id = "";    
	        String parts = "";    
	        
	        // jspから送られてきた値を受け取る
	        parts = request.getParameter("parts_name");    
	        
	        // 次の画面(jsp)に値を渡す
	        request.setAttribute("parts_name", parts);
	        
	    	
	    	// フォームからのデータを取得
//	        String parts = request.getParameter("parts_name");
//
//	     // TrainingDaoを使用してデータベースに格納する
//            TrainingDao tDao = new TrainingDao();
//            if (tDao.insert(parts)) { // 格納成功
//                Trainings training = new Trainings(parts);
//
//                // セッションに格納する
//                HttpSession session = request.getSession();
//                session.setAttribute("training", training);
//                response.sendRedirect("/komatsukita/TraincheckServlet");
//            } else { // 格納失敗
//                request.setAttribute("result",
//                        new Result("登録できません", "必須項目を入力してください", "/komatsukita/MenuServlet"));
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hometrain.jsp");
//                dispatcher.forward(request, response);
//            }
//        } else {
//            request.setAttribute("result",
//                    new Result("登録できません", "必須項目を入力してください", "/komatsukita/MenuServlet"));
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hometrain.jsp");
//            dispatcher.forward(request, response);
//        }
	    }
	}

}
