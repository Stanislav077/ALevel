import com.google.gson.*;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/json")
public class GetTableJsonServlet extends HttpServlet {
    static SqlUtils sqlUtils = new SqlUtils();
    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        String nametable = req.getParameter("tablename7");
        ArrayList<JsonObject> jsonData = sqlUtils.getJson(nametable);
        PrintWriter writer = resp.getWriter();
        for(int i = 0; i < jsonData.size(); i++) {
            if(jsonData.size() == 1){
                writer.print("{" + sqlUtils.getArrayId().get(i) + ":");
                writer.print(jsonData.get(i) + "}");
                break;
            } else if(i==0){
                writer.print("{" + sqlUtils.getArrayId().get(i) + ":");
                writer.print(jsonData.get(i) + ", ");
            } else if (i == jsonData.size()-1){
                writer.print(sqlUtils.getArrayId().get(i) +  ":");
                writer.print(jsonData.get(i) + "}");
            } else {
                writer.print(sqlUtils.getArrayId().get(i) + ":");
                writer.print(jsonData.get(i) + ", ");
            }

        }
        writer.flush();
        writer.close();
    }
}
