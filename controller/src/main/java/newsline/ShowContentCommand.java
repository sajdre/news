package newsline;

import com.pvt.News;
import com.pvt.NewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class ShowContentCommand extends Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
        NewsService ns = new NewsService();
		News news = ns.getNewsById((Serializable) request.getParameter("id"));
		String content = news.getContent();
		request.setAttribute("content", content);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/newslinepages/content.jsp");
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
