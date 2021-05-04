/*
GameObject추상클래스를 상속받는 Bear클래스를 정의하였다.
GameObject추상클래스의 모든 추상메소드를 구현하거나 혹은 Bear클래스도 추상클래스가 된다.(이 경우에는 상위클래스의 추상메소드 모두 구현)
하위클래스의 인스턴스 생성 시 즉 하위클래스의 생성자 호출 시 상위클래스의 생성자도 함께 호출된다. 이 때 하위 클래스에서 상위클래스의 생성자 호출이 명시적이지 않은 경우
인자를 전달받지 않는 상위클래스의 생성자가 컴파일러에 의해 자동 삽입,호출된다.(이 때 상위클래스에 인자를 전달받지 않는 생성자 없을 시 오류)
하위클래스의 생성자에서 상위클래스의 생성자를 호출하지 않으면 컴파일 오류를 발생시킨다.
이와 같은 이유는 상위 클래스의 멤버는 상위클래스의 생성자를 통해 초기화하도록 유도하기 위함이다.
상위클래스의 생성자를 명시적으로 호출하기 위해서는 하위클래스의 생성자에서 super()와 같은 형태로 나타내는데 매개변수형식을 통해 상위클래스의 생성자를 선택한다.
이 때, super()는 하위클래스 생성자의 몸체 부분에 앞서 실행되어야 한다. 즉, 상위클래스의 생성자 호출문 super는 생성자의 첫 문장으로 등장해야 한다.
상위클래스(GameObject추상클래스)에 정의되어 있는 추상메소드 move(),getShape()에 대한 구체적인 구현을 하위클래스인 Bear클래스에서 오버라이딩을 통해 구현하였다.
 */

public class Bear extends MovingGameObject {
    //생성자
    public Bear(int startX,int startY,int distance){super(startX,startY,distance);}
    //어노테이션은 자바 컴파일러에게 메시지를 전달하는 목적의 메모로 볼 수 있는데(메타데이터)
    //@Override를 통하여 오버라이딩이 제대로 이루어졌는지 컴파일과정에서 발견가능하다.(개발자의 실수를 잡아냄)
    //스프링 프레임워크등에서 특수 기능을 위해 사용하므로 어노테이션에 익숙해지는 것이 좋다고 생각한다.
    @Override
    //추상타입(MovingGameObject)에 정의되어 있는 move()메소드를 구현하였다.
    //Bear클래스의 경우 사용자의 입력에 따라 동작하도록 구현하였다.(다형성)
    public void move(){
        //사용자에게 출력할 격자판을 재설정한다.(인자로 객체 자신에 대한 래퍼런스 전달)
        Grid.resetGrid(this);
        System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
        //UserInput클래스의 public static으로 정의된 메소드를 클래스이름을 통해 참조하고 이 메소드가 반환하는
        //문자(char형) 데이터를 c라는 char형 변수에 저장한다.
        char c=UserInput.getChar();

        //다중 if-else문을 통해 사용자로부터 입력받은 문자를 통해 동작이 구분된다.
        if(c=='a'){
            moveLeft();
        }else if(c=='s'){
            moveDown();
        }else if(c=='d'){
            moveUp();
        }else if(c=='f'){
            moveRight();
        }else{
            System.out.println("잘못된 입력입니다.");
        }
        //격자판에 움직인 이후의 위치에 Bear객체의 모양을 표시한다.(인자로 객체 자신에 대한 래퍼런스 전달)
        Grid.setGameObject(this);
    }
    //각 객체에 맞게끔 모양을 나타내는 문자를 반환하도록 상위 추상클래스의 메소드를 오버라이딩을 통해 구현
    //이를 통해 다형성 실현
    @Override
    public char getShape(){
        return 'B';
    }
}
