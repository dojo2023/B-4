package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HometrainServlet
 */
@WebServlet("/HometrainServlet")
public class HometrainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // トレーニング選択ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hometrain.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//鍛えたい部位のデータを取得する
        request.setCharacterEncoding("UTF-8");
    	
        // 画像から選択された値を取得する
        String parts = request.getParameter("PARTS_NAME");
        

        //リクエストスコープに格納する
        request.setAttribute("parts", parts);
        
             
    }
}
