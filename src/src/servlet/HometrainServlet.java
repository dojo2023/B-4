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
import model.Trainings;

/**
 * Servlet implementation class HometrainServlet
 */
@WebServlet("/HometrainServlet")
public class HometrainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HometrainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // トレーニング選択ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hometrain.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 鍛えたい部位のデータを取得する
        request.setCharacterEncoding("UTF-8");

        // フォームから選択された値を取得する
        String parts = request.getParameter("parts_name");
        String id = request.getParameter("user_id");

        // もしも選択された部位名が空でない場合
        if (parts != null && !parts.isEmpty()) {
            // TrainingDaoを使用してデータベースに格納する
            TrainingDao tDao = new TrainingDao();
            if (tDao.insert(id,parts)) { // 格納成功
                Trainings training = new Trainings(id,parts);

                // セッションに格納する
                HttpSession session = request.getSession();
                session.setAttribute("training", training);
                response.sendRedirect("/komatsukita/TraincheckServlet");
            } else { // 格納失敗
                request.setAttribute("result",
                        new Result("登録できません", "必須項目を入力してください", "/komatsukita/MenuServlet"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hometrain.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("result",
                    new Result("登録できません", "必須項目を入力してください", "/komatsukita/MenuServlet"));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hometrain.jsp");
            dispatcher.forward(request, response);
        }
    }
}
