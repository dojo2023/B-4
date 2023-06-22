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

    /**
     * @see HttpServlet#HttpServlet()
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // トレーニング選択ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hometrain.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	//鍛えたい部位のデータを取得する
//        request.setCharacterEncoding("UTF-8");
    	
//        // 画像から選択された値を取得する
//        String parts = request.getParameter("PARTS_NAME");
//        String id = request.getParameter("USER_ID");

//        // もしも選択された部位名が空でない場合
//        if (parts != null && !parts.isEmpty()) {
            // TrainingDaoを使用してデータベースに格納する


//            if (tDao.insert(id,parts)) { // 格納成功
//                Trainings training = new Trainings(id,parts);
//
//                // セッションに格納する
//                HttpSession session = request.getSession();
//                session.setAttribute("trainings", training);
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
