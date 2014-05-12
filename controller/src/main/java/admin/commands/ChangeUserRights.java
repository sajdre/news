package admin.commands;

import com.pvt.RoleService;
import com.pvt.UserService;
import com.pvt.daoEntities.Role;
import com.pvt.daoEntities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChangeUserRights extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        UserService us = new UserService();
        RoleService rs = new RoleService();
        String email = request.getParameter("userid");
        User user = us.getUserById(email);
        String [] stringids = request.getParameterValues("roleid");
        if(stringids == null){
            try {
                response.sendRedirect("/admin/");
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
        Integer[] ids = new Integer[stringids.length];
        for(int i = 0; i<ids.length; i++){
            ids[i] = Integer.parseInt(stringids[i]);
        }
        List<Role> rolesList = rs.getRoleListById(ids);
        user.setRoles(rolesList);
        us.update(user);
        try {
            response.sendRedirect("/admin/");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
