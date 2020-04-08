import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PeriodicElement {
    private int number;
    private String symbol;
    private String name;
    private double weight;
    public PeriodicElement(int number,String symbol,String name,double weight){
        this.number=number;
        this.symbol=symbol;
        this.name=name;
        this.weight=weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    //Object클래스로부터 상속받은 toString()메소드를 오버라이딩(재정의)한다.
    @Override
    public String toString() {
        return "PeriodicElement{" +
                "number=" + number +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }


    public static State getState(PeriodicElement element){
        //gas와solid의 번호가 불규칙하고 많으므로 배열을 생성하여 getState메소드에서 활용하겠다.
        List<Integer> gasNumber= Arrays.asList(1,2,7,8,9,10,17,18,36,54,86);
        List<Integer> liquidNumber=Arrays.asList(35,80);
        gasNumber=new ArrayList<>(gasNumber);
        liquidNumber=new ArrayList<>(liquidNumber);

        if(element.number<=0||element.number>118){
            System.out.println("잘못된 원소번호입니다.");
            System.out.println("상태를 알 수 없습니다.");
            return State.UNKOWN;
        }
        else if(gasNumber.contains(element.number)){
            return State.GAS;
        }
        else if(liquidNumber.contains(element.number)){
            return State.LIQUID;
        }
        else if(104<=element.number&&element.number<=104){
            return State.UNKOWN;
        }
        else{
            return State.SOLID;
        }
    }
    public static PeriodicElement parsePeriodicElement(String line){
        PeriodicElement element=null;
        StringTokenizer st=new StringTokenizer(line," ");
        try {
            element = new PeriodicElement(Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()));
        }catch(Exception e){
            System.out.println("잘못된 입력이 존재합니다. 입력양식을 확인해주세요");
        }
        return element;
    }
}