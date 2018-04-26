import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/main.jsp")
public class FilterServletLoging implements Filter {
    public static final String ID = "id";
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        int tempCount = 0;
        for (Cookie cookie: cookies) {
            if(cookie.getName().equals(ID)){
                tempCount = 1;
            }
        }

        if (tempCount == 0){
           response.sendRedirect("index.jsp");
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
