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

    MyArrayStack<Integer> kernel1;
    MyArrayStack<Integer> kernel2;
    MyArrayStack<Integer> kernelTemp;
    int n;

    public MyHanoiTower(int n) {
        this.n = n;
        kernel1 = new MyArrayStack();
        kernel2 = new MyArrayStack();
        kernelTemp = new MyArrayStack();

        for (int i = n; i > 0; i--) {
            kernel1.push(i);
        }

        printCondition();

        moveTower(n, kernel1, kernel2, kernelTemp);
    }

    public void printCondition(){
        System.out.println("\n" + "Старт : " + kernel1);
        System.out.println("Финиш : " + kernel2);
        System.out.println("Темп  : " + kernelTemp + "\n");
    }

    public void move(MyArrayStack<Integer> kernel1, MyArrayStack<Integer> kernel2){
        kernel2.push(kernel1.pop());
        printCondition();
    }

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

    public static void main(String[] args) {
        MyHanoiTower tower = new MyHanoiTower(4);
    }

}
