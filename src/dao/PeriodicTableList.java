/*
Lab8
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/06/07
 */

//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려준다.
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려줌을 통해
//클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
//java.util패키지에 있는 List,Set인터페이스와 ArrayList,TreeSet,Random,Collections,LinkedList클래스를 import한다.

//다음의 클래스(PeriodicTable)가 소속될 패키지 명을 다음과 같이 package키워드를 이용하여 소스파일의 첫 줄에 선언해주었다.
package dao;

import dto.PeriodicElement;

import java.util.*;
import java.util.function.Predicate;


public class PeriodicTableList  implements IPeriodicElementFinder{
    //List<dto.PeriodicElement>형 컬렉션 인스턴스를 참조할 수 있는 참조변수 elements를 선언하였다.
    //인스턴스변수 혹은 static변수는 null로 초기화하지 않더라도 컴파일러에 의해 null로 초기화된다.
    //여기서 ArrayList<E>나 LinkedList<E>형 참조변수가 아닌 List<E>형 참조변수를 선언한 이유는
    //코드의 유연성을 얻기 위함이다. 주로 List<E>에 선언된 메소드를 호출하기 때문에 굳이 ArrayList<E>형 참조변수를 선언할 필요가 없으며,
    //참조변수를 List<E>형으로 함으로써 컬렉션 클래스의 교체가 용이해진다.(ArrayList<E>형 인스턴스를 참조하다가 LinkedList<E>형 인스턴스를 참조할 수 있다.)
    //물론 List<E>형 참조벼수이므로 List<E>에 선언된 메소드만이 호출가능하다.(실제로 호출되는 메소드는 List<E>가 참조하는 concrete class에서 오버라이딩을 통해 구현한 메소드일 것이다.)
     /*
    객체 지향 특성을 살리기 위해서는 캡슐화 원칙을 지키는 것이 좋고 이를 위해 가능하면 필드에 대해서
    private선언을 하고 접근자와 설정자를 통해 접근할 수 있도록 하는 것이 좋다.
    */
    private List<PeriodicElement> elements;

    //PeriodicTableList객체 생성시에 인스턴스변수 elements는 ArrayList<dto.PeriodicElement>객체를 참조하게 된다.
    //여기서 new ArrayList<>()와 같이 제네릭을 생략하였는데 다이아몬드 기호를 통한 타입 인자 생략을 하여도 컴파일러가 참조변수 선언을 통해서 유추가 가능하다.
    public PeriodicTableList(){
        //여기서 elements가 List<dto.PeriodicElement>형 변수이므로 생성되는 컬렉션 객체는 ArrayList<dto.PeriodicElement>인데
        //제네릭의 타입 매개변수 T가 PeriodicElement이므로 PeriodicElement로 참조가능한 인스턴스만을 요소로 가진다.
        //(제네릭이 없는 ArrayList도 존재하는데 이는 Object형으로 참조가능한(즉 모든 인스턴스를)인스턴스를 요소로 가질 수 있다.)
        this.elements=new ArrayList<>();
    }
    //인자로 전달된 List<PeriodicElement> elements가 참조하는 컬렉션인스턴스를 인스턴스변수 elements가 참조하도록 하는 생성자를 정의하였다.(오버로딩)
    public PeriodicTableList(List<PeriodicElement> elements){
        this.elements=elements;
    }

    //매개변수를 통해 전달받은 dto.PeriodicElement pe로 참조가능한 객체를 elements가 참조하는 컬렉션 인스턴스의 맨 뒤에 add메소드를 통해서 추가하여준다.
    public void add(PeriodicElement pe){elements.add(pe);}
    //이 메소드도 위와 같이 ArrayList<E>의 메소드를 이용한다.
    //remove()를 통해 remove메소드의 인자로 전달된 dto.PeriodicElement pe가 참조하는 인스턴스와 같은 요소를 ArrayList에서 삭제한다.
    //(ArrayList<E>는 AbstractCollection<E>를 상속한다.
    //이 때 AbstracCollection에 remove(Object o)가 정의되어 있는데 이를 ArrayList<E>에서 오버라이딩한다. 반환형은 boolean형으로 삭제가 정상적으로 이루어졌는지 실패하였는지 유무를 알 수 있다.
    //따라서 PeriodicTableList의 remove()메소드의 반환형도 boolean형으로 변경하였다.)
    //이 때 equals()메소드를 통해서 같은 요소인지를 판단한다. 따라서 PeriodicElement에서 Object의 equals()메소드를 적절히 오버라이딩하여 주었다.
    //만약 이를 오버라이딩하지 않으면 Object의 equals()메소드를 기반으로 비교를 할 것이고 Object의 equals()는 다음과 같이
    //public boolean equals(Object obj) {return(this==obj);}
    //참조값을 비교하도록 되어 있다.
    //우리는 '=='연산자를 통해 참조값의 비교가 가능하므로 equals()를 통해 참조값을 비교할 필요가 없다. 즉 equals()는 내용 비교가 이루어지도록 오버라이딩하라고 존재하는 메소드라고 볼 수도 있겟다.
    public boolean remove(PeriodicElement pe){return elements.remove(pe);}


    /*
    이제까지는 메소드 내부에서 예외가 발생하였을 때 try-catch문을 통해서 처리하도록 하였다.
    하지만 이에 대해서 조금 더 생각하여보니 메소드를 사용하는 상황에 따라서 다르게 예외를 처리하는 것이 더 옳을 것 같다는 생각을 하였다.
    따라서 메소드 내부에서 예외를 처리하는 것이 아니라 메소드에서는 발생가능한 예외를 throws를 통해 넘겨주고
    메소드를 사용하는 곳에서 메소드를 사용함에 따라 발생가능한 예외를 사용하는 곳마다 적절히 처리할 수 있도록 하였다.
    (throws는 예외의 처리를, 이 메소드를 호출한 메소드에게 넘긴다는 표시이다.
    throw와 헷갈리기 쉬운데 throw는 예외를 발생시킨다는 의미이다. ex. throw new RuntimeException()
    예외를 발생시킨다는 것은 예외 인스턴스의 생성을 의미한다.(new RuntimeException()))
     */

    //다음의 3가지 메소드는 모두 IndexOutOfBoundsException이 발생가능하다.
    //따라서 이 메소드를 호출한 영역으로 throws를 통해 예외를 넘기고 이를 호출한 영역에서 try-catch구문을 통해서 적절히 예외를 처리하도록 하였다.
    //매개변수를 통해서 전달받은 index를 3가지 메소드에서 각각 elements.get()으로 전달하고 있다.(getPrev는 index-1을, getNext는 index+1을)
    //get은 인자로 전달된 index에 해당하는 요소를 반환하는데, 이 때 적절하지 않은 인덱스가 전달되면 ArrayList<E>의 get에서는 IndexOutOfBoundsException을 일으킨다.
    //elements가 참조하는 인스턴스는 ArrayList<dto.PeriodicElement>인데(생성자가 호출되었다는 가정하에, 인스턴스 메소드를 호출하기 위해선 먼저 인스턴스가 생성되어야 하고 인스턴스 생성시에 생성자가 호출되는데
    //현재 PeriodicTableList에는 매개변수가 없는 생성자 단 하나 뿐이고, 여기서 elements가 ArrayList<dto.PeriodicElement>인스턴스를 참조하도록 한다.)
    //ArrayList<E>에서 인덱스를 통해 컬렉션인스턴스에 저장된 각 인스턴스에 접근이 가능한 이유는 ArrayList는 배열 기반 자료구조로 배열을 이용하여 인스턴스를 저장하고 순서가 있기 때문이다.
    //참고로 List<E>인터페이스를 구현하는 대표적인 컬렉션 클래스는 ArrayList<E>와 LinkedList<E>로 두가지 인데 다음의 두가지 특성을 지닌다.
    //인스턴스의 저장 순서를 유지한다. 동일한 인스턴스의 중복 저장을 허용한다.
    //(참고: Vector<E>도 List<E>인터페이스를 구현하는 컬렉션 클래스로 ArrayList와 거의 동일한데, ArrayList는 쓰레드 동기화를 지원하지 않아 멀티쓰레드에서 안전하지 않은데 반해 Vector는 멀티쓰레드에 안전하다.
    //현재 프로그램에서는 단일쓰레드를 활용하고 있고, ArrayList가 Vector보다 속도가 빠르기 때문에 ArrayList를 활용하였다.)
    public PeriodicElement get(int index) throws IndexOutOfBoundsException{
        //매개변수로 전달된 인자에 해당하는 값을 ArrayList<E>의 메소드 get으로 전달하여 해당하는 인덱스의 요소를 반환받고 이를 return한다.
        return elements.get(index);
    }
    public PeriodicElement getPrev(int index) throws IndexOutOfBoundsException{
        //매개변수로 전달된 인자에 -1을 한 값을 ArrayList<E>의 메소드 get으로 전달하여 해당하는 인덱스의 요소를 반환받고 이를 return한다.
        return elements.get(index-1);
    }
    public PeriodicElement getNext(int index) throws IndexOutOfBoundsException{
        //매개변수로 전달된 인자에 +1을 한 값을 ArrayList<E>의 메소드 get으로 전달하여 해당하는 인덱스의 요소를 반환받고 이를 return한다.
        return elements.get(index+1);
    }

    //elements가 참조하는 ArrayList<dto.PeriodicElement>컬렉션 인스턴스에서 랜덤하게 하나의 요소를 골라 반환하는 메소드
    public PeriodicElement getRandomElement(){
        //java.util패키지의 Random클래스의 인스턴스를 생성하고 이를 random이라는 이름의 참조변수로 참조한다.(Random은 자바에서 제공하는 난수를 생성하기 위한 클래스이다.)
        //Random인스턴스 생성시 시드값을 생성자로 전달하지 않으면 현재시간을 시드값으로하고 이 시드값을 인자로 받는 다른 생성자를 호출한다.
        //public Random(){
        //    this(System.currentTimeMillis());
        //}
        //Random클래스에는 nextBoolean(),nextLong(),nextFloat()등의 메소드가 정의되어 있다.
        //nextInt()도 정의되어 있는데 nextInt()와 nextInt(int bound)로 오버로딩되어 있다.
        //nextInt()의 경우에는 int형 난수를 반환하고 nextInt(int bound)의 경우에는 0이사 bound미만 번위의 int형 난수를 반환한다.
        Random random=new Random();
        //elements.get()을 통해 get의 인자로 전달되는 값의 인덱스에 해당하는 인스턴스를 반환하려고 한다.
        //이 때, 인자로 random.nextInt(elements.size()가 전달되고 있는데
        //random.nextInt()의 인자로 elements가 참조하는 컬렉션인스턴스가 포함한느 요수의 개수를 전달한다.
        //따라서 만약 컬렉션 인스턴스가 20개의 요소를 가지고 있다면, random.nextInt()는 0이상 20미만의 값을 반환할 것이고(0~19)
        //이를 통해 elements가 참조하는 컬렉션 인스턴스의 모든요소에 대해서 랜덤하게 하나를 고르고 elements.get()으로 해당 인덱스의 요소를 반환할 것이다.
        //get()은 원래 E get(int index)로 정의되어 있는데 컬렉션인스턴스가 ArrayList<dto.PeriodicElement>로 구체화되었으므로 타입매개변수 E는 PeriodicElement가 되고
        //E get(int index)는 dto.PeriodicElement get(int index)가 되어 PeriodicElement로 참조가능한(PeriodicElement형) 인스턴스가 반환된다.
        return elements.get(random.nextInt(elements.size()));
    }

    //매개변수를 통해 PeriodicEleemnt로 참조가능한 인스턴스를 전달받고 이에 해당하는 인덱스(int)를 반환하는 메소드이다.
    public int indexOf(PeriodicElement pe){
        //앞서 ArrayList<E>는 배열 기반 자료구조로 내부적으로 배열을 이용하여 인스턴스를 저장한다고 하였다.
        //또 인스턴스의 저장 순서를 유지하는 특성이 있다고 하였는데, 따라서 다음과 같이 indexOf를 통해
        //인자로 전달된 객체과 동일한 요소의 인덱스번호를 반환할 수 있다.
        //만약 존재하지 않는다면 ArrayList<E>의 indexOf는 -1을 반환한다.
        //(물론 List<E>에 indexOf가 선언되어 있기 때문에 List<E>형 참조변수인 elements를 통해 호출 가능한 것이다.)
        //이 때 indexOf로 전달된 인자와 동일한 내용인지 확인할 때는 내부적으로 equals()메소드를 통해 비교한다.
        return elements.indexOf(pe);
    }

    //리스트의 크기(int)를 반환하는 메소드이다.
    public int size(){
        //elements가 참조하는 컬렉션인스턴스ArrayList<dto.PeriodicElement>의 size()메소드를 호출하고 반환되는 값을 return한다.
        //size()메소드는 ArrayList가 포함하는 요소의 개수를 리턴하여준다.
        return elements.size();
    }


    //ArrayList에서 매개변수로 전달된 문자열(String) symbol과 동일한 요소(dto.PeriodicElement)를 찾아서 반환한다.
    public PeriodicElement find(String symbol){
        //elements가 참조하는 컬렉션인스턴스 ArrayList<E>는 Collection<E>를 상속하고 Iterable<T>를 간접적으로 구현하고 있다.
        //따라서 elements는 for-each문의 대상이 될 수 있다.
        //for-each문을 통해 컬렉션인스턴스에 저장된 인스턴스 전부를 대상으로 반복을 진행한다.(탐색을 한다고 볼수도 있겠다.)
        for(PeriodicElement pe: elements){
            //만약 컬렉션인스턴스에 저장된 요소중 하나인 pe의 getSymbol()을 통해 반환되는 문자열과 매개변수로 전달된 symbol이 같으면
            //(equals()를 통한 비교는 두 문자열의 내용을 비교한다. String클래스는 Object에 정의된 equals를 오버라이딩하고 있다.)
            if(pe.getSymbol().equals(symbol)){
                //if문이 참인 경우 return을 통해 pe가 참조하는 인스턴스를 반환하며 메소드를 종료한다.
                return pe;
            }
        }
        //for-each를 반복하는 동안 해당되는 내용이 없을 시 null을 반환하며 메소드 호출을 종료한다.
        return null;
    }

    //elements가 참조하는 컬렉션 인스턴스의 내용을 정렬하기 위한 메소드
    //Collections.sort를 내부적으로 이용할 것인데 이 메소드는 다음의 3가지 이유로 3가지 예외를 발생할 수 있다.
    //ClassCastException: if the list contains elements that are not mutually comparable
    //UnsopportedOperationException: if the specified list's list-iterator does not support the set operation.
    //IllegalArgumentException: if the implementation detects that the natural ordering of the list elements is found to violate the Comparable contract
    //둘 이상의 예외를 넘길 때는 다음과 같이 ',' 로 구분한다.
    public void sort() throws ClassCastException,UnsupportedOperationException,IllegalArgumentException{
        //sort()메소드 내부에서 Collections의 static으로 정의된 메소드 sort를 호출하며 인자로 elements를 전달한다.
        //Collections의 sort메소드는 다음과 같이 정의되어 있다.
        //public static <T extends Comparable<? super T>> void sort​(List<T> list){내부구현은 생략하였고 메소드 반환형, 이름, 타입매개변수 정보, 매개변수정보에 대해서 이야기하겠다.}
        //그전에 우선 Collections.srot메소드는 위의 메소드 뿐 아니라(List<T> list,Comparator<? super T> c)와 같이 오버로딩되어 있다.
        //즉 Comparable을 이용하든, Comparator를 이용하든 상관없지만
        //Comparable을 구현한 T에 대한 List의 전달 혹은 T에 대한 Comparator인스턴스의 전달을 통해 정렬의 기준이 꼭 필요하다는 의미이다.
        //Compartor<? super T>에 대해서는 PeriodicElement에서 이야기하였으므로 생략하고
        //(추가적인 내용을 말하자면 String과 같은 자바에서 제공하는 기본클래스를 대상으로 정렬기준을 바꿔야 하는 상황에서 Comparator<T>를 이용하는 것이 좋다.
        //예를 들어 String은 사전편찬순으로 정렬이 되도록 Comparable<String>인터페이스를 구현하고 있는데 문자열 길이순으로 수정하고 싶다고 우리가 String클래스에 정의된 compareTo()를 수정할 수 없다.
        //따라서 이럴 때에 Comparator<T>를 이용하여 문자열 길이순으로 정렬하도록 정렬 기준을 전달할 수 있다. TreeSet의 생성자나 Collections.sort의 인자로..)
        //sort(List<T> list)에 대해서 이야기하겠다.
        //간략히 먼저 정리하면 sort(List<T> list)메소드는 Comparable을 구현한 T에 대한 List<T>를 인자로 전달받고 Comparable의 compareTo()메소드에 따라 정렬을 진행하는 메소드이다.
        //정확히 타입매개변수 정보에 대해서 분석하여 보자. 타입매개변수 정보를 <T>와 같이 생략하여보면
        //메소드 호출 시점에 T가 결정되므로 List<T>는 모두 전달가능하다.
        //<T extends Comparable<T>>이므로 그 T는 Compararble<T>를 구현한 상태이어야하는데,
        //<T extends Comparable<? super T>>이므로 와일드카드를 통한 하한제한으로 T의 상위의 클래스에 대하여 Comparable이 정의되어 있으면
        //하위클래스에서 이를 또 정의해줄 필요가 없다.(물론 정렬 기준이 바뀐다면 compareTo()를 오버라이딩할 수 있겠지만)
        //또한 T형 인스턴스를 넣는 작업(전달하는 작업)(set)만 가능하고 이 인스턴스를 반환하는(get)작업은 불가능하다.)
        Collections.sort(elements);
    }
    public void sort(Comparator<PeriodicElement> com) throws ClassCastException,UnsupportedOperationException,IllegalArgumentException{
        Collections.sort(elements,com);
    }

    //내가 추가한 메소드, 중복되는 원소를 제거하기 위한 메소드
    public void deduplicate(){
        /*
        TreeSet은 트리 자료구조를 기반으로 인스턴스를 저장하기 때문에 정렬된 상태가 유지되면서 인스턴스가 저장된다.
        따라서 이를 통한 ArrayList를 생성하면 자동으로 ArrayList의 저장된 인스턴스들도 정렬을 유지하게 된다.
         */
        //elements가 참조하는 ArrayList컬렉션 인스턴스는 동일한 인스턴스의 중복 저장을 허용한다.
        //반면 Set<E>를 상속하는 컬렉션인스턴스인 HashSet<E>과 TreeSet<E>은 Set이름 그 자체가 의미하듯이 집합(set)의 특성을 가지는데
        //저장 순서가 유지되지 않고, 데이터의 중복저장을 허용하지 않는다.
        //따라서 List<E>기반의 컬렉션 인스턴스가 저장하고 있는 인스턴스들에 대해서 중복 저장을 제거하고 싶다면 이를 HashSet혹은 Treeset의 생성자로
        //전달하여주고 이를 다시 ArrayList혹은 LinkedList의 생성자로 옮겨주면 된다.
        //아래와 같이 TreeSet의 인스턴스를 생성하면서 elements가 참조하는 ArrayList<PeridoicElement>컬렉션객체를 전달하면
        //TreeSet<dto.PeriodicElement>인스턴스에 저장대상을 복사하는 연산이 내부적으로 진행된다. 그리고 이 때 Set<E> 인터페이스의 성격에 맞게 중복된 인스턴스는 걸러지게되고
        //이를 다시 ArrayList<dto.PeriodicElement>로 복사하면 중복된 내용이 걸러진 내용만을 elements가 참조하게 될 것이다.
        Set<PeriodicElement> set=new TreeSet<>(elements);
        elements=new ArrayList<>(set);
    }

    //PeriodicTableList클래스의 필드 elements가 참조하는 컬렉션인스턴스의 요소들을 전부 테이블형태로 출력하는 메소드
    public void print(){
        //for-each문을 통해서 elements의 모든 요소에 순차적으로 접근하고 이를 pe변수로 참조한다.
        //이 때 pe가 참조하는 인스턴스는 PeriodicElement가 아닌 이를 구현한 concrete class기반의 인스턴스들일 것이다.
        for(PeriodicElement pe: elements){
            System.out.println("----------------------------------------------------------------------------------------");
            //각각의 pe인스턴스들의 print()메소드를 호출한다. PeridoicElement pe가 참조하는 elements의 각각의 원소들은 PeriodicElement를 구현하는 구상클래스들일 것이다.
            //왜냐하면 PeriodicElement는 추상클래스로 인스턴스화 할 수 없기 때문이다.
            //따라서 각 PeriodicElement를 상속을 통해 구현하는 클래스들에서 오버라이딩한 print()메소드를 호출할 것이다.(다형성)
            pe.print();
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }


    //elements가 참조하는 리스의 순서를 랜덤하게 섞는 메소드
    public void shuffle() throws UnsupportedOperationException{
        //if the specified list or its list-iterator does not support the set operation.
        //위와 같은 경우 Collections.shuffle()메소드는 UnsupportedOperationException을 일으킨다고 자바API문서에 나와있다.
        //따라서 이를 사용하는 PeriodicTable의 shuffle()메소드에서는 이를 throws를 통해 이 메소드를 호출한 영역으로 넘기도록 하였다.
        //그리고 이에 대해 적절히 예외처리를 할 수 있도록 하였다.

        //Collections클래스의 shuffle메소드를 통해 elements가 참조하는 리스의 순서를 랜덤하게섞도록 하겠다.
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
        Collections.shuffle(elements);
    }

    /*
   Object클래스로부터 상속받은 toString()메소드를 오버라이딩(재정의)한다.
   System.out.println()의 인자로 인스턴스를 참조하는 참조변수 전달시 해당 인스턴스의 toString()호출로 이어진다.
   모든 클래스는 Object를 상속하므로 이를 오버라이딩하지 않으면 Object에 정의되어있는
   public String toString(){return getClass().getName()+"@"+Integer.toHexString(hashCode());}
   가 호출되게 된다.
   인스턴스 구분에 도움이 되는 문자열을 구성하여, 각각의 클래스에 맞게끔 toString()메소드를 적절히 오버라이딩하는 것이 바람직 하다고 생각한다.
    */
    @Override
    public String toString() {
        //다음의 elements도 elements.toString()과 같다.
        return "PeriodicTableList{" +
                "elements=" + elements +
                '}';
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
        //Collection<E>는 Iterable<T>를 상속한다. 따라서 Collection<E>를 구현하는 제네릭클래스는 Iterable<T>의 iterator()추상메소드를 구현한다.
        //elements가 참조하는 인스턴스는 Collection을 상속하는 컬렉션 인스턴스이므로 iterator()를 통해 반복자(Iterator)를 생성가능하다.
        //elements.iterator()를 통해 Iterator<PeriodicElement>(반복자)를 생성한다.
        //그리고 itr.hasNext()를 이용하여 next메소드 호출 시 참조 값 반환 가능 여부를 확인하여 반복을 계속할지를 결정하도록한다.
        //반복자(iterator)를 활용하여 순차적으로 컬렉션 인스턴스의 내용에 접근한다.
        //참고로 for-each문을 통한 순차적 접근의 대상이 되려면, 해당 컬렉션 클래스는 public interface Iterable<T>를 구현해야 하는데,
        //ArrayList<E>, LinkedList<E>클래스는 위의 Iterable<T>인터페이스를 구현하고 있다.
        //정확히는 Collection<E>가 Iterable<T>를 상속하고 있고, Iterable<T>를 간접적으로 구현하고 있다고 볼 수 있다.
        //실제로 for-each문을 통해 순차적으로 접근하였던 문장들도 컴파일 과정에서는 다음과 같이 반복자를 이용하는 코드로 수정된다.(즉 for-each문도 역시 반복자에 의한 순차적 접근으로 진행된다.)
        for(Iterator<PeriodicElement> itr=elements.iterator();itr.hasNext();){
            //itr.next()를 통해 다음 인스턴스의 참조값을 반환하고, 이를 pe(PeriodicElement형 참조변수)로 참조하도록 한다.
            PeriodicElement pe=itr.next();
            //매개변수를 통해 전달된 Predicate의 test메소드의 인자로 pe가 참조하는 인스턴스를 전달한다.
            //Predicate는 java.util.function패키지의 들어있는 FunctionalInterace이다.(boolean Test(T t)
            //Predicate<T>인터페이스는 전달된 인자를 판단하여 true or false를 반환해야하는 상황에서 유용다.
            //따라서 다음의 경우 사용하기 적절한데, 인자로 전달되는 인스턴스가 구현한 test()메소드의 조건에 따라 true or false를 반환하는데
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
        //Collection<E>는 Iterable<T>를 상속한다. 따라서 Collection<E>를 구현하는 제네릭클래스는 Iterable<T>의 iterator()추상메소드를 구현한다.
        //elements가 참조하는 인스턴스는 Collection을 상속하는 컬렉션 인스턴스이므로 iterator()를 통해 반복자(Iterator)를 생성가능하다.
        //elements.iterator()를 통해 Iterator<PeriodicElement>(반복자)를 생성한다.
        //그리고 itr.hasNext()를 이용하여 next메소드 호출 시 참조 값 반환 가능 여부를 확인하여 반복을 계속할지를 결정하도록한다.
        //반복자(iterator)를 활용하여 순차적으로 컬렉션 인스턴스의 내용에 접근한다.
        for(Iterator<PeriodicElement> itr=elements.iterator();itr.hasNext();){
            //itr.next()를 통해 다음 인스턴스의 참조값을 반환하고, 이를 pe(PeriodicElement형 참조변수)로 참조하도록 한다.
            PeriodicElement pe=itr.next();
            //매개변수를 통해 전달된 Predicate의 test메소드의 인자로 pe가 참조하는 인스턴스를 전달한다.
            //만약 test()가 반환하는 값이 참(true)인경우 if문은 참이되면
            if(predicate.test(pe)){
                //해당 인스턴스를 list가 참조하는 LinkedList<PeriodicElement>의 add()메소드를 통해 추가한다.
                list.add(pe);
            }
        }
        //이렇게 리스 전체에 대해서 조건을 만족하는 PeriodicElement인스턴스를 모두 참조(저장)하고 있는 컬렉션인스턴스 list를 배열의 형태로 만들어 주기 위해 다음이 작업을 실시한다.
        //컬렉션 인스턴스(list가 참조하는 LinkedList인스턴스)의 크기만큼의 배열을 먼저 생성한 이후에
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
        //이렇게 변환된 PeriodicElement형 배열을 반환하며 메소드 호출을 종료한다.
        return peArray;
    }

    //elements가 참조하는 ArrayList<PeriodicElement>인스턴스를 반환하여주는 메소드이다.
    public List<PeriodicElement> getList(){
        return elements;
    }
}
