//자바에 내장되어 있는 옵저버 패턴(Observer인퍼테이스와 Observable클래스)를 이용하면 풀 방식과 푸시 방식 모두 사용 가능하다.
//java.util패키지에 들어있는 Observable클래스를 import한다.
import java.util.Observable;


//Speedmeter클래스는 Observable클래스를 상속을 통해 확장한다.
public class Speedometer extends Observable{
    //현재 속도와 관련된 인스턴스 변수 currentSpeed
    //객체 지향 특성을 살리기 위해서는 캡슐화의 원칙이 지켜지도록 가능한 필드에 대해서 private선언을 하고
    //접근자와 설정자 메소드를 두는 것이 좋다고 판단하여 private로 선언해주었다.
    private int currentSpeed;

    public void Speedometer(){}
    //풀 방식에서는 다음의 getXXX()메소드가 요구된다.
    //Observer객체에서 직접 데이터를 가져가는 방식이기 때문이다.
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
        //currentSpeed가 setCurrentSpeed()의 호출로 변경될 시 즉 상태가 바뀌면 옵저버들에게 상태가 바뀌었음을 알리기위해 currentSpeedChanged()를 호출한다.
        currentSpeedChanged();
    }
    public void currentSpeedChanged(){
        /*
        Observable클래스에 정의되어 있는 setChanged()메소드는 상태가 바뀌었음을 밝히기 위한 용도로
        연락을 최적화할 수 있게 해줌으로써 옵저버들을
        갱신하는 방법에 있어서 더 광범위한 유연성을 제공하기 위해 만들어 진 것이다.
        setChanged()메소드를 조건에 따라 호출함으로써 원하는 조건에서만 연락을 돌릴 수 있다.
        참고로, changed플래그를 거짓으로 만드는 clearChanged()메소드와
        changed플래그의 현재 상태를 알려주는 hasChanged()메소드가 Observable클래스에 정의되어 있다.
         */
        setChanged();
        /*
        Observable클래스에 오버로딩되어 있는 notifyObservers(Object arg)에 인자로 null을 전달한 메소드 호출한다.
        notifyObservers()메소드 내부에서 changed가 참이면 등록된 옵저버들에 대해 update()메소드를 호출하고 changed플래그를 거짓으로 변경한다.
        이와 같이 notifyObservers()를 호출할 때 데이터 객체를 보내지 않는다는 것은 풀 모델(옵저버에서 직접 데이터를 가져가는 방식)이 사용되었다는 것을 뜻한다.
         */
        notifyObservers();
    }
}
