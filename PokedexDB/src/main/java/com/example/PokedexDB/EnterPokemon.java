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
            enterPokemon(request, response, "GET");
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            enterPokemon(request, response, "POST");
        }

        protected void enterPokemon(HttpServletRequest request, HttpServletResponse response, String requestType) throws ServletException, IOException{
            System.out.println("Enter a pokemon: " + requestType);

        try {
            MyDAO = PokedexDao.getInstance();
            int number = Integer.parseInt(request.getParameter("number"));
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            MyDAO.savePokemon(number, name, type);
        } catch (Exception e){
            System.out.println("Error adding to DB");
        }
            response.setContentType("text/html");
            try {
                PrintWriter respond = response.getWriter();
                respond.println("<!DOCTYPE html><html lang=\"en-us\"><head>");
                respond.println("<title> Enter a Pokemon</title>");
                respond.println("</head><body>");
                respond.println("<h1>Enter a Pokemon</h1>");
                respond.print("<form method=\"POST\" action=\"EnterPokemon\">");
                respond.println("Pokemon Number: ");
                respond.println("<input type=number name=number/>");
                respond.println("Pokemon Name: ");
                respond.println("<input type=text name=name/>");
                respond.println("Pokemon Type: ");
                respond.println("<input type=text name=type/>");
                respond.println("<input type=\"submit\" value=\"Save\" />");
                respond.println("</form>");
                respond.println("<br>");
                respond.println("<a href=\"mainDex\"><button type=\\\"button\\\">Return to Database</button/></a>");
                respond.println("</br>");
                respond.println("</body>");
            } catch(IOException e){
                e.printStackTrace();
                response.sendError(1, "Something went wrong");
            }


        }
        private static void savePokemon(Integer number, String name, String type){
            PokedexDao db;
            System.out.println("adding newly discovered Pokemon:");
            db = PokedexDao.getInstance();
            db.savePokemon(number,name,type);
        }

        }


