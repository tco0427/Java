//'탈 것'에 관한 일종의 명세,표준이다.(인터페이스)
//'탈 것'에 관한 기능(오퍼레이션)들의 모음(추상형)
//또한 색과 관련된 상수를 enum 열거형을 통해 인터페이스 내에서 선언해주었다.(static 생략되어 있지만 static으로 간주)
public interface Vehicle {
    public enum Colour {UNPAINTED,BLUE,BLACK,GREEN,RED,SILVER,WHITE,YELLOW};
    public Engine getEngine();
    public Vehicle.Colour getColour();
    public void paint(Vehicle.Colour colour);
}
