package River.Algoritm.Stack;

import River.Algoritm.Stack.Exceptions.EmptyStackException;
import River.Algoritm.Stack.Exceptions.StackOverflowExeption;

public class StackArray implements Stack {
    int[] stackArray;
    int headIndex = -1;

    public StackArray() {
        stackArray = new int[20];
    }

    public StackArray(int size) {
        stackArray = new int[size];
    }

    public void push(int value) throws StackOverflowExeption {
        if (headIndex == stackArray.length-1){
            throw new StackOverflowExeption();
        }
        headIndex = headIndex + 1;
        stackArray[headIndex] = value;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        headIndex = headIndex - 1;
        return stackArray[headIndex + 1];
    }

    public boolean isEmpty() {
        return headIndex == -1;
    }
}
