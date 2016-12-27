package River.Algoritm.Stack;

import River.Algoritm.Stack.Exceptions.EmptyStackException;
import River.Algoritm.Stack.Exceptions.StackOverflowExeption;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws StackOverflowExeption, EmptyStackException {
        Stack sArray = new StackArray(20);
        Random random1 = new Random(13);

        for (int i = 0; i <= 10; i++) {
            sArray.push(random1.nextInt(5));
        }

        Stack sList = new StackList();
        Random random2 = new Random(33);

        for (int i = 0; i <= 10; i++) {
            sList.push(random2.nextInt(5));
        }

        System.out.println("Статический стек: " + sArray.toString());
        deleteEqualsFirst(sArray, new StackArray(20));
        System.out.println("Статический стек после удалений элементов равных первому: " + sArray.toString());

        System.out.println("\nДинамический стек: " + sList.toString());
        deleteEqualsFirst(sList, new StackArray(20));
        System.out.println("Динамический стек после удалений элементов равных первому: " + sList.toString());
    }

    private static void deleteEqualsFirst(Stack stack, Stack buffer) throws EmptyStackException, StackOverflowExeption {
        int first;
        int current;

        if (!stack.isEmpty()) {
            first = stack.pop();

            while (!stack.isEmpty()) {
                current = stack.pop();

                if (current != first) {
                    buffer.push(current);
                }
            }

            while (!buffer.isEmpty()) {
                stack.push(buffer.pop());
            }
        }
    }
}
