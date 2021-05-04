//AbstractVehicleOption추상클래스를 구현한 ConcreteDecorator객체로 볼 수 있다.
//decoratedVehicle이 참조하고 있는 객체(AlloyWheeledVehicle이 꾸며주고 있는 객체)의 getPrice()통해 반환된 값에 250을 더해준다.
public class AlloyWheeledVehicle extends AbstractVehicleOption {
    public AlloyWheeledVehicle(Vehicle vehicle) {
        super(vehicle);
    }
    @Override
    public int getPrice(){
        return decoratedVehicle.getPrice()+250;
    }
}
