//32180472 김동규

//import문을 통하여 java.util패키지의 Scanner클래스를 import(포함)한다.
import java.util.Scanner;

//UserInput이라는 이름의 클래스를 생성한다.
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야하며 다른 패키지에서도 접근이 가능하다.
public class UserInput{
    //사용자로부터 입력을 받기 위해 Scanner클래스의 생성자에 표준입력스트림인 System.in을 전달하여 인스턴스를 생성하고
    //이를 참조하는 참조변수를 'sc'라는 이름으로 선언한다.
    //private(접근 수준 지시자Access-level Modifiers)로 선언하였으므로 클래스 내부에서만 접근이 가능하다.
    private static Scanner scan=new Scanner(System.in);

    //이 클래스의 메소드는 모두 public과 static으로 선언되었다.
    //public으로 선언되었으므로 이 클래스 이외의 영역에서 모두 접근이 가능하며
    //static으로 선언되었으므로 인스턴스 생성과 무관하게 접근이 가능하다.



    public static double getDouble(){
        //try-catch구문을 통하여
        //parseDouble()과 같이 문자열을 숫자로 변환하는 과정에서 발생할 수 있는
        //NumberFormatException상황을 처리한다.
        //catch영역으로 예외 인스턴스가 전달이 되면 가상머신은 예외가 처리된것으로 판다낳고 실행 흐름을이어나간다.
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
        try {
            return Integer.parseInt(scan.nextLine());
        }catch(NumberFormatException e){
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
            return true;
        }
        //거짓이 다음 문장 실행
        else{
            return false;
        }
    }

    public static Element getElement(){
        return Element.nameOf(UserInput.getString().toUpperCase());
    }
}
