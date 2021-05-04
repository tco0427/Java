/*
Lab7
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/05/26
 */

//import문을 통하여 java.util패키지의 ArrayList클래스와 List인터페이를 import한다.
//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려준다.
//이를 통해 패키지 경로를 생략하고 클래스 이름만을 이용해서 사용할 수 있게 된다.
//static import문이라는 것도 존재하는데, static import문을 사용하면 static멤버(클래스 변수, 클래스 메소드)를 호출할 때 클래스의 이름을 생략할 수 있다.
//다음과 같이 import static 패키지.클래스.static멤버 형태로 사용한다.
//import static java.lang.Integer.*;
import java.util.List;
import java.util.ArrayList;

//periodicElementFinder를 abstract키워드를 통해 추상클래스로 선언하였다.
//abstract키워드와 함께 메소드의 선언부만을 작성한 isInstanceOf()추상메소드를 가진다.
//추상클래스인 PeriodicElementFinder를 대상으로 한 인스턴스의 생성이 불가능하다.(물론 PeriodicElementFinder형 참조변수는 선언 가능하다.)
//이를 상속하여 오버라이딩을 통해 추상메소드를 모두 구현한 구상클래스(concrete class)를 대상으로만 인스턴스 생성이 가능하다.
public abstract class PeriodicElementFinder {
    //abstract키워드와 함께 메소드의 선언부(구현부제외)만을 작성하였다.
    //추상메소드에 대해서는 'private'접근지정자 선언이 불가능하다.(서브클래스에서 오버라이딩을 통해 반드시 구현되어야 하기 때문이다.)(private는 하위클래스에서 접근할 수 없고 따라서 오버라이딩을 할 수 없다.)
    //여기서는 하위클래스에서 이를 오버라이딩하고 또 내부의 메소드인 find에서만 isInstanceOf()를 사용하기 때문에 protected로 하는 것이 옳아보인다.
    //(ppt에는 public으로 되어있는데 이를 수정하였습니다. 만약 이후 업데이터에서 외부에서 isInstanceOf()를 활용하게 되더라도 이를 굳이 PeriodicElementFinder를 구현한 구상클래스의 인스턴스를 생성하여
    //쓰는 것보다는 단순히 instanceof 연산자를 활용하는 것이 더 적절해 보인다.)
    protected abstract boolean isInstanceOf(PeriodicElement pe);
    //하위클래스에서 find()을 오버라이딩하지 않으면 상위클래스인 PeriodicElmentFinder에 정의된 다음의 메소드를 그대로 상속받고 사용하게 된다.
    //모든 하위의 구상클래스에 대해서 공통적인 부분이라고 볼 수 있기 때문에 상위의 추상클래스에서 구현부를 작성해주었다.
    //(모든 하위 클래스에대해서 공통적인 부분을 굳이 각 구상클래스별로 따로 구현해줊 필요가 없으며 하위클래스에 대해서 공통적인 부분을 정의한 것이므로 이를 오버라이딩하여 재정의할 이유도 없다.)
    public PeriodicElement[] find(PeriodicElement[] elements){
        //PeriodicElement 인스턴스를 저장하는 ArrayList<PeriodicElement>컬렉션 인스턴스를 생성하고 이를 list라는 이름으로 참조한다.
        //다이아몬드 기호를 통한 타입 인자 생략(컴파일러가 참조변수 선언을 통해서 유추가 가능하다. 비공식적인 표현이긴 하지만 공식적인 표현으로 인식될만큼 널리 사용되는 방법)
        List<PeriodicElement> list=new ArrayList<>();
        //for-each문을 통해 elements가 참조하는 배열인스턴스에 대해서 전체 반복
        for(PeriodicElement e: elements){
            //isInstanceOf의 인자로 e를 전달하고 반환되는 값이 true이면
            //(이 때 isInstanceOf()의 동작은 어느 구상 객체를 통해서 find를 호출했느냐에 따라 달라진다(다형성))
            if(isInstanceOf(e)){
                //컬렉션 인스턴스를 참조하는 list에 해당 인스턴스(PeriodicElement) 저장
                //실제로 add의 인자로 전달된 인스턴스는 실제 저장되는 것이 아닌 인스턴스의 참조값이 저장된다.
                list.add(e);
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
        //다음의 대문자T(제네릭은 보통 한글자의 대문자로 표기한다.)는 제네릭이라고 하는것인데, 컴파일 시의 타입 체크를 해주어
        //타입 안정성을 제공하며, 타입체크와 형변환을 생략할 수 있어 코드를 간결하게 해준다.
        //다음과 같은 경우 타입매개변수(Type Parameter) T에 타입인자(Type Argument)로 PeriodicElement가 전달된다.
        //그리고 이후의 코드를 보면 자세한 내용은 모르더라도 첫번째 if문이 참이되지 않았을 경우(배열의 길이를 컬렉션의 길이로 맞추었으므로 if문은 false가 될것이다)
        //System클래스의 arraycopy()메소드에 의해서 elementData배열의 0부터 a배열의 0으로 size길이만큼 복사된다는 것을 알 수 있다.
        //(여기서 elementData는 ArrayList컬렉션 인스턴스 내부에
        //transient Object[] elementData; // non-private to simplify nested class access
        //위와 같이 정의된 인스턴스 변수로 볼 수 있는데 자바문서에서는
        /*
         * The array buffer into which the elements of the ArrayList are stored.
         * The capacity of the ArrayList is the length of this array buffer. Any
         * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
         * will be expanded to DEFAULT_CAPACITY when the first element is added.
         */
        //다음과 같이 설명하고 있다. ArrayList도 배열 기반의 자료구조라는 점(ArrayList도 내부적으로 배열로 구현되어 있다)을 알고있으면 이해가 가는 내용이다.)
        //즉, peArray에 컬렉션 인스턴스가 담고 있는 내용이 복사된다.
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
}
