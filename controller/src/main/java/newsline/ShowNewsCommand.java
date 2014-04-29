package newsline;

import com.pvt.daoEntities.Category;
import com.pvt.CategoryService;
import com.pvt.daoEntities.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ShowNewsCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
        List<Category> list;
        CategoryService cs = new CategoryService();
        list = cs.getCategoryList();
        Iterator<Category> itList = list.iterator();
        while(itList.hasNext()){
            Category cat = itList.next();
            List<News> news = cs.getNewsByCategory(cat);
            cat.setNews(news);
        }
        request.setAttribute("categories", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/newslinepages/index.jsp");
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
