package lesson_5_Recursion;

/**
 * Дано натуральное число a, которое необходимо возвести в степень n.
 * f(a, n) = a * a * ... * a = (a^[n - 1]) * a;
 */
public class MyExponentiation {

    /**
     *  Вычисляем при помощи циклов
     *  Медленное возведение
     */
    public long expo(int a, int n){
        long exp = 1;
        for (int i = 0; i < n; i++) {
            exp *= a;
        }
        return exp;
    }

    /**
     *  Вычисляем при помощи циклов
     *  Быстрое возведение (добавлена некорорая оптимизация)
     */
    public long qExpo(int a, int n){
        long exp = 1;
        while (n > 0){
            if (n % 2 == 1){
                exp *= a;
            }
            a *= a;
            n /= 2;
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

    /**
     *  Вычисляем при помощи рекурсии
     *  Быстрое возведение (добавлена некорорая оптимизация)
     */
    public long qExpoRec(int a, int n){
        if (n == 1) return a;
        if (n < 1) return 1;
        else return qExpoRec(a * a, n / 2) * a;
    }
}
