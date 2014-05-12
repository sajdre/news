package authentication.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class AdminCheck implements Filter {

    /**
     * Default constructor. 
     */
    public AdminCheck() {
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

		if((session.getAttribute("login") == (Object) true) && (((List<Integer>)session.getAttribute("role")).contains(1))){
            chain.doFilter(request, response);
			return;
		}else{
            req.getRequestDispatcher("/WEB-INF/newslinepages/index.html").forward(request, response);
		}
	}


	/**
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
