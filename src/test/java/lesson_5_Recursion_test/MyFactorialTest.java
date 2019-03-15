package lesson_5_Recursion_test;

import lesson_4_Linked_list.MyLinkedList;
import lesson_5_Recursion.MyFactorial;
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
public class MyFactorialTest {

    static int count = 0;
    static long timeStart = 0L;
    static long timeStop = 0L;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
                {10, 3628800},
                {20, 2432902008176640000L},
                {-1, 1}
        });
    }

    private int n;
    private long result;

    public MyFactorialTest(int n, long result) {
        this.n = n;
        this.result = result;
    }

    MyFactorial myFactorial;

    @Before
    public void init() {
        myFactorial = new MyFactorial();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test(){
        timeStart = System.currentTimeMillis();
        long factC = myFactorial.fact(n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == factC);
        System.out.println(String.format("Факториал (Цикл) числа %d = %d;", n, factC));
        System.out.println(String.format("Факториал (Цикл) время выполнения : %dмс;", (timeStop - timeStart)));

        timeStart = System.currentTimeMillis();
        long factR = myFactorial.factRec(n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == factR);
        System.out.println(String.format("Факториал (Рекурсия) числа %d = %d;", n, factR));
        System.out.println(String.format("Факториал (Рекурсия) время выполнения : %dмс;", (timeStop - timeStart)));
    }

    @After
    public void result(){
        System.out.println("Test #" + count + " finished" + "\n");
    }
}

