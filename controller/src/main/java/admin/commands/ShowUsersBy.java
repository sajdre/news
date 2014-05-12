package admin.commands;

import com.pvt.UserService;
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
 * Time: 19:31
 * To change this template use File | Settings | File Templates.
 */
public class ShowUsersBy extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        UserService us = new UserService();
        List<User> users;
        users = us.getUserBy(request.getParameter("email"),
                request.getParameter("firstname"), request.getParameter("secondname"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/adminpages/usercontrol.jsp");
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
