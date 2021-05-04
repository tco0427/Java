/*
Lab7
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/26
 */

//PeriodicElementFinder를 상속하고 추상메소드 isInstanceOf()를 오버라이딩을 통해 구현한 구상클래스(Concrete Class)
public class LiquidPeriodicElementFinder extends PeriodicElementFinder {
    //PeriodicElementFinder를 구현한 각 클래스에 맞게끔 isInstanceOf()를 오버라이딩하고 있다.
    //이를 통해 동일한 메소드호출 isInstaceOf()을 하더라도 각 객체에 따라서 다르게 동작하도록 다형성을 실현하였다.
    @Override
    //메소드의 가시성을 하위클래스에서 확장은 가능하다(즉, protected접근지정자로 된 상위클래스의 isInstanceOf를 하위클래스에서 public으로 하는 것은 가능하다.)
    //하지만 상위클래스의 visibility를 하위클래스에서 reduce할 수는 없다. 따라서 isInstanceOf의 경우 protected 또는 public접근지정자만이 가능하다.
    protected boolean isInstanceOf(PeriodicElement e){
        //매개변수 PeriodicElement형 e로 참조하는 인자로 전달된 인스턴스가 LiquidPeriodicElement인스턴스 이거나 LiquidPeriodicElement를 상속하는 인스턴스이면 true를, 아니면 false를 반환한다.
        if(e instanceof LiquidPeriodicElement)
            return true;
        else
            return false;
    }
}
