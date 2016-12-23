package River.Algoritm.Stack;

import River.Algoritm.Stack.Exceptions.EmptyStackException;
import River.Algoritm.Stack.Exceptions.StackOverflowExeption;

public interface Stack {
    boolean isEmpty();

    int pop() throws EmptyStackException;

    void push(int value) throws StackOverflowExeption;
}
