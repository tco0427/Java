package DecoratorPattern;

public class Large extends CondimentDecorator {
    Beverage beverage;
    public Large(Beverage beverage){
        this.beverage=beverage;
        this.beverage.setSize("Large");
    }

    @Override
    public double cost() {
        return .20+beverage.cost();
    }
    @Override
    public String getDescription(){
        return beverage.getDescription()+", "+beverage.getSize();
    }
}
