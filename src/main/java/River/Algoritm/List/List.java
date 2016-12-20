package River.Algoritm.List;

import River.Algoritm.List.Exceptions.NegativePositionException;
import River.Algoritm.List.Exceptions.OutOfRangePositionException;

public class List {
    private ListItem headItem;

    public void addToEnd(int value) {
        if (isEmpty()) {
            addToHead(value);
        } else {
            ListItem current = headItem;

            while (current.nextItem != null) {
                current = current.nextItem;
            }

            current.nextItem = new ListItem(value, null);
        }
    }

    public void addToHead(int value) {
        headItem = new ListItem(value, headItem);
    }

    public void addToPosition(int value, int position) throws OutOfRangePositionException, NegativePositionException {
        if (position == 0) {
            addToHead(value);
        } else {
            ListItem current = getInternal(position - 1);
            ListItem newItem = new ListItem(value, current.nextItem);
            current.nextItem = newItem;
        }
    }

    static void compareAndPrintResult(List list1, List list2) {
        if (list1.isEmpty() && list2.isEmpty()) {
            System.out.println("Списки пустые");
            return;
        }

        if (list1.isEmpty()) {
            System.out.print("Список 1 пуст, уникальные значения в Списке 2: ");
            list2.print();
            return;
        }

        if (list2.isEmpty()) {
            System.out.print("Список 2 пуст, уникальные значения в Списке 1: ");
            list1.print();
            return;
        }

        System.out.print("Уникальные значения в Списке 1: ");

        if (compareList(list1, list2).isEmpty()) {
            System.out.println("нет");
        } else {
            compareList(list1, list2).print();
        }

        System.out.print("Уникальные значения в Списке 2: ");

        if (compareList(list2, list1).isEmpty()) {
            System.out.println("нет");
        } else {
            compareList(list2, list1).print();
        }
    }

    private static List compareList(List list1, List list2) {
        List unique = new List();

        if (list1.isEmpty() && list2.isEmpty()) {
            return unique;
        }

        ListItem current = list1.headItem;

        while (current != null) {
            if (list2.find(current.data) == -1) {
                unique.addToEnd(current.data);
            }

            current = current.nextItem;
        }

        return unique;
    }

    public void deleteHead() throws OutOfRangePositionException {
        if (isEmpty()) {
            throw new OutOfRangePositionException();
        }

        if (headItem.nextItem != null) {
            headItem = headItem.nextItem;
        } else headItem = null;
    }

    public void deleteLast() throws OutOfRangePositionException {
        if (isEmpty()) {
            throw new OutOfRangePositionException();
        }

        if (headItem.nextItem == null) {
            headItem = null;
        } else {
            ListItem current = headItem;

            while (current.nextItem.nextItem != null) {
                current = current.nextItem;
            }

            current.nextItem = null;
        }
    }

    public void deletePosition(int position) throws OutOfRangePositionException, NegativePositionException {
        if (position == 0) {
            deleteHead();
        } else {
            ListItem current = getInternal(position - 1);

            if (current.nextItem == null) {
                throw new OutOfRangePositionException();
            } else {
                current.nextItem = current.nextItem.nextItem;
            }
        }
    }

    public int find(int value) {
        if (isEmpty()) {
            return -1;
        }

        ListItem current = headItem;
        int position = 0;

        while (current != null) {
            if (current.data == value) {
                return position;
            }

            current = current.nextItem;
            position++;
        }

        return -1;
    }

    public int get(int position) throws OutOfRangePositionException, NegativePositionException {
        return getInternal(position).data;
    }

    private ListItem getInternal(int position) throws NegativePositionException, OutOfRangePositionException {
        if (isEmpty()) {
            throw new OutOfRangePositionException();
        }

        if (position < 0) {
            throw new NegativePositionException();
        }

        ListItem current = headItem;

        for (int i = 1; i <= position; i++) {
            if (current.nextItem == null) {
                throw new OutOfRangePositionException();
            }

            current = current.nextItem;
        }

        return current;
    }

    public boolean isEmpty() {
        return headItem == null;
    }

    public void print() {
        ListItem current = headItem;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.nextItem;
        }

        System.out.println();
    }

    class ListItem {
        Integer data;
        ListItem nextItem;

        public ListItem(Integer data, ListItem nextItem) {
            this.data = data;
            this.nextItem = nextItem;
        }
    }
}
