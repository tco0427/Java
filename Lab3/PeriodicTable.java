/*
Lab6
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/18
 */

//import문을 통하여 java.util패키지의 Arrays,ArrayList클래스와 List인터페이스를 import한다.
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려준다.
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려줌을 통해
//이를 통해클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
//(서로 다른 패키지의 동일한 이름의 클래스를 대상으로 동시에 import하는 것은 불가능하며, 디폴트패키지를 import할수도 없다.(컴파일 에러) 왜냐하면 default package는 어나니머스, 즉 이름이 없는 패키지이기 때문이다.)
//toString()에서 Arrays.toString()을 통해 배열의 내용을 한 줄의 문자열로 반환한다.
//ArrayList(컬렉션 인스턴스)를 통해 find(State state)에서 해당되는 state에 해당되는 PeriodicElement인스턴스를
//길이를 신경쓰지 않고 추가하고 이를 배열로 변환하는데 사용
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

//PeriodicElement는 화학원소 데이터 하나하나를 담고 있는 클래스라고 한다면
//PeriodicTable은 PeriodicElement를 배열(array)형태로 여러개의 화학원소 정보를 가지고 있으면서 이를 관리하는 클래스
//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
public class PeriodicTable {
    //PeriodicElement배열을 참조하는 참조변수 elements
    /*
    객체 지향 특성을 살리기 위해서는 캡슐화 원칙을 지키는 것이 좋고 이를 위해 가능하면 필드에 대해서
    private선언을 하고 접근자와 설정자를 통해 접근할 수 있도록 하는 것이 좋다.
     */
    private PeriodicElement[] elements;

    //생성자
    //생성자를 통해 배열을 전달받고 이를 elements가 참조할 경우
    //elements는 배열인스턴스(elements[0]...elements[n])을 참조하고
    //각각의 elements[0]...elements[n]들이 실제 인스턴스를 참조하고 있는 것으로 볼 수 있다.(PeriodicElement참조변수로 참조가능한 인스턴스, PeriodicElement를 상속을 통해 구현한 클래스의 인스턴스)
    //객체에 대한 배열은 "객체에 대한 참조(래퍼런스)를 원소로 갖는 배열"로 볼 수 있다.
    public PeriodicTable(PeriodicElement[] elements) {
        this.elements = elements;
    }


    //인스턴스변수(필드)에 대한 접근자와 설정자들이다.
    //접근자(getter)
    public PeriodicElement[] getElements() {
        return elements;
    }
    //설정자(setter)
    public void setElements(PeriodicElement[] elements) {
        this.elements = elements;
    }


    //배열 자체에서 toString()을 사용하면 배열의 내용이 아닌 배열의 주소값(참조값)이 반환된다.(ex. arr.toString())
    //따라서 배열의 내용(배열이 참조하는 인스턴스의 toString()을 통한 내용)을 반환하고 싶을 때는 Arrays클래스의 static으로 정의되어 있는 toString()의 인자로 배열을 참조하는 참조변수를 전달한다.
    //(ex. Arrays.toString(arr))
    //Arrays클래스에 static String toString(Object[] a) 형태로 정의되어 있다.
    //즉 아래와 같은 경우 elements(PeriodicElement[])배열의 각 원소들(elements[0]...elmeent[n])이 PeriodicElement를 구현한 인스턴스를 참조하므로
    //Arrays.toString(elements)를 통해 PeriodicElement를 구현한 각각의 클래스에서 오버라이딩하여 정의되어 있는 toString()메소드를 호출한다.(배열의 원소 모두에 대해서)
    //만약 PeridoicElement를 구현한 클래스에서 toString()을 오버라이딩하지 않았다면 PeriodicElement의 toString()이 호출된다.
    @Override
    public String toString() {
        return "PeriodicTable{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

    //전달받은 인덱스에 해당하는 PeriodicElement를 반환하는 메소드
    public PeriodicElement get(int index){
        //try-catch문을 통해 배열 접근에 잘못된 인덱스 사용을 잡아낸다.(ArrayIndexOutOfBoundsException)
        //이에 대한 내용을 사용자에게 알리며 null을 반환한다.
        try {
            return elements[index];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("잘못된 인덱스 접근!!");
            System.out.println("입력을 다시 한 번 확인해주세요.");
            return null;
        }
    }
    //전달받은 인덱스 이전에 해당하는 PeriodicElement를 반환하는 메소드
    public PeriodicElement getPrevious(int index){
        try{
            return elements[index-1];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("잘못된 인덱스 접근!!");
            System.out.println("입력을 다시 한 번 확인해주세요.");
            return null;
        }
    }
    //전달받은 인덱스 이후에 해당하는 PeriodicElement를 반환하는 메소드
    public PeriodicElement getNext(int index){
        try {
            return elements[index + 1];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("잘못된 인덱스 접근!!");
            System.out.println("입력을 다시 한 번 확인해주세요.");
            return null;
        }
    }

    //PeridicElement fine(Element element), PeriodicElement find(int number), PeriodicElement find(String symbol)이 세개의
    //메소드들은 서로 매개변수의 타입에 차이가 있고 메소드의 이름과 반환형이 동일하므로 오버로딩 관계라고 할 수 있다.


    //String symbol을 매개변수로 받는 find()메소드가 정의되어 있으므로 이 메소드를 오버로딩하려고할 때
    //매개변수로 String은 불가능하다(매개변수 형식이 달라야하기 때문에) 따라서 Element를 받는 find()메소드를 통해 오버로딩하였고
    //Element를 통해서 "HYDROGEN"과 같이 이름을 통해 PeriodicElement를 찾고 해당하는 원소를 반환하도록 하겠다.
    public PeriodicElement find(Element element){
        for(PeriodicElement pe: elements){
            //우리가 정의한 열거형Element의 이름은 모두 대문자이기 때문에 String클래스에 정의되어 있는 toUpperCase()메소드를 통해 문자열의 모든 문자를 대문자로 바꿔준다.
            //element.name()이 반환하는 문자열과
            //pe.getname()을 통해 반환된 문자열을 toUpperCase() 문자열의 모든 문자를 대문자로 한 문자열을
            //Object에 정의된 equals()메소드를 오버라이딩한 String클래스의 equals()를 통해 문자열 내용을 비교하고 참일 경우 pe가 참조하는 인스턴스 반환
            if(pe.getName().toUpperCase().equals(element.name())){
                //or element.toString()을 하여도 상관없다.
                //하지만 toString()은 System.out.println()에 인자로 전될되었을 시에 호출로 연결된다는 의미가 강하기 때문에(또 그러한 의도로 정의하고 사용하기 때문에)
                //name()을 통해 element가 참조하는 열거형의 name필드를 반환하는 것이 바람직해 보인다.
                //java.lang.Enum 클래스에는
                /*

                /**
                 * Returns the name of this enum constant, exactly as declared in its
                 * enum declaration.
                 *
                 * <b>Most programmers should use the {@link #toString} method in
                 * preference to this one, as the toString method may return
                 * a more user-friendly name.</b>  This method is designed primarily for
                 * use in specialized situations where correctness depends on getting the
                 * exact name, which will not vary from release to release.
                 *
                 * @return the name of this enum constant
                public final String name() {
                    return name;
                }
                /**
                * Returns the name of this enum constant, as contained in the
                * declaration.  This method may be overridden, though it typically
                * isn't necessary or desirable.  An enum type should override this
                * method when a more "programmer-friendly" string form exists.
                *
                * @return the name of this enum constant
                public String toString(){
                    return name;
                }
                다음과 같이 정의되어 있으므로
                동일한 인스턴스 변수(열거형 상수의 이름에 해당하는)name을 반환한다.
                 */

                //if문을 참으로 만드는 pe가 존재하면 pe가 참조하는 인스턴스를 반환하며 메소드 종료
                //return은 메소드를 호출한 영역으로 값을 반환한다는 의미와 함께 메소드의 종료를 의미한다.
                return pe;
            }
        }
        //for-each를 통해 반복을 하는동안 해당하는 내용이 없을 시 null반환
        return null;
    }

    //매개변수로 전달받은 정수(int)는 원소번호를 뜻하고 이에 해당하는 PeriodicElement를 구현한 인스턴스를 elements(PeriodicElement[])에서 찾아 반환한다.
    public PeriodicElement find(int number){
        //for-each를 통해 elements가 참조하는 PeriodicElement[]배열인스턴스에서 각 배열원소(객체에 대한 래퍼런스)가 참조하는 인스턴스를
        //pe가 반복을 진행하면서 하나씩 참조하면서 if문을 진행
        for(PeriodicElement pe:elements){
            if(pe.getNumber()==number){
                //if문을 참으로 만드는 pe가 존재하면 pe가 참조하는 인스턴스를 반환하며 메소드 종료
                //return은 메소드를 호출한 영역으로 값을 반환한다는 의미와 함께 메소드의 종료를 의미한다.
                return pe;
            }
        }
        //for-each를 통해 반복을 하는동안 해당하는 내용이 없을 시 null반환
        return null;
    }

    //원소 기호를 String형으로 전달받은 뒤 해당하는 PeriodicElement를 반환하는 메소드
    //위의 오버로딩된 find메소드와 마찬가지로 for-each를 통해 배열을 돌며 해당하는 인스턴스를 반환하고
    //배열을 전체 반복하는 동안 해당되는 내용이 없으면 null반
    public PeriodicElement find(String symbol){
        for(PeriodicElement pe:elements){
            if(pe.getSymbol().equals(symbol)){
                return pe;
            }
        }
        //for-each를 통해 반복을 하는동안 해당하는 내용이 없을 시 null반환
        return null;
    }

    //위의 3개의 find()메소드와 오버로딩관계가 아니다. 왜냐하면 리턴타입,즉 반환형에서 차이가 있기 때문이다.
    //만약 매개변수가 동일하고 반환형만 다르다면 이는 컴파일에러를 일으킬것이다.(메소드 호출시에 '메소드의 이름과 매개변수 정보(수와 타입)'을 참조하여 메소드를 호출하기 때문에)
    //인자로 전달된 state에 해당하는 인스턴스를 모두 반환(예를 들어 인자로 전달된 state가 GAS인 경우 elements에서 GasPeriodicElement에 해당하는 인스턴스들을 배열형태로 모두 반환)
    public PeriodicElement[] find(State state){
        //PeriodicElement 인스턴스를 저장하는 ArrayList<PeriodicElement>컬렉션 인스턴스를 생성하고 이를 list라는 이름으로 참조한다.
        //다이아몬드 기호를 통한 타입 인자 생략(컴파일러가 참조변수 선언을 통해서 유추가 가능하다. 비공식적인 표현이긴 하지만 공식적인 표현으로 인식될만큼 널리 사용되는 방법)
        List<PeriodicElement> list=new ArrayList<>();
        //for-each문을 통해 elements가 참조하는 배열인스턴스에 대해서 전체 반복
        for(PeriodicElement pe:elements){
            //만약 pe가 참조하는 인스턴스의 getState()를 호출하여 반환되는 State필드의 값이 state와 일치하면
            if(pe.getState()==state) {
                //컬렉션 인스턴스를 참조하는 list에 해당 인스턴스(PeriodicElement) 저장
                //실제로 add의 인자로 전달된 인스턴스는 실제 저장되는 것이 아닌 인스턴스의 참조값이 저장된다.
                list.add(pe);
            }
        }

        //이렇게 배열 저체에 대해서 조건을 만족하는 PeriodicElement인스턴스를 모두 참조(저장)하고 있는 컬렉션인스턴스 list를 배열의 형태로 만들어 주기 위해 다음과 같은 작업을 실행한다.
        //PeriodicElement[] peArray=(PeriodicElement[])list.toArray();와 같은 방법을  생각할 수도 있지만 list.toArray()의 반환형은 Object[]형이고
        //이를 (PeriodicElement[])를 통해 다운캐스팅하는 것은 불가능하진 않지만(컴파일에러가 잡히진 않겠지만) 실행중 예외가 발생한다.(java.lang.ClassCastException)
        //다운 캐스팅은 프로그래머가 이를(list.toArray()가 반환하는 인스턴스가 PeridoicElement[]형이다!)보장한다는 의미로 컴파일러가 허용한다.
        //하지만 실제로 list.toArray()가 반환하는 것은 Object[]형이므로 이와 같은 형변환은 불가능하다.
        //하위클래스 형식의 참조변수로 상위클래스의 인스턴스를 참조하는 방식은 옳지 않다.(하지만 반대로 상위클래스 형식의 참조변수로 하위클래스의 인스턴스를 참조하는 것은 가능하다.)

        //따라서 다음과 같이 컬렉션 인스턴스의 크기만큼의 배열을 먼저 생성한 이후에
        PeriodicElement[] peArray=new PeriodicElement[list.size()];
        //이 배열에 대한 래퍼런스를 가지는 래퍼런스 변수를 toArray의 인자로 전달하여준다.
        //System.arraycopy에 의해 컬렉션인스턴스인 ArrayList의 내용이 peArray배열로 복사된다.
        /*
        public <T> T[] toArray(T[] a) {
            if (a.length < size)
                // Make a new array of a's runtime type, but my contents:
                return (T[]) Arrays.copyOf(elementData, size, a.getClass());
            System.arraycopy(elementData, 0, a, 0, size);
            if (a.length > size)
                a[size] = null;
            return a;
        }
         */
        list.toArray(peArray);
        //이렇게 변환된 PeriodicElement형 배열을 반환한다.
        return peArray;
    }

    //PeriodicTable클래스의 필드 elements(private static)가 참조하는 배열인스턴스에 해당하는 원소들을 전부 테이블형태로 출력하는 메소드
    public void print(){
        for(PeriodicElement pe: elements){
            System.out.println("----------------------------------------------------------------------------------------");
            //각각의 pe인스턴스들의 print()메소드를 호출한다. PeridoicElement pe가 참조하는 elements의 각각의 원소들은 PeriodicElement를 구현하는 구상클래스들일 것이다.
            //왜냐하면 PeriodicElement는 추상클래스로 인스턴스화 할 수 없기 때문이다.
            //따라서 각 PeriodicElement를 상속을 통해 구현하는 클래스들에서 오버라이딩한 print()메소드를 호출할 것이다.(다형성)
            pe.print();
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

    //인자로 인덱스와 PeriodicElement가 참조할 수 있는 인스턴스를 전달받고 이에 해당하는 PeriodicTable클래스의 elements인스턴스 변수가 참조하는 배열의 내용을 변경한다.
    public void set(int index,PeriodicElement pe){
        //만약 사용자가 잘못된 인덱스 번호를 전달할 시 ArrayIndexOutOfBoundsException이 발생하고 이에 대한 처리를 해주었다.
        try {
            elements[index] = pe;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("잘못된 인덱스 접근으로 인해 화학원소의 변경은 이루어지지 않습니다.");
        }
    }
    //인자로 전달된 PeriodicElementFinder참조변수로 참조가능한 인스턴스에 대해서 find메소드를 호출한다.
    //(PeriodicElementFinder는 추상클래스이므로 이를 대상으로 인스턴스생성은 불가능할 것이다. 따라서 이를 구현한 구상클래스의 인스턴스가 전달될 것이고 당연히 PeriodicElementFinder로 참조가능하다.)
    //이 때 find()메소드의 인자로 인스턴스변수 elements가 참조하는 인스턴스가 전달될 것이고, find가 반환하는 PeriodicElement[]객체를 반환한다.
    //(매개변수로 전달되는 인스턴스에 따라서 finder.find()의 내부적인 구현에서 사용되는 isInstanceOf()의 동작에 차이가 있고, 다형성을 실현하였다고 볼 수 있다.)
    //(실제로 find를 호출하는 객체에 따라서 isInstanceOf()가 달라지는 것인데 이를 내부적으로 사용하고 있는 find()가 달라지는 것처럼 보일 수 있다.)
    public PeriodicElement[] find(PeriodicElementFinder finder){
        return finder.find(elements);
    }
    //find(State), find(PeriodicElementFinder), find(IPeriodicElementFinder)이 세개의 메소드는 매개변수정보(매개변수 개수, 타입, 선언 순서 등)에 대해서만
    //차이가 있고, 메소드 이름과 반환형이 동일한 오버로딩 관계이다.
    //메소드 호출 시 IPeriodicElementFinder를 구현한 concrete class를 인자로 받고 이를 ifinder라는 매개변수로 참조하게된다.
    //(IPeriodicElementFinder인터페이스를 통한 인스턴스 생성은 불가능하므로 당연히 이를 구현한 구상클래스의 인스턴스가 전달될 것이다.)
    //매개변수가 IPeriodicElementFinder로 선언되어 있으므 이를 구현하는 클래스의 인스턴스는 모두 전달될 수 있다(추상화타입을 통해 다형성 실현)
    public PeriodicElement[] find(IPeriodicElementFinder ifinder){
        //PeriodicElement 인스턴스를 저장하는 ArrayList<PeriodicElement>컬렉션 인스턴스를 생성하고 이를 list라는 이름으로 참조한다.
        //다이아몬드 기호를 통한 타입 인자 생략(컴파일러가 참조변수 선언을 통해서 유추가 가능하다. 비공식적인 표현이긴 하지만 공식적인 표현으로 인식될만큼 널리 사용되는 방법)
        List<PeriodicElement> list=new ArrayList<>();
        //for-each문을 통해 인스턴스변수 elements가 참조하는 배열인스턴스에 대해서 전체 반복
        for(PeriodicElement e: elements){
            //매개변수를 통해 전달받은 IPeriodicElementFinder의 구상객체에 대해서 isInstaceOf를 호출하고 인자로 e(반복을 하면서 순차적으로 접근하게 되는 배열의 원소)가 전달된다.
            if(ifinder.isInstanceOf(e)){
                //만약 ifinder.isInstanceOf()가 반환하는 값이 참이면
                //add메소드의 인자를 통해 저장할 인스턴스를 전달한다.(e가 참조하는 인스턴스 전달)
                //실제로 add의 인자로 전달된 인스턴스는 실제 저장되는 것이 아닌 인스턴스의 참조값이 저장된다.
                list.add(e);
            }
        }
        //반복을 끝낸 이후 컬렉션 인스턴스를 배열형태로 변환해주기 위해 다음과 같은 작업을 수행한다.
        //우선 ArrayList의 크기만큼의 배열을 생성한다.
        PeriodicElement[] peArray=new PeriodicElement[list.size()];
        //그리고 toArray메소드의 인자로 배열인스턴스에 대한 참조변수를 전달한다.
        //peArray가 참조하는 배열인스턴스의 길이와 컬렉션인스턴스의 길이가 같으므로
        //System클래스의 arrayCopy()를 통해 컬렉션의 내용이 peArray가 참조하는 배열인스턴스로 복사된다.
        list.toArray(peArray);

        //이렇게 변환된 PeriodicElement형 배열을 반환한다.
        return peArray;
    }
}
