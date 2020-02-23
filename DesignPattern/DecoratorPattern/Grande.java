package DecoratorPattern;

public class Grande extends CondimentDecorator {
    Beverage beverage;
    public Grande(Beverage beverage){
        this.beverage=beverage;
        this.beverage.setSize("Grande");
    }

    @Override
    public String getDescription(){
        return beverage.getDescription()+", "+beverage.getSize();
    }
    @Override
    public double cost() {
        return .15 +beverage.cost();
    }
}
