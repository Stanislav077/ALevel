import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    static SqlUtils sqlUtils = new SqlUtils();
    public static final String ID = "id";

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("firstname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        sqlUtils.insertIntoBd(name, email, String.valueOf(password.hashCode()));

        int counter = sqlUtils.getMaxId();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(ID)) {
                counter = Integer.valueOf(cookie.getValue());
            }
        }
        resp.addCookie(new Cookie(ID, String.valueOf(counter)));

        resp.sendRedirect("temp.jsp");
    }
}
