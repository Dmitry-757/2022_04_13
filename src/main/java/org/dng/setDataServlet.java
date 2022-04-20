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

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        CarsRepository.makeNCars(3);
        List<Car> lc = CarsRepository.findAll();
        // lc.stream().forEach(c -> System.out.println(c.toString()));
        req.setAttribute("cars", lc);
        req.setAttribute("taxRate", Car.getTaxRate());

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sTaxRate = req.getParameter("taxRate");
        if(sTaxRate != null) {
            double tax = Double.parseDouble(sTaxRate);
            CarsRepository.setTax(tax);

            req.setAttribute("taxRate", Car.getTaxRate());

            List<Car> lc = CarsRepository.findAll();
            req.setAttribute("cars", lc);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
            dispatcher.forward(req, resp);
        }

        String sNumCar = req.getParameter("numCar");
        if(sNumCar != null) {
            int nCars = Integer.parseInt(sNumCar);
            CarsRepository.makeNCars(nCars);

//            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/cars");
//            dispatcher.forward(req, resp);

//            doGet(req,resp);
            req.setAttribute("taxRate", Car.getTaxRate());
            List<Car> lc = CarsRepository.findAll();
            req.setAttribute("cars", lc);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
