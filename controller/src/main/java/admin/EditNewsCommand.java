package admin;

import com.pvt.News;
import com.pvt.NewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class EditNewsCommand extends Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		News news = new News();
        NewsService ns = new NewsService();
		news = ns.getNewsById((Serializable)request.getParameter("id"));
        ns.getNewsById(news);
		request.setAttribute("news", news);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/adminpages/editnews.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
