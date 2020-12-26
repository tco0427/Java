package calculatortdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void createCalculator(){
        Calculator calc=new Calculator();
        assertEquals(0,calc.getResult());
    }
    @Test
    public void createCalculatorWithValue(){
        Calculator calc=new Calculator(10);
        assertEquals(10,calc.getResult());
    }
    @Test
    public void testAdd(){
        Calculator calc=new Calculator();
        calc.add(20);
        assertEquals(20,calc.getResult());
    }
    @Test
    public void testTwoConsecutiveAdd(){
        Calculator calc=new Calculator();
        calc.add(20);
        calc.add(30);
        assertEquals(50,calc.getResult());
    }
    @Test
    public void testClear(){
        Calculator calc=new Calculator(30);
        calc.add(20);
        assertEquals(50,calc.getResult());
        calc.clear();
        assertEquals(0,calc.getResult());
    }
}
