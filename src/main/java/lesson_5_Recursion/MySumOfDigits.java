package lesson_5_Recursion;

/**
 * Найти сумму цифр числа
 * f(n) - сумма чисел
 * f(n) = f(n/10) + n % 10;
 * f(5845) = (5 + 8 + 4) + 5 = f(584) + 5
 */
public class MySumOfDigits {

    public static void main(String[] args) {
        System.out.println(symbolsSum(0));
        System.out.println(symbolsSum(1));
        System.out.println(symbolsSum(2));
        System.out.println(symbolsSum(10));
        System.out.println(symbolsSum(5795));
        System.out.println(symbolsSum(584579));
        System.out.println(symbolsSum(584565461));
        System.out.println(symbolsSum(584599999));
    }

    /**
     *  Вычисляем при помощи циклов
     */
    public static int symbolsSum(int n){
        int sum = 0;
        while (n > 0){
            int dig = n % 10;
            sum += dig;
            n /= 10;
        }
        return sum;
    }

    /**
     *  Вычисляем при помощи рекурсии
     */
    public static int symbolsSumRec(int n){
        if (n < 10) return n;
        else return symbolsSumRec(n / 10) + n % 10;
    }

}
