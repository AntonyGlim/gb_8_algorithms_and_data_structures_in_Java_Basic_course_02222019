package lesson_6_Trees;

public class Programm {
    public static void main(String[] args) {
        MyBinaryTree<Character, Integer> tree = new MyBinaryTree<Character, Integer>();
        tree.put('S', 0);
        tree.put('E', 0);
        tree.put('A', 0);
        tree.put('R', 0);
        tree.put('C', 0);
        tree.put('H', 0);
        tree.put('X', 0);
        tree.put('M', 0);
        tree.remove('E');
        for (int i = 0; i < 500; i++) {
            System.out.println(rnd(-100, 100));
        }

    }

    /**
     * Функция вернет случайное число из указанного диапазона
     * @param min - включительно. min должно быть отрицательным числом
     * @param max - включительно
     * @return - псевдослучайное целое число
     */
    public static int rnd(int min, int max){
        int diapason = max + Math.abs(min) + 1;
        return  (int) (Math.random() * diapason) - max;
    }
}
