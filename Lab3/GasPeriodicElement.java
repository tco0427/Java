/*
Lab5
2020/05/01
32180472 김동규
 */

//PeriodicElement를 상속하고 추상메소드 print()를 오버라이딩을 통해 구현한 구상클래스(Concrete Class)
//GasPeriodicElement is a PreiodicElement(is-a 관계)
public class GasPeriodicElement extends PeriodicElement {
    public GasPeriodicElement(int number,String symbol,String name,double weight){
        //super()를 통해 명시적으로 상위클래스의 생성자를 호출하며 매개변수로 전달받은 값과 함께 State.GAS를 인자로 전달한다.
        super(number,symbol,name,weight,State.GAS);
    }
    //PeriodicElement를 구현한 각 클래스에 맞게끔 toString()과 print()를 오버라이딩하였고
    //이를 통해 동일한 메소드호출 print(),toString()을 하더라도 각 객체에 따라서 다르게 동작하도록 다형성을 실현하였다.

    @Override
    public String toString() {
        return "GasPeriodicElement{" +
                "number=" + number +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", state=" + state +
                '}';
    }
    @Override
    public void print(){
        System.out.println("GasPeriodicElement");
        System.out.println("number=" +this.number);
        System.out.println("symbol="+this.symbol);
        System.out.println("name="+this.name);
        System.out.println("weight="+this.weight);
        System.out.println("state="+this.state);
        System.out.println();
    }
}
