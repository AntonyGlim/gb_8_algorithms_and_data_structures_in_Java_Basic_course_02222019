package Lesson_5_Recursion;

public class Factorial {

    //Дано число n, найти n! = {1 * 2 * ... * (n - 1)} * n = {n - 1}! * n
    //f(n) = f(n - 1) * n;
    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(factRec(5));
    }

    /**
     * Вычисление факториала
     * (циклическим способом)
     * @param n
     * @return
     */
    public static long fact(int n){
        long mult = 1;
        while (n > 0) mult *= n--;
        return mult;
    }

    /**
     * Вычисление факториала
     * (рекурсивным способом)
     * При большом объеме данных стэк переполнится
     * @param n
     * @return
     */
    public static long factRec(int n){
        if (n < 2) return 1;
        else return factRec(n - 1) * n;
    }
}
