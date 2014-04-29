package admin;

import com.pvt.daoEntities.Category;
import com.pvt.CategoryService;
import com.pvt.daoEntities.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowOnlyThisCategoryCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Category> list = new ArrayList<Category>();
		CategoryService cs = new CategoryService();
		Serializable id = Integer.parseInt(request.getParameter("id"));
		list.add(cs.getCategoryById(id));
        Iterator<Category> itList = list.iterator();
        while(itList.hasNext()){
            Category cat = itList.next();
            List<News> news = cs.getNewsByCategory(cat);
            cat.setNews(news);
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
