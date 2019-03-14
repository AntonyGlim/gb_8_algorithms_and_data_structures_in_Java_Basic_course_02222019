package lesson_5_Recursion;

import lesson_3_Stack_and_queue.MyArrayStack;

/**
 *  Даны три стержня, на один из которых нанизаны колец,
 *  причём кольца отличаются размером и лежат меньшее на большем.
 *  Задача состоит в том, чтобы перенести пирамиду из колец
 *  за наименьшее число ходов на другой стержень.
 *  За один раз разрешается переносить только одно кольцо,
 *  причём нельзя класть большее кольцо на меньшее.
 */
public class MyHanoiTower {

    MyArrayStack<Integer> kernel1; //начальный стержень
    MyArrayStack<Integer> kernel2; //конечный стержень
    MyArrayStack<Integer> kernelTemp; //промежуточный
    int n; //количество колец


    public MyHanoiTower(int n) {

        this.n = n;

        //инициализируем 3 стержня
        kernel1 = new MyArrayStack();
        kernel2 = new MyArrayStack();
        kernelTemp = new MyArrayStack();

        //нанизываем кольца на стержень
        for (int i = n; i > 0; i--) kernel1.push(i);

        //выводим состояние игры до начала перестановок
        printCondition();

        //стартуем игру
        moveTower(n, kernel1, kernel2, kernelTemp);
    }

    /**
     * Метод выводи на экран текущее состояние стержней
     * на которые нанизаны кольца.
     * Грубо говоря - это кадр анимации
     */
    public void printCondition(){
        System.out.println();
        System.out.println("Старт : " + kernel1);
        System.out.println("Финиш : " + kernel2);
        System.out.println("Темп  : " + kernelTemp);
        System.out.println();
    }

    /**
     * Метод перемещает кольцо с одного стержня на другой
     * @param kernel1 - стержень 1
     * @param kernel2 - стержень 2
     */
    public void move(MyArrayStack<Integer> kernel1, MyArrayStack<Integer> kernel2){
        kernel2.push(kernel1.pop()); //извлекаем из одного стэка и кладем в другой
        printCondition(); //выводим текущее состояние "поля"
    }

    /**
     * Метод использует рекурсию.
     * Чтобы переложить n колец с Старт на Финиш нужно:
     * 1. Переложить (n - 1) колец на Темп;
     * 2. Переложить последнее кольцо с Старт на Финиш;
     * 3. ереложить (n - 1) колец на Финиш;
     * Условие выхода из рекурсии - когда мы дошли до последнего кольца
     */
    public void moveTower(
            int n,
            MyArrayStack<Integer> kernel1,
            MyArrayStack<Integer> kernel2,
            MyArrayStack<Integer> kernelTemp
    ){
        if(n == 0) return;
        moveTower(n - 1, kernel1, kernelTemp, kernel2);
        move(kernel1, kernel2);
        moveTower(n - 1, kernelTemp, kernel2, kernel1);
    }

    /**
     * Тестируем в main
     */
    public static void main(String[] args) {
        MyHanoiTower tower = new MyHanoiTower(16);
    }

}
