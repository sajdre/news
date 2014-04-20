package admin;


import com.pvt.News;
import com.pvt.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class DeleteNewsCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

        NewsService ns = new NewsService();
        News news = ns.getNewsById((Serializable) request.getParameter("id"));
        ns.deleteNews(news);
		try {
			response.sendRedirect("/admin/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
		}
	}
}
