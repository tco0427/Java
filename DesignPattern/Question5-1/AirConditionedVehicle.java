//AbstractVehicleOption추상클래스를 구현한 ConcreteDecorator객체로 볼 수 있다.
//decoratedVehicle이 참조하고 있는 객체(AirConditionedVehicle이 꾸며주고 있는 객체)의 getPrice()통해 반환된 값에 600을 더해준다.
public class AirConditionedVehicle extends AbstractVehicleOption {
    private int temperature;
    public AirConditionedVehicle(Vehicle vehicle) {
        super(vehicle);
    }
    @Override
    public int getPrice(){
        return decoratedVehicle.getPrice()+600;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
