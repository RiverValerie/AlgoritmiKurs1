package River.Algoritm.Array;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Valllee on 28.12.2016.
 */
public class SortsTest {
    Integer[] array = {5, 4, 7, 3, 2, 5, 6, 1};

    @Test
    public void testSortShell() throws Exception {
        Sorts.sortShell(array, Comparator.<Integer>naturalOrder());
        Arrays.toString(array);
    }
}
