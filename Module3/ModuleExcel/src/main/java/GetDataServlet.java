import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getdata")
public class GetDataServlet extends HttpServlet {
    static SqlUtils sqlUtils = new SqlUtils();
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String nameTable = req.getParameter("nametabledata");
        int row = Integer.parseInt(req.getParameter("row2"));
        String data = req.getParameter("data");
        sqlUtils.insertData(nameTable, row, data);
        resp.sendRedirect("/");
    }
}
