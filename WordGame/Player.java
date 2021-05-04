//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
//public으로 선언된 클래스는 다른패키지(이외의 영역)에서 접근이 가능하다.

//각 선수들에 대한 정보와 이런 정보(필드,데이터)를 위한 기능들을 정의한 클래스
public class Player {

    //Player클래스의 필드는 모두 private로 선언하여 외부에서의 접근을 막았다.
    //이는 캡슐화원칙을 지키기 위해 웬만하면 필드에 대해서는 private로 선언하는 것이 좋다고 생각하여 private로 선언
    private String name;
    private String word;

    //굳이 만들지 않아도 되는 생성자이지만 this를 통한 다른 생성자의 호출을 연습하기 위해
    //문자열("")를 전달하는 생성자를 추가로 정의해 두었다.
    //이후의 프로그램의 유지보수 과정에서 이름을 전달받지 않는 생성자가 요구될 수도 있
    public Player(){
        this("");
    }
    public Player(String name){
        this.name=name;
    }

    //getName()메소드를 통해 name필드에 대한 접근자 메소드를 정의하였다.
    public String getName(){
        return this.name;
    }

    //getWordFromUser()메소드를 통해 플레이어가 입력하는 단어를 각 인스턴스의 word필드에서 저장하게끔 하였다.
    public void getWordFromUser(){
        System.out.print(this.name+">>");
        this.word=UserInput.getString();
    }

    //각 인스턴스마다 저장해둔 word 인스턴스 변수에 담긴 값을 반환하는 접근자 메소드
    public String getWord(){
        return this.word;
    }

    //이전 플레이어가 입력한 단어의 마지막 글자와 현재 플레이어가 입력한 첫번째 단어의 일치를 확인하는 메소드
    //String형 인자를 받고boolean형 값을 반환한다.
    public boolean checkSuccess(String word){
        //이전플레이어가 입력했던 word를 인자로 받는다.
        //배열의 마지막 글자(원소)의 인덱스는 배열의 길이-1이므로(String인스턴스에서도 0~n-1을 charAt()메소드를 통해 글자 하나장(char)를 반환해줌)
        //word.length()를 통해 구한 word의 길이에서 1을 빼준다.
        int lastIndex=word.length()-1;
        //그 인덱스에 해당하는 글자하나를 반환하여 char형에 저장
        char lastChar=word.charAt(lastIndex);
        //this를 통해 현재 인스턴스의 word 인스턴스 변수에 접근
        //현재 메소드 내에서는 인스턴스 변수 word의 가시성이 없고 매개변수 word의 가시성이 존재
        //따라서 this를 통해 현재 인슽턴스의 인스턴스변수 word 접근
        char firstChar=this.word.charAt(0);
        //두 글자(char)가 일치하면 true,아니면 false반환을 if-else문으로 구현
        if(lastChar==firstChar)
            return true;
        else
            return false;
    }
}
