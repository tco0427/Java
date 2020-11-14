//import문을 통하여 java.util패키지의 Scanner클래스를 import(포함)한다.
import java.util.Scanner;
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
public class RockScissorsPaper {
    //RockScissorsPaper클래스 에서 사용할 Scanner클래스를 static으로 선언
    static Scanner sc = new Scanner(System.in);

    //프로그램의 시작지점(Starting Point)로 main메소드에서 프로그램 실행을 구현한 run()메소드 호출
    public static void main(String[] args) {
        run();
    }

    //run()메소드는 static으로 구현되었으므로 RockScissorsPaper인스턴스 생성이전에 호출될 수 있다.
    public static void run() {
        //두 사람이 가위바위보 게임을 하므로 두 개의 Person인스턴스를 생성한다.
        Person A = new Person();
        Person B = new Person();

        //입력이 제대로 되었는지 확인하기 위한 boolean변수를 초기값 false로 선언및초기화 한다.
        boolean bool = false;

        //사용자로부터 입력받을 String인스턴스를 선언하고 null(아무 인스턴스도 참조하지 않음)로 초기화한다.
       String s = null;

        System.out.print("person-A>>");
        //입력이 정상적으로 들어올 때까지 계속해서 반복한다.
        while (bool == false) {
            //사용자(키보드)로부터 입력을 받는다. 이때 nextLine()메소드를 호출하므로 '\n'를 버린 한줄의 문자열을 입력받고 String변수 s가 참조하도록 한다.
            s = sc.nextLine();
            //Person인스턴스인 A가 인스턴스 메소드 check()의 인자로 사용자로부터 입력받은 문자열을 전달하고
            //check메소드에서 boolean형의 값을 반환한다. 이때 true이면 while반복문을 빠져나온다. false이면 반복문을 다시 실행하고 사용자로부터 다시 입력받는다.
            bool = A.check(s);
        }
        //두 번째 사용자의 입력을 위해 다시 bool을 false로 값을 할당한다.
        bool = false;

        //위와 같은 동작을 반복
        System.out.print("person-B>>");
        while (bool == false) {
            s = sc.nextLine();
            bool = B.check(s);
        }

        //Person클래스의 static으로 정의된 메소드를 호출한다.
        //이 때 인자(Argument)로 A,B 두 인스턴스를 전달한다.
        Person.winner(A, B);

    }
}

//가위바위보 게임에 참여하는 사람을 위한 class 정의
class Person{
    //Person클래스의 인스턴스 변수 answer을 선언한다.
    //이 때, private로 선언하여 클래스 외부에서의 접근을 불허한다.
    private int answer;

    //getAnswer()메소드를 통해서 answer인스턴스 변수를 반환한다.
    //이 때 설정자는 정의하지 않는다. 왜냐하면 check메소드를 통해 부정확한 값이 들어오는 것을 막고 있고
    //setter(설정자)를 통해 임의의 부정확한 값을 전달받으면 논리에 어긋나기 때문이다.
    int getAnswer(){
        return this.answer;
    }

    //check메소드는 인자로 전달받은 문자열이 '가위','바위','보' 중 하나이면 answer에 적당한 값을 할당하고 true를 반환한다.
    //반면 인자로 전달받은 문자열이 요구되는 입력(가위바위보)과 맞지 않을 경우 다시 입력해달라는 메시지(출력)과 함게 false를 반환한다.
    boolean check(String s){
        //if-else문을 통해 조건에 따라 실행흐름을 달리한다.
        //조건과 모두 일치하지 않을 경우 else문을 실행한다.
        if (s.equals("가위")) {
            answer=0;
            return true;
        } else if (s.equals("바위")) {
            answer=1;
            return true;
        } else if (s.equals("보")) {
            answer=2;
            return true;
        } else {
            System.out.print("다시 입력해주세요.>>");
            return false;
        }
    }
    //인자로 전달받은 두 개의 Person인스턴스중 승자가 누구인지 판단하는 메소드이다.
    //어느 한 인스턴스를 통해서 호출하지 않고 클래스 이름을 통해 호출하는 것이 논리적으로 더 맞다고 판단되며
    //단순히 외부에 기능을 제공하는 목적이 더 옳은 것 같아 static메소드로 정의하였다.
    static void winner(Person a,Person b){
        //인자를 통해 전달받은 Person형 인스턴스의 getAnswer인스턴스 메소드를 호출하여 각 인스턴스가 가지고있는 인스턴스 변수answer의 값을 n1,n2 Primitive변수(기본 타입인 int)에 저장
        int n1=a.getAnswer();
        int n2=b.getAnswer();


        //n1과 n2변수를 이용하여 승자를 판단한고 이 결과를 System클래스의 out변수(static으로 선언되었고 참조변수이다)가 참조하는 인스턴스의 println메소드 호출하여 출력
        //이 때 if-else문을 사용하여 무승부, A승리, B승리 세가지 실행흐름 중 하나를 선택하여 실행한다.(이 세가지 이외의 실행흐름은 존재할 수 없다.)
        if(n1==n2){
            System.out.println("무승부입니다.");
        }
        else if((n1+2)%3==n2){
            System.out.println("승자는 A입니다.");
        }
        else{
            System.out.println("승자는 B입니다.");
        }
    }
}
