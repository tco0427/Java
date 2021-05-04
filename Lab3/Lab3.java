
//main메소드를 가지고 있는 Lab3클래스
//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
public class Lab3 {
    /*
    PeriodicElement인스턴스 참조할 수 있는 PeriodicElement배열에(인스턴스에 대한 레퍼런스를 갖는 배열)
    각각의 인스턴스들을 생성하여 이를 원소로 갖는 elements라는 이름으로 선언과동시에 초기화하였다.
    //이는 PeriodicElement 인스턴스를 저장(참조)할 수 있는 참조변수의 배열로 볼 수 있다.
    //즉, 배열의 생성은 인스턴스의 생성과 무관하다. 하지만 현재 이 코드와 관련된 경우 배열을 생성하면서
    //동시에 각 인스턴스들을 생성하여 이를 원소로하고 있다. 즉 배열의 선언과 동시에 초기화를 한 것이다.
    private로 선언하였으므로 클래스 내부에서만 접근이 가능하며
    static으로 선언되었으므로 클래스 로딩시에 정적으로(static) 메모리 공간을 할당받으며
    인스턴스생성과는 무관하게 접근이 가능하다.(클래스 내부에서만private)
     */
    private static PeriodicElement[] elements={
            new PeriodicElement(1,"H","Hydrogen",1.01),
            new PeriodicElement(2,"He","Helium",4.0026),
            new PeriodicElement(3,"Li","Lithium",6.94),
            new PeriodicElement(4,"Be","Beryllium",9.0122),
            new PeriodicElement(5,"B","Boron",10.81),
            new PeriodicElement(6,"C","Carbon",12.011),
            new PeriodicElement(7,"N","Nitrogen",14.007),
            new PeriodicElement(8,"O","Oxygen",15.999),
            new PeriodicElement(9,"F","Fluorine",18.998),
            new PeriodicElement(10,"Ne","Neon",20.180),
            new PeriodicElement(11,"Na","Sodium",22.990),
            new PeriodicElement(12,"Mg","Magnesium",24.305),
            new PeriodicElement(13,"Al","Aluminium",26.982),
            new PeriodicElement(14,"Si","Silicon",28.085),
            new PeriodicElement(15,"P","Phosphorus",30.974),
            new PeriodicElement(16,"S","Sulfur",32.06),
            new PeriodicElement(17,"Cl","Chlorine",35.45),
            new PeriodicElement(18,"Ar","Argon",39.948),
            new PeriodicElement(19,"K","Kalium",39.098),
            new PeriodicElement(20,"Ca","Calcium",40.078),
            new PeriodicElement(21,"Sc","Scandium",44.956),
            new PeriodicElement(22,"Ti","Titanium",47.867),
            new PeriodicElement(23,"V","Vanadium",50.942),
            new PeriodicElement(24,"Cr","Chrominum",51.996),
            new PeriodicElement(25,"Mn","Manganese",54.938),
            new PeriodicElement(26,"Fe","Iron",55.845),
            new PeriodicElement(27,"Co","Cobalt",58.933),
            new PeriodicElement(28,"Ni","Nickel",58.693),
            new PeriodicElement(29,"Cu","Copper",63.546),
            new PeriodicElement(30,"Zn","Zinc",65.38),
            new PeriodicElement(31,"Ga","Gallium",69.723),
            new PeriodicElement(32,"Ge","Germanium",72.630),
            new PeriodicElement(33,"As","Arsenic",74.922),
            new PeriodicElement(34,"Se","Selenium",78.971),
            new PeriodicElement(35,"Br","Bromine",79.904),
            new PeriodicElement(36,"Kr","Krypton",83.798),
            new PeriodicElement(37,"Rb","Rubidium",85.468),
            new PeriodicElement(38,"Sr","Strontium",87.62),
            new PeriodicElement(39,"Y","Yttrium",88.906),
            new PeriodicElement(40,"Zr","Zirconium",91.224),
            new PeriodicElement(41,"Nb","Niobium",92.906),
            new PeriodicElement(42,"Mo","Molybdenum",95.95),
            new PeriodicElement(43,"Tc","Technetium",98),
            new PeriodicElement(44,"Ru","Ruthenium",101.07),
            new PeriodicElement(45,"Rh","Rhodium",102.91),
            new PeriodicElement(46,"Pd","Palladium",106.42),
            new PeriodicElement(47,"Ag","Silver",107.87),
            new PeriodicElement(48,"Cd","Cadmium",112.41),
            new PeriodicElement(49,"In","Indium",114.82),
            new PeriodicElement(50,"Sn","Tin",118.71)
    };

    /*
    private static으로 선언되었으므로 인스턴스생성과 무관하게 클래스 로딩시에 생성된다고 볼 수 있다.
    또한 private로 선언되었으므로 클래스 내부에서만 접근이 가능하다.
     */
    private static PeriodicElement getPeriodicElement(PeriodicElement[] array,Element e){
        /*
        매개변수로 전달받은 array배열의 모든 원소를 for-each문을 통해 접근한다.
        즉 for(요소: 배열(반복의 대상))꼴이 되는 것이다. 변수 pe에는 배열의 각각의 요소의 값이 담기게 된다.
        따라서 배열의 원소중들의 getNumber()와 매개변수로 전달받은 Element e의getValue()의 값이 같으면
        //배열의 요소인 pe(if문을 참으로 만든 배열의 원소)를 반환하고 만약 for-each문을 도는 동안 if문을 만족시키지 못했으면
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
    /*
    프로그램의 시작지점(Starting Point) main메소드이다.
    자바 프로그램은 main()메소드를 가지는 클래스가 반드시 하나는 존재해야하며
    public static void로 선언되어있으므로 반환형이 없고(void),
    인스턴스 생성이전에 정적으로(static)메소드 호출이 가능하며
    다른 패키지에서도 접근이 가능하다(public)(main메소드의 호출이 이뤄지는 영역은 클래스 외부이다.
     */
    public static void main(String[] args) {
        System.out.println("Print PeriodicElementInformation");
        for(PeriodicElement pe: elements){
            System.out.println(pe);
        }
        System.out.println();


        System.out.println("Print element name");
        for(String s:Element.names()){
            System.out.println(s);
        }
        System.out.println();


        System.out.println("Print element name, PeriodicElementInformation, State");
        String[] names=Element.names();
        for(String s: names){
            Element element=Element.nameOf(s);
            System.out.println(element.name());
            PeriodicElement pElement=getPeriodicElement(elements,element);
            System.out.println(pElement);
            System.out.println(PeriodicElement.getState(pElement));
        }

        do{
            System.out.println("Please enter 'number symbol name weight' of PeriodicElement");
            System.out.print(">>");
            PeriodicElement element=PeriodicElement.parsePeriodicElement(UserInput.getString());
            if(element!=null)
                System.out.println(element);
        }while(!UserInput.getExitKey());


        do{
            System.out.println("Please enter [#] or [name] of PeriodicElement");
            System.out.print(">>");

            /*
            getElement메소드에서 Element의 nameOf를 이용한다.(Element.nameOf(UserInput.getString().toUpperCase())
            따라서 getElement를 사용하는 곳에서는 혹시나 모를 NullPointerException발생을 염두해두는 것이 좋은 프로그램이며
            이를 위해 try-catch구문을 통해 예외를 처리하도록 하였다. 또한 NullPointerException이 발생했다는 것은 잘못된 입력이
            존재할 수 있다는 것이므로 이를 사용자에게 알리는 문장을 catch문에서 구현하였다.
            //getPeriodicElement에서도 null을 반환하는 경우가 존재하므로 이를 통한 NullPointerException예외 발생도 함께 처리할 수 있다.
             */
            //try영역의 실행 중간에 예외 상황이 만들어지고 이로 인해 가상머신이 NullPointerException인스턴스를 생성하면 이 인스턴스는 메소드를
            //호출하듯이 catch구문의 매개변수 e에 전달된다. catch구문으로 실행흐름이 이어지면 가상머신은 예외가 처리된것으로 간주하고 실행흐름을 이
            //어나간다.
            try {
                Element e = UserInput.getElement();
                PeriodicElement element = getPeriodicElement(elements, e);
                System.out.println(element + " ");
                State state = PeriodicElement.getState(element);
                System.out.println(state);
            }catch(NullPointerException e){
                System.out.println("잘못된 입력이 존재합니다.");
            }
        }while(!UserInput.getExitKey());

        //프로그램을 종료함을 알린다.
        System.out.println("Program Termination");
    }
}
