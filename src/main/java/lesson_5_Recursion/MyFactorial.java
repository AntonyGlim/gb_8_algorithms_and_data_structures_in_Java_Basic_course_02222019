package lesson_5_Recursion;

/**
 * Дано натуральное число n, найти n! = (1 * 2 * ... * [n - 1]) * n = (n - 1)! * n
 * f(n) = f(n - 1) * n;
 */
public class MyFactorial {

    /**
     * Вычисление факториала (циклическим способом)
     * @param n - натуральное число
     * @return - факториал n
     */
    public long fact(int n){
        long mult = 1;
        while (n > 0) mult *= n--;
        return mult;
    }

    /**
     * Вычисление факториала(рекурсивным способом)
     * Недостатки: при большом объеме данных стэк переполнится
     * @param n - натуральное число
     * @return - факториал n
     */
    public long factRec(int n){
        if (n < 2) return 1;
        else return factRec(n - 1) * n;
    }

}
