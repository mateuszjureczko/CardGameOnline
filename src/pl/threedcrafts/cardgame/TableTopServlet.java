package pl.threedcrafts.cardgame;

import pl.threedcrafts.cardGameGen.Card;
import pl.threedcrafts.cardGameGen.cardGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cardgame")
public class TableTopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            resp.setContentType("text/html; charset=utf-8");
            String kindOfShot = req.getParameter("shot");


            String cardRequestAsString = req.getParameter("cardRequest");
            if (cardRequestAsString != null) {
               Integer liczba = Integer.valueOf(cardRequestAsString);

                Integer cardRequest = liczba;
                cardGenerator cardGenerator = new cardGenerator();
                cardGenerator.prepareBase();
                List<Card> karty = cardGenerator.generate(cardRequest);
                for (Card karta : karty) {
                    resp.getWriter().write(karta.toStringForHtml());
                    resp.getWriter().write("--------------------------------<br>");
                }


            }






            }



}
