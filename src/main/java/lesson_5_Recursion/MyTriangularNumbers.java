package lesson_5_Recursion;

/**
 * Дано натуральное число n. Найти n-е треугольное число
 * f(n) = {1 + 2 ... + n);
 * f(n) = f(n - 1) + n;
 */
public class MyTriangularNumbers {

    /**
     *  Вычисляем при помощи циклов
     */
    public int triangular(int n){
        int sum = 0;
        while ((n > 0)){
            sum += n;
            n--;
        }
        return sum;
    }

    /**
     *  Вычисляем при помощи рекурсии
     */
    public int triangularRec(int n){
        if (n == 2) return 1;
        else return triangularRec(n - 1) + n;
    }

}
