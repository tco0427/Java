/*
Lab8
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/06/07
 */

//다음의 열거형(Type)이 소속될 패키지 명을 다음과 같이 package키워드를 이용하여 소스파일의 첫 줄에 선언해주었다.
package dto;

//원소의 타입을 나타내기 위해 정의한 Type열거형
public enum Type {
    //열거형 값 하나하나가 모두 Type객체라고 볼 수 있다.
    //따라서 이는 static final dto.Type ACINIDE=new dto.ACTINIDE(1); 과 같은것이다.
    //그러므로 생성자에 해당하는 값 value를 전달해주어야하며 GAS(1)과 같이 선언한 이유가 그것이다.

    ACTINIDE(1),
    ALKALI_METAL(2),
    ALKALINE_EARTH_METAL(3),
    HOLOGEN(4),
    LANTHANIDE(5),
    METALLOID(6),
    METAL(7),
    NOBLE_GAS(8),
    NONMETAL(9),
    TRANSACTINIDE(10),
    TRANSITION_METAL(11);

    /*
        //보통 enum Excample(a,b,c)와 같이 생성자를 통해 열거형 상수의 값을 지정하지 않고 선언하기도 한다.
        //하지만 Enum클래스에 정의된 ordinal()이 열거형 상수가 정의된 단순히 순서만을 나타내지 이 값을 실제 열거형 상수의 값으로 사용하지 않는 것이 좋다.
        //단순히 내부적인 용도로만 사용되기 때문이다.
        //따라서 다음과 같이 인스턴스 변수와 생성자를 추가로 작성하여 열거형상수의 값을 지정해주도록 하였다.
    */
    //열거형의 인스턴스 변수는 반드시 final이어야 한다는 제약은 없지만 value는 열거형 상수의 값을 저장하기 위한 용도이므로 fianl을 붙였다.
    private final int value;
    //열거형의 생성자는 제어자가 묵시적으로 private이기 때문에 생략하였다.
    Type(int value){
        this.value=value;
    }
    //private로 선언된 열거형의 인스턴스변수를 외부에서 접근하기 위해 public으로 선언된 getValue()를 정의하였다.
    public int getValue(){
        return this.value;
    }
}
