package newsline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Authentication implementation class SiteController
 */

public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("operation");
		
		 Command com = null;
		
		if(operation == null)
		{
			com = new ShowNewsCommand();
		}else if(operation.equals("shownews")){
			com = new ShowContentCommand();
		}else if(operation.equals("addcomment")){
            com = new AddComment();
        }else if(operation.equals("addnews")){
            com = new AddNews();
        }else if(operation.equals("addwritenews")){
            com = new AddWriteNews();
        }else{
            com = new ShowNewsCommand();
        }com.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
