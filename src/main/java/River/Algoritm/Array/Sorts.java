package River.Algoritm.Array;

import java.util.Comparator;



public class Sorts {
    static Comparator<Car> comparatorGenerator(String[] fields) throws Exception {
        Comparator<Car> comparator = emptyCarComparator;
        for (String field : fields) {
            switch (field) {
                case "sign":
                    comparator = comparator.thenComparing(o -> o.sign);
                    break;
                case "mark":
                    comparator = comparator.thenComparing(o -> o.mark);
                    break;
                case "owner":
                    comparator = comparator.thenComparing(o -> o.owner);
                    break;
                case "dateLastRepair":
                    comparator = comparator.thenComparing(o -> o.dateLastRepair);
                    break;
                case "dateRepairTo":
                    comparator = comparator.thenComparing(o -> o.dateRepairTo );
                    break;
                default: break;
            }
        }

        return comparator;
    }

    private static Comparator<Car> emptyCarComparator = (o1, o2) -> 0;

    static void sortShell(Object[] array, Comparator comparator) {
        for (int d = array.length / 2; d > 0; d = d / 2) {
            for (int i = d; i < array.length; i++) {
                for (int j = i; j >= d; j = j - d) {
                    Object temp = array[j];
                    if (comparator.compare(temp, array[j - d]) >= 0) {
                        break;
                    }
                    array[j] = array[j - d];
                    array[j - d] = temp;
                }
            }
        }
    }
}
