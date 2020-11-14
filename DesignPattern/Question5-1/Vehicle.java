/*
차량 인터페이스 Vehicle에 대한 기능들을 선언하여 표준을 만들어주었다.
차량색에 대한 열거형을 선언해주었다. 이 때 인터페이스의 모든 변수는 pulic static이 선언된 것으로 간주한다.
열거형의 경우 모두 final이므로 final키워드가 불필요하고 이를 컴파일 단계에서 허용하지도 않는다.
이 인터페이스를 구현하는 객체가 제공하는 기능에 대한 일종의 명세
 */
public interface Vehicle {
    public enum Colour{UNPAINTED,BLUE,BLACK,GREEN,RED,SILVER,WHITE,YELLOW};
    public Engine getEngine();
    public Vehicle.Colour getColour();
    public void paint(Vehicle.Colour colour);
    public int getPrice();
}
