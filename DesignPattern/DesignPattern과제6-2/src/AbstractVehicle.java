//Vehicle인터페이스를 구현하는 (추상)클래스
//탈 것에 관련된 속성(필드)들을 추가하였다.
//탈 것에 관한 기능(메소드)을 구체화하였다.
//생성자를 오버로딩하여 색과 관련된 정보 없이 엔진에 관련된 정보만으로 탈것에 관한 인스턴스를 생성할 수 있도록하였다.
//(물론 추상클래스를 대상으로 인스턴스 생성하는 것이 아닌 이를 구현하는 하위클래스(혹은 이를 상속하는 추상클래스)의 생성자에서 super()통해 호출)
//바뀌는 부분과 바뀌지 않는 부분을 분리하고 엔진에 대한 내용을 AbstractVehicle(혹은 서브클래스)에서 구현하지 않고 다른 클래스에 위임하고
//이에 대한 인터페이스 형식의 인스턴스 변수를 추가하였다. 이를 통해 기존의 코드를 변경하지 않고도 엔진에 대한 내용을 변경할 수 있고
//새로운 엔진 추가되더라도 탈 것에 관련된 AbstractVehicle은 영향을 받지 않는다.
public abstract class AbstractVehicle implements Vehicle {
    //Engine에 대한 composition을 이용
    private Engine engine;
    private Vehicle.Colour colour;
    public AbstractVehicle(Engine engine){
        this.engine=engine;
    }
    public AbstractVehicle(Engine engine,Vehicle.Colour colour){
        this.engine=engine;
        this.colour=colour;
    }
    public Engine getEngine(){
        return this.engine;
    }
    public Vehicle.Colour getColour(){
        return this.colour;
    }
    public void paint(Vehicle.Colour colour){
        this.colour=colour;
    }
}
