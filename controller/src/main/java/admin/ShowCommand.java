package admin;

import com.pvt.Category;
import com.pvt.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<Category> list;
        CategoryService cs = new CategoryService();
		list = cs.getCategoryList();
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
