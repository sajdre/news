package admin;


import com.pvt.daoEntities.Category;
import com.pvt.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddWriteCategoryCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub


		Category cat = new Category();
		cat.setCategory(request.getParameter("category"));
		CategoryService cs = new CategoryService();
        cs.saveCategory(cat);
		try {
			response.sendRedirect("/admin/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
