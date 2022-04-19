package org.dng;

/**
 Задание.
 1. Создать класс «Автомобиль» с полями гос.номер, мощность автомобиля (л.с.), год проиводства автомобиля.
 2. Добавить в класс статическое поле double «налоговая ставка» (руб.) – default = 1.
 3. Реализовать методы геттеров и сеттеров.
 4. Реализовать метод расчета налога на данный автомобиль по формуле S = P * Q – Y / Q, где P – мощность данного автомобиля (поле класса), Q – налоговая ставка, Y – возраст автомобиля (сколько машине лет, вычислить через год выпуска).
 5. Реализовать статические методы сеттера и геттера для статического поля налоговой ставки.
 6. Протестировать программу: создать несколько автомобилей, посчитать для них налоги. Далее поменять ставку, посчитать еще раз для тех же автомобилей
 */



public class CarMain {
    public static void main(String[] args) {
        Car car1 = new Car("x111yz", 50, 2015 );
        Car car2 = new Car("x222yz", 70, 2017 );
        Car car3 = new Car("x333yz", 150, 2010 );

        System.out.println("Tax rate is "+Car.getTaxRate());
        System.out.printf("for car %s with power %s and issueYear %s tax = %3.2f \n",car1.getGosNom(), car1.getPower(), car1.getIssueYear(),car1.taxSum());
        System.out.printf("for car %s with power %s and issueYear %s tax = %3.2f \n",car2.getGosNom(), car2.getPower(), car2.getIssueYear(),car2.taxSum());
        System.out.printf("for car %s with power %s and issueYear %s tax = %3.2f \n",car3.getGosNom(), car3.getPower(), car3.getIssueYear(),car3.taxSum());
        System.out.println();

        Car.setTaxRate(5);

        System.out.println("Tax rate is "+Car.getTaxRate());
        System.out.printf("for car %s with power %s and issueYear %s tax = %3.2f \n",car1.getGosNom(), car1.getPower(), car1.getIssueYear(),car1.taxSum());
        System.out.printf("for car %s with power %s and issueYear %s tax = %3.2f \n",car2.getGosNom(), car2.getPower(), car2.getIssueYear(),car2.taxSum());
        System.out.printf("for car %s with power %s and issueYear %s tax = %3.2f \n",car3.getGosNom(), car3.getPower(), car3.getIssueYear(),car3.taxSum());

    }
}
