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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        makeResponse(request, response, "POST");

    }

    private void makeResponse(HttpServletRequest request, HttpServletResponse response, String requestType) throws ServletException, IOException{
        System.out.println(requestType + " : Pokedex");
        MyDAO = PokedexDao.getInstance();
        List<Pokemon> pk = MyDAO.getPokemon();
        response.setContentType("text/html");
        try{
            PrintWriter respond = response.getWriter();
            respond.println("<!DOCTYPE html><html lang=\\\"en-us\\\"><head>");
            respond.println("<title>The Pokedex</title>");
            respond.println("</head><body>");
            respond.println("<div>");
            respond.println("<a href=\"EnterPokemon\" New Pokemon Entry</a>");
            respond.println("<a href=\"index.jsp\" Home Page</a>");
            respond.println("</div>");
            respond.println("<h1>Pokedex</h1>");
            respond.println("<table class=\"table table-sm table-bordered\">");
            respond.println("<tr>");
            respond.println("<th>Number</th>");
            respond.println("<th>Pokemon</th>");
            respond.println("<th class-\"text-right\">type</th>");
            respond.println("</tr>");
            for (Pokemon p: pk){
                respond.println("<tr>");
                respond.println("<td>" + p.getPokeID() + "</td>");
                respond.println("<td>" + p.getPokename() + "</td>");
                respond.println("<td>" + p.getPoketype() + "</td>");
                respond.println("</tr>");
            }
            respond.println("<div>");
            respond.println("<br><a href=\"EnterPokemon\"><button type=\"button\">Add New Pokemon</button/></a>");
            respond.println("</div>");
            respond.println("</body></html>");
        }catch(IOException e ){
            e.printStackTrace();
        }


    }
}