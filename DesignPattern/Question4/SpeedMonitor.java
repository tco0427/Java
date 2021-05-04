//옵저버가 등록한 주제 객체의 데이터에 변화가 생기면 이에 대한 연락,notification을 받는다.
public class SpeedMonitor implements Observer{
    //static선언을 통해 인스턴스 생성이전에 정적으로 그리고 final선언을 통해 값이 한 번 초기화되면 변경이 불가한 상수를 public접근지정자를 통해
    //외부에서 접근 가능하게 선언하였다.
    public static final int SPEED_TO_ALERT=70;
    //private접근지정자로 외부에서 접근할 수 없도록, 클래스 내부에서만 접근가능하도록 인스턴스 변수들을 생성하였다.
    //currentSpeed는 주제객체로부터 전달받은 데이터를 저장하기 위한 int형 변수이다.
    private int currentSpeed;
    //주제(Subject)객체를 참조하기 위한 참조변수 speedometer이다.
    private Subject speedometer;

    /*
    아무것도 하지 않고 매개변수를 전달받지 않는 기본생성자를 두어 생성자를 오버로딩하였다.
    생성자에서 Subject형 매개변수를 통해 옵저버를 주제객체에 등록시켜도 되지만
    즉 옵저버 객체 생성시에 주제객체에 등록하여도 되지만
    Simulator의 main메소드에서와 같이 옵저버 객체 생성시 주제객체에 등록하는 것이 아닌
    주제객체에서 직접 addObserver()메소드를 통해 등록할 수 있다.
    옵저버 객체 생성시에 등록여부를 결정하지 않고 실행중에 동적으로 결정할 수 있다.
     */
    public SpeedMonitor(Subject speedometer){
        this.speedometer=speedometer;
        speedometer.addObserver(this);
    }
    public SpeedMonitor(){}

    //오버라이딩을 통해 Observer인터페이스에 정의된 update메소드에 대한 구체적인 구현을 하였다.
    @Override
    public void update(int currentSpeed){
        //주제객체에서 직접 데이터를 보내고 이를 매개변수로 받는다.(푸쉬방식)
        //이를 인스턴스 변수에 저장하고 SPEED_TO_ALERT와의 비교를 통해 fastSpeedDisplay()와properSpeedDisplay()를 호출한다.
        this.currentSpeed=currentSpeed;
        if(currentSpeed>SPEED_TO_ALERT){
            fastSpeedDisplay();
        }else{
            properSpeedDisplay();
        }
    }
    public void fastSpeedDisplay(){
        System.out.println("** ALERT ** Driving too fast! ("+this.currentSpeed+")");
    }
    public void properSpeedDisplay(){
        System.out.println("... nice and steady ...("+this.currentSpeed+")");
    }
}
