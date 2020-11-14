//Vehicle를 구현한 구상클래스(차량)을 꾸며주는 클래스들에 대한 추상화를 추상클래스AbstractVehicleOption클래스를 통해 하였다.
//데코레이터의 상위클래스는 자신이 꾸미고 있는 객체의 상위클래스와 동일해야한다. 따라서 AbstractVehicle을 상속하도록 하였다.
public abstract class AbstractVehicleOption extends AbstractVehicle {
    //이를 구현하는 클래스마다 모두 동일하게 탈것(Vehicle)을 꾸미기 때문에 상위의 추상클래스에서 선언해주었다.
    //상속관계의 하위 클래스에서 접근 가능하도록 protected로 접근지정자를 설정해주었다.
    protected Vehicle decoratedVehicle;

    //생성자에서 자신이 꾸미고 있는 객체에 대한 래퍼런스와 함께 자신이 꾸미고 있는 객체의 엔진과 색에 대한 정보를 함께 가지고 있는다.
    //이렇게 한 이유는 출력시에 꾸미고 있는 객체에 대한 엔진과 색에 대한 정보도 함께 출력하고 있기 때문이다.
    public AbstractVehicleOption(Vehicle vehicle) {
        super(vehicle.getEngine(), vehicle.getColour());
        decoratedVehicle = vehicle;
    }

    @Override
    public abstract int getPrice();
}
