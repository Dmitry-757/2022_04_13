package org.dng;

import org.dng.repository.CarsRepository;

import java.util.List;

/**
 Задание.
 1. Создать класс «Автомобиль» с полями гос.номер, мощность автомобиля (л.с.), год проиводства автомобиля.
 2. Добавить в класс статическое поле double «налоговая ставка» (руб.) – default = 1.
 3. Реализовать методы геттеров и сеттеров.
 4. Реализовать метод расчета налога на данный автомобиль по формуле S = P * Q – Y / Q, где P – мощность данного автомобиля (поле класса), Q – налоговая ставка, Y – возраст автомобиля (сколько машине лет, вычислить через год выпуска).
 5. Реализовать статические методы сеттера и геттера для статического поля налоговой ставки.
 6. Протестировать программу: создать несколько автомобилей, посчитать для них налоги. Далее поменять ставку, посчитать еще раз для тех же автомобилей
  */


//************** Light version )) ******************
public class CarMain {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("*******************");
        CarsRepository.makeNCars(4); //lets make 4 objects of Car
        List<Car> lc = CarsRepository.findAll(); //lets make list of car-objects that were created earlier

        Car.setTaxRate(1);// lets set tax rate
        System.out.println("Tax rate is "+Car.getTaxRate());//checking of current tax rate
        lc.stream().forEach(c-> System.out.println(c.toString())); //lets print list of cars with calculated tax values

        System.out.println();
        Car.setTaxRate(5);// lets reset taxe rate
        System.out.println("Tax rate is "+Car.getTaxRate());//checking of current tax rate
        lc.stream().forEach(c-> System.out.println(c.toString()));//lets print list of cars with calculated tax values


    }
}
