package lesson_2_Arrays_and_sorting_test;

import lesson_2_Arrays_and_sorting.MyArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyArrayListTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{'a', 'b', 'c', 'd', 'e', 'z'}, 6, 0, -1, 5, new char[]{'c', 'd', 'z'} },
                {new char[]{'z', 'x', 'c', 'y', 'e'}, 5, -1, -1, 0, new char[]{'z', 'x', 'c', 'y'} },
                {new char[]{'a', 'b', 'c', 'd', 'r', 'f', 'e'}, 7, 0, 4, -1, new char[]{'c', 'd', 'r', 'f'} },
                {new char[]{'a', 'b', 'c', 'd'}, 4, 0, -1, -1, new char[]{'c', 'd'}},
                {new char[]{}, 0, -1, -1, -1, new char[]{}},
        });
    }
    private char[] symbolsBefore;
    private int arrSize;
    private int elementIndex1;
    private int elementIndex2;
    private int elementIndex3;
    private char[] symbolsAfter;

    public MyArrayListTest(
            char[] symbolsBefore,
            int arrSize,
            int elementIndex1,
            int elementIndex2,
            int elementIndex3,
            char[] symbolsAfter) {

        this.symbolsBefore = symbolsBefore;
        this.arrSize = arrSize;
        this.elementIndex1 = elementIndex1;
        this.elementIndex2 = elementIndex2;
        this.elementIndex3 = elementIndex3;
        this.symbolsAfter = symbolsAfter;
    }

    MyArrayList<Character> list;

    @Before
    public void init() {
        list = new MyArrayList();
    }

    @Test
    public void testWithParam() {

        //putting elements into list
        for (Character ch : symbolsBefore) {
            list.add(ch);
        }

        //check is all elements are equals
        for (int i = 0; i < arrSize; i++) {
            Assert.assertTrue(list.get(i).equals(symbolsBefore[i]));
        }

        //check is sizes are equals
        Assert.assertEquals(arrSize, list.size());

        //check indexOf
        Assert.assertEquals(elementIndex1, list.indexOf('a'));
        Assert.assertEquals(elementIndex2, list.indexOf('r'));
        Assert.assertEquals(elementIndex3, list.indexOf('z'));

        //removing
        list.remove('a');
        list.remove('b');
        list.remove('e');
        for (int i = 0; i < list.size(); i++) {
            Assert.assertTrue(list.get(i).equals(symbolsAfter[i]));
        }
    }
}
