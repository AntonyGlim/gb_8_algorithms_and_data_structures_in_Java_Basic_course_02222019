package lesson_4_Linked_list_test;

import lesson_2_Arrays_and_sorting.MyArrayList;
import lesson_4_Linked_list.MyLinkedList;
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
public class MyLinkedListTest {

    static int count = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{'a', 'b', 'c', 'd', 'e', 'z'}, new char[]{'1', '2', '3', '4'}, true, 'j'},
                {new char[]{'z', 'x', 'c', 'y', 'e'}, new char[]{'3'}, false, 'j'},
                {new char[]{'a', 'b', 'c', 't', 'r', 'f', 'e'}, new char[]{'5', '6'}, true, 'j'},
                {new char[]{'a', 'b', 'c', 's'}, new char[]{'5', '6', '7', '8'}, true, 'j'},
                {new char[]{}, new char[]{}, false, 'j'},
        });
    }

    private char[] symbolsToFront;
    private char[] symbolsToBack;
    private boolean containsInList;
    private char symbolToSet;

    public MyLinkedListTest(char[] symbolsToFront, char[] symbolsToBack, boolean containsInList, char symbolToSet) {
        this.symbolsToFront = symbolsToFront;
        this.symbolsToBack = symbolsToBack;
        this.containsInList = containsInList;
        this.symbolToSet = symbolToSet;
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
        System.out.println("After adding and getting: " + linkedList + "(sise: " + linkedList.size() + ")");

        //removing elements from back and front
        try{
            System.out.println("removeFirst: " + linkedList.removeFirst());
            System.out.println("removeFirst: " + linkedList.removeFirst());
            System.out.println("removeLast: " + linkedList.removeLast());
            System.out.println("removeLast: " + linkedList.removeLast());

        } catch (NoSuchElementException e){
            System.out.println("Error! Size = " + linkedList.size());
        }
        System.out.println("After removing: " + linkedList + "(sise: " + linkedList.size() + ")");

        //getting elements by index
        try{
            System.out.println("get(1): " + linkedList.get(1));
            System.out.println("Symbol must be: " + symbolsToFront[symbolsToFront.length - 4]);
            Assert.assertTrue(linkedList.get(1).equals(symbolsToFront[symbolsToFront.length - 4]));
        } catch (NoSuchElementException e){
            System.out.println("NoSuchElement! Size = " + linkedList.size());
        } catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBounds! Size = " + linkedList.size());
        }

        //setting
        try{
            linkedList.set(2, 'j');
            System.out.println("set(2): " + linkedList.get(2));
            Assert.assertTrue(linkedList.get(2).equals('j'));
        } catch (NoSuchElementException e){
            System.out.println("Error! Size = " + linkedList.size());
        } catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBounds! Size = " + linkedList.size());
        }
        System.out.println("After setting: " + linkedList + "(sise: " + linkedList.size() + ")");

        //contains & indexOf
        Assert.assertTrue(containsInList == linkedList.contains(symbolToSet));
        System.out.println("List contains 'j': " + (linkedList.contains(symbolToSet)));
        try{
            Assert.assertTrue((2 == linkedList.indexOf(symbolToSet)) == containsInList);
            System.out.println("Symbol 'j' index: " + linkedList.indexOf(symbolToSet));
        } catch (NoSuchElementException e){
            System.out.println("Error! Size = " + linkedList.size());
        }

        //adding by index
        try{
            linkedList.add(0, '0');
            System.out.println("add (index = 0; symbol = '0')");
            linkedList.add(0, '0');
            System.out.println("add (index = 0; symbol = '0')");
            linkedList.add(3, '3');
            System.out.println("add (index = 3; symbol = '3')");
            linkedList.add(3, '3');
            System.out.println("add (index = 3; symbol = '3')");
            linkedList.add(5, '5');
            System.out.println("add (index = 5; symbol = '5')");
            linkedList.add(7, '7');
            System.out.println("add (index = 7; symbol = '7')");
        } catch (NoSuchElementException e){
            System.out.println("Error! Size = " + linkedList.size());
        } catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBounds! Size = " + linkedList.size());
        }
        System.out.println("After adding by index: " + linkedList + "(sise: " + linkedList.size() + ")");

        try{
            linkedList.remove('0');
            System.out.println("remove (symbol = '0')");
            linkedList.remove('0');
            System.out.println("remove (symbol = '0')");
            linkedList.remove('5');
            System.out.println("remove (symbol = '5')");
        } catch (NoSuchElementException e){
            System.out.println("Error! Size = " + linkedList.size());
        } catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBounds! Size = " + linkedList.size());
        }
        System.out.println("After removing by index: " + linkedList + "(sise: " + linkedList.size() + ")");
    }

    @After
    public void result(){
        System.out.println("After testing: " + linkedList + "(size = " + linkedList.size() + ")" + "\n");
    }
}
