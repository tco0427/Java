package DecoratorPattern;

public class tall extends CondimentDecorator {
    Beverage beverage;
    public tall(Beverage beverage){
        this.beverage=beverage;
        super.setSize("tall");
    }
    @Override
    public String getDescription(){
        return beverage.getDescription()+", "+getSize();
    }
    @Override
    public double cost(){
        return .10+beverage.cost();
    }
}
