package authentication;

import com.pvt.Users;
import com.pvt.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Authentication implements Filter {

    /**
     * Default constructor. 
     */
    public Authentication() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if(session.getAttribute("login") == (Object) true){
			chain.doFilter(request, response);
			return;
		}else{
			session.setAttribute("login", null);
		}
		if((session.getAttribute("login") == null) && ((req.getParameter("id") == null) || (req.getParameter("password") == null))){
			req.getRequestDispatcher("/WEB-INF/index.html").forward(request, response);
			return;
		}else if(session.getAttribute("login") == null && (checkRegistration(req.getParameter("id"), req.getParameter("password")))){
			Users user;
            UsersService us = new UsersService();
			user = us.getUserById(req.getParameter("id"));
			session.setAttribute("user", user);
			session.setAttribute("login", true);
			session.setMaxInactiveInterval(60*60*24);
			req.getRequestDispatcher("/admin/").forward(request, response);
			return;
		}req.getRequestDispatcher("/WEB-INF/index.html").forward(request, response);
		return;
	}


	/**
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

    public boolean checkRegistration(String email, String password){
        UsersService us = new UsersService();
        Users user;
        user = us.getUserById(email);
        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
