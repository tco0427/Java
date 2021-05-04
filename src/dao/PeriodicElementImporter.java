/*
Lab8
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/06/07
 */

//다음의 클래스(PeriodicElementImporter)가 소속될 패키지 명을 다음과 같이 package키워드를 이용하여 소스파일의 첫 줄에 선언해주었다.
package dao;

//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려줌을 통해
//클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
//다음은 PeriodicElementImporter클래스에서 활용하는 다른 패키지의 클래스들을 import한 것이다.
import dto.PeriodicElement;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class PeriodicElementImporter {
    //이 클래스의 메소드는 모두 public과 static으로 선언되었다.(생성자 메소드 제외)
    //public으로 선언되었으므로 이 클래스 이외의 영역에서 모두 접근이 가능하며
    //static으로 선언되었으므로 인스턴스 생성과 무관하게 접근이 가능하다.
    //생성자에 대해서 private 접근 지정자를 통해 UserInput클래스 외부에서의 생성자호출을 제한하고 있다.
    //즉 PeriodicElementImporter클래스에 대해 인스턴스 생성이 불가능하다.
    //생성자에 private선언은 싱글톤 패턴에서 객체를 하나만 생성하여 어디서든 공용할 수 있도록 활용할 수 있다.(멀티쓰레드 환경을 고려하긴 해야함)
    //이와 같이 생성자를 private로 선언하고 이 클래스의 모든 메소드를 public static으로 정의하는 이유는
    //이 클래스는 인스턴스의 생성이 목적이 아니고 외부에 기능을 제공하기 위함이기 때문이다.
    private PeriodicElementImporter(){}

    /*
    스트림이란 "데이터의 흐름"(데이터의 이동통로)를 의미한다.
    '입력 스트림'은 데이터의 입력통로를 의미하고, '출력 스트림'은 데이터의 출력통로를 의미한다.
    그리고 여기서 말하는 입력, 출력의 주체는 '실행중인 자바 프로그램'이다.
    따라서 자바프로그램으로 데이터를 읽어들이는 경우를 가리켜 '입력'이라고 하고, 자바프로그램에서 데이터를 내보내는 경우를 '출력'이라 한다.
    다음의 loadCSV와 saveCSV는 파일을 대상으로 한 입출력 스트림을 생성한다.
    (자바에서는 입출력 대상에 관계없이 동일한 방법으로 입출력을 진행할 수 있도록 'I/O 스트림 모델'이라는 것을 정의한다.
    즉, 자바의 I/O 모델을 기반으로 데이터를 입출력할 경우, 그 대상에 상관없이 동일한 방법으로 데이터를 입출력할 수 있다.)
     */
    /*
    PeriodicElementImporter의 두 static메소드에서 FileReader,FileWriter와 같은 파일을 대상으로 한 문자 입출력 스트림을 이용하였다.
    자바에서는 모든 문자를 유니코드를 기준으로 표현한다. 그런데 운영체제의 문자표현 방식이(인코딩 방식이) 자바의 문자 표현방식과 다르다.(운영체제의 문자 표현방식은 OS별로 다르다.)
    따라서 유니코드로 표현된 문자를 해당 운영체제의 문자 표현 방식으로 바꾸어서 저장하는 작업이 이루어져야 '메모장'과 같은 프로그램을 통해 제대로된 문자가 저장이 된다.
    위와 같은 작업을 프로그래머가 직접 하기엔 부담이 많이 되기 때문에 자바에서는 운영체제의 문자표현방식의 맞춰서 유니코드로 표현된 문자를 알아서 변환하여주는 '문자 출력 스트림'을 지원한다.
    반대로 운영체제상에서 만든 텍스트 파일(메모장과 같은 프로그램)을 통해 원하는 내용을 담고, 이렇게 만들어진 파일에 저장된 문자들을 자바프로그램으로 읽어 들이려면 유니코드로의 인코딩 변화가 필요하다.
    그러므로 이 경우에도 '문자 입력 스트림'을 이용하였다.
     */
    //static으로 정의된 메소드이다.
    public static List<PeriodicElement> loadCSV(String filename){
        //List<PeriodicElement>형 참조변수를 선언하면서 LinkedList<>인스턴스를 생성하면서 이를 참조하도록하였다.
        //여기서 ArrayList가 아닌 LinkedList를 사용한 이유는 ArrayList는 배열기반이기 때문에 저장공간을 늘리는 과정에서 시간이 많이 소요된다.(배열교체)
        //반면 LinkedList는 저장공간을 늘리는 과정이 간단하고 빠르다.
        //이 경우 약 118개의 원소를 add할 것이기 때문에 저장공간을 수시로 늘려주어야 한다. 따라서 LinkedList를 활용하였다.
        List<PeriodicElement> list=new LinkedList<>();

        //try-with-resources문을 이용하였다.
        //try에 이어 등장하는 소괄호 안에 종료의 과정(close())를 필요로하는 resource를 생성한다.
        //이를 통해 bufferedReader가 참조하는 인스턴스의 종료는 신경쓰지 않아도 된다.
        //예외가 발생하건 안하건 bufferedReader를 대상으로 한 다음 메소드의 호출은 보장된다.(bufferedReader.close();)
        //(try-with-resources문에 의해 자동으로 종료되어야 할 리소스 관련 클래스는 AutCloseable인터페이스를 구현하고 있어야한다.
        //BufferedReader클래스는 AutoCloseable인터페이스의 다음의 추상메소드 'void close() throws Exception'을 구현하고 있다.)
        //(참고로 java.io패키지의 클래스들은 많은 부분이 '데코레이터 패턴'을 바탕으로 만들어 졌다. 대표적으로 다음과 같은 BufferedReader,FileReader와 같은 클래스가 있다.)
        try(BufferedReader bufferedReader=
                new BufferedReader(new FileReader(filename))){
            //한줄의 라인을 파일로부터 읽어올 것이고 이를 저장하기 위해 문자열(String) line을 선언하면서 ""로 초기화한다.
            String line="";
            //while()문을 통해 파일로부터 문자스트림을 입력받는다.
            //readLine()은 파일로부터 문자열 단위로 입력을 받고 반환할 문자열이 없으면 null을 반환한다.(BufferdReader의 메소드)
            //(이 때, 공백을 기준으로 문자열을 구분하고 공백을 제외한 문자열을 입력받는다.)
            while((line=bufferedReader.readLine())!=null){
                //파일로 부터 읽어들인 문자열을 split()메소드를 통해 인자로 전달된 기준(",")을 근거로 문자열을 나누고 나뉜 문자열을 배열에 담아서 반환한다.
                //이를 fields라는 String[]형 참조변수로 참조한다.(public String[] split(String regex))
                String[] fields=line.split(",");
                //이렇게 나눈 문자열을 담은 문자열 배열을 PeriodicElement에 static으로 정의된 parse메소드의 인자로 전달한다.
                //parse()메소드가 반환하는 PeriodicElement인스턴스를 PeriodicElement형 참조변수 peBuffer로 참조한다.
                PeriodicElement peBuffer=PeriodicElement.parse(fields);
                //list가 참조하는 LinkedList<PeriodicElement>인스턴스 맨뒤에 add()메소드의 인자로 전달된 peBuffer를 추가한다.
                //이 때, 실제로 저장되는 것은 add()메소드의 인자로 전달된 인스턴스의 참조값이다.
                //(parse()가 null을 반환할 가능성이 있으므로 이를 검사하여 null이 아닌 경우에 추가해주도록 한다.)
                if(peBuffer!=null)
                    list.add(peBuffer);
            }
        /*
        입출력처리의 실패 or 인터럽트의 생에 의해 작성되는 예외의 일반적인 클래발
        입출력관련 스트림을 생성하는 과정에서 파일의 경로명이 제대로 되지 않은 경우에 FileNotFoundException이 발생한다.
        또 파일 읽기, 쓰기, 닫기를 하는 동안에도 IOException예외가 발생할 수 있다.
        따라서 다음과 같이 catch구문에서 예외를 처리하여주도록 한다. 이 때 FileNotFoundException은 IOException을 상속하므로
        다음과 같이 IOException을 처리하는 catch블록 하나만 있어도 무관하다.
        또 IOException은 Exception을 상속하면서 RuntimeException은 상속하지 않는 예외클래스이다.
        Exception을 상속하는 예외는 예외를 반드시 처리하거나 throws를 통해 메소드를 호출한 영역으로 넘긴다고 명시하여야 한다.
        그렇지 않으면 컴파일 오류가 발생한다.(컴파일 체크 Exception)
        */
        }catch(IOException e){
            //IOException발생시 이를 사용자에게 알린고 null을 반환하여 준다.
            //Lab8의 main에서 null을 검사하여 파일을 읽어들이는 과정이 실패하면 프로그램을 종료하도록 할 것이다.
            System.out.println("파일을 읽어들이는 과정에 오류가 있습니다.");
            return null;
        }

        //catch문으로 프로그램실행흐름이 넘어가지 않았다면 return을 통해 종료되지않고 다음 문장까지 흐름이 이어지게된다.
        //이 경우 정상적으로 파일로부터 데이터를 읽어들인 경우가 되므로 이를 사용자에게 알린다.
        System.out.println(filename+"으로부터 데이터를 읽어들이는 데 성공하였습니다!");
        //list가 참조하는 인스턴스를 반환한다.
        return list;
    }
    public static void saveSCV(String path,List<PeriodicElement> elements){
        //결함이 있던 java.io패키지의 File클래스를 대체하기 위해 정의된 java.nio.file.Path인터페이스를 참조변수 형으로 선언하였다.
        //이는 경로를 표현하기 위한 인터페이스인데, 다음 문장과 같이 Paths.get()메소드가 반환하는 '경로정보를 담은 인스턴스'를 참조하는 참조변수 선언에 사용된다.
        //여기서는 굳이 이렇게 하지 않아도 되겠지만 path(경로)라는 의미를 강하게 해주기 위해 다음과 같이 Paths와 Path를 활용하였다.
        //(해당 메소드, 해당 프로그램에서는 파일,디렉토리에 대한 조작을 하지 않기 때문에 불필요하긴 하다.)
        Path filepath= Paths.get(path);
        //loadSCV메소드와 마찬가지로 try-with-resources문을 활용하여 자동으로 close()호출을 처리하도록 한다.
        //saveSCV인자로 전달된 파일의 경로와 이름에 .csv(파일 확장자)를 더해준다(concat).
        try(BufferedWriter bufferedWriter=
                new BufferedWriter(new FileWriter(filepath+".csv"))){
            //Collection<E>는 Iterable<T>를 상속한다. 따라서 Collection<E>를 구현하는 제네릭클래스는 Iterable<T>의 iterator()추상메소드를 구현한다.
            //elements가 참조하는 인스턴스는 Collection을 상속하는 컬렉션 인스턴스이므로 iterator()를 통해 반복자(Iterator)를 생성가능하다.
            //elements.iterator()를 통해 Iterator<PeriodicElement>(반복자)를 생성한다.
            //그리고 itr.hasNext()를 이용하여 next메소드 호출 시 참조 값 반환 가능 여부를 확인하여 반복을 계속할지를 결정하도록한다.
            //반복자(iterator)를 활용하여 순차적으로 컬렉션 인스턴스의 내용에 접근한다.
            for(Iterator<PeriodicElement> itr = elements.iterator();itr.hasNext();){
                //itr.next()를 통해 다음 인스턴스의 참조값을 반환하고 이를 pe(PeriodicElement형 참조변수)로 참조하도록 한다.
                PeriodicElement pe=itr.next();
                //bufferedWriter의 write메소드를 통해 인자로 전달되는 내용을 파일에 쓴다.
                //이 때 pe.toString()을 통해 pe가 참조하는 인스턴스의 클래스에서 오버라이딩한 toString()내용대로 문자열이 반환될 것이고,
                //여기에 newLine()을 통해서(BufferedWriter의 메소드) 운영체제에서 정의하는 줄 바꿈 문자를 삽입하여 준다.
                bufferedWriter.write(pe.toString());
                bufferedWriter.newLine();
                //여기에 newLine()을 사용하지 않더라도 다음과 같이 "\n"을 통해 줄넘김 문자를 포함하여 주어도 된다.
                //bufferedWriter.write(pe.toString()+"\n");
            }
        //파일 출력 과정에서 IOException발생시 catch구문을 통해 예외를 처리하여준다.
        }catch(IOException e){
            //사용자에게 파일 처리 과정에 문제가 있음을 알린다.
            System.out.println("파일을 쓰는 과정에 오류가 있습니다.");
            //return을 통해 메소드 호출을 종료한다.
            return;
        }
        //catch문의 return을 통해 메소드 호출이 종료되지 않았다면 파일에 데이터를 성공적으로 출력하였다는 것이고, 따라서 이를 사용자에게 알린다.
        System.out.println("파일에 데이터를 쓰는데 성공하였습니다.");
    }
}
