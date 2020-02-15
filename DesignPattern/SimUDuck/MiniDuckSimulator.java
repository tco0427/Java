package SimUDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard=new MallardDuck();
        mallard.display();
        mallard.swim();
        mallard.perfomFly();
        mallard.perfomQuack();

        Duck model=new ModelDuck();

        model.perfomFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.perfomFly();

    }
}
