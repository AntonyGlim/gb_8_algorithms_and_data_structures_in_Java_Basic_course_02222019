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
    }
}
