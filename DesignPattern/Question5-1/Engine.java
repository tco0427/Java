/*
엔진에 관한 일종의 명세,표준이다.(인터페이스)
엔진에 관한 기능(오퍼레이션)들의 모음(추상형)
이 인터페이스를 구현하는 객체가 제공하는 기능에 대한 일종의 명세
 */
public interface Engine {
    public int getSize();
    public boolean isTurbo();
}
