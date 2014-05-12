package newsline;

import com.pvt.CategoryService;
import com.pvt.NewsService;
import com.pvt.UserService;
import com.pvt.daoEntities.Category;
import com.pvt.daoEntities.News;
import com.pvt.daoEntities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowNewsCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
        CategoryService cs = new CategoryService();
        NewsService ns = new NewsService();
        UserService us = new UserService();
        HttpSession session = request.getSession();
        // if "category" parameter there is, we show news by this category id
        String stringCategoryId = request.getParameter("category");
        if(stringCategoryId != null){
        Integer categoryId = Integer.parseInt(stringCategoryId);
        List<News> newslist = ns.getNewsByCategoryId(categoryId);
        request.setAttribute("newslist", newslist);
        Category selectedCategory = cs.getCategoryById(categoryId);
        request.setAttribute("selectedcategory", selectedCategory);
        }
        //Same with user
        User user;
        user = (User) session.getAttribute("user");
        if(user != null){
            request.setAttribute("user", user);
            if(us.isAdmin(user)){
                request.setAttribute("admin", true);
            }
            if(us.isAuthor(user)){
                request.setAttribute("author", true);
            }
        }
        // Set all categories to request
        List<Category> list;
        list = cs.getCategoryList();
        request.setAttribute("categories", list);
        /////////////////
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
