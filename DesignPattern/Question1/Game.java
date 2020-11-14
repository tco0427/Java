/*
프로그램의 실행흐름을 제어하기 위한 용도의 클래스
프로그램의 시작지점(Starting Point) main메소드를 가지고 있는 클래스이다.
자바 프로그램은 mian()메소드를 가지는 클래스가 반드시 하나는 존재해야하며
public static void로 선언되었으므로 반환형이 없고, 인스턴스 생성 이전에 정적으로 메소드 호출이 가능하며
다른 패키지에서도 접근이 가능하다(public)(main메소드의 호출이 이뤄지는 영역은 클래스 외부이다.)
자바에서는 관례적으로 파일이름과 public으로 선언된 클래스의 이름이 동일해야 한다.
 */
public class Game {
    public static void main(String[] args) {
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다. **");
        System.out.println();
        //Bear와 Fish인스턴스를 생성하며 생성자를 호출한다. 이 때 적절한 인자를 전달해준다.
        //Bear와 Fish인스턴스를 GameObject형 참조변수를 통해 참조하는데 이렇게 추상상위형식에 맞춰서 프로그래밍함으로써
        //다형성을 활용할 수 있다.(ex. bear=new XXXX(MovingGameObject를 상속하는 객체 인스턴스를 참조하도록 실행중에 동적으로 변경가능))
        //즉 bear와fish는 GameObject를 상속하는 클래스의 인스턴스 모두 참조가능하다.
        MovingGameObject bear=new Bear(0,0,1);
        MovingGameObject fish=new Fish(5,10,1);

        //게임시작전 인스턴스를 참조하는 두 참조변수를 전달하므로써 격자판을 초기화한다.
        Grid.initGrid(fish,bear);

        //각각 반복의 횟수, 랜덤으로 생성되는 수를 저장하기 위한 변수, 움직인 횟수를 저장하기 위한 변수를 선언 및 초기화하였다.(random은 초기화X)
        int count=0;
        int sum=0;
        int random;
        int moveCount=0;


        //while루프의 조건식에 true를 전달함으로써 무한루프 구성
        while(true){
            Grid.showGrid();
            //Math클래스의 생성자는 private선언되어 있고 Math클래스에 정의된 메소드는 모두 staticㅇ로 정의되어 있다.
            //즉 이 클래스는 인스턴스 생성이 아닌 기능 제공이 목적인 클래스이다.
            //Math클래스의 random()메소드를 호출한다.
            //이 메소드는 0 이상 1 미만의 구간에서 근사적으로 균일한(approximately uniform) 부동소숫점 의사난수를 반환한다.
            //이렇게 반환된 의사난수에 2를 곱하고 int형으로 명시적형변환을 함에 따라 random변수는 0또는 1의 값을 가지게된다.
            //(0일 경우 움직이고 1일 경우 움직이지 않는다.)
            random=(int)(Math.random()*2);

            //GameObject에 정의되어 있는 collide(오버라이딩하지 않았으므로 fish가 참조하는 인스턴스, Fish클래스의 collide호출 시 GameObject의 collide를 호출한다.)
            //를 호출하여 반환값이 true인 경우 "Bear Wins!!"와 같은 메소드를 호출하고
            //break문을 통해 반복문을 빠져나온다.
            if(fish.collide(bear)){
                System.out.println("Bear Wins!!");
                break;
            }
            //30회 이내로 Bear가 Fish를 먹지 못하면 Fish의 승리가 되도록 하였다.
            //(단, sum은 5의 배수에 대해서만 검사가 가능하다. 왜냐하면 count==5일 때 sum에 5를 더해주기 때문이다.)
            if(sum>=30){
                System.out.println("Fish Wins!");
                break;
            }

            //Fish객체는 다섯 번 중 3번은 제자리에 있고 2번은 움직인다.(move())
            //따라서 이에 대한 알고리즘을 if문을 통하여 구현하였다.
            //만약 random이 0이고 총 움직인 횟수가 2회 미만이면
            if(random==0&&moveCount<2){
                fish.move();
                moveCount++;
            //만약 반복횟수가 5번째(count==4)이고 움직인 횟수가 2회 미만이면
            }else if(count>=4&&moveCount<2) {
                fish.move();
                moveCount++;
            //만약 반복횟수가 4번째(count==3)이고 한번도 움직이지 않았으면
            }else if(count>=3&&moveCount<1){
                fish.move();
                moveCount++;
            }
            bear.move();
            count++;

            //count가 5와 같으면 반복횟수를 저장하는 변수 count에 0,움직인 횟수를 저장하는 변수moveCount에 0을 저장한다.
            if(count==5){
                //반복횟수를 5의 단위로 sum(전체반복횟수)에 더해준다.
                sum=sum+count;
                count=0;
                moveCount=0;
            }
            System.out.println();
        }

        //프로그램을 종료함을 알린다.
        System.out.println("Program Termination");
    }
}
