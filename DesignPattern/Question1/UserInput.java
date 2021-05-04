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
    //또한 생성자에 대해서 private 접근 지정자를 통해 UserInput클래스 외부에서의 생성자호출을 제한하고 있다.
    //즉 UserInput클래스에 대해 인스턴스 생성이 불가능하다.
    private UserInput(){}

    //이와 같이 생성자를 private로 선언하고 이 클래스의 모든 메소드를 public static으로 정의하는 이유는
    //이 클래스는 인스턴스의 생성이 목적이 아니고 외부에 기능을 제공하기 위함이기 때문이다.

    public static double getDouble(){
        //try-catch구문을 통하여
        //parseDouble()과 같이 문자열을 숫자로 변환하는 과정에서(실행시간에) 발생할 수 있는 NumberFormatException예외상황을 처리한다.
        //catch영역으로 예외 인스턴스가 전달이 되면 가상머신은 예외가 처리된것으로 판단하고 실행 흐름을 이어나간다.
        try {
            //Wrapper Class중 하나인 Double클래스의 static(정적)메소드인 parseDouble()을 클래스이름을 통하여 클래스 외부에서 접근하고 있다.
            //이 때 메소드의 인자로 scan.nextLine()을 통해 사용자로부터 입력받은 문자열을 전달하고
            //기본자료형의 값(double)으로 변환하여 반환해주고 있다.
            return Double.parseDouble(scan.nextLine());
        }catch(NumberFormatException e){
            //ex)sc.nextLine()을 통해 입력받은 문자열이 "k"인데 이는 double형으로 변환이 불가능하므로
            //NumberFormatException이 발생한다.
            return 0.0;
        }
    }
    public static int getInteger(){
        //try-catch구문을 통해 문자열을 숫자로 변환시키는 과정에서(실행시간에) 예외 발생시 이를 catch구문에서 처리한다.
        try {
            return Integer.parseInt(scan.nextLine());
        }catch(NumberFormatException e){
            //NumberFormatException발생 시 0을 반환
            return 0;
        }
    }
    public static String getString(){
        return scan.nextLine();
    }
    public static char getChar(){
        //try-catch문을 통해 scan.nextLine()을 통해 입력받아 생성된 String인스턴스의 charAt메소드의 인자로 전달된 인덱스에 해당하는 문자를 반환한다.
        //charAt() 메소드는 문자열에서 특정 인덱스에 위치하는 유니코드 단일문자를 반환한다.
        //nextLine()메소드를 통해 사용자로 부터 입력받는 문자열은 '\n'제외한 문자열을 생성하여 반환하는데
        //이 때 사용자가 단순히 '엔터'키를 누르게 되면 문자열의 길이가 0인 String이 생성되어 반환되고 이에 대해 charAt(0)메소드를 호출 시
        //String 클래스가 가지고 있는 문자열의 길이에 맞지 않는 메모리 공간에 접근하므로 StringIndexOutOfBoundsException 예외가 발생하게 된다.
        try {
            return scan.nextLine().charAt(0);
        }catch(StringIndexOutOfBoundsException e){
            //예외가 발생할 시 프로그램의 실행흐름은 catch영역으로 이어가게 되고 가상머신은 예외가 처리된 것으로 간주하고 실행흐름을 이어나간다.
            //' '을 반환
            return ' ';
        }
    }
}
