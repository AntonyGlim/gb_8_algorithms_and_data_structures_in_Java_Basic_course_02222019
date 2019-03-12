package Lesson_5_Recursion;

public class SumSymbolsOfNumber {

    //Найти сумму цифр числа
    //f(n) - умма чисел
    //f(n) = f(n/10) + n % 10;
    //f(5845) = (5 + 8 + 4) + 5 = f(584) + 5
    public static void main(String[] args) {
        System.out.println(symbolsSum(5845));
        System.out.println(symbolsSumRec(5845));
    }

    public static int symbolsSum(int n){
        int sum = 0;
        while (n > 0){
            int dig = n % 10;
            sum += dig;
            n /= 10;
        }
        return sum;
    }

    public static int symbolsSumRec(int n){
        if (n < 10) return n;
        else return symbolsSumRec(n / 10) + n % 10;

    }
}
