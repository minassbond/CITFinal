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

    @WebServlet(name = "EnterPokemon", value = "/EnterPokemon")
    public class EnterPokemon extends HttpServlet {
        private PokedexDao MyDAO;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            makeResponse(request, response, "GET");
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            makeResponse(request, response, "POST");

        }

        private void makeResponse(HttpServletRequest request, HttpServletResponse response, String requestType) throws ServletException, IOException{
            System.out.println(requestType + " : Pokemon");
            MyDAO = PokedexDao.getInstance();
            List<Pokemon> pk = MyDAO.getPokemon();
            Pokemon p;
            int id;
            boolean idProblem = false;
            boolean nameProblem = false;

            String pid = request.getParameter("pokeID");
            String name = request.getParameter("pokename");
            String type = request.getParameter("poketype");

            if(pid == null && name == null){
                pid = "New";
                name = "";
                type = "";
            } else if(!pid.equals("New")){
                p = MyDAO.getPokemon(Integer.parseInt(pid));
                if (p==null) {
                    response.sendRedirect("pokedex");
                    return;
                }
                name = p.getPokename();
                type = p.getPoketype();
                }else if (pid != null && name != null) {
                System.out.println("New Pokemon data entry");
                try{
                    if(!pid.equals("New")){
                        id = Integer.parseInt(pid);
                    }
                } catch (NumberFormatException e) {
                    idProblem = true;
                }
                if (name.length() > 50){
                    nameProblem = true;
                }
            }


        }
    }
