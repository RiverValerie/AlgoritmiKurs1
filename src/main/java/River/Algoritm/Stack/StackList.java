package River.Algoritm.Stack;

import River.Algoritm.List.Exceptions.NegativePositionException;
import River.Algoritm.List.Exceptions.OutOfRangePositionException;
import River.Algoritm.List.List;
import River.Algoritm.Stack.Exceptions.EmptyStackException;


class StackList implements Stack {

    private List stackList = new List();

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        try {
            int headValue = stackList.get(0);
            stackList.deleteHead();
            return headValue;
        } catch (OutOfRangePositionException | NegativePositionException e) {
            throw new RuntimeException(e);
        }
    }

    public void push(int value) {
        stackList.addToHead(value);
    }

    @Override
    public String toString() {
        return stackList.toString();
    }
}
