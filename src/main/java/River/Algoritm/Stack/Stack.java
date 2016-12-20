package River.Algoritm.Stack;

import River.Algoritm.List.Exceptions.NegativePositionException;
import River.Algoritm.List.Exceptions.OutOfRangePositionException;
import River.Algoritm.Stack.Exceptions.EmptyStackException;
import River.Algoritm.Stack.Exceptions.StackOverflowExeption;

public interface Stack {
    void push(int value) throws StackOverflowExeption;

    int pop() throws EmptyStackException, NegativePositionException, OutOfRangePositionException;

    boolean isEmpty();
}
