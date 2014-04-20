package admin;

import com.pvt.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class DeleteCategoryCommand extends Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
        CategoryService cs = new CategoryService();
        Serializable i = Integer.parseInt(request.getParameter("id"));
		cs.deleteCategory(cs.getCategoryById(i));
		try {
			response.sendRedirect("/admin/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
