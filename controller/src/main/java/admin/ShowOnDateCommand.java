package admin;

import com.pvt.daoEntities.Category;
import com.pvt.CategoryService;
import com.pvt.daoEntities.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShowOnDateCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Date today;
        CategoryService cs = new CategoryService();
		String date = request.getParameter("date");
		String dateOut;
		List<Category> list;

		list = cs.getCategoryList();
		
		Iterator<Category> iterator = list.iterator();
		while(iterator.hasNext()){
			Category cat = (Category) iterator.next();
			List<News> news = cat.getNews();
			Iterator<News> iterator2 = news.iterator();
			while(iterator2.hasNext()){
				News item = (News) iterator2.next();
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
