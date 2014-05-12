package admin.commands;

import com.pvt.daoEntities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 04.05.14
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
public class ShowUsers extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/adminpages/usercontrol.jsp");
        List<User> users = null;
        request.setAttribute("users", users);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
