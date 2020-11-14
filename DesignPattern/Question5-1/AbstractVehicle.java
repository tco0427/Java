//Vehicle인터페이스를 구현하는 (추상)클래스
//탈 것에 관련된 속성(필드)들을 추가하였다.
//getPrice()를 제외한 나머지 탈 것에 관한 기능(메소드)들을 구체화하였다.(getPrice()에 대해서는 여전히 추상메소드이다.)
//데코레이터에 의해 장식되는 객체에 대한 추상클래스(AbstractCar,AbstractVan)과 데코레이터에 대한 추상클래스(AbstractVehicleOption) 모두 이 클래스를 상속한다.
//데코레이터의 상위 클래스는 자신이 장식하고 있는 객체의 상위클래스와 같아야하기 때문이다.
//(AbstractVehicle은 Vehicle를 구현한다. 물론 Vehicle의 getPrice()를 구현하지 않고 있고,
//인터페이스의 모든 추상메소드를 구현하지 않은 경우 추상클래스이어야한다. AbstractVehicle는 추상클래스이다.)
//바뀌는 부분과 바뀌지 않는 부분을 분리하고 엔진에 대한 내용을 AbstractVehicle(혹은 서브클래스)에서 구현하지 않고 다른 클래스에 위임하고
//이에 대한 인터페이스 형식의 인스턴스 변수를 추가하였다. 이를 통해 기존의 코드를 변경하지 않고도 엔진에 대한 내용을 변경할 수 있고
//새로운 엔진 추가되더라도 탈 것에 관련된 AbstractVehicle은 영향을 받지 않는다.
public abstract class AbstractVehicle implements Vehicle {
    //인스턴스 변수 engine과 colour에 대해서 private로 정의해주었고 이에 대한 접근자를 정의해주었다.
    //캡슐화의 원칙을 지키기 위해 가능하면 필드에 대해서 접근 범위를 작게하는 것이 좋다.
    private Engine engine;
    private Vehicle.Colour colour;
    //생성자를 오버로딩하여 색과 관련된 정보 없이 엔진에 관련된 정보만으로 탈것에 관한 인스턴스를 생성할 수 있도록하였다.
    //(물론 추상클래스를 대상으로 인스턴스 생성하는 것이 아닌 이를 구현하는 하위클래스(혹은 이를 상속하는 추상클래스)의 생성자에서 super()통해 호출)
    public AbstractVehicle(Engine engine){
        this(engine, Colour.UNPAINTED);
    }
    public AbstractVehicle(Engine engine, Vehicle.Colour colour){
        this.engine=engine;
        this.colour=colour;
    }
    //private로 정의된 engine과colour 인스턴스 변수에 대한 접근자와 설정자를 정의하였다.
    public Engine getEngine(){
        return engine;
    }
    public Vehicle.Colour getColour(){
        return colour;
    }
    public void paint(Vehicle.Colour colour){
        this.colour=colour;
    }
    //Object클래스의 toString()메소드를 오버라이딩을 통해 재정의하였다.
    //따라서 이를 상속하는 하위클래스들에서 toString()을 다시 오버라이딩하지 않는 이상
    //AbstractVehicle에서 정의한 toString()이 호출된다.
    @Override
    public String toString() {
        return getClass().getSimpleName()+
                "("+engine+", "+colour+
                ", price "+getPrice()+")";
    }
}
