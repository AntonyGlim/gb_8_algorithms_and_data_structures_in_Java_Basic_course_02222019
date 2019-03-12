package Lesson_5_Recursion;

//Даны a b найи их произведение без умножения. a b > 0
//a * b = a + a + a + ... + a
//f(a,b) = f(a, b - 1) + a
public class MultiWithoutMulti {
    public static void main(String[] args) {
        System.out.println(mult(7, 8));
        System.out.println(multRect(7, 8));
    }

    /**
     * Если 1 и 10000000 то очень не эффективно
     * @param a
     * @param b
     * @return
     */
    public static int mult(int a, int b){
        int sum = 0;

        //оптимизация для плохого случая
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b > 0){
            sum += a;
            b--;
        }
        return sum;
    }

    /**
     * Несколько рекурсивных случаев
     * @param a
     * @param b
     * @return
     */
    public static int multRect(int a, int b){
        if (b == 0) return 0;
        else if (b == 1) return a;
        else return multRect(a, b - 1) + a;
    }

}
