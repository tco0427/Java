/*
Lab8
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/06/07
 */

//다음의 클래스(IPeriodicElementFinder)가 소속될 패키지 명을 다음과 같이 package키워드를 이용하여 소스파일의 첫 줄에 선언해주었다.
package dao;

//dto패키지의 PeriodicElement클래스를 import한다.
//이를 통해 컴파일러에게 그 클래스의 경로명을 알려주게 되고, 클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
import dto.PeriodicElement;
//import문을 통해 java.util.function패키지의 Predicate클래스를 import한다.
import java.util.function.Predicate;

//인터페이스 IPeriodicElementFinder를 선언하였다.
public interface IPeriodicElementFinder {
    //다음의 추상 메소드들에는 접근지정자(public)과 abstract선언이 생략되어 있다.
    //하지만 인터페이스에 정의한 메소드는 묵시적으로 public과 abstract가 선언된 것으로 간주한다.
    PeriodicElement findElement(Predicate<PeriodicElement> predicate);
    PeriodicElement[] findElements(Predicate<PeriodicElement> predicate);

}
