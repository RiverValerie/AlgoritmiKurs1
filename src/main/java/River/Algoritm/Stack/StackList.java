package River.Algoritm.Stack;

import River.Algoritm.List.Exceptions.NegativePositionException;
import River.Algoritm.List.Exceptions.OutOfRangePositionException;
import River.Algoritm.List.List;
import River.Algoritm.Stack.Exceptions.EmptyStackException;


class StackList implements Stack {

    List stackList = new List();

    public void push(int value) {
        stackList.addToHead(value);
    }

    public int pop() throws EmptyStackException, NegativePositionException, OutOfRangePositionException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int headValue = stackList.get(0);
        stackList.deleteHead();
        return headValue;
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }
}
