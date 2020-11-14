/*
java.util패키지의 Rancom클래스를 import하였다.
Fish라는 이름의 클래스를 정의하며 이는 GameObject클래스를 상속한다.
GameObject추상클래스의 모든 추상메소드를 구현하거나 혹은 Fish클래스도 추상클래스가 된다.(이 경우에는 상위클래스의 추상메소드 모두 구현)
하위클래스의 인스턴스 생성 시 즉 하위클래스의 생성자 호출 시 상위클래스의 생성자도 함께 호출된다. 이 때 하위 클래스에서 상위클래스의 생성자 호출이 명시적이지 않은 경우
인자를 전달받지 않는 상위클래스의 생성자가 컴파일러에 의해 자동 삽입,호출된다.(이 때 상위클래스에 인자를 전달받지 않는 생성자 없을 시 오류)
하위클래스의 생성자에서 상위클래스의 생성자를 호출하지 않으면 컴파일 오류를 발생시킨다.
이와 같은 이유는 상위 클래스의 멤버는 상위클래스의 생성자를 통해 초기화하도록 유도하기 위함이다.
상위클래스의 생성자를 명시적으로 호출하기 위해서는 하위클래스의 생성자에서 super()와 같은 형태로 나타내는데 매개변수형식을 통해 상위클래스의 생성자를 선택한다.
이 때, super()는 하위클래스 생성자의 몸체 부분에 앞서 실행되어야 한다. 즉, 상위클래스의 생성자 호출문 super는 생성자의 첫 문장으로 등장해야 한다.
상위클래스(GameObject추상클래스)에 정의되어 있는 추상메소드 move(),getShape()에 대한 구체적인 구현을 하위클래스인 Fish클래스에서 오버라이딩을 통해 구현하였다.
 */

import java.util.Random;

public class Fish extends MovingGameObject {
    //생성
    public Fish(int startX,int startY,int distance){
        super(startX,startY,distance);
    }
    @Override
    //추상타입(MovingGameObject)에 정의되어 있는 move()메소드를 구현하였다.
    //Bear클래스의 경우 사용자의 입력에 따라 동작하도록 구현하였다.(다형성)
    public void move(){
        //사용자에게 출력할 격자판을 재설정한다.(인자로 객체 자신에 대한 래퍼런스 전달)
        Grid.resetGrid(this);
        //Random인스턴스 생성시에 인자로 시드값전달x시 현재시간을 시드값으로 하고 이 시드값을 인자로 받는 다른 생성자 호출
        //즉 생성자가 다음과 같은 상태
        /*
        public Random(){
            this(System.currentTimeMillis());
        }
         */
        Random rand=new Random();
        //rand가 참조하는 Random객체의 nextInt메소드를 호출하며 인자로 4를 전달한다.
        //nextInt는 0이상 bounc(인자로 전달된 정수)미만 범위의 int형 난수를 반환한다.
        int randomNumber=rand.nextInt(4);

        //다중 if-else문을 통해 랜덤으로 생성된 int형 정수에 따라 동작이 구분된다.
        //Fish인스턴스는 랜덤하게 방향을 정해 움직이게 된다.
        if(randomNumber==0){
            moveLeft();
        }else if(randomNumber==1){
            moveDown();
        }else if(randomNumber==2){
            moveUp();
        }else if(randomNumber==3){
            moveRight();
        }
        //격자판에 움직인 이후의 위치에 Bear객체의 모양을 표시한다.(인자로 객체 자신에 대한 래퍼런스 전달)
        Grid.setGameObject(this);
    }
    //각 객체에 맞게끔 모양을 나타내는 문자를 반환하도록 상위 추상클래스의 메소드를 오버라이딩을 통해 구현
    //이를 통해 다형성 실현
    @Override
    public char getShape(){
        return '@';
    }
}
