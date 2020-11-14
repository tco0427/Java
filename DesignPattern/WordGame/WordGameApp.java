//WordGameApp이라는 이름의 클래스를 public으로 선언한다.
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
//public으로 선언된 클래스는 다른패키지(이외의 영역)에서 접근이 가능하다.분

//프로그램의 실행흐름을 제어하기 위한 용도의 클래
public class WordGameApp {
    //프로그램의 시작지점(Starting Point) main메소드이다.
    //자바 프로그램은 mian()메소드를 가지는 클래스가 반드시 하나는 존재해야하며
    //public static void로 선언되었으므로 반환형이 없고, 인스턴스 생성이전에 정저긍로 메소드 호출이가능하며
    //다른 패키지에서도 접근이 가능하다(public)(main메소드의 호출이 이뤄지는 영역은 클래스 외부이다.
    //main메소드에서 run()메소드 호출
    public static void main(String[] args) {
        run();
    }
    //run메소드도 static으로 선언되었으므로 main(static으로 정의된 메소드)에서 호출가능
    public static void run(){

        //System에 위치한 클래스 변수 out이 참조하는 인스턴스의 println메소드를 호출하여 인자로 문자열 전달
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇명입니까?");


        //UserInput클래스의 getInteger()(static으로 정의된 메소드)를 클래스 이름을 통해 접근하여 호출
        int personnel=UserInput.getInteger();

        //getInteger에서 사용자로부터 입력받은 값이 정상이 아닌경우 0을 반환하고
        //0보다 작은값을 입력하면 참가인원이 없는것으로 판단하고 프로그램을 종료
        if(personnel<=0){
            System.out.println("참가 인원이 없어 프로그램을 종료합니다.");
            return;
        }

        //WordGameApp(같은 클래스)에서 정의한 makePlayerArray를 통해 Player배열 생성
        //이는 Player인스턴스의 생성과는 무관하고 단지 Player인스턴스를 personnel개 저장(참조)할 수 있는 참조변수의 배열이다.
        Player[] players=makePlayerArray(personnel);
        //createPlayerElement메소드에 players(배열을 참조하고있는 참조변수)를 전달하여 실제 Player인스턴스를 생성한다.
        createPlayerElement(players);
        //startGame에 Player배열을 참조하는 players와 처음 시작 단어인 "아버지"를 전달한다.
        //이후의 프로그램에서 처음 시작하는 단어를 바꾸고 싶을 때 메소드를 직접바꾸는 것이 아닌 전달 인자를 변경함으로써
        //조금의 유연성을 얻을 수 있다고 생각된다.
        startGame(players,"아버지");

        //사용자에게 프로그램을 종료함을 알림
        System.out.println("프로그램을 종료합니다.");
    }

    //이전 시간에 배운 배열을 반환(return)하는 메소드를 활용해 보았다.
    //Primitive배열이 아닌 인스턴스를 참조할 수 있는 참조변수들의 배열을 생성하여 반환해보았다.
    //즉, 배열의 생성이 Player인스턴스의 생성과는 무관하며, 이 메소드를 통해 length개의 Player인스턴스를 참조할 수 있는(저장할 수 있는)
    //배열이 생성될 뿐이다.
    public static Player[] makePlayerArray(int length){
        Player[] players=new Player[length];
        return players;
    }


    //실제 게임을 시작하는 부분으로 Player인스턴스르 담은 배열과 처음 시작 단어를 전달받는다.
    public static void startGame(Player[] players,String word){
        System.out.println("시작하는 단어는 "+word+"입니다.");

        //각 순서를 위한 sequence 정수형 변수를 0으로 선언과 동시에 초기화한다.
        int sequence=0;

        //while(ture)를 통해 무한루프를 만들었다.
        //while문 내부에서 if문을 통해 while문을 빠져나오는 조건을 만든다.(break활용)
        while(true){
            //sequence가 배열의 길이와 같으면 모든 플레이어가 한바퀴 돈것이므로
            //다시 처음 플레이어의 순서가 되게끔 sequence의 값을 0으로 만들어준다.
            if(sequence==players.length){
                sequence-=players.length;
            }

            //players배열의 sequence인덱스의 Player인스턴스의 getWordFromUser()메소드를 통해 word를 입력받고 이를 word필드에 저장
            players[sequence].getWordFromUser();


            //Player인스턴스의 checkSuccess메소드의 인자로 처음 단어를 전달
            //참이면 if부분을 실행 거짓이면 else부분 실행
            if(players[sequence].checkSuccess(word)){
                //참이면 word에 Player인스턴스가 저장하고 있는 word를 getWord()를 통해 반환하여 저장
                word=players[sequence].getWord();
                //sequence의 값을 1증가
                sequence=sequence+1;
            }else{
                //거짓이면 그 플레이어가 끝말잇기에서 진것이므로 getName()을 통해 인스턴스에 저장된 name필드의 값을 반환하여
                //누가 졌는지 알리고 break을 통해 while반복문을 빠져나온다.
                System.out.println(players[sequence].getName()+"이 졌습니다.");
                break;
            }
        }
    }

    //Player배열의 각각의 Player인스턴스를 생성하는 메소드
    public static void createPlayerElement(Player[] players){
        //매개변수로 받은 배열의 길이를 personnel에 저장
        int personnel=players.length;
        //0~personnel-1까지 반복(총 personnel번)
        for(int i=0;i<personnel;i++){
            //참가자의 이름을 입력받아 이를 생성자의 인자로 전달하고 Player인스턴스를 생성
            //이를 배열이 참조(players배열은 인스턴스를 참조할 수 있는 참조변수의 배열로 볼 수 있음)
            System.out.print("참가자의 이름을 입력하세요>>");
            players[i]=new Player(UserInput.getString());
        }
    }
}
