package lesson_4_Linked_list_test;

import lesson_2_Arrays_and_sorting.MyArrayList;
import lesson_4_Linked_list.MyLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyLinkedListTest {

    static int count = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{'a', 'b', 'c', 'd', 'e', 'z'}, new char[]{'1', '2', '3', '4'}},
                {new char[]{'z', 'x', 'c', 'y', 'e'}, new char[]{'3'}},
                {new char[]{'a', 'b', 'c', 'd', 'r', 'f', 'e'}, new char[]{'5', '6'}},
                {new char[]{'a', 'b', 'c', 'd'}, new char[]{'5', '6', '7', '8'}},
                {new char[]{}, new char[]{}},
        });
    }

    private char[] symbolsToBack;
    private char[] symbolsToFront;

    public MyLinkedListTest(char[] symbolsToBack, char[] symbolsToFront) {
        this.symbolsToBack = symbolsToBack;
        this.symbolsToFront = symbolsToFront;
    }

    MyLinkedList<Character> linkedList;

    @Before
    public void init() {
        linkedList = new MyLinkedList();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test(){

        //adding and getting elements front
        for (int i = 0; i < symbolsToFront.length; i++) {
            linkedList.addFirst(symbolsToFront[i]);
            System.out.println("addFirst: " + linkedList.getFirst());
        }

        //adding and getting elements back
        for (int i = 0; i < symbolsToBack.length; i++) {
            linkedList.addLast(symbolsToBack[i]);
            System.out.println("addLast: " + linkedList.getLast());
        }

        //removing

    }

    @After
    public void result(){
        System.out.println("After start testing: " + linkedList + "(size = " + linkedList.size() + ")" + "\n");
    }
}
