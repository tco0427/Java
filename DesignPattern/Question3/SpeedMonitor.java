//java.util패키지에 들어있는 Observable클래스와 Observer인터페이스를 import한다.
import java.util.Observable;
import java.util.Observer;

//Observer인터페이스를 구현하는 구상클래스SpeedMonitor
public class SpeedMonitor implements Observer{
    Observable observable;
    public static final int SPEED_TO_ALERT=70;
    private int currentSpeed;

    /*
    아무것도 하지 않고 매개변수를 전달받지 않는 기본생성자를 두어 생성자를 오버로딩하였다.
    생성자에서 Observable형 매개변수를 통해 옵저버를 주제객체에 등록시켜도 되지만
    즉 옵저버 객체 생성시에 주제객체에 등록하여도 되지만
    Simulator의 main메소드에서와 같이 옵저버 객체 생성시 주제객체에 등록하는 것이 아닌
    주제객체에서 직접 addObserver()메소드를 통해 등록할 수 있다.
    옵저버 객체 생성시에 등록여부를 결정하지 않고 실행중에 동적으로 결정할 수 있다.
     */
    public SpeedMonitor(){}
    public SpeedMonitor(Observable observable){
        this.observable=observable;
        observable.addObserver(this);
    }
    //Observer인터페이스에 정의되어 있는 update를 오버라이딩한다.
    //어노테이션은 자바 컴파일러에게 메시지를 전달하는 목적의 메모로 볼 수 있는데(메타데이터)
    //@Override를 통하여 오버라이딩이 제대로 이루어졌는지 컴파일과정에서 발견가능하다.(개발자의 실수를 잡아냄)

    //update()메소드는 주제객체(여기서는 Observable를 상속하는 Speedmeter클래스)에서 상태가 변경될 때 호출된다.
    @Override
    public void update(Observable obs, Object obj) {
        //다운캐스팅을 안전하게 하기위해 instanceof와 if문을 통해 먼저 검사한다.
        if(obs instanceof Speedometer){
            /*
            obs를 Speedmeter형으로 형변환한다.
            왜냐하면 이후 호출하는 getCurrentSpeed()와 같은 메소드는 Speedmeter클래스에서 정의되었고
            이렇게 Speedmeter에 정의된 메소드는 상위클래스의 참조변수를 통해 호출할 수 없다.
            (Observable형 참조변수로 접근가능한 멤버는 Observable클래스에 정의된 멤버만 가능하다.)
             */
            Speedometer speedometer=(Speedometer)obs;
            //Observer에서 직접 데이터를 가져오는(getXXX()메소드를 통해) 풀 방식
            this.currentSpeed=speedometer.getCurrentSpeed();
            /*
            주제객체에서 getCurrentSpeed()를 통해 전달받은 데이터를 인스턴스 변수 currentSpeed에 저장하고
            currentSpeed의 값에 따라, 즉 주제객체로부터 전달된 데이터에 따라 다르게 출력한다.
            */
            if(currentSpeed>SPEED_TO_ALERT){
                System.out.println("** ALERT ** Driving too fast! ("+speedometer.getCurrentSpeed()+")");
            }else{
                System.out.println("... nice and steady ...("+speedometer.getCurrentSpeed()+")");
            }
        }
    }
}
