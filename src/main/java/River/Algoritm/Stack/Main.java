package River.Algoritm.Stack;

import River.Algoritm.Stack.Exceptions.EmptyStackException;
import River.Algoritm.Stack.Exceptions.StackOverflowExeption;

public class Main {
    public static void main(String[] args) throws StackOverflowExeption, EmptyStackException {
        Stack sArray = new StackArray(20);
        sArray.push(7);
        sArray.push(6);
        sArray.push(1);
        sArray.push(5);
        sArray.push(4);
        sArray.push(1);
        sArray.push(3);
        sArray.push(2);
        sArray.push(1);

        System.out.println(sArray.toString());

        deleteEqualsFirst(sArray);

        System.out.println(sArray.toString());

    }

    static void deleteEqualsFirst(Stack stack) throws EmptyStackException, StackOverflowExeption {
        Stack temp = new StackList();
        int first;
        int current;
        if (!stack.isEmpty()) {
            first = stack.pop();
            while (!stack.isEmpty()) {
                current = stack.pop();
                if (current != first) {
                    temp.push(current);
                }
            }
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }
}
