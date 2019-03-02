package lesson_2_Arrays_and_sorting;

import java.util.Comparator;

/**
 * Класс будет описывать логику сравнения двух
 * char символов
 */
public class CharComparator implements Comparator<Character> {

    public int compare(Character o1, Character o2) {
        return o1 - o2;
    }
}
