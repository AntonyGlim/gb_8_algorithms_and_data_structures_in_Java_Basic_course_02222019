package Lesson_5_Recursion;

public class Fibonachi {

    //Дано натуральное n. Найти n-й член последовательности Фибоначчи.
    //Каждый последующий член равен сумме 2-х предыдущих
    //f(1) = 1; f(2) = 1; f(3) = 2;  3, 5, 8, 13, 34, 55 ...
    //f(n) / f(n - 1) = phi = 1.618 - число Бога (золотое сечение) очень приятен глазу
    //f(0) = 0 - создадим фиктивный член последовательности

    public static void main(String[] args) {

        double timeStart = System.currentTimeMillis();
        System.out.println(phibo(50));
        double timeStop = System.currentTimeMillis();
        System.out.println("Цикл: " + (timeStop - timeStart) + "мс");

        timeStart = System.currentTimeMillis();
        System.out.println(phiboRec(50));
        timeStop = System.currentTimeMillis();
        System.out.println("Рекурсия: " + (timeStop - timeStart) + "мс");
    }

    /**
     * Метод вычисляет число Фибоначчи
     * (используется цикл)
     * @param n
     * @return
     */
    public static long phibo(int n){
        long current = 1;
        int currentIndex = 1;
        long previous = 0;
        while (currentIndex < n) {
            long next = current + previous;
            previous = current;
            current = next;
            currentIndex++;
        }
        return current;
    }

    /**
     * Метод вычисляет число Фибоначчи
     * (используется рекурсия)
     * У данного метода есть существенный недостаток,
     * мы вычисляем одни и те же задачи множество раз, хотя
     * могли бы запоминать решения пользуясь мемоизацией (запоминание
     * промежуточных вычислений)
     * @param n
     * @return
     */
    public static long phiboRec(int n){
        if (n < 3) return 1;
        else return phiboRec(n - 1) + phiboRec(n - 2);
    }
}
