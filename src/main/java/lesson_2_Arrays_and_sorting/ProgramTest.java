package lesson_2_Arrays_and_sorting;

import java.util.Iterator;
import java.util.Random;

/**
 * Данный класс является дубликатом тестирования,
 * которое расположено в папке test
 */
public class ProgramTest {


    public static void main(String[] args) {
        MyArrayList<Character> list = new MyArrayList<Character>();

        //adding
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        System.out.println(list);
        System.out.println("size: " + list.size());

        //index information
        System.out.println(list.indexOf('a'));
        System.out.println(list.indexOf('b'));
        System.out.println(list.indexOf('c'));
        System.out.println(list.indexOf('d'));
        System.out.println(list.indexOf('f'));

        //elements information
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        try {
            System.out.println(list.get(4));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
        }

        //setting
        list.set(0, 'z');
        list.set(1, 'y');
        list.set(2, 'x');
        list.set(3, 'w');
        try {
            list.set(5, 'k');
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
        }

        System.out.println(list);
        System.out.println("size: " + list.size());

        //removing
        list.remove('a');
        list.remove('a');
        list.remove('b');
        list.remove('c');
        list.remove('d');
        list.remove('d');
        System.out.println(list);
        System.out.println("size: " + list.size());

        //iterator testing
        Iterator<Character> iterator = list.iterator();
        while (iterator.hasNext()){
            Character c = iterator.next();
            System.out.println(c + ", ");
        }

        //sorting
        list.add('g');
        list.add('b');
        list.add('f');
        list.add('r');
        list.add('a');
        list.add('p');
        list.add('o');
        list.add('c');
        list.add('i');

        MyArrayList<Character> list2 = new MyArrayList<Character>();
        for (Character ch : list) {
            list2.add(ch);
        }

        System.out.println("list1: " + list);
        System.out.println("list2: " + list2);
        System.out.println("size list1: " + list.size());
        System.out.println("size list2: " + list2.size());

        list.selectionSort(new CharComparator());
        list2.insortionSort(new CharComparator());
        System.out.println("list1: " + list);
        System.out.println("list2: " + list2);
        System.out.println("size list1: " + list.size());
        System.out.println("size list2: " + list2.size());


    }
}
