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
//java.util패키지에 들어있는 모든 클래스(*)를 import한다.
//다음과 같이 패키지의 모든 클래스를 import하는 것은 다른패키지의 클래스와 이름충돌이 발생가능할 수 있고, 의도하지 않은 클래스의 인스턴스를 생성하는 상황으로 이어질 수 있기 때문에
//가급적 사용을 자제하라고 권고하고 필요한 클래스별로 import하는 것을 권장한다고 한다.
//하지만 다음의 경우 java.util패키지의 클래스만을 사용하고, 다른 패키지의 클래스는 import하지 않으므로 *를 통해서 모든 클래스를 한번에 import하도록하였다.
import java.util.*;

public class PeriodicTableMap {
    //Map<Element,PeriodicElement>형 컬렉션 인스턴스를 참조할 수 있는 참조변수 elements를 선언하였다.
    //인스턴스변수 혹은 static변수는 null로 초기화하지 않더라도 컴파일러에 의해 null로 초기화된다.
    //여기서 HashMap<K,V>나 TreeMap<K,V>형 참조변수가 아닌 Map<K,V>형 참조변수를 선언한 이유는
    //코드의 유연성을 얻기 위함이다. 주로 Map<E>에 선언된 메소드를 호출하기 때문에 굳이 HashMap<E>형 참조변수를 선언할 필요가 없으며,
    //참조변수를 Map<K,V>형으로 함으로써 컬렉션 클래스의 교체가 용이해진다.(HashMap<K,V>형 인스턴스를 참조하다가 TreeMap<K,V>형 인스턴스를 참조할 수 있다.)
    //(실제로 TreeMap은 트리 자료구조를 기반으로 하므로 정렬된 상태를 유지하는데 sort()메소드에서 이를 활용할 것이다. 이 때 Map<K,V>형 참조변수의 이점이 들어난다.)
    //물론 Map<K,V>형 참조벼수이므로 Map<E>에 선언된 메소드만이 호출가능하다.(실제로 호출되는 메소드는 Map<E>가 참조하는 concrete class에서 오버라이딩을 통해 구현한 메소드일 것이다.)
     /*
    객체 지향 특성을 살리기 위해서는 캡슐화 원칙을 지키는 것이 좋고 이를 위해 가능하면 필드에 대해서
    private선언을 하고 접근자와 설정자를 통해 접근할 수 있도록 하는 것이 좋다.
    */
     /*
     여기서 추가적으로 Map의 특징에 대해서 간략히 이야기하겠다.
     맵은 연상배열(associative array)이라고 불리기도 하며, Dictionary라고 불리기도한다.
     연상배열은 원소 개수와 동일한 개수의 값들(키라 불리움)로 인덱싱되는 순서를 갖지 않는 데이터 원소들의 모임이다.
     따라서 자바에서 Map<K,V>를 구현하는 컬렉션 클래스의 인스턴스들은 Key와 Value가 한 쌍을 이루는 형태로 데이터를 저장한다.
     앞서 키를 통해 인덱싱된다고 언급하였다. 즉 키를 통해서 Value(값)을 찾는다는 의미이다. 따라 Key값은 절대로 중복될 수 없다.
     하지만 Value는 키값만 중복되지 않는다면 중복되어도 무관하다.
     참고로 Map<K,V>는 Collection을 상속하지 않으므로 자연히 Collection이 상속하는 Iterable<T>를 상속하지 않는다.
     따라서 Map<K,V>를 구현하는 HashMap<K,V>와 TreeMap<K,V>는 모두 for-each문을 통한 순차적 접근의 대상이 될 수 없다.
     (for-each문의 순차적 접근의 대상이 되기 위해서는 Iterable<T>를 구현하여야 한다.)
     (반복자(Iterator)를 통한 순차적 접근도 당연히 불가능하다.)(반복자에 대해서는 PeriodicTableList에서 언급하였으므로 생략)
      */
    private Map<Element,PeriodicElement> elements=null;

    //PeriodicTableMap객체 생성시에 인스턴스변수 elements는 HashMap<Element,PeriodicElement>객체를 참조하게 된다.
    //여기서 new Hash<>()와 같이 제네릭을 생략하였는데 다이아몬드 기호를 통한 타입 인자 생략을 하여도 컴파일러가 참조변수 선언을 통해서 유추가 가능하다.
    //HashMap은 해싱알고리즘을 이용하기 때문에 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다. 하지만 hash데이터는 정렬을 보장하는 않는다는 점이다.
    public PeriodicTableMap(){
        this.elements=new HashMap<>();
    }

    //매개변수를 통해 전달받은 Element와PeriodicElement pe로 참조가능한 객체를 elements가 참조하는 컬렉션 인스턴스(HashMap)의 put메소드를 통하여 키와 값 쌍 형태로 저장한다.
    public void add(Element e,PeriodicElement pe){ elements.put(e,pe); }
    //이 메소드도 위와 같이 HashMap<K,V>의 메소드 remove를 통해 remove메소드의 인자로 전달된 Element e를 통해 해당되는 키를 찾아 키와 값을 모두 삭제한다.
    public void remove(Element e){
        elements.remove(e);
    }
    //매개변수를 통해 전달받은 Value에 해당하는 값이 elements가 참조하는 맵에 존재하는지, 즉 일치하는 키가 있는지 확인하는 메소드
    public boolean containsValue(PeriodicElement pe){
        //매개변수를 통해 전달받은 Value에 해당하는 pe가 참조하는 인스턴스를 HashMap<K,V>(혹은 TreeMap<K,V>)의 메소드containsValue의 인자로 전달한다.
        //return을 통해 elements가 참조하는 맵객체에 인자로 넘겨준 값(value)이 포함되어있으면 true,없으면 false 반환하고 메소드 종료
        //(동일한 값인지 포함되어 있는지의 여부는 넘겨준 Value에 정의된 equals()메소드에 의해서 결정된다.(여기서는 PeriodicElement에 오버라이딩된 equals()이용))
        return elements.containsValue(pe);
    }

    //HashMap에서 한가지 주의 하실 점이 Map에 데이터를 등록할 때, Key값은 중복이 되지 않고 Value값은 중복이 허용된다는 점이다.
    //만약 동일한 키를 중복하여 저장할 시 해당 키에 대해 마지막으로(가장 최근에) 저장한 value값으로 덮어씌워진다.
    //즉, 이 말은 키에 해당하는 value값을 수정하기 위해서는 동일 키 값으로 덮어쓰면 된다라는 뜻이다.
    //따라서 맵에서 해당 Element를 PeriodicElement로 교체하는 메소드인 set에서는 인스턴스변수 elements가 참조하는 HashMap컬렉션인스턴스의 put메소드를 이용하여
    //중복된 키값과 함께 value를 전달하여 주면 된다.
    //다음의 메소드에서는 추가적으로 매개변수를 통해 전달받은 키에 해당하는 Element e가 존재하는지 유무에 따라 true혹은 false를 반환하도록하였다.
    public boolean set(Element e,PeriodicElement pe){
        //해당되는 키값을 검색하기 위해 elements가 참조하는 맵에 대해서 순차적으로 접근하여야한다.
        //앞서 언급하였듯이 Map<K,V>의 구상클래스들은 Iterable<T>인터페이스를 구현하지 않으므로 for-each문을 통해서 혹은 '반복자'(Iterator)를 통해서 순차적 접근을 진행할 수 없다.
        //따라서 Map<K,V>에 존재하는 public Set<K> keySet()메소드를 통해서 모든 Key값을 담은 집합(Set)을 Set<Element>형 참조변수 keySet으로 참조하도록 하겠다.
        Set<Element> keySet=elements.keySet();
        //keyset은 elements가 참조하는 HashMap의 모든 키값을 담은 Set을 참조하는 변수이다.
        //그리고 Set을 기반으로는 iterator()를 통해 반복자(Iterator)를 생성가능하다.
        //PeriodicTableList에서 for-each문에 대해 설명하면서 for-each은 컴파일과정에서 반복자를 이용하는 코드로 수정된다고 하였다.
        //따라서 다음에서는 반복자를 이용한 형태로 코드를 작성하였다.문
        //반복문을 통해 모든 키값을 순차적으로 접근하면서 매개변수와 동일한 키값을 가진 키가 맵에 존재하는 경우 값을 변경하고 true를 반환할 것이다.
        //keySet.iterator()를 통해 Iterator<Element>를 생성한다. 그리고 itr.hasNext()를 이용하여 next메소드 호출 시 참조 값 반환 가능 여부를 확인하여 반복을 계속할지를 결정하도록한다.
        for(Iterator<Element> itr=keySet.iterator();itr.hasNext();){
            //itr.next()가 반환하는 참조값을 element로 참조하도록한다.
            Element element=itr.next();
            //반복자(Iterator)가 next()를 통해 반환한 Element와 매개변수를 통해 전달된 Element가 동일한지 if문을 통해 확인한다.
            //이 때 동일한지의 여부를 판단하기 위해 각각 Element에 대해서 name()을 호출하고 반환되는 문자열을 equals()를 통해 비교하도록하였다.
            if(element.name().equals(e.name())){
                //if문이 참이면 매개변수를 통해 전달된 Element, 즉 키가 존재한다는 것이고 put을 통해 덮어써준다.(즉 키는 동일한데 해당 키의 값(PeriodicElement가 변경된다.)
                elements.put(element,pe);
                //이후 return을 통해 true를 반환하며 메소드를 종료한다.
                return true;
            }
        }
        //만약 for문을 도는 동안 if문이 참이되어 return을 통해 메소드 호출이 종료되지 않은 경우 다음의 return문을 통해 false를 반환하며 메소드를 종료한다.
        return false;
    }
    //매개변수로 전달받은 Element값, 즉 맵의 키(Key)에 해당하는 값을 통해서 elements가 참조하는 HashMap의 get메소드를 이용하여 지정된 키의 값을 반환한다.
    public PeriodicElement get(Element e){
        //elements가 참조하는 HashMap의 get메소드를 이용한다.(물론 sort()호출 이후이면 elements가 참조한는 것은 TreeMap일 것이다. 둘 모두 get()의 동작내용은 동일하다.)
        //get()의 인자로 매개변수로 전달받은 Element값을 전달한다.
        //인자로 전달한 Element는 맵의 키 값에 해당하는데 지정된 키 값에 해당하는 값이 존재하면 이를 반환한다. 만약 키에 해당하는 값이 존재하지 않으면 null을 반환한다.
        //이를 return을 통해 반환하고 메소드를 종료한다.
        return elements.get(e);
    }

    //IndexOutOfBoundsException예외 발생여부가 있는 메소드 getRandomElmeent()이다.
    //throws를 통해 넘긴 예외는 이 메소드를 호출한 영역에서 처리하거나 throws를 통해 다시 또 넘긴다.
    //만약 main메소드에서도 예외를 throws를 통해 넘긱 되면 이 예외는 main을 호출한 VM에게 넘어가게되며 프로그램은 종료된다.
    //elements가 참조하는 맵에서 값 하나를 랜덤하게 하나 골라서 반환하는 메소드
    public PeriodicElement getRandomElement() throws IndexOutOfBoundsException{
        //Map<K,V>는 Iterable<T>인터페이스를 상속받지 않으므로 elements가 참조하는 HashMap<K,V>(또는 sort()호출이후에는 TreeMap<K,V>)는
        //for-each를 이용한, 혹은 Iterator(반복자)를 이용한 순차적 접근을 진행할 수 없다.
        //따라서 해당 맵의 모든 키값의 집합을 keySet()메소드를 통해 만들어준다.
        //elements가 참조하는 객체의 키는 Element형이므로 다음과 같이 Set<Element>형 참조변수를 통해 참조하도록한다.
        Set<Element> keys=elements.keySet();
        //elements.keySet()을 통해 elements가 참조하는 맵의 모든 키값의 집합을 반환하여주고 이를 Set<Element>형 참조변수로 참조한다.
        //이를 리스트의 형태로 변경하려고 하는데 이 때 호출되는 ArrayList<E>의 생성자는 다음과 같다.
        //public ArrayList(Collection<? extends E> c)
        //위의 ArrayList<E>의 생성자는 Collection<E>를 구현한 컬렉션 인스턴스를 인자로 전달받을 수 있고, E는 인스턴스 생성과정에서 결정되므로 무엇이든 될 수 있고,
        //매개변수로 전달된 컬렉션 인스턴스에서는 참조만(꺼내기만) 가능하도록(상한제한) 매개변수를 전달받지 않는 생성자와 함께 오버로딩되어있다.
        //다음의 문장을 통해서 keys가 참조하는 컬렉션 인스턴스가 저장하고 있던 Element인스턴스들을 새로운 컬렉션 인스턴스인 keyList가 참조하는 ArrayList에 모두 복사하면서 컬렉션 인스턴스를 생성한다.
        List<Element> keyList=new ArrayList<>(keys);
        //random이라는 이름의 int형 변수를 생성하면서 동시에 (int)(Math.random()*keyList.size())로 초기화한다.
        //Math클래스의 random()함수는 0이상 1미만 실수를 반환하는데 이를 keyList의 size()메소드를 통해 반환된 값과 곱한다.
        //즉 0이상 1미만의 실수에서 랜덤으로 반환되는 값과 keyList가 참조하는 ArrayList<Element>가 포함하는 요수의 개수를 곱한다.
        //그리고 이렇게 생성된 실수를 (int)를 통해 형변환을 한다.(이 때 소수점 이하의 값은 잘려나간다.)
        //따라서 만약 keyList가 참조하는 컬렉션인스턴스가 20개의 요소를 지니고 있었다고 하면
        //random에 저장되는 값은 0이상 20미만의 랜덤한 정수 하나이다.
        int random=(int)(Math.random()*keyList.size());
        //keyList의 get메소드의 인자로 random을 전달시 만약 keyList에 아무런 원소도 없으면 random은 0이될텐데
        //아무런 원소도 없는 ArrayList에 대해서 인덱스 0번의 원소를 get()을 통해 접근하는 것은 IndexOutOfBoundsException을 일으킨다.
        //만약 정상적이라면 get()메소드의 인자로 전달한 random에 해당하는 인덱스의 요소를 반환하여준다.
        Element element = keyList.get(random);
        //elements가 참조하는 HashMap<Element,PeriodicElement>(sort호출 이후라면 TreeMap객체)객체의 get의 인자로 앞서 랜덤하게 고르게된 키에 해당하는 Element을 전달한다.
        //따라서 키에 해당하는 값(Value)을 return을 통해 반환하면서 메소드 호출을 종료하게 된다.
        return elements.get(element);
    }
    //PeriodicTableMap클래스의 인스턴스 변수 elements가 참조하는 맵에 포함된 요소의 개수를 반환하는 메소드
    public int size(){
        //인스턴스 변수 Map<Elmeent,PeriodicElement> elements가 참조하는 맵에 포함된 요소의 개수를 HashMap(or TreeMap)의 size()메소드를 통해 알아내고
        //이를 return을 통해서 반환하며 메소드를 종료한다.
        return elements.size();
    }

    //다음 2개의 find메소드는 매개변수만이 find(Elmeent e), find(String symbol)로 다르고
    //메소드 이름과 반환형이 모두 동일한 오버로딩 관계이다.
    //List<PeriodicElement> find(IPeriodicElementFinder finder)는 위의 두 메소드와 오버로딩 관계가 성립하지 않는다.

    //매개변수로 전달된 Element에 해당하는 PeriodicElement를 찾아 반환한다.
    public PeriodicElement find(Element e) throws NullPointerException{
        //elements가 참조하는 HashMap<Element,PeriodicElement>(sort()호출 이후에는 TreeMap)은 '키'와'값'의 쌍으로 이루는 데이터 저장 방식이다.
        //그리고 여기서 '키'가 '값'을 찾는 지표와도 같다. 이 때 키로는 Element형 값을 사용하고 값(Value)로는 PeriodicElement형 값을 사용한다.
        //맵에서 매개변수를 통해 전달받은 Element를 이용하여 해당하는 PeriodicElement를 찾는 메소드인 find()에서
        //다음과 같이 elements.get()의 인자로 매개변수를 통해 전달받은 Element를 전달하여 키에 해당하는 값을 return을 통해 반환하여 주면 된다.(키에 해당하는 값이 없으면 get은 null반환)
        //즉 매개변수로 전달받은 Element에 해당하는 Value가 있으면 이를 반환하게 되고 없으면 null을 반환하게 된다.
        return elements.get(e);
    }

    //HashMap에서 매개변수로 전달된 문자열(String) symbol과 동일한 요소(PeriodicElement)를 찾아서 반환한다.
    public PeriodicElement find(String symbol){
        //Map<K,V>는 Iterable<T>인터페이스를 상속받지 않으므로 elements가 참조하는 HashMap<K,V>(또는 sort()호출이후에는 TreeMap<K,V>)는
        //for-each를 이용한, 혹은 Iterator(반복자)를 이용한 순차적 접근을 진행할 수 없다.
        //따라서 해당 맵의 모든 키값의 집합을 keySet()메소드를 통해 만들어준다.
        //elements가 참조하는 객체의 키는 Element형이므로 다음과 같이 Set<Element>형 참조변수를 통해 참조하도록한다.
        Set<Element> keys=elements.keySet();
        //앞서 생성한 맵의 모든 키값들의 집합인 keys를 이용하여 Iterator(반복자)를 생성한다.
        //(Set<E>은 Collection<E>을 상속하고 Collections<E>는 Iterable<T>를 상속한다.
        //Iterable<T>인터페이스에는 Iterator<T>를 반환하는 iterator()라는 추상메소드가 존재한다.)
        Iterator<Element> itr=keys.iterator();
        //이를 통해 모든 키값들에 대해서 순차적으로 접근한다.
        //itr.hasNext()가 참인 동안 while()문을 반복한다.(hasNext()는 next호출시 반환 가능 여부에 따라 true or false를 반환)
        while(itr.hasNext()){
            //itr.next()를 통해 다음 인스턴스의 참조값을 반환하고 이를 key라는 참조변수로 참조한다.
            Element key=itr.next();
            //elements.get(key)를 통해 elements가 참조하는 맵에서 인자로 전달된 key에 해당하는 값(value)을 얻고
            //그렇게 얻은 Value(PeriodicElement)에 대해서 getSymbol()메소드를 호출하여 반환되는 문자열과 매개변수로 전달된 symbol이 같은지 equals()를 통해 비교한다.
            //만약 두 문자열이 같다면 if문은 참이되어 if문 내부가 실행될 것이고 그렇지 않다면 if문은 false가 될 것이다.
            if(elements.get(key).getSymbol().equals(symbol)){
                //이전에 얻은 key를 get메소드의 인자로 전달하여 인자로 전달한 키 값에 해당하는 값(value)(PeriodicElement)를 반환하고 메소드를 종료한다.
                return elements.get(key);
            }
        }
        //반복자(Iterator)를 통한 반복을 진행하는 동안 if문이 참이되지 않아 if문 내부의 return문이 실행되지 않았다면 다음의 return문이 실행되어 null을 반환할 것이다.
        return null;
    }

    //HashMap에서 매개변수로 전달된 IPeriodicElementFinder를 통해 조건을 만족하는 요소를 모아 List<PeriodicElement>형태로 반환한다.
    //매개변수로 전달되는 IPeriodicElemenetFinder finder가 null일 수도 있고 이를 통한 isInstanceOf()호출은 NullPointerException을 일으킨다.
    //따라서 이 메소드를 호출한 영역으로 throws를 통해 예외를 넘기고 이를 호출한 영역에서 try-catch구문을 통해서 적절히 예외를 처리하도록 하였다.
    public List<PeriodicElement> find(IPeriodicElementFinder finder) throws NullPointerException{
        //finder를 통한 조건을 만족하는 요소들을 모으기 위해 PeriodicElement인스턴스를 저장하는 ArrayList<PeriodicElement>컬렉션인스턴스를 생성하고
        //List<E>형 참조변수 list로 참조한다.
        List<PeriodicElement> list=new ArrayList<>();
        //elements가 참조하는 맵에서 모든 키값을 모은 집합(set)형태의 Set<Element>를 keySet()메소드(반환형이 Set<K>이다.)를 통해 반환하고
        //이를 keys로 참조한다.
        Set<Element> keys=elements.keySet();
        //앞서 생성한 맵의 모든 키값들의 집합인 keys를 이용하여 Iterator(반복자)를 생성한다.
        //(Set<E>은 Collection<E>을 상속하고 Collections<E>는 Iterable<T>를 상속한다.
        //Iterable<T>인터페이스에는 Iterator<T>를 반환하는 iterator()라는 추상메소드가 존재한다.)
        Iterator<Element> itr=keys.iterator();
        //반복자를 통해 모든 키값들(keys가 참조하는 집합)에 대해서 순차적으로 접근한다.
        //itr.hasNext()가 참인 동안 while()문을 반복한다.(hasNext()는 next호출시 반환 가능 여부에 따라 true or false를 반환)
        while(itr.hasNext()){
            //itr.next()를 통해 다음 인스턴스의 참조값을 반환하고 이를 key라는 참조변수로 참조한다.
            Element key=itr.next();
            //element.get(key)를 통해 인자로 전달된 key에 해당하는 값(Value)를 반환하고 이를
            //매개변수finder의 isInstanceOf메소드의 인자로 전달한다.
            //만약 참이라면 if문 내부가 실행될 것이고 거짓(false)라면 if문 내부는 실행되지 않을 것이다.
            if(finder.isInstanceOf(elements.get(key))){
                //element.get(key)가 finder의 isInstanceOf를 참으로 만들면
                //list.add()메소드의 인자로 elements.get(key)로 전달(get메소드는 key값에 해당하는 Value를 반환한다.)하여 ArrayList의 맨 뒤에 추가한다.
                list.add(elements.get(key));
            }
        }
        //list가 참조하는 인스턴스를 반환하면서 메소드를 종료한다.
        return list;
    }

    //elements가 참조하는 맵을 정렬하는 메소드
    public void sort(){
        //elements가 참조하는 객체를 HashMap에서 TreeMap으로 변경하여주면서 기존의 elements가 참조하고 있던 인스턴스를 생성자로 전달하여 내용을 모두 복사하고있다.
        //다음에서 호출하고 있는 TreeMap의 생성자는 다음과 같다.
        /*
        public TreeMap(Map<? extends K, ? extends V> m) {
            comparator = null;
            putAll(m);
        }
        생성자의 매개변수 형이 Map<? extends K, ? extends V> m 인데 즉, Map<K,V>를 구현하는 구상객체가 전달될 수 있고, 이 때 K,V는 전달되는 인스턴스와 동일하므로
        여기서는 각각 Element,PeriodicElement가 된다. 또한 K,V 모두에 대해서 와일드카드를 이용하여 ? extends와 같이 상한 제한을 걸고 있다.
        따라서 K,V에 대해서 참조만(꺼내는 작업,get) 가능하다.
        실제로 생성자의 인자로 전달된 기존의 elements가 참조하던 맵객체의 저장데이터에 대해서 참조를 하여 데이터를 복사하고 이를 새로운 TreeMap으로 만들어 다시 elements변수가 참조하고 있다.
         */
        //해쉬 알고리즘, 해쉬 함수를 이용하여 데이터를 저장하고 검색하는 HashMap은 기본적으로 정렬을 지원하지 않는다.
        //따라서 이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 젖아하는 TreeMap으로의 변경이 요구된다.
        //TreeMap은 트리라는 자료구조를 기반으로 인스턴스를 저장하므로 정렬된 상태가 유지되면서 인스턴스가 저장된다.
        //따라서 다음과 같이 elements가 참조하는 객체를 HashMap->TreeMap으로 변경하여주는 것만으로도 맵의 내용이 정렬되는 것이다.
        //이 때 정렬의 기준은 맵이 저장하고 있는 키(key)인스턴스를 기준으로 정렬한다.
        //(Element는 열거형으로 Enum추상클래스를 상속받는데 Enum은 다음과 같이 Comparable을 implements하고
        //abstract class Enum<E extends Enum<E>> implements Comparable<E>
        //compareTo메소드를 다음과 같이 구현하고 있다.
        //(compareTo의 앞부분은 생략하고 다음만 보이겠다.)
        //return self.ordinal - other.ordinal;
        //따라서 이를 기준으로 키(Element)를 정렬하게 된다.
        elements=new TreeMap<>(elements);

        //다음과 같이 정렬하는 것도 하나의 방법이다.
        /*
        List<PeriodicElement> list=new ArrayList<>(elements.values());
        Collections.sort(list);
        elements=new LinkedHashMap<>();
        for(PeriodicElement e: list){
            elements.put(e.getElement(),e);
        }
        */
    }

    //맵의 Key와 Value 모두를 출력하는 메소드
    public void print(){
        //elements가 참조하는 맵에서 모든 키값을 모은 집합(set)형태의 Set<Element>를 keySet()메소드(반환형이 Set<K>이다.)를 통해 반환하고
        //이를 keys로 참조한다.
        Set<Element> keys=elements.keySet();
        //for-each문을 통해서 set의 모든 요소를 순차적으로 접근하면서 각각의 원소를 e라는 이름의 Element변수가 참조하게된다.
        //참고로 for-each문을 통한 순차적 접근의 대상이 되려면, 해당 컬렉션 클래스는 public interface Iterable<T>를 구현해야 하는데,
        //맵의 모든 키의 집합에 대한 인스턴스를 참조하는 set참조변수는 Set<E>형 참조변수이고 Set<E>인터페이스는 Collection인터페이스가 상속하는 Iterable<T>인터페이스를 간접적으로 구현하고 있다.
        //따라서 for-each문을 통한 순차적 접근의 대상이 될 수 있다.
        //아래의 for-each문을 통해서 PeriodicTableMap의 인스턴스 변수 elements가 저장하고 있는 맵의 key,value쌍을 모두 출력한다.
        for(Element e: keys){
            System.out.println("----------------------------------------------------------------------------------------");
            //순차적으로 접근하면서 e를 출력한다.
            System.out.println("Element: "+e);
            //이 때, key값뿐만 아니라 Value에 해당하는 값도 함께 출력해야하기 때문에
            //해당 키값과 쌍을 이루는 Value에 해당하는 값을 get()을 통해서 얻고,이에 대해 PeriodicElement의 print()를 출렷한다.
            //(이 때 print()는 PeriodicElement의 구상클래스들에 따라서 서로 다르게 동작한다.(다형성))
            elements.get(e).print();
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

    //맵의 Key에 해당하는 값들만 출력하는 메소드
    public void printKeys(){
        //elements가 참조하는 맵에서 모든 키값을 모은 집합(set)형태의 Set<Element>를 keySet()메소드(반환형이 Set<K>이다.)를 통해 반환하고
        //이를 keys로 참조한다.
        Set<Element> keys=elements.keySet();
        //이를 System.out.println()의 인자로 전달하여 출력한다.
        //이 때 keys는 keys.toString()과 동일하다.
        //(println()의 인자로 인스턴스를 참조하는 참조변수 전달시 해당 인스턴스의 toString()을 호출로 연결된다.)
        System.out.println(keys.toString());
    }
    //맵의 Value에 해당하는 값들만 출력하는 메소드
    public void printValues(){
        //HashMap<K,V>을 참조하는 elements를 대상으로 values()를 호출하면
        //맵에 contain되어 있는 모든 value에 해당하는 값을 Colletion<V>형태로 반환하여 준다.
        //(HashMap에 저장된 모든 값을 컬렉션의 형태로 반환)
        //(sort()를 통해 elements가 참조하는 인스턴스가 TreeMap으로 변경된 경우에도 맵에 저장된 모든 값(value)를 컬렉션의 형태로 변환한다는 내용은 동일하다.)
        //이를 System.out.printlN()의 인자로 전달한다. 다음은 toString()의 호출로 이어지게 되고 모든 값(value)를 하나의 문자열로 출력하게된다.
        //물론 이와같은 방법이외에도 keySet()을 이용해 키의 집합을 얻고, 이를 for-each를 통해 순차적으로 접근하며 get()을 이용하여도 충분히 가능할 것이다.
        //하지만 이와같은 방법은 PeriodicTableMap의 print()메소드에서 등장하였으므로 여기서는 다음의 방법을 이용하도록 하였다.
        System.out.println(elements.values());
    }
}
