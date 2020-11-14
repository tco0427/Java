//주제 인터페이스
//addObserver(),deleteObserver(),notifyObservers()메소드를 통해
//주제객체에 옵저버를 등록,삭제,변경 알림 기능(behavior)들을 선언하여
//메소드의 시그니처(반환형,이름,매개변수정보만을 선언)표준을 만들었다.
//이를 구현하는 객체가 제공하는 기능에 대한 일종의 명세
public interface Subject {
    public void addObserver(Observer observer);
    public void deleteObserver(Observer observer);
    public void notifyObservers();
}
