package lesson_3_Stack_and_queue_test;

import lesson_3_Stack_and_queue.MyArrayDeque;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

@RunWith(Parameterized.class)
public class MyArrayDequeTest {

    static int count = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{'a', 'b', 'c', 'd', 'e', 'z'}, new char[]{'1', '2', '3', '4'}, 10, new char[]{'d', 'e', 'z'} },
                {new char[]{'z', 'x', 'c', 'y', 'e'}, new char[]{'3'}, 6, new char[]{'y', 'e'} },
                {new char[]{'a', 'b', 'c', 'd', 'r', 'f', 'e'}, new char[]{'5', '6'}, 9, new char[]{'d', 'r', 'f', 'e'} },
                {new char[]{'a', 'b', 'c', 'd'}, new char[]{'5', '6', '7', '8'}, 8, new char[]{'d'} },
                {new char[]{}, new char[]{}, 0, new char[]{}},
        });
    }

    private char[] symbolsToBack;
    private char[] symbolsToFront;
    private int dequeSize;
    private char[] symbolsAfter;

    public MyArrayDequeTest(char[] symbolsToBack, char[] symbolsToFront, int dequeSize, char[] symbolsAfter) {
        this.symbolsToBack = symbolsToBack;
        this.symbolsToFront = symbolsToFront;
        this.dequeSize = dequeSize;
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

        //pushing elements front
        for (int i = 0; i < symbolsToFront.length; i++) {
            deque.pushFront(symbolsToFront[i]);
            System.out.println("pushFront() : " + (char) symbolsToFront[i]);
        }
        System.out.println("After pushing elements front: " + deque + "(size = " + deque.size() + ")");

        //pushing elements back
        for (int i = 0; i < symbolsToBack.length; i++) {
            deque.pushBack(symbolsToBack[i]);
            System.out.println("pushBack() : " + (char) symbolsToBack[i]);
        }
        System.out.println("After pushing elements back: " + deque + "(size = " + deque.size() + ")");

        //popping elements from front
        try{
            System.out.println("popFront() : " + (char) deque.popFront());
            System.out.println("popFront() : " + (char) deque.popFront());
            System.out.println("popFront() : " + (char) deque.popFront());
        }catch (NoSuchElementException e){
            System.out.println("Can not get element from deque. Deque size: " + deque.size());
        }
        System.out.println("After popping elements front: " + deque + "(size = " + deque.size() + ")");

        //popping elements from back
        try{
            System.out.println("popBack() : " + (char) deque.popBack());
            System.out.println("popBack() : " + (char) deque.popBack());
            System.out.println("popBack() : " + (char) deque.popBack());
        }catch (NoSuchElementException e){
            System.out.println("Не удалось удалить элементы из очереди. Размер очереди: " + deque.size());
        }
        System.out.println("After popping elements back: " + deque + "(size = " + deque.size() + ")");

        //peaking elements from back
        try{
            System.out.println("Symbol from back of deque: " +  deque.peakBack());
            System.out.println("Symbol must be: " +  symbolsToBack[symbolsToBack.length - 4]);
            Assert.assertTrue(deque.peakBack().equals(symbolsToBack[symbolsToBack.length - 4]));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Can not get element from deque. Deque size: " + deque.size());
        } catch (NoSuchElementException e){
            System.out.println("Can not get element from deque. Deque size: " + deque.size());
        }
    }

    @After
    public void result(){
        System.out.println("After testing: " + deque + "(size = " + deque.size() + ")" + "\n");
    }


}
