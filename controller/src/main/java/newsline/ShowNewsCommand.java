package newsline;

import com.pvt.Category;
import com.pvt.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowNewsCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Category> list;
		CategoryService cs = new CategoryService();
		list = cs.getCategoryList();
		request.setAttribute("categories", list);
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
