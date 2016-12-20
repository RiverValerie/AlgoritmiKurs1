package River.Algoritm.Stack;


import River.Algoritm.Stack.Exceptions.EmptyStackException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class StackTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    Stack testStack;

    @Test
    public void pushAndPopFromNotEmptyStackList() throws Exception {
        testStack.push(3);
        testStack.push(5);
        testStack.push(7);
        assertEquals(7, testStack.pop());
        assertEquals(5, testStack.pop());
        assertEquals(3, testStack.pop());
    }

    @Test
    public void popFromEmptyList() throws Exception {
        expectedException.expect(EmptyStackException.class);
        testStack.pop();
    }

    @Test
    public void isEmptyEmptyStackList() throws Exception {
        assertTrue(testStack.isEmpty());
    }

    @Test
    public void isEmptyNotEmptyStackList() throws Exception {
        testStack.push(1);
        assertFalse(testStack.isEmpty());
    }
}
