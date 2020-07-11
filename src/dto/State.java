/*
Lab8
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/06/07
 */
//다음의 열거형(State)이 소속될 패키지 명을 다음과 같이 package키워드를 이용하여 소스파일의 첫 줄에 선언해주었다.
package dto;

public enum State {
    //열거형 값 하나하나가 모두 State객체라고 볼 수 있다.
    //따라서 이는 static final dto.State GAS=new dto.State(1); 과 같은것이다.
    //그러므로 생성자에 해당하는 값 value를 전달해주어야하며 GAS(1)과 같이 선언한 이유가 그것이다.
    GAS(1),
    SOLID(2),
    LIQUID(3),
    UNKNOWN(4);

    /*
        //보통 enum Excample(a,b,c)와 같이 생성자를 통해 열거형 상수의 값을 지정하지 않고 선언하기도 한다.
        //하지만 Enum클래스에 정의된 ordinal()이 열거형 상수가 정의된 단순히 순서만을 나타내지 이 값을 실제 열거형 상수의 값으로 사용하지 않는 것이 좋다.
        //단순히 내부적인 용도로만 사용되기 때문이다.
        //따라서 다음과 같이 인스턴스 변수와 생성자를 추가로 작성하여 열거형상수의 값을 지정해주도록 하였다.
    */

    //열거형의 인스턴스 변수는 반드시 final이어야 한다는 제약은 없지만 value는 열거형 상수의 값을 저장하기 위한 용도이므로 fianl을 붙였다.
    private final int value;
    //열거형의 생성자는 제어자가 묵시적으로 private이기 때문에 생략하였다.
    State(int value){
        this.value=value;
    }
    //private로 선언된 열거형의 인스턴스변수를 외부에서 접근하기 위해 public으로 선언된 getValue()를 정의하였다.
    public int getValue(){
        return this.value;
    }

    /*
    Element열거형에서와 동일한 기능을 하는 valueOf,nameOf,names메소드들을 정의하였고,
    구현 내용도 동일하다고 볼 수 있기 때문에 주석을 통한 코드설명은 생략하겠다.
     */

    public static State valueOf(int value){
        for(State state: State.values()){
            if(state.getValue()==value){
                return state;
            }
        }
        return null;
    }
    public static State nameOf(String name){
        for(State state:State.values()){
            try {
                if ((String.valueOf(state.getValue()).equals(name)) || state == State.valueOf(name)) {
                    return state;
                }
            }catch(IllegalArgumentException e){}
        }
        return null;
    }
    public static String[] names(){
        String names[]=new String[State.values().length];
        for(State state: State.values()){
            names[state.ordinal()]=state.toString();
        }
        return names;
    }
}
