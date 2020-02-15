package SimUDuck;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){}

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();
    public void swim(){
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠.");
    }

    public void perfomFly(){
        flyBehavior.fly();
    }
    public void perfomQuack(){
        quackBehavior.quack();
    }
}
