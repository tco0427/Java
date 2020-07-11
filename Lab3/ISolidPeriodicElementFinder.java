/*
Lab6
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/18
 */

//IPeriodicElementFinder인터페이스를 구현하고 추상메소드 isInstanceOf()를 오버라이딩을 통해 구현한 구상클래스(Concrete Class)
public class ISolidPeriodicElementFinder implements IPeriodicElementFinder {

    //PeriodicElementFinder를 구현한 각 클래스에 맞게끔 isInstanceOf()를 오버라이딩하고 있다.
    //이를 통해 동일한 메소드호출 isInstaceOf()을 하더라도 각 객체에 따라서 다르게 동작하도록 다형성을 실현하였다.
    @Override
    public boolean isInstanceOf(PeriodicElement e){
        //매개변수 PeriodicElement형 e로 참조하는 인자로 전달된 인스턴스가 SolidPeriodicElement인스턴스 이거나 SolidPeriodicElement를 상속하는 인스턴스이면 true를, 아니면 false를 반환한다.
        if(e instanceof SolidPeriodicElement)
            return true;
        else
            return false;
    }
}
