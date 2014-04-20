package admin;

import com.pvt.Category;
import com.pvt.CategoryService;
import com.pvt.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShowOnlyTodayCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Date today;
		String dateOut;
		DateFormat dateFormatter;
		dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		today = new Date();
		dateOut = dateFormatter.format(today);
		List<Category> list;
        CategoryService cs = new CategoryService();
		list = cs.getCategoryList();
		
		Iterator<Category> iterator = list.iterator();
		while(iterator.hasNext()){
			Category cat = (Category) iterator.next();
			List<News> news = cat.getNewsByCategory();
			Iterator<News> iterator2 = news.iterator();
			while(iterator2.hasNext()){
				News item = (News) iterator2.next();
				if(!(item.getCreationdate().equals(dateOut))){
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
