package pl.threedcrafts.cardgame;

import pl.threedcrafts.cardGameGen.ClassType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@WebServlet("/startgame")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        resp.getWriter().write("<html>\n" +
                "  <head>\n" +
                "    <title>$Title$</title>\n" +
                " <meta charset=\"UTF-8\">"+
                "  </head>\n" +
                "  <body><form method=\"post\" accept-charset=\"UTF-8\">\n"+
                "name: <input type=\"text\" name=\"name\">\n"+
                " Class:<select name = \"userClass\">\n");


        List<String> classes = new ArrayList<String>();
        EnumSet.allOf(ClassType.class)
                .forEach(classType -> classes.add(classType.toString()));

        for(String classType: classes){
            resp.getWriter().write("<option value=\""+classType+"\">"+classType+"</option>");
        }
        resp.getWriter().write("  </select><br><input type=\"submit\" value=\"graj!\"></form></body>\n" +
                "</html>\n");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String userClass = req.getParameter("userClass");
        resp.getWriter().write("<html>\n" +
                        "  <head>\n" +
                        "    <title>$Title$</title>\n" +
                        " <meta charset=\"UTF-8\">"+
                        "  </head>\n" +
                        "  <body>");
        resp.getWriter().write("witaj "+name+"!<br> Twoja klasa to: "+userClass);

        resp.getWriter().write("</body>\n" +
                "</html>\n");

    }
}
