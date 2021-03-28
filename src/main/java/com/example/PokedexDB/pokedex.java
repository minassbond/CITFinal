package com.example.PokedexDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Pokedex", value = "/data")
public class pokedex extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String pokemon = request.getParameter("pokemon");
        String type = request.getParameter("type");
        String area = request.getParameter("area");

        // Data Entered
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Your data has been submitted</title>");
        out.println("</head>");
        out.println("<body>");
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {


    }
}