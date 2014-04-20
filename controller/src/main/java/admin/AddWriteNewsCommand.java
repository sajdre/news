package admin;


import com.pvt.News;
import com.pvt.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddWriteNewsCommand extends Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		News news = new News();
		Date today;
		String dateOut;
		DateFormat dateFormatter;
		dateFormatter = new SimpleDateFormat("yyyy.MM.dd");
		today = new Date();
		dateOut = dateFormatter.format(today);
        NewsService ns = new NewsService();
		news.setAnnotation(request.getParameter("annotation"));
		news.setAuthor(request.getParameter("author"));
		news.setCategory(Integer.parseInt(request.getParameter("category")));
		news.setCreationdate(dateOut);
		news.setTitle(request.getParameter("title"));
		news.setContent(request.getParameter("content"));
		news.setId(request.getParameter("id"));
		ns.saveNews(news);
		try {
			response.sendRedirect("/admin/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
