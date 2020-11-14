//AbstractVehicle클래스를 상속받는 AbstractCar추상클래스와 AbstractVan추상클래스를 정의하였다.
//이를 통해 탈 것(Vehicle)으로 추상화 되어 있던 것을 Van과 Car로 구체화, 세분화하였다.
public abstract class AbstractCar extends AbstractVehicle {
    //생성자를 오버로딩하여 색정보없이 엔진정보만을 가지고도 인스턴스 생성이 가능하게 하였다.(물론 AbstractCar를 대상으로 인스턴스생성하는 것잉 아닌 이를 구상하는 클래스를 대상으로 인스턴스를 생성하는 것이다.)
    //이 때 두 생성자 모두에서 상위클래스의 생성자를 호출하고 있다.
    public AbstractCar(Engine engine) {
        super(engine);
    }
    public AbstractCar(Engine engine, Colour colour) {
        super(engine, colour);
    }
    @Override
    public abstract int getPrice();
}
