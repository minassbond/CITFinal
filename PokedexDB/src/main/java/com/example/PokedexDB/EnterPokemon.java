package com.example.PokedexDB;

import PokedexDB.hibernate.dao.PokedexDao;
import PokedexDB.hibernate.model.Pokemon;
import jakarta.servlet.RequestDispatcher;
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
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("EnterPokemon.jsp");
                dispatcher.forward(request, response);
            }catch(Exception e){
                System.out.println("We were unable to capture your data.");
            }
        }

        protected void enterPokemon(HttpServletRequest request, HttpServletResponse response, String requestType) throws ServletException, IOException{
            System.out.println("Enter a pokemon: " + requestType);
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("EnterPokemon.jsp");
                dispatcher.forward(request, response);
            }catch(Exception e){
                System.out.println("Your form was unable to collect the data.");
            }

        try {
            MyDAO = PokedexDao.getInstance();
            String number = request.getParameter("number");
            System.out.println(number);
            int number1 = Integer.parseInt(number);
           // System.out.println(number1);
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            MyDAO.savePokemon(number1, name, type);
        } catch (Exception e){
            System.out.println("Error adding to DB");
        }



        }
        private static void savePokemon(Integer number, String name, String type){
            PokedexDao db;
            System.out.println("adding newly discovered Pokemon:");
            db = PokedexDao.getInstance();
            db.savePokemon(number,name,type);
        }

        }


