import java.util.NoSuchElementException;

public class MyArrayStack <Item> {

    private  Object[] stack = new Object[1];
    private int size = 0;

    /**
     * TODO see teacher cod
     * @return
     */
    public boolean isEmpty(){
        if (size > 0){
            return true;
        }
        return false;
    }

    public  void push (Item item){
        if (size == stack.length){
            resize(2 * stack.length);
        }
        stack[size++] = item;
    }

    /**
     * Посмотреть что на верху стека
     * @return
     */
    public Item peek(){
        if (isEmpty()){
            throw new  NoSuchElementException();
        }
        //InstanceOf not needed
        return (Item) stack[size - 1];
    }

    /**
     * Извлечение элемента
     * @return
     */
    public Item pop(){
        if (isEmpty()){
            throw new  NoSuchElementException();
        }
        Item item = (Item) stack[size - 1];
        size--;
        if (size == stack.length / 4 && size > 0){
            resize (stack.length / 2);
        }
        return item;
    }

    /**
     * Вывод
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            stringBuilder.append((Item) stack[i].toString());
            stringBuilder.append(", ");
        }

        return stringBuilder.toString();
    }
}
