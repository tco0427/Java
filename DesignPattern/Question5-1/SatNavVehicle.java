//AbstractVehicleOption추상클래스를 구현한 ConcreteDecorator객체로 볼 수 있다.
//decoratedVehicle이 참조하고 있는 객체(SatNavVehicle이 꾸며주고 있는 객체)의 getPrice()통해 반환된 값에 1500을 더해준다.
public class SatNavVehicle extends AbstractVehicleOption {
    private String destination;
    public SatNavVehicle(Vehicle vehicle) {
        super(vehicle);
    }
    @Override
    public int getPrice(){
        return decoratedVehicle.getPrice()+1500;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDestination() {
        return destination;
    }
}
