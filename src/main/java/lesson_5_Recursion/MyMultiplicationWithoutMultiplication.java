package lesson_5_Recursion;

/**
 * Даны a и b найи их произведение без умножения. a и b > 0
 * a * b = a + a + a + ... + a (b раз)
 * f(a,b) = f(a, b - 1) + a
 */
public class MyMultiplicationWithoutMultiplication {

    /**
     * Метод найдет произведение 2 чисел в цикле
     * @param a
     * @param b
     * @return
     */
    public int mult(int a, int b){
        int sum = 0;
        int min = min(a, b);
        int max = max(a, b);
        while (min > 0){
            sum += max;
            min--;
        }
        return sum;
    }

    /**
     * Является вспомогательным методом.
     * Обеспечивает оптимизацию выполнения по меньшему аргументу.
     * Вызывает приватный метод multRect,
     * в котором и организована рекурсия.
     */
    public int multRec(int a, int b){
        if (a < 0 || b < 0) throw new ArithmeticException();
        int min = min(a, b);
        int max = max(a, b);
        return multRect(max, min);
    }

    /**
     * Метод найдет произведение 2 чисел используя рекурсию
     */
    private int multRect(int a, int b){
        if (b == 0) return 0;
        if (b == 1) return a;
        else return multRect(a, b - 1) + a;
    }

    /**
     * Вынесем методы нахождения максимального и минимального чисел отдельно.
     * Определить какое число больше необходимо для того,
     * чтобы избежать худшего из возможных случаев, например:
     * 1 и 10000000. Мы можем выполнить алгоритм за 10000000 раз а можем за 1
     */
    private int min(int a, int b){
        return a < b ? a : b;
    }

    private int max(int a, int b){
        return a > b ? a : b;
    }

}
