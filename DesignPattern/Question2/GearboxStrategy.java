//기어박스에 관한 일종의 명세,표준이다.(인터페이스)
//기어박스에 관한 기능(오퍼레이션)들의 모음(추상형)
//이를 구현하여 구체화한 클래스(StandardGearboxStrategy, SportGearboxStrategy)를 통해
//기어박스 인스턴스를 생성하도록 하였다.
public interface GearboxStrategy {
    public void ensureCorrectGear(Engine engine,int speed);
}
