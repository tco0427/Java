/*
게임에 등장하는 Bear객체와 Fish객체의 상위클래스로 추상클래스로 정의되어 있다.(Bear와 Fish는 움직일 수 있다.)
GameObject에서는 단순히 GameObject에 대한 개관을 만들었다면
MobingGameObject에서는 움직임을 가지는 게임객체에 대한 개관을 만들어 두었다고 볼 수 있다.
따라서 MovingGameObject는 GameObject추상클래스를 상속받으며 이를 구현하는 객체마다 움직임을 다르게 하여 다형성을 구현할 것이기 때문에
움직이는 기능을 하는(물론 여기서는 그 기능에 대한 구현은 없음 기능에 대한 개관만을 제시) 메소드 move()를 추상메소드로 정의하였고
이러한 추상메소드를 가지는 MovingGameObject 또한 GameObject와 마찬가지로 추상클래스이다.
 */

public abstract class MovingGameObject extends GameObject {
    //움직일 때의 이동거리를 나타내기 위한 필드(멤버 변수,인스턴스 변수)
    //GameObject는 단순히 게임 객체에 대해 나타내기 위해 정의된 추상클래스이고
    //MovingGameObject에서 움직임에 대한 개념이 추가되었으므로 distance필드도 MovingGameObject클래스에서 정의하는 것이 옳다고 생각된다.
    protected int distance;

    //MovingGameObject에서 상위클래스(GameObject)의 생성자를 super()를 통해 명시적으로 호출한다.(상위클래스의 생성자 호출문 super는 생성자의 첫문장에 와야한다.)
    //이와 같은 이유는 상위 클래스의 멤버는 상위클래스의 생성자를 통해 초기화하도록 유도하기 위함이다.
    //MovingGameObject에서 추가된 필드(인스턴스 변수) distance에 대해서도 생성자에서 초기화해준다.
    //이를 상속을 통해 구현하는 하위클래스에서만이 추상클래스의 생성자를 호출하므로 protected선언을 통해 접근을 조금 더 세밀하게 제한하였다.
    protected MovingGameObject(int startX,int startY,int distance){
        super(startX,startY);
        this.distance=distance;
    }

    //protected접근 지정자를 갖는 추상메소드 move()
    //이 클래스를 상속하여 구현하는 객체마다 어떤 방식으로 움직임을 구현할지에 대한 방법은 다양함.
    //오버라이딩을 통해 동적인 다형성을 제공한다. Fish에서는 랜덤으로 move(),Bear에서는 사용자 입력으로 move()
    protected abstract void move();

    //각 방향에 대한 움직임을 나타낸 메소드
    //만약 움직임에 대한 메소드를 Bear,Fish를 포함하여 셀 수 없이 많은 (예를들어) 100000개의 각 클래스에서 직접 구현시
    //향후에 움직임에 대한 알고리즘이 변경되어 수정하게 되면 각 클래스마다 하나씩 일일히 수정해야한다.
    //하지만 이를 상위클래스(MovingGameObject)에서 구현 시 상위클래스에서의 구현만 변경하여주면 된다.
    protected void moveLeft(){
        if((getY()-distance)<=0){
            y=0;
        }else{
            y=y-distance;
        }
    }
    protected void moveRight(){
        if(getY()+distance>=19){
            y=19;
        }else{
            y=y+distance;
        }
    }
    protected void moveUp(){
        if((getX()-distance)<=0){
            x=0;
        }else {
            x = x - distance;
        }
    }
    protected void moveDown(){
        if((getX()+distance)>=9){
            x=9;
        }else {
            x = x + distance;
        }
    }
}
