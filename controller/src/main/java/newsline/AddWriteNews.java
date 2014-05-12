package newsline;

import com.pvt.NewsService;
import com.pvt.daoEntities.News;
import com.pvt.daoEntities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 12.05.14
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class AddWriteNews extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String name;
        User user = (User) session.getAttribute("user");
        name = user.getName() + user.getSecondname();
        NewsService ns = new NewsService();
        News news = new News();
        Date today;
        String dateOut;
        DateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat("yyyy.MM.dd");
        today = new Date();
        dateOut = dateFormatter.format(today);
        news.setAnnotation(request.getParameter("annotation"));
        news.setAuthor(name);
        news.setCategory_id(Integer.parseInt(request.getParameter("category")));
        news.setCreationdate(dateOut);
        news.setTitle(request.getParameter("title"));
        news.setContent(request.getParameter("content"));

        ns.save(news);
        try {
            response.sendRedirect("/site/");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
