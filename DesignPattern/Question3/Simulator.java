public class Simulator {
    public static void main(String[] args) {
        //옵저버객체에 해당되는 인스턴스를 생성한다.
        SpeedMonitor monitor=new SpeedMonitor();
        //주제객체에 해당되는 인스턴스를 생성한다.
        Speedometer speedo=new Speedometer();
        /*
        위와 같이 옵저버생성 이후에 주제객체를 생성하는 경우는 교재(HeadFirstDesignPatterns)와 같이 생성자를 정의하면
        옵저버 생성시에 주제객체를 전달하여야하므로 불가능한데,
        여기서는 생성자의 오버로딩을 통해 기본생성자를 추가하였고 아래와 같이 주제인스턴스를 참조하는 참조변수를 통해 직접 addObserver를 호출하며
        옵저버 객체를 전달하고 있다.
        이를 통해 옵저버 생성시에 주제객체에 등록여부를 판단할 필요가 없고 또 어떠한 주제객체에도 등록되지 않을 수 있다.
        (만약 기본생성자를 오버로딩하지 않았다면 옵저버인스턴스 생성시에 무조건 주제(Subject)에 등록되어야 한다.)
         */
        speedo.addObserver(monitor);

        speedo.setCurrentSpeed(50);
        speedo.setCurrentSpeed(70);
        speedo.setCurrentSpeed(40);
        speedo.setCurrentSpeed(100);
        speedo.setCurrentSpeed(69);
        speedo.setCurrentSpeed(71);
    }
}
