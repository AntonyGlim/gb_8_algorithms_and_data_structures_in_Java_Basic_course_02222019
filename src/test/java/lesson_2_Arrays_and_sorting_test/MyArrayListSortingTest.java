package lesson_2_Arrays_and_sorting_test;

import lesson_2_Arrays_and_sorting.CharComparator;
import lesson_2_Arrays_and_sorting.MyArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

@RunWith(Parameterized.class)
public class MyArrayListSortingTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Cортировка выбором", 10000, 0, 1000000000},
                {"Cортировка выбором", 10000, 0, 1000000000},
                {"Cортировка выбором", 10000, 0, 1000000000},
                {"Cортировка выбором", 10000, 0, 1000000000},
                {"Cортировка выбором", 10000, 0, 1000000000},
                {"Cортировка вставками", 10000, 0, 1000000000},
                {"Cортировка вставками", 10000, 0, 1000000000},
                {"Cортировка вставками", 10000, 0, 1000000000},
                {"Cортировка вставками", 10000, 0, 1000000000},
                {"Cортировка вставками", 10000, 0, 1000000000}
        });
    }

    String sortingMethodName;
    int arraySize;
    int minElementInArray;
    int maxElementInArray;

    public MyArrayListSortingTest(String sortingMethodName, int arraySize, int minElementInArray, int maxElementInArray) {
        this.sortingMethodName = sortingMethodName;
        this.arraySize = arraySize;
        this.minElementInArray = minElementInArray;
        this.maxElementInArray = maxElementInArray;
    }

    MyArrayList<Integer> list;

    @Before
    public void init() {
        list = new MyArrayList();
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            list.add((int)(random.nextFloat() * (maxElementInArray - minElementInArray) + minElementInArray));
        }
    }

    @Test
    public void test() {
        list.selectionSort(new CharComparator());
    }

    @After
    public void result(){
        System.out.print(sortingMethodName + " : ");
        System.out.print("list[0] = " + list.get(0) + ", ");
        System.out.print("list[1] = " + list.get(1) + ", ");
        System.out.print("list[2] = " + list.get(2) + ", ... ");
        System.out.print("list[list.size - 3] = " + list.get(list.size() - 3) + ", ");
        System.out.print("list[list.size - 2] = " + list.get(list.size() - 2) + ", ");
        System.out.print("list[list.size - 1] = " + list.get(list.size() - 1) + "; ");
        System.out.print("Затраченое время: " + ",мс" + "\n");
    }
}
