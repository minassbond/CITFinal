package com.example.PokedexDB;

import PokedexDB.hibernate.dao.PokedexDao;
import PokedexDB.hibernate.model.Pokemon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Pokedex", value = "/mainDex")
public class pokedex extends HttpServlet {
    private PokedexDao MyDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        makeResponse(request, response, "GET");

        String pokemon = request.getParameter("pokemon");
        String type = request.getParameter("type");
        String area = request.getParameter("area");

        // Data Entered
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Pokedex Data</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Your data has been submitted");
        out.println("<br></br>");
        out.println("New Pokemon: " + pokemon);
        out.println("<br></br>");
        out.println("Typing: " + type);
        out.println("<br></br>");
        out.println("Area Seen: " + area);
        out.println("<br></br>");
        out.print("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        makeResponse(request, response, "POST");

    }

    private void makeResponse(HttpServletRequest request, HttpServletResponse response, String requestType) throws ServletException, IOException{
        System.out.println(requestType + " : Pokemon");
        MyDAO = PokedexDao.getInstance();
        List<Pokemon> pk = MyDAO.getPokemon();
    }
}