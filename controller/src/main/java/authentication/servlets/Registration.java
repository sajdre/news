package authentication.servlets;

import com.pvt.RoleService;
import com.pvt.UserService;
import com.pvt.daoEntities.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 10.05.14
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public class Registration extends HttpServlet {
    Logger log = Logger.getLogger(Registration.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            log.info("No such algorithm exception", e);
        }
        String operation = request.getParameter("operation");
        String email;
        String password;
        String firstname;
        String secondname;
        User user = new User();
        UserService us = new UserService();
        RoleService rs = new RoleService();
        if((operation != null) && (operation.equals("adduser"))){
            if(!(request.getParameter("password1").equals(request.getParameter("password2")))){
                String errorMessage = "Password error";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("../WEB-INF/registration/index.jsp").forward(request, response);
                return;
            }
            email = request.getParameter("id");
            password = request.getParameter("password1");
            firstname = request.getParameter("firstname");
            secondname = request.getParameter("secondname");
            user.setName(firstname);
            user.setSecondname(secondname);
            user.setId(email);
            user.addRole(rs.getRoleById(2));
            user.setPassword(password);
            us.save(user);
            request.getRequestDispatcher("/site/").forward(request, response);
            return;
        }
        request.getRequestDispatcher("../WEB-INF/registration/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
