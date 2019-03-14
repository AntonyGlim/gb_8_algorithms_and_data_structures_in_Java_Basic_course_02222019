package lesson_5_Recursion;

/**
 *  Даны три стержня, на один из которых нанизаны колец,
 *  причём кольца отличаются размером и лежат меньшее на большем.
 *  Задача состоит в том, чтобы перенести пирамиду из колец
 *  за наименьшее число ходов на другой стержень.
 *  За один раз разрешается переносить только одно кольцо,
 *  причём нельзя класть большее кольцо на меньшее.
 */
public class MyHanoiTower {

    public void move(char kernel1, char kernel2){
        System.out.println(String.format("Из стрежня %s на стержень %s", kernel1, kernel2 ));
    }

    public void moveTower(int n, char kernel1, char kernel2, char kernelTemp){
        if(n == 0) return;
        moveTower(n - 1, kernel1, kernelTemp, kernel2);
        move(kernel1, kernel2);
        moveTower(n - 1, kernelTemp, kernel2, kernel1);
    }

    public static void main(String[] args) {
        MyHanoiTower tower = new MyHanoiTower();
        tower.moveTower(8, 'A', 'B', 'C');
    }

}
