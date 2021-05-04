/*
Lab7
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/26
 */

//PeriodicElement클래스에서 사용할 (java.util패키지에 들어있는)StringTokenizer클래스를 import시켰다.
import java.util.StringTokenizer;


//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
//abstract키워드를 통해 PeriodicElement를 추상클래스로 선언하였고
//abstract키워드와 함께 메소드의 선언부만을 작성한 print()추상메소드를 가진다.
//추상클래스인 PeriodicElement를 대상으로 한 인스턴스의 생성이 불가능하다.(물론 PeriodicElement형 참조변수는 선언 가능하다.)
//이를 상속하여 오버라이딩을 통해 추상메소드를 모두 구현한 구상클래스(concrete class)를 대상으로만 인스턴스 생성이 가능하다.
//PeriodicElement는 Comparable<T>인터페이스를 구현한다.(기존의 Comparable인터페이스에서, 자바에 제네릭(generic)이 도입되면서 Comparable<T>인터페이스로 수정되었다.)
//Comparable<T>인터페이스를 구현할 때 정의해야 할 추상메소드는 int compareTo(T o)이다.
//따라서 PeriodicElement추상클래스에서는 int compareTo(T o)의 구현부를 제공한다.
//(물론 PeriodicElement는 추상클래스이므로 이를 구현하지 않고, public abstract int compareTo(PeriodicElement other); 다음과 같이 할 수 있다.
//하지만 이는 PeriodicElement의 구상클래스들에서 모두 공통되므로 PeriodicElement에서 구현하도록 하였다.
//Comparable<T>의 타입매개변수T를 PeriodicElement로 하였다.
//이러한 제네릭으로 인해 불필요한 타입변환(cast)와 자료형과 관련된 프로그래머의 실수가 컴파일과정에서 드러나도록 하는 이점을 얻을 수 있었다. 또 ClassCastException을 방지할 수 있다.
public abstract class PeriodicElement implements Comparable<PeriodicElement>{
    /*
    객체 지향 특성을 살리기 위해서는 캡슐화 원칙을 지키는 것이 좋고 이를 위해 가능하면 필드에 대해서 접근 범위를 작게하는 것이 좋다.
    PeriodicElement는 추상클래스이므로 이를 상속하는 구상클래스에서 이 필드에 접근 가능해야하므로 protected로 선언해주었다.
    이 필드(인스턴스 변수)들에 대한 접근을 위해 접근자와 설정자를 아래에 각각 정의해두었다.
     */
    protected int number;
    protected String symbol;
    protected String name;
    protected double weight;
    protected State state;

    /*
    PeriodicElement의 생성자를 정의하였다.
    물론 추상클래스로 정의되어 있는 PeriodicElement를 대상으로 인스턴스를 생성할 수는 없지만 하위클래스에서 super를 통해 호출이 가능하다.
     */

    //매개변수를 전달 받지 않는 생성자 정의, 이 생성자에서는 0,"",State.UNKNOWN과 같은 정해지지 않았다는 의미의 값들을(null에 해당하는..실제로 null은 아니지만..)
    //오버로딩을 통해 작성된 또 다른 생성자를 this()를 통해 호출하고 이 값들을 인자로 전달한다.
    //PeriodicElement를 추상클래스로 정의하고 인스턴스 생성시 PeriodicElementFactory를 이용함으로써 이를 활용할 경우는 없다고 판단되지만 그래도 이후 업데이트에서 필요하게 될지도 모르기 때문에 우선은 그냥 두겠다.
    protected PeriodicElement(){
        this(0,"","",0, State.UNKNOWN);
    }

    //this를 통해 객체 자신의 대한 참조 즉, 예를들어 매개변수 number가 아닌 인스턴스변수 number라는 것을 명시해준다.
    //생성자(메소드)안에서 동일이름의 매개변수(지역변수)는 인스턴스변수의 가시성을 가린다고 볼 수 있다.
    //즉, 생성자 내부에서 동일한 변수명의 인스턴스변수 혹은 static변수 (필드)보다 지역변수(매개변수 혹은 메소드내에서 선언된 변수)의 가기성이 더 높다.


    //생성자에 대해서 public이 아닌 protected로 정의한 이유는 추상클래스에 대한 인스턴스 생성이 불가하므로 외부에서 생성자를 호출할 일이 없고 적절치도 않다.
    //또한 PeriodicElement추상클래스에 대한 생성자의 호출은 이를 구현하는 구상클래스(Concrete Class)에서 이루어지므로 protected로 접근지정자를 선언해주었다.
    protected PeriodicElement(int number,String symbol,String name,double weight,State state){
        this.number=number;
        this.symbol=symbol;
        this.name=name;
        this.weight=weight;
        this.state=state;
    }
    //이후 10개의 메소드들은 인스턴스변수(필드)에 대한 접근자와 설정자들이다.
    public State getState(){
        return state;
    }
    public void setState(State state){
        this.state=state;
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


    /*
    Object클래스로부터 상속받은 toString()메소드를 오버라이딩(재정의)한다.
    System.out.println()의 인자로 인스턴스를 참조하는 참조변수 전달시 해당 인스턴스의 toString()호출로 이어진다.
    모든 클래스는 Object를 상속하므로 이를 오버라이딩하지 않으면 Object에 정의되어있는
    public String toString(){return getClass().getName()+"@"+Integer.toHexString(hashCode());}
    가 호출되게 된다.
     */
    /*
    추가적으로 만약 이를 구현하는 구상클래스(concrete class)에서 각 클래스에 맞게끔 toString()다시 재정의할 수 있는데
    만약 그렇게 하지 않은경우 추상클래스PeriodicElement에서 Object의 toStirng()을 오버라이딩한 다음의 toString()이 호출된다.
    예를 들어 GasPeriodicElement에서 toString()을 오버라이딩하지 않았다면 현재추상클래스 PeriodicElement에 정의된 toString()이 호출된다.
     */

    //어노테이션은 자바 컴파일러에게 메시지를 전달하는 목적의 메모로 볼 수 있는데(메타데이터)
    //@Override를 통하여 오버라이딩이 제대로 이루어졌는지 컴파일과정에서 발견가능하다.(개발자의 실수를 잡아냄)
    //스프링 프레임워크등에서 특수 기능을 위해 사용하므로 어노테이션에 익숙해지는 것이 좋다고 생각한다.
    @Override
    public String toString() {
        return "PeriodicElement{" +
                "number=" + number +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    //인스턴스 정보를 출력하기 위한 메소드로 구체적인 구현은 하위클래스에서 오버라이딩을 통해 구현하도록 하였습니다.
    //인스턴스에 대한 정보(속성,필드)에 대해 출력하기 때문에 인스턴스에 종속적인 메소드로 정의하는 것이 옳고 따라서 Non-Static으로 정의
    //추상클래스(추상타입)을 상속하여 구체화하는 객체에서 이를 구현하도록 하였습니다. 이를 통해 다형성을 실현하도록 하였습니다.
    //(객체들의 타입이 다르면 똑같은 메시지가 전달되더라도 각 객체의 타입에 따라서 다르게 동작)
    //물론 PeriodicElement를 상속하더라도 이를 구현하지 않을 수 있지만 그러한 경우 상속한 클래스도 마찬가지로 추상클래스로 정의해주어야 합니다.
    public abstract void print();

    /*
    오버로딩된 두개의 parsePeriodicElement()메소드는 이를 구현하는 구상클래스(Concrete Class)들에게 공통적인 내용의 메소드들이다.
    따라서 이들에 대해 굳이 추상메소드로두어 각각의 Concrete Class들에서 이를 구현하도록 할 필요가 없기 때문에 자체로 완전한(몸체를 가지는) 메소드로 구현하였다.
    추상클래스인 PeriodicElement를 상속을 통해 구현하는 클래스의 인스턴스들에서는 아래의 메소드에 접근할 수 있다.
     */

    //String[]형태를 매개변수로 받기위한 메소드로 PeriodicElement parsePeriodicElement(String line)메소드와 오버로딩 관계이다.
    //반환형을 PeriodicElement로 둠으로써 이를 구현하는 하위클래스의 인스턴스들에 대해서 모두 반환이 가능하다.
    //즉 구현 교체의 유연함을 얻을 수 있고(이 메소드 하나로 4개 상태의 인스턴스에 대해 적용 가능)불필요하게 4개의 구상클래스에 대해 별도의 메소드를 정의할 필요도 없다.
    //또한 이후에 PeriodicElement를 구현하는 클래스가 추가되더라도 이 메소드를 적용할 수 있다.
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
            //PeriodicElementFactory클래스에 static으로 정의되어 있는 getInstance()메소드를 호출하여 State에 따른 객체를 반환하고 이를 element변수를 통해 참조한다.
            //(상위클래스의 참조변수로 하위클래스의 인스턴스를 참조할 수 있다. 또 이를 통해 element는 GasPeriodicElement,LiquidPeriodicElement등 모두 참조할 수 있다.)
            element=PeriodicElementFactory.getInstance(number,strArray[1],strArray[2],Double.parseDouble(strArray[3]),State.valueOf(strArray[4].toUpperCase()));
            //열거형 State에 정의되어 있는 valueOf메소드의 인자로 strArray[4].toUpperCase()이 반환하는 String을 전달한다.(문자열을의 모든 문자를 대문자로 바꾼다.)
            //nameOf를 사용하여도 되지만 nameOf의 경우 "GAS"와 같은 입력 혹은 "1"와 같은 State열거형의 인스턴스 변수 value값을 통한 입력 둘 다 캐치 가능하기 때문에 메소드의 의도와는 맞지 않기 때문에
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
        }catch(Exception e){
            //try문에서 예외가 발생시 catch문으로 실행흐름이 이어지고 컴파일러는 예외가 처리된것으로 간주하고 프로그램의 실행흐름을 이어나간다.
            //이에 대한 내용을 사용자에게 알리고 null을 반환
            System.out.println("잘못된 입력이 존재합니다. 입력양식을 지켜주세요.");
            return null;
        }

        //실행흐름이 catch문으로 흘러가게 되었을 경우에는 처음의 element=null이므로 null이 반환되고 정상적인 입력일 경우에만
        //PeriodicElementFactory.getInstance()를 통해 생성된 인스턴스가 반환된다.
        return element;
    }


    //문자열을 한줄로 입력받아 이를 StringTokenizer를 이용하여 공백으로 분리하고, 이에 대항하는 PeriodicElement를 구현한 인스턴스를 생성하고 반환한다.
    //반환형을 PeriodicElement로 둠으로써 이를 구현하는 하위클래스의 인스턴스들에 대해서 모두 반환이 가능핟.
    //즉 GasPeriodicElement도 반환가능하고, SolidPeriodicElement도 반환 가능하다.
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

            //PeriodicElementFactory클래스에 static으로 정의되어 있는 getInstance()메소드를 호출하여 State에 따른 객체를 반환하고 이를 element변수를 통해 참조한다.
            //(상위클래스의 참조변수로 하위클래스의 인스턴스를 참조할 수 있다. 또 이를 통해 element는 GasPeriodicElement,LiquidPeriodicElement등 모두 참조할 수 있다.)
            element= PeriodicElementFactory.getInstance(number,st.nextToken(),st.nextToken(),Double.parseDouble(st.nextToken()),State.valueOf(st.nextToken().toUpperCase()));
            //열거형 State에 정의되어 있는 valueOf메소드에 st.nextToken()이 반환하는 String을 toUpperCase()를 통해 문자열의 모든 문자를 대문자로 바꾼 후 전달한다.
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

        //실행흐름이 catch문으로 흘러가게 되었을 경우에는 처음의 element=null이므로 null이 반환되고
        //정상적인 입력일 경우에만 PeriodicElementFactory.getInstance()를 통해 생성된 인스턴스가 반환된다.
        return element;
    }

/*
    //와일드카드(?)는 어떤 타입도 가능하므로 ? 단독으로는 Object와 다를것이 없다.
    //보통 와일드카드는 제네릭 클래스의 객체를 메소드의 매개변수로 받을 때, 그 객체의 타입 변수를 제한할 때 사용한다.
    //(<? super T>: 하한제한된 와일드 카드 <? extends T>: 상한 제한된 와일드 카드)
    //(참고로 public <T> void method(A<T> a)와 public void method(A<?> a)는 동일하다.
    //(각각 제네릭 메소드의 정의와 와일드카드 기반 메소드의 정의이다.)
    //제네릭 메소드 선언 시 <T>는 반환형 앞에서 T가 타입 매개변수의 선언임을 알리기위해 한 번 한 번, 매개변수에서 한 번 총 두 번 등장하고
    //와일드카드를 이용한 예에서는 <?>가 한 번 등장한다.)
 */

    //Comparable<T>인터페이스의 추상메소드 compareTo를 오버라이딩을 통해 정의한다.
    //Arrays.sort() 혹은 Collections클래스의 sort()메소드를 통해 정렬하고자 할 때 정렬의 기준이 필요하고
    //다음의 compareTo()메소드를 오버라이딩하여야한다.
    //(따라서 PeriodicElement를 상속하는 하위의 구상클래스들은 PeriodicElement에서 오버라이딩을 통해 정의한 compareTo를 따르게 된다. 하
    //물론 하위클래스에서 compareTo()메소드를 다시 오버라이딩한다면 그 하위클래스에 대한 정렬의 기준은 바뀔 것이다.)
    //물론 Collections의 sort메소드는 매개변수가 각각
    //(List<T> list)와 (List<T> list,Comparator<? super T> c)와 같이 오버로딩되어 있어
    //정렬하려는 객체의 클래스 T가 Comparable을 구현하지 않더라도 Comparator인스턴스를 전달하여 주면 정렬가능하다.
    //(이 때 Comparator<? super T>는 와일드카드를 통한 하한제한으로 T의 상위의 클래스에 대하여 Comparator가 정의되어 있으면
    //하위클래스에서 이를 또 정의해줄 필요가 없다. 또한 T형 인스턴스를 넣는(set) 작업(전달하는 작업)만 가능하고(compare메소드의 매개변수를 위해) 이 인스턴스를 반환하는(get)작업은 불가능하다.)
    /*
    //(예시를 들어 이해를 돕도록 하겠다.
    //public static void inBox(Box<? super Toy> box,Toy n) {
    //    box.set(n);
    //    Toy myToy = box.get();
    //}다음의 메소드가 있다고 가정하자.
    //위와 같은 매개변수 선언에서 get메소드의 호출문은 컴파일 오류를 발생한다. 왜냐하면 반환형을 Toy로 결정할 수 없기 때문이다.
    //즉 get메소드 호출 자체는 문제가 되지 않으나, 반환되는 값을 저장하기 위한 참조변수의 형을 Toy로 결정할 수 없다는 것이다.
    //만약 Plastic이라는 클래스가 있고, 이를 Toy가 상속한다고 가정하자. 그리고 Box<Plastic> box가 매개변수로 전달될 수 있을 것이다.(Box<? super Toy> box이므로)
    //이 때, get()이 반환하는 것이 Plastic인스턴스이므로 문제가 된다.)
     */
    //Comparator<T>도 Comparable<T>와 마찬가지로 정렬 기준에 관한 인터페이스이다.
    //Comparator<T>를 사용하기 적절한 경우를 예시로 들어 차이점을 보이겠다.
    //만약 일시적인 정렬 기준 변경있을 때  Comparable<T>의 compareTo()메소드를 매번 수정하는 일은 적절치 않다.
    //따라서 Comparator<T>인터페이스를 구현한 클래스의 인스턴스를 통해 일시적인 정렬기준을 전달할 수 있다.
    @Override
    //Comparable<T>의 타입매개변수 T가 PeriodicElement로 결정되었으므로 compareTo(T o)의 매개변수도 PeriodicElement이다.
    public int compareTo(PeriodicElement other){
        //인자로 전달된 other가 작다면 양의정수, 크다면 음의정수, 같다면 0을 반환하도록한다.
        //그러면 이를 기반으로 저장된 인스턴스들이 정렬된 상태를 유지하게 된다.
        //다음과 같이 하여 인자로 전달된 인스턴스의 number가 크면 음수를, 작으면 정수를, 같으면 0을 반환하도록하였다.
        return this.getNumber()-other.getNumber();
    }
    public Element getElement(){
        //Element에 정의되어 있는 valueOf의 인자로 현재PeriodicElement클래스(this)의 getNumber()메소드를 호출하고 반환하는 값을 전달한다.
        //즉, PeriodicElement의 인스턴스변수 number와 동일한 상수값(value)을 가지는 Element를 찾아서 반환한다.
        return Element.valueOf(this.getNumber());
    }
    //어노테이션, Object의 equals()메소드를 오버라이딩한다.
    @Override
    //객체의 참조값을 통한 비교가 아닌 내용비교를 위해 Object클래스에 정의되어 있는 equals()메소드를 오버라이딩하였다.
    //만약 이를 오버라이딩하지 않으면 Object의 equals()메소드를 기반으로 비교를 할 것이고 Object의 equals()는 다음과 같이
    //public boolean equals(Object obj) {return(this==obj);} 참조값을 비교하도록 되어 있다.
    //다음은 이 메소드를 오버라이딩하여 인스턴스변수 5개가 모두 동일할 때 동일한 내용의 인스턴스로 판단하도록 하였다.
    //이 PeriodicElement를 상속받는 모든 구상클래스는 이를 상속받는데 만약 하위클래스에서 이를 다시 오버라이딩하지 않으면
    //하위의 구상클래스를 대상으로 equals()메소드를 호출하여도 다음에 정의된 equals()이 호출된다.
    public boolean equals(Object o){
        //Object형 매개변수 o를 PeriodicElement형으로 다운캐스팅(형변환)한다.
        //이렇게 명시적으로 타입변환을 하는 것은 프로그래머가 이를 보장한다는 의미로 컴파일러가 이를 허용하느데 만약 예를 들어Object o가 참조하는 인스턴스가
        //PeriodicElement가 아닌 Object인 경우 다음은 실행예외를 일으킨다.(ClassCastException)
        //따라서 instanceof를 통해 검사(확인)을 해주는 것이 좋을 것 같아서 다음과 같이 하였다.
        //이를 통해 적절하지 않은 객체가 매개변수를 통해 전달되어 ClassCastException을 일으켜 프로그램이 종료되지 않고
        //false를 반환하게 된다.(어차피 적절하지 않은 객체, 즉 PeriodicElement가 아닌 객체가 전달되면 둘은 비교 불가능하고 false가 되는 것이 논리에 맞다.)
        //물론 PeriodicElement를 상속하는 구상클래스(concrete class)들도 모두 PeriodicElement를 상속하고 PeriodicElement형으로 형변환이 가능하므로 문제없다.
        PeriodicElement pe=null;
        if(o instanceof PeriodicElement){
            pe=(PeriodicElement)o;
        }else{
            return false;
        }
        //위의 if문을 통과하여 형변환이 제대로 되었다면 둘은 서로 비교가 가능하다는 것이고(둘 다 PeriodicElement형 객체(PeriodicElement형 객체라는 말은 여기서 PeriodicElement는 추상클래스이므로
        //이를 구현하는 구상클래스(concrete class)라는 의미이다.))
        //다음의 if문을 통해 내용이 동일한지를 판단하여 true혹은 false를 반환한다.
        if(this.getNumber()==pe.getNumber()&&
                this.getName().toUpperCase().equals(pe.getName().toUpperCase())
                &&this.getSymbol().equals(pe.getSymbol())
                &&this.getWeight()==pe.getWeight()
                &&this.getState().name().toUpperCase().equals(pe.getState().name().toUpperCase())){
            return true;
        }else{
            return false;
        }
    }
}