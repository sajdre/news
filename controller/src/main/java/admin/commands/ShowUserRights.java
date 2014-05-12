package admin.commands;

import com.pvt.RoleService;
import com.pvt.UserService;
import com.pvt.daoEntities.Role;
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
 * Date: 05.05.14
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
public class ShowUserRights extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userid");
        UserService us = new UserService();
        RoleService rs = new RoleService();
        User user = us.getUserById(userId);
        List<Role> roleList = rs.getRoleList();
        List<Role> userRolesList = user.getRoles();
        roleList.removeAll(userRolesList);
        request.setAttribute("userroles", userRolesList);
        request.setAttribute("allroles", roleList);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/adminpages/userrights.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
