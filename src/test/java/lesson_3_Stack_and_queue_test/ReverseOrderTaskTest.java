package lesson_3_Stack_and_queue_test;

import lesson_3_Stack_and_queue.ReverseOrderTask;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ReverseOrderTaskTest {

    static int count = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abcde", "edcba"},
                {"1234567890", "0987654321"},
                {"I muse my Lord of Gloucester is not come:", ":emoc ton si retsecuolG fo droL ym esum I"},
                {"'Tis not his wont to be the hindmost man,", ",nam tsomdnih eht eb ot tnow sih ton siT'"},
                {"Whate'er occasion keeps him from us now.", ".won su morf mih speek noisacco re'etahW"},
                {"QUEEN MARGARET", "TERAGRAM NEEUQ"},
                {" ", " "}
        });
    }

    private String text;
    private String textReverse;

    public ReverseOrderTaskTest(String text, String textReverse) {
        this.text = text;
        this.textReverse = textReverse;
    }

    ReverseOrderTask rot;
    String rezult;

    @Before
    public void init(){
        rot = new ReverseOrderTask(text);
        System.out.println("Test #" + ++count);
        System.out.println("Text for testing: \"" + text + "\"");
    }

    @Test
    public void test() {
        rezult = rot.reverse();
        Assert.assertTrue(textReverse.equals(rezult));
    }


    @After
    public void result(){
        System.out.println("Text after testing: \"" + rezult + "\"");
        System.out.println("Test #" + count + " finished\n");
    }

}
