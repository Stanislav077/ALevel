import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleterow")
public class DeleteRowServlet extends HttpServlet {
    static SqlUtils sqlUtils = new SqlUtils();
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String nametable = req.getParameter("nametable5");
        int row = Integer.parseInt(req.getParameter("row3"));
        sqlUtils.deleteRow(nametable, row);
        resp.sendRedirect("/");
    }
}
