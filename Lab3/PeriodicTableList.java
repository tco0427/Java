/*
Lab7
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/26
 */

//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려준다.
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려줌을 통해
//클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
//java.util패키지에 있는 List,Set인터페이스와 ArrayList,TreeSet,Random,Collections,LinkedList클래스를 import한다.
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;



public class PeriodicTableList {
    //List<PeriodicElement>형 컬렉션 인스턴스를 참조할 수 있는 참조변수 elements를 선언하였다.
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

    //PeriodicTableList객체 생성시에 인스턴스변수 elements는 ArrayList<PeriodicElement>객체를 참조하게 된다.
    //여기서 new ArrayList<>()와 같이 제네릭을 생략하였는데 다이아몬드 기호를 통한 타입 인자 생략을 하여도 컴파일러가 참조변수 선언을 통해서 유추가 가능하다.
    public PeriodicTableList(){
        //여기서 elements가 List<PeriodicElement>형 변수이므로 생성되는 컬렉션 객체는 ArrayList<PeriodicElement>인데
        //제네릭의 타입 매개변수 T가 PeriodicElement이므로 PeriodicElement로 참조가능한 인스턴스만을 요소로 가진다.
        //(제네릭이 없는 ArrayList도 존재하는데 이는 Object형으로 참조가능한(즉 모든 인스턴스를)인스턴스를 요소로 가질 수 있다.)
        this.elements=new ArrayList<>();
    }

    //매개변수를 통해 전달받은 PeriodicElement pe로 참조가능한 객체를 elements가 참조하는 컬렉션 인스턴스의 맨 뒤에 add메소드를 통해서 추가하여준다.
    public void add(PeriodicElement pe){elements.add(pe);}
    //이 메소드도 위와 같이 ArrayList<E>의 메소드를 이용한다.
    //remove()를 통해 remove메소드의 인자로 전달된 PeriodicElement pe가 참조하는 인스턴스와 같은 요소를 ArrayList에서 삭제한다.
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
    //elements가 참조하는 인스턴스는 ArrayList<PeriodicElement>인데(생성자가 호출되었다는 가정하에, 인스턴스 메소드를 호출하기 위해선 먼저 인스턴스가 생성되어야 하고 인스턴스 생성시에 생성자가 호출되는데
    //현재 PeriodicTableList에는 매개변수가 없는 생성자 단 하나 뿐이고, 여기서 elements가 ArrayList<PeriodicElement>인스턴스를 참조하도록 한다.)
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

    //elements가 참조하는 ArrayList<PeriodicElement>컬렉션 인스턴스에서 랜덤하게 하나의 요소를 골라 반환하는 메소드
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
        //get()은 원래 E get(int index)로 정의되어 있는데 컬렉션인스턴스가 ArrayList<PeriodicElement>로 구체화되었으므로 타입매개변수 E는 PeriodicElement가 되고
        //E get(int index)는 PeriodicElement get(int index)가 되어 PeriodicElement로 참조가능한(PeriodicElement형) 인스턴스가 반환된다.
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
        //elements가 참조하는 컬렉션인스턴스ArrayList<PeriodicElement>의 size()메소드를 호출하고 반환되는 값을 return한다.
        //size()메소드는 ArrayList가 포함하는 요소의 개수를 리턴하여준다.
        return elements.size();
    }


    //다음 2개의 find메소드는 매개변수만이 find(Elmeent e), find(String symbol)로 다르고
    //메소드 이름과 반환형이 모두 동일한 오버로딩 관계이다.
    //List<PeriodicElement> find(IPeriodicElementFinder finder)는 위의 두 메소드와 오버로딩 관계가 성립하지 않는다.

    //ArrayList에서 매개변수로 전달된 Element와 동일한 Element에 해당하는 요소(PeriodicElement)를 찾아서 반환한다.
    public PeriodicElement find(Element e) throws NullPointerException{
        //enhanced for문(for-each문)을 통해서 elements가 참조하는 컬렉션인스턴스의 모든 요소를 접근하며
        //반복을 진행하면서 각각의 원소가 참조하는 인스턴스를 pe 또한 참조하게 된다.
        //(컬렉션 인스턴스에 저장된 모든 인스턴스들을 대상으로 다음을 진행)
        //참고로 for-each문을 통한 순차적 접근의 대상이 되려면, 해당 컬렉션 클래스는 public interface Iterable<T>를 구현해야 하는데,
        //ArrayList<E>, LinkedList<E>클래스는 위의 Iterable<T>인터페이스를 구현하고 있다.
        //정확히는 Collection<E>가 Iterable<T>를 상속하고 있고, Iterable<T>를 간접적으로 구현하고 있다고 볼 수 있다.
        /*
        실제로 for-each문은 다음과 같은 형태이다.(컴파일 과정에서 다음과 같은 반복자를 이용하는 코드로 수정된다.)
        for(Iterator<PeriodicElement> itr=elements.iterator();itr.hasNext();){
            if(itr.next()==e.getValue()){
                return pe;
            }
        }
        Iterable인터페이스의 iterator()메소드를 통하여 Iterator<T>형 반복자인스턴스를 반환한다. 반복자는 저장된 인스턴스를 가리키는 역할을 한다고 볼 수 있다.
        Iterator반복자는 다음 인스턴스의 참조값을 반환하는 next()메소드와 next메소드 호출 시 참조값 반환 가능 여부를 확인하기 위한 boolean형값을 반환하는 hasNext(), next()를 통해 반환하였던 인스턴스를 삭제하는 remove()메소드가 있다.
        참고로 List<E>를 구현하는 클래스의 인스턴스들만 얻을 수 있는 '양방향 반복자'가 존재한다. 이 양방향 반복자는 다음의 메소드 호출을 통해 얻을 수 있다.
        public ListIterator<E> listIterator()
        참고로 ListIterator<E>는 Iterator<E>를 상속한다.
         */
        for(PeriodicElement pe: elements){
            //pe.getNumber()를 통해 반환되는 값과 매개변수를 통해 전달받은 Element의 getvalue(), 즉 e.getVaule()의 값
            //두 값이 동일하면 if문이 참이되고 pe가 참조하는 인스턴스를 return을 통해 반환한다.
            if(pe.getNumber() == e.getValue()){
                //return을 통해 pe를 반환하며 메소드를 종료한다.
                return pe;
            }
        }
        //for-each를 반복하는 동안 컬레션인스턴스에 해당되는 내용이 없을 시 null을 반환하며 메소드를 종료한다.
        return null;
    }
    //ArrayList에서 매개변수로 전달된 문자열(String) symbol과 동일한 요소(PeriodicElement)를 찾아서 반환한다.
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
    //ArrayList에서 매개변수로 전달된 IPeriodicElementFinder를 통해 조건을 만족하는 요소를 모아 List<PeriodicElement>형태로 반환한다.
    //매개변수로 전달되는 IPeriodicElemenetFinder finder가 null일 수도 있고 이를 통한 isInstanceOf()호출은 NullPointerException을 일으킨다.
    //따라서 이 메소드를 호출한 영역으로 throws를 통해 예외를 넘기고 이를 호출한 영역에서 try-catch구문을 통해서 적절히 예외를 처리하도록 하였다.
    public List<PeriodicElement> find(IPeriodicElementFinder finder) throws NullPointerException{
        //인스턴스변수 elements가 참조하는 ArrayList<PeriodicElement>에서 조건을 만족하는 내용을 저장하기 위한 LinkedList를 생성하고
        //이를 List<PeriodicElement>형 참조변수로 참조한다.(ArrayList를 사용하여도 되지만 LinkedList를 사용해보고 싶었고 다음의 이유로 적절하다고 생각하였기 때문에 이를 사용하였다.)
        //다음에서 설명하겠지만 ArrayList보다 LinkedList를 이용하는 것이 저장공간을 늘리는데 효과적인데 add를 통해 계속해서 저장할 인스턴스를 늘리기 때문에
        //LinkedList를 이용하면 조금 더 효율적이라고 생각하였기 때문이다.
        /*
        LinkedList<E>와 ArrayList<E>는 모두 List<E>인터페이스를 구현하기 때문에 List<PeriodicElement>형 참조변수로 참조가능하다.
        해당클래스(PeriodicTableList)의 인스턴스변수 elements와 find()메소드내에 선언된 지역변수 list 모두 List<E>형 참조변수인데
        현재까지 elements를 통해 호출한 메소드는 모두 List<E>에 선언되어 있는 메소드이다.(물론 실제 호출되는 메소드는 각 구상클래스에서 오버라이딩을 통해 구현한 메소드일 것이다.)
        이 때 굳이 ArrayList<E>형 참조변수를 이용하지 않고, List<E>형 참조변수를 한 이유는 컬레션 클래스의 교체가 용이하다는 장점이 있기 때문이다.
        LinkedList는 요소들을 양방향으로 연결하여 관리한다는 점을 제외하면 ArrayList와 동일하다. 즉, 리스트기반 자료구조로 리스트를 구성하여 인스턴스를 저장한다고 볼 수 있다.
        LinkedList와 ArrayList를 비교하여 보면 ArrayList는 저장된 인스턴스의 참조가 빠르다는 장점(배열에 저장된 요소에 접근할 때 인덱스 값을 통해 원한느 위치에 바로 접근하기 대문에 어느 위치에 있는 인스턴스이건 접근에 소요되는 시간이 동일)이 있지만
        저장공간을 늘리는 과정에서 시간이 비교적 많이 소요된다는 점(배열 교체)과 인스턴스의 삭제 과정에서 많은 연산이 필요하여 속도가 느릴 수 있다는 단점이있다.
        (배열 중간에 위치한 인스턴스를 삭제할 경우, 삭제된 위치를 비워두지 않기 위해서 그 뒤에 저장되어 있는 인스턴스들을 한 칸씩 앞으로 이동하는 과정 진행)
        반면 LinkedList는 저장공간을 늘리는 과정이 간단하고, 저장된 인스턴스의 삭제과정이 단순하다는 장점(중간에 위치한 데이터를 없앨 때에는 해당칸을 제외한 앞뒤의 칸을 연결하면 되기 때문에)
        이 있지만 저장된 인스턴스의 참조과정이 배열에 비해 복잡하여 느릴 수 있다는 단점터
        (연결리스트라는 자료구조는 중간에 위치한 데이터에 바로 접근이 불가하고 맨 앞 혹은 맨 뒤칸에서부터 한칸씩 건너가는 구조이기 때문에)이 있다.
         */
        List<PeriodicElement> list=new LinkedList<>();
        //for-each문을 통해 elements가 참조하는 ArrayList컬렉션 인스턴스에 저장된 모든 요소를 순차적으로 접근하고
        //각 인스턴스를 for-each문 내에서 pe라는 참조변수로 참조한다.
        for(PeriodicElement pe:elements){
            //매개변수로 전달된 IPeriodicElementFinder형 finder로 참조가능한 인스턴스를 대상으로 isInstanceOf메소드를 호출하며 pe가 참조하는 인스턴스를 인자로 전달한다.
            //(IPerodicElementFinder는 인터페이스로 이를 대상으로 인스턴스생성이 불가하고, 이를 통한 참조변수선언은 가능하다.
            //따라서 finder는 IPeriodicElementFinder를 구현한 모든 구상클래스를 참조할 수 있다.
            //이 때 finder를 통해 접근가능한 멤버(호출가능한 메소드)는 IPeriodicElementFinder에 정의된 멤버만 가능하다.)
            if(finder.isInstanceOf(pe)){
                //finder.isInstaceOf()의 반환값이 true인 경우 if문은 참이된다.
                //isInstanceOf()를 참으로 만든 pe인스턴스를 add()메소드를 통해 list에 저장한다.
                //매개변수를 전달받지 않는 생성자를 통해 만든 ArrayList가 기본적으로 가지고 있는 공간의 크기는 10인데 이보다 큰 원소를 저장하려고하게되면 크기를 늘려야할 것이고, 빈번한 배열의 교체가 일어날 것이다.
                //(참고로 ArrayList의 생성자는 ArrayList(), ArrayList(int initialCapacity)로 오버로딩되어 있다. 따라서 저장해야 할 인스턴스의 수를 대략적으로 알 수 있다면
                //ArrayList(int initialCapacity)를 이용하는 것도 성능향상에 도움이 될 것이다.)
                //따라서 LinkedList를 이용한 것이 더 현명하다고 생각한다.
                list.add(pe);
            }
        }
        //return을 통해 list가 참조하는 인스턴스를 반환하며 메소드 호출을 종료한다.
        return list;
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
        //TreeSet<PeriodicElement>인스턴스에 저장대상을 복사하는 연산이 내부적으로 진행된다. 그리고 이 때 Set<E> 인터페이스의 성격에 맞게 중복된 인스턴스는 걸러지게되고
        //이를 다시 ArrayList<PeriodicElement>로 복사하면 중복된 내용이 걸러진 내용만을 elements가 참조하게 될 것이다.
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
}
