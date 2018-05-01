import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getdatawithoutrow")
public class GetDataServletWithoutRow extends HttpServlet {
    static SqlUtils sqlUtils = new SqlUtils();
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String nameTable = req.getParameter("nametabledata2");
        String data = req.getParameter("data2");
        sqlUtils.insertDataWithoutRow(nameTable, data);
        resp.sendRedirect("/");
    }
}
