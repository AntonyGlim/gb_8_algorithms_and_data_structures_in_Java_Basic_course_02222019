package lesson_3_Stack_and_queue;

/**
 * В классе рассматривается пример применения стэка
 * для решения задачи со скобками
 *
 * (a + b) * ([b - 7] / {a - 5 * (a - 2)}) правильно расставлены скобки?
 * встречая скобку - помещаем ее в стек
 * если встречаем закр. скобку сравниваем с верхушкой стека
 */
public class Expression {

    private String expr;

    public Expression(String expr) {
        this.expr = expr;
    }

    /**
     *
     * @return
     */
    public boolean checkBrackets(){
        MyArrayStack <Character> stack = new MyArrayStack<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}'){
                if (stack.isEmpty()){
                    System.out.println("Error in " + i + " position");
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(' || ch == ']' && top != '[' || ch == '}' && top != '{'){
                    System.out.println("Error in " + i + " position");
                    return false;
                }
            }
        }
        if (!stack.isEmpty()){
            System.out.println("Error! Bracket doesn't match.");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return expr;
    }
}
