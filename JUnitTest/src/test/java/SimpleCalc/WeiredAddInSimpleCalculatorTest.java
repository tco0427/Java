package SimpleCalc;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@Category(FunctionGroup3Test.class)
public class WeiredAddInSimpleCalculatorTest {
    private int expected;
    private int value1;
    private int value2;

    public WeiredAddInSimpleCalculatorTest(int expected, int value1, int value2){
        this.expected=expected;
        this.value1=value1;
        this.value2=value2;
    }

    @Parameterized.Parameters
    public static Collection getParameters(){
        return Arrays.asList(new Integer[][]{
                {30,10,20},
                {0,0,0},
                {100,5,7}
        });
    }

    @Test
    public void testWeirdAdd(){
        SimpleCalculator calc=new SimpleCalculator();
        calc.weirdAdd(value1,value2);
        assertEquals(expected,calc.getResult());
    }
}
