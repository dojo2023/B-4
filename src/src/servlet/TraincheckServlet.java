package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TrainingDao;
import model.Result;

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
		
		String foot = "脚";
		String behind = "背中";
		String arm = "腕";
		String sixpack = "お腹";
		String power = "体力";
		
		
		request.setCharacterEncoding("UTF-8");  
        String parts = request.getParameter("parts_name");    
        String str = request.getQueryString();
        
        System.out.println(str);
        System.out.println(foot);
        System.out.println(behind);
        System.out.println(arm);
        System.out.println(sixpack);
        System.out.println(power);
        
          
        
//        // jspから送られてきた値を受け取る
//        parts = request.getParameter("parts_name");    
        
        
        
        switch (parts) {
        case "foot":
        	foot = "脚";
        	break;
        case "power":
        	power = "体力";
        	break;
        case "sixpack":
        	sixpack = "お腹";
        	break;
        case "arm":
        	arm = "腕";
        	break;
        case "behind":
        	behind = "背中";
        	break;
        }
        
     // 次の画面(jsp)に値を渡す
        request.setAttribute("parts_name", parts);
        
        // 次の画面(jsp)に値を渡す(カレンダーに
//        request.getAttribute("parts", parts);
//        request.getAttribute();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/traincheck.jsp");
        dispatcher.forward(request, response);
//        request.getRequestDispatcher("/Traincheck.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	
	    	
	    	// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String parts = request.getParameter("kakunin");
			
			//セッションスコープからIDを取得する
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			
	    	// 登録処理を行う
			TrainingDao tDao = new TrainingDao();
			if (tDao.insert(id,parts)) {	// 登録成功
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



