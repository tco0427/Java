/*
Lab7
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/26
 */

//import문을 통하여 java.util패키지의 Arrays클래스를 import한다.
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려줌을 통해
//클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
//이 때 서로 다른 패키지의 동일한 이름의 클래스를 대상으로 동시에 import하는 것은 불가능하며, 디폴트패키지를 import할수도 없다.(컴파일 에러) 왜냐하면 default package는 어나니머스, 즉 이름이 없는 패키지이기 때문이다.
import java.util.Arrays;
import java.util.List;

//main메소드를 가지고 있는 클래스
//실제 프로그램의 실행흐름을 담당
//실행흐름제어(컨트롤)
//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
public class Lab7 {
    /*
    PeriodicElement[]배열 참조변수를 선언하였다.
    PeriodicElement는 추상클래스로 인스턴스 생성이 불가능하다.
    PeriodicElement배열은 인스턴스에 대한 레퍼런스를 갖는 배열이고 배열의 원소들이 참조하는 각각의 인스턴스들은 PeriodicElement추상클래스를 구현하는 구상클래스의 인스턴스들이다.
    //배열의 형이 PeriodicElement이므로 이를 상속하는 하위클래스 인스턴스를 참조할 수 있다.(상위클래스의 참조변수는 하위클래스의 인스턴스를 참조할 수 있다.)
    //그리고 배열의 생성은 실제 인스턴스의 생성과 무관하다. 즉, PeriodicElement인스턴스 생성이 아닌 PeriodicElement형 참조변수의 배열을 생성한 것으로 볼 수 있다.
    //하지만 현재 이 코드와 관련된 경우 배열을 생성하면서 동시에 각 인스턴스들을 생성하여 이를 원소로하고 있다. 즉 배열의 선언과 동시에 초기화를 한 것이다.
    private로 선언하였으므로 클래스 내부에서만 접근이 가능하며 static으로 선언되었으므로 클래스 로딩시에 정적으로(static) 메모리 공간을 할당받으며
    Lab5클래스의 인스턴스생성과는 무관하게 접근이 가능하다.
     */

    //PeriodicElement[] 배열의 각 원소들을 생성하는 코드
    //PeriodicElement[]형 참조변수로 참조하는 배열인스턴스의 원소로는 PeriodicElement와 상속관계인 하위 클래스의 인스턴스를 둘 수 있다.
    //즉 상위클래스의 참조변수는 하위클래스의 인스턴스를 참조할 수 있다.
    //(ex. GasPeridoicELement is a PeriodicElement)
    private static PeriodicElement[] elements = {
            new GasPeriodicElement(1, "H", "HYDROGEN", 1.008),
            new GasPeriodicElement(2, "He", "HELIUM", 4.0026),
            new SolidPeriodicElement(3, "Li", "LITHIUM", 6.94),
            new SolidPeriodicElement(4, "Be", "BERYLLIUM", 9.0122),
            new SolidPeriodicElement(5, "B", "BORON", 10.81),
            new SolidPeriodicElement(6, "C", "CARBON", 12.011),
            new GasPeriodicElement(7, "N", "NITROGEN", 14.007),
            new GasPeriodicElement(8, "O", "OXYGEN", 15.999),
            new GasPeriodicElement(9, "F", "FLUORINE", 18.998),
            new GasPeriodicElement(10, "Ne", "NEON", 20.18),
            new SolidPeriodicElement(11, "Na", "SODIUM", 22.99),
            new SolidPeriodicElement(12, "Mg", "MAGNESIUM", 24.305),
            new SolidPeriodicElement(13, "Al", "ALUMINIUM", 26.982),
            new SolidPeriodicElement(14, "Si", "SILICON", 28.085),
            new SolidPeriodicElement(15, "P", "PHOSPHOROUS", 30.974),
            new SolidPeriodicElement(16, "S", "SULFUR", 32.06),
            new GasPeriodicElement(17, "Cl", "CHLORINE", 35.45),
            new GasPeriodicElement(18, "Ar", "ARGON", 39.948),
            new SolidPeriodicElement(19, "K", "POTASSIUM", 39.098),
            new SolidPeriodicElement(20, "Ca", "CALCIUM", 40.078),
            new SolidPeriodicElement(21, "Sc", "SCANDIUM", 44.956),
            new SolidPeriodicElement(22, "Ti", "TITANIUM", 47.867),
            new SolidPeriodicElement(23, "V", "VANADIUM", 50.942),
            new SolidPeriodicElement(24, "Cr", "CHROMIUM", 51.996),
            new SolidPeriodicElement(25, "Mn", "MANGANESE", 54.938),
            new SolidPeriodicElement(26, "Fe", "FERRUM", 55.845),
            new SolidPeriodicElement(27, "Co", "COBALT", 58.933),
            new SolidPeriodicElement(28, "Ni", "NICKEL", 58.693),
            new SolidPeriodicElement(29, "Cu", "CUPRUM", 63.546),
            new SolidPeriodicElement(30, "Zn", "ZINC", 65.38),
            new SolidPeriodicElement(31, "Ga", "GALLIUM", 69.723),
            new SolidPeriodicElement(32, "Ge", "GERMANIUM", 72.63),
            new SolidPeriodicElement(33, "As", "ARSENIC", 74.922),
            new SolidPeriodicElement(34, "Se", "SELENIUM", 78.971),
            new LiquidPeriodicElement(35, "Br", "BROMINE", 79.904),
            new GasPeriodicElement(36, "Kr", "KRYPTON", 83.798),
            new SolidPeriodicElement(37, "Rb", "RUBIDIUM", 85.468),
            new SolidPeriodicElement(38, "Sr", "STRONTIUM", 87.62),
            new SolidPeriodicElement(39, "Y", "YTTRIUM", 88.906),
            new SolidPeriodicElement(40, "Zr", "ZIRCONIUM", 91.224),
            new SolidPeriodicElement(41, "Nb", "NIOBIUM", 92.906),
            new SolidPeriodicElement(42, "Mo", "MOLYBDENUM", 95.95),
            new UnknownPeriodicElement(43, "Tc", "TECHNETIUM", 98),
            new SolidPeriodicElement(44, "Ru", "RUTHENIUM", 101.07),
            new SolidPeriodicElement(45, "Rh", "RHODIUM", 102.91),
            new SolidPeriodicElement(46, "Pd", "PALLADIUM", 106.42),
            new SolidPeriodicElement(47, "Ag", "SILVER", 107.87),
            new SolidPeriodicElement(48, "Cd", "CADMIUM", 112.41),
            new SolidPeriodicElement(49, "In", "INDIUM", 114.82),
            new SolidPeriodicElement(50, "Sn", "TIN", 118.71)
    };

    //PeriodicTable형 인스턴스를 생성하고 이를 ptable이라는 이름의 PeriodicTable형 참조변수로 참조한다.
    //이 때, 앞서 static으로 정의한 PeriodicElement[]형인 elements를 생성자의 인자로 전달한다.
    /*
    private접근지정자로 선언하였으므로 클래스 내부에서만 접근이 가능하며
    static으로 선언되었으므로 클래스 로딩시에 정적으로(static) 메모리 공간을 할당받으며
    인스턴스생성과는 무관하게 접근이 가능하다.(클래스 내부에서만)
     */
    private static PeriodicTable ptable=new PeriodicTable(elements);

    /*
    private static으로 선언되었으므로 인스턴스생성과 무관하게 클래스 로딩시에 생성된다고 볼 수 있다.
    또한 private로 선언되었으므로 클래스 내부에서만 접근이 가능하다.
     */
    private static PeriodicElement getPeriodicElement(PeriodicElement[] array,Element e){
        /*
        매개변수로 전달받은 array배열의 모든 원소를 for-each문을 통해 접근한다.
        즉 for(요소: 배열(반복의 대상))꼴이 되는 것이다. 변수 pe에는 반복을 하면서 배열의 각각의 요소의 값이 담기게 된다.
        (여기서는 PeriodicElement형 변수 pe가 배열의 각각의 요소가 참조하는 인스턴스를 pe 또한 참조한다.)
        따라서 배열의 원소중들의 getNumber()와 매개변수로 전달받은 Element e의getValue()의 값이 같으면(if문이 참이되면)
        배열의 요소인 pe가 참조하는 인스턴스를 반환하고 만약 for-each문을 통해 배열 전체를 도는 동안 if문을 만족시키지 못했으면
        null을 반환하게된다.
         */
        for(PeriodicElement pe: array){
            if(pe.getNumber()==e.getValue()){
                //return은 메소드를 호출한 영역으로 값을 반환한다는 의미도 지니지만
                //메소드의 종료를 의미하기도 한다.
                //따라서 메소드 중간에서 return문이 실행되면 값이 반환되면서(혹은 값의반환없이) 메소드의 실행은 종료된다.
                return pe;
            }
        }
        return null;
    }

    //내가 추가한 메소드
    //프로그램상에 적절한 원소번호(ElementInteger)를 입력받았는지 확인하는 메소드이다.(원소번호는 1부터 시작하며 프로그램상에는 원소번호50번까지의 원소가 존재한다.)
    //이에따라 true혹은 flase를 반환한다.
    public static boolean checkElementInteger(int[] intArray){
        //intArray의 인스턴스 변수 length를 통해 배열의 길이정보를 알아내서 0부터 길이-1까지(모든 배열 원소의 인덱스)를 for문을 통해 접근할 수 있다.
        for(int i=0;i<intArray.length;i++){
            //배열은 생성되면 모든 요소는 0또는 null로 초기화된다.만약 0보다 작으면
            //Integer.parseInt()에 문제가 있다는 것이거나
            //사용자가 잘못된 입력을 한 경우이다.(원소번호는 1부터 시작이고 따라서 min혹은 max값도 1보다 크거나 같아야한다.)
            //또 프로그램에 저장된 원소는 원소번호50번까지 이므로 이에 대해서도 검사한다.
            if(intArray[i]<=0||intArray[i]>50)
                //false를 반환하고 return을 만났으므로 메소드를 종료한다.
                return false;
        }

        //for문을 반복하는 동안 if문이 실행되지 않았다면 true를 반환하고 return(메소드를 종료)한다.
        return true;
    }
    //내가 추가한 메소드
    //static으로 정의된 main메소드에서 사용하는 메소드이므로 static으로 정의하였다.
    //매개변수를 통해 전달받은 key에 따라서 periodicTableList의 elementNumber(이전,현재,이후)에 해당하는 원소를 반환한다.
    public static PeriodicElement prevOrNextOrCurrent(PeriodicTableList periodicTableList, int elementIndex, char key) {
        //매개변수를 통해 PeriodicTableList인스턴스와 elementIndex, key를 받는다.
        //이 때 getPrev,getNext,get 3가지 메소드는 모두 IndexOutOfBoundsException예외를 일으킬 가능성이 있고
        //예외가 발생하면 이 getPrev,getNext,get을 호출하는 영역으로 throws를 통해 넘긴다.
        //따라서 이를 사용하는 다음의 영역에서 try-catch구문을 통해 처리하여준다.
        try {
            //매개변수를 통해 전달받은 char형 값이 'p','n','c'중 어느값인지에 따라서
            //PeriodicTableList의 getPrev(),getNext(),get()이 호출된다.(인자로 매개변수를 통해 전달받은 elementIndex를 전달한다.)
            //만약 이 때 잘못된 인덱스접근이 있는 경우 IndexOutOfBoundsException클래스의 인스턴스가 생성되고 catch문의 매개변수로 전달된다.
            //정상적인 인덱스 접근이라면 if를 통해 나누어지는 3가지 실행흐름들은 PeriodicElement(실제로는 이 추상클래스에 대한 구상클래스)인스턴스를 return을 통해 반환하면 메소드를 종료한다.
            if (key == 'p') {
                return periodicTableList.getPrev(elementIndex);
            } else if (key == 'n') {
                return periodicTableList.getNext(elementIndex);
            } else if (key == 'c') {
                return periodicTableList.get(elementIndex);
            }
        }catch(IndexOutOfBoundsException e){
            //사용자에게 잘못된 인덱스 접근이 있음을 알리고 return을 통해 null을 반환하면서 메소드를 종료한다.
            System.out.println("PeriodicTableList에 존재하지 않는 인덱스에 대해서 접근을 시도하였습니다.\n");
            return null;
        }
        return null;
    }
    /*
        프로그램의 시작지점(Starting Point) main메소드이다.
        자바 프로그램은 main()메소드를 가지는 클래스가 반드시 하나는 존재해야하며
        public static void로 선언되어있으므로 반환형이 없고(void),
        인스턴스 생성 이전에 클래스 로딩시에 바인딩되어 정적으로(static)메소드 호출이 가능하며
        다른 패키지에서도 접근이 가능하다(public)(main메소드의 호출이 이뤄지는 영역은 클래스 외부이다.)
     */
    public static void main(String[] args) {
        System.out.println("Print PeriodicElementInformation");
        //for-each(enhanced for)문을 통해 elements(PeriodicElement[])의 모든 원소를 접근하며
        //반복을 진행하면서 배열의 각각의 원소가 참조하는 인스턴스를 pe또한 참조하게 된다.
        for(PeriodicElement pe: elements){
            //System클래스의 out참조변수(static으로 선언되어있음)가 참조하는 인스턴스의 println()메소드를 호출한다.
            //System.out.println()의 인자로 인스턴스를 참조하는 참조변수 전달 시 해당 인스턴스의 toString()을 호출한다.
            System.out.println(pe);
        }
        //줄넘김용으로 println()호출 System.out.print("\n");과 같은 기능
        System.out.println();

        //Element에 static으로 정의되어 있는 names()메소드를 통해 모든 Element열거형 상수의 name값을 String형 배열로 반환하고
        //이에 대해 for-each구문을 통해 모두 출력한다.
        System.out.println("Print element name");
        for(String s:Element.names()){
            System.out.println(s);
        }
        System.out.println();


        System.out.println("Print element name, PeriodicElementInformation, State");
        //for-each문에서 Element열거형의 names메소드가 반환하는 문자열 배열(String[])의 각 요소들에 접근
        for(String s: Element.names()){
            //Element에 static으로 정의되어있는 nameOf메소드에 문자열배열(Element.names())의 각 요소를 인자로 전달하고
            //반환되는 Element열거형을 element로 참조한다.
            Element element=Element.nameOf(s);
            //element가 참조하는 열거형 상수의 name메소드를 통해 name(열거형 상수의 이름)을 출력한다.
            //name()메소드와 name필드는 Enum추상클래스에 정의되어있음. (public final String name(){return name;}과 같이 정의되어있다.)
            System.out.println(element.name());
            //static으로 정의된 getPeriodicElement()에 elements(PeriodicElement배열)과 함께 element를 전달한다. 그리고 반환되는 인스턴스를
            //pElement라는 이름의 PeriodicElement형 참조변수가 참조한다.
            //이 때, 반환되는 인스턴스는 PeriodicElement인스턴스가 아닌! PeriodicElement를 구현하는 하위클래스의 인스턴스일텐데
            //상위클래스의 참조변수로 하위클래스의 인스턴스를 참조할 수 있고 이와 같이 PeriodicElement로 참조함을 통해서 구현 교체의 유연함을 얻을 수 있다.
            //예를들어 pElement가 참조하는 인스턴스가 GasPeriodicElement였다가 SolidPeriodicElement인스턴스로 바뀔 수 있다.
            PeriodicElement pElement=getPeriodicElement(elements,element);
            //pElement를 출력한다. 이 때 인스턴스에 대한 출력은 toString()메소드의 호출로 이어진다.
            //따라서 PeriodicElement를 구현한 각각의 구상클래스에서 오버라이딩한 toString()이 출력된다. (같은 형태이지만 구상클래스에 따라 다르게 동작->다형성)
            //(오버라이딩하지않으면 기본적으로는 Object에 정의된 toString()호출하지만 여기서는 PeriodicElement에서 오버라이딩한 toString()이 호출된다.)
            System.out.println(pElement);
            //PeriodicElement에 정의된 getState()메소드를 통해 State state필드를 반환
            //이 때, PeriodicElement에 정의된 메소드들은 상속관계에 있는 하위클래스에 모두 상속되기 때문에 pElement가 참조하는 실제 인스턴스(예를 들어 GasPeridoicElement인스턴스)에서 호출 가능하다.
            System.out.println(pElement.getState());
            System.out.println();
        }

        do{
            System.out.println("Please enter 'number symbol name weight state' of PeriodicElement");
            System.out.print(">>");
            //PeriodicElement클래스에 static(정적)으로 정의된 PeriodicElement메소드를 클래스이름을 통해 접근하여 호출하고 있다.
            //이 메소드의 인자로 사용자의 입력을 전달(문자열형태로)하고 PeriodicElement를 구현하는 인스턴스를 반환해준다.
            //(parsePeriodicElement내부에서 PeriodicElementFactory의 getInstance()호출)
            //이를 element라는 이름의 PeriodicElement형 참조변수로 참조한다.
            PeriodicElement element=PeriodicElement.parsePeriodicElement(UserInput.getString());
            //parsePeriodicElement를 통해 생성된 인스턴스가 null이 아닌경우에만 element를 출력한다.
            if(element!=null)
                System.out.println(element);
            System.out.println();
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());

        do{
            System.out.println("Please enter [number] or [name] of PeriodicElement");
            System.out.print(">>");
            /*
            getElement메소드에서 Element의 nameOf를 이용한다.(Element.nameOf(UserInput.getString().toUpperCase())
            Element에 정의된 static메소드 nameOf는 null을 반환할 가능성이 있고 이를 통한 getPeriodicElement에서의 getValue()호출은
            NullPointerException을 발생시킬 가능성이 있다.
            따라서 getElement를 사용하는 곳에서는 혹시나 모를 NullPointerException발생을 염두해두는 것이 좋은 프로그램이며
            이를 위해 try-catch구문을 통해 예외를 처리하도록 하였다. 또한 NullPointerException이 발생했다는 것은 잘못된 입력이
            존재할 수 있다는 것이므로 이를 사용자에게 알리는 문장을 catch문에서 구현하였다.
            getPeriodicElement에서도 null을 반환하는 경우가 존재하므로 이를 사용하는 PeriodicElement.getState()에서 NullPointerException예외 발생도 함께 처리할 수 있다.
            (물론 getElement()에서 반환된 null을 getPeriodicElement에서 사용하는 순간 NullPointerException이 발생하여 getState()메소드까지 실행흐름이 연결되지는 않을 것 같지만..)
             */
            //try영역의 실행 중간에 예외 상황이 만들어지고 이로 인해 가상머신이 NullPointerException인스턴스를 생성하면 이 인스턴스는 메소드를
            //호출하듯이 catch구문의 매개변수 e에 전달된다. catch구문으로 실행흐름이 이어지면 가상머신은 예외가 처리된것으로 간주하고 실행흐름을 이어 나간다.
            try {
                //UserInput클래스에 static(정적으로)으로 정의된 getElement()를 호출한다.
                //이를 통해 반환되는 Element열거형을 e로 참조한다.
                Element e = UserInput.getElement();
                //getPeriodicElement()의 인자로 elements(Periodicelement[])배열과 사용자로 부터 입력받아 생성된 Element열거형을 전달
                PeriodicElement element = getPeriodicElement(elements, e);
                //이를 통해 반환된 PeriodicElement를 구현한 인스턴스를 출력한다.(toString()호출로 연결됨->다형성)
                //element가 가리키는 인스턴스(getPeriodicElement를 통해 반환된 인스턴스)는 elements배열에 존재하는 인스턴스와 같다.
                //즉 예를들어 element가 (2,'He','Helium',4.0026,GAS)인 인스턴스를 참조한다면 이는 elements[1]을 통해 참조하는 인스턴스와 같다.
                System.out.println(element + " ");
                //element가 참조하는 PeriodicElement를 구현한(상속한) 인스턴스의 getState()메소드를 호출한다.
                //getPeriodicElmeent에서 null을 반환할 가능성이 있고 그러할 경우 NullPointerException이 발생하므로 try구문 안에서 호출
                State state = element.getState();
                //State에서는 toString()을 오버라이딩하지 않았으므로 Enum에 정의되어있는
                //public String toString() { return name;}을 출력한다.(name은 열거형상수의 이름, Enum에 private final String name;으로 정의되어 있음)
                System.out.println(state);
            }catch(NullPointerException e){
                System.out.println("잘못된 입력이 존재하거나 프로그램내에 정의되어 있지 않은 원소 출력(51~118)을 요구하셨습니다.");
            }
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
            System.out.println();
        }while(!UserInput.getExitKey());
        System.out.println();


        //---------------------Lab4에서 추가된 내용----------------------//


        System.out.println("Print element state");
        //for-each(enhanced for)문을 통해 elements(PeriodicElement[])의 모든 원소를 접근하며
        //반복을 진행하면서 배열의 각각의 원소가 참조하는 인스턴스를 element 또한 참조하게 된다.
        for(PeriodicElement element: elements){
            //PeriodicElement클래스에 정의되어 있는 getName()과 getState()를 호출하고 이를 출력한다.
            //PeridoicElement를 상속하는 클래스의 인스턴스에 대해서 PeriodicElement에 정의된 메소드의 호출이 가능하다.
            System.out.println(element.getName()+": "+element.getState());
        }
        System.out.println();


        //PeriodicTable에 정의한 toString()을 호출한다.
        //PeriodicTable이 참조하는 PeriodicElement 배열인스턴스의 원소(각 원소들은 모두 PeriodicElement를 구현한 인스턴스) 내용 모두 출력
        System.out.println("Print PeriodicTable through toString() Method");
        System.out.println(ptable.toString());
        System.out.println();

        //ptable이 참조하는 인스턴스는 PeriodicTable이고 이 클래스에 정의되어 있는 print()메소드를 호출하여
        //ptable이 참조하는 PeriodicTable형 인스턴스의 인스턴스변수 elements(PeriodicElement[]형 변수로 PeriodicElement을 구현한 인스턴스를 참조할 수 있는 참조변수의 배열로 볼 수 있다. 객체에 대한 래퍼런스를 원소로 가지는 배열)
        //의 원소가 참조하는 모든 인스턴스에 대해 print()호출(PeridoicTable의 print()에서 인스턴스변수 elmenets가 참조하는 모든 인스턴스에 대해서 print()를 호출하는 데 이는 PeriodicElement를 구현한 구상클래스마다 다르다.->다형성)
        System.out.println("Print PeriodicTable through print() Method");
        ptable.print();


        //UserInput클래스의 getIntegerBetween메소드와 PeriodicTable의 find(int)메소드를 활용하여 구현한 내용
        System.out.println("Enter element number of element in periodic table(with min value,max value).");
        do{
            System.out.print("UserInput(min,max): ");
            String buf=UserInput.getString();
            //String의 split메소드를 통하여 문자열을 분리하고 이를 배열의 형태로 반환한다.
            //이때 구분자는 인자로 전달된 문자열이다.
            String[] strArray=buf.split(" ");
            //strArray배열의 길이와 동일한 길이의 int배열을 생성한다.
            //배열이 생성되면 모두 0또는 null로 초기화 되어있다.
            int[] intArray=new int[strArray.length];
            for(int i=0;i<intArray.length;i++) {
                //catch영역으로 예외 인스턴스가 전달이 되면 가상머신은 예외가 처리된것으로 판단하고 실행 흐름을 이어나간다.
                //여기서는 catch구문에서 아무 작업도 하지 않는다. 정상흐름으로 이어가기 위해서 try-catch구문을 사용하였다.
                try {
                    //문자열을 Intger클래스의 static으로 정의된 parseInt메소드의 인자로 전달함으로써 int(Primitive Type)으로 변환한다.
                    //이 과정에서 가상머신이 NumberFormatException예외 인스턴스를 생성할 수 있다.
                    intArray[i] = Integer.parseInt(strArray[i]);
                } catch (NumberFormatException e) {
                }
            }
            //intArray이 참조하는 배열인스턴스의 인스턴스 변수 length를 통해 배열길이를 구한다.
            //만약 배열의 길이가 2가 아닐 경우(min과max 두 가지 값)
            //혹은 chekcElementInteger의 반환값이 거짓인경우 if문의 몸체{}부분 실행
            if(intArray.length!=2||!checkElementInteger(intArray)){
                //잘못된 입력임을 사용자에게 알림
                System.out.println("Invalid input");
                //continue를 통해 반복문의 나머지를 생략하고(반복문을 빠져나가지 않고) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }
            System.out.print("UserInput(element): ");
            //UserInput클래스의 static으로 정의된 getIntegerBetween메소드의 인자로 intArray배열의 원소 2개를 넘긴다.
            int elementNumber=UserInput.getIntegerBetween(intArray[0],intArray[1]);
            //element가 0보다 작거나 같으면 입력에 문제가 있는 것이다.(주기율표의 원소번호는 1보다 크거나 같다.)
            if(elementNumber<=0){
                System.out.println("Invalid input");
                continue;
            }
            //PeriodicTable클래스에 정의된 find메소드를 활용하여 해당하는 원소번호의 인슽턴스를 반환하고 이를 PeriodicElement형 참조변수로 참조하도록 하였다.
            PeriodicElement element=ptable.find(elementNumber);
            //만약 find가 null을 반환한다면 문제가 있는 것이고 이에 대해서 사용자에게 알린다. 널이 아니면 element가 참조하는 인스턴스에 대해서 print()메소드를 호출한다.
            if(element!=null){
                element.print();
            }else{
                System.out.println("Invalid input");
            }

            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());
        System.out.println();

        //do-while문 이용
        //PeriodicElement의 static으로 정의된 parsePeriodicEelment(String[] strarr)를 테스트해보기 위해 추가한 내용이다.
        do{
            //원소의 정보는 총 5가지 이므로 배열의 크기를 5로 고정한 상태로 배열을 생성하였다.
            String[] ElementInfo = new String[5];
            System.out.println("Please enter Element Information");
            System.out.print("Element number>>");
            ElementInfo[0] = UserInput.getString();
            System.out.print("Element name>>");
            ElementInfo[1] = UserInput.getString();
            System.out.print("Element symbol>>");
            ElementInfo[2] = UserInput.getString();
            System.out.print("Element weight>>");
            ElementInfo[3] = UserInput.getString();
            System.out.print("Element state>>");
            ElementInfo[4] = UserInput.getString();
            //PeriodicElement클래스에 static으로 정의되어 있는 parsePeriodicElement메소드의 인자로 ElementInfo가 참조하는 String배열인스턴스 전달
            //(ElementInfo.length를 통해 인스턴스 별수 length에 접근가능하다는 것은 배열도 인스턴스임을 보이는 것과 같다.)
            //parsePeriodicElement가 반환하는 인스턴스를 pe참조변수를 통해 참조(null반환 가능성 존재)
            //PeriodicElement형 참조변수로 참조함을 통해 구현 교체의 유연함을 얻는다. 즉 pe는 GasPeriodicElemen인스턴스도 SolidPeriodicElement인스턴도 참조할 수 있다.
            PeriodicElement pe = PeriodicElement.parsePeriodicElement(ElementInfo);
            //pe가 참조하는 인스턴스가 null이 아니면 if문 내부의 문장{} 실행
            if (pe != null) {
                //PeriodicElement에 정의한 print()를 통한 원소의 정보 출력
                System.out.println();
                pe.print();
            }
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());
        System.out.println();

        //while문 이용
        //getKey()메소드와 getNext(),getPrevious(),get()메소드를 활용하여 원소번호를 통한 원소정보 출력
        while(true){
            System.out.println("Please enter Element number");
            System.out.print(">>");
            //UserInput클래스에 static으로 정의된 getInteger()를 호출하여 반환되는 int형 값을 elementNumber변수에 저장
            int elementNumber= UserInput.getInteger();
            //프로그램 내부적으로 get을 통한 인덱스 접근을 하기 때문에 사용자의 입력(1~50)을 1감소 시킨 (0~49)로 변경해주어야한다.
            elementNumber-=1;
            //ptable(PeriodicTable형 인스턴스) static 변수를 통해 PeriodicTable클래스에 정의되어 있는 get()을 호출한다.
            //이 때 사용자로부터 입력받은 (원소번호-1)을 인자로 전달하고 반환되는 PeriodicElement를 구현한 인스턴스를 element참조변수로 참조한다.
            PeriodicElement element=ptable.get(elementNumber);
            //element가 참조하는 인스턴스가 null이 아닐경우 if문의 중괄호 부분 실행
            if(element!=null){
                System.out.println("Element information according to the entered element number");
                //element가 참조하는 인스턴스가 null이 아닌경우로(if조건식) 제대로된 PeriodicElement 인스턴스를 참조한다고 볼 수 있으므로
                //element가 참조하는 인스턴스에 에 Non-static으로 정의된 print()메소드를 참조변수이름을 통해 호출
                element.print();
                System.out.println();
                //UserInput클래스에 static으로 정의되어 있는 getKey()메소드를 통해 사용자로부터 입력을 받고 메소드가 반환하는 값을 c라는 이름의 char형 변수에 저장
                char c=UserInput.getKey();
                //사용자로부터입력 받은 값이 'q'와 같으면 while반복문을 break를 통해 빠져나간다.
                if(c=='q'){
                    break;
                }
                //사용자로부터 입력 받은 값이 'p'와 같으면
                else if(c=='p'){
                    //ptable(PeriodicTable)에 정의되어 있는 getPrevious의 인자로 이전에 입력받았던 elementNumber를 전달하여
                    //elementNumber이전(Previous)인덱스에 해당하는 인스턴스를 반환하도록 하고 이를 element가 참조한다.
                    //element가 참조하는 인스턴스와 ptable.getPrevious()를 통해 반환한 인스턴스는 동일 인스턴스이다.
                    //즉 element를 통해 인스턴스의 정보 변경 시 ptable에 해당 인스턴스의 정보도 변경된다. (주의해야함)
                    element=ptable.getPrevious(elementNumber);
                    //사용자로부터 입력 받은 값이 'n'과 같으면
                }else if(c=='n'){
                    //ptable(PeriodicTable)에 정의되어 있는 getNext의 인자로 이전에 입력받았던 elementNumber를 전달하여
                    //elementNumber이후(Next)인덱스에 해당하는 인스턴스를 반환하도록 하고 이를 element가 참조한다.
                    element=ptable.getNext(elementNumber);
                }else if(c=='c'){
                    //꼭 이와 같은 경우 이외에도 UserInput클래스의 getKey()를 독립적으로 사용하고 싶을 수 있고
                    //다른 경우에 (이전,이후가 아닌) 현재 인덱스에 해당하는 원소의 정보를 원할수도 있기에 c(current)에 해당하는 내용을 getKey()에 추가하였고,
                    //이 경우에는 이전,이후 인덱스의 원소(PeriodicElement)에 대한 내용을 원하지 않고 다시 한 번 더 출력하길 원할 경우 이용할 수 있다.
                    element=ptable.get(elementNumber);
                }else if(c==' '){

                    //사용자의 입력이 'q','p','n','c'가 아닌 경우에는 ' '와 같게되고 반복문을 빠져나가지 않으면서 반복문 실행도중에 즉시 다음 반복으로 넘어간다.
                    continue;
                }
                //모든 작업(이전,이후,현재에 해당하는 PeriodicElement인스턴스를 element가 참조)이 진행된 이후
                //정상적일 경우 null이 아닌 PeriodicElement를 구현한 인스턴스를 참조하게 될 것이고 이 경우에 해당하여 print()메소드를 실행한다.
                if(element!=null){
                    element.print();
                }
            }
            //처음 사용자가 입력한 elementNumber가 적절치 않은 경우 혹은 p,n,c등을 통한 이전,이후,현재에 해당하는 인덱스의 접근이 적절치 않은 경우에는
            //다음의 문장을 통해 사용자에게 적절치 않음을 알린다.
            //ex)사용자로부터 입력받은 elementNumber를 1감소시킨(사용자는 원소번호를 입력 프로그램 내에서의 접근은 인덱스)값이 0인 경우 'p'를 통해 이전 인덱스에 대한 접근은
            //-1이 되고 적절치 않다.
            if(element==null){
                System.out.println("원소번호는 1부터 시작하며, 프로그램 상에서는 50까지의 원소가 저장되어 있습니다.(1-50)");
                System.out.println();
            }
        }
        System.out.println();

        //PeriodicTable에 정의되어 있는 find(Element element)를 이용
        while(true){
            System.out.println("Please enter Element Name");
            System.out.print(">>");
            //UserInput클래스에 static으로 정의되어 있는 getElement()메소드를 클래스 이름을 통해 접근 및 호출한다.
            //getElement()메소드가 반환하는 Element열거형(열거형 상수 하나하나가 Element객체(인스턴스)이다.)을 element변수가 참조한다.
            //참고로 getElement내부에서 Element의 nameOf()메소드가 사용되는데 이 nameOf는 Element상수의 이름뿐만아니라 상수값(value)을 통해서도 해당하는 Element열거형인스턴스를 찾아서 반환해준다.
            //즉, 사용자가 name이 아닌 number입력을 이용해서 element를 할당받고 이를 통해 검색(find)이 가능하다.
            //이러한 로직이 바로 밑에 Element의 number를 통한 검색이 있어 부적절해 보일 수 있지만(동일해보일 수 있지만)
            //아래의 반복문은 Element number만을 입력받을 수 있다는 점에서 차이가 있다고 생각한다.
            //또 이 반복문을 단독으로 보면 이상할 것이 없기 때문에 이를 프로그램적으로 막아두지는 않도록하였다.(number입력시에 그 접근을 막지 않겠다.)
            Element element=UserInput.getElement();
            /*
            PeriodicTable에 정의되어 있는 find(Element element)메소드 내부에서 NullPointerExeption이 발생할 가능성이 있으므로
            find()를 사용하는 곳에서는 혹시나 모를 NullPointerException발생을 염두해 try-catch문으로 구현하는 것이 좋다.
             */
            //try-catch를 통해 NullPointerException예외를 잡아낸다.
            //try영역의 실행 중간에 예외 상황이 만들어지고 이로 인해 가상머신이 NullPointerException인스턴스를 생성하면 이 인스턴스는 메소드를
            //호출하듯이 catch구문의 매개변수 e에 전달된다. catch구문으로 실행흐름이 이어지면 가상머신은 예외가 처리된것으로 간주하고 실행흐름을 이어 나간다.
            try {
                //ptable(PeriodicTable형 인스턴스를 참조하는 참조변수)을 통해 PeriodicTable에 정의되어 있는 find메소드 호출
                //이 때, 인자로 element가 참조하는 Element열거형 상수를 전달한다.
                //반환되는 인스턴스를 pe라는 이름의 PeriodicElement형 참조변수로 참조한다.
                //여기서 반환되는 인스턴스는 GasPeridoicElement, SolidPeriodicElement등 일 수 있고 이러한 인스턴스는 상위 클래스인 PeriodicElement형 참조변수로 참조가 가능하다.
                PeriodicElement pe = ptable.find(element);
                //여기서 pe를 통해 호출하는 print()는 실제 pe가 참조하는 인스턴스가 오버라이딩한 내용에 따라 다르게 동작할 수 있다.->다형성
                pe.print();
            }catch(NullPointerException e){
                System.out.println("Invalid Input");
            }
            //UserInput.getExitKey()가 참이면 break를 통해 반복문을 빠져나간다.
            if(UserInput.getExitKey()){
                break;
            }
        }
        System.out.println();

        //do-while문 이용
        //PeriodicTable에 정의되어 있는 find(int number)를 이용
        do{
            System.out.println("Please enter Element Number");
            System.out.print(">>");
            //UserInput클래스에 static으로 정의된 getInteger()를 호출하여 반환되는 int형 값을 eNum변수에 저장
            int eNum=UserInput.getInteger();
            //ptable을 통해 find메소드를 호출하고 인자로 사용자로부터 입력받은 정수(int)를 전달한다. 반환되는 인스턴스를 PeridoicElement형 참조변수 pe를 통해 참조
            PeriodicElement pe=ptable.find(eNum);
            //만약 pe가 참조하는 인스턴스가 null이아니면 pe를 출력
            //(pe.toString()메소드 호출로 이어진다. 이 때 PeriodicElement를 구현한 클래스에서 오버라이딩한 toString()이 호출된다. 만약 오버라이딩하지 않았다면 PeriodicElement에 정의된 toString()이 호출된다.)
            //null이면 잘못된 입력임을 알림
            if(pe!=null)
                pe.print();
            else if(pe==null){
                System.out.println("Invalid Input");
            }
        }while(!UserInput.getExitKey());
        System.out.println();

        System.out.println("반복할 횟수를 입력하시오");
        System.out.print(">>");
        //for문을 통해 반복을 할 것이기 때문에 사용자로부터 반복할 횟수를 입력받는다.
        int count=UserInput.getInteger();
        //UserInput.getInteger는 잘못된 입력일 시 -1을 반환 혹은 사용자가 0보다 작은수를 입력할 수 있음
        //이를 if문을 통해 체크
        if(count<=0){
            System.out.println("잘못된 입력 혹은 0보다 작은 입력으로 인해 Symbol에 대한 반복을 진행하지 않습니다.");
            count=0;
        }

        //for문 이용( 총 count번 반복)
        //PeriodicTable에 정의되어 있는 find(String symbol)을 이용
        for(int i=0;i<count;i++){
            System.out.println("Please enter Element Symbol");
            System.out.print(">>");
            //사용자로부터 Symbol(기호)에 해당하는 내용을 입력받는다.
            String eSymbol=UserInput.getString();
            //ptable을 통해 find메소드를 호출하고 인자로 사용자로부터 입력받은 String을 전달한다. 반환되는 인스턴스를 PeriodicElement형 참조변수 pe를 통해 참조
            PeriodicElement pe=ptable.find(eSymbol);

            if(pe!=null){
                pe.print();
            }else if(pe==null){
                System.out.println("Invalid Input");
            }
        }
        System.out.println();

        //PeriodicTable에 정의되어 있는 find(State state)를 이용
        while(true){
            System.out.println("Please enter Element State");
            System.out.print(">>");
            //UserInput에 추가로 getState()메소드를 정의해주었다.
            //이를 통해 반환되는 State열거형을 eState로 참조
            State eState=UserInput.getState();
            //ptable을 통해 find메소드를 호출하고 인자로 전달된 eState와 일치하는 상태(State)를 가진 모든 인스턴스(ex. GasPeriodicElement인스턴스들)를 배열형태로 반환하고
            //이 배열인스턴스를 PeriodicElement[]형 참조변수 peArray를 통해 참조
            PeriodicElement[] peArray=ptable.find(eState);
            //만약 반환된 배열의 길이가 0이면 잘못된 상태를 입력했을 때 이므로 이를 사용자에게 알리고
            //continue를 통해 반복문을 빠져나가지 않으면서 반복문의 다음 내용들을 생략하고 다음 반복을 진행한다.
            if(peArray.length==0){
                System.out.println("잘못된 입력이 존재하거나 프로그램에 등록되지 않은 원소에 대한 상태입니다.");
                continue;
            }
            //PeriodicTable의 생성자에 PeriodicElement배열을 전달해주고 새로운 PeriodicTable인스턴스를 생성하며 이를
            //PeriodicTable형 참조변수 pt로 참조한다.
            PeriodicTable pt =new PeriodicTable(peArray);
            //PeriodicTable인스턴스를 참조하는 pt참조변수를 통해 PeriodicTable클래스에 정의되어 있는 print()호출
            //PeriodicTable의 print()메소드 내부에서는 PeriodicTable의 인스턴스변수(elements)가 참조하는 각각의 인스턴스에 대해 print()호출
            pt.print();
            //만약 UserInput.gtExitKey()의 반혼값이 true이면 반복문 종료
            if(UserInput.getExitKey()){
                break;
            }
        }
        System.out.println();

        //---------------------Lab5에서 추가된 내용----------------------//
        //PeriodicTable의 find메소드들과 get,getPrevious,getNext메소드들에 대한 테스트는
        //Lab4의 내용을 유지함을 통해 위에서 테스트하였으므로 여기서는 생략하도록 하겠다.

        //PeriodicElement[]형 참조변수 elements2로 PeriodicElement배열을 크기가 5로 만들었다.
        //여기서 주의할 점은 elements2는 객체 배열로 객체에 대한 래퍼런스를 원소로 갖는 배열이라는 것이다.
        //즉 다음의 문장을 통해 PeriodicElement인스턴스 생성이 아닌 PeriodicElement형 참조변수의 배열을 생성한 것으로 볼 수 있다.
        //따라서 PeriodicElement추상클래스를 구현한 인스턴스들의 배열로 볼 수 있다.
        //(elements2의 배열의 각 원소들이 참조하는 인스턴스는 GasPeridoicElement,SolidPeriodicElement등 모두 다를 수 있다. 하지만 이들 모두 PeriodicElement참조변수로 참조가능하다.)
        PeriodicElement[] elements2=new PeriodicElement[5];
        System.out.println("크기가 "+elements2.length+"인 배열 생성!");

        //배열의 크기만큼 반복하며 사용자로부터 입력을 받는다.
        for(int i=0;i<elements2.length;i++){
            System.out.println("생성한 배열의"+(i+1)+"번째 원소에 대한 정보 입력");
            //UserInput클래스에 정의된 getPeriodicElement()를 통해 원소정보를 입력받아서 PeriodicElement형으로 반환
            //이 때, 실제 반환되는 인스턴스는 PeriodicElement형이 아닌 이를 구현한 구상클래스의 인스턴스이다.
            //하지만 getPeriodicElement반환형이 PeriodicElement형인 이유는 이를 통해 GasPeriodicElement인스턴스, LiquidPeriodicElement등 PeridoicElement로 참조가능한 모든 객체가 반환가능하기 때문이다.
            elements2[i]=UserInput.getPeriodicElement();
        }

        //사용자 입력을 통해 생성된 배열을 대상으로 PeriodicTable인스턴스를 생성하고 ptable2라는 이름의 참조변수로 참조한다.
        PeriodicTable ptable2=new PeriodicTable(elements2);
        System.out.println("Print PeriodicTable");
        //PeriodicTable에 정의된 print()메소드를 호출하여 PreiodicTable의 인스턴스 변수 elements가 참조하는 모든 원소에 대해서 print()를 호출한다.
        ptable2.print();
        do {
            //사용자로부터 인덱스와 변경할 화학원소의 정보를 입력받는다.
            System.out.println("배열의 인덱스와 변경할 화학원소를 입력하세요");
            System.out.println("현재 배열의 총 길이는 "+elements2.length+"이고 인덱스번호는 0부터 "+(elements2.length-1)+"입니다.");
            System.out.print("Index>>");
            int index = UserInput.getInteger();
            //사용자가 입력한 인덱스번호가 올바르지 않은경우 이를 사용자에게 알리고 continue문을 통하여
            //반복문을 빠져나가지 않으면서 즉시 다음 반복을 진행한다.(반복문의 조건식을 검사하는 과정으로 분기한다.)
            if(index<0||index>=elements2.length){
                System.out.println("잘못된 인덱스 번호를 입력하셨습니다.");
                continue;
            }
            System.out.println("ElementInformation");
            //PeriodicElement형 참조변수로 참조하므로 PeriodicElement를 구현한 하위클래스에 대해서 모두 참조가능하다. 이를 통해 구현 교체의 유연함을 얻을 수 있다.
            PeriodicElement element = UserInput.getPeriodicElement();

            //입력받은 내용을 토대로 ptable2.set()메소드를 통해 해당되는 인덱스의 화학원소 정보를 변경한다.
            ptable2.set(index, element);


            System.out.println();
            System.out.println("Changed Element Information");
            //변경된 내용을 출력한다.
            //PeriodicTable의 print()를 통해 PeriodicTable의 인스턴스 변수 elements가 참조하는 배열인스턴스의 각 인스턴스들의 print()를 호출한다.
            ptable2.print();
        }while(!UserInput.getExitKey());

        System.out.println();

        //---------------------Lab6에서 추가된 내용----------------------//

        System.out.println("Used the \"PeriodicElementFinder\" abstract class's concrete class");
        //PeriodicElement[]형 변수를 선언하고 null로 초기화한다.
        PeriodicElement[] findElements=null;

        //PeriodicTable형 인스턴스를 참조하고있는 static으로 선언된 참조변수 ptable을 이용하여 PeriodicTable에 정의된 find(PeriodicElementFinder)를 호출하고 있다.
        //이 때 반환되는 인스턴스를 PeriodicElement[]형으로 참조한다.
        //PeriodicTable에 정의된 find의 매개변수형이 PeriodicElementFinder이기 때문에 이를 구현하는 구상클래스들의 인스턴스는 모두 인자로 전달될 수 있다.
        //(PeriodicElementFinder형 참조변수로 이를 상속을 통해 구현하는 구상클래스의 인스턴스를 참조가능하기 때문이다.)
        //하위클래스는 상위클래스의 속성을 상속받기 때문에 하위클래스의 객체는 상위클래스의 멤버를 모두 가진다.(private제외)
        //그러므로 하위클래스의 객체를 상위클래스의 객체로 취급할 수 있는 것이고, 상위형식의 참조변수로 하위형식의 인스턴스를 참조할 수 있다.
        //(하위클래스의 객체에 대한 래퍼런스를 상위클래스의 타입으로 변환하는 것을 '업캐스팅'이라고 한다.)
        //(이렇게 추상타입을 이용함으로 해서 구현 교체의 유연함을 얻을 수 있다.
        //모두 같은 find메소드를 호출하는데 인자로 전달되는 구상클래스(concrete class)는 SolidPeriodicElementFinder등으로 달라지고 있다.)
        findElements=ptable.find(new GasPeriodicElementFinder());

        //Gas상태를 가지는 GasPeriodicElement와 Solid상태를 가지는 SolidPeriodicElement가 너무 많은데
        //이 인스턴스들에 대한 래퍼런스를 가지는 PeriodicElement[]배열을 대상으로 Arrays클래스 static으로 정의된 toString()을 호출하면
        //배열인자에 대해서 배열의 모든 요소를 하나의 String으로 반환하여주는데 너무 길어 한눈에 알아보기 힘드므로
        //이전에 PeriodicTable에 정의하였던 print()메소드를 이용하여 여러줄의 문자열로 나누어 출력하도록 하였다.
        //(물론 이로인해 계속해서 PeriodicTable인스턴스를 생성하게 되므로 메모리나 성능적으로 그렇게 효율적인 것 같지는 않지만..)

        //앞서 생성한 PeriodicElement배열인스턴스에 대한 참조변수를 PeriodicTable의 생성자로 전달하면서 PeriodicTable인스턴스를 생성한다.
        //그리고 이를 findElementTable이라는 이름의 PeriodicTable형 참조변수로 참조한다.
        PeriodicTable findElementsTable=new PeriodicTable(findElements);
        //ptable이 참조하는 인스턴스는 PeriodicTable이고 이 클래스에 정의되어 있는 print()메소드를 호출하여
        //ptable이 참조하는 PeriodicTable형 인스턴스의 인스턴스변수 elements(PeriodicElement[]형 변수로 PeriodicElement을 구현한 인스턴스를 참조할 수 있는 참조변수의 배열로 볼 수 있다. 객체에 대한 래퍼런스를 원소로 가지는 배열)
        //의 원소가 참조하는 모든 인스턴스에 대해 print()호출(PeridoicTable의 print()에서 인스턴스변수 elmenets가 참조하는 모든 인스턴스에 대해서 print()를 호출하는 데 이는 PeriodicElement를 구현한 구상클래스마다 다르다.->다형성)
        //여기서의 print()는 GasPeriodicElement구상클래스의 인스턴스들에 대해서만 print()가 호출될 것이다.
        findElementsTable.print();
        findElements=ptable.find(new SolidPeriodicElementFinder());
        findElementsTable=new PeriodicTable(findElements);
        //여기서의 print()는 SolidPeriodicElement구상클래스 인스턴스들에 대해서만 print()가 호출될 것이다.
        findElementsTable.print();
        findElements=ptable.find(new LiquidPeriodicElementFinder());
        //LiquidperiodicElement인스턴스들의 배열과 UnknownPeriodicElment인스턴스들의 배열의 원소는 많지 않으므로
        //이에 대해서는 Arrays클래스의 toString() static메소드를 활용하여 출력하였다.
        //java.util패키지에 들어있는 Arrays클래스의 static으로 정의된 메소드 toString()을 호출한다.
        //Arrays클래스의 toString()메소드는 전달받은 배열인자에 대해서 배열의 모든 요소를 하나의 String으로 반환하여준다.
        //Arrays클래스의 toString()메소드는 모든 1차원 기본자료형을 대상으로 한 배열뿐만 아니라 Object와 String를 대상으로한 배열을 매개변수로 전달받을 수 있도록 오버로딩 되어있다.
        //PeriodicElement도 Object를 상속하므로 PeriodicElement[]배열 인스턴스도 전달 가능하다.
        System.out.println(Arrays.toString(findElements));

        //본인만의 코드를 추가하지 않아도 된다고 하였지만 수업시가에 배운 익명클래스(anonymous class)를 익히기위해서 이를 활용해보았다.
        //(물론 UnknownPeriodicElementFinder에서 동일한 내용을 구현하고 있고, 굳이 다음과 같이 하지 않아도 된다는 것은 알지만...)
        //클래스의 정의와 인스턴스 생성을 하나로 묶는다. 고때문에 오직 하나의 객체만을 생성할 수 있는 일회용 클래스이다.
        //그리고 이렇게 생성된 객체는 다른 Inner Class들과 달리 클래스의 이름이 없다.
        //(Inner Class에는 Member Inner Class,Local Inner Class들이 있다.
        //Non-static Nested Class는 아니지만 Static선언이 갖는 특성이 반영된 Static Nested Class도 존재한다.)
        //추가적으로 익명클래스 내부에 추상메소드에 대한 구현이외에도 추가적으로 필드나 메소드를 선언할 수 있으나 익명클래스 내부에서만 사용가능하다.
        findElements=ptable.find(new PeriodicElementFinder() {
            @Override
            public boolean isInstanceOf(PeriodicElement pe) {
                if(pe instanceof UnknownPeriodicElement)
                    return true;
                else
                    return false;
            }
        });
        System.out.println(Arrays.toString(findElements));
        System.out.println();

        System.out.println("Used the \"IPeriodicElementFinder\" interface's concrete class");
        //마침 IPeriodicElementFinder가 추상메소드가 딱 하나만 존재하는 함수형 인터페이스이기에
        //수업시간에 배운 람다식(Lambda expression)을 익히기 위해서 이를 활용해보았다.
        //람다식의 도입으로 인해 자바는 객체지향언어인 동시에 함수형 언어의 기능까지 갖추게 되었는데
        //람다식은 메소드를 하나의 식(expression)으로 간략하면서도 명확하게 표현하는 것이다.
        //람다를 이용하면 코드를 줄일 수 있고, 가독성에도 도움이 된다.
        //보통 람다는 인스턴스보다는 기능(메소드) 하나를 정의해서 전달해야 하는 상황에서 쓰인다.
        //위의 추상클래스를 이용한 내용에서는 람다식을 활용하지 않았는데, 이유는 람다의 타겟타입은 반드시 인터페이스이어야하기 때문이다.
        //즉, 추상클래스가 추상메소드를 하나만 가지고 있다고 하더라도 이는 함수형 인터페이스가 아니므로 이를 대상으로 람다식을 작성하는 것은 불가능하다.
        //(람다식은 함수형 인터페이스를 기반으로만 작성될 수 있다.)
        //람다식과 익명클래스의 차이점을 정리하고 가겠다.
        /*
        Anonymous Class vs Lambda expression
        1. 익명클래스와 람다에서의 this의 의미는 다르다.
        람다식은 this를 이용한 자기 자신에 대한 참조가 불가능하다.
        익명클래스의 this는 익명클래스 자신을 가리키지만 람다에서의 this는 선언된 클래스를 가리킨다.
        2. 람다는 은닉변수(Shadow Variable)을 허용하지 않는다.
        익명 클래스는 변수를 선언하여 사용할 수 있지만, 람다는 이를 허용하지 않는다.
        3. 람다는 인터페이스에 반드시 하나의 추상메소드만 가지고 있어야한다.
        익명클래스는 추상클래스를 대상으로도 가능하고, 또 추상메소드의 개수에 제한이 없다. 모두 구현해주기만 하면 된다.
        하지만 람다는 반드시 '함수형 인터페이스'를 기반으로만 작성될 수 있다.
        4. 람다는 같은 시그니처를 가지는 인터페이스에 대하여 의미가 모호해진다.(타입을 지정해주어야 한다.)
         */
        //'->'를 람다 연산자라고 한다.

        //람다식을 이용하여 IPeriodicElementFinder함수형 인터페이스가 가지는 추상메소드에 대해 구현하고
        //이를 기반으로 인스턴스의 생성을 하여 IPeriodicElementFinder형 참조변수로 참조한다.
        //(람다식은 결국 익명 구현객체를 생성한다.)
        IPeriodicElementFinder gasFinder=(PeriodicElement pe)->{
            if(pe instanceof GasPeriodicElement) return true;
            else return false;};
        //앞선문장에서 람다를 통해 생성된 인스턴스에 대한 래퍼런스를 가지는 참조변수를 전달한다.
        //즉, 메소드의 기능을 정의해서 전달하고 있는 것과 같다고 볼 수 있다.
        findElements=ptable.find(gasFinder);
        //ptable.find()를 통해 반환된 PeriodicElement[]을 PeriodicTable의 생성자로 전달하면서 PeriodicTable인스턴스를 생성한다.
        findElementsTable=new PeriodicTable(findElements);
        //추상클래스를 이용한 것과 마찬가지로 ptable.find의 인자로 ISolidPeriodicElementFinder()를 통해 반환되는 SolidPeriodicElement와 GasPeriodicElement 배열에 대해서는
        //원소의 개수가 너무 많아 Arrays.toString()을 통해 반환되는 한 줄의 String으로는 가독성이 떨어지므로
        //이전에 정의하고 사용하였던 PeriodicTable의 print()메소드를 활용하였다.
        findElementsTable.print();
        //PeriodicTable형 인스턴스를 참조하고있는 static으로 선언된 참조변수 ptable을 이용하여 PeriodicTable에 정의된 find(IPeriodicElementFinder)를 호출하고 있다.
        //이 때 반환되는 인스턴스를 PeriodicElement[]형으로 참조한다.
        //PeriodicTable에 정의된 find의 매개변수형이 IPeriodicElementFinder이기 때문에 이를 구현하는 구상클래스들의 인스턴스는 모두 인자로 전달될 수 있다.
        //(IPeriodicElementFinder형 참조변수로 이를 구현하는 구상클래스의 인스턴스를 참조가능하기 때문이다.)
        //(이렇게 추상타입을 이용함으로 해서 구현 교체의 유연함을 얻을 수 있다.
        //모두 같은 find메소드를 호출하는데 인자로 전달되는 구상클래스(concrete class)는 달라지고 있다.)


        //PeriodicTable은 find()의 매개변수가 PeriodicElementFinder뿐만아니라 IPeriodicElementFinder에 대해서도 오버로딩 되어 있다.
        //다음의 코드들은 IPeriodicElementFinder인터페이스를 구현한 구상클래스(concrete class)들을 생성하며 ptable.find()의 인자로 전달해주고 있다.
        //매개변수 형이 IPeriodicElementFinder이므로 이를 구현한 클래스들의 인스턴스를 인자로 전달 가능하다.
        findElements=ptable.find(new ISolidPeriodicElementFinder());
        //이렇게 PeriodicTable의 find메소드를 통해 반환된 PeriodicElement[]배열 인스턴스를 PeriodicTable의 생성자로 전달하여
        //앞서 추상클래스를 이용한 것과 마찬가지로 PeriodicTable인스턴스를 생성한다.
        findElementsTable=new PeriodicTable(findElements);
        findElementsTable.print();
        findElements=ptable.find(new LiquidPeriodicElementFinder());
        //LiquidperiodicElement인스턴스들의 배열과 UnknownPeriodicElment인스턴스들의 배열의 원소는 많지 않으므로
        //이에 대해서는 Arrays클래스의 toString() static메소드를 활용하여 출력하였다.
        System.out.println(Arrays.toString(findElements));
        findElements=ptable.find(new UnknownPeriodicElementFinder());
        System.out.println(Arrays.toString(findElements));
        System.out.println();

        //---------------------Lab7에서 추가된 내용----------------------//
        //-------------------PeriodicTable에 추가된 모든 메소드 테스트하기-----------------//
        //인스턴스 변수 elements를 PeriodicTable의 생성자의 인자로 전달하여 main메소드 내의 지역변수 ptable을 선언과 동시에 초기화한다.
        //즉 ptable이라는 이름의 참조변수로 PeriodicTable객체를 참조하게된다.
        PeriodicTable ptable=new PeriodicTable(elements);
        System.out.println("PeriodicElement[]배열에 저장된 내용의 순서를 랜덤하게 섞습니다.");
        try {
            //ptable의 메소드 shuffle()을 통해서 ptable이 참조하는 PeriodicTable내부의 인스턴스변수 elements가 참조하는 배열의 내용을 랜덤하게 섞는다.
            //이 때 shuffle메소드에서 UnssupportedOperationException예외가 발생할 수 있고, 이를 throws를 통해 넘기므로
            //이를 사용하는 다음의 문장을 try-catch구문을 통해 예외 처리를 하여주도록한다.
            ptable.shuffle();
        }catch(UnsupportedOperationException e){
            //만약 shuffler()호출에서 UnsupportedOperationException예외가 발생하게 되면 UnsupportedOperationException클래스의 인스턴스가 생성되고 이는 catch구문의 매개변수 e로 전달된다.
            //catch문에서는 다음을 통해 사용자에게 예외가 발생하여 정상적인 동작을 하는데 실패하였음을 알린다.
            //이렇게 catch문으로 프로그램의 실행흐름이 넘어오게되면(catch구문 안에서 무엇을 하든 상관없이) 가상머신은 예외가 처리된 것으로 판단하고 프로그램의 실행흐름을 이어나간다.
            System.out.println("배열에 저장된 내용을 랜덤하게 섞는데 실패하였습니다.");
        }
        //배열에 저장된 내용이 제대로 섞였는지 확인하기 위해 ptable.print()를 호출하여 확인한다.
        //ptable이 참조하는 인스턴스는 PeriodicTable이고 이 클래스에 정의되어 있는 print()메소드를 호출하여
        //ptable이 참조하는 PeriodicTable형 인스턴스의 인스턴스변수 elements(PeriodicElement[]형 변수로 PeriodicElement을 구현한 인스턴스를 참조할 수 있는 참조변수의 배열로 볼 수 있다. 객체에 대한 래퍼런스를 원소로 가지는 배열)
        //의 원소가 참조하는 모든 인스턴스에 대해 print()메소드를 호출한다.
        //(PeridoicTable의 print()에서 인스턴스변수 elmenets가 참조하는 모든 인스턴스에 대해서 print()를 호출하는 데 이는 PeriodicElement를 구현한 구상클래스마다 다르다.->다형성)
        ptable.print();
        System.out.println();

        System.out.println("섞었던 배열의 내용을 다시 정렬합니다.");
        try {
            //ptable의 메소드 sort()를 통해서 ptable이 참조하는 PeriodicTable내부의 인스턴스 변수 elements가 참조하는 배열의 내용을 정렬한다.
            //이 때 sort()메소드는 ClassCastException을 발생할 가능성이 있기 때문에 이를 사용하는 main메소드의 다음 부분에서 이에 대한 try-catch구문을을 통해 예외처리를 하여 주었다.
            //(PeriodicTable의 sort()메소드 내부에서 ClassCastException이 발생할 가능성이 있는데 이 예외를 PeriodicTable의 sort()메소드를 사용하는 영역으로 throws를 통해 넘겨주기 때문에 이를 처리)
            ptable.sort();
        }catch(ClassCastException e){
            //만약 sort()호출에서 ClassCastException예외가 발생하게 되면 ClassCastException클래스의 인스턴스가 생성되고 이는 catch구문의 매개변수 e로 전달된다.
            //catch문에서는 다음을 통해 사용자에게 예외가 발생하여 정상적인 동작을 하는데 실패하였음을 알린다.
            //이렇게 catch문으로 프로그램의 실행흐름이 넘어오게되면(catch구문 안에서 무엇을 하든 상관없이) 가상머신은 예외가 처리된 것으로 판단하고 프로그램의 실행흐름을 이어나간다.
            System.out.println("배열에 저장된 내용을 정렬하는데 실패하였습니다.");
        }
        //이전과 동일하게 ptable의 print()메소드를 호출하여 정렬된 내용을 확인한다.
        //print()메소드는 ptable이 참조하는 PeriodicTable의 인스턴스변수 elements가 참조하는 배열인스턴스의 모든 내용을 출력한다.
        ptable.print();
        System.out.println();

        System.out.println("ptable에 저장된 내용 중 하나를 랜덤으로 고릅니다.");
        try {
            //ptable을 통해서 PeriodicTable클래스에 정의된 getRandomElement()메소드를 호출하여 ptable에 저장된 내용 중 하나를 랜덤하게 뽑아낸다.
            //이렇게 랜덤하게 고른 하나의 인스턴스(PeriodicElement를 구현한 구상클래스일 것이다.)에 대해서 print()를 호출한다.(다형성)

            //getRandomElement()메소드는 ArrayIndexOutOfBoundsException을 일으킬 가능성이 있다.
            //물론 실제 PeriodicTable의 getRandomElement()메소드 내용을 보면 예외가 발생할 가능성은 없다고 보여진다.
            //하지만 예기치못한 상황이 발생할 수도 있으므로 이에대해서 try-catch문을 통해 예외를 처리하도록 하였다.
            //(try구문 안에 위치한 코드는 try구문 밖에 위치한 코드에 비해 실행속도가 느리기 때문에 과도한 예외처리는 심각한 성능의 저하로 이어질 수 있다는 것을 안다.
            //하지만 현재 이 프로그램은 성능의 저하가 일어날만큼 규모가 큰 프로그램이 아니라고 생각되고 실행속도보다 안정성(예기치못하게 프로그램이 종료되지 않는..)이 더 중요하다고 판단되어
            //조금 빈번하다고 try-catch문을 사용한다고 생각됨에도 불구하고 이렇게 코딩하였다.)
            ptable.getRandomElement().print();
        }catch(ArrayIndexOutOfBoundsException e){
            //만약 getRandomElement()호출에서 ArrayIndexOutOfBoundsException가 발생하게 되면 ArrayIndexOutOfBoundsException클래스의 인스턴스가 생성되고
            //이는 catch구문의 매개변수 e로 전달된다. catch문에서는 다음을 통해 사용자에게 예외가 발생하여 정상적인 동작을 하는데 실패하였음을 알리고 프로그램의 실행흐름을 이어나간다.
            System.out.println("ptable에 저장된 내용 중 하나를 랜덤하게 뽑아내는데 있어서 문제가 존재합니다.");
        }
        System.out.println();


        //이후에 1부터50까지 원소번호의 원소들을 PeriodicTable을 통해 접근하여 사용할 것이기 때문에
        //ptable을 다음과 같이 PeridoicTable의 생성자로 인스턴스변수 elements가 참조하는 배열인스턴를 전달하여 생성한 PeriodicTable인스턴스를 참조하게끔한다.
        ptable=new PeriodicTable(elements);

        //-----------------PeriodicTableList의 모든 메소드 테스트하기------------------//
        //PeriodicElement[]형 참조변수 periodicElements를 선언하면서 null로 초기화한다.
        PeriodicElement[] periodicElements=null;
        //PeriodicTableList형 참조변수를 plist라는 이름으로 선언하면서 동시에 PeriodicTableList인스턴스를 생성하여 이를 참조하도록 초기화하고 있다.
        PeriodicTableList plist=new PeriodicTableList();
        System.out.println("인덱스 번호를 입력하시오.(원소번호x)");
        while(true) {
            //UserInput클래스의 getInteger클래스를 이용하여 각각 int형 변수 min과 max에 사용자가 입력한 정수를 저장한다.
            //만약 정상적이지 않은 입력인 경우 getInteger()메소드 내부에서 이를 -1로 반환하도록 되어있다.
            System.out.print("min>>");
            int min = UserInput.getInteger();
            System.out.print("max>>");
            int max = UserInput.getInteger();
            //이전에 선언하였던 perioicElements참조변수가 ptable.getElements()가 반환하는 PeriodicElement[]배열인스턴스를 참조하도록한다.
            //이 때 이전에 입력받았던 min,max값을 getElements의 인자로 전달하여준다.
            //getElements메소드는 인자로 전달받은 두 값을 통해서 PeriodicTable의 클래스의 인스턴스변수 elements가 참조하는 배열인스턴스의 min인덱스부터 max인덱스까지의 요소를 담은 배열을 반환한다.
            //getElements메소드는 내부에서 if문을 통한 검사와 try-catch구문을 통해 ArrayIndexOutOfRangeException을 내부에서 처리하므로 여기서 따로 처리해줄 예외는 없다.
            periodicElements = ptable.getElements(min, max);
            //만약 getElements를 통해 반환된 값이 null이라면 다음의 if문을 실행한다.
            if (periodicElements == null) {
                //if문 조건식이 만족되어 다음의 if문이 실행되었다는 것은 사용자가 정상적인 입력을 하지 않았다는 것이므로 이에대해 알리고
                System.out.println("다시 입력해주세요.");
                //continue를 통해 사용자가 다시 입력할 수 있도록 반복문의 나머지를 생략하고(반복문을 빠져나가지 않으면서) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }else {
                //만약 사용자가 정상적인 입력을 통해서 periodicElements가 null아닌 정상적인 PeriodicElement[]배열 인스턴스를 참조하게 된다면 다음의 문장을 실행하게된다.
                //for-each문을 통해서 periodicElements가 참조하는 배열인스턴스의 모든 내용을 순차적으로 접근한다.
                //(PeriodicElement형 변수 pe가 배열의 각각의 요소가 참조하는 인스턴스를 참조한다.)
                for (PeriodicElement pe : periodicElements) {
                    //이전에 선언및 생성하였던 PeriodicTableList객체를 참조하는 plist의 add메소드를 통하여 pe가 참조하는 인스턴스를 PeriodicTableList의 인스턴스변수 elements가 참조하는 인스턴스에 저장하게된다.
                    plist.add(pe);
                }
                //break을 통해 while반복문을 빠져나간다.
                break;
            }
        }
        //위의 반복문을 통해 plist에 추가된 내용을 확인하기 위해 plist가 참조하는 PeriodicTableList의 print()메소드를 통해 출력한다.
        plist.print();
        System.out.println();

        //다음 동작을 수행하기에 앞서 periodicElements를 null로 할당하여준다.
        periodicElements=null;
        //while반복문의 조건식이 true이므로 항상 조건이 참이되는 무한루프이다.
        //이 경우 whiel반복문 내부에서 if문을 이용하여 특정 조건이 만족되면 break을 통해 반복문을 빠져나가도록 한다.
        while(true) {
            System.out.print("random size>>");
            //UserInput의 static메소드인 getInteger()을 호출하여 사용자로부터 정수를 입력받고 이를 int형 변수 size에 저장한다.
            int size=UserInput.getInteger();
            //만약 사용자가 잘못된 입력을 하여 getInteger()가 -1을 반환하거나 사용자가 0보다 작은 값을 입력한 경우
            //변수 size에는 0보다 작은 값이 저장되게 되고 if문은 참이된다.
            if(size<0){
                //사용자에게 잘못된 입력이 있음을 알리고 다시 입력해달라고 알린다.
                System.out.println("잘못된 size입력입니다. size는 0보다 크거나 같아야합니다. 아무런 내용도 추가하고 싶지 않으면 0을 입력하여주세요.");
                //continue문을 통해 사용자가 다시 입력할 수 있도록 반복문의 나머지를 생략하고(반복문을 빠져나가지 않으면서) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }else {
                //if문이 참이되지 않았다면 정상적인 입력(0보다 크거나 같은 입력)이 있는 것이고 else문을 실행하게 된다.
                //ptable은 1부터 50까지의 원소를 저장하고 있는 PeridicTable인스턴스이다. 따라서 ptable의 getRandomElements()메소드를 이용하여
                //1부터 50까지의 화학원소중 랜덤하게 size개를 골라 PeriodicElement[]형태로 반환하여주고 이를 periodicElements가 참조하도록 한다.
                try {
                    //getRandomElements는 NegativeArraySizeException을 일으킬 가능성이 있고, 이를 throws를 통해 호출한영역으로 예외를 넘긴다.
                    //따라서 이를 사용하는 다음의 영역에서 try-catch 구문을 통해서 처리하도록 하였다.
                    //(예를 들어 size가 0보다 작으면 NegativeArraySizeException이 발생한다.)
                    //물론 앞의 if문을 통해서 size가 0보다 작은지 검사하여주지만..
                    periodicElements = ptable.getRandomElements(size);
                }catch(NegativeArraySizeException e){
                    //만약 예기치 못한 상황이 발생하여 NegativeArraySizeException이 발생한 경우 catch문으로 실행흐름이 이어지게되고
                    //다음을 출력한다. 이후 가상머신은 예외가 처리도니 것으로 간주하고 프로그램의 실행흐름을 이어나간다.
                    System.out.println("NegativeArraySizeException");
                    //만약 실행흐름이 catch문으로 들어오게되면 사용자로부터 다시 입력을 받아야할 것이기 때문에
                    //반복문의 나머지를 생략하고 조건식을 검사하는 과정으로 분기하도록 continue문을 이용한다.
                    continue;
                }
                //for-each문을 통해서 periodicElements가 참조하는 배열인스턴스의 모든 내용을 순차적으로 접근한다.
                //(PeriodicElement형 변수 pe가 배열의 각각의 요소가 참조하는 인스턴스를 참조한다.)
                for (PeriodicElement pe : periodicElements) {
                    //이전에 getElements()를 통해 요소를 추가하였던 PeriodicTableList객체에 대해서
                    //PeriodicElements의 배열내용을 plist의 add메소드를 이용하여 추가적으로 저장하게된다.
                    plist.add(pe);
                }
                //이렇게 추가된 내용을 print()메소드를 호출하여 확인하고 break문을 통해 반복문을 빠져나간다.
                plist.print();
                break;
            }
        }
        System.out.println();

        System.out.println("plist에 저장된 내용 중 하나를 랜덤으로 고릅니다. ");
        //plist가 참조하는 PeriodicTableList의 getRandomElement()메소드를 호출하여 plist에 저장된 내용 중 하나를 랜덤하게 고르고 이를 반환한다.
        //이렇게 getRandomElement()가 반환하는 값을 PeriodicElement형 참조변수 peIndexTest가 참조한다.
        //이 때 getRandomElement()가 반환하는 인스턴스는 실제로 PeriodicElement가 아닌 PeriodicElement를 구현한 구상클래스의 인스턴스일 것이다.
        //PeriodicElement형 참조변수 peIndexTest는 모든 PeriodicElement의 구상클래스의 인스턴스를 참조할 수 있다.
        PeriodicElement peIndexTest=plist.getRandomElement();
        //peIndexTest가 참조하는 인스턴스의 print()를 호출한다.(다형성)(실제 참조하는 구상클래스에 따라 오버라이딩된 print()가 호출되고 각 구상클래스에 따라 동작이 다르다.)
        peIndexTest.print();
        System.out.println();
        //plist의 indexOf메소드를 호출하면서 인자로 이전에 랜덤하게 고른 인스턴스를 전달한다.
        //이를 통해 우리가 랜덤하게 뽑은 인스턴스가 plist가 저장하고 있는 내용의 몇번째 인덱스인지를 확인한다.(PeriodicTableList의 elements가 참조하는 ArrayList<E>가 저장하고 있는 인스턴스들 중 몇번째 인덱스인지)
        System.out.println("random하게 고른 원소의 인덱스 번호는 "+plist.indexOf(peIndexTest)+"입니다.\n");
        System.out.println("sorting...");
        //plist의 메소드 sort()를 이용하여 plist가 참조하는 PeriodicTableList내부의 인스턴스 변수 elements가 참조하는 ArrayList<PeriodicElement>의 내용을 정렬한다.
        //이 때 내부적으로 Collections.sort()메소드를 이용하는데 ClassCastException, UnsupportedOperationException, IllegalArgumentException 예외들이 발생할 가능성이 있다.
        //(PeriodicTableList의 sort()에서는 이 예외들을 throws를 통해 넘겨주므로 sort()를 이용하는 영역에서 이를 처리한다.)
        try {
            plist.sort();
            //3가지 예외 발생에 대해서 상황 별 예외 처리 방식이 다르지 않을 경우, 아래와 같이 하나의 catch구문 안에서 모든 예외가 처리될 수 있도록 묶을 수 있다.('|' 이용)
        }catch(ClassCastException|UnsupportedOperationException|IllegalArgumentException e){
            System.out.println("plist에 저장된 내용을 정렬하는데 실패하였습니다.");
        }

        //정렬을 한 이후에 다시 한 번 더 plistIndexOf를 호출하여 우리가 랜덤하게 골랐던 peIndexTest가 참조하는 인스턴스가 plist가 저장하고 있는 내용의 몇번째 인덱스인지를 확인한다.
        System.out.println("정렬 이후에 random하게 골랐던 원소의 인덱스번호는 "+plist.indexOf(peIndexTest)+"입니다.");
        System.out.println();
        System.out.println("정렬된 plist의 모든 원소 출력");
        //plist가 참조하는 PeriodicTableList의 print()메소드를 통해서 정렬된 내용을 모두 출력한다.
        plist.print();
        System.out.println();


        //다음에 대해서 PeriodicTableList의 deduplicate()메소드에서 설명하였지만
        //plist가 참조하는 PeriodicTableList는 내부적으로 ArrayList<PeriodicElement>인스턴스를 참조하는 인스턴스변수를 이용하여
        //내용을 저장하는데 ArrayList<E>는 데이터의 중복저장을 허용한다.
        System.out.println("plist의 화학원소 중 중복된 원소를 제거하고 싶다면 'Y'를 입력하시오.");
        System.out.println("그렇지 않다면 'Y'를 제외한 아무키나 입력하시오.");
        System.out.print(">>");
        //UserInput의 static메소드 getString()을 통해 문자열을 입력받고 toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
        //이를 String형 input참조변수로 참조한다.(선언과 초기화 동시에)
        String input=UserInput.getString().toUpperCase();
        //input과 "Y"를 equals를 통해 내용비교를 진행한다.
        //만약 if의 조건식이 참이면 if문 내의 문장들을 실행하고 조건식이 false이면 else문을 실행한다.
        if(input.equals("Y")){
            //중복을 제거하기 이전 상태의 전체 크기를 plist.size()메소드를 호출하여 출력한다.(size()는 리스트의 크기를 반환하여주는 메소드이다.)
            //(plist가 참조하는 PeriodicTableList는 내부적으로 ArrayList<E>를 이용하여 내용을 저장하는데 size()는 이 ArrayList<E>의 크기를 반환하여주는것이다.)
            System.out.println("중복을 제거하기 이전 상태에서의 전체 크기는 "+plist.size()+"입니다.");
            //내가정의한 메소드 deduplicate()를 호출하여 중복을 제거하여준다.
            plist.deduplicate();
            //이후 plist가 참조하는 PeriodicTableList의 print()메소드를 통해 중복이 제거된 내용을 모두 출력한다.
            plist.print();
            //중복을 제거한 이후 상태의 전체 크기를 plist.size()메소드를 호출하여 출력한다.
            System.out.println("중복된 원소를 제거한 이후의 전체 크기는 "+plist.size()+"입니다.");
        }else{
            //만약 사용자가 중복제거를 원치않았다면 else문을 실행하게 될텐데 이 경우 단순히 size()메소드를 통하여 전체크기만을 출력하여준다.
            System.out.println("\n리스트의 전체 크기는 "+plist.size()+"입니다.");
        }
        System.out.println();


        System.out.println("plist에서 원소를 삭제하고 싶다면 'Y'를 입력하시오.");
        System.out.println("그렇지 않다면 'Y'를 제외한 아무키나 입력하시오.");
        System.out.print(">>");
        //UserInput의 static메소드 getString()을 통해 문자열을 입력받고 toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
        //이를 String형 input참조변수로 참조한다.
        input=UserInput.getString().toUpperCase();
        //input과 "Y"를 equals를 통해 내용비교를 진행한다.
        //만약 if의 조건식이 참이면 if문 내의 문장들을 실행한다.
        if(input.equals("Y")) {
            do {
                System.out.println("삭제되기 이전에 리스트의 전체 크기는 "+plist.size()+"입니다.");
                System.out.println("삭제하고 싶은 PeriodicElement를 입력하시오.");
                System.out.print(">>");
                //UserInput클래스의 getPeriodicElement()메소드를 이용하여 사용자 입력에 따른 PeriodicElement를 생성하고 이를 periodicElement참조변수로 참조한다.
                //(getPeriodicElement메소드 내부에서는 PeriodicElementFactory의 getInstance()를 이용하여 객체를 생성한다.)
                PeriodicElement periodicElement = UserInput.getPeriodicElement();
                //plist의 remove메소드의 인자로 사용자로부터 입력받아 생성한 PeriodicElement(실제로는 이를 구현한 구상클래스)를 참조하는 참조변수를 전달한다.
                //이 때 remove메소드 내부에서 ArrayList의 remove()를 사용하는데 이 때 equals()메소드를 통해서 같은 요소인지를 판단한다.
                //따라서 PeriodicElement에서 Object의 equals()메소드를 적절히 오버라이딩하여 주었다.

                //plist의 remove()메소드 내부에서는 AbstractCollections에 정의된 remove(Object o)를 오버라이딩한 ArrayList<E>의 remove(Object o)를 호출하는데
                //이 메소드의 반환형은 boolean형이다. 따라서 PeriodicTableList의 반환형도 boolean형으로 변경하여 주었다.
                //이를 통해 remove()를 수행하고 반환되는 값이 true이면 if문을 실행하고 false이면 else문을 실행한다.
                if(plist.remove(periodicElement)) {
                    //if문이 참이되었을 경우 실행되는 문장들이다.
                    //삭제한 이후의 plist의 전체 크기를 size()메소드를 이용하여 출력하여준다.
                    System.out.println("삭제한 이후, 리스트의 전체 크기는 " + plist.size() + "입니다.");
                    //정상적으로 삭제가 이루어졌으므로 삭제된 plist의 내용에 대해서 print()를 통해 출력하여 확인할 수 있게 한다.
                    System.out.println("삭제한 이후, 리스트의 내용 출력");
                    plist.print();
                }else{
                    //정상적으로 삭제가 이루어지지 않은 경우 else문을 실행하게 된다. 사용자에게 삭제에 실패하였음을 알린다.
                    System.out.println("리스트에서 입력하신 PeriodicElement 삭제에 실패하였습니다.\n");
                }
            } while (!UserInput.getExitKey());
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }

        //다음 두 변수는 find를 통해 찾은 원소 혹은 원소들의 리스트를 참조하기 위한 변수들이다.
        //원소를 찾기 이전에 PeriodicElement형 참조변수 periodicElement를 선언하면서 null로 초기화하고
        PeriodicElement periodicElement=null;
        //List<PeriodicElemenet>형 참조변수 periodicElementList를 null로 초기화해준다.
        List<PeriodicElement> periodicElementList=null;
        do {
            //반복을 진행하면서 두 참조변수가 참조하고 있던 인스턴스를 대신하여 null을 할당한다.
            //만약 그렇지 않으면 이전에 찾았던 인스턴스를 계속 참조하고 있어 정상적이지 않은 동작이 이루어진다.
            periodicElement=null;
            periodicElementList=null;
            System.out.println("찾고자 하는 원소를 기호(symbol)로 찾을지 Element정보를 통해서 찾을지 IPeriodicElementFinder를 이용하여 찾을지 선택하여 주세요.");
            System.out.println("Mode 1.find by symbol");
            System.out.println("Mode 2.find by element information");
            System.out.println("Mode 3.find by using IPeriodicElementFinder");
            System.out.print("Enter the mode number>>");
            //사용자로부터 어떤 모드로 원소를 찾을지 UserInput클래스의 getInteger()를 통해서 입력받는다.
            int modeNumber = UserInput.getInteger();
            //modeNumber에 저장된 값이 1이면
            if (modeNumber == 1) {
                System.out.println("Enter symbol");
                System.out.print(">>");
                //사용자로부터 UserInput.getString()을 통해 문자열(String)형태의 symbol을 입력받는다.
                String symbol=UserInput.getString();
                //PeriodicTableList에 정의된 find(String symbol)메소드를 통하여 해당되는 원소를 찾는다.
                //만약 plist가 저장하고 있는 내용에 해당하는 symbol이 없는경우 null을 반환하고 해당되는 원소가 있으면
                //PeriodicElement형 원소(실제로 이를 구현한 구상클래스의 인스턴스)를 반환한다.
                periodicElement=plist.find(symbol);
            //modeNumber에 저장된 값이 2이면
            } else if (modeNumber == 2) {
                System.out.println("Enter element information(name or number)");
                System.out.print(">>");
                //사용자로부터 UserInput.getElement를 통해서 Element에 대한 정보(이름 혹은 원소번호)를 입력받고 이에 따른 Element를 반환한다.
                Element element=UserInput.getElement();
                //PeriodicTableList에 정의된 find(Element)메소드를 통하여 해당되는 원소를 찾는다.
                //만약 plist가 저장하고 있는 내용에 해당하는 Element가 없는경우 null을 반환하고 해당되는 원소가 있으면
                //PeriodicElement형 원소(실제로 이를 구현한 구상클래스의 인스턴스)를 반환한다.
                //plist.find()의 인자로 element를 전달하는데 find내부에서 NullPointerException이 발생할 수 있고 throws를 통해 이를 호출한 영역으로 넘긴다.
                //따라서 이에 대한 예외처리를 하여주었다.
                try {
                    periodicElement = plist.find(element);
                }catch(NullPointerException e){
                    //NullPointerException발생시 이를 사용자에게 알리고 continue를 통해 다음 반복을 진행하게 된다.
                    System.out.println("Invalid Input");
                    continue;
                }
            //modeNumber에 저장된 값이 3이면
            } else if (modeNumber == 3) {
                System.out.println("Enter the state of the finder");
                System.out.print(">>");
                //사용자로부터 getState()를 통해 상태를 입력받는다.
                State state=UserInput.getState();
                //만약 state가 참조하는 State값이 null이 아니면, 즉 사용자가 정상적인 입력을 하여 getState()가 반환하는 값이 null이 아니면
                if(state!=null) {
                    //IPeriodicElementFinderFactory클래스의 getInstance메소드의 인자로 전달한다.
                    //이를 통해 해당되는 상태에 따른 IPerodicElementFinder를 구현한 구상클래스를 반환하고
                    //이를 finder라는 이름의 참조변수로 참조하게된다.
                    //만약 해당되는 state가 없으면 getInstance는 null을 반환한다.
                    IPeriodicElementFinder finder = IPeriodicElementFinderFactory.getInstance(state);
                    //이렇게 생성한 finder가 참조하는 인스턴스를 plist.find()메소드의 인자로 전달한다.
                    //find(IPeriodicElementFinder finder)내부에서는 전달된 인스턴스를 통해 사용자가 입력한 상태에 해당하는 원소들을 List<PeriodicElement>형태로 반환한다.
                    //(물론 실제로 반환되는 인스턴스는 LinkedList<PeriodicElement>이다. 단지 반환형이 List<PeridoicElement>인 것이다.)
                    //이를 periodicElementList참조변수가 참조한다.
                    //이 때 plist.find(IPeriodicElementFinder)메소드는 NullPointerException발생 가능성이 있으므로 이에 대한 예외처리를 하여 주었다.
                    try {
                        //List<PeriodicElement>형 참조변수 periodicElementList가
                        //plist.find(finder)가 반환하는 인스턴스를 참조한다.
                        periodicElementList = plist.find(finder);
                    }catch(NullPointerException e){
                        System.out.println("NullPointerException");
                    }
                }
            }
            //사용자의 잘못된 입력 혹은 선택에 따라 modeNumber가 적절치 않으면 다음의 else문을 실행한다.
            else {
                //사용자에게 잘못된 mode number임을 알리고 다시 입력할 것을 알린다.
                System.out.println("Wrong mode number. Please re-enter.");
                //continue문을 통해서 반복문을 빠져나가지 않으면서 즉시 다음 반복을 진행한다.
                continue;
            }
            //위의 3가지 모드에서 1,2번 모드는 하나의 PeriodicElement를 3번모드는 여러개의 PeriodicElement를 리스트형태로 반환한다.
            //따라서 둘 다 null인 경우에는 잘못된 입력이 있는 것이고 이에 따른 출력을 다음과 같이 한다.
            //(정상적인 경우 하나는 null이더라도 하나는 null이 아닐 것이다.)
            if(periodicElement==null&&periodicElementList==null){
                System.out.println("Invalid Input");
            //모드 번호가 1또는 2번인 경우 그리고 periodicElement가 null이 아니면 periodicElement.print()를 통해 하나의 원소를 출력한다.
            }else if(modeNumber==1||modeNumber==2){
                if(periodicElement!=null) {periodicElement.print(); }
                //만약 periodicElement가 null이면 아무것도 찾지 못한 것이다.
                else{System.out.println("nothing find..");}
            //3번 모드의 경우 plist.find()는 ArrayList<PeriodicElement>를 무조건 반환하여 준다.
            //여기서 문제는 만약 적절한 요소를 찾지 못한 경우에는 ArrayList의 크기가 0일것이라는 것이다.
            //다라서 다음과 같이 모드가 3번이고 periodicElementList가 참조하는 인스턴스(ArrayList)의 size()를 통해 반환되는 값이 0이아니면(즉 ArrayList가 저장하고 있는 요소의 개수가 0이아니면)
            }else if(modeNumber==3&&periodicElementList.size()!=0){
                //이 리스트의 모든 요소를 출력한다.
                for(PeriodicElement pe: periodicElementList){
                    System.out.println("----------------------------------------------------------------------------------------");
                    pe.print();
                }
                System.out.println("----------------------------------------------------------------------------------------");
            //3번모드이면서 periodicElementList가 참조하는 인스턴스(ArrayList)의 크기가 0이면(즉 ArrayList가 저장하고 있는 요수가 없으면(0이면))
            }else if(modeNumber==3&&periodicElementList.size()==0){
                //아무것도 찾은 것이 없다고 사용자에게 알린다.
                System.out.println("nothing find..");
            }
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());

        //while반복문의 조건식이 true이므로 항상 조건이 참이되는 무한루프이다.
        //이 경우 whiel반복문 내부에서 if문을 이용하여 특정 조건이 만족되면 break을 통해 반복문을 빠져나가도록 한다.
        while(true){
            System.out.println("PeriodicTableList에서 찾고싶은 원소의 인덱스번호를 입력하시오.");
            System.out.print(">>");
            //사용자로부터 찾고싶은 원소의 인덱스번호를 UserInput의 getInteger()를 통해 입력받고 이를 elementNumber에 저장한다.
            int elementIndex= UserInput.getInteger();
            //인덱스번호는 0보다 작을 수 없고,getInteger메소드는 잘못된 입력이 있을시(NumberFormatException발생시) -1을 반환한다.
            //이 때 if문을 통해 걸러주지 않으면 'n'입력시 -1보다 1큰 0이되어 정상입력으로 처리할 가능성이 있다. 따라서 이를 if문을 통해 먼저검사하고
            //만약 0보다 작으면 continue를 통해 사용자로부터 다시 입력받을 수 있게한다.
            if(elementIndex<0){
                continue;
            }
            //PeriodicElement형 참조변수를 null로 할당한다.
            PeriodicElement element=null;
            //UserInput.getKey()를 통해 사용자로부터 char형 값을 하나 입력받고 이를 key라는 이름의 변수에 저장한다.
            char key=UserInput.getKey();
            //key의 값이 'q'와 같으면 break을 통해 반복문을 빠져나간다.
            if(key=='q'){
                break;
            //'q'의 값이 ' '와 같으면 continue문을 통해 나머지 반복문의 부분을 생략하고 프로그램의 흐름을 조건검사 부분으로 이동한다.
            }else if(key==' '){
                continue;
            }else{
                //만약 'q'와 ' '가 아니라면 즉 위의 if문들의 조건식을 만족하지 않았다면 다음의 문장을 실행하게 된다.
                //Lab7에 static으로 정의되어 있는 prevOrNextOrCurrent()메소드의 인자로 리스트와 사용자로부터 입력받은 인덱스정보, 그리고 key값을 전달한다.
                element=prevOrNextOrCurrent(plist,elementIndex,key);
            }
            //만약 element가 null아 아니면
            if(element!=null){
                //element가 참조하는 PeriodicElement에 대해서 print()를 호출한다.(실제로는 PeriodicElement를 구현한 구상클래스일 것이다.(추상클래스 대상 인스턴스생성불가))
                element.print();
            }
        }
        System.out.println();

        //-----------------PeriodicTableMap의 모든 메소드 테스트하기------------------//
        //이전에 사용하였던 periodicElements를 다시 활용할 것이다.
        //때문에 이를 활용하기 이전에 null로 할당하여준다.
        periodicElements=null;
        //PeriodicTableMap형 참조변수를 pmap라는 이름으로 선언하면서 동시에 PeriodicTableMap인스턴스를 생성하여 이를 참조하도록 초기화하고 있다.
        PeriodicTableMap pmap=new PeriodicTableMap();
        System.out.println("인덱스 번호를 입력하시오.(원소번호x)");
        while(true) {
            //UserInput클래스의 getInteger클래스를 이용하여 각각 int형 변수 min과 max에 사용자가 입력한 정수를 저장한다.
            //만약 정상적이지 않은 입력인 경우 getInteger()메소드 내부에서 이를 -1로 반환하도록 되어있다.
            System.out.print("min>>");
            int min = UserInput.getInteger();
            System.out.print("max>>");
            int max = UserInput.getInteger();
            //perioicElements참조변수가 ptable.getElements()가 반환하는 PeriodicElement[]배열인스턴스를 참조하도록한다.
            //이 때 이전에 입력받았던 min,max값을 getElements의 인자로 전달하여준다.
            //getElements메소드는 인자로 전달받은 두 값을 통해서 PeriodicTable의 클래스의 인스턴스변수 elements가 참조하는 배열인스턴스의 min인덱스부터 max인덱스까지의 요소를 담은 배열을 반환한다.
            //getElements메소드는 내부에서 if문을 통한 검사와 try-catch구문을 통해 ArrayIndexOutOfRangeException을 내부에서 처리하므로 여기서 따로 처리해줄 예외는 없다.
            periodicElements = ptable.getElements(min, max);
            //만약 getElements를 통해 반환된 값이 null이라면 다음의 if문을 실행한다.
            if (periodicElements == null) {
                //if문 조건식이 만족되어 다음의 if문이 실행되었다는 것은 사용자가 정상적인 입력을 하지 않았다는 것이므로 이에대해 알리고
                System.out.println("다시 입력해주세요.");
                //continue를 통해 사용자가 다시 입력할 수 있도록 반복문의 나머지를 생략하고(반복문을 빠져나가지 않으면서) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }else {
                //만약 사용자가 정상적인 입력을 통해서 periodicElements가 null아닌 정상적인 PeriodicElement[]배열 인스턴스를 참조하게 된다면 다음의 문장을 실행하게된다.
                //for-each문을 통해서 periodicElements가 참조하는 배열인스턴스의 모든 내용을 순차적으로 접근한다.
                //(PeriodicElement형 변수 pe가 배열의 각각의 요소가 참조하는 인스턴스를 참조한다.)
                for (PeriodicElement pe : periodicElements) {
                    //이전에 선언및 생성하였던 PeriodicTableMap객체를 참조하는 pmap의 add메소드를 통하여 pe가 참조하는 인스턴스를 PeriodicTableMap의 인스턴스변수 elements가 참조하는 인스턴스에 저장한다.
                    //이 때 elements가 참조하는 인스턴스는 HashMap<Element,PeriodicElement>이므로 키(key)에 해당하는 값을 함께 전달하여 주어야한다.
                    //때문에 PeriodicElement에 추가한 getElement()를 활용하여 pe가 참조하는 PeriodicElement구상클래스의 인스턴스에 해당하는 Element를 생성하여 add의 인자로 pe가 참조하는 인스턴스와 함께 전달하여준다.
                    //(HashMap은 Key를 통해서 실질적인 데이터 Value를 찾도록 Key와Value가 한쌍인 데이터 저장 방식을 이용한다.)
                    pmap.add(pe.getElement(),pe);
                }
                //break을 통해 while반복문을 빠져나간다.
                break;
            }
        }
        //위의 반복문을 통해 pamap에 추가된 내용을 확인하기 위해 pmap이 참조하는 PeriodicElementMap의 print()메소드를 통해 출력한다.
        pmap.print();
        System.out.println();

        //다음 동작을 수행하기에 앞서 periodicElements를 null로 할당하여준다.
        periodicElements=null;
        //while반복문의 조건식이 true이므로 항상 조건이 참이되는 무한루프이다.
        //이 경우 whiel반복문 내부에서 if문을 이용하여 특정 조건이 만족되면 break을 통해 반복문을 빠져나가도록 한다.
        while(true) {
            System.out.print("random size>>");
            //UserInput의 static메소드인 getInteger()을 호출하여 사용자로부터 정수를 입력받고 이를 int형 변수 size에 저장한다.
            int size=UserInput.getInteger();
            //만약 사용자가 잘못된 입력을 하여 getInteger()가 -1을 반환하거나 사용자가 0보다 작은 값을 입력한 경우
            //변수 size에는 0보다 작은 값이 저장되게 되고 if문은 참이된다.
            if(size<0){
                //사용자에게 잘못된 입력이 있음을 알리고 다시 입력해달라고 알린다.
                System.out.println("잘못된 size입력입니다. size는 0보다 크거나 같아야합니다. 아무런 내용도 추가하고 싶지 않으면 0을 입력하여주세요.");
                //continue문을 통해 사용자가 다시 입력할 수 있도록 반복문의 나머지를 생략하고(반복문을 빠져나가지 않으면서) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }else {
                //if문이 참이되지 않았다면 정상적인 입력(0보다 크거나 같은 입력)이 있는 것이고 else문을 실행하게 된다.
                //ptable은 1부터 50까지의 원소를 저장하고 있는 PeridicTable인스턴스이다. 따라서 ptable의 getRandomElements()메소드를 이용하여
                //1부터 50까지의 화학원소중 랜덤하게 size개를 골라 PeriodicElement[]형태로 반환하여주고 이를 periodicElements가 참조하도록 한다.
                try {
                    //getRandomElements는 NegativeArraySizeException을 일으킬 가능성이 있고, 이를 throws를 통해 호출한영역으로 예외를 넘긴다.
                    //따라서 이를 사용하는 다음의 영역에서 try-catch 구문을 통해서 처리하도록 하였다.
                    //(예를 들어 size가 0보다 작으면 NegativeArraySizeException이 발생한다.)
                    //물론 앞의 if문을 통해서 size가 0보다 작은지 검사하여주지만..
                    periodicElements = ptable.getRandomElements(size);
                }catch(NegativeArraySizeException e){
                    //만약 예기치 못한 상황이 발생하여 NegativeArraySizeException이 발생한 경우 catch문으로 실행흐름이 이어지게되고
                    //다음을 출력한다. 이후 가상머신은 예외가 처리된 것으로 간주하고 프로그램의 실행흐름을 이어나간다.
                    System.out.println("NegativeArraySizeException");
                    //만약 실행흐름이 catch문으로 들어오게되면 사용자로부터 다시 입력을 받아야할 것이기 때문에
                    //반복문의 나머지를 생략하고 조건식을 검사하는 과정으로 분기하도록 continue문을 이용한다.
                    continue;
                }
                //for-each문을 통해서 periodicElements가 참조하는 배열인스턴스의 모든 내용을 순차적으로 접근한다.
                //(PeriodicElement형 변수 pe가 배열의 각각의 요소가 참조하는 인스턴스를 참조한다.)
                for (PeriodicElement pe : periodicElements) {
                    //PeriodicTableMap객체를 참조하는 pmap의 add메소드를 통하여 pe가 참조하는 인스턴스를 PeriodicTableMap의 인스턴스변수 elements가 참조하는 인스턴스에 저장한다.
                    //이 때 elements가 참조하는 인스턴스는 HashMap<Element,PeriodicElement>이므로 키(key)에 해당하는 값을 함께 전달하여 주어야한다.
                    //때문에 PeriodicElement에 추가한 getElement()를 활용하여 pe가 참조하는 PeriodicElement구상클래스의 인스턴스에 해당하는 Element를 생성하여 add의 인자로 pe가 참조하는 인스턴스와 함께 전달하여준다.
                    //즉, getRandomElements()를 통해 얻은 PeriodicElement배열의 모든 내용과 함께 이에 해당하는 Element키값을 함께 저장하여주는것이다.
                    pmap.add(pe.getElement(),pe);
                }
                //이렇게 추가된 내용을 print()메소드를 호출하여 확인하고 break문을 통해 반복문을 빠져나간다.
                pmap.print();
                break;
            }
        }
        System.out.println();

        System.out.println("pmap에 저장된 내용 중 하나를 랜덤으로 고릅니다. ");
        PeriodicElement randomPE=null;
        //pmap이 참조하는 PeriodicTableMap의 getRandomElement()메소드를 호출하여 pmap에 저장된 내용 중 하나를 랜덤하게 고르고 이를 반환한다.
        //이렇게 getRandomElement()가 반환하는 값을 PeriodicElement형 참조변수 randomPE가 참조한다.
        //이 때 getRandomElement()가 반환하는 인스턴스는 실제로 PeriodicElement가 아닌 PeriodicElement를 구현한 구상클래스의 인스턴스일 것이다.
        //PeriodicElement형 참조변수 randomPE는 모든 PeriodicElement의 구상클래스의 인스턴스를 참조할 수 있다.
        //이 때 getRandomElement()메소드는 IndexOutOfBoundsException을 일으킬 가능성이 있고 이를 throws를 통해 getRandomElement()를 호출한 영역으로 넘긴다.
        //따라서 다음과 같이 try-catch구문을 통해 예외를 처리하여준다.
        try{
            randomPE=pmap.getRandomElement();
        }catch(IndexOutOfBoundsException e){
            //IndexOutOfBoundsException이 발생하였음을 알린다.
            System.out.println("IndexOutOfBoundsException");
        }
        //randomPE가 참조하는 인스턴스의 print()를 호출한다.(다형성)(실제 참조하는 구상클래스에 따라 오버라이딩된 print()가 호출되고 각 구상클래스에 따라 동작이 다르다.)
        randomPE.print();
        System.out.println();
        System.out.println("sorting...");
        //pmap의 메소드 sort()를 이용하여 pmap이 참조하는 PeriodicTableMap내부의 인스턴스 변수 elements가 참조하는 HashMap<Element,PeriodicElement>를
        //TreeMap<Element,PeriodicELement>로 변경한다. 이를통해 정렬을 한다.(이에 대한 내용은 PeriodicTableMap에서 설명)
        pmap.sort();
        //정렬된 map의 모든 내용을 출력한다.
        pmap.print();
        //pamp.size()를 통해서 pmap이 참조하는 PeriodicTableMap클래스의 인스턴스 변수 elements가 참조하는 인스턴스의 size()를 내부적으로 호출하여 포함된 요소의 개수를 반환한다.
        System.out.println("맵의 전체 크기는 "+pmap.size()+"입니다.");
        System.out.println("맵 전체 출력(key,value)");
        //pmpa.print()를 통해서 맵의 key와 value를 함께 출력한다.
        pmap.print();
        System.out.println("맵의 key 전체 출력");
        //printKeys()메소드를 통해서 pmap이 참조하는 인스턴스의 맵의 내용중 key값만을 출력한다.
        pmap.printKeys();
        System.out.println("맵의 value 전체 출력");
        //printValues()메소드를 통해서 pamap이 참조하는 인스턴스의 맵의 내용중 value에 해당하는 값만을 출력한다.
        pmap.printValues();
        System.out.println();

        System.out.println("pmap에서 원소를 삭제하고 싶다면 'Y'를 입력하시오.");
        System.out.println("그렇지 않다면 'Y'를 제외한 아무키나 입력하시오.");
        System.out.print(">>");
        //UserInput의 static메소드 getString()을 통해 문자열을 입력받고 toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
        //이를 String형 input참조변수로 참조한다.
        input=UserInput.getString().toUpperCase();
        //input과 "Y"를 equals를 통해 내용비교를 진행한다.
        //만약 if의 조건식이 참이면 if문 내의 문장들을 실행한다.
        if(input.equals("Y")) {
            do {
                System.out.println("삭제되기 이전에 맵의 전체 크기는 "+pmap.size()+"입니다.");
                System.out.println("삭제하고 싶은 PeriodicElement를 입력하시오.");
                System.out.print(">>");
                //UserInput의 getPeriodicElement()를 통해서 사용자 입력정보를 바탕으로 한 PeriodicElement인스턴스를 생성하고 이를 periodicElement가 참조한다.
                //이 때 적절하지 않은 경우 원소번호(number) 0인 UnknownPeriodicElement를 생성한다.
                periodicElement = UserInput.getPeriodicElement();
                //사용자가 입력한 내용을 바탕으로 생성한 PeriodicElement구상클래스의 인스턴스에 대해서 getElement()를 호출하여 해당 PeriodicElement의 Element를 반환한다.
                //이렇게 반환된 Element를 pmap의 remove()메소드의 인자로 전달한다. 따라서 해당 Element(Key)값을 토대로 해당하는 값을 삭제한다.
                //그런데 그전에 pmap의 containsValue()의 인자로 사용자가 입력한 내용을 바탕으로 생성한 PeriodicElement구상클래스의 인스턴스를 참조하는 참조변수를 전달한다.
                //왜냐하면 getElement()를 통해 반환되는 Element는 PeriodicElement의 number인스턴스변수와 동일한 상수값을 가지는 Element를 반환하지 이름, 기호등은 다를 수 있기 때문이다.
                //따라서 원소번호(number)만이 동일한 적절하지 않은 입력으로 pmap의 내용을 삭제할 수 있기 때문에 맵의 Value에 해당하는 PeriodicElement에 대해서
                //pmap이 저장하고 있는 요소들 중 해당하는 내용이 있는지를 if문을 통해 먼저 검사한다.
                if(pmap.containsValue(periodicElement)) {
                    //if문이 참이면 다음을 진행한다.
                    try {
                        //PeriodicElement에 정의되어 있는 getElement()메소드는 원소번호number와 ELement의 상수값을 비교하여 같은 값을 반환하여 준다.
                        //그런데 만약 적절하지 않은 입력에 의해 getPeriodicElement()가 반환하는 것이 원소번호가 0인 UnknownPeriodicElement인 경우
                        //getElement()가 반환하는 값은 null이 될 것이고 이를 remove메소드의 인자로 전달하게되면 PeriodicTableMap의 remove메소드에서
                        //NullpointerException이 발생하고 프로그램이 종료된다.
                        //따라서 다음고 같이 try-catch구문을 통해서 예외를 처리하도록 하였다.
                        pmap.remove(periodicElement.getElement());
                    } catch (NullPointerException e) {
                        //NullPointerException이 발생한 경우 사용자에게 이를 알리고
                        //continue문을 통해 나머지 반복을 생략하고 프로그램의 흐름을 조건검사부분으로 이동시킨다.
                        System.out.println("적절하지 않은 PeriodicElement입니다.");
                        continue;
                    }
                    //삭제된 이후의 pmap의 내용에 대해서 print()를 통해 출력하여 확인한다.
                    pmap.print();
                    //또한 pmap.size()를 통해 삭제 이후의 맵의 크기를 출력하여 확인한다.
                    //pmap의 remove는 boolean값을 반환하지 않으므로 삭제 이전과 이후의 맵의 전체 크기를 비교하여 삭제가 이루어졌는지를 짐작할 수 있게끔 하려는 의도이다.
                    System.out.println("삭제한 이후, 맵의 전체 크기는 " + pmap.size() + "입니다.");
                }else{
                    //if문이 참이되지 않은 것은 pmap이 참조하는 맵인스턴스의 요소에 해당하는 value가 없다는 의미이고 사용자가 입력한 PeriodicElement는 pmap에 존재하니 않는 화학원소이기 때문에
                    //pmap에 존재하지 않는 화학원소에 대해서 삭제할 수 없음을 알리고 continue를 통해 다음 반복으로 넘어간다.
                    System.out.println("pmap에 존재하지 않는 PeriodicElement입니다. 삭제할 수 없습니다.");
                    continue;
                }
            } while (!UserInput.getExitKey());
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }
        System.out.println();

        do {
            System.out.println("변경하고자하는 PeriodicElement에 해당하는 element를 입력하시오");
            System.out.print(">>");
            //사용자로부터 UserInput.getElement를 통해서 Element에 대한 정보(이름 혹은 원소번호)를 입력받고 이에 따른 Element를 반환한다.
            Element changeElement=UserInput.getElement();
            System.out.println("element에 해당하는 PeriodicElement를 입력하시오");
            System.out.print(">>");
            //UserInput의 getPeriodicElement()를 통해서 사용자 입력정보를 바탕으로 한 PeriodicElement인스턴스를 생성하고 이를 periodicElement가 참조한다.
            //이 때 적절하지 않은 경우 원소번호(number) 0인 UnknownPeriodicElement를 생성한다.
            PeriodicElement changePE = UserInput.getPeriodicElement();
            //pmap을 통한 set메소드의 호출한다. 이 때 set메소드 인자를 통해 전달되는 changeElement가 위의 입력과정에서
            //null로 할당될 수 있기 때문에 이 메소드를 사용하는 문장에 대해서 예외처리를 할수 있도록하였다.
            try {
                //set메소드호출의 반환이 true이면 변경이 성공적으로 이루어졌음을 이미한다.
                if(pmap.set(changeElement, changePE)){
                    //if문이 참이라는 것은 set을 통한 내용의 변경이 성공적으로 이루어졌음을 의미한다.
                    //내용이 변경되었음을 알리고 pmap.print()를 통해 변경된 내용을 출력한다.
                    System.out.println("변경된 내용은 다음과 같습니다.");
                    pmap.print();
                //if의 조건식이 거짓이면 else문이 실행된다. 즉 set을 통한 내용의 변경이 이루어지지 않았음을 의미한다.
                }else{
                    //이에 대한 내용을 출력한다.
                    System.out.println("입력하신 Element에 해당하는 내용이 맵에 존재하지 않습니다.");
                }
            }catch(NullPointerException e){
                //만약 set메소드에서 NullPointerException이 일어나게되면 key인 changeElement는 null이 될 수 없음을 사용자에게 알린다.
                System.out.println("The key cannot be null");
            }
        }while(!UserInput.getExitKey());
        //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        System.out.println();


        do {
            //이전에 사용하였던 periodicElement와 periodicElementList를 다시 활용할 것이다.
            //따라서 pmap에 대한 find작업을 하기 앞서서 두 변수에 대해서 null로 설정하여준다.
            //만약 그렇지 않으면 이전에 찾았던 인스턴스를 계속 참조하고 있어 정상적이지 않은 동작이 이루어진다.
            periodicElement=null;
            periodicElementList=null;
            System.out.println("찾고자 하는 원소를 기호(symbol)로 찾을지 Element정보를 통해서 찾을지 IPeriodicElementFinder를 이용하여 찾을지 선택하여 주세요.");
            System.out.println("Mode 1.find by symbol");
            System.out.println("Mode 2.find by element information");
            System.out.println("Mode 3.find by using IPeriodicElementFinder");
            System.out.print("Enter the mode number>>");
            //사용자로부터 어떤 모드로 원소를 찾을지 UserInput클래스의 getInteger()를 통해서 입력받는다.
            int modeNumber = UserInput.getInteger();
            //modeNumber에 저장된 값이 1이면
            if (modeNumber == 1) {
                System.out.println("Enter symbol");
                System.out.print(">>");
                //사용자로부터 UserInput.getString()을 통해 문자열(String)형태의 symbol을 입력받는다.
                String symbol=UserInput.getString();
                //PeriodicTableMap에 정의된 find(String symbol)메소드를 통하여 해당되는 원소를 찾는다.
                //만약 pmap이 저장하고 있는 내용(value)에 해당하는 symbol이 없는 경우 null을 반환하고 해당되는 원소가 있으면
                //value에 해당하는 PeriodicElement형 원소(실제로 이를 구현한 구상클래스의 인스턴스)를 반환한다.
                periodicElement=pmap.find(symbol);
            //modeNumber에 저장된 값이 2이면
            } else if (modeNumber == 2) {
                System.out.println("Enter element information(name or number)");
                System.out.print(">>");
                //사용자로부터 UserInput.getElement를 통해서 Element에 대한 정보(이름 혹은 원소번호)를 입력받고 이에 따른 Element를 반환한다.
                Element element=UserInput.getElement();
                //PeriodicTableMap에 정의된 find(Element)메소드를 통하여 해당되는 원소를 찾는다.
                //만약 pmap이 저장하고 있는 키에 해당하는 Element가 없는경우 null을 반환하고 해당되는 원소가 있으면
                //Value에 해당하는 PeriodicElement형 원소(실제로 이를 구현한 구상클래스의 인스턴스)를 반환한다.
                //pmap.find()의 인자로 element를 전달하는데 find내부에서 NullPointerException이 발생할 수 있고 throws를 통해 이를 호출한 영역으로 넘긴다.
                //따라서 이에 대한 예외처리를 하여주었다.
                try {
                    periodicElement = pmap.find(element);
                }catch(NullPointerException e){
                    //NullPointerException이 발생한 경우 사용자에게 이를 알리고
                    //continue문을 통해서 반복문을 빠져나가지 않으면서 즉시 다음 반복을 진행한다.
                    System.out.println("Invalid Input");
                    continue;
                }
            //modeNumber에 저장된 값이 3이면
            } else if (modeNumber == 3) {
                System.out.println("Enter the state of the finder");
                System.out.print(">>");
                //사용자로부터 getState()를 통해 상태를 입력받는다.
                State state=UserInput.getState();
                //만약 state가 참조하는 State값이 null이 아니면, 즉 사용자가 정상적인 입력을 하여 getState()가 반환하는 값이 null이 아니면
                if(state!=null) {
                    //IPeriodicElementFinderFactory클래스의 getInstance메소드의 인자로 전달한다.
                    //이를 통해 해당되는 상태에 따른 IPerodicElementFinder를 구현한 구상클래스를 반환하고
                    //이를 finder라는 이름의 참조변수로 참조하게된다.
                    //만약 해당되는 state가 없으면 getInstance는 null을 반환한다.
                    IPeriodicElementFinder finder = IPeriodicElementFinderFactory.getInstance(state);
                    //이렇게 생성한 finder가 참조하는 인스턴스를 pmap.find()메소드의 인자로 전달한다.
                    //find(IPeriodicElementFinder finder)내부에서는 전달된 인스턴스를 통해 사용자가 입력한 상태에 해당하는 원소들을 List<PeriodicElement>형태로 반환한다.
                    //(물론 실제로 반환되는 인스턴스는 LinkedList<PeriodicElement>이다. 단지 반환형이 List<PeridoicElement>인 것이다.)
                    //이를 periodicElementList참조변수가 참조한다.
                    //이 때 pmap.find(IPeriodicElementFinder)메소드는 NullPointerException발생 가능성이 있으므로 이에 대한 예외처리를 하여 주었다.
                    try {
                        //List<PeriodicElement>형 참조변수 periodicElementList가
                        //pmap.find(finder)가 반환하는 인스턴스를 참조한다.
                        periodicElementList = pmap.find(finder);
                    }catch(NullPointerException e){
                        System.out.println("NullPointerException");
                    }
                }
            //사용자의 잘못된 입력에 따라 modeNumber가 적절치 않으면 다음의 else문을 실행한다.
            } else {
                //사용자에게 잘못된 mode number임을 알리고 다시 입력할 것을 알린다.
                System.out.println("Wrong mode number. Please re-enter.");
                //continue문을 통해서 반복문을 빠져나가지 않으면서 즉시 다음 반복을 진행한다.
                continue;
            }
            //위의 3가지 모드에서 1,2번 모드는 하나의 PeriodicElement를 3번모드는 여러개의 PeriodicElement를 리스트형태로 반환한다.
            //따라서 둘 다 null인 경우에는 잘못된 입력이 있는 것이고 이에 따른 출력을 다음과 같이 한다.
            //(정상적인 경우 하나는 null이더라도 하나는 null이 아닐 것이다.)
            if(periodicElement==null&&periodicElementList==null){
                System.out.println("Invalid Input");
            //모드 번호가 1 또는 2번인 경우 그리고 periodicElement가 null이 아니면 periodicElement.print()를 통해 하나의 원소를 출력한다.
            }else if(modeNumber==1||modeNumber==2){
                if(periodicElement!=null) {periodicElement.print(); }
                //만약 periodicElement가 null이면 아무것도 찾지 못한 것이다.
                else{System.out.println("nothing find..");}
            //3번모드의 경우 pmap.find()는 ArrayList<PeriodicElement>를 무조건 반환하여 준다.
            //여기서 문제는 만약 적절한 요소를 찾지 못한 경우에는 ArrayList의 크기가 0일것이라는 것이다.
            //따라서 다음과 같이 모드가 3번이고 periodicElementList가 참조하는 인스턴스(ArrayList)의 size()를 통해 반환되는 값이 0이아니면(즉 ArrayList가 저장하고 있는 요소의 개수가 0이아니면)
            }else if(modeNumber==3&&periodicElementList.size()!=0){
                //이 리스트의 모든 요소를 출력한다.
                for(PeriodicElement pe: periodicElementList){
                    System.out.println("----------------------------------------------------------------------------------------");
                    pe.print();
                }
                System.out.println("----------------------------------------------------------------------------------------");
            //3번모드이면서 periodicElementList가 참조하는 인스턴스(ArrayList)의 크기가 0이면(즉 ArrayList가 저장하고 있는 요수가 없으면(0이면))
            }else if(modeNumber==3&&periodicElementList.size()==0){
                //아무것도 찾은 것이 없다고 사용자에게 알린다.
                System.out.println("nothing find..");
            }
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());

        do{
            periodicElement=null;
            System.out.println("PeriodicElementMap에서 찾고 싶은 원소(name or number)를 입력하시오.");
            System.out.print(">>");
            //사용자로부터 UserInput.getElement를 통해서 Element에 대한 정보(이름 혹은 원소번호)를 입력받고 이에 따른 Element를 반환한다. 이를 element라는 Element형 참조변수로 참조한다.
            Element element=UserInput.getElement();
            //만약 UserInput.getElement()가 반환하는 값이 null이 아니면 다음 if문은 참이된다.
            if(element!=null){
                //pamp.get()의 인자로 사용자로부터 입력받아 생성한 Element를 전달한다.
                //이를 통해 pmap이 참조하는 PeriodicTableMap의 맵에대 get인자로 준 element에 해당하는 Value값(PeriodicElement)를 반환한다.해
                //그렇게 반환된 인스턴스를 periodicElement로 참조한다.
                periodicElement=pmap.get(element);
            }else{
                //만약 if문이 참이면 element는 null이고 해당하는 원소이름 혹은 번호가 존재하지 않는다는 의미이다.
                //따라서 이에 대한 내용을 출력하고 continue를 통해서 반복문의 나머지부분을 생략하고 다음반복(반복문의 조건식부분)으로 분기한다.
                System.out.println("존재하지 않는 원소이름(element name)혹은 번호(number)입니다.\n");
                continue;
            }
            //만약 pmap.get()을 통해 반환된 값이 null이 아니면
            if(periodicElement!=null){
                //if문이 참이라는 것은
                //get()의 인자로 전달하여준 값이 맵에 존재하는 키값이고, 해당 키값의 value(PeriodicElement)를 찾아 periodicElement가 참조하고 있다는 의미이다.
                //이렇게 찾은 내용(PeriodicElement구상클래스의 인스턴스)을 print()를 통해 출력한다.
                periodicElement.print();
            }else{
                //만약 pmap.ge()을 통해 반환된 값이 null이면 사용자의 입력을 통해 생성한 Element에 해당되는 내용이 pmap존재하지 않는 것이므로 이에 대해서 출력하고
                //continue를 통해 반복문의 나머지를 생략하고(반복문을 빠져나가지 않고) 반복문의 조건식을 검사하는 과정으로 분기한다.
                System.out.println("pmap에 존재하지 않는 원소입니다.\n");
                continue;
            }
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());

        ㅌㅌ2
    }
}