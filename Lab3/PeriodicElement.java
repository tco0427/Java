
//PeriodicElement클래스에서 사용할 다양한 클래스들을 import시켰다.
//java.util패키지로 묶여있는 Arrays,List,ArrayList,StringTokenizer클래스들
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;


//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
public class PeriodicElement {
    /*
    PerdiodicElement의 인스턴스 변수들이다.
    모두 private로 선언되었으므로 클래스 내부에서만 접근이 가능하며
    이 필드(인스턴스 변수)들에 대한 접근을 위해 접근자와 설정자를 아래에 각각 정의해두었다.
     */
    /*
    객체 지향 특성을 살리기 위해서는 캡슐화 원칙을 지키는 것이 좋고 이를 위해 가능하면 필드에 대해서
    private선언을 하고 접근자와 설정자를 통해 접근할 수 있도록 하는 것이 좋다.
     */
    private int number;
    private String symbol;
    private String name;
    private double weight;
    //State열거형을 참조하는 참조변수이자 인스턴스 변수(멤버 변수)를 state라는 이름으로 추가
    private State state;
    /*
    PeriodicElement의 생성자를 정의하였다.
    이 때, PeriodicElement를 생성하는 과정에서 필드들(인스턴스변수들)에 대한 값을 정의하지 않을 수도 있기 때문에
    매개변수가없는 생성자를 오버로딩해두었다.
    또 매개변수가 없는 생성자에서는 this를 통해 다른 생성자를 호출하는데 0혹은""과 같은 null로 취급할 수 있는
    (실제로 null은 아니지만)(아무것도 정의되어있지 않다는것을 알 수 있으므로)
    값들을 전달한다.
     */

    //매개변수를 전달 받지 않는 생성자 정의, 이 생성자에서는 0,"",State.UNKOWN과 같은 정해지지 않았다는 의미의 값들을(null에 해당하는..)
    //오버로딩을 통해 작성된 또 다른 생성자를 this()를 통해 호출하고 이 값들을 인자로 전달한다.
    public PeriodicElement(){
        this(0,"","",0,State.UNKOWN);
    }

    //this를 통해 객체 자신의 대한 참조 즉, 예를들어 매개변수 number가 아닌 인스턴스변수 number라는 것을 명시해준다.
    //생성자(메소드)안에서 동일이름의 매개변수는 인스턴스변수의 가시성을 가린다고 볼 수 있다.
    //즉, 동일한 변수명의 인스턴스변수 혹은 static변수 (필드)보다 지역변수(매개변수 혹은 메소드내에서 선언된 변수의 가기성이 더 높다.)

    //멤버 변수(인스턴스 변수)를 추가함에 따라 생성자 수정(state를 매개변수로 받고 이를 통해 인스턴스변수(this.state)를 초기화하도록 변경)
    public PeriodicElement(int number,String symbol,String name,double weight,State state){
        this.number=number;
        this.symbol=symbol;
        this.name=name;
        this.weight=weight;
        this.state=state;
    }


    //인스턴스 변수 state에 대한 접근자와 설정자(Setter and Getter)메소드 정의
    public State getState() {return state; }
    public void setState(State state) {this.state = state;}
    //이후 8개의 메소드들은 인스턴스변수(필드)에 대한 접근자와 설정자들이다.
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


    /*
    Object클래스로부터 상속받은 toString()메소드를 오버라이딩(재정의)한다.
    System.out.println()의 인자로 인스턴스를 참조하는 참조변수 전달시 해당 인스턴스의 toString()호출로 이어진다.
    모든 클래스는 Object를 상속하므로 이를 오버라이딩하지 않으면 Object에 정의되어있는
    public String toString(){return getClass().getName()+"@"+Integer.toHexString(hashCode());}
    가 호출되게 된다.
     */

    //어노테이션은 자바 컴파일러에게 메시지를 전달하는 목적의 메모로 볼 수 있는데(메타데이터)
    //@Override를 통하여 오버라이딩이 제대로 이루어졌는지 컴파일과정에서 발견가능하다.(개발자의 실수를 잡아냄)
    //스프링 프레임워크등에서 특수 기능을 위해 사용하므로 어노테이션에 익숙해지는 것이 좋다고 생각한다.

    //인스턴스 변수를 추가해줌에 따라 toString()또한 수정해주었다.
    @Override
    public String toString() {
        return "PeriodicElement{" +
                "number=" + number +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", state=" + state +
                '}';
    }

    //toString()메소드에서는 문자열 한 줄을 반환하기 때문에
    //PeriodicElement의 정보를 한줄씩(인스턴스 변수 하나당 한줄씩) 출력하는 인스턴스 메소드로 정의
    //인스턴스 변수 정보를 출력하는 것이기 때문에 인스턴스에 종속적인 메소드로 정의하는 것이 옳다고 생각되어 Non-Static으로 정의하였습니다.
    //인스턴스를 통해 메소드 접근이 가능하다.
    public void print(){
        System.out.println("<Periodic Elemenet Information>");
        System.out.println("number=" +this.number);
        System.out.println("symbol="+this.symbol);
        System.out.println("name="+this.name);
        System.out.println("weight="+this.weight);
        System.out.println("state="+this.state);
    }

    //Lab4에서는 PeriodicElement의 필드를 통해 State를 저장하므로 즉 PeriodicElement가 State속성을 포함하기 때문에 다음 메소드를 주석처리하였다.
    /*

        //public static으로 정의되어 다른 패키지의 클래스에서도 접근이 가능하며 static으로 정의되었으므로 클래스 로딩시점에 정적으로 바인딩된다.
        //따라서 인스턴스에 종속되지 않으며 외부에 메소드의 기능을 제공할 목적으로 정의했다고 볼 수 있다.
        //매개변수로 받은 element에 해당하는 상태(State열거형 상수)를 반환해주는 기능을 하는 메소드이다.

    public static State getState(PeriodicElement element){
        //gas와solid의 번호가 불규칙하고 많으므로 컬렉션인스턴스를 생성하여 getState메소드에서 활용하겠다.
        //Arrays.asList를 통하여 ArrayList객체를 선언과 동시에 초기화하여 생성하였고 이를 List<Integer>형 참조변수로 참조하였다.
        //List<Integer>이기 때문에 Integer형 인스턴스만 저장할 수 있다.(제네릭 개념)
        //여기서 Integer인스턴스를 저장해야함에도 불구하고 1,2와 같은 리터럴을 사용할 수 잇는 이유는
        //내부적으로 '오토박싱'과 '오토언박싱'작업이 이루어지기 때문이다.
        //즉 자동으로 박싱과 언박싱 작업(Wrapper->Primitive,Primitive->Wrapper)을 수행한다.
        List<Integer> gasNumber= Arrays.asList(1,2,7,8,9,10,17,18,36,54,86);
        List<Integer> liquidNumber=Arrays.asList(35,80);
        gasNumber=new ArrayList<>(gasNumber);
        liquidNumber=new ArrayList<>(liquidNumber);


        //주기율표의 번호는 1부터 118까지 이므로 이 원소번호를 벗어나는 경우 잘못되었음을 알리고
        //UNKOWN을 반환해주자(존재하지않는 주기율표원소의 상태는 모르는 것이나 다름없기 때문에 이렇게 처리하였다.)
        //PeriodicElement의 getNumber()를 통해 element인스턴스 변수를 반환하여 값을 비교한다.
        if(element.getNumber()<=0||element.getNumber()>118){
            System.out.println("잘못된 원소번호입니다.");
            System.out.println("상태를 알 수 없습니다.");
            return State.UNKOWN;
        }
        //element.getNumber()를 통해 반환되는 인스턴스 변수 number가 gasNumber컬렉션 인스턴스(ArrayList)가 저장하고 있는 인스턴스들(Integer) 중에 일치하는 값이 존재하면 State.GAS반환
        //오토 박싱,오토 언박싱 수행
        else if(gasNumber.contains(element.getNumber())){
            return State.GAS;
        }
        //마찬가지로 element.getNumber()를 통해 반환되는 인스턴스 변수 number가 liquidNumber컬렉션 인스턴스가 저장하고 있는 인스턴스들 중 일치하는 값이 존재하면 State.LIQUID반환
        else if(liquidNumber.contains(element.getNumber())){
            return State.LIQUID;
        }
        //주기율표의 원소번호(element.getNumber()를 통해 반환되는 인스턴스 변수 number)의 값이 104~118사이이면 UNKOWN을 반환한다.
        else if(104<=element.getNumber()&&element.getNumber()<=118){
            return State.UNKOWN;
        }
        //이외에는 모두 SOLID를 반환한다.
        else{
            return State.SOLID;
        }
    }


     */
    //String[]형태를 매개변수로 받기위한 메소드로 PeriodicElement parsePeriodicElement(String line)메소드와 오버로딩 관계이다.
    public static PeriodicElement parsePeriodicElement(String[] strArray){
        PeriodicElement element=null;
        //원소의 정보(number,name,symbol,weight,state)총 5개 이므로
        //이보다 적은 정보를 전달받거나 혹은 더 많은 정보를 전달받았을 시에는 잘못된 입력(양식을지키지 않은)경우 이므로
        //사용자에게 잘못되었음을 알리고 null을 반환하도록 한다.
        if(strArray.length!=5){
            System.out.println("잘못된 입력이 존재합니다. 입력양식을 지켜주세요");
            return null;
        }
        //NumberFormatException과 State.valueOf()로 인한 IllegalArgumentException을 둘 다 한번에 처리하기 위하여 이 두 예외클래스가 상속하는
        //Exception클래스를 통해 두 가지 예외 상황에 대하여 동일하게 예외를 처리하도록 하였다.
        //catch구문으로 실행흐름이 이어지면 가상머신은 프로그램을 종료시키지 않고, 예외가 처리된것으로 간주하여 프로그램실행흐름을 이어나간다.
        try {
            //NumberFormatException예외 발생 가능성 존재(Integer.parseInt(strArray[0]))
            int number=Integer.parseInt(strArray[0]);
            if(number<=0){
                System.out.println("주기율표의 원소번호는 1부터 시작입니다.");
                //return은 메소드를 호출한 영역으로 값을 반환한다는 의미도 지니지만
                //메소드의 종료를 의미하기도 한다.
                //따라서 메소드 중간에서 return문이 실행되면 값이 반환되면서(혹은 값의반환없이) 메소드의 실행은 종료된다.
                return null;
            }
            //PeriodicElement클래스의 생성자 변경에 따라 parsePeriodicElement내부에서의 PeriodicElement생성시에도 인자전달에 변경이 발생(인스턴스변수 state에 해당하는 내용 추가로 전달)
            //이 때 열거형 State에 정의되어 있는 valueOf메소드 strArray[4].toUpperCase()이 반환하는 String을 전달한다.(문자열을의 모든 문자를 대문자로 바꾼다.)
            //nameOf를 사용하여도 되지만 nameOf의 경우 "GAS"와 같은 입력 혹은 "1"와 같은 State열거형의 인스턴스 변수value값을 통한 입력 둘 다 캐치 가능하기 때문에 메소드의 의도와는 맞지 않기 때문에
            //nameOf사용을 지양하고 valueOf(String)사용을 지향한다.
            element = new PeriodicElement(number, strArray[1], strArray[2], Double.parseDouble(strArray[3]), State.valueOf(strArray[4].toUpperCase()));
        }catch(Exception e){
            //try문에서 예외가 발생시 catch문으로 실행흐름이 이어지고 컴파일러는 예외가 처리된것으로 간주하고 프로그램의 실행흐름을 이어나간다.
            //이에 대한 내용을 사용자에게 알리고 null을 반환
            System.out.println("잘못된 입력이 존재합니다. 입력양식을 지켜주세요.");
            return null;
        }
        return element;
    }
    //문자열을 한줄로 입력받아 이를 공백으로 분리해 PeriodicElement인스턴스를 생성해 반환하는 기능을 하는 메소드이다.
    public static PeriodicElement parsePeriodicElement(String line){
        PeriodicElement element=null;
        //특정 기준을 가지고 문자열을 나눌 때 사용하기 편리한 StringTokenizer클래스를 이용하여 문자열(String)을 분리하려고한다.
        //StringTokenizer생성자에 인자로 나눌 문자열을 전달하고 구분자 즉, 문자열 분리의 기준을 전달한다.(" ")
        StringTokenizer st=new StringTokenizer(line," ");


        //try-catch구문에서 문자열을 기본자료형으로 변환하는 과정에서 발생할 수 있는 예외(NumberFormatException), 혹시나 nextToken()에서 발생할 수 있는
        //NoSuchElementException예외 (사용자가 입력을 양식보다(요구되는 입력보다) 적게하여 발생할 수 있다.)
        //PeriodicElement를 생성하는 과정에서(new를 통해) State.valueOf()가 IllegalArgumentException을 발생할 수 있다. 이들을 잡기위하여
        //모든 예외가 상속하는(Error를 포함한 이를 상속하는 예외 제외) Exception으로 catch문을 구현하였다.
        //catch구문으로 실행흐름이 이어지면 가상머신은 예외가 처리된것으로 간주하고 실행흐름을 이어나간다.
        try {
            //많은 예외상황이 있겠지만 원소번호가 0보다 작거나 같은경우에 대한 예외처리를 if구문을 통해서 하였다.
            //문자열에서 첫번째로 구분된 토근(문자열 조각)을 int형으로 반환한다.
            int number=Integer.parseInt(st.nextToken());
            if(number<=0){
                System.out.println("주기율표의 원소번호는 1부터 시작입니다.");
                //return은 메소드를 호출한 영역으로 값을 반환한다는 의미도 지니지만
                //메소드의 종료를 의미하기도 한다.
                //따라서 메소드 중간에서 return문이 실행되면 값이 반환되면서(혹은 값의반환없이) 메소드의 실행은 종료된다.
                return null;
            }
            //PeriodicElement클래스의 생성자 변경에 따라 parsePeriodicElement내부에서의 PeriodicElement생성시에도 인자전달에 변경이 발생(인스턴스변수 state에 해당하는 내용 추가로 전달)
            //이 때 열거형 State에 정의되어 있는 valueOf메소드에 st.nextToken()이 반환하는 String을 toUpperCase()를 통해 문자열의 모든 문자를 대문자로 바꾼다.
            //nameOf를 사용하여도 되지만 nameOf의 경우 "GAS"와 같은 입력 혹은 "1"와 같은 State열거형의 인스턴스 변수value값을 통한 입력 둘 다 캐치 가능하기 때문에 메소드의 의도와는 맞지 않기 때문에
            //nameOf사용을 지양하고 valueOf(String)사용을 지향한다.
            //Enum의 valueOf메소드는 다음과 같이 정의되어 있다. 제네릭과 같은 문법적인 내용을 제외하고
            //메소드의 기능을 위주로 간단히 요약하면 인자로 받은 name과 일치하는 열거형상수이름이 없을 경우 IllegalArgumentException 예외 인스턴스를 생성하여 호출한 영역으로 넘긴다.
            /*
            public static <T extends Enum<T>> T valueOf(Class<T> enumType,
                                                String name) {
            T result = enumType.enumConstantDirectory().get(name);
            if (result != null)
                return result;
            if (name == null)
                throw new NullPointerException("Name is null");
            throw new IllegalArgumentException(
                "No enum constant " + enumType.getCanonicalName() + "." + name);
            }
             */
            element = new PeriodicElement(number, st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()),State.valueOf(st.nextToken().toUpperCase()));
            //만약 StringTokenizer의 hasMoreToekns()의 반환값이 참이면 반환할 토큰이 남아있다는 것을 의미하고
            //이는 곧 요구된 양식대로의 입력이 아닌 추가적인 입력이 존재한다는 뜻으로 잘못된입력이므로
            //throw new Exception()을 통해 예외 인스턴스를 생성하고 이를 catch구문에 전달하게끔 하였다.
            if(st.hasMoreTokens()){
                throw new Exception();
            }
        }catch(Exception e){
            //try문에서 예외가 발생시 catch문으로 실행흐름이 이어지고 컴파일러는 예외가 처리된것으로 간주하고 프로그램의 실행흐름을 이어나간다.
            //이에대한 내용을 사용자에게 알리고 null을 반환
            System.out.println("잘못된 입력이 존재합니다. 입력양식을 확인해주세요");
            return null;
        }

        //실행흐름이 catch문으로 흘러가게 되었을 경우에는 처음의 element=null이므로 null이 반환되고 정상적인 입력일 경우에만 new PeriodicElement를 통해
        //PeriodicElement인스턴스가 반환된다.
        return element;
    }
}