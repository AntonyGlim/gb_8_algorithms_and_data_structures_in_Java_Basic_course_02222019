package lesson_3_Stack_and_queue_test;

import lesson_3_Stack_and_queue.Expression;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ExpressionTest {

    static int count = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"(){}[]", true},
                {"((){}[]", false},
                {"((([[{([][]{})}]])))", true},
                {"([})", false},
                {"(2 + [2]) + {4 - [)}", false},
        });
    }

    private String expression;
    private boolean isCorrect;

    public ExpressionTest(String expression, boolean isCorrect) {
        this.expression = expression;
        this.isCorrect = isCorrect;
    }

    Expression expr;

    @Before
    public void init() {
        expr = new Expression(expression);
        System.out.println("Test #" + ++count);
        System.out.println(expr);
    }

    @Test
    public void test() {
        Assert.assertTrue(expr.checkBrackets() == isCorrect);
    }

    @After
    public void result(){
        System.out.println("Test #" + count + " finished");
        System.out.println();
    }
}