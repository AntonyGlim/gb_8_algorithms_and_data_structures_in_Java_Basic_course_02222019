package lesson_2_Arrays_and_sorting;

import java.util.Comparator;

/**
 * Класс будет описывать логику сравнения двух
 * Integer чисел
 */
public class IntegerComparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
