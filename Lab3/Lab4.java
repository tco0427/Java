//main메소드를 가지고 있는 Lab4클래스
//실제 프로그램의 실행흐름을 담당
//실행흐름제어(컨트롤)
//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.

public class Lab4 {
    /*
    PeriodicElement인스턴스를 참조할 수 있는 PeriodicElement배열에(인스턴스에 대한 레퍼런스를 갖는 배열)
    각각의 인스턴스들을 생성하여 이를 배열의 각 원소가 참조하는 배열인스턴스를 elements라는 이름으로 선언과동시에 초기화하였다.
    //elements는 PeriodicElement 인스턴스를 저장(참조)할 수 있는 참조변수의 배열로 볼 수 있다.
    //따라 배열의 생성은 인스턴스의 생성과 무관하다. 하지만 현재 이 코드와 관련된 경우 배열을 생성하면서
    //동시에 각 인스턴스들을 생성하여 이를 원소로하고 있다. 즉 배열의 선언과 동시에 초기화를 한 것이다.
    private로 선언하였으므로 클래스 내부에서만 접근이 가능하며
    static으로 선언되었으므로 클래스 로딩시에 정적으로(static) 메모리 공간을 할당받으며
    인스턴스생성과는 무관하게 접근이 가능하다.(클래스 내부에서만private)
     */

    //PeriodicElement클래스의 생성자에 변경이 있으므로(State열거형을 저장하는 state인스턴스 변수로(필드)를 추가하였고 이로인해 생성자도 수정하였다.)
    //PeriodicElement[] 배열(PeriodicElement인스턴스(객체)에 대한 래퍼런스를 갖는 배열)의 각 원소인 PeriodicElement를 생성하는 코드들을 수정(state에 해당하는 값을 인자로 전달)하였다.
    private static PeriodicElement[] elements={
            new PeriodicElement(1,"H","Hydrogen",1.008,State.GAS),
            new PeriodicElement(2,"He","Helium",4.0026,State.GAS),
            new PeriodicElement(3,"Li","Lithium",6.94,State.SOLID),
            new PeriodicElement(4,"Be","Beryllium",9.0122,State.SOLID),
            new PeriodicElement(5,"B","Boron",10.81,State.SOLID),
            new PeriodicElement(6,"C","Carbon",12.011,State.SOLID),
            new PeriodicElement(7,"N","Nitrogen",14.007,State.GAS),
            new PeriodicElement(8,"O","Oxygen",15.999,State.GAS),
            new PeriodicElement(9,"F","Fluorine",18.998,State.GAS),
            new PeriodicElement(10,"Ne","Neon",20.180,State.GAS),
            new PeriodicElement(11,"Na","Sodium",22.990,State.SOLID),
            new PeriodicElement(12,"Mg","Magnesium",24.305,State.SOLID),
            new PeriodicElement(13,"Al","Aluminium",26.982,State.SOLID),
            new PeriodicElement(14,"Si","Silicon",28.085,State.SOLID),
            new PeriodicElement(15,"P","Phosphorus",30.974,State.SOLID),
            new PeriodicElement(16,"S","Sulfur",32.06,State.SOLID),
            new PeriodicElement(17,"Cl","Chlorine",35.45,State.GAS),
            new PeriodicElement(18,"Ar","Argon",39.948,State.GAS),
            new PeriodicElement(19,"K","Kalium",39.098,State.SOLID),
            new PeriodicElement(20,"Ca","Calcium",40.078,State.SOLID),
            new PeriodicElement(21,"Sc","Scandium",44.956,State.SOLID),
            new PeriodicElement(22,"Ti","Titanium",47.867,State.SOLID),
            new PeriodicElement(23,"V","Vanadium",50.942,State.SOLID),
            new PeriodicElement(24,"Cr","Chrominum",51.996,State.SOLID),
            new PeriodicElement(25,"Mn","Manganese",54.938,State.SOLID),
            new PeriodicElement(26,"Fe","Iron",55.845,State.SOLID),
            new PeriodicElement(27,"Co","Cobalt",58.933,State.SOLID),
            new PeriodicElement(28,"Ni","Nickel",58.693,State.SOLID),
            new PeriodicElement(29,"Cu","Copper",63.546,State.SOLID),
            new PeriodicElement(30,"Zn","Zinc",65.38,State.SOLID),
            new PeriodicElement(31,"Ga","Gallium",69.723,State.SOLID),
            new PeriodicElement(32,"Ge","Germanium",72.630,State.SOLID),
            new PeriodicElement(33,"As","Arsenic",74.922,State.SOLID),
            new PeriodicElement(34,"Se","Selenium",78.971,State.SOLID),
            new PeriodicElement(35,"Br","Bromine",79.904,State.LIQUID),
            new PeriodicElement(36,"Kr","Krypton",83.798,State.GAS),
            new PeriodicElement(37,"Rb","Rubidium",85.468,State.SOLID),
            new PeriodicElement(38,"Sr","Strontium",87.62,State.SOLID),
            new PeriodicElement(39,"Y","Yttrium",88.906,State.SOLID),
            new PeriodicElement(40,"Zr","Zirconium",91.224,State.SOLID),
            new PeriodicElement(41,"Nb","Niobium",92.906,State.SOLID),
            new PeriodicElement(42,"Mo","Molybdenum",95.95,State.SOLID),
            new PeriodicElement(43,"Tc","Technetium",98,State.SOLID),
            new PeriodicElement(44,"Ru","Ruthenium",101.07,State.SOLID),
            new PeriodicElement(45,"Rh","Rhodium",102.91,State.SOLID),
            new PeriodicElement(46,"Pd","Palladium",106.42,State.SOLID),
            new PeriodicElement(47,"Ag","Silver",107.87,State.SOLID),
            new PeriodicElement(48,"Cd","Cadmium",112.41,State.SOLID),
            new PeriodicElement(49,"In","Indium",114.82,State.SOLID),
            new PeriodicElement(50,"Sn","Tin",118.71,State.SOLID)
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
    //int형 배열을 받아서 배열의 값이 0보다 작거나 같은 값이 존재하는지 확인하고 만약 존재한다면 false를 아니라면 true를 반환하는 메소드이다.
    public static boolean checkBetweenInteger(int[] intArray){
        //intArray의 인스턴스 변수 length를 통해 배열의 길이정보를 알아내서 0부터 길이-1까지(모든 배열 원소의 인덱스)를 for문을 통해 접근할 수 있다.
        for(int i=0;i<intArray.length;i++){
            //0보다 작거나 같은 값이 있다면
            //배열은 생성되면 0또는 null로 초기화된다.만약 0보다 작으면
            //Integer.parseInt()에 문제가 있다는 것이거나
            //사용자가 잘못된 입력을 한 경우이다.(원소번호는 1부터 시작이고 따라서 min혹은 max값도 1보다 크거나 같아야한다.)
            if(intArray[i]<=0)
                //false를 반환하고 return을 만났으므로 메소드를 종료한다.
                return false;
        }

        //for문을 반복하는 동안 if문이 실행되지 않았다면 true를 반환하고 return(메소드를 종료)한다.
        return true;
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
            //static으로 정의된 getPeriodicElement()에 elements(PeriodicElement배열)과 함께 element를 전달한다. 그리고 반환되는 PeriodicElement형 인스턴스를
            //pElement라는 이름의 참조변수가 참조한다.
            PeriodicElement pElement=getPeriodicElement(elements,element);
            //pElement를 출력한다. 이 때 인스턴스에 대한 출력은 toString()메소드의 호출로 이어진다.
            //따라서 PeriodicElement에서 오버라이딩한 toString()이 출력된다.(오버라이딩하지않으면 Object에 정의된 toString()호출)
            System.out.println(pElement);
            //PeriodicElement에 정의된getState()메소드를 통해 State state필드를 반환
            System.out.println(pElement.getState());
            System.out.println();
        }

        do{
            System.out.println("Please enter 'number symbol name weight state' of PeriodicElement");
            System.out.print(">>");
            //PeriodicElement클래스에 static(정적)으로 정의된 PeriodicElement메소드를 클래스이름을 통해 접근하여 호출하고 있다.
            //이 메소드의 인자로 사용자의 입력을 전달(문자열형태로)하고 PeriodicElement인스턴스를 반환해준다.
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
            Element에 정의된 static메소드 nameOf는 null을 반환할 가능성이 있고 이를통한 getPeriodicElement에서의 getValue()호출은
            NullPointerException을 발생시킬 가능성이 있다.
            따라서 getElement를 사용하는 곳에서는 혹시나 모를 NullPointerException발생을 염두해두는 것이 좋은 프로그램이며
            이를 위해 try-catch구문을 통해 예외를 처리하도록 하였다. 또한 NullPointerException이 발생했다는 것은 잘못된 입력이
            존재할 수 있다는 것이므로 이를 사용자에게 알리는 문장을 catch문에서 구현하였다.
            getPeriodicElement에서도 null을 반환하는 경우가 존재하므로 이를 사용하는 element.getState()에서 NullPointerException예외 발생도 함께 처리할 수 있다.
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
                //이를 통해 반환된 PeriodicElement인스턴스를 출력한다.
                //element가 가리키는 인스턴스(getPeriodicElement를 통해 반환된 인스턴스)는 elements배열에 존재하는 인스턴스와 같다.
                //즉 예를들어 element가 (2,'He','Helium',4.0026)인 인스턴스를 참조한다면 이는 elements[1]을 통해 참조하는 인스턴스와 같다.
                System.out.println(element + " ");
                //element가 참조하는 PeriodicElement형 인스턴스의 getState()메소드를 호출한다.
                //getPeriodicElmeent에서 null을 반환할 가능성이 있고 그러할 경우 NullPointerException이 발생하므로 try구문 안에서 호
                State state = element.getState();
                //이를 출력한다.
                //State에서는 toString()을 오버라이딩하지 않았으므로 Enum에 정의되어있는
                //public String toString() { return name;}
                //을 출력한다.(name은 열거형상수의 이름, Enum에 private final String name;으로 정의되어 있음)
                System.out.println(state);
            }catch(NullPointerException e){
                System.out.println("잘못된 입력이 존재하거나 프로그램내에 정의되어 있지 않은 원소 출력(51~118)을 요구하셨습니다.");
            }
            //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
            System.out.println();
        }while(!UserInput.getExitKey());
        System.out.println();


        //---------------------Lab4에 해당하는 내용----------------------//

        //PeriodicElement에 추가한 인스턴스 변수(필드) state에 대해 출력
        System.out.println("Print element state");
        //PeriodicElement형 배열(Lab4클래스에서 static변수(클래스변수)로 선언되어 있는 elements
        //for-each(enhanced for)문을 통해 elements(PeriodicElement[])의 모든 원소를 접근하며
        //반복을 진행하면서 배열의 각각의 원소가 참조하는 인스턴스를 element또한 참조하게 된다.
        for(PeriodicElement element: elements){
            //PeriodicElement클래스에 정의되어 있는 getName()과 getState()를 호출하고 이를 출력한다.
            System.out.println(element.getName()+": "+element.getState());
        }
        System.out.println();


        //PeriodicTable에 정의한 toString()을 호출한다.
        //PeriodicTable이 참조하는 PeriodicElement배열 인스턴스의 원소 내용 모두 출력
        System.out.println("Print PeriodicTable through toString() Method");
        System.out.println(ptable.toString());
        System.out.println();

        //ptable이 참조하는 인스턴스는 PeriodicTable이고 이 클래스에 static으로 정의되어 있는 print()메소드를 호출하여
        //ptable이 참조하는 인스턴스의 인스턴스변수 elements(PeriodicElement[]형 변수로 PeriodicElement인스턴스를 참조할 수 있는 참조변수의 배열로 볼 수 있다. 객체에 대한 래퍼런스를 원소로 가지는 배열)
        //의 원소가 참조하는 모든 인스턴스의 내용 출
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
            //혹은 checkBetweenInteger의 반환값이 거짓인경우 if문의 몸체{}부분 실행
            if(intArray.length!=2||!checkBetweenInteger(intArray)){
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
            PeriodicElement element=ptable.find(elementNumber);
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
            //parsePeriodicElement가 반환하는 periodicElmeent인스턴스를 pe참조변수를 통해 참조(null반환 가능성 존재)
            PeriodicElement pe = PeriodicElement.parsePeriodicElement(ElementInfo);
            //pe가 참조하는 인스턴스가 null이 아니면 if문 내부의 문장{} 실행
            if (pe != null) {
                //PeriodicElement에 정의한 print()를 통한 원소의 정보 출력
                pe.print();
            }
        //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());
        System.out.println();




        //while문 이용력
        //getKey()메소드와 getNext(),getPrevious(),get()메소드를 활용하여 원소번호를 통한 원소정보 출력
        while(true){
            System.out.println("Please enter Element number");
            System.out.print(">>");
            //UserInput클래스에 static으로 정의된 getInteger()를 호출하여 반환되는 int형 값을 elementNumber변수에 저장
            int elementNumber= UserInput.getInteger();
            //프로그램 내부적으로 get을 통한 인덱스 접근을 하기 때문에 사용자의 입력(1~50)을 1감소 시킨 (0~49)로 변경해주어야한다.
            elementNumber-=1;
            //ptable(PeriodicTable형 인스턴스) static 변수를 통해 PeriodicTable클래스에 정의되어 있는 get()을 호출한다.
            //이 때 사용자로부터 입력받은 (원소번호-1)을 인자로 전달하고 반환되는 PeriodicElement인스턴스를 element참조변수로 참조한다.
            PeriodicElement element=ptable.get(elementNumber);
            //element가 참조하는 인스턴스가 null이 아닐경우 if문의 중괄호 부분 실행
            if(element!=null){
                System.out.println("Element information according to the entered element number");
                //element가 참조하는 인스턴스가 null이 아닌경우로(if조건식) 제대로된 PeriodicElement 인스턴스를 참조한다고 볼 수 있으므로
                //element에 Non-static으로 정의된 print()메소드를 참조변수이름을 통해 호출
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
                    //elementNumber이전(Previous)인덱스에 해당하는 PeriodicElement인스턴스를 반환하도록 하고 이를 element가 참조한다.
                    //element가 참조하는 인스턴스와 ptable.getPrevious()를 통해 반환한 인스턴스는 동일 인스턴스이다.
                    //즉 element를 통해 인스턴스의 정보 변경 시 ptable에 해당 인스턴스의 정보도 변경된다. (주의해야함)
                    element=ptable.getPrevious(elementNumber);
                //사용자로부터 입력 받은 값이 'n'과 같으면
                }else if(c=='n'){
                    //ptable(PeriodicTable)에 정의되어 있는 getNext의 인자로 이전에 입력받았던 elementNumber를 전달하여
                    //elementNumber이후(Next)인덱스에 해당하는 PeriodicElement인스턴스를 반환하도록 하고 이를 element가 참조한다.
                    element=ptable.getNext(elementNumber);
                    //이 경우에는 이미 정상적인 입력이 있었을 경우 사용자가 입력한 elementNumber에 대한 원소의 내용이 elemenet.print()를 통해 출력되었지만
                    //다른 경우에 (이전,이후가 아닌) 현재 인덱스에 해당하는 원소의 정보를 원할수도 있기에 c(current)에 해당하는 내용을 getKey()에 추가하였고,
                    //이 경우에는 이전,이후 인덱스의 원소(PeriodicElement)에 대한 내용을 원하지 않고 다시 한 번 더 출력하길 원할 경우 이요할 수 있다.
                }else if(c=='c'){
                    element=ptable.get(elementNumber);
                    //사용자의 입력이 'q','p','n','c'가 아닌 경우에는 ' '와 같게되고 반복문을 빠져나가지 않으면서 반복문 실행도중에 즉시 다음 반복으로 넘어간다.
                }else if(c==' '){
                    continue;
                }
                //모든 작업(이전,이후,현재에 해당하는 PeriodicElement인스턴스를 element가 참조)이 진행된 이후
                //정상적일 경우 null이 아닌 PeriodicElement를 참조하게 될 것이고 이 경우에 해당하여 print()메소드를 실행한다.
                if(element!=null){
                    element.print();
                }
            }
            //처음 사용자가 입력한 elementNumber가 적절치 않은 경우 혹은 p,n,c등을 통한 이전,이후,현재에 해당하는 인덱스의 접근이 적절치 않은 경우에는
            //다음의 문장을 통해 사용자에게 적절치 않음을 알린다.
            //ex)사용자로부터 입력받은 elementNumber를 1감소시킨(사용자는 원소번호를 입력 프로그램 내에서의 접근은 인덱스)값이 0인 경우 'p'를 통해 이전 인덱스에 대한 접근은
            //-1이 되고 적적치 않다.
            if(element==null){
                System.out.println("원소번호는 1부터 시작하며, 프로그램 상에서는 50까지의 원소가 저장되어 있습니다.(1-50)");
                System.out.println();
            }
        }
        System.out.println();

        //PeriodicTable에 정의되어 있는 find(Element element)를 이용
        while(true){
            System.out.println("Please enter Element(Element name or Element number)");
            System.out.print(">>");
            //UserInput클래스에 static으로 정의되어 있는 getElement()메소드를 클래스 이름을 통해 접근 및 호출한다.
            //getElement()메소드가 반혼하는 Element열거형(열거형 상수 하나하나가 Element객체(인스턴스)이다.)을 element변수가 참조한다.
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
                //반환되는 PeriodicElement인스턴스를 pe참조변수로 참조한다.
                PeriodicElement pe = ptable.find(element);
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
            //ptable을 통해 find메소드를 호출하고 인자로 사용자로부터 입력받은 정수(int)를 전달한다. 반환되는 PeriodicElement인스턴스를 pe를 통해 참조
            PeriodicElement pe=ptable.find(eNum);
            //만약 pe가 null이아니면 pe를 출력(pe.toString()메소드 호출로 이어진다.) null이면 잘못된 입력임을 알림
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
            //ptable을 통해 find메소드를 호출하고 인자로 사용자로부터 입력받은 String을 전달한다. 반환되는 PeriodicElement인스턴스를 pe를 통해 참조
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
            //ptable을 통해 find메소드를 호출하고 인자로 전달된 eState와 일치하는 상태(State)를 가진 모든 PeriodicElement를 배열형태로 반환하고 이 배열인스턴스를
            //peArray를 통해 참조
            PeriodicElement[] peArray=ptable.find(eState);
            //만약 반환된 배열의 길이가 0이면 잘못된 상태를 입력했을 때 이므로 이를 사용자에게 알리고
            //continue를 통해 반복문을 빠져나가지 않으면서 반복문의 다음 내용들을 생략하고 다음 반복을 진행한다.
            if(peArray.length==0){
                System.out.println("잘못된 입력이 존재합니다.");
                continue;
            }
            //PeriodicTable의 생성자에 PeriodicElement배열을 전달해주고 새로운 PeriodicTable인스턴스를 생성하며 이를
            //PeriodicTable형 참조변수 pt로 참조한다.
            PeriodicTable pt =new PeriodicTable(peArray);
            //PeriodicTable인스턴스를 참조하는 pt참조변수를 통해 PeriodicTable클래스에 정의되어 있는 print()호출
            pt.print();
            //만약 UserInput.gtExitKey()의 반혼값이 true이면 반복문 종료
            if(UserInput.getExitKey()){
                break;
            }
        }
        System.out.println();

        //프로그램을 종료함을 알린다.
        System.out.println("Program Termination");
    }
}