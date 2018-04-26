import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile2")
public class ProfileServlet extends HttpServlet {
    static SqlUtils sqlUtils = new SqlUtils();
    public static final String ID = "id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String coockieId = String.valueOf(sqlUtils.getMaxId());
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(ID)) {
                try {
                    if (cookie.getValue().equals(coockieId)) {
                        req.setAttribute("name", sqlUtils.getById(Integer.parseInt(cookie.getValue()), 1));
                        req.setAttribute("email", sqlUtils.getById(Integer.parseInt(cookie.getValue()), 2));
                        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
                        requestDispatcher.forward(req, resp);
                    }
                } catch (Exception e) {
                    resp.sendRedirect("/index.jsp");
                } finally {
                    resp.sendRedirect("/profile.jsp");
                }
            }
        }
    }
}
