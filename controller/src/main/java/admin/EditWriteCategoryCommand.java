package admin;

import com.pvt.Category;
import com.pvt.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditWriteCategoryCommand extends Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		Category cat = new Category();
        CategoryService cs = new CategoryService();
		cat.setId(Integer.parseInt(request.getParameter("id")));
		cat.setCategory(request.getParameter("category"));
		cs.updateCategory(cat);
		try {
			response.sendRedirect("/admin/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
		}
	}
}
