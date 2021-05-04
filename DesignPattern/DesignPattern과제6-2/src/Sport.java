//AbstractCar를 상속하는 Sport클래스이다.
//즉 이는 AbstractVehicle과 Vehicle을 간접적으로 상속 및 구현한다.
public class Sport extends AbstractCar {
    public Sport(Engine engine){
        super(engine);
    }
    public Sport(Engine engine,Vehicle.Colour colour){
        super(engine);
        paint(colour);
    }
}
