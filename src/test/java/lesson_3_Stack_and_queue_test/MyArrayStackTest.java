package lesson_3_Stack_and_queue_test;

import lesson_3_Stack_and_queue.MyArrayStack;
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
public class MyArrayStackTest {

    static int count = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{'a', 'b', 'c', 'd', 'e', 'z'}, 6 },
                {new char[]{'z', 'x', 'c', 'y', 'e'}, 5 },
                {new char[]{'a', 'b', 'c', 'd', 'r', 'f', 'e'}, 7 },
                {new char[]{'a', 'b', 'c', 'd'}, 4 },
                {new char[]{}, 0},
        });
    }

    private char[] symbolsBefore;
    private int stackSize;

    public MyArrayStackTest(char[] symbolsBefore, int stackSize) {
        this.symbolsBefore = symbolsBefore;
        this.stackSize = stackSize;
    }

    MyArrayStack<Character> stack;

    @Before
    public void init(){
        stack = new MyArrayStack<Character>();
        System.out.println("Test #" + ++count);
    }

    @Test
    public void test1(){

        //pushing elements
        for (int i = 0; i < symbolsBefore.length; i++) {
            stack.push(symbolsBefore[i]);
            System.out.println("push() : " + (char) symbolsBefore[i]);
        }
        System.out.println("Before start testing: " + stack + "(size = " + stack.size() + ")");

        //testing size
        Assert.assertTrue(stack.size() == stackSize);

        //popping and peeking
        try {
            char ch1 = stack.peek();
            System.out.println("peek() : " + (char) ch1);
            char ch2 = stack.pop();
            System.out.println("pop() : " + (char) ch2);
            char ch3 = stack.pop();
            System.out.println("pop() : " + (char) ch3);
            Assert.assertTrue(ch1 == symbolsBefore[symbolsBefore.length - 1]);
            Assert.assertTrue(ch2 == symbolsBefore[symbolsBefore.length - 1]);
            Assert.assertTrue(ch3 == symbolsBefore[symbolsBefore.length - 2]);
        } catch (NoSuchElementException e){
            System.out.println("В стеке : " + stack.size() + " элементов");
        }
    }

    @After
    public void result(){
        System.out.println("After start testing: " + stack + "(size = " + stack.size() + ")" + "\n");
    }
}
