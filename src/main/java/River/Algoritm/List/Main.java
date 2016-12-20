package River.Algoritm.List;

import River.Algoritm.List.Exceptions.NegativePositionException;
import River.Algoritm.List.Exceptions.OutOfRangePositionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        loopMain:
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("0 - Выход из приложения");
            System.out.println("1 - Работа со списком");
            System.out.println("2 - Сравнение двух списоков");
            System.out.println("\nВведите команду:");
            switch (reader.readLine()) {
                case "0":
                    break loopMain;
                case "1":
                    System.out.println("\nРабота со списком");
                    uiList();
                    break;
                case "2":
                    System.out.println("\nСравнение двух списков");
                    uiCompareLists();
                    System.out.println();
                    break;
                default:
                    System.out.println();
            }
        }

    }

    private static void uiCompareLists() throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("compare - сравнение списков");
            System.out.println("exit - выход в основное меню");
            System.out.println("\nВведите команду:");
            switch (reader.readLine()) {
                case "compare":
                    List list1;
                    List list2;
                    try {
                        System.out.println("Введите элементы Списка 1 (целые числа через пробел):");
                        list1 = listInput();

                        System.out.println("Введите элементы Списка 2 (целые числа через пробел):");
                        list2 = listInput();
                    } catch (NumberFormatException e){
                        System.out.println("Некорректный ввод списка\n");
                        break;
                    }

                    List.compareAndPrintResult(list1, list2);
                    System.out.println();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println();
            }
        }
    }

    private static void uiList() throws IOException {

        List list = new List();
        uiListActions();
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nВведите команду:");

            switch (reader.readLine()) {
                case "addToEnd":
                    uiListAddToEnd(list, reader);
                    break;
                case "addToHead":
                    uiListAddToHead(list, reader);
                    break;
                case "addToPosition":
                    uiListAddToPosition(list, reader);
                    break;
                case "deleteHead":
                    uiListDeleteHead(list);
                    break;
                case "deleteLast":
                    uiListDeleteLast(list);
                    break;
                case "deletePosition":
                    uiListDeletePosition(list, reader);
                    break;
                case "find":
                    uiListFind(list, reader);
                    break;
                case "get":
                    uiListGet(list, reader);
                    break;
                case "isEmpty":
                    if (list.isEmpty()) {
                        System.out.println("Список пустой");
                    } else {
                        System.out.println("Список не пустой");
                    }
                    break;
                case "print":
                    list.print();
                    break;
                case "help":
                    uiListActions();
                    break;
                case "new":
                    System.out.println("\nРабота с новым списком");
                    list = new List();
                    break;
                case "exit":
                    System.out.println();
                    return;
                default:
            }
        }

    }

    private static void uiListActions() {
        System.out.println("addToEnd - добавление элемента в конец списка");
        System.out.println("addToHead - добавление элемента в начало списка");
        System.out.println("addToPosition - добавление элемента на позицию в списке");
        System.out.println("deleteHead - удаление первого элемента списка");
        System.out.println("deleteLast - удаление последнего элемента списка");
        System.out.println("deletePosition - удаление элемента списка на позиции");
        System.out.println("find - поиск элемента по значению, возврат позиции");
        System.out.println("get - поиск элемента по позиции, возврат значения");
        System.out.println("isEmpty - проверка пустоты списка");
        System.out.println("print - вывод списка на экран");
        System.out.println("\nnew - завершить работу с текущим списком списком и начать работу с новым");
        System.out.println("help - помощь");
        System.out.println("exit - выход в основное меню");
    }

    private static void uiListAddToEnd(List list, BufferedReader reader) throws IOException {
        System.out.println("Введите значение элемента(целое число):");
        int value;
        try {
            value = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод");
            return;
        }
        list.addToEnd(value);
        System.out.println("Элемент добавлен в список");
    }

    private static void uiListAddToHead(List list, BufferedReader reader) throws IOException {
        System.out.println("Введите значение элемента(целое число):");
        int value;
        try {
            value = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод");
            return;
        }
        list.addToHead(value);
        System.out.println("Элемент добавлен в список");
    }

    private static void uiListAddToPosition(List list, BufferedReader reader) throws IOException {
        int position;
        int value;
        try {
            System.out.println("Введите позицию для вставки элемента (целое число от 0 до n, n - количество элементов в списке):");
            position = Integer.parseInt(reader.readLine());
            System.out.println("Введите значение элемента(целое число):");
            value = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод");
            return;
        }

        try {
            list.addToPosition(value, position);
        } catch (NegativePositionException | OutOfRangePositionException e) {
            System.out.println("Введено некорректное значение позиции");
            return;
        }
        System.out.println("Элемент добавлен в список");
    }

    private static void uiListDeleteHead(List list) {
        try {
            list.deleteHead();
        } catch (OutOfRangePositionException e) {
            System.out.println("Пустой список: удаление невозможно");
            return;
        }
        System.out.println("Первый элемент списка удален");
    }

    private static void uiListDeleteLast(List list) {
        try {
            list.deleteLast();
        } catch (OutOfRangePositionException e) {
            System.out.println("Пустой список: удаление невозможно");
            return;
        }
        System.out.println("Последний элемент списка удален");
    }

    private static void uiListDeletePosition(List list, BufferedReader reader) throws IOException {
        int position;
        System.out.println("Введите позицию для удаления элемента (целое число от 0 до n, n - количество элементов в списке):");
        try {
            position = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод");
            return;
        }
        try {
            list.deletePosition(position);
        } catch (NegativePositionException | OutOfRangePositionException e) {
            if (list.isEmpty()) {
                System.out.println("Пустой список: удаление невозможно");
            } else {
                System.out.println("Введено некорректное значение позиции");
            }
            return;
        }
        System.out.println("Элемент списка удален");
    }

    private static void uiListFind(List list, BufferedReader reader) throws IOException {
        System.out.println("Введите значение для поиска:");
        int value;
        try {
            value = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод");
            return;
        }
        int findPosition = list.find(value);
        if (findPosition == -1) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println("Элемент найден на позиции: " + findPosition);
        }
    }

    private static void uiListGet(List list, BufferedReader reader) throws IOException {
        int position;
        int value;
        System.out.println("Введите позицию элемента (целое число от 0 до n, n - количество элементов в списке):");
        try {
            position = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод");
            return;
        }
        try {
            value = list.get(position);
        } catch (NegativePositionException | OutOfRangePositionException e) {
            System.out.println("Введено некорректное значение позиции");
            return;
        }
        System.out.println("Значение элемента: " + value);
    }

    private static List listInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List list = new List();
        String s = reader.readLine();
        String[] ints = s.split(" ");

        for (String number : ints) {
            list.addToEnd(Integer.parseInt(number));
        }

        return list;
    }
}



