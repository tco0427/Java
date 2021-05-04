package SimpleCalc;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.experimental.categories.Category;

public class SimpleCalculatorTest {
    private SimpleCalculator calc;
    @BeforeClass
    public static void setUpClass(){
        System.out.println("Test class started");
    }
    @AfterClass
    public static void tearDownClass(){
        System.out.println("Test class finished");
    }
    @Before
    public void setUp(){
        System.out.println("Test started");
        calc=new SimpleCalculator();
    }
    @After
    public void tearDown(){
        System.out.println("Test finished");
    }
    @Test
    @Category(FunctionGroup1Test.class)
    public void testAdd() throws Exception{
        calc.add(10,20);
        assertEquals("실패",30,calc.getResult());
    }
    @Test
    @Category(FunctionGroup1Test.class)
    public void testSub(){
        calc.sub(10,20);
        Assert.assertEquals(-10,calc.getResult());
    }
    @Test
    @Category(FunctionGroup2Test.class)
    public void testInc() throws Exception{
        calc.inc(10);
        assertEquals(10,calc.getResult());
    }

    @Test(expected=IllegalArgumentException.class)
    @Category(FunctionGroup1Test.class)
    public void testAddWithNegativeArgument() throws IllegalArgumentException{
        calc.addWithPositiveArgs(10,-20);
    }
}
