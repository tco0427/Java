/*
Lab7
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/26
 */

//PeriodicElement를 상속하고 추상메소드 print()를 오버라이딩을 통해 구현한 구상클래스(Concrete Class)
//UnknownPeriodicElement is a PreiodicElement(is-a 관계)
public class UnknownPeriodicElement extends PeriodicElement {
    public UnknownPeriodicElement(int number, String symbol, String name, double weight){
        //super()를 통해 명시적으로 상위클래스의 생성자를 호출하며 매개변수로 전달받은 값과 함께 State.UNKNOWN를 인자로 전달한다.
        super(number,symbol,name,weight,State.UNKNOWN);
    }
    //PeriodicElement를 구현한 각 클래스에 맞게끔 toString()과 print()를 오버라이딩하였고
    //이를 통해 동일한 메소드호출 print(),toString()을 하더라도 각 객체에 따라서 다르게 동작하도록 다형성을 실현하였다.


    //상위클래스에 매개변수를 전달 받지 않는 생성자 정의해두었다. 그리고 이 생성자에서는 0,"",State.UNKNOWN과 같은 정해지지 않았다는 의미의 값들을(null에 해당하는..실제로 null은 아니지만..)
    //오버로딩을 통해 작성된 또 다른 생성자를 this()를 통해 호출하고 인자로 전달한다.
    //따라서 UnknownPeriodicElement에 상위클래스의 매개변수를 전달받지않고 state를 State.UNKNOWN으로 하는 생성자를 super()를 통해 호출하는 생성자를 추가로 정의하였다.(오버로딩)
    public UnknownPeriodicElement(){
        super();
    }
    @Override
    public String toString() {
        return "UnknownPeriodicElement{" +
                "number=" + number +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", state=" + state +
                '}';
    }
    @Override
    public void print(){
        System.out.println("UnknownPeriodicElement");
        System.out.println("number=" +this.number);
        System.out.println("symbol="+this.symbol);
        System.out.println("name="+this.name);
        System.out.println("weight="+this.weight);
        System.out.println("state="+this.state);
    }
}
