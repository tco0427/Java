/*
Lab6
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/18
 */

//상태(State)에 맞는 PeriodicElement를 생성하여 반환하여주는 클래스
//Simple Factory(간단한 팩토리)를 이용했다고 할 수 있다.
//간단한 팩토리를 팩토리 패턴이라고 하기도 하지만 이는 어떠한 디자인 패턴이라고 보기보다는 프로그래밍에 자주 쓰이는 관용구에 가깝다고 볼 수 있다.
public class PeriodicElementFactory {
    //인스턴스 생성이 목적이 아닌 클래스(외부에 기능 제공)
    //이 클래스의 메소드는 모두 public과 static으로 선언되었다.(생성자 메소드 제외)
    //public으로 선언되었으므로 이 클래스 이외의 영역에서 모두 접근이 가능하며
    //static으로 선언되었으므로 인스턴스 생성과 무관하게 접근이 가능하다.
    //또한 생성자에 대해서 private 접근 지정자를 통해 PeriodicElementFactory클래스 외부에서의 생성자호출을 제한하고 있다.
    //즉 PeriodicElementFactory클래스에 대해 인스턴스 생성이 불가능하다.
    private PeriodicElementFactory(){}

    //반환형이 PeriodicElement이기 때문에 이를 상속하는 클래스는 모두 반환가능하다.(상속을 통한 다형성을 실현했다고 볼 수 있다.)
    public static PeriodicElement getInstance(int number, String symbol, String name,double weight,State state){
        PeriodicElement element=null;
        if(state==State.GAS){
            element=new GasPeriodicElement(number,symbol,name,weight);
        }else if(state==State.SOLID){
            element=new SolidPeriodicElement(number,symbol,name,weight);
        }else if(state==State.LIQUID){
            element=new LiquidPeriodicElement(number,symbol,name,weight);
        }else if(state==State.UNKNOWN){
            element=new UnknownPeriodicElement(number,symbol,name,weight);
        }
        //만약 다중 if-else문에서 element가 적절한 인스턴스를 참조하는 경우가 발생하지 않는다면 처음에 할당한 null이 반환되게 된다.
        return element;
    }
}
