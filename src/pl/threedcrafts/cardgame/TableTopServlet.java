package pl.threedcrafts.cardgame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cardgame")
public class TableTopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String kindOfShot = req.getParameter("shot");
        if (kindOfShot == null) {
            resp.getWriter().write("there Is No Nigass!");
        } else {
            resp.getWriter().write("watchout! someone is shooting Niggas! his name is " + kindOfShot);
        }


    }

}
