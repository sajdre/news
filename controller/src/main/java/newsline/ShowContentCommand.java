package newsline;

import com.pvt.NewsService;
import com.pvt.daoEntities.News;
import com.pvt.daoEntities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowContentCommand extends Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
        //if there is comment parameter, save comment

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null){
            request.setAttribute("user", user);
        }
        NewsService ns = new NewsService();
		News news = ns.getNewsById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("news", news);
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
