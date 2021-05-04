//java.util패키지에 들어있는 List인터페이스와 ArrayList클래스를 import한다.
import java.util.ArrayList;
import java.util.List;
//실제 데이터(currentSpeed)를 소유하고 관리하는 클래스는 Subject인터페이스를 구현하는 구상클래스(Speedmeter)이다.
public class Speedometer implements Subject{
    //캡슐화의 원칙을 지키기 위해 가능하면 필드에 대해서 private선언을 하는 것이 좋다고 판단되어 private접근지정자를 설정하였다.
    //Observer객체들을 저장하기 위해 ArrayList인스턴스 변수 선언
    private List<Observer> observers;
    //현재 속도에 관한 인스턴스 변수를 선언하였다.
    private int currentSpeed;

    //Speedometer인스턴스 생성시 생성자 호출로 이어지면 이 때 Observer객체들을 저장하는 컬렉션인스턴스ArrayList가 생성되고 이를 observers가 참조
    public Speedometer(){
        this.observers=new ArrayList<>();
    }

    /*
    다음의 addObserver(),deleteObserver(),notifyObservers()는 오버라이딩을 통해
    인터페이스에 선언된 추상메소드에 대해 구체적으로 구현한다.
    각각 옵저버 객체를 등록,삭제하고 만약 Speedometer객체의 데이터(currentSpeed)에 변경이 발생하면
    옵저버에게 알리는(notify) 기능들을 한다.
     */
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    @Override
    public void deleteObserver(Observer observer){
        int i=observers.indexOf(observer);
        if(i>=0){
            observers.remove(i);
        }
    }
    //setCurrentSpeed(currentSpeed인스턴스 변수에 대한 설정자)를 통해 데이터에 변화가 발생하고
    //currentSpeedChanged()메소드를 호출한다.
    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
        currentSpeedChanged();
    }
    //currentSpeedChanged(),즉 currentSpeedChanged()에 변화가 생기면 이를 옵저버들에게 알리기위해
    //notifyObservers()메소드를 호출한다.
    public void currentSpeedChanged(){
        notifyObservers();
    }
    @Override
    public void notifyObservers(){
        //for-each구문을 통해 인스턴스변수를 통해 참조하고 있는 (Observer객체들을 저장하는) ArrayList인스턴스에 저장된 모든 인스턴스들을 대상으로
        //순차적으로 반복한다.
        //이와같은 순차적 접근의 대상이 되려면, 해당 컬렉션 클래스는 Iterable<T>인터페이스를 구현하여야 하는데 Collection<E>가 Iterable<T>를 상속하고
        //ArrayList클래스와 LinkedList클래스는 Collection<E>를 상속하므로 Iterable<T>인터페이스를 간접구현하고 있다.
        for(Observer observer: observers){
            //Subject에서 직접 데이터를 보내는 푸시 방식으로 구현
            observer.update(this.currentSpeed);
        }
    }
    //currentSpeed인스턴스 변수에 대한 접근자
    public int getCurrentSpeed() {
        return currentSpeed;
    }

}
