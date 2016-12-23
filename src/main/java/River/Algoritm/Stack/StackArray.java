package River.Algoritm.Stack;

import River.Algoritm.Stack.Exceptions.EmptyStackException;
import River.Algoritm.Stack.Exceptions.StackOverflowExeption;

public class StackArray implements Stack {
    private int[] stackArray;
    private int headIndex = -1;

    public StackArray() {
        stackArray = new int[20];
    }

    public StackArray(int size) {
        stackArray = new int[size];
    }

    public boolean isEmpty() {
        return headIndex == -1;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        headIndex = headIndex - 1;
        return stackArray[headIndex + 1];
    }

    public void push(int value) throws StackOverflowExeption {
        if (headIndex == stackArray.length - 1) {
            throw new StackOverflowExeption();
        }

        headIndex = headIndex + 1;
        stackArray[headIndex] = value;
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = headIndex; i >= 0; i--) {
            s = s + stackArray[i] + " ";
        }

        return s;
    }
}
