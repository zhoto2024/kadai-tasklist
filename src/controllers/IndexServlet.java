package controllers;

// IndexServlet はデータベースから
// 複数のメッセージ情報を取得して一覧表示するサーブレット

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        /*
         * 先ほどJPQLの文につけた名前 getAllMessages を
         *  createNamedQuery メソッドの引数に指定してあげることで、
         *  データベースへの問い合わせを実行できます。
         *  その問い合わせ結果を getResultList() メソッド
         *  を使ってリスト形式で取得します。
         *  データベースに保存されたデータはHibernateによって
         *  自動で Message クラスのオブジェクトになってこのリストの中に
         *  格納される
         */
        List<Task> tasks = em.createNamedQuery("getAllTasks", Task.class).getResultList();
        response.getWriter().append(Integer.valueOf(tasks.size()).toString());

        em.close();

        request.setAttribute("tasks", tasks);

        // DBから取得したタスク一覧(tasks)をリクエストスコープにセット
        // index.jspを呼び出している、
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/index.jsp");
        rd.forward(request, response);
    }
}
