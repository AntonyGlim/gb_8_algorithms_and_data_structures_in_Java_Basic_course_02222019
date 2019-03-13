package lesson_5_Recursion_test;


import lesson_5_Recursion.MyTriangularNumbers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Тестирование класса MyTriangularNumbersTest
 * Проверка корректности вычисляемых значений.
 * Сравнение циклического и рекурсивного способа вычисления.
 * Способы сравниваются по количеству затраченого времени
 */
@RunWith(Parameterized.class)
public class MyTriangularNumbersTest {

    static int count = -1;
    static long timeStart = 0L;
    static long timeStop = 0L;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {10, 55},
                {50, 1275},
                {150, 11325},
                {780, 304590},
                {4589, 10531755},
                {245897, 168019181}
        });
    }

    private int n;
    private long result;

    public MyTriangularNumbersTest(int n, long result) {
        this.n = n;
        this.result = result;
    }

    MyTriangularNumbers triangularNumber;

    @Before
    public void init() {
        triangularNumber = new MyTriangularNumbers();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test(){
        timeStart = System.currentTimeMillis();
        int numberC = triangularNumber.triangular(n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == numberC);
        System.out.println(String.format("Результат (Цикл) для числа %d : %d;",n, numberC));
        System.out.println(String.format("Результат (Цикл) время выполнения : %dмс;", (timeStop - timeStart)));

        timeStart = System.currentTimeMillis();
        int numberR = triangularNumber.triangular(n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == numberR);
        System.out.println(String.format("Результат (Рекурсия) для числа %d : %d;",n, numberR));
        System.out.println(String.format("Результат (Рекурсия) время выполнения : %dмс;", (timeStop - timeStart)));
    }

    @After
    public void result(){
        System.out.println("Test #" + count + " finished" + "\n");
    }
}
