package River.Algoritm.Array;


import java.sql.Date;
import java.util.Arrays;
import java.util.Comparator;

import static River.Algoritm.Array.Sorts.comparatorGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        Car[] cars = {
                new Car("314", "Geely", "Tolik", Date.valueOf("2014-12-12"), Date.valueOf("2016-12-16") ),
                new Car("475", "Geely",  "Miron", Date.valueOf("2015-01-13"), Date.valueOf("2016-10-12") ),
                new Car("431","Ford", "Lera", Date.valueOf("2016-09-15"), Date.valueOf("2017-02-01") ),
                new Car("xxx", "Focus",  "Demyan", Date.valueOf("2016-08-25"), Date.valueOf("2016-12-25") ),
                new Car("xxx","Hyundai", "Slava", Date.valueOf("2016-10-10"), Date.valueOf("2016-12-13") ),
                new Car("212","Ford", "Alena", Date.valueOf("2015-08-31"), Date.valueOf("2017-01-25") ),
                new Car("xxx","Honda", "Olya",Date.valueOf("2014-03-26"), Date.valueOf("2017-03-26") ),
        };
        String[] fields = {"dateLastRepair","mark", "owner"};

        Comparator<Car> comparator = comparatorGenerator(fields);

        System.out.println(Arrays.toString(cars)+'\n');
        Sorts.sortShell(cars, comparator);
        System.out.println(Arrays.toString(cars));
    }


}
