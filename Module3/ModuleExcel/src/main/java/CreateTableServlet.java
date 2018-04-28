import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createtable")
public class CreateTableServlet extends HttpServlet {
    static SqlUtils sqlUtils = new SqlUtils();
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String nameTable = req.getParameter("nametablecreate");
        int col = Integer.parseInt(req.getParameter("col"));
        sqlUtils.createTable(nameTable, col);
        resp.sendRedirect("/");

    }
}
