package admin.commands;

import com.pvt.CategoryService;
import com.pvt.daoEntities.Category;
import com.pvt.daoEntities.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ShowOnDateCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
        CategoryService cs = new CategoryService();
		String date = request.getParameter("date");
		List<Category> list;

		list = cs.getCategoryList();
		
		Iterator<Category> iterator = list.iterator();
		while(iterator.hasNext()){
			Category cat = iterator.next();
			cat.setNews(cs.getNewsByCategory(cat));
            List<News> newsList = cat.getNews();
			Iterator<News> iterator2 = newsList.iterator();
			while(iterator2.hasNext()){
				News item = iterator2.next();
				if(!(item.getCreationdate().equals(date))){
					iterator2.remove();
				}
			}
		}
		request.setAttribute("categories", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/adminpages/mainadmin.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
