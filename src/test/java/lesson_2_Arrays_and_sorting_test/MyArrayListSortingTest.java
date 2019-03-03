package lesson_2_Arrays_and_sorting_test;

import lesson_2_Arrays_and_sorting.CharComparator;
import lesson_2_Arrays_and_sorting.IntegerComparator;
import lesson_2_Arrays_and_sorting.MyArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@RunWith(Parameterized.class)
public class MyArrayListSortingTest {

    private final int MAX = 10000000;
    private final int MIN = 0;
    private final int SIZE = 10000;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Cортировка выбором"},
                {"Cортировка выбором"},
                {"Cортировка выбором"},
                {"Cортировка выбором"},
                {"Cортировка выбором"},
                {"Cортировка вставками"},
                {"Cортировка вставками"},
                {"Cортировка вставками"},
                {"Cортировка вставками"},
                {"Cортировка вставками"}
        });
    }

    String sortingMethodName;

    public MyArrayListSortingTest(String sortingMethodName) {
        this.sortingMethodName = sortingMethodName;
    }

    MyArrayList<Integer> list;
    long time;
    String name;

    @Before
    public void init() {
        list = new MyArrayList();
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            list.add((int)(random.nextFloat() * (MAX - MIN) + MIN));
        }
    }

    @Test
    public void test() {
        long timeStart = new Date().getTime();
        if (sortingMethodName.equals("Cортировка выбором")){
            list.selectionSort(new IntegerComparator());
            name = "Cортировка выбором";
        } else {
            list.insortionSort(new IntegerComparator());
            name = "Cортировка вставками";
        }
        long timeEnd = new Date().getTime();
        time = timeEnd - timeStart;
    }

    @After
    public void result(){
        System.out.printf("%24s", name + " : ");
        System.out.printf("%20s", "list[0] = " + list.get(0) + ", ");
        System.out.printf("%21s", "list[1] = " + list.get(1) + ", ");
        System.out.printf("%25s", "list[2] = " + list.get(2) + ", ... ");
        System.out.printf("%30s", "list[list.size - 3] = " + list.get(list.size() - 3) + ", ");
        System.out.printf("%30s", "list[list.size - 2] = " + list.get(list.size() - 2) + ", ");
        System.out.printf("%30s", "list[list.size - 1] = " + list.get(list.size() - 1) + "; ");
        System.out.printf("%30s", "Затраченое время: " + time + ",мс" + "\n");
    }
}
