package lesson_5_Recursion;

public class NumbersTriangles {

    //Дано натуральное число n. Найти -е треугольное число
    //t(n) = {1 + 2 ... +
    public static void main(String[] args) {

    }

    public static int triangl(int n){
        int sum = 0;
        while ((n>0)){
            sum += n;
            n--;
        }
        return sum;
    }

    public static int trianglRec(int n){
        if (n == 2) return 1;
        else return trianglRec(n - 1) + n;
    }
}
