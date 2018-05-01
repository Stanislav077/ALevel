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
        ArrayList<JSONObject> jsonData = sqlUtils.getJson(nametable);
        //ArrayList<JsonObject> jsonObjectArray = new ArrayList<>();
        //JsonObject jsonObject;
        PrintWriter writer = resp.getWriter();
        for(int i = 0; i < jsonData.size(); i++){
            writer.println(jsonData.get(i));
            System.out.println(jsonData.get(i));
        }
        /*for(int i = 0; i < jsonData.length; i++){
            jsonObject = new JsonObject();
            jsonObject.addProperty(jsonData[i].split(" ")[0], jsonData[i].split(" ")[1]);
            writer.println(jsonObject);
        }*/
        writer.flush();
        writer.close();
    }
}
