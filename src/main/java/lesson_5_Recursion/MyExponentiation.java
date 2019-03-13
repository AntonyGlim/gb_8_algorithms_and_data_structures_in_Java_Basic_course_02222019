package lesson_5_Recursion;

/**
 * Дано натуральное число a, которое необходимо возвести в степень n.
 * f(a, n) = a * a * ... * a = (a^[n - 1]) * a;
 */
public class MyExponentiation {

    /**
     *  Вычисляем при помощи циклов
     */
    public long expo(int a, int n){
        long exp = 1;
        for (int i = 0; i < n; i++) {
            exp *= a;
        }
        return exp;
    }

    /**
     *  Вычисляем при помощи рекурсии
     */
    public long expoRec(int a, int n){
        if (n == 1) return a;
        if (n < 1) return 1;
        else return expoRec(a, n - 1) * a;
    }
}
