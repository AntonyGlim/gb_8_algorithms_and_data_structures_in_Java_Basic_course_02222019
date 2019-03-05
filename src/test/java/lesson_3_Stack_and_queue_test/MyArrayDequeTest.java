package lesson_3_Stack_and_queue_test;

import lesson_3_Stack_and_queue.MyArrayDeque;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyArrayDequeTest {

    static int count = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{'a', 'b', 'c', 'd', 'e', 'z'}, 6, new char[]{'d', 'e', 'z'} },
                {new char[]{'z', 'x', 'c', 'y', 'e'}, 5, new char[]{'y', 'e'} },
                {new char[]{'a', 'b', 'c', 'd', 'r', 'f', 'e'}, 7, new char[]{'d', 'r', 'f', 'e'} },
                {new char[]{'a', 'b', 'c', 'd'}, 4, new char[]{'d'} },
                {new char[]{}, 0, new char[]{}},
        });
    }

    private char[] symbolsBefore;
    private int DequeSize;
    private char[] symbolsAfter;

    public MyArrayDequeTest(char[] symbolsBefore, int dequeSize, char[] symbolsAfter) {
        this.symbolsBefore = symbolsBefore;
        DequeSize = dequeSize;
        this.symbolsAfter = symbolsAfter;
    }

    MyArrayDeque<Character> deque;

    @Before
    public void init(){
        deque = new MyArrayDeque<Character>();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test1(){

        //
        for (int i = 0; i < symbolsBefore.length; i++) {
            deque.pushBack(symbolsBefore[i]);
            System.out.println("pushBack() : " + (char) symbolsBefore[i]);
        }
        System.out.println("Before start testing: " + deque + "(size = " + deque.size() + ")");
    }

    @After
    public void result(){
        System.out.println("After start testing: " + deque + "(size = " + deque.size() + ")" + "\n");
    }


}
