package River.Algoritm.Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SortsTest {
    Integer[] array = {5, 4, 7, 3, 2, 5, 6, 1};

    @Test
    public void testSortShell() throws Exception {
        Sorts.sortShell(array, Comparator.<Integer>naturalOrder());
        System.out.println(Arrays.toString(array));
    }
}
