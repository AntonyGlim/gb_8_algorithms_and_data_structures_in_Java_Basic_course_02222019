package lesson_5_Recursion_test;

import lesson_5_Recursion.MyFactorial;
import lesson_5_Recursion.MyMultiplicationWithoutMultiplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Тестирование класса MyFactorial
 * Проверка корректности вычисляемых значений.
 * Сравнение циклического и рекурсивного способа вычисления.
 * Способы сравниваются по количеству затраченого времени и
 * по затраченым ресурсам.
 */
@RunWith(Parameterized.class)
public class MyMultiplicationWithoutMultiplicationTest {

    static int count = 0;
    static long timeStart = 0L;
    static long timeStop = 0L;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {1, 1, 1},
                {5, 5, 25},
                {10, 10, 100},
                {2, 1000000, 2000000},
                {-1, 0, 0}
        });
    }

    private int a;
    private int b;
    private long result;

    public MyMultiplicationWithoutMultiplicationTest(int a, int b, long result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    MyMultiplicationWithoutMultiplication multiplication;

    @Before
    public void init() {
        multiplication = new MyMultiplicationWithoutMultiplication();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test(){
        timeStart = System.currentTimeMillis();
        int multC = multiplication.mult(a, b);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == multC);
        System.out.println(String.format("Произведение (Цикл) числа %d на %d = %d;", a, b, multC));
        System.out.println(String.format("Произведение (Цикл) время выполнения : %dмс;", (timeStop - timeStart)));

        timeStart = System.currentTimeMillis();
        long multR = multiplication.multRec(a, b);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == multR);
        System.out.println(String.format("Произведение (Рекурсия) числа %d на %d = %d;", a, b, multR));
        System.out.println(String.format("Произведение (Рекурсия) время выполнения : %dмс;", (timeStop - timeStart)));
    }

    @After
    public void result(){
        System.out.println("Test #" + count + " finished" + "\n");
    }
}

