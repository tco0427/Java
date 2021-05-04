/*
Lab7
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/26
 */

//상태(State)에 맞는 IPeriodicElementFinder의 구상클래스의 인스턴스를 생성하여 반환하여주는 클래스
//Simple Factory(간단한 팩토리)를 이용했다고 할 수 있다.
//간단한 팩토리를 팩토리 패턴이라고 하기도 하지만 이는 어떠한 디자인 패턴이라고 보기보다는 프로그래밍에 자주 쓰이는 관용구에 가깝다고 볼 수 있다.
public class IPeriodicElementFinderFactory {
    //인스턴스 생성이 목적이 아닌 클래스(외부에 기능 제공)
    //이 클래스의 메소드는 모두 public과 static으로 선언되었다.(생성자 메소드 제외)
    //public으로 선언되었으므로 이 클래스 이외의 영역에서 모두 접근이 가능하며
    //static으로 선언되었으므로 인스턴스 생성과 무관하게 접근이 가능하다.
    //또한 생성자에 대해서 private 접근 지정자를 통해 IPeriodicElementFinderFactory클래스 외부에서의 생성자호출을 제한하고 있다.
    private IPeriodicElementFinderFactory(){}

    //반환형이 IPeriodicElementFinder이기 때문에 이를 상속하는 클래스는 모두 반환가능하다.(상속을 통한 다형성을 실현했다고 볼 수 있다.)
    public static IPeriodicElementFinder getInstance(State state){
        IPeriodicElementFinder finder=null;
        //다중 if-else문을 이용하여 인자를 통해 전달받은 state에 따라서 해당되는 인스턴스를 finder가 참조하도록한다.
        if(state==State.GAS){
            finder=new IGasPeriodicElementFinder();
        }else if(state==State.SOLID){
            finder=new ISolidPeriodicElementFinder();
        }else if(state==State.LIQUID){
            finder=new ILiquidPeriodicElementFinder();
        }else if(state==State.UNKNOWN){
            finder=new IUnknownPeriodicElementFinder();
        }
        //만약 다중 if-else문에서 element가 적절한 인스턴스를 참조하는 경우가 발생하지 않는다면 처음에 할당한 null이 반환되게 된다.
        return finder;
    }
}
