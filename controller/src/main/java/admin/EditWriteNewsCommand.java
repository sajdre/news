package admin;

import com.pvt.News;
import com.pvt.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditWriteNewsCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
        NewsService ns = new NewsService();
		News news = new News();
		news.setAnnotation(request.getParameter("annotation"));
		news.setAuthor(request.getParameter("author"));
		news.setCategory(Integer.parseInt(request.getParameter("category")));
		news.setCreationdate(request.getParameter("creationdate"));
		news.setTitle(request.getParameter("title"));
		news.setContent(request.getParameter("content"));
		news.setId(request.getParameter("id"));
		ns.updateNews(news);
		try {
			response.sendRedirect("/admin/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
		}
	}

}
