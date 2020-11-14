//난수를 발생시키기위해 java.util패키지의 Random클래스를 import시킨다.
import java.util.Random;
//import문을 통하여 java.util패키지의 Scanner클래스를 import(포함)한다.
import java.util.Scanner;
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
//public으로 선언된 클래스는 다른 패키지에서도 접근이 가능하다.
public class CardGame {
    //프로그램의 시작지점(Starting Point) main메소드이다.
    //자바 프로그램은 main()메소드를 가지는 클래스가 반드시 하나는 존재해야하며
    //public static void로 선언되어있으므로 반환형이 없고(void),
    //인스턴스 생성이전에 정적으로(static)메소드 호출이 가능하며
    //다른 패키지에서도 접근이 가능하다(public)(main메소드의 호출이 이뤄지는 영역은 클래스 외부이다.
    public static void main(String[] args) {
        //do-while문을 빠져나오기 위한 지역변수 bool을 boolean형으로 선언한다.
        //초기값이 주어지지 않았다.
        boolean bool;

        //정답을 맞출 때까지 진행하는 game()메소드를 do-while문을 통해 최소 한 번 이상 호출한다.
        //이후에는 최대 횟수를 정하여 게임을 진행하거나 정답을 맞출때까지 게임을 진행할 수 있다.
        //따라서 bool의 값에 상관없이 do-while문을 진행하며 bool을 굳이 초기화하지 않은 이유와도 연관된다.
        do {
            bool=Game.playGame();
        }while(bool==true);
        //do-while문을 통해 {}몸체 부분을 최소 한 번 실행한 이후에 while문 다음에 오는 조건식을 통해 조건을 검사하고
        //참이면 계속해서 반복, 거짓이면 반복문을 빠져나온다.

        //System클래스에 위치한 클래스 변수 out이 참조하는 인스턴스의 println메소드를 호출한다.
        //이 때 "..."문자열 리터럴을 인자로 전달한다.
        System.out.println("프로그램을 종료합니다.");
    }
}

//Game이라는 이름의 클래스를 생성한다.
//이 클래스는 단순히 기능을 제공하기 위해 만든 클래스로 모든 메소드와 변수를 static으로 선언하였다.
class Game{
    //사용자로 부터 입력을 받기위해 Scanner클래스의 생성자에 표준입력스트림인 System.in을 전달하여 객체를 생성하고
    //이를 참조하는 참조변수를 'sc'라는 이름으로 선언하였다.
    protected static Scanner sc=new Scanner(System.in);
    //Card클래스의 인스턴스를 protected접근 지정자로 그리고 static으로 선언하였다.
    //'sc'와'card' 모두 protected로 선언한 이유는 다른 클래스에서의 사용을 막기위해서이고
    //static으로 선언한 이유는 어느 인스턴스에 종속되지 않고, 단순히 기능을 외부에 제공하기 위한 static메소드에서 사용하기위한 변수들이며
    //인스턴스 생성이전에 클래스 내부의 static메소드에서 접근하기 위해서이다.
    protected static Card card=new Card();

    //Card클래스의 모든 메소드는 static으로 선언하였다.
    //그 이유는 인스턴스 생성이 목적이 아니라 외부에 기능을 제공하는 것이 Card클래스의 목적이기 때문이다.

    //게임의 버전을 선택하기 위한 메소드
    public static void chooseGameVersion(){
        System.out.print("1. 정답을 맞출 때까지 게임을 진행한다.\n2. 최대 횟수를 정하여 게임을 진행한다.\n입력>>");
        //Scanner클래스의 nextLine()메소드를 통하여 문자열을 입력(공백포함,줄넘김이전까지)받고 String인스턴스를 생성한다.
        //이를 String형 참조변수 version이 참조한다.
        String version=sc.nextLine();

        //equals메소드를 통해 참조값이 아닌 내용을 비교한다.
        //version이 참조하는 인스턴스(String)과 "1"이 같으면 다음 문장 진행
        if(version.equals("1")){
            playGame();
        //if문이 거짓이고 다음 조건식이 참이면 다음 문장 실행
        }else if(version.equals("2")){
            //최대 횟수는 0보다 커야하므로 초기값을 -1로 주었다.
            int max = -1;
            //do-while문을 통하여 최소한 한 번 이상은 {}몸체 부분을 실행한다.
            do {
                System.out.print("최대 횟수를 입력하시오(0보다 큰 정수 입력)>>");
                //try-catch문을 통해 문자열을 숫자로 변환시키는 과정에서(실행시간에) 예외발생시 이를 catch문에서 처리한다.
                try {
                    //Scanner클래스의 nextLine()메소드를 통해 입력받은 문자열을 Wrapper Class중 하나인 Integer클래스에 static으로 정의되어 있는 parseInt()메소드를
                    //호출하여 인자로 전달(parseInt()메소드는 문자열을 전달받아 기본자료형의 형태로 변환하여 준다.
                    max = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    //NumberFormatException이 발생시(문자열을 숫자로 변환하는 과정에서의 예외발생) 이를 처리하기 위한 구문
                    //입력이 잘못되어 변환과정에 예외가 발생했음을 알린다.
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                    //continu문을 통해 반복문의 나머지 부분을 생략후, 반복문의 헤더부분(첫 문장)으로 돌아간다.
                    continue;
                }
                //max가 0보다 크면 정상적인 프로그램의 흐름이고 반복문을 break문을 통해 빠져나간다.
                if(max>0){
                    break;
                }
            }while(true);//조건식이 true이므로 무한루프이고 if문의 break을 통해 조건 만족시 반복문을 빠져나간다.
            //playGame메소드를 호출하며 max를 인자로 전달한다.
            playGame(max);
        }
        //모두 거짓이면 다음 문장 실행
        else{
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            //chooseGameVersion()메소드를 다시 호출한다.
            chooseGameVersion();
        }
    }

    //게임 지속 여부에 관한 메소드이다.
    public static void continueGame(){
        String more;
        System.out.print("More Game(y/n)>>");
        more=sc.nextLine();
        //사용자로 부터 입력을 String클래스의 toLowerCase()를 통해 소문자로 변환한다.
        more=more.toLowerCase();
        //if문이 참이면 다음 문장 실행
        if(more.equals("y")){
            //chooseGameVersion()메소드를 호출한다.
            chooseGameVersion();
        //위의 if문이 거짓이고 다음 조건식이 참이면 실행
        }else if(more.equals("n")){
        //몸체 부분이 비어있으므로 아무것도 하지 않는다.
        }else{
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            //continueGame()을 다시 호출한다.
            continueGame();
        }
    }

    //사용자로부터 값을 입력받아 난수를 맞추었는지(게임을 진행하는) 메소드
    public static boolean playGame(){
        System.out.println("Hidden number is created. Try it!");
        //Game클래스의 static변수 card의 newNumber()메소드를 호출하였다.
        card.newNumber();
        //조건식이 true이므로 무한루프이다.
        while(true) {
            System.out.print(">>");
            int input=-1;
            try {
                input = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("잘못 입력하셨습니다. 정수를 입력해주세요");
                continue;
            }
            //Card인스턴스를 참조하는 'card' static변수의 check메소드를 호출하며 인자로 input을 전달하고 있다.
            //Card클래스의 check메소드의 반환형이 참이면 다음 {}몸체 부분을 실행한다.
            if (card.check(input)) {
                //정답을 사용자에게 알린다.
                System.out.println("Correct!");
                //continuGame()메소드를 호출한다.
                continueGame();
                //false를 반환하며 메소드를 종료한다.
                return false;
            }
        }
    }
    //같은 메소드를 do-while문으로 작성해보았고 이를 주석처리하여 프로그램 실행에 오류가 없게 하였다.
    /*
    public static boolean playGame(){
        System.out.println("Hidden number is created. Try it!");
        card.newNumber();
        do{
            System.out.print(">>");
            int input=-1;
            try{
                input=Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("잘못 입력하셨습니다. 정수를 입력해주세요");
                continue;
            }
            if(card.check(input)){
                System.out.println("Correct!");
                continueGame();
                return false;
            }
        }while(true);
    }
     */


    //매개변수의 선언이 다르면서 동일한 이름의 메소드를 정의하는 메소드 오버로딩을 이용하여 다형성을 구현하였다.
    //난수를 추측할 수 있는 최대 입력 횟수를 정하여 게임 진행하기 위한 메소드로 int형 매개변수를 받는다.
    public static boolean playGame(int count){
        System.out.println("Hidden number is created. Try it!");
        card.newNumber();
        //int i가 0부터 count와 같을 때 까지 반복을 진행
        //count와 같을 때까지 진행하는 이유는 다음의 if문을 위해서이다.
        for(int i=0;i<=count;i++){
            //i가 count와 같으면 정답을 제한된 횟수에 맞추지 못한 경우이고
            //맞추지 못했다는 안내와 함께 계속할 것인지 여부를 묻는 continueGame을 호출한다.
            if(i==count){
                System.out.println("제한된 횟수("+count+")안에 정답을 맞추지 못하였습니다.");
                continueGame();
                break;
            }
            System.out.print(">>");
            int input=-1;
            try{
                input=Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("잘못 입력하셨습니다. 정수를 입력해주세요");
                i--;
                //반복문의 나머지를 생략하고 프로그램의 흐름을 반복문의 헤더부분으로 이어간다.
                //반복문을 빠져나가지 않으면서 즉시 다음 반복으로 넘어감
                continue;
            }
            if(card.check(input)){
                System.out.println("Correct!");
                continueGame();
                break;
            }
        }
        return false;
    }
}

//Card클래스
class Card{
    //난수를 생성하기위한 Random클래스의 인스턴스를 생성자를 통해 생성하고 rand라는 이름의 참조변수로 참조
    Random rand=new Random();
    //난수를 저장하기 위한 변수 randomNumber선언
    int randomNumber;
    //생성자를 통해 처음 인스턴스 생성시에 Random클래스의 nextInt메소드를 통해 randomNumber에 0이상100미만의(0~99)사이의 난수를 생성하고 저장
    public Card(){
        randomNumber=rand.nextInt(100);
    }
    //newNumber()메소드 호출시 새로운 게임을 위하여 난수를 새로 생성한다.
    public void newNumber(){
        randomNumber=rand.nextInt(100);
    }
    //매개변수로 받은 값을 인스턴스 변수 randomNumber와 비교한다.
    public boolean check(int num){
        //같으면 true를 반환
        if(randomNumber==num)
            return true;
        //다를 경우 난수가 매개변수로 받은 값보다 작은지 큰지를 사용자에게 알리고
        //false를 반환한다.
        else if(randomNumber<num){
            System.out.println("Lower");
            return false;
        }
        else if(randomNumber>num){
            System.out.println("Higher");
            return false;
        }
        return false;
    }
}
