public class Simulator {
    public static void main(String[] args) {
        AbstractCar myCar=new Sport(new StandardEngine(2000));
        myCar.setSpeed(20);
        myCar.setSpeed(40);
        System.out.println("Switching on sports mode gearbox...");
        myCar.setGearboxStrategy(new SportGearboxStrategy());
        myCar.setSpeed(20);
        myCar.setSpeed(40);

        System.out.println();

        //내가 이해하고 있는 클래스 다이어그램과 일치하는지 확인하기 위해 테스트한 코드들
        System.out.println("내가 이해하고 있는 클래스의 관계들이(구조가) 올바른지 확인해보기 위해서 테스트한 코드들");
        myCar.paint(Vehicle.Colour.BLACK);
        System.out.println(myCar.getColour());

        Engine engine=myCar.getEngine();
        System.out.println(engine.getSize());
        System.out.println(engine.isTurbo());

        GearboxStrategy gearboxStrategy=myCar.getGearboxStrategy();
        gearboxStrategy.ensureCorrectGear(new TurboEngine(2000),30);

        AbstractCar myCar2=new Sport(new StandardEngine(3000), Vehicle.Colour.RED);
        System.out.println(myCar2.getColour());
        myCar2.setSpeed(20);
        myCar2.setGearboxStrategy(new SportGearboxStrategy());
        myCar2.setSpeed(50);
    }
}
