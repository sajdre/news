package admin.commands;

import com.pvt.daoEntities.Category;
import com.pvt.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCategoryCommand extends Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Category cat;
        CategoryService cs = new CategoryService();
		cat = cs.getCategoryById(Integer.parseInt(request.getParameter("id")));
        cs.updateCategory(cat);
		request.setAttribute("category", cat);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/adminpages/editcategory.jsp");
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