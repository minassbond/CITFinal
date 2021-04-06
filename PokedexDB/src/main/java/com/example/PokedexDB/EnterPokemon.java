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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

    @WebServlet(name = "EnterPokemon", value = "/EnterPokemon")
    public class EnterPokemon extends HttpServlet {
        private PokedexDao MyDAO;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            response.setContentType("text/html");
            try {
                PrintWriter respond = response.getWriter();
                respond.println("<!DOCTYPE html><html lang=\"en-us\"><head>");
                respond.println("<title> Enter a Pokemon</title>");
                respond.println("</head><body>");
                respond.println("<h1>Enter a Pokemon</h1>");
                respond.println("<a href=\"mainDex\"><button type=\\\"button\\\">Return to Database</button/></a>");
                respond.print("<form method=\"POST\" action=\"EnterPokemon\">");
                respond.println("Pokemon Number: ");
                respond.println("<input type=number name=number/>");
                respond.println("Pokemon Name: ");
                respond.println("<input type=text name=name/>");
                respond.println("Pokemon Type: ");
                respond.println("<input type=text name=type/>");
                respond.println("<input type=\"submit\" value=\"Save\" />");
            } catch(IOException e){
                e.printStackTrace();
                response.sendError(1, "Something went wrong");
            }
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            MyDAO = PokedexDao.getInstance();
            int number = Integer.parseInt(request.getParameter("number"));
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            Pokemon p = new Pokemon();
            p.setPokeID(number);
            p.setPokename(name);
            p.setPoketype(type);
            MyDAO.savePokemon(p);
            number = p.getPokeID();
            name = p.getPokename();
            type = p.getPoketype();



        }

        }


