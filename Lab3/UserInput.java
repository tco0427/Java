/*
Lab7
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/26
 */

//import문을 통하여 java.util패키지의 Scanner클래스를 import(포함)한다.
import java.util.Scanner;

//UserInput이라는 이름의 클래스를 생성한다.
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야하며 다른 패키지에서도 접근이 가능하다.
public class UserInput{
    //사용자로부터 입력을 받기 위해 Scanner클래스의 생성자에 표준입력스트림인 System.in을 전달하여 인스턴스를 생성하고
    //이를 참조하는 참조변수를 'sc'라는 이름으로 선언한다.
    //private(접근 수준 지시자Access-level Modifiers)로 선언하였으므로 클래스 내부에서만 접근이 가능하다.
    private static Scanner scan=new Scanner(System.in);

    //이 클래스의 메소드는 모두 public과 static으로 선언되었다.(생성자 메소드 제외)
    //public으로 선언되었으므로 이 클래스 이외의 영역에서 모두 접근이 가능하며
    //static으로 선언되었으므로 인스턴스 생성과 무관하게 접근이 가능하다.
    //또한 생성자에 대해서 private 접근 지정자를 통해 UserInput클래스 외부에서의 생성자호출을 제한하고 있다.
    //즉 UserInput클래스에 대해 인스턴스 생성이 불가능하다.
    //생성자에 private선언은 싱글톤 패턴에서 객체를 하나만 생성하여 어디서든 공용할 수 있도록 활용할 수 있다.
    private UserInput(){}

    //이와 같이 생성자를 private로 선언하고 이 클래스의 모든 메소드를 public static으로 정의하는 이유는
    //이 클래스는 인스턴스의 생성이 목적이 아니고 외부에 기능을 제공하기 위함이기 때문이다.

    public static double getDouble(){
        //try-catch구문을 통하여
        //parseDouble()과 같이 문자열을 숫자로 변환하는 과정에서 발생할 수 있는
        //NumberFormatException상황을 처리한다.
        //catch영역으로 예외 인스턴스가 전달이 되면 가상머신은 예외가 처리된것으로 판단하고 실행 흐름을이어나간다.
        try {
            //Wrapper Class중 하나인 Double클래스의 static(정적)메소드인 parseDouble()을 클래스이름을 통하여
            //클래스 외부에서 접근하고있다. 이 때 메소드의 인자로 sc.nextLine()을 통해 사용자로부터 입력받은 문자열을 전달하고
            //기본자료형의 값(double)로 변환하여 반환해주고 있다.
            return Double.parseDouble(scan.nextLine());
        }catch(NumberFormatException e){
            //ex)sc.nextLine()을 통해 입력받은 문자열이 "k"인데 이는 double형으로 변환이 불가능하므로
            //NumberFormatException이 발생하고 원소번호는 1이상이므로 -1을 반환하도록 하였다.
            return -1.0;
        }
    }
    public static int getInteger(){
        //try-catch구문을 통해 문자열을 숫자로 변환시키는 과정에서(실행시간에) 예외 발생시 이를 catch구문에서 처리한다.
        try {
            return Integer.parseInt(scan.nextLine());
        }catch(NumberFormatException e){
            //NumberFormatException발생 시 -1을 반환
            return -1;
        }
    }

    //내가 추가한 코드(getIntegerBetween)을 위한 문자열 입력받기
    public static String getString(){
        //scan.nextLine()은 공백을 포함하고 '\n'이전까지의 문자열을 입력받고 String인스턴스를 생성하여 받환한다.
        return scan.nextLine();
    }

    //두개의 int형 값을 인자로 전달받는다.
    public static int getIntegerBetween(int min,int max){
        int input=0;
        //사용자가 작은수,큰수 순서대로 입력한다는 보장이 없고 반대 순서로 입력할 수도 있으므로
        //아래와 같은 조건문을 삽입
        //만약 min이 max보다  크면
        if(min>max){
            //둘의 값을 서로 바꾸는 과정
            int temp=max;
            max=min;
            min=temp;
        }
        //try-catch문에서 마찬가지로 NumberFormatException예외 발생시 이를 catch영역에서 처리한다.
        try{
            //WrapperClass중 하나인 Integer클래스의 static으로 정의되어 있는 parseInt()메소드를 클래스이름을 통하여 접근한다.
            //이낮로 사용자로부터 입력받은 문자열(scan.nextLine())을 전달한다.
            input=Integer.parseInt(scan.nextLine());
        }catch(NumberFormatException e){
            return -1;
        }
        //만약 입력이 min보다 작거나 max보다 크면 input이 -1이 되게 하였다.
        //원소번호는 1이상이므로 -1이 반환되면 잘못되었다는 것을 알 수 있다.
        if(max<input||input<min){
            input=-1;
        }
        //input의 값을 반환한다.
        return input;
    }


    public static boolean getExitKey(){
        System.out.print("Press q-key to exit or enter-key to continue:");
        String s=scan.nextLine();
        //contentEquals를 호출한 문자열의 내용과 인자로 전달된 문자열의 내용이 100% 일치하면 true를 반환한다.
        //if문이 참이면 다음 문장 실행
        if(s.contentEquals("q")){
            //boolean형 상수값인 true반환
            return true;
        }
        //거짓이 다음 문장 실행
        else{
            //boolean형 상수값인 false반환
            return false;
        }
    }
    public static char getKey(){
        System.out.print("Press key 'q' to exit, 'n' to nextElement, 'p'  to previousElement,'c' to currentElement, ' ' to continue: ");
        //사용자로부터 한줄의 문자열을 입력받고 이를 s를 통해 참조한다.
        String s=scan.nextLine();
        //contentEquals를 호출한 문자열의 내용과 인자로 전달된 문자열의 내용이 100% 일치하면 true를 반환한다.
        //q,n,p,c,' '에 해당하는 값을 다중if-else문으로 구분하고 char형으로 반환한다.
        if(s.contentEquals("q")){
            return 'q';
        }else if(s.contentEquals("n")){
            return 'n';
        }else if(s.contentEquals("p")){
            return 'p';
        //원소번호의 이전,이후가 아닌 입력한 원소번호 그대로에 대한 정보를 알고 싶을 수 있기에 추가한 코드
        }else if(s.contentEquals("c")){
            return 'c';
        }else{
            return ' ';
        }
    }

    //UserInput.getString()을 통해 입력받은 값을 String클래스에 정의되어 있는 toUpperCase()를 호출하여 모두 대문자로 만들어 준다.
    //왜냐하면 관례적으로 상수는 모두 대문자로 정의하고 우리도 열거형(Enum)들에서 상수들을 모두 대문자로 선언했기 때문이다.
    //그리고 이 값을 Element.nameOf의 인자로 전달해준다. 그후 Element.nameOf로 반환되는 값을(Element형)을 반환해준다.
    public static Element getElement(){
        return Element.nameOf(UserInput.getString().toUpperCase());
    }

    //내가 추가한 코드(State를 직접 입력받고 이를 통해 PeriodicTable의 find을 호출하는 것이 좋다고 생각되어 추가하였다.)
    //getElement와 내용은 동일하다 단지 Enum에 정의된 valueOf(static으로 정의된 메소드)를 호출하고, Element에서 State로 차이가 있을 뿐이다.
    public static State getState(){
        //valueOf에서 발생가능한 IllegalArgumentException에 대한예외처리
        //만약 예외 발생시 null을 반환한다.
        try{
            return State.valueOf(UserInput.getString().toUpperCase());
        }catch(IllegalArgumentException e){
            return null;
        }
    }


    //원소 정보(number,symbol,name,weight,state)를 입력받고 이를 통해 PeriodicElement로 참조가능한 인스턴스(즉, 추상클래스인 PeriodicElement를 구현한 클래스의 인스턴스)를 반환해주는 메소드
    public static PeriodicElement getPeriodicElement(){
        //getPeridoicElement가 정의된 클래스와 동일한 UserInput클래스에서 getInteger,getString,getDouble,getState()을 이용하여 사용자로부터 입력을 받는다.
        System.out.print("number: ");
        int number=UserInput.getInteger();
        System.out.print("symbol: ");
        String symbol=UserInput.getString();
        System.out.print("name: ");
        String name=UserInput.getString().toUpperCase();
        System.out.print("weight: ");
        double weight=UserInput.getDouble();
        System.out.print("state: ");
        State state=getState();
        //만약 number,weight이 음수이거나 state가 null이면 사용자의 입력에 문제가 있다는 것을 의미하는 것이고
        //이에대해서 아무런 내용도 가지지 않는(0,"",UNKNOWN)값들을 PeriodicElementFactory의 getInstace메소드에 전달하여
        //사용자로 하여금 잘못된 입력이 있었음을 인지할 수 있게끔 한다.
        if(number<=0||weight<=0||state==null){
            return PeriodicElementFactory.getInstance(0,"","",0.0,State.UNKNOWN);
        }else {
            //정상적인 입력들일 경우 이를 토대로 인스턴스를 생성하여 반환한다.
            return PeriodicElementFactory.getInstance(number, symbol, name, weight, state);
        }
    }
}
