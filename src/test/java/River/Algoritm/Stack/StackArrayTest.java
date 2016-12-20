package River.Algoritm.Stack;


import River.Algoritm.Stack.Exceptions.StackOverflowExeption;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackArrayTest extends StackTest{
    @Before
    public void setUp() throws Exception {
        testStack = new StackArray();

    }

    @Test
    public void stackOverflow() throws Exception {
        expectedException.expect(StackOverflowExeption.class);
        for (int i=0; i<21; i++){
            testStack.push(i);
        }
    }

    @Test
    public void notStackOverflow() throws Exception {
        for (int i=0; i<20; i++){
            testStack.push(i);
        }
        assertEquals(19,testStack.pop());
    }
}
