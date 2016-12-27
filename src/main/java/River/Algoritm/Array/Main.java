package River.Algoritm.Array;

import java.time.LocalDate;

import static River.Algoritm.Array.Sorts.carComparatorGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        Car[] cars = {
                new Car("А215ЕК", "Ford", "Иванов Сергей Игоревич", LocalDate.parse("2014-12-12"), LocalDate.parse("2017-01-15")),
                new Car("А475ВС", "Honda", "Смирнова Екатерина Андреевна", LocalDate.parse("2016-05-29"), LocalDate.parse("2017-01-23")),
                new Car("Е431ТУ", "Audi", "Сергеев Павел Анатольевич", LocalDate.parse("2016-09-15"), LocalDate.parse("2015-09-04")),
                new Car("Р648АК", "Ford", "Антонов Михаил Юрьевич", LocalDate.parse("2017-01-05"), LocalDate.parse("2017-02-15")),
                new Car("Р659КС", "Hyundai", "Новиков Вячеслав Петрович", LocalDate.parse("2015-01-10"), LocalDate.parse("2017-01-23")),
                new Car("В212УК", "Ford", "Романов Роман Алексеевич", LocalDate.parse("2015-08-31"), LocalDate.parse("2017-01-25")),
                new Car("А648ВУ", "Honda", "Викторова Ольга Ивановна", LocalDate.parse("2017-01-07"), LocalDate.parse("2017-02-26")),
                new Car("В812КН", "Ford", "Иванова Татьяна Алексеевна", LocalDate.parse("2014-03-26"), LocalDate.parse("2017-02-03")),
                new Car("К816АК", "Kia", "Смирнов Леонид Артемович", LocalDate.parse("2016-03-26"), LocalDate.parse("2017-02-12")),
                new Car("Т845КМ", "Audi", "Иванов Игорь Сергеевич", LocalDate.parse("2015-05-12"), LocalDate.parse("2017-01-25")),
        };

        System.out.println("Список машин в мастерской:");
        printCarArray(cars);

        String[] fields = {"owner"};
        Sorts.sortShell(cars, carComparatorGenerator(fields));

        Car[] carsNotRepairedThisYear = new Car[cars.length];
        int index = 0;

        for (Car car : cars) {
            if (car.dateLastRepair.getYear() < LocalDate.now().getYear()) {
                carsNotRepairedThisYear[index] = car;
                index++;
            }
        }

        System.out.println("Владельцы машин, не ремонтировавшихся с прошлого года:");

        for (Car car : carsNotRepairedThisYear) {
            if (car != null) {
                System.out.println(car.owner);
            }
        }
    }

    private static void printCarArray(Car[] cars) {
        System.out.printf("%-6s %-10s %-30s %-16s %-18s \n", "Номер", "Марка", "Владелец", "Последний ремонт", "Отремонтировать до");

        for (Car car : cars) {
            if (car != null) {
                System.out.println(car.toString());
            }
        }

        System.out.println();
    }
}
