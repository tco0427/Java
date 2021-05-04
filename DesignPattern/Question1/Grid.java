/*
게임화면(격자판)을 표시하기 위한 클래스이다.
char형 배열을 참조할 수 있는 참조변수를 static멤버로 가지고 있다.
그리고 이 참조변수를 grid라는 이름으로 정의하였고 이는 char[10][20]의 배열인스턴스를 참조한다.
(static변수는 클래스 로딩시에 정적으로 메소드영역(클래스영역)에 생성된다(바인딩된다).
grid는 private(접근 수준 지시자Access-level Modifiers)로 선언하였으므로 클래스 내부에서만 접근이 가능하다.
Grid클래스의 모든 메소드는 public,static으로 정의되어있다.(이클래스 이외의 영역에서도 모두 접근이 가능하며 인스턴스 생성과 무관하게 접근가능하다.)
또한 생성자에대해 private로 선언함으로써 클래스외부에서의 생성자호출을 제한한다.(즉 클래스 외부에서 인스턴스 생성이 불가능하다.)
이는 이 클래스는 인스턴스의 생성이 목적이 아니고 외부에 기능을 제공하기 위함이기 때문이다.
initGrid 메소드에서는 인스턴스 변수가 참조하는 배열을 초기화한다.
이 때 매개변수를 통해 2개의 GameObject형 참조변수로 참조 가능한 인스턴스를 전달받는다.
(GameObject클래스 혹은 이를 상속하는 클래스의 인스턴스 모두 인자로 전달 가능 하지만 주의할 점은 GamObject는 추상클래스이므로 GamObject인스턴스는 불가능하다.)
(이와 같이 추상타입을 이용함으로써 구현 교체의 유연함을 얻을 수 있다.)
initGrid메소드 내에서 public static으로 정의된 setGameObject를 호출하며 매개변수로 전달받은 인스턴스를 전달한다.
initGrid메소드와 SetGameObject(),resetGrid()메소드의 매개변수형을 GameObject로 정의함으로써 다형성을 활용할 수 있다.
(GameObject를 상속하는 클래스의 인스턴스는 모두 참조 가능하다.)
 */

public class Grid {
    private static char[][] grid=new char[10][20];
    //게임을 처음 시작할 때 배열을 초기화하기 위한 메소드로 게임에 참여하는 객체(Bear,Fish)를 매개변수로 받는다

    //아무런 기능도 하지 않는(몸체가 비어있는) 생성자를 private접근 지정자로 선언하였다.
    //또한 생성자를 제외한 Grid클래스의 모든 메소드는 public static으로 정의되어있다.
    //이렇게 한 이유는 이 클래스는 인스턴스의 생성이 목적이 아니고 외부에 기능을 제공하기 위함이다.
    private Grid(){}

    //매개변수로 선언된 GameObject형 참조변수를 통해 구현 교체의 유연함을 얻을 수 있다.
    public static void initGrid(GameObject fish,GameObject bear){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                grid[i][j]='-';
            }
        }
        setGameObject(fish);
        setGameObject(bear);
    }
    //GameObject참조변수로 참조가능한 객체를 매개변수로 전달받는다. 이를 통해 getShape()을 호출하여 객체에 대한 모양,심볼을 배열에 나타낸다.
    //GameObject형 참조변수로 인해 인자로 전달되는 인스턴스에 따라 교체가 유연해진다.(이를 상속하는 모든 클래스의 인스턴스가 전달될 수 있음)
    public static void setGameObject(GameObject gObject){
        grid[gObject.getX()][gObject.getY()]=gObject.getShape();
    }
    //배열 전체를 출력하는 메소드
    public static void showGrid(){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    //매개변수를 통해 전달받은 객체의 getX(),getY()를 통해 해당인덱스의 char를 '-'로 바꾼다.
    public static void resetGrid(GameObject gObject){
        grid[gObject.getX()][gObject.getY()]='-';
    }
}
