package SimpleCalc;


import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
@RunWith(Suite.class)
@Suite.SuiteClasses({SimpleCalculatorTest.class,
        WeiredAddInSimpleCalculatorTest.class})
public class AllTest {}
 */

@RunWith(Categories.class)
//@Categories.IncludeCategory({FunctionGroup2Test.class, FunctionGroup3Test.class})
@Categories.ExcludeCategory(FunctionGroup1Test.class)
@Suite.SuiteClasses({SimpleCalculatorTest.class,
        WeiredAddInSimpleCalculatorTest.class})
public class AllTest {}
