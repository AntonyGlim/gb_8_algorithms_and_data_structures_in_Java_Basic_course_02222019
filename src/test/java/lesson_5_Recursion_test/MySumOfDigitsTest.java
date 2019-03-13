package lesson_5_Recursion_test;

import lesson_5_Recursion.MySumOfDigits;
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
 * Тестирование класса MySumOfDigits
 * Проверка корректности вычисляемых значений.
 * Сравнение циклического и рекурсивного способа вычисления.
 * Способы сравниваются по количеству затраченого времени
 */
@RunWith(Parameterized.class)
public class MySumOfDigitsTest {

    static int count = -1;
    static long timeStart = 0L;
    static long timeStop = 0L;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {2, 2},
                {10, 1},
                {5795, 26},
                {584579, 38},
                {584565461, 44},
                {584599999, 67}
        });
    }

    private int n;
    private long result;

    public MySumOfDigitsTest(int n, long result) {
        this.n = n;
        this.result = result;
    }

    MySumOfDigits sumOfDigits;

    @Before
    public void init() {
        sumOfDigits = new MySumOfDigits();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test(){
        timeStart = System.currentTimeMillis();
        int sumC = sumOfDigits.symbolsSum(n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == sumC);
        System.out.println(String.format("Результат (Цикл) для числа %d : %d;",n, sumC));
        System.out.println(String.format("Результат (Цикл) время выполнения : %dмс;", (timeStop - timeStart)));

        timeStart = System.currentTimeMillis();
        int sumR = sumOfDigits.symbolsSumRec(n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == sumR);
        System.out.println(String.format("Результат (Рекурсия) для числа %d : %d;",n, sumR));
        System.out.println(String.format("Результат (Рекурсия) время выполнения : %dмс;", (timeStop - timeStart)));
    }

    @After
    public void result(){
        System.out.println("Test #" + count + " finished" + "\n");
    }
}
