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
		
		String foot = "脚";
		String behind = "背中";
		String arm = "leg";
		String sixpack = "お腹";
		String power = "体力";
		
		
		request.setCharacterEncoding("UTF-8");  
        String parts = request.getParameter("parts_name");    
        String str = request.getQueryString();
        
        System.out.println(parts);
        System.out.println(str);
        System.out.println(foot);
        System.out.println(behind);
        System.out.println(arm);
        System.out.println(sixpack);
        System.out.println(power);
        
    
        
        // 次の画面(jsp)に値を渡す
//        request.getAttribute("parts", parts);
//        request.getAttribute();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/traincheck.jsp");
        dispatcher.forward(request, response);
//        request.getRequestDispatcher("/Traincheck.jsp").forward(request, response);
		
		
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
	    }  
    }    	


}
