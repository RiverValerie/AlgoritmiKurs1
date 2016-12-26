package River.Algoritm.Array;

import java.util.Comparator;

public class Sorts {
    public static Comparator<Car> carComparatorGenerator(String[] fields) throws Exception {
        Comparator<Car> carComparator = emptyCarComparator;

        for (String field : fields) {
            switch (field) {
                case "sign":
                    carComparator = carComparator.thenComparing(o -> o.sign);
                    break;
                case "mark":
                    carComparator = carComparator.thenComparing(o -> o.mark);
                    break;
                case "owner":
                    carComparator = carComparator.thenComparing(o -> o.owner);
                    break;
                case "dateLastRepair":
                    carComparator = carComparator.thenComparing(o -> o.dateLastRepair);
                    break;
                case "dateRepairTo":
                    carComparator = carComparator.thenComparing(o -> o.dateRepairTo);
                    break;
                default:
                    break;
            }
        }

        return carComparator;
    }

    private static Comparator<Car> emptyCarComparator = (o1, o2) -> 0;

    public static void sortShell(Object[] array, Comparator comparator) {
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

    public static void sortInsertion(Object[] array, Comparator comparator) {
        for (int i = 1; i < array.length; i++) {
            Object temp = array[i];
            int j = i - 1;

            while ((j >= 0) && (comparator.compare(temp, array[j]) < 0)) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = temp;
        }
    }

    public static void sortSelection(Object[] array, Comparator comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[minIndex], array[j]) > 0) {
                    minIndex = j;
                }
            }

            Object min = array[minIndex];
            array[minIndex] = array[i];
            array[i] = min;
        }
    }

    public static void sortExchange(Object[] array, Comparator comparator) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    Object temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}