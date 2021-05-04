
public class Simulator {
    public static void main(String[] args) {
        //1번문제에서는 주제객체의 addObserver()메소드를 통해 옵저버 객체를 등록하였지만
        //여기서는 옵저버를 생성할 때 생성자로 주제객체를 전달하는 방법으로 등록하게끔 구현해보았다.
        Speedometer speedo=new Speedometer();
        SpeedMonitor monitor=new SpeedMonitor(speedo);

        speedo.setCurrentSpeed(50);
        speedo.setCurrentSpeed(70);
        speedo.setCurrentSpeed(40);
        speedo.setCurrentSpeed(100);
        speedo.setCurrentSpeed(69);
        speedo.setCurrentSpeed(71);
    }
}
