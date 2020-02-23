package DecoratorPattern;

public class Espresso extends Beverage {
    public Espresso(){
        description="에소프레소";
    }
    @Override
    public double cost(){
        return 1.99;
    }
}
