package MyClass;

import java.util.Random;
import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        boolean bool;
        do {
            bool=Game.game();
        }while(bool==true);
        System.out.println("프로그램을 종료합니다.");
    }
}

class Game{
    protected static Scanner sc=new Scanner(System.in);
    protected static Card card=new Card();

    public static void gameVersionChoice(){
        System.out.print("1. 정답을 맞출 때까지 게임을 진행한다.\n2. 최대 횟수를 정하여 게임을 진행한다.\n입력>>");
        String version=sc.nextLine();

        if(version.equals("1")){
            game();
        }else if(version.equals("2")){
            int max = -1;
            do {
                System.out.print("최대 횟수를 입력하시오(0보다 큰 정수 입력)>>");
                try {
                    max = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                    continue;
                }
                if(max>=0){
                    break;
                }
            }while(true);
            game(max);
        }
        else{
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            gameVersionChoice();
        }
    }

    //게임 지속 여부에 관한 메소드이다.
    public static void continueGame(){
        String more;
        System.out.print("More Game(y/n)>>");
        more=sc.nextLine();
        more=more.toLowerCase();
        if(more.equals("y")){
            gameVersionChoice();
        }else if(more.equals("n")){
        }else{
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            continueGame();
        }
    }

    //사용자로부터 값을 입력받아 난수를 맞추었는지(게임을 진행하는) 메소드
    public static boolean game(){
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
    public static boolean game(int count){
        System.out.println("Hidden number is created. Try it!");
        card.newNumber();
        //int i가 0부터 count와 같을 때 까지 반복을 진행
        //count와 같을 때까지 진행하는 이유는 다음의 if문을 위해서이다.
        for(int i=0;i<=count;i++){
            //i가 count와 같으면 정답을 제한된 횟수에 맞추지 못한 경우이고
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
