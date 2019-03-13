package lesson_5_Recursion_test;

import lesson_5_Recursion.MyFactorial;
import lesson_5_Recursion.MyFibonacciNumbers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Тестирование класса MyFibonacciNumbers
 * Проверка корректности вычисляемых значений.
 * Сравнение циклического и рекурсивного способа вычисления.
 * Способы сравниваются по количеству затраченого времени и
 * по затраченым ресурсам.
 */
@RunWith(Parameterized.class)
public class MyFibonacciNumbersTest {

    static int count = 0;
    static long timeStart = 0L;
    static long timeStop = 0L;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-1, 1},
                {0, 1},
                {2, 1},
                {3, 2},
                {8, 21},
                {50, 12586269025L},
//                {65, 17167680177565L},
//                {85, 2596954969111225857L}
        });
    }

    private int n;
    private long result;

    public MyFibonacciNumbersTest(int n, long result) {
        this.n = n;
        this.result = result;
    }

    MyFibonacciNumbers myFibonacciNumber;

    @Before
    public void init() {
        myFibonacciNumber = new MyFibonacciNumbers();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test(){
        timeStart = System.currentTimeMillis();
        long fiboC = myFibonacciNumber.fibo(n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == fiboC);
        System.out.println(String.format("Число Фибоначчи (Цикл) для числа %d = %d;", n, fiboC));
        System.out.println(String.format("Число Фибоначчи (Цикл) время выполнения : %dмс;", (timeStop - timeStart)));
        System.out.println(String.format("Выполнено операций (Цикл) : %d;", myFibonacciNumber.operationsCountC));

        timeStart = System.currentTimeMillis();
        long fiboR = myFibonacciNumber.fiboRec(n);
        timeStop = System.currentTimeMillis();

        Assert.assertTrue(result == fiboR);
        System.out.println(String.format("Число Фибоначчи (Рекурсия) числа %d = %d;", n, fiboR));
        System.out.println(String.format("Число Фибоначчи (Рекурсия) время выполнения : %dмс;", (timeStop - timeStart)));
        System.out.println(String.format("Выполнено операций (Рекурсия) : %d;", myFibonacciNumber.operationsCountR));
    }

    @After
    public void result(){
        System.out.println("Test #" + count + " finished" + "\n");
    }
}

