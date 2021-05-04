//AbstractVehicleOption추상클래스를 구현한 ConcreteDecorator객체로 볼 수 있다.
//decoratedVehicle이 참조하고 있는 객체(MetallicPaintedVehicle이 꾸며주고 있는 객체)의 getPrice()통해 반환된 값에 750을 더해준다.
public class MetallicPaintedVehicle extends AbstractVehicleOption {
    public MetallicPaintedVehicle(Vehicle vehicle) {
        super(vehicle);
    }
    @Override
    public int getPrice(){
        return decoratedVehicle.getPrice()+750;
    }
}
