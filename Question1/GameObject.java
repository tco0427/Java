/*
게임에 등장하는 객체에 대한 개관에 대한 상위 추상클래스로 정의되어 있다.(추상화)
GameObject는 추상타입으로 일종의 설계도,표준으로 볼 수 있는데 설계와 구현을 분리했다고 볼 수 있다.
getShape()과 같은 메소드를 추상메소드로 정의하여 개념만을 정의하고 하위클래스에서 이를 구현한다.
게임에 사용되는 객체에 대한 전체적인 개관으로 볼 수 있다.
필드(인스턴스 변수)에 대해서 protected로 선언하여 동일패키지 혹은 상속관계에서만 접근할 수 있도록 하였다.
생성자를 정의하여 필드에 대한 초기화를 진행한다.(물론 추상클래스를 대상으로 인스턴스의 생성은 불가능하다.)
(추상클래스를 상속을 통해 구현하는 하위클래스에서만이 추상클래스의 생성자를 super를 통해 호출할 수 있도록 protected로 접근을 조금 더 세밀하게 제한하였다.)
(참고로 필드와 생성자의 정의는 인터페이스로는 불가능하다.)
protected접근 지정자를 가지는 x와y필드에 대한 접근자메소드(getXXX())를 정의해주었다.
이 접근자메소드를 통해 외부에서도 필드에 대한 간접적인 접근이 가능하다.(public)
(다른 패키지의 상속관계가 아닌 클래스에서 필드에 '직접적인' 접근은 여전히 불가)
protected접근 지정자를 갖는 추상메소드 getShape() 정의(구체적인 구현은 하위클래스에서 수행하며 각 클래스마다 다른 모양을 가질 수 있음)
(오버라이딩을 통해 동적으로 다형성을 구현한다. 이(추상타입)를 상속하여 구현하는 구상클래스마다 getShape()는 각 클래스에 맞게 다르게 구현)

 */
public abstract class GameObject{
    protected int x,y;
    //이를 구현하는 하위의 구상(concrete)클래스에서 super()를 통해 상위클래스(GameObject)의 생성자를 호출하므로 protected로 접근을 제한
    protected GameObject(int startX,int startY){
        this.x=startX;
        this.y=startY;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    protected abstract char getShape();
    //이 객체가 객체 p와 충돌했으면 true리턴(움직임이 있는 객체에서 두 객체가 충돌 시)
    //만약 움직임에 대한 개념이 없고 단지 화면상에 게임의 객체를 표현하고 싶은경우(GameObject만을 상속하여 구현한 객체의 경우)에는
    //두 객체가 같은 위치에 충돌되었으므로 화면 표현에 이상이 있을 것임을 알리는 기능을 할 수 있을 것이다.
    public boolean collide(GameObject p){
        if(this.x==p.getX()&&this.y==p.getY()){
            return true;
        }
        else return false;
    }
}
