package lesson_5_Recursion_test;

import lesson_5_Recursion.MyExponentiation;
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
 * Тестирование класса MyExponentiation
 * Проверка корректности вычисляемых значений.
 * Сравнение циклического и рекурсивного способа вычисления.
 * Способы сравниваются по количеству затраченого времени
 */
@RunWith(Parameterized.class)
public class MyExponentiationTest {

    static int count = -1;
    static long timeStart = 0L;
    static long timeStop = 0L;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 0, 1},
                {2, 2, 4},
                {10, 2, 100},
                {5, 2, 25},
                {3, 4, 81},
                {12, 12, 8916100448256L},
                {14, 14, 11112006825558016L}
        });
    }

    private int a;
    private int n;
    private long result;

    public MyExponentiationTest(int a, int n, long result) {
        this.a = a;
        this.n = n;
        this.result = result;
    }

    MyExponentiation exponentiation;

    @Before
    public void init() {
        exponentiation = new MyExponentiation();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test(){
        timeStart = System.currentTimeMillis();
        long expC = exponentiation.expo(a, n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == expC);
        System.out.println(String.format("Результат (Цикл) для числа %d в степени %d : %d;",a, n, expC));
        System.out.println(String.format("Результат (Цикл) время выполнения : %dмс;", (timeStop - timeStart)));

        timeStart = System.currentTimeMillis();
        long expR = exponentiation.expoRec(a, n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == expR);
        System.out.println(String.format("Результат (Рекурсия) для числа %d в степени %d : %d;",a, n, expR));
        System.out.println(String.format("Результат (Рекурсия) время выполнения : %dмс;", (timeStop - timeStart)));
    }

    @After
    public void result(){
        System.out.println("Test #" + count + " finished" + "\n");
    }
}
