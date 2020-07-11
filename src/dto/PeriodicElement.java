/*
Lab8
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/06/07
 */

//다음의 클래스(PeriodicElement)가 소속될 패키지 명을 다음과 같이 package키워드를 이용하여 소스파일의 첫 줄에 선언해주었다.
package dto;
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려줌을 통해
//클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
//다음은 PeriodicElement클래스에서 활용하는 다른 패키지의 클래스들을 import한 것이다.
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
//PeriodicElement는 Comparable<T>인터페이스를 구현한다.(기존의 Comparable인터페이스에서, 자바에 제네릭(generic)이 도입되면서 Comparable<T>인터페이스로 수정되었다.)
//Comparable<T>인터페이스를 구현할 때 정의해야 할 추상메소드는 int compareTo(T o)이다.
//따라서 PeriodicElement클래스에서는 int compareTo(T o)의 구현부를 제공한다.
//Comparable<T>의 타입매개변수T를 PeriodicElement로 하였다.
//이러한 제네릭으로 인해 불필요한 타입변환(cast)와 자료형과 관련된 프로그래머의 실수가 컴파일과정에서 드러나도록 하는 이점을 얻을 수 있었다. 또 ClassCastException을 방지할 수 있다.
public class PeriodicElement implements Comparable<PeriodicElement>{
    /*
    객체 지향 특성을 살리기 위해서는 캡슐화 원칙을 지키는 것이 좋고 이를 위해 가능하면 필드에 대해서 접근 범위를 작게하는 것이 좋다.
    따라서 PeriodicElement의 필드들에 대해서 모두 private로 선언하였고,
    이 필드(인스턴스 변수)들에 대한 접근을 위해 접근자와 설정자를 아래에 각각 정의해두었다.
     */
    private int number;
    private String symbol;
    private String name;
    private double weight;
    private int period;
    private int group;
    private Type type;
    private State state;

    /*
    PeriodicElement의 생성자를 정의하였다.
    이 때, PeriodicElement를 생성하는 과정에서 필드들(인스턴스변수들)에 대한 값을 정의하지 않을 수도 있기 때문에
    매개변수가없는 생성자를 오버로딩해두었다.(this를 통한 오버로딩된 다른 생성자의 호출은 생성자의 처음 위치에 와야한다.)
    또 매개변수가 없는 생성자에서는 this를 통해 다른 생성자를 호출하는데 0혹은""과 같은 null로 취급할 수 있는
    (실제로 null은 아니지만)(아무것도 정의되어있지 않다는것을 알 수 있으므로) 값들을 전달한다.
     */

    //매개변수를 전달 받지 않는 생성자 정의, 이 생성자에서는 0,"",null과 같은 값들을
    //오버로딩을 통해 작성된 또 다른 생성자를 this()를 통해 호출하고 이 값들을 인자로 전달한다.
    //PeriodicElement를 추상클래스로 정의하고 인스턴스 생성시 PeriodicElementFactory를 이용함으로써 이를 활용할 경우는 없다고 판단되지만 그래도 이후 업데이트에서 필요하게 될지도 모르기 때문에 우선은 그냥 두겠다.
    public PeriodicElement(){
        this(0,"","",0,0,0,null,null);
    }


    //매개변수를 통해 전달받은 값으로 PeriodicElement클래스의 필드들(인스턴스변수들)을 초기화하여준다.
    //this를 통해 객체 자신의 대한 참조 즉, 예를들어 매개변수 number가 아닌 인스턴스변수 number라는 것을 명시해준다.
    //생성자(메소드)안에서 동일이름의 매개변수(지역변수)는 인스턴스변수의 가시성을 가린다고 볼 수 있다.
    //즉, 생성자 내부에서 동일한 변수명의 인스턴스변수 혹은 static변수 (필드)보다 지역변수(매개변수 혹은 메소드내에서 선언된 변수)의 가기성이 더 높다.
    public PeriodicElement(int number,String symbol,String name,double weight,int periodic,int group, Type type,State state){
        this.number=number;
        this.symbol=symbol;
        this.name=name;
        this.weight=weight;
        this.period =periodic;
        this.group=group;
        this.type=type;
        this.state=state;
    }

    //이후 8개의 메소드들은 인스턴스변수(필드)에 대한 접근자와 설정자들이다.
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
    public int getPeriod() {return period; }
    public void setPeriod(int period) {this.period = period; }
    public int getGroup() { return group; }
    public void setGroup(int group) { this.group = group; }
    public Type getType() { return type;}
    public void setType(Type type) { this.type = type;}


    /*
    Object클래스로부터 상속받은 toString()메소드를 오버라이딩(재정의)한다.
    System.out.println()의 인자로 인스턴스를 참조하는 참조변수 전달시 해당 인스턴스의 toString()호출로 이어진다.
    모든 클래스는 Object를 상속하므로 이를 오버라이딩하지 않으면 Object에 정의되어있는
    public String toString(){return getClass().getName()+"@"+Integer.toHexString(hashCode());}
    가 호출되게 된다.
     */
    /*
    이 경우에는 CSV파일에 PeriodicElement인스턴스의 내용이 출력이 가능하도록 각 필드들(인스턴스변수들)을 ","로 구분하여 한줄의 문자열로 출력할 수 있도록 하였다.
     */
    //어노테이션은 자바 컴파일러에게 메시지를 전달하는 목적의 메모로 볼 수 있는데(메타데이터)
    //@Override를 통하여 오버라이딩이 제대로 이루어졌는지 컴파일과정에서 발견가능하다.(개발자의 실수를 잡아냄)
    //스프링 프레임워크등에서 특수 기능을 위해 사용하므로 어노테이션에 익숙해지는 것이 좋다고 생각한다.
    @Override
    public String toString(){
        //StringBuilder인스턴스를 str이름의 참조변수로 참조한다.
        //String의 concat을 통한 문자열의 결합은 빈번한 String객체의 생성으로 이어지기 때문에(String은 Immutable한 객체이다.)
        //StringBuilder를 이용하였다.
        //StringBuilder는 String클래스의 메모리 공간과 달리 문자를 추가하거나 삭제하는 것이 가능하다. 따라서 수정하면서 유지해야할 문자열이 있다면 이 클래스에 그 내용을 담아서 관리하는 것이 효율적이다.
        StringBuilder str=new StringBuilder();
        //List형 참조변수 list를 선언하고 Arrays.asList를 통해 인자로 전달된 인스턴스들을 저장한 컬렉션 인스턴스를 생성하고 반환한다.
        //(컬렉션 인스턴스를 생성할 때 당연히 int,double과 같이 primitive type인 number,weight등은 wrapper class인 Integer, Double로 Auto Boxing될 것이다.)
        //이 때 생성되는 ArrayList는 java.util.Arrays.ArrayList이다. 우리가 컬렉션을 배울 때 알고 있던 java.util.ArrayList와는 다르다.
        //하지만 이 클래스 또한 Collections과 List를 상속한다.
        //Arrays.asList로 생성한 객체는 이미 존재하는 fixed sized 배열의 주소값을 가져와 List로 처리하기 때문에 새로운 인스턴스의 추가나 삭제가 불가능하다.
        //그리고 기존 배열의 주소값을 가져오기 때문에 asList로 생성한 ArrayList의 내용이 변경되면 기존 배열(asList의 인자로 전달된 배열)의 내용도 변경된다.
        //여기서 주의할 점은 asList의 인자를 통해 전달된 인스턴스들의 타입 Integer,Double,Type,State,String과 같이 다양하다.
        //따라서 특정타입의 인스턴스만을 저장한 컬렉션 인스턴스를 참조하는 List<E>형 대신 와일드카드를 이용한 List<?>를 사용한다.(이를 통해 여러 타입의 인스턴스들을 요소로 가질 수 있게 된다.)
        List<?> list= Arrays.asList(number,symbol,name,weight, period,group,type,state);
        //list.size()를 통해 리스트 요소의 크기를 반환한다.
        //for문에서 0부터 list.size()-1까지 1씩 증가하면서 반복을 진행한다.
        for(int i=0;i<list.size();i++){
            //list.get(i)를 통해서 list가 참조하는 인스턴스의 i번째의 요소를 이를 Object형 참조변수로 참조한다.
            Object objBuf=list.get(i);
            //objBuf가 참조하는 인스턴스가 null이거나 -1이면
            if(objBuf==null||objBuf==Integer.valueOf(-1)||objBuf==Double.valueOf(-1)){
                //str에 " "을 추가한다.
                str.append(" ");
            }else{
                //만약 그렇지 않다면(즉, objBuf가 참조하는 인스턴스가 null이 아니고 -1이 아니면) objBuf가 참조하는 인스턴스를 str에 추가한다.
                //append는 primitive타입, Object타입, String타입을 인자로 받을 수 있도록 오버로딩 되어 있다.
                str.append(objBuf);
            }
            //맨 마지막에 추가되는 요소에는 ","가 추가될 필요가 없기 때문에
            //다음과 같은 조건문을 통해 맨 마지막 요소가 아닌 경우에만 콤마를 추가하고 맨 마지막 요소의 경우에는 추가하지 않도록한다.
            if(i!=(list.size()-1)){
                str.append(",");
            }
        }
        //이렇게 만들어진 StringBuilder인스턴스를 toString()을 통해
        //저장된 문자열의 내용을 담은 String인스턴스를 생성하고 이를 반환하며 메소드 호출을 종료한다.
        return str.toString();
    }
    //인스턴스 정보를 한줄씩(인스턴스 변수 하나당 한줄 씩)출력하기 위한 메소드
    //인스턴스에 대한 정보(속성,필드)에 대해 출력하기 때문에 인스턴스에 종속적인 메소드로 정의하는 것이 옳고 따라서 Non-Static으로 정의
    public void print(){
        System.out.println("<Periodic Elemenet Information>");
        System.out.println("number=" +this.number);
        System.out.println("symbol="+this.symbol);
        System.out.println("name="+this.name);
        System.out.println("weight="+this.weight);
        System.out.println("periodic="+this.period);
        //PeriodicElement생성시에 group과 type에 대해서 적절치 않은 값 혹은 비어있는 값을 통해 인스턴스를 생성하였을 수 있다.(특히 new키워드(생성자)를 통한 생성이 아닌 parse()메소드를 통해 생성한 경우)
        //따라서 이를 if문을 통해 검사하고 적절치 않은 값인 경우 출력하지 않도록(빈 공간으로 두도록)하였다.
        //(물론 이외의 인스턴스 변수들에 대해서도 동일한 상황이 연출될 수 있다. 하지만 이번 Lab의 경우 파일을 통해서 화학원소에 대한 정보를 입력받는데(이외의 루트로는 PeriodicElement를 생성하지 않음)
        //group과 type이외에는 모두 정상적인 값들이 들어온다고 판단되어 아래의 값들에 대해서만 if문을 통해 검사해주었다.
        //만약 다른 값들도 아래와 같은 상황이 발생 가능하다면 당연히 if문을 통해 처리해주어야 한다. 여기서는 이를 생략하도록 하였다.)
        if(this.group==-1){
            System.out.println("group=");
        }else {
            System.out.println("group=" + this.group);
        }
        if(this.type==null) {
            System.out.println("type=");
        }else{
            System.out.println("type=" + this.type);
        }
        if(this.state==null) {
            System.out.println("state=");
        }else{
            System.out.println("state="+this.state);
        }
    }
    //해당메소드는 인자로 전달된 문자열배열의 정보를 통해서 PeriodicElement를 생성해 반환하여주는 메소드이므로 static으로 정의해주었다.
    public static PeriodicElement parse(String[] fields){
        //매개변수를 통해 전달된 문자열배열(String[])의 길이정보(length)를 int형 변수 length에 저장한다.
        int length=fields.length;
        //만약 length가 정확히 8이 아니면, String배열 fields가 PeriodicElement를 생성하기 위한 정보가 부족하거나 혹은 불필요한 정보를 포함하고 있다는 것이므로
        //사용자에게 이를 알리고 null을 반환하면서 메소드 호출을 종료하여야 한다.
        if(length!=8){
            System.out.println("잘못된 인자전달");
            return null;
        }
        //int number, double weight, int period,Type type등 변수를 선언하여 준다. 이 때 따로 초기화는 하지 않았다.
        //(프로그램 흐름상 정상적인 흐름인 경우 String배열을 적절히 파싱(parse)한 값으로
        //그렇지 않은 경우 -1이나 null로 변수의 값이 할당되기 때문에 굳이 선언과 함께 초기화를 할 필요가 없다고 판단되었다.)
        int number;

        //String배열의 요소들(String)을 Integer(Double).parseInt(Double)을 이용하여 int,double로 변경하는데 있어서
        //NumberFormatException예외가 발생가능하다.
        //따라서 이를 try-catch구문을 통해서 예외처리를 하여준다.
        //이 때 만약 NumberFormatException이 일어난다면 해당 내용이 부적절하거나 존재하지 않는(""빈 값)이기 때문에 이를
        //-1로 변경하여 준다.
        try {
            number = Integer.parseInt(fields[0]);
        }catch(NumberFormatException e){
            number=-1;
        }
        //symbol과 name은 String형이므로 fields배열요소의 값을 그냥 대입하여주면 된다.
        String symbol=fields[1];
        String name=fields[2];
        double weight;
        try {
            weight = Double.parseDouble(fields[3]);
        }catch(NumberFormatException e){
            weight=-1;
        }
        int period;
        try {
            period = Integer.parseInt(fields[4]);
        }catch(NumberFormatException e){
            period=-1;
        }
        int group;
        try {
            group = Integer.parseInt(fields[5]);
        }catch(NumberFormatException e){
            group=-1;
        }

        //Type과  State의 경우는 열거형(Enum)이다.
        //모든 열거형의 조상이라고 할 수 있는 Enum클래스에는 valueOf()메소드가 정의되어 있다.
        //valueOf는 해당 열거형에서 인자로 전달된 String값과 일치하는 열거형 상수를 찾아서 반환하여 준다.
        //이 때 해당되는 열거형 상수가 없을 경우 IllegalArgumentException예외인스턴스를 생성한다.
        //따라서 Type과 State에 대해서 try-catch문을 이용하여 예외처리를 하여주었다.
        //만약 IllegalArgumentException 일어난다면 프로그램의 실행흐름은 catch구문 안으로 넘어가게 될 것이고
        //catch구문안에서 각각 type과 state에 null을 대입하여준다.
        Type type;
        try {
            type = Type.valueOf(fields[6]);
        }catch(IllegalArgumentException e){
            type=null;
        }
        State state;
        try{
            state = State.valueOf(fields[7]);
        }catch(IllegalArgumentException e){
            state=null;
        }

        //예외처리에 대한 부분을 하나의 try-catch문으로 구성한다는 생각을 할 수도 있지만
        //만약 이러한 생각으로 다음과 같은 코드
        /*
        try{
            number= Integer.parseInt(fields[0]);
            weight=Double.parseDouble(fields[3]);
            ..
            group=Integer.parseInt(fields[5]);
            type=Type.valueOf(fields[6]);
            state=State.valueOf(fields[7]);
        }
         */
        //위와 같은 코드에서는 만약 type에서 예외발생시 그 뒷 문장(그 뒷부분)에 해당하는 state에 대한 내용은 처리하지 않고 바로 catch로 프로그램의 실행흐름이 넘어가게된다.
        //또 group에서 예외발생시 그 뒷 문장인 type=Type.valueOf(fields[6]);, state=State.valueOf(fields[7]); 이 두 문장은 실행되지 않고 catch로 넘어간다.
        //따라서 위와같이 각 부분마다 별도의 try-catch로 처리해주어야한다.
        //만약 이와 같은 코드가 지저분하다고 느껴진다면 예외처리부분을 별도의 메소드로 분리하는 리팩토링 과정을 진행할 수도 있겠다.

        //앞서 try-catch구문, valueOf메소드, Wrapper클래스의 parseXXX()메소드를 통해서 변환해준 값과 또 단순히 String값을 대입하여준 값(ex.symbol,name)
        //을 토대로 new를 통해 인스턴스를 생성하면서 PeriodicElement의 생성자로 값들을 전달하여 준다.
        //그리고 이렇게 생성된 PeridoicElement인스턴스를 return을 통해 반환하면서 메소드호출을 종료한다.
        return new PeriodicElement(number,symbol,name,weight,period,group,type,state);
    }

    /*
    다음의 8개의 static메소드는 모두 Comparator<PeriodicElement>인스턴스를 생성해 반환하여 주는 메소드들이다.
     */


    public static Comparator<PeriodicElement> numberComparator(){
        //Comparator<PeriodicElement>인스턴스를 생성하며 return을 통해 반환하여 준다.
        //이 때 AnonymousClass를 활용하였다.
        //로컬클래스를 활용하게 되면 클래스의 정의와 new를 통한 생성이 분리되게 되는데 익명클래스를 활용함으로써 클래스의 정의와 인스턴스의 생성을 하나로 묶을 수 있다.
        //Comparator는 FunctionalInterface로 default메소드와 static메소드를 제외한, compare라는 추상메소드를 하나 가진 인터페이스이다.
        //따라서 Comparator를 대상으로 인스턴스를 생성하기 위해(이를 구현한 구상클래스를 정의하기 위해) Comparator의 유일한 추상메소드 compare()를 정의하며 클래스를 생성하고 있다.
        //(인터페이스를 대상으로 인스턴스를 생성하고 있으니 문제가 있는 문장이지만, 여기에 해당 인터페이스를 구현하는 클래스의 정의를 덧붙임으로해서 인스턴스 생성이 가능하다.)
        return new Comparator<PeriodicElement>() {
            //어노테이션
            //Comparator인터페이스의 compare를 오버라이딩을 통해 구현하고 있다.
            @Override
            //o1과 o2의 getNumber()를 통해 반환된 값(number)을 기준으로 비교를 진행한다.
            public int compare(PeriodicElement o1, PeriodicElement o2) {
                return o1.getNumber()-o2.getNumber();
            }
        };
    }
    public static Comparator<PeriodicElement> symbolComparator(){
        //numberComparator와 같이 익명클래스 방법을 통해 클래스의 정의와 인스턴스의 생성(new를 통한)을 하나로 묶었다.
        return new Comparator<PeriodicElement>() {
            //어노테이션
            //Comparator인터페이스의 compare를 오버라이딩을 통해 구현하고 있다.
            @Override
            //o1과 o2의 symbol을 기준으로 비교를 진행한다.
            //이 때, getSymbol()을 통해 얻은 인스턴스는 String이고,
            //String클래스는 사전편찬순으로 정렬이 되도록 Comparable<String)인터페이스를 구현하고 있다.
            //compare()에서 이를 이용하여 String클래스에 정의된 compareTo()를 통해 사전편찬순으로 비교를 하게 된다.
            public int compare(PeriodicElement o1, PeriodicElement o2) {
                return o1.getSymbol().compareTo(o2.getSymbol());
            }
        };
    }
    public static Comparator<PeriodicElement> nameComparator(){
        //앞서 Comparator인터페이스가 default,static메소드를 제외하면 추상메소드(compare)하나만을 가지는 FunctionalInterface이므로
        //이를 기반으로 람다식을 작성하는 것이 가능하다.(람다식은 함수형 인터페이스를 기반으로만 작성될 수 있다.)
        //람다식은 메소드를 하나의 식(expression)으로 간략하면서도 명확하게 표현하는 것이다.
        //람다를 이용하면 코드를 줄일 수 있고, 가독성에도 도움이 된다.
        //'->'를 람다 연산자라고 한다.
        //보통 람다는 인스턴스보다는 기능(메소드) 하나를 정의해서 전달해야 하는 상황에서 쓰인다.
        //람다식과 익명클래스의 차이점
        /*
        Anonymous Class vs Lambda expression
        1. 익명클래스와 람다에서의 this의 의미는 다르다.
        람다식은 this를 이용한 자기 자신에 대한 참조가 불가능하다.
        익명클래스의 this는 익명클래스 자신을 가리키지만 람다에서의 this는 선언된 클래스를 가리킨다.
        2. 람다는 은닉변수(Shadow Variable)을 허용하지 않는다.
        익명 클래스는 변수를 선언하여 사용할 수 있지만, 람다는 이를 허용하지 않는다.
        3. 람다는 인터페이스에 반드시 하나의 추상메소드만 가지고 있어야한다.
        익명클래스는 추상클래스를 대상으로도 가능하고, 또 추상메소드의 개수에 제한이 없다. 모두 구현해주기만 하면 된다.
        하지만 람다는 반드시 '함수형 인터페이스'를 기반으로만 작성될 수 있다.
        4. 람다는 같은 시그니처를 가지는 인터페이스에 대하여 의미가 모호해진다.(타입을 지정해주어야 한다.)
         */

        //람다식을 활용하여 작성하였다. 이 때 람다식을 통해 작성하는 메소드 compare의 내용은 다음과 같다.
        //따라서 o1과o2의 getName()을 통해서 반환된 내용(name)을 기준으로 비교를 진행한다.
        //이 때 symbolComparator()에서와 마찬가지로 getName()이 반환하는 것은 String이고,
        //String 클래스에 정의되어 있는 compareTo를 이용한다.
        //(String클래스는 사전편찬순으로 정렬이 되도록 Comparable<String)인터페이스를 구현하고 있다.)
        Comparator<PeriodicElement> com=(o1,o2)->{
            return o1.getName().compareTo(o2.getName());
        };
        return com;
    }
    public static Comparator<PeriodicElement> weightComparator(){
        //람다식에서 메소드의 몸체를 이루는 하나의 문장이 return문 뿐이라면 retrun과 함께 중괄호를 생략가능하다.
        //getWeight()를 통해 반환되는 값(weight)를 기준으로 비교를 진행한다.
        //(weightComparator()가 반환하는 Comparator를 구현한 객체를 활용시 람다식을 통해 작성한 compare이 반환하는 내용을 기준으로 정렬 진행)
        Comparator<PeriodicElement> com=(o1,o2)-> (int)(o1.getWeight()-o2.getWeight());
        return com;
    }
    public static Comparator<PeriodicElement> periodComparator(){
        //앞선 메소드들과 마찬가지로 람다식을 통해 작성하였다.
        //periodComparator()에서 정의하고 반환하는 Comparator객체(Comparator를 구현한 객체)는 getPeriod()를 통해 반환되는 값을 이용하여 compare()를 구현한다.
        //따라서periodCompartor()에서 반환하는 Comparator구상클래스 객체를 이용하여 정렬을 진행하는 PeriodicElement들은 getperiod를 기준으로 정렬을 진행할 것이다.
        Comparator<PeriodicElement> com=(o1,o2)->o1.getPeriod()-o2.getPeriod();
        return com;
    }
    public static Comparator<PeriodicElement> groupComparator(){
        //이전에 익명클래스를 활용한 것과 마찬가지로
        //익명클래스를 활용하여 Comparator인터페이스를 구현하는 클래스의 정의와 인스턴스 생성을 묶었다.
        return new Comparator<PeriodicElement>() {
            //어노테이션
            //Comparator인터페이스의 compare를 오버라이딩을 통해 구현하고 있다.
            @Override
            public int compare(PeriodicElement o1, PeriodicElement o2) {
                //int형 변수 o1group,o2group 각각에 o1,o2의 getGroup()이 반환하는 값을 저장한다.
                int o1group=o1.getGroup();
                int o2group=o2.getGroup();
                //둘 다 -1이면
                if(o1group==-1&&o2group==-1){
                    //0을 반환
                    return 0;
                //o1group이 -1이면
                }else if(o1group==-1){
                    //양수인 1을 반환
                    return 1;
                //o2group이 -1이면
                }else if(o2group==-1){
                    //음수인 -1을 반환
                    return -1;
                //else, 즉 둘 다-1이 아니면서 둘 중 하나도 -1이 아닌 경우
                }else {
                    //o1.getGroup()-o2.getGroup()을 반환한다.
                    return o1.getGroup() - o2.getGroup();
                }
            }
            //parse를 통한 PeriodicElement생성시에 전달된 값이 정상적이지 않은 경우 group에 -1을 대입한다.
            //따라서 이를 검사하여 Comparator를 이용한 정렬시 이 정상적이지 않은 값들을 맨 뒤에 정렬되도록 하였다.
        };
    }
    public static Comparator<PeriodicElement> typeComparator(){
        //이전에 익명클래스를 활용한 것과 마찬가지로
        //익명클래스를 활용하여 Comparator인터페이스를 구현하는 클래스의 정의와 인스턴스 생성을 묶었다.
        return new Comparator<PeriodicElement>() {
            //어노테이션
            //Comparator인터페이스의 compare를 오버라이딩을 통해 구현하고 있다.
            @Override
            public int compare(PeriodicElement o1, PeriodicElement o2) {
                Type o1type=o1.getType();
                Type o2type=o2.getType();
                //groupComparator()에서와 동일한 내용을 진행하고 있으므로 아래 if-else문에 대한 설명은 생략하겠다.
                if(o1type==null&&o2type==null){
                    return 0;
                }else if(o1type==null){
                    return 1;
                }else if(o2type==null){
                    return -1;
                }else {
                    //o1.getType(),o2.getType()을 통해 반홚된 Type열거형의 getValue()를 통해 반환되는 value값의 차를 반환한다.
                    return o1.getType().getValue() - o2.getType().getValue();
                }
            }
            //parse를 통한 PeriodicElement생성시에 전달된 값이 정상적이지 않은 경우 type에 null을 대입한다.
            //따라서 이를 검사하여 Comparator를 이용한 정렬시 이 정상적이지 않은 값들을 맨 뒤에 정렬되도록 하였다.
        };
    }
    public static Comparator<PeriodicElement> stateComparator(){
        //이전에 익명클래스를 활용한 것과 마찬가지로
        //익명클래스를 활용하여 Comparator인터페이스를 구현하는 클래스의 정의와 인스턴스 생성을 묶었다.
        return new Comparator<PeriodicElement>() {
            //어노테이션
            //Comparator인터페이스의 compare를 오버라이딩을 통해 구현하고 있다.
            @Override
            public int compare(PeriodicElement o1, PeriodicElement o2) {
                State o1state=o1.getState();
                State o2state=o2.getState();
                //typeComparator()에서와 동일한 내용을 진행하고 있으므로 아래 if-else문에 대한 설명은 생략하겠다.
                if(o1state==null&&o2state==null){
                    return 0;
                }else if(o1state==null){
                    return 1;
                }else if(o2state==null){
                    return -1;
                }else {
                    //o1.getType(),o2.getType()을 통해 반홚된 State열거형의 getValue()를 통해 반환되는 value값의 차를 반환한다.
                    return o1.getState().getValue() - o2.getState().getValue();
                }
            }
            //parse를 통한 PeriodicElement생성시에 전달된 값이 정상적이지 않은 경우 state에 null을 대입한다.
            //따라서 이를 검사하여 Comparator를 이용한 정렬시 이 정상적이지 않은 값들을 맨 뒤에 정렬되도록 하였다.
        };
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
    //다음의 compareTo()메소드를 오버라이딩한 내용을 정렬의 기준으로 삼는다.
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

    //어노테이션, Object의 equals()메소드를 오버라이딩한다.
    @Override
    //객체의 참조값을 통한 비교가 아닌 내용비교를 위해 Object클래스에 정의되어 있는 equals()메소드를 오버라이딩하였다.
    //만약 이를 오버라이딩하지 않으면 Object의 equals()메소드를 기반으로 비교를 할 것이고 Object의 equals()는 다음과 같이
    //public boolean equals(Object obj) {return(this==obj);} 참조값을 비교하도록 되어 있다.
    //다음은 이 메소드를 오버라이딩하여 인스턴스변수가 모두 동일할 때 동일한 내용의 인스턴스로 판단하도록 하였다.
    public boolean equals(Object o){
        //Object형 매개변수 o를 PeriodicElement형으로 다운캐스팅(형변환)한다.
        //이렇게 명시적으로 타입변환을 하는 것은 프로그래머가 이를 보장한다는 의미로 컴파일러가 이를 허용하는데 만약 예를 들어 Object o가 참조하는 인스턴스가
        //PeriodicElement가 아닌 Object인 경우 다음은 실행예외를 일으킨다.(ClassCastException)
        //따라서 instanceof를 통해 검사(확인)을 해주는 것이 좋을 것 같아 다음과 같이 하였다.
        //이를 통해 적절하지 않은 객체가 매개변수를 통해 전달되어 ClassCastException을 일으켜 프로그램이 종료되지 않고
        //false를 반환하게 된다.(어차피 적절하지 않은 객체, 즉 PeriodicElement가 아닌 객체가 전달되면 둘은 비교 불가능하고 false가 되는 것이 논리에 맞다.)
        PeriodicElement pe=null;
        //instanceof를 통해 o가 참조하는 인스턴스가 PeriodicElement로 타입변환을 하여도 적절한지를 판단한다.
        if(o instanceof PeriodicElement){
            pe=(PeriodicElement)o;
        }else{
            return false;
        }
        //위의 if문을 통과하여 형변환이 제대로 되었다면 둘은 서로 비교가 가능하다는 것이고
        //다음의 if문을 통해 내용이 동일한지를 판단하여 true혹은 false를 반환한다.
        try {
            if (this.getNumber() == pe.getNumber() &&
                    this.getName().toUpperCase().equals(pe.getName().toUpperCase())
                    && this.getSymbol().equals(pe.getSymbol())
                    && this.getWeight() == pe.getWeight()
                    && this.getState().name().toUpperCase().equals(pe.getState().name().toUpperCase())
                    && this.getGroup() == pe.getGroup()
                    && this.getPeriod() == pe.getPeriod()
                    && this.getType().getValue() == pe.getType().getValue())
            //State열거형에 대해서는 name()을 통한 비교를 진행하였고
            //Type열거형에 대해서는 getValue()를 통한 비교를 진행하였다.
            {
                return true;
            } else {
                return false;
            }
        //만약 this의 인스턴스 혹은 pe가 참조하는 인스턴스의 getType(),getState()를 통해 반환되는 내용이 null인 경우
        //이에 대한 getValue()혹은 name() 호출은 NullPointerException을 일으킨다. 따라서 이에 대한 에외처리를 하여 주었다.
        }catch(NullPointerException e){
            System.out.println("해당인스턴스의 정보(인스턴스 변수)가 null을 포함하고 있기 때문에 비교가 불가능합니다.");
            //null을 포함한 경우 비교가 불가능하기 때문에 false를 반환한다.
            return false;
        }
    }
}