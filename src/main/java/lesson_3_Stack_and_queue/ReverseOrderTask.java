package lesson_3_Stack_and_queue;

public class ReverseOrderTask {
    String text;

    public ReverseOrderTask(String text) {
        this.text = text;
    }

    public String reverse(){
        MyArrayStack<Character> stack = new MyArrayStack();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
