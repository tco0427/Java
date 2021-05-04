/*
Lab8
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/06/07
 */

//다음의 클래스(PeriodicTable)가 소속될 패키지 명을 다음과 같이 package키워드를 이용하여 소스파일의 첫 줄에 선언해주었다.
package dao;

//import문을 통하여 java.util패키지의 Arrays,ArrayList클래스와 List인터페이스를 import한다.
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려준다.
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려줌을 통해
//클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
//(서로 다른 패키지의 동일한 이름의 클래스를 대상으로 동시에 import하는 것은 불가능하며, 디폴트패키지를 import할수도 없다.(컴파일 에러) 왜냐하면 default package는 어나니머스, 즉 이름이 없는 패키지이기 때문이다.)
//toString()에서 Arrays.toString()을 통해 배열의 내용을 한 줄의 문자열로 반환한다.
//ArrayList(컬렉션 인스턴스)를 통해 find(dto.State state)에서 해당되는 state에 해당되는 PeriodicElement인스턴스를
//길이를 신경쓰지 않고 추가하고 이를 배열로 변환하는데 사용
import dto.PeriodicElement;
import dto.State;
import java.util.*;
import java.util.function.Predicate;

//PeriodicElement는 화학원소 데이터 하나하나를 담고 있는 클래스라고 한다면
//PeriodicTable은 PeriodicElement를 배열(array)형태로 여러개의 화학원소 정보를 가지고 있으면서 이를 관리하는 클래스
//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
public class  PeriodicTable  implements IPeriodicElementFinder{
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
    //즉 아래와 같은 경우 elements(dto.PeriodicElement[])배열의 각 원소들(elements[0]...elmeent[n])이 PeriodicElement를 구현한 인스턴스를 참조하므로
    //Arrays.toString(elements)를 통해 PeriodicElement를 구현한 각각의 클래스에서 오버라이딩하여 정의되어 있는 toString()메소드를 호출한다.(배열의 원소 모두에 대해서)
    //만약 PeridoicElement를 구현한 클래스에서 toString()을 오버라이딩하지 않았다면 PeriodicElement의 toString()이 호출된다.
    @Override
    public String toString() {
        return "dao.PeriodicTable{" +
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

    //PeridicElement fine(Element element), dto.PeriodicElement find(int number), dto.PeriodicElement find(String symbol)이 세개의
    //메소드들은 서로 매개변수의 타입에 차이가 있고 메소드의 이름과 반환형이 동일하므로 오버로딩 관계라고 할 수 있다.



    //매개변수로 전달받은 정수(int)는 원소번호를 뜻하고 이에 해당하는 PeriodicElement를 구현한 인스턴스를 elements(dto.PeriodicElement[])에서 찾아 반환한다.
    public PeriodicElement find(int number){
        //for-each를 통해 elements가 참조하는 dto.PeriodicElement[]배열인스턴스에서 각 배열원소(객체에 대한 래퍼런스)가 참조하는 인스턴스를
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
        //dto.PeriodicElement 인스턴스를 저장하는 ArrayList<dto.PeriodicElement>컬렉션 인스턴스를 생성하고 이를 list라는 이름으로 참조한다.
        //다이아몬드 기호를 통한 타입 인자 생략(컴파일러가 참조변수 선언을 통해서 유추가 가능하다. 비공식적인 표현이긴 하지만 공식적인 표현으로 인식될만큼 널리 사용되는 방법)
        List<PeriodicElement> list=new ArrayList<>();
        //for-each문을 통해 elements가 참조하는 배열인스턴스에 대해서 전체 반복
        for(PeriodicElement pe:elements){
            //만약 pe가 참조하는 인스턴스의 getState()를 호출하여 반환되는 State필드의 값이 state와 일치하면
            if(pe.getState()==state) {
                //컬렉션 인스턴스를 참조하는 list에 해당 인스턴스(dto.PeriodicElement) 저장
                //실제로 add의 인자로 전달된 인스턴스는 실제 저장되는 것이 아닌 인스턴스의 참조값이 저장된다.
                list.add(pe);
            }
        }

        //이렇게 배열 저체에 대해서 조건을 만족하는 PeriodicElement인스턴스를 모두 참조(저장)하고 있는 컬렉션인스턴스 list를 배열의 형태로 만들어 주기 위해 다음과 같은 작업을 실행한다.
        //dto.PeriodicElement[] peArray=(dto.PeriodicElement[])list.toArray();와 같은 방법을  생각할 수도 있지만 list.toArray()의 반환형은 Object[]형이고
        //이를 (dto.PeriodicElement[])를 통해 다운캐스팅하는 것은 불가능하진 않지만(컴파일에러가 잡히진 않겠지만) 실행중 예외가 발생한다.(java.lang.ClassCastException)
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

    //PeriodicTable클래스의 필드 elements(private)가 참조하는 배열인스턴스에 해당하는 원소들을 전부 테이블형태로 출력하는 메소드
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

    //Lab7추가내용//
    //매개변수로 전달되는 min값에서부터 max값까지의 인덱스에 해당하는 원소들을 배열형태로 반환해주는 메소드
    public PeriodicElement[] getElements(int min,int max){
        //max와 min의 차를 size에 저장한다.
        int size=max-min;
        //만약 size가 0보다 작으면 즉, min이 max보다 크면 null을 반환한다.
        if(size<0){
            return null;
        }
        //max와 min의 차이보다 1큰 크기의 PeriodicElement배열을 생성하며
        //이에 대한 참조값을 가지는 dto.PeriodicElement[]형 참조변수를 periodicElements라는 이름으로 선언한다.(배열의 선언 및 생성 동시에)
        PeriodicElement[] periodicElements=new PeriodicElement[size+1];
        //try-catch구문을 통해 예외를 처리하도록 하였다.
        try {
            //만약 min과 max가 같고 size가 0이면
            if(min==max&&size==0){
                //periodicElement는 size보다 1큰 크기로 만들었으므로 원소를 하나 가지는 배열이 만들어졌을 것이고
                //min과 max가 같으므로 어떤 것을 써도 상관없고, elements가 참조하는 객체배열의 min인덱스의 객체를 periodicElement의 0번인덱스에 저장한다.
                //(periodicElements배열은 객체에 대한 래퍼런스를 원소로 가지는 배열이다. 즉, PeriodicElement형 참조변수의 배열로 볼 수 있다.
                //periodicElement의 0번째 인덱스의 참조변수가 elements의 min번 인덱스에 해당하는 참조변수가 참조하는 객체와 같은 객체를 참조한다.)
                periodicElements[0]=elements[min];
                //periodicElements가 참조하는 배열을 반환하면서 메소드를 종료한다.
                return periodicElements;
            }
            //변수 i의 값이 반복문을 진입하면서 0으로 초기화되고, 0~size까지 1씩증가하며 반복하는 for문이다.
            //(위의 if문들을 통과하였기 때문에 size는 0보다 크다는 것을 알 수 있다.)
            for (int i = 0; i < size + 1; i++) {
                //반복을 진행하면서 i은 for문의 증감식을 통해, min값은 다음의 min++후위 증감 연산자를 통해 함께 1씩증가한다.
                //그리고 periodicElement의 i번째 인덱스의 래퍼런스와 elements의 min번째 인덱스의 래퍼런스는 동일한 래퍼런스로 같은 인스턴스를 참조하게 된다.
                periodicElements[i] = elements[min];
                //min을 1증가시키는 후위 증감 연산자, 연산이 반형되는 시점은 연산이 진행된 문장이 아닌 그 다음 문장으로 넘어가야 반영된다.
                min++;
            }
        //min,max값의 전달이 정상적이지 않을 수 있다. 예를들어 -4,-2가 전달된다고 가정하면
        //elements[min]에서 정상적이지 않은 접근이 일어나고 ArrayIndexOutOfBoundsException이 발생할 수 있다.
        //따라서 이에대해 try-catch문을 통해 예외를 처리하여 프로그램의 실행흐름을 이어나가도록하였다.
        }catch(ArrayIndexOutOfBoundsException e){
            //사용자에게 잘못된 인덱스 접근이 있음을 알린다.
            System.out.println("Invalid index access");
            //periodicElements가 null을 참조하도록한다.
            periodicElements=null;
        }
        //periodicElements가 참조하는 인스턴스 혹은 null을 반환하고 메소드를 종료한다.
        return periodicElements;
    }

    //인자를 통해 전달받은 size를 통해서 new dto.PeriodicElement[size]와 같이 배열을 생성할 때 음수가 전달되면 NegativeArraySizeException이 발생하게 된다.
    //이제까지는 메소드 내부에서 예외가 발생하였을 때 try-catch문을 통해서 처리하도록 하였다.
    //하지만 다음의 4개의 메소드들에 대해서는 메소드 내부에서 예외를 처리하는 것이 아니라 메소드에서는 발생가능한 예외를 throws를 통해 넘겨주고
    //메소드를 사용하는 곳에서 메소드를 사용함에 따라 발생가능한 예외를 사용하는 곳마다 적절히 처리할 수 있도록 하였다.
    //(참고로 프로그램의 startin point인 main메소드도 예외를 넘기면 이 예외는 main을 호출한 가상머신으로 넘어가고 프로그램은 종료된다.)
    //(예외처리에 대해서 생각을 조금 해보니(물론 크게 의미가 있는지는 모르겠지만) 메소드내부에서 예외까지 처리하는 것보다는
    //메소드는 단순히 자기가 맡은 '기능'만을 수행하고 발생가능한 예외를 throws를 통해 메소드를 호출한 영역으로 넘겨주어
    //이 메소드를 활용하는 곳에서 적절히 처리하는 것이 더 깔끔한 것 같다는 생각을 하엿다.
    //물론 메소드 내부에서 예외를 처리하는 것이 깔끔한 경우도 존재할 것이지만..따라서 둘 다 적절히 사용할 줄 알아야 할 것 같다.)
    public PeriodicElement[] getRandomElements(int size) throws NegativeArraySizeException{
        //int형 변수 random을 선언한다. 이 때 초기화를 하지 않았다.
        int random;
        //매개변수를 통해 전달받은 size크기만금의 배열을 생성하며 periodicElements라는 이름의 dto.PeriodicElement[]형 참조변수를 선언한다.(배열의 선언 및 생성 동시에)
        //이 때 size가 음수이면 NegativeArraySizeException이 발생할 것이고 throws를 통해 메소드를 호출한 영역으로 넘기면서 메소드의 호출이 종료된다.
        //따라서 이를 호출한 영역에서 예외를 처리하거나 프로그램이 종료된다.
        //(Error를 상속하거나 RuntimeException을 상속하는 예외의 발생은 특별히 무언가를 하지 않아도 되지만 Exception을 상속하는 예외의 발생에 대해서는 try-catch로 처리하거나 throws로 예외의 처리를 넘긴다는 표시를 꼭 해야 한다. 컴파일러 체)
        PeriodicElement[] periodicElements=new PeriodicElement[size];
        //변수 i의 값이 반복문을 진입하면서 0으로 초기화되고, 0~size-1까지 1씩증가하며 반복하는 for문이다.
        for(int i=0;i<size;i++) {
            //Math클래스의 static메소드인 random메소드를 호출한다.(Math클래스는 java.lang패키지에 속하므로 별도로 import할 필요가 없다.)
            //Math의 random은 현재시간을 씨드(seed)로 사용하며 0이상 1미만의 double형 값(실수)의 난수를 균일한 분포로 반환한다.
            //우리에게 필요한 값은 elements의 인덱스번호인 0부터49까지의 값이므로 elements.length를 통해 배열의 길이인 50을 곱하면
            //0이상 50미만의 값을 얻게 된다. 이 때 이 값은 double형이므로 (int)을 통해 정수로 형변환을 한다. 그러면 이 때 소수점 이하는 버려지게 되고
            //정수 0부터 49까지의 값을 랜덤하게 생성하여 int형 변수 random에 저장하게 된다.
            random =(int)(Math.random()*elements.length);
            //periodicElements와 elements모두 객체에 대한 래퍼런스를 원소로 하는 배열인데,
            //periodicElements의 i번째 인덱스에 elements의 random번째 인덱스가 참조하는 인스턴스의 참조값(래퍼런스값)을 대입한다.
            //즉 periodicElements[i]에 저장된 객체에 대한 래퍼런스와 elements[random]에 저장된 객체에 대한 래퍼런스는 동일한 값으로 둘은 동일한 인스턴스를 참조한다.
            periodicElements[i]=elements[random];
        }
        //return문을 통해 periodicElements가 참조하는 배열인스턴스를 반환하며 메소드의 호출을 종료한다.
        return periodicElements;
    }
    //PeriodicTable의 인스턴스변수 elemetns가 참조하는 배열에서 랜덤하게 하나를 골라서 반환하는 메소드
    public PeriodicElement getRandomElement() throws ArrayIndexOutOfBoundsException {
        //Java에서 난수를 발생시키는 방법은 java.lang.Math클래스의 정적메소드인 random()메소드를 사용하는 방법과 java.util.Random 클래스를 사용하는 방법 두가지가 존재한다.
        //위의 getRandomElements에서는 Math의 random()메소드를 활용하였기에 여기서는 Random클래스를 사용하도록하겠다.
        //다음의 문장은 Random클래스의 인스턴스를 생성하며 random이라는 이름의 참조변수로 참조한다.
        //Random인스턴스 생성시 시드값을 생성자로 전달하지 않으면 현재시간을 시드값으로하고 이 시드값을 인자로 받는 다른 생성자를 호출한다.
        //public Random(){
        //    this(System.currentTimeMillis());
        //}
        Random random=new Random();
        //Random클래스에는 nextBoolean(),nextLong(),nextFloat()등의 메소드가 정의되어 있다.
        //nextInt()도 정의되어 있는데 nextInt()와 nextInt(int bound)로 오버로딩되어 있다.
        //nextInt()의 경우에는 int형 난수를 반환하고 nextInt(int bound)의 경우에는 0이사 bound미만 번위의 int형 난수를 반환한다.
        //random.nextInt()메소드의 인자로 elements.length 즉 배열의 길이가 전달되고 있다.
        //여기서 elements가 참조하는 배열의 길이가 50이라면 rnadom.nextInt(elements.length)는 0이상 50미만의 값을 반환할 것이다.(0~49)
        //즉 배열의 모든 인덱스번호에 대해서 랜덤하게 하나를 고르게 된다.
        //이를 통해 elements가 참조하는 배열의 모든요소에 대해서 랜덤하게 하나를 고르고 이를 return을 통해 반환하면서 메소드호출이 종료된다.
        return elements[random.nextInt(elements.length)];
    }
    //elements가 참조하는 배열의 순서를 랜덤하게 섞는 메소드
    public void shuffle() throws UnsupportedOperationException{
        //if the specified list or its list-iterator does not support the set operation.
        //위와 같은 경우 Collections.shuffle()메소드는 UnsupportedOperationException을 일으킨다고 자바API문서에 나와있다.
        //따라서 이를 사용하는 PeriodicTable의 shuffle()메소드에서는 이를 throws를 통해 이 메소드를 호출한 영역으로 넘기도록 하였다.
        //그리고 이에 대해 적절히 예외처리를 할 수 있도록 하였다.

        //Collections클래스의 shuffle메소드를 통해 elements가 참조하는 배열의 순서를 랜덤하게섞도록 하겠다.
        //Collections클래스에 정의된 shuffle메소드는 다음과 같다.
        /*
        public static void shuffle(List<?> list) {
            Random rnd = r;
            if (rnd == null)
                r = rnd = new Random(); // harmless race.
            shuffle(list, rnd);
        }
         */
        //즉 매개변수형이 List<?>형이다. 여기서 와일드카드(?)가 쓰였는데 위의 메소드는 다음과 의미가 동일하다.
        //(public static <T> void shuffle(List<T> list))
        //매개변수형이 List<?>이므로 Arrays.asList()메소드를 통해서 배열을 리스트의 형태로 변환하여 주어야한다.
        //asList메소드는 다음과 같다.
        /*
        public static <T> List<T> asList(T... a) {
            return new ArrayList<>(a);
        }
         */
        //이 때 생성되는 ArrayList는 java.util.Arrays.ArrayList이다. 우리가 컬렉션을 배울 때 알고 있던 java.util.ArrayList와는 다르다.
        //하지만 이 클래스 또한 Collections과 List를 상속한다.
        //Arrays.asList로 생성한 객체는 이미 존재하는 fixed sized 배열의 주소값을 가져와 List로 처리하기 때문에 새로운 인스턴스의 추가나 삭제가 불가능하다.
        //그리고 기존 배열의 주소값을 가져오기 때문에 asList로 생성한 ArrayList의 내용이 변경되면 기존 배열(asList의 인자로 전달된 배열)의 내용도 변경된다.
        //java.util.Arrays.ArrayList는 set,get메소드는 가지고 있지만 add()메소드는 가지고 있지 않다.
        //하지만 List형 참조변수로 참조하고 있다면 add()호출은 가능하겠지만 List형 참조변수가 참조하는 객체(ArrayList)는 add()메소드는 지원하지 않으므로 UnsupportedOperationException실행예외가 발생할 것이다.
        //즉 정리하여 보면 다음의 문장에서 Collections클래스의 shuffle메소드를 통해 우리는 배열의 내용을 랜덤하게 썪는데,
        //elements가 참조하는 배열을 Collections클래스의 shuffle메소드의 인자로 전달하여 랜덤하게 섞기위해 Arrays.asList를 통해 리스트형태로 변환하여 전달하고있다.
        Collections.shuffle(Arrays.asList(elements));
    }
    //배열을 정렬하기 위한 메소드
    public void sort() throws ClassCastException{
        //Arrays클래스의 sort메소드의 인자로 배열(elements가 참조하는 배열인스턴스)을 전달하여 배열을 정렬한다.
        //이 Arrays.sort()는 기본자료형에 대해서 오버로딩되어 있을 뿐만 아니라 Object배열에 대해서도 오버로딩되어 있다.
        //이는 인스턴스의 참조값을 저장하고 있는 배열에 대한 정렬을 진행하는데 이 때 인스턴스들은 Comparable인터페이스를 구현하여
        //compareTo메소드를 통해 정렬의 기준을 제시하여야한다.
        //만약 Object[](혹은 이 하위의 클래스들의 배열(모든 클래스는 Object를 상속))배열의 래퍼런스에 해당하는 인스턴스들이 Comparable을 구현하지 않았다면
        //ClassCastException예외를 발생시킨다. 따라서 Arrays.sort()를 사용하는 PeriodicTable의 sort()메소드에서는 throws를 통해 이 메소드를 사용하는 영역으로 예외를 넘긴다.
        //elements가 참조하는 PeriodicElement배열에 대해서 PeriodicElement클래스는 Comparable을 implements하고 있다.
        //따라서 PeriodicElement에 정의된 compareTo의 정렬기준에 따라서 정렬될 것이다.
        Arrays.sort(elements);
    }
    //위의 sort()메소드와 오버로딩 관계에 있는 메소드이다.
    //위의 sort()의 경우 내부적으로 Comparable을 구현한 배열인스턴스를 전달함으로써 Comparable의 compareTo를 통해 정렬을 진행한다면
    //다음의 sort()의 경우 Comparator인스턴스(Comparator인터페이스를 구현한 인스턴스)를 함께 전달하여 Comparator인스턴스의 compare를 통해 정렬을 진행한다.
    public void sort(Comparator<PeriodicElement> com) throws ClassCastException{
        //Comparator<PeridoicElement>형 참조변수로 참조가능한 인스턴스(즉, Comparator인터페이스를 구현한 인스턴스)를 매개변수를 통해 전달받아
        //전달받은 Comparator를 구현한 인스턴스와 함께 elements 가 참조하는 배열인스턴스를 Arrays.sort()메소드의 인자로 전달하여
        //Comparator의 compare메소드를 통해 제시된 정렬의 기준을 바탕으로 배열의 정렬을 진행한다.
        Arrays.sort(elements,com);
    }

    //어노테이션
    //PeirodicTable클래스는 IPeriodicElementFinder인터페이스를 구현한다.
    //따라서 IPeriodicElementFinder에 정의된 findElement와 findElements메소드를 구현하여야 한다.
    @Override
    /*
    자바에서 표준으로 정의하고 있는 달리 말하면 '미리 정의해 놓은' 함수형 인터페이스들을 모아놓은
    java.util.function패키지에는 메소드의 반환형과 매개변수 선언에 차이를 둔 다양한 함수형 인터페이스들이 있다.
    다음은 표준으로 정의된 대표적인 함수형 인터페이스 4개와 그 안에 위치한 추상메소드이다.
    Predicate<T> boolean test(T t)
    Supplier<T> T get()
    Consumer<T> void accept(T t)
    Function<T,R> R apply(T t)
    참고로 다음의 메소드에서 사용하는 Predicate<T>를 구체화하고 다양화한 인터페이스들이 존재한다.
    T를 다음과 같이 기본 자료형으로 결정하여 정의한 인터페이스들도 존재하며
    IntPredicate boolean test(int value)
    LongPredicate boolean test(long value)
    DoublePredicate boolean test(double value)
    Predicate<T>와 달리 두 개의 인자를 받아서 true 또는 flase를 결정할 수 있는 다음 제네릭 인터페이스도 정의되어 있다.
    BiPredicate<T,U> boolean test(T t,U u)
    더 나아가서는 이를 스트림(파일IO스트림 X)(여기서 스트림이란 간략히 소개하면 파이프에 물을 흘려보내는 것과 같이
    '데이터의 흐름'으로 중간연산(Intermediate Operation)과 최종연산(Terminal Operation)을 진행하여 원하는 기준으로 데이터를 필터링하고 필터링 된 데이터의 가공된 결과를 얻는 것을 말한다.)
    에 활용하기도 한다.
    필터링은 스트림을 구성하는 데이터 중 일부를 조건에 따라 걸러내는 행위를 의미하는데, 다음의 메소드를 필터링에 사용할 수 있다.
    Stream<T> filter(Predicate<? super T> predicate
    위 매개변수 선언에서 보이듯이 매개변수 형이 Predicate이다. 따라서 Predicate를 스트림에서도 활용하기도 한다는 것을 알 수 있다.
     */
    //인자로 전달된 Predicate를 구현한 인스턴스의 test()메소드 조건을 만족하는 PeridoicElement하나를 찾고 반환하는 메소드
    public PeriodicElement findElement(Predicate<PeriodicElement> predicate){
        //for-each를 통해 elements가 참조하는 dto.PeriodicElement[]배열인스턴스에서 각 배열원소(객체에 대한 래퍼런스)가 참조하는 인스턴스를
        //pe가 반복을 진행하면서 하나씩 참조하면서 if문을 진행한다.
        for(PeriodicElement pe: elements){
            //매개변수를 통해 전달된 Predicate의 test메소드의 인자로 pe가 참조하는 인스턴스를 전달한다.
            //Predicate는 java.util.function패키지의 들어있는 FunctionalInterace이다.(boolean Test(T t)
            //Predicate<T>인터페이스는 전달된 인자를 판단하여 true or false를 반환해야하는 상황에서 유용하다.
            //따라서 다음의 경우 사용하기 적절한데, 인자로 전달되는 인스턴스가 구현한 Predicate의 test메소드에 따라 조건(true,flase)이 결정된다.
            //만약 test()가 반환하는 값이 참(true)인경우 if문은 참이되고
            if(predicate.test(pe)){
                //pe가 참조하는 인스턴스를 반환하며 메소드를 종료한다.
                return pe;
            }
        }
        //만약 for-each문을 통해 반복을 진행하면서 elements가 참조하는 배열의 모든 요소에 대해서 if문이 한번이라도 참이되지 않은 경우(if문 내부의 return문이 실행되지 않은 경우) null을 반환하면서 메소드를 종료한다.
        return null;
    }

    //어노테이션
    //PeirodicTable클래스는 IPeriodicElementFinder인터페이스를 구현한다.
    //따라서 IPeriodicElementFinder에 정의된 findElement와 findElements메소드를 구현하여야 한다.
    @Override
    //인자로 전달된 Predicate를 구현한 인스턴스의 test()메소드 조건을 만족하는 PeridoicElement를 모두 찾고 이를 배열형태로 반환하는 메소드
    public PeriodicElement[] findElements(Predicate<PeriodicElement> predicate){
        //매개변수를 통해 전달된 Predicate<PeriodicElement>의 test()를 만족시키는 (elements가 참조하는)배열의 요소를 모두 저장하기 위한
        //LinkedList를 생성하며 이를 List<PeriodicElement>형 참조변수로 참조한다.
        //(다이아몬드 기호를 통한 타입인자 생략)
        //LinkedList를 사용한 이유는 ArrayList를 사용할 때보다 저장공간을 늘리는 과정이 간단하여
        //다음과 같이 빈번하게 요소가 추가되어 저장공간을 늘려야하는 경우 효과적이기 때문이다.
        List<PeriodicElement> list=new LinkedList<>();
        //for-each를 통해 elements가 참조하는 dto.PeriodicElement[]배열인스턴스에서 각 배열원소(객체에 대한 래퍼런스)가 참조하는 인스턴스를
        //pe가 반복을 진행하면서 하나씩 참조하면서 if문을 진행한다.
        for(PeriodicElement pe:elements){
            //매개변수를 통해 전달된 Predicate의 test메소드의 인자로 pe가 참조하는 인스턴스를 전달한다.
            //Predicate는 java.util.function패키지의 들어있는 FunctionalInterace이다.(boolean Test(T t)
            //만약 test()가 반환하는 값이 참(true)인경우 if문은 참이되면
            if(predicate.test(pe)){
                //해당 인스턴스를 list가 참조하는 LinkedList<PeriodicElement>의 add()메소드를 통해 추가한다.
                list.add(pe);
            }
        }
        //이렇게 배열 전체에 대해서 조건을 만족하는 PeriodicElement인스턴스를 모두 참조(저장)하고 있는 컬렉션인스턴스 list를 배열의 형태로 만들어 주기 위해 다음과 같은 작업을 실행한다.
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

    //elements가 참조하는 배열인스턴스를 List<PeriodicElement>가 참조가능한 형태로 변환하여 반환하여주는 메소드이다.
    public List<PeriodicElement> getList(){
        //Arrays.asList의 인자로 elements를 전달하여 해당 내용을 담은 java.util.Arrays.ArrayList를 생성한다.
        //이 때의 ArrayList는 java.util.ArrayList와는 다르다. 하지만 이 클래스 또한 Collections과 List를 상속한다.
        //Arrays.asList로 생성한 객체는 이미 존재하는 fixed sized 배열의 주소값을 가져와 List로 처리한다.
        List<PeriodicElement> list=Arrays.asList(elements);
        //list가 참조하는 인스턴스를 반환하면서 메소드를 종료한다.
        return list;
    }
}
