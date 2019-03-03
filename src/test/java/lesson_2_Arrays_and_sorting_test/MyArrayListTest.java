package lesson_2_Arrays_and_sorting_test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyArrayListTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, false},
                {new int[]{1, 1, 1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, false},
                {new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, false},
                {new int[]{1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, true},
                {new int[]{1, 4}, true},
                {new int[]{1}, false},
                {new int[]{4}, false},
        });
    }
    private int[] arrStart;
    private boolean expectedResult;
}
