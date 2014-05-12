package admin;
import admin.commands.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		/**
		 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Logger log = Logger.getLogger(AdminController.class);
            String operation = request.getParameter("operation");
			
			Command com = null;
			
			if(operation == null)
			{
				com = new ShowCommand();
			}else if(operation.equals("addcategory")){
				com = new AddCategoryCommand();
			}else if(operation.equals("addwritecategory")){
				com = new AddWriteCategoryCommand();
			}else if(operation.equals("addnews")){
				com = new AddNewsCommand();
			}else if(operation.equals("addwritenews")){
				com = new AddWriteNewsCommand();
			}else if(operation.equals("editnews")){
				com = new EditNewsCommand();
			}else if(operation.equals("editwritenews")){
				com = new EditWriteNewsCommand();
			}else if(operation.equals("editcategory")){
				com = new EditCategoryCommand();
			}else if(operation.equals("editwritecategory")){
				com = new EditWriteCategoryCommand();
			}else if(operation.equals("deletenews")){
				com = new DeleteNewsCommand();
			}else if(operation.equals("deletecategory")){
				com = new DeleteCategoryCommand();
			}else if(operation.equals("showonlythiscategory")){
				com = new ShowOnlyThisCategoryCommand();
			}else if(operation.equals("showondate")){
				com = new ShowOnDateCommand();
			}else if(operation.equals("showusers")){
                com = new ShowUsers();
            }else if(operation.equals("showusersby")){
                com = new ShowUsersBy();
            }else if(operation.equals("userrights")){
                com = new ShowUserRights();
            }else if(operation.equals("changerights")){
                com = new ChangeUserRights();
            }
			try{
			com.execute(request, response);
            }catch (RuntimeException rte){
                log.info("Command doesn`t work", rte);
            }
		}

		/**
		 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}

