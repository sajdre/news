package authentication.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 10.05.14
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class AuthorCheck implements Filter {
    public AuthorCheck() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        return;
    }

    @Override
    public void destroy() {

    }
}
