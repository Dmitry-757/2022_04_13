package org.dng;

/**
 1. Создать класс «Автомобиль» с полями гос.номер, мощность автомобиля (л.с.), год проиводства автомобиля.
 2. Добавить в класс статическое поле double «налоговая ставка» (руб.) – default = 1.
 3. Реализовать методы геттеров и сеттеров.
 4. Реализовать метод расчета налога на данный автомобиль по формуле S = P * Q – Y / Q, где P – мощность данного автомобиля (поле класса), Q – налоговая ставка, Y – возраст автомобиля (сколько машине лет, вычислить через год выпуска).
 5. Реализовать статические методы сеттера и геттера для статического поля налоговой ставки.
 6. Протестировать программу: создать несколько автомобилей, посчитать для них налоги. Далее поменять ставку, посчитать еще раз для тех же автомобилей.

 7. Добавление класса пользовательского интерфейса приветствуется.
 */


import org.dng.repository.CarsRepository;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/carsTaxCalc")
public class setDataServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Car> lc = CarsRepository.findAll();
        req.setAttribute("cars", lc);
        req.setAttribute("taxRate", Car.getTaxRate());

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //searching and processing of "tax rate" parameter
        String sTaxRate = req.getParameter("taxRate");//get taxRate parameter from http request
        if(sTaxRate != null) {
            double tax = Double.parseDouble(sTaxRate);//cast it to double
            CarsRepository.setTax(tax);//set new tax rate to cars

            req.setAttribute("taxRate", Car.getTaxRate());//set new value of tax rate to request attribute

            List<Car> lc = CarsRepository.findAll();//get list of cars-objects
            req.setAttribute("cars", lc);//pass it to jsp-attribute
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");//get jsp-maket context
            dispatcher.forward(req, resp);//forward our data to jsp-page
        }

        //searching and processing of "number of created cars" parameter
        String sNumCar = req.getParameter("numCar");
        if(sNumCar != null) {
            int nCars = Integer.parseInt(sNumCar);
            if(nCars >= 0) {
                CarsRepository.makeNCars(nCars);//creat nCars objects of Cars

                //renew data for user in http
                req.setAttribute("taxRate", Car.getTaxRate());
                List<Car> lc = CarsRepository.findAll();
                req.setAttribute("cars", lc);
            }
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
