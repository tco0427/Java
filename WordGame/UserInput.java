//import문을 통하여 java.util패키지의 Scanner클래스를 import한다.
import java.util.Scanner;
//UserInput이라는 이름의 클래스를 public하게 접근할 수 있도록 선언한다.(다른 패키지에서 접근가능)스
//사용자로부터 입력을 받기위한 용도(기능)의 클래스
public class UserInput {
    //사용자로부터 입력을 받기위해 Scanner클래스의 생성자에 표준입력스트림인 System.in을 전달하여 객체를 생성하고
    //이를 참조하는 참조변수를 'sc'라는 이름으로 선언한다.
    //이 때 private static을 통해 클래스 내부에서만 접근이 가능하고(private) static선언을 통해
    //인스턴스 생성이전에 클래스 로딩시점에(정적으로)멤버가 생성된다.
    private static Scanner sc=new Scanner(System.in);

    //UserInput의 모든 메소드는 public static으로 선언하였다.
    //인스턴스 생성과는 무관하게 외부에 기능을 제공하기 위한 클래스이므로 모두 public static으로 선언하였다.
    public static double getDouble(){

        //try-catch구문을 통해 문자열을 숫자로 변환시키는 과정에서(실생시간에) 예외 발생시 이를 catch구문에서 처리한다.
        try{
            return Double.parseDouble(sc.nextLine());
        }catch(NumberFormatException e){
            //사용자에게 입력이 잘못되었음을 알리고 0.0을 반환한다.
            System.out.println("잘못된 입력이 존재합니다.");
            return 0.0;
        }
    }
    public static int getInteger(){
        //try-catch구문을 통해 문자열을 숫자로 변환시키는 과정에서(실행시간에 발생하는) 예외 발생시 이를 catch구문에서 처리한다.
        try{
            return Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            //사용자가에게 입력이 잘못되었음을 알리고 0을 반환한다.
            System.out.println("잘못된 입력이 존재합니다.");
            return 0;
        }
    }

    //Scanner클래스의 nextLine()메소드를 통해 '\n'을 제외한 공백을 포함하는 문자열(한 줄)을 사용자로부터 입력받고
    //이를 문자열형태로 반환한다.
    public static String getString(){
        return sc.nextLine();
    }
}
