package org.dng;


//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;

import org.dng.repository.CarsRepository;
import org.dng.repository.CarsRepositoryI;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/cars")
public class setDataServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CarsRepository.makeNCars(3);
        List<Car> lc = CarsRepository.findAll();
        lc.stream().forEach(c-> System.out.println(c.toString()));

        request.setAttribute("cars", lc);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
        dispatcher.forward(request, response);

//        response.setContentType("text/html");
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1> Hello ))</h1>");
//        out.println("</body></html>");
    }

    public void destroy() {
    }

}
