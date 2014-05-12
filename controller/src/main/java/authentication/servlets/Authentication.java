package authentication.servlets;

import com.pvt.UserService;
import com.pvt.daoEntities.Role;
import com.pvt.daoEntities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Authentication extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("id");
        String password = request.getParameter("password");
        Boolean registration = checkRegistration(email, password);
        if(registration == true){
            User user;
            UserService us = new UserService();
            user = us.getUserById(email);
            List<Role> role = user.getRoles();
            List<Integer> roleIds = new ArrayList<Integer>();
            Iterator iterator = role.iterator();
            while(iterator.hasNext()){
                Integer id = ((Role)iterator.next()).getId();
                roleIds.add(id);
            }

            session.setAttribute("user", user);
            session.setAttribute("login", true);
            session.setAttribute("role", roleIds);
            session.setMaxInactiveInterval(60*60*24);
            request.getRequestDispatcher("/site/").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/site/").forward(request, response);
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private boolean checkRegistration(String email, String password){
        UserService us = new UserService();
        User user;
        user = us.getUserById(email);
        if (user == null){
            return false;
        }
        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
