public enum Element {
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
    NATRIUM(11),
    MAGNESIUM(12),
    ALUMINIUM(13),
    SILICON(14),
    PHOSPHORUS(15),
    SULFUR(16),
    CHLORINE(17),
    ARGON(18),
    KALIUM(19),
    CALCIUM(20),
    SCANDIUM(21),
    TITANIUM(22),
    VANADIUM(23),
    CHROMIUM(24),
    MANGANESE(25),
    IRON(26),
    COBALT(27),
    NICKEL(28),
    COPPER(29),
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

    private final int value;
    Element(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }


    public static Element valueOf(int value){
        for(Element element:Element.values()){
            if (element.getValue() == value) {
                return element;
            }
        }
        return null;
        /*
        현재 이프로그램에서는 Element valueOf(int) 이 메소드를 이용하는 곳이 없지만 만약 이를 사용하는 곳이 존재한다면 null을 반환할 수 있으므로
        이 메소드가 반환하는 인스턴스(Element혹은null)을 사용할 시 NullPointerException이 발생할 수 있음을 인지해두어야한다.
         */
        /*
        과제 관련 영상에서는 switch문을 통해서 일일이 상수를 기입하는 하드코딩을 하였는데 이와 같이 for-each(enhanced for)문을 통해
        같은 구현이지만 개발자입장에서 편리하게 코딩할 수 있다고 생각되어 위와 같은 형태로 구현하였다.
        for-each문에서 Element.values()를 통해 열거형의 모든 상수값들을 한 번 반복할 수 있고(열거형의 모든 상수에 한 번 씩 접근)
        swtich문의 case문의 1,2,3과 같은 값들은 모두 Element의 value값이고 이는 getValue()메소드를 통해 구할 수 있고 이를 인자로 전달받은
        value와 비교하여 같으면 반환 혹은 모두 일치하지 않으면 null을 반환하면 된다.(switch문에서 default와 같은 역할)
        이는 곧 switch구문과 동일하다.
         */
    }
    public static Element nameOf(String name){
        for(Element element:Element.values()){
            try {
                if ((String.valueOf(element.getValue()).equals(name))||(element==Element.valueOf(name))) {
                    return element;
                }
            }catch(IllegalArgumentException e){
            }
        }
        return null;
        /*
        null을 반환할 수 있으므로 이 메소드가 반환하는 인스턴스(Element혹은null)을 사용할 시 NullPointerException이 발생할 수 있음을 인지해두어야한다.
         */
    }
    public static String[] names(){
        String[] names=new String[Element.values().length];
        for(Element element: Element.values()){
            //Enum의 toString()은 name값을 반환하도록 오버라이딩 되어있다.
            //name은 Enum클래스에서 private final String name;으로 정의되어있다.
            //즉, HYDROGEN과 같이 열거형 상수의 이름을 반환한다.
            names[element.ordinal()]=element.toString();
        }
        return names;
    }
}