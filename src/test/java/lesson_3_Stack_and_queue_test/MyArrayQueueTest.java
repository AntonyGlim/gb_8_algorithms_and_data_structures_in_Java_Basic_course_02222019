package lesson_3_Stack_and_queue_test;

import lesson_3_Stack_and_queue.MyArrayQueue;
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
public class MyArrayQueueTest {

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
    private int queueSize;
    private char[] symbolsAfter;

    public MyArrayQueueTest(char[] symbolsBefore, int queueSize, char[] symbolsAfter) {
        this.symbolsBefore = symbolsBefore;
        this.queueSize = queueSize;
        this.symbolsAfter = symbolsAfter;
    }

    MyArrayQueue<Character> queue;

    @Before
    public void init(){
        queue = new MyArrayQueue<Character>();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test1(){

        //enqueueing elements
        for (int i = 0; i < symbolsBefore.length; i++) {
            queue.enqueue(symbolsBefore[i]);
            System.out.println("enqueue() : " + (char) symbolsBefore[i]);
        }
        System.out.println("Before start testing: " + queue + "(size = " + queue.size() + ")");

        //dequeueing elements
        try{
            System.out.println("dequeue() : " + (char) queue.dequeue());
            System.out.println("dequeue() : " + (char) queue.dequeue());
            System.out.println("dequeue() : " + (char) queue.dequeue());
        }catch (NoSuchElementException e){
            System.out.println("Не удалось удалить элементы из очереди. Размер очереди: " + queue.size());
        }

        try{
            System.out.println("Symbol on top of queue: " +  queue.peak());
            System.out.println("Symbol must be: " +  symbolsBefore[3]);
            Assert.assertTrue(queue.peak().equals(symbolsBefore[3]));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Не удалось получить элементы из очереди. Размер очереди: " + queue.size());
        } catch (NoSuchElementException e){
            System.out.println("Не удалось удалить элементы из очереди. Размер очереди: " + queue.size());
        }

    }

    @After
    public void result(){
        System.out.println("After start testing: " + queue + "(size = " + queue.size() + ")" + "\n");
    }
}
