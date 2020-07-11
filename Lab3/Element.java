/*
Lab6
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/18
 */

//Element라는 이름의 열거형을 public(접근지정자)하게 선언하였다.
//따라서 외부에서도(동일패키지가아닌)접근이 가능해진다.
/*
열거형은 서로 관련된 상수를 편리하게 선언하기 위한 것으로 여러 상수를 정의해야할 때 사용하면 편리하다.
 */
public enum Element {
    //열거형 값 하나하나가 모두 Element객체라고 볼 수 있다.
    //따라서 이는 static final Element HYDROGEN=new Element(1); 과 같은것이다.
    //그러므로 생성자에 해당하는 값 value를 전달해주어야하며 HYDROGEN(1)과 같이 선언한 이유가 그것이다.

    HYDROGEN(1),
    HELIUM(2),
    LITHIUM(3),
    BERYLLIUM(4),
    BORON(5),
    CARBON(6),
    NITROGEN(7),
    OXYGEN(8),
    FLUORINE(9),
    NEON(10),
    SODIUM(11),
    MAGNESIUM(12),
    ALUMINIUM(13),
    SILICON(14),
    PHOSPHORUS(15),
    SULFUR(16),
    CHLORINE(17),
    ARGON(18),
    POTASSIUM(19),
    CALCIUM(20),
    SCANDIUM(21),
    TITANIUM(22),
    VANADIUM(23),
    CHROMIUM(24),
    MANGANESE(25),
    FERRUM(26),
    COBALT(27),
    NICKEL(28),
    CUPRUM(29),
    ZINC(30),
    GALLIUM(31),
    GERMANIUM(32),
    ARSENIC(33),
    SELENIUM(34),
    BROMINE(35),
    KRYPTON(36),
    RUBIDIUM(37),
    STRONTIUM(38),
    YTTRIUM(39),
    ZIRCONIUM(40),
    NIOBIUM(41),
    MOLYBDENUM(42),
    TECHNETIUM(43),
    RUTHENIUM(44),
    RHODIUM(45),
    PALLADIUM(46),
    SILVER(47),
    CADMIUM(48),
    INDIUM(49),
    TIN(50);

    /*
    //보통 enum Excample(a,b,c)와 같이 생성자를 통해 열거형 상수의 값을 지정하지 않고 선언하기도 한다.
    //하지만 Enum클래스에 정의된 ordinal()이 열거형 상수가 정의된 단순히 순서만을 나타내지 이 값을 실제 열거형 상수의 값으로 사용하지 않는 것이 좋다.
    //단순히 내부적인 용도로만 사용되기 때문이다.
    //따라서 다음과 같이 인스턴스 변수와 생성자를 추가로 작성하여 열거형상수의 값을 지정해주도록 하였다.
     */

    //열거형의 인스턴스 변수는 반드시 final이어야 한다는 제약은 없지만 value는 열거형 상수의 값을 저장하기 위한 용도이므로 fianl을 붙였다.
    private final int value;

    //열거형의 생성자는 제어자가 묵시적으로 private이기 때문에 생략하였다.
    //private Element(int value){...}와 동일
    Element(int value){
        this.value=value;
    }

    //private로 선언된 열거형의 인스턴스변수를 외부에서 접근하기 위해 public으로 선언된 getValue()를 정의하였다.
    public int getValue(){
        return value;
    }


    //Element열거형에 static으로 vlaueOf메소드를 정의하였다.
    //따라서 Element.valueOf와 같이 열거형이름을 통해서 접근이 가능하다. 물론 Element.HYDRROGEN.valueOf()와같이 접근할 수도 있지만
    //권장하지는 않는다.
    /*
        과제 관련 영상에서는 switch문을 통해서 일일이 상수를 기입하는 하드코딩을 하였는데 이와 같이 for-each(enhanced for)문을 통해
        같은 구현이지만 개발자입장에서 편리하게 코딩할 수 있다고 생각되어 위와 같은 형태로 구현하였다.
        for-each문에서 Element.values()를 통해 열거형배열의 모든 상수값들을 한 번 반복할 수 있고(열거형의 모든 상수에 한 번 씩 접근)
        swtich문의 case문의 1,2,3과 같은 값들은 모두 Element의 value값이고 이는 getValue()메소드를 통해 구할 수 있고 이를 인자로 전달받은
        value와 비교하여 같으면 반환 혹은 모두 일치하지 않으면 null을 반환하면 된다.(switch문에서 default와 같은 역할)
        이는 곧 switch구문과 동일하다.
    */

    //Enum에 정의되어 있는 valueOf(String s)메소드를 오버로딩하였다.
    public static Element valueOf(int value){
        //for-each문에서 Element.values()를 통해 Element배열의 모든 원소에 접근한다.
        for(Element element:Element.values()){
            //매개변수를 통해 전달받은 값과 getValue()를 통해 반환한 인스턴스변수value값(각 상수의 저장하고 있는 상수값)이 같으면 그 element를 반환한다.
            if (element.getValue() == value) {
                return element;
            }
        }
        return null;
        /*
        현재 이프로그램에서는 Element valueOf(int) 이 메소드를 이용하는 곳이 없지만 만약 이를 사용하는 곳이 존재한다면 null을 반환할 수 있으므로
        이 메소드가 반환하는 인스턴스(Element혹은null)을 사용할 시 NullPointerException이 발생할 수 있음을 인지해두어야한다.
         */
    }

    //Element열거형에 static으로 정의된 nameOf메소드이다.
    //사용자가 value값과 같은 1,2,3,4,5를 입력할 수도 있고, 직접 이름을 입력받을 수 있도록 하고 이에 해당하는 열거형 인스턴스(열거형 상수 하나하나를 Element객체로 볼 수 있으므로)가 존재하면 이를 반환하고 아니면 null을 반환하도록 한다.
    public static Element nameOf(String name){
        for(Element element:Element.values()){
            try {
                //상수값일치||이름일치
                if ((String.valueOf(element.getValue()).equals(name))||(element==Element.valueOf(name))) {
                    return element;
                }
                //IllegalArgumentException이 발생할 수 있는 이유는 우리가 예를들어 숫자를 입력했다고 가정하자.
                //||연산자를 기준으로 오른쪽 피연산자의 Element.valueOf(name)에서 No enum constant상황이 생기고 IllegarArgumentException이 발생하게 된다.
                //Enum의 valueOf메소드는 다음과 같이 정의되어 있다. 제네릭과 같은 문법적인 내용을 제외하고
                //메소드의 기능을 위주로 간단히 요약하면 인자로 받은 name과 일치하는 열거형상수이름이 없을 경우 IllegalArgumentException 예외 인스턴스를 생성하여 호출한 영역으로 넘긴다.
                /*
                public static <T extends Enum<T>> T valueOf(Class<T> enumType,
                                                String name) {
                T result = enumType.enumConstantDirectory().get(name);
                if (result != null)
                    return result;
                if (name == null)
                    throw new NullPointerException("Name is null");
                throw new IllegalArgumentException(
                    "No enum constant " + enumType.getCanonicalName() + "." + name);
                }
                 */
                //이를 catch구문을 통해 컴파일러에게 정상적인 실행흐름을 유지하도록 try-catch구문을 구현한다.
            }catch(IllegalArgumentException e){}
        }
        return null;
        /*
        null을 반환할 수 있으므로 이 메소드가 반환하는 인스턴스(Element혹은null)을 사용할 시 NullPointerException이 발생할 수 있음을 인지해두어야한다.
         */
    }

    //String배열을 반환하는 names메소드를 public하게(다른 패키지,외부에서 접근가능) 또 static으로 클래스 로딩시에 정적으로 바인딩되게 선언하였다.
    public static String[] names(){
        //Element.values()를 통해 Element[]을..그리고 length를 통해 Eelement[]의 길이를 새로운 String배열의 길이로 하여 생성한다.
        String[] names=new String[Element.values().length];
        //for-each문에서 Element.values()를 통해 Element배열의 모든 원소에 접근한다.
        for(Element element: Element.values()){
            //Enum의 name()은 name값을 반환하도록 오버라이딩 되어있다.
            //name은 Enum클래스에서 private final String name;으로 정의되어있다.
            //즉, HYDROGEN과 같이 열거형 상수의 이름을 반환한다.
            //element.ordinal()은 해당 열거형 상수의 순서를 반환한다.(0부터 시작) 따라서 names배열의 인덱스로 사용하기에 적절하다.
            names[element.ordinal()]=element.name();
        }

        //String형 인스턴스를 참조하고 있는 참조변수의 배열격이 되는 names(String배열)을 반환한다.
        return names;
    }
}