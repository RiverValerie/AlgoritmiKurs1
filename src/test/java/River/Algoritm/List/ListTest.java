package River.Algoritm.List;

import River.Algoritm.List.Exceptions.NegativePositionException;
import River.Algoritm.List.Exceptions.OutOfRangePositionException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ListTest {
    List testList = new List();
    List emptyList = new List();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 10; i++) {
            testList.addToEnd(i);
        }

    }

    @Test
    public void testAddToHeadEmptyList() throws Exception {

        emptyList.addToHead(9);

        assertEquals(9, emptyList.get(0));
    }

    @Test
    public void testAddToHeadNotEmptyList() throws Exception {
        testList.addToHead(13);

        assertEquals(13, testList.get(0));
        assertEquals(0, testList.get(1));

    }

    @Test
    public void testAddToEndEmptyList() throws Exception {
        emptyList.addToEnd(15);

        assertEquals(15, emptyList.get(0));
    }

    @Test
    public void testAddToEndNotEmptyList() throws Exception {
        testList.addToEnd(33);

        assertEquals(33, testList.get(10));
        assertEquals(9, testList.get(9));
    }

    @Test
    public void testAddToPosition0EmptyList() throws Exception {
        emptyList.addToPosition(55, 0);

        assertEquals(55, emptyList.get(0));
    }

    @Test
    public void testAddToPosition0NotEmptyList() throws Exception {
        testList.addToPosition(77, 0);

        assertEquals(77, testList.get(0));
        assertEquals(0, testList.get(1));
    }

    @Test
    public void testAddToNegativePosition() throws Exception {
        expectedException.expect(NegativePositionException.class);
        testList.addToPosition(35, -2);

    }

    @Test
    public void testAddToCorrectPosition() throws Exception {
        testList.addToPosition(99, 9);

        assertEquals(8, testList.get(8));
        assertEquals(99, testList.get(9));
        assertEquals(9, testList.get(10));
    }

    @Test
    public void testAddToPositionLastPlus1() throws Exception {
        testList.addToPosition(59, 10);
        assertEquals(9, testList.get(9));
        assertEquals(59, testList.get(10));
    }

    @Test
    public void testAddToOutOfRangePosition() throws Exception {
        expectedException.expect(OutOfRangePositionException.class);

        emptyList.addToPosition(31, 1);

    }

}
