/*
Lab8
과목명(분반): 자바프로그래밍1(2분반)
교수명: 박경신 교수님
학번: 32180472
학과: 컴퓨터공학과
이름: 김동규
제출일: 2020/06/07
 */

//다음의 클래스(Lab8)가 소속될 패키지 명을 다음과 같이 package키워드를 이용하여 소스파일의 첫 줄에 선언해주었다.
package controller;

//import문은 다른 패키지의 클래스를 사용할 때, 컴파일러에게 그 클래스의 경로명을 알려줌을 통해
//클래스 사용시 패키지선언을 생략하고 사용할 수 있다.
//이 때 서로 다른 패키지의 동일한 이름의 클래스를 대상으로 동시에 import하는 것은 불가능하며, 디폴트패키지를 import할수도 없다.(컴파일 에러) 왜냐하면 default package는 어나니머스, 즉 이름이 없는 패키지이기 때문이다.
//다음은 Lab8클래스에서 활용하는 다른 패키지의 클래스들을 import한 것이다.
import dao.PeriodicElementImporter;
import dao.PeriodicTable;
import dao.PeriodicTableList;
import dto.PeriodicElement;
import dto.State;
import dto.Type;
import java.util.*;
import java.util.function.Predicate;

//main메소드를 가지고 있는 클래스
//실제 프로그램의 실행흐름을 담당
//실행흐름제어(컨트롤)
//public으로 선언되었으므로 외부패키지에서도 접근이 가능하다.(모든 영역에서 접근이 가능하다)
//public으로 선언된 클래스의 이름은 소스파일(.java)의 이름과 동일해야한다.
public class Lab8 {
    /*
        프로그램의 시작지점(Starting Point) main메소드이다.
        자바 프로그램은 main()메소드를 가지는 클래스가® 반드시 하나는 존재해야하며
        public static void로 선언되어있으므로 반환형이 없고(void),
        인스턴스 생성 이전에 클래스 로딩시에 바인딩되어 정적으로(static)메소드 호출이 가능하며
        다른 패키지에서도 접근이 가능하다(public)(main메소드의 호출이 이뤄지는 영역은 클래스 외부이다.)
     */
    public static void main(String[] args) {
        //File Input stream을 이용하여 파일로부터 데이터를 읽어들일 것이다.
        //따라서 대상이 되는 파일의 이름을 리터럴문자열로 생성하고 이를 source로 참조한다.
        String source="ptable.csv";
        //PeriodicElementImporter클래스에 static으로 정의된 loadCSV의 인자로
        //이전에 먼저 선언및 초기화한 source를 전달한다.(읽어들일 대상이 되는 파일이름을 전달한다.)
        //loadCSV내부에서는 다음곽 같이 스트림을 생성한다.
        //BufferedReader bufferedReader=new BufferedReader(new FileReader(filename))
        //이렇게 경로명을 제외하고 파일이름만을 전달하는 경우 대상 파일은 현재 프로그램이 실행되는 프로그램의 작업 디렉토리에 있어야한다.
        //loadCSV를 통해 파일로 데이터를 읽어들이고 반환되는 내용을 리스트형태로 담는다.
        //이를 baseList라는 List<PeriodicElement>형 참조변수로 참조한다.
        List<PeriodicElement> baseList=PeriodicElementImporter.loadCSV(source);
        //loadCSV에서 반환하는 값이 null인 경우에 이는 정상적인 파일 로드가 되지 않았다는 것이다.
        //따라서 이를 검사하고 만약 baseList가 null이면(즉, loadCSV가 반환하는 값이 null이면)프로그램을 종료한다.
        if(baseList==null){
            System.out.println("프로그램을 종료합니다.");
            //return을 통해 main메소드를 종료한다.
            return;
        }

        //baseList의 내용을 배열의 형태로 변환해주기 위한 다음의 작업이다.
        //baseList가 참조하는 인스턴스가 포함하는 요소의 개수를 baseList.size()를 통해 반환한다.
        //즉 baseList가 참조하는 인스턴스가 포함하는 요소의 개수만큼의 크기를 가지는 PeridoicElement배열을 생성하고
        //이를 baseArray라는 참조변수로 참조한다.
        PeriodicElement[] baseArray=new PeriodicElement[baseList.size()];
        //이 배열에 대한 래퍼런스를 가지는 래퍼런스 변수를 toArray의 인자로 전달하여준다.
        //컬렉션인스턴스 내용이 baseArray배열로 복사된다.
        baseList.toArray(baseArray);

        //앞서 생성한 baseArray와 baseList가 참조하는 인스턴스들을 각각 PeriodicTable과 PeriodicTableList의 생성자로 전달하면서
        //해당 내용을 바탕으로 한 PeriodicTable인스턴스와 PeridoicTableList인스턴스를 생성하고 이를 ptable,plist라는 이름의 참조변수로 참조한다.
        //ptable은 배열형태인 baseArray를 통해서, plist는 리스트형태인 baseList를 통해서..
        PeriodicTable ptable=new PeriodicTable(baseArray);
        PeriodicTableList plist=new PeriodicTableList(baseList);



        System.out.println("파일로부터 읽어들인 내용을 랜덤하게 섞습니다.");
        try {
            //ptable,plist의 메소드 shuffle()을 통해서 ptable과 plist가 참조하는 PeriodicTable,PeriodicTableList내부의 인스턴스변수 elements가 참조하는 배열,리스의 내용을 랜덤하게 섞는다.
            //이 때 shuffle메소드에서 UnssupportedOperationException예외가 발생할 수 있고, 이를 throws를 통해 넘기므로
            //이를 사용하는 다음의 문장을 try-catch구문을 통해 예외 처리를 하여주도록한다.
            ptable.shuffle();
            plist.shuffle();
        }catch(UnsupportedOperationException e){
            //만약 shuffle()호출에서 UnsupportedOperationException예외가 발생하게 되면 UnsupportedOperationException클래스의 인스턴스가 생성되고 이는 catch구문의 매개변수 e로 전달된다.
            //catch문에서는 다음을 통해 사용자에게 예외가 발생하여 정상적인 동작을 하는데 실패하였음을 알린다.
            //이렇게 catch문으로 프로그램의 실행흐름이 넘어오게되면(catch구문 안에서 무엇을 하든 상관없이) 가상머신은 예외가 처리된 것으로 판단하고 프로그램의 실행흐름을 이어나간다.
            System.out.println("파일로부터 읽어들인 내용을 랜덤하게 섞는데 실패하였습니다.");
        }

        System.out.println("--------------------랜덤하게 섞인 ptable의 내용 출력--------------------");
        //배열에 저장된 내용이 제대로 섞였는지 확인하기 위해 ptable.print()를 호출하여 확인한다.
        ptable.print();


        //사용자에게 해당 내용을 파일로 저장할 것인지 묻는다.
        System.out.println("해당 내용을 파일로 저장하시겠습니까?(.csv)");
        System.out.print("Y/N >>");
        //UserInput의 static메소드 getString()을 통해 문자열을 입력받는다.
        //이를 String형 input참조변수로 참조한다.(선언과 초기화 동시에)
        String input=UserInput.getString();
        //toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
        //이렇게 변환한 String에 equals()를 호출하여 "Y"와 같은지 비교한다. 만약 둘이 동일한 내용이라면 if문은 참이된다.
        if(input.toUpperCase().equals("Y")){
            //사용자에게 '파일의 확장자'를 제외한 파일의 이름을 입력받는다.
            //물론 파일의 경로를 파일의 이름과 함께 전달하여도 무관하다.(경로를 함께 제시하면 해당 경로에 파일이 저장될 것이다.(정상적으로 파일출력이 되면))
            System.out.println("저장할 파일의 이름을 입력하시오.(파일의 확장자 제외)");
            System.out.println("저장할 파일의 경로를 함께 입력하시면 해당 경로에 파일을 생성합니다.");
            System.out.print(">>");
            //사용자로부터 경로를 입력받는다.(UserInput의 static메소드 getString()을 이용하여)
            String path=UserInput.getString();
            //PeriodicElementImporter클래스의 static메소드 saveSCV를 호출한다.
            //인자로 이전에 입력받은 파일의이름(+경로)와 ptable을 전달한다.
            //(이때 saveSCV의 매개변수 형식이 List<PeriodicElement>이므로 getList()를 통해 List<PeriodicElement>형태로 변환하여준다.(List<PeriodicElement>로 참조가능한 형태))
            PeriodicElementImporter.saveSCV(path,ptable.getList());
            //toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
            //이렇게 변환한 String에 equals()를 호출하여 "N"와 같은지 비교한다.
        }else if(input.toUpperCase().equals("N")){
            //만약 N과 같다면 다음을 출력한다.
            System.out.println("파일로 저장하지 않습니다.");
        }else{
            //앞선 조건식을 모두 만족하지 않으면 다음 문장을 실행한다.
            System.out.println("잘못된 입력입니다. 파일로 저장하지 않습니다.");
        }
        System.out.println();

        System.out.println("--------------------랜덤하게 섞인 plist의 내용 출력--------------------");
        //리스트에 저장된 내용이 제대로 섞였는지 확인하기 위해 plist.print()를 호출하여 확인한다.
        plist.print();

        //사용자에게 해당 내용을 파일로 저장할 것인지 묻는다.
        System.out.println("해당 내용을 파일로 저장하시겠습니까?(.csv)");
        System.out.print("Y/N >>");
        //UserInput의 static메소드 getString()을 통해 문자열을 입력받는다.
        //이를 이전에 선언한 String형 input참조변수를 이용하여 참조한다.
        input=UserInput.getString();
        //toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
        //이렇게 변환한 String에 equals()를 호출하여 "Y"와 같은지 비교한다. 만약 둘이 동일한 내용이라면 if문은 참이된다.
        if(input.toUpperCase().equals("Y")){
            //사용자에게 '파일의 확장자'를 제외한 파일의 이름을 입력받는다.
            //물론 파일의 경로를 파일의 이름과 함께 전달하여도 무관하다.(경로를 함께 제시하면 해당 경로에 파일이 저장될 것이다.(정상적으로 파일출력이 되면))
            System.out.println("저장할 파일의 이름을 입력하시오.(파일의 확장자 제외)");
            System.out.println("저장할 파일의 경로를 함께 입력하시면 해당 경로에 파일을 생성합니다.");
            System.out.print(">>");
            //사용자로부터 경로를 입력받는다.(UserInput의 static메소드 getString()을 이용하여)
            String path=UserInput.getString();
            //PeriodicElementImporter클래스의 static메소드 saveSCV를 호출한다.
            //인자로 이전에 입력받은 파일의이름(+경로)와 plist를 전달한다.
            //(이때 saveSCV의 매개변수 형식이 List<PeriodicElement>이므로 getList()를 통해 List<PeriodicElement>형태로 변환하여준다.(List<PeriodicElement>로 참조가능한 형태))
            PeriodicElementImporter.saveSCV(path,plist.getList());
            //toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
            //이렇게 변환한 String에 equals()를 호출하여 "N"와 같은지 비교한다.
        }else if(input.toUpperCase().equals("N")){
            //만약 N과 같다면 다음을 출력한다.
            System.out.println("파일로 저장하지 않습니다.");
        }else{
            //앞선 조건식을 모두 만족하지 않으면 다음 문장을 실행한다.
            System.out.println("잘못된 입력입니다. 파일로 저장하지 않습니다.");
        }
        System.out.println();


        //앞서 랜덤하게 섞었던 plist의 내용을 정렬할 것임을 사용자에게 알린다.
        System.out.println("앞서 shuffle하였던 plist의 정보를 정렬합니다.");
        do{
            //PeriodicElement의 어떤 정보를 기준으로 정렬할 것인지 선택하게끔한다.(사용자에게 묻는다.)
            System.out.println("어떤 정보를 기준으로 정렬할지 선택하시오.");
            System.out.println("Mode 1.sort by number");
            System.out.println("Mode 2.sort by symbol");
            System.out.println("Mode 3.sort by name");
            System.out.println("Mode 4.sort by weight");
            System.out.println("Mode 5.sort by period");
            System.out.println("Mode 6.sort by group");
            System.out.println("Mode 7.sort by type");
            System.out.println("Mode 8.sort by state");
            System.out.print("Enter the mode number>>");
            //사용자로부터 어떤 모드로 정렬할 것인지 UserInput클래스의 getInteger()를 통해서 입력받는다.
            int modeNumber = UserInput.getInteger();
            //다중 if-else문을 통해 modeNumber가 저장하고 있는 정수값에 따라 실행흐름을 나눈다.
            //plist.sort()의 인자로 Comparator<PeriodicElement>를 구현한 인스턴스를 전달하고 있는데
            //해당 인스턴스에서 구현한 compare()메소드의 내용을 기반으로 정렬이 진행된다.
            if(modeNumber==1){
                //plist가 참조하는 PeriodicTableList인스턴스의 sort()메소드를 호출한다.
                //이 때 sort()는 인자를 받지 않는 메소드와 Comparator<PeriodicElement>를 구현한 인스턴스를 전달받는 두가지로 오버로딩되어있다.
                //다음은 인자를 전달하므로 Comparator<PeriodicElement>를 구현한 인스턴스를 전달하여야한다.
                //Comparator<PeriodicElement>는 함수형 인터페이스(Functional Interface)로 default,static을 제외한 추상메소드를 하나만 가진다.
                //따라서 이를 기반으로 람다식 작성이 가능하며 다음은 인자로 람다식을 작성하여 전달하고 있다.
                //(람다식을 통해 작성하는 추상메소드의 몸체에 해당하는 내용이 reeturn문 하나이면, 즉 return문이 메소드 몸체를 이루는 유일한 문장이면
                //아래와 같이 {}중괄호와 return을 함께 생략할 수 있다.
                plist.sort(((o1, o2) -> o1.getNumber()-o2.getNumber()));
            }else if(modeNumber==2){
                //PeirodicElement의 static메소드 symbolComparator()가 반환하는 Comparator<PeriodicElement>를 구현한 인스턴스를 인자로 전달하고 있다.
                plist.sort(PeriodicElement.symbolComparator());
            }else if(modeNumber==3){
                //PeirodicElement의 static메소드 nameComparator()가 반환하는 Comparator<PeriodicElement>를 구현한 인스턴스를 인자로 전달하고 있다.
                plist.sort(PeriodicElement.nameComparator());
            }else if(modeNumber==4){
                //PeirodicElement의 static메소드 weightComparator()가 반환하는 Comparator<PeriodicElement>를 구현한 인스턴스를 인자로 전달하고 있다.
                plist.sort(PeriodicElement.weightComparator());
            }else if(modeNumber==5){
                //modeNumber가 1일 때와 마찬가지로 람다식을 작성하여 전달하고 있다.
                plist.sort(((o1, o2) -> o1.getPeriod()-o2.getPeriod()));
            }else if(modeNumber==6){
                //PeirodicElement의 static메소드 groupComparator()가 반환하는 Comparator<PeriodicElement>를 구현한 인스턴스를 인자로 전달하고 있다.
                plist.sort(PeriodicElement.groupComparator());
            }else if(modeNumber==7){
                //PeirodicElement의 static메소드 typeComparator()가 반환하는 Comparator<PeriodicElement>를 구현한 인스턴스를 인자로 전달하고 있다.
                plist.sort(PeriodicElement.typeComparator());
            }else if(modeNumber==8){
                //PeirodicElement의 static메소드 stateComparator()가 반환하는 Comparator<PeriodicElement>를 구현한 인스턴스를 인자로 전달하고 있다.
                plist.sort(PeriodicElement.stateComparator());
            }
            //사용자의 잘못된 입력 혹은 선택에 따라 modeNumber가 적절치 않으면 다음의 else문을 실행한다.
            else {
                //사용자에게 잘못된 mode number임을 알리고 다시 입력할 것을 알린다.
                System.out.println("Wrong mode number. Please re-enter.");
                //continue문을 통해서 반복문을 빠져나가지 않으면서 즉시 다음 반복을 진행한다.
                continue;
            }
            System.out.println("--------------------정렬된 내용 출력--------------------");
            //리스트에 저장된 내용이 제대로 정렬되었는지 확인하기 위해 plist.print()를 호출하여 확인한다.
            plist.print();

            //정렬한 내용을 파일로 저장할 것인지 사용자에게 묻는다.
            System.out.println("해당 내용을 파일로 저장하시겠습니까?");
            System.out.print("Y/N >>");
            //UserInput의 static메소드 getString()을 통해 문자열을 입력받는다.
            //이를 이전에 선언한 String형 input참조변수를 이용하여 참조한다.
            input=UserInput.getString();
            //toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
            //이렇게 변환한 String에 equals()를 호출하여 "Y"와 같은지 비교한다. 만약 둘이 동일한 내용이라면 if문은 참이된다.
            if(input.toUpperCase().equals("Y")){
                //사용자에게 '파일의 확장자'를 제외한 파일의 이름을 입력받는다.
                //물론 파일의 경로를 파일의 이름과 함께 전달하여도 무관하다.(경로를 함께 제시하면 해당 경로에 파일이 저장될 것이다.(정상적으로 파일출력이 되면))
                System.out.println("저장할 파일의 이름을 입력하시오.(파일의 확장자 제외)");
                System.out.println("저장할 파일의 경로를 함께 입력하시면 해당 경로에 파일을 생성합니다.");
                System.out.print(">>");
                //사용자로부터 경로를 입력받는다.(UserInput의 static메소드 getString()을 이용하여)
                String path=UserInput.getString();
                //PeriodicElementImporter클래스의 static메소드 saveSCV를 호출한다.
                //인자로 이전에 입력받은 파일의이름(+경로)와 plist를 전달한다.
                //(이때 saveSCV의 매개변수 형식이 List<PeriodicElement>이므로 getList()를 통해 List<PeriodicElement>형태로 변환하여준다.(List<PeriodicElement>로 참조가능한 형태))
                PeriodicElementImporter.saveSCV(path,plist.getList());
            }else if(input.toUpperCase().equals("N")){
                System.out.println("파일로 저장하지 않습니다.");
            }else {
                System.out.println("잘못된 입력입니다. 파일로 저장하지 않습니다.");
            }
            System.out.println();
        //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());
        System.out.println();

        //앞서 랜덤하게 섞었던 ptable의 내용을 정렬할 것임을 사용자에게 알린다.
        System.out.println("앞서 shuffle하였던 ptable의 정보를 정렬합니다.");
        do{
            //PeriodicElement의 어떤 정보를 기준으로 정렬할 것인지 선택하게끔한다.(사용자에게 묻느다)
            System.out.println("어떤 정보를 기준으로 정렬할지 선택하시오.");
            System.out.println("Mode 1.sort by number");
            System.out.println("Mode 2.sort by symbol");
            System.out.println("Mode 3.sort by name");
            System.out.println("Mode 4.sort by weight");
            System.out.println("Mode 5.sort by period");
            System.out.println("Mode 6.sort by group");
            System.out.println("Mode 7.sort by type");
            System.out.println("Mode 8.sort by state");
            System.out.print("Enter the mode number>>");
            //사용자로부터 어떤 모드로 정렬할 것인지 UserInput클래스의 getInteger()를 통해서 입력받는다.
            int modeNumber = UserInput.getInteger();
            //다중 if-else문을 통해 modeNumber가 저장하고 있는 정수값에 따라 실행흐름을 나눈다.
            //plist.sort()의 인자로 Comparator<PeriodicElement>를 구현한 인스턴스를 전달하고 있는데
            //해당 인스턴스에서 구현한 compare()메소드의 내용을 기반으로 정렬이 진행된다.
            //이전의 plist의 경우와 동일하다. 차이점이라고 하면 다음의 문장들은 sort()의 인자로 PeriodicElement의 static메소드 xxxComparator()를 이용한다는 것이다.
            if(modeNumber==1){
                ptable.sort(PeriodicElement.numberComparator());
            }else if(modeNumber==2){
                ptable.sort(PeriodicElement.symbolComparator());
            }else if(modeNumber==3){
                ptable.sort(PeriodicElement.nameComparator());
            }else if(modeNumber==4){
                ptable.sort(PeriodicElement.weightComparator());
            }else if(modeNumber==5){
                ptable.sort(PeriodicElement.periodComparator());
            }else if(modeNumber==6){
                ptable.sort(PeriodicElement.groupComparator());
            }else if(modeNumber==7){
                ptable.sort(PeriodicElement.typeComparator());
            }else if(modeNumber==8){
                ptable.sort(PeriodicElement.stateComparator());
            }
            //사용자의 잘못된 입력 혹은 선택에 따라 modeNumber가 적절치 않으면 다음의 else문을 실행한다.
            else {
                //사용자에게 잘못된 mode number임을 알리고 다시 입력할 것을 알린다.
                System.out.println("Wrong mode number. Please re-enter.");
                //continue문을 통해서 반복문을 빠져나가지 않으면서 즉시 다음 반복을 진행한다.
                continue;
            }

            System.out.println("--------------------정렬된 내용 출력--------------------");
            //배열에 저장된 내용이 제대로 정렬되었는지 확인하기 위해 plist.print()를 호출하여 확인한다.
            ptable.print();

            System.out.println("해당 내용을 파일로 저장하시겠습니까?");
            System.out.print("Y/N >>");
            //UserInput의 static메소드 getString()을 통해 문자열을 입력받는다.
            //이를 이전에 선언한 String형 input참조변수를 이용하여 참조한다.
            input=UserInput.getString();
            //toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
            //이렇게 변환한 String에 equals()를 호출하여 "Y"와 같은지 비교한다. 만약 둘이 동일한 내용이라면 if문은 참이된다.
            if(input.toUpperCase().equals("Y")){
                System.out.println("저장할 파일의 이름을 입력하시오.(파일의 확장자 제외)");
                System.out.println("저장할 파일의 경로를 함께 입력하시면 해당 경로에 파일을 생성합니다.");
                System.out.print(">>");
                String path=UserInput.getString();
                //PeriodicElementImporter클래스의 static메소드 saveSCV를 호출한다.
                //인자로 이전에 입력받은 파일의이름(+경로)와 ptable을 전달한다.
                //(이때 saveSCV의 매개변수 형식이 List<PeriodicElement>이므로 getList()를 통해 List<PeriodicElement>형태로 변환하여준다.(List<PeriodicElement>로 참조가능한 형태))
                PeriodicElementImporter.saveSCV(path,ptable.getList());
            }else if(input.toUpperCase().equals("N")){
                System.out.println("파일로 저장하지 않습니다.");
            }else {
                System.out.println("잘못된 입력입니다. 파일로 저장하지 않습니다.");
            }
            System.out.println();
        //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());
        System.out.println();

        //PeriodicElement형 참조변수 findPE를 선언하면서 null로 초기화한다.
        PeriodicElement findPE=null;
        do{
            System.out.println("원소하나를 찾습니다.");
            System.out.println("무엇을 통해 원소를 찾을지 선택하십시오.");
            System.out.println("Mode 1.find by number");
            System.out.println("Mode 2.find by symbol");
            System.out.println("Mode 3.find by name");
            System.out.println("Mode 4.find by weight");
            System.out.print(">>");
            //UserInput의 static메소드 getInteger()을 통해 문자열을 입력받는다.
            //이를 int형 변수 modeNumber에 저장한다.
            //어떤 모드로 find할지 결정하는 변수이다.
            int modeNumber=UserInput.getInteger();
            //만약 사용자가 입력한 값(modeNumber에 저장된 값)이 1보다 작거나 4보다 크면
            //적절하지 않은 모드 번호 입력이고 이를 사용자에게 알린다.
            if(modeNumber<1||modeNumber>4){
                System.out.println("Wrong mode number. Please re-enter.");
                //continue를 통해 사용자가 다시 입력할 수 있도록 반복문의 나머지를 생략하고(반복문을 빠져나가지 않으면서) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }
            System.out.println("1. find from plist");
            System.out.println("2. find from ptable");
            System.out.print(">>");
            //UserInput의 static메소드 getInteger()을 통해 문자열을 입력받는다.
            //이를 int형 변수 dataNumber에 저장한다.
            //plist,ptable 어떤 데이터 형식으로부터 find할지를 결정하는 변수이다.
            int dataNumber=UserInput.getInteger();
            //만약 dataNumber가 1보다 작거나 2보다 크면 적절하지 않은 사용자입력이므로 이를 사용자에게 알린다.
            if(dataNumber<1||dataNumber>2){
                System.out.println("Wrong dataType number. Please re-enter.");
                //continue를 통해 사용자가 다시 입력할 수 있도록 반복문의 나머지를 생략하고(반복문을 빠져나가지 않으면서) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }
            //dataNumber가 1인경우에 if문 내부{}의 문장을 실행한다.
            if(dataNumber==1){
                //다중 if-else문을 통해 modeNumber가 저장하고 있는 정수값에 따라 실행흐름을 나눈다.
                if(modeNumber==1){
                    System.out.print("number>>");
                    //사용자로부터 number값을 입력받는다.(UserInput클래스의 static메소드 getInteger()를 이용하여)
                    int number=UserInput.getInteger();
                    //plist.findELement의 인자로 Predicate<PeriodicElement>를 구현한 인스턴스를 전달하여야한다.
                    //Predicate는 자바에서 표준으로 정의하고 있는 달리 말하면 '미리 정의해 놓은' 함수형 인터페이스들을 모아놓은
                    //java.util.function패키지에 있는 함수형 인터페이스로써 전달된 인자를 판단하여 true or false를 판단한다.
                    //익명클래스를 통해 Predicate<PeriodicElement>를 구현하고 이를 인자로 전달하고 있다.(클래스 정의와 생성을 묶음)
                    //findElement의 인자로 전달된 Predicate(를 구현한 인스턴스)의 test를 참으로 만든 PeriodicElement를 findPE가 참조하게 된다.
                    findPE=plist.findElement(new Predicate<PeriodicElement>() {
                        //어노테이션
                        //오버라이딩을 통해 test추상메소드를 구현한다.
                        @Override
                        public boolean test(PeriodicElement periodicElement) {
                            //인자로 전달된 PeriodicElement의 getNumber()를 통해 반환된 값과 사용자로부터 입력받은 number의 값이 동일하면
                            //true를 반환하고 그렇지 않으면 false를 반환한다.
                            if(periodicElement.getNumber()==number)
                                return true;
                            else
                                return false;
                        }
                    });
                }else if(modeNumber==2){
                    System.out.print("symbol>>");
                    //사용자로부터 symbol을 입력받는다.(UserInput클래스의 static메소드 getString()를 이용하여)
                    String symbol=UserInput.getString();
                    //plist.findELement의 인자로 Predicate<PeriodicElement>를 구현한 인스턴스를 전달하여야한다.
                    //Predicate는 자바에서 표준으로 정의하고 있는 달리 말하면 '미리 정의해 놓은' 함수형 인터페이스들을 모아놓은
                    //java.util.function패키지에 있는 함수형 인터페이스로써 전달된 인자를 판단하여 true or false를 판단한다.
                    //익명클래스를 통해 Predicate<PeriodicElement>를 구현하고 이를 인자로 전달하고 있다.(클래스 정의와 생성을 묶음)
                    //findElement의 인자로 전달된 Predicate(를 구현한 인스턴스)의 test를 참으로 만든 PeriodicElement를 findPE가 참조하게 된다.
                    findPE=plist.findElement(new Predicate<PeriodicElement>() {
                        //어노테이션, 오버라이딩을 통해 test추상메소드를 구현한다.
                        @Override
                        public boolean test(PeriodicElement periodicElement) {
                            //인자로 전달된 PeriodicElement의 getSymbol()을 통해 반환된 값과 사용자로부터 입력받은 symbol의 내용이 동일하면
                            //(String의 equals()는 참조값(레퍼런스값)을 비교하지 않고 문자열 내용을 비교하도록 Object의 equals()를 오버라딩하고 있다.)
                            //true를 반환하고 그렇지 않으면 false를 반환한다.
                            if(periodicElement.getSymbol().equals(symbol))
                                return true;
                            else
                                return false;
                        }
                    });
                }else if(modeNumber==3){
                    System.out.print("name>>");
                    //사용자로부터 name을 입력받는다.(UserInput클래스의 static메소드 getString()를 이용하여)
                    String name=UserInput.getString();
                    //findElement의 인자로 전달되는 Predicate<T>는 자바에서 표준으로 정의하고 있는 함수형 인터페이스라고 하였다.
                    //따라서 이 함수형인터페이스(추상메소드를 하나만 가지는 인터페이스)를 기반으로 람다식 작성이 가능하다.
                    //이전에 익명클래스(Anonymous Class)로 작성하였던 내용을 람다식 기반으로 작성하였다.
                    //findElement의 인자로 전달된 Predicate(를 구현한 인스턴스)의 test를 참으로 만든 PeriodicElement를 findPE가 참조하게 된다.
                    findPE=plist.findElement(pe->{
                        //내용은 비슷하다.
                        //인자로 전달된 pe의 getName()을 통해 반환된 name문자열을 toUpperCase()를 이용하여 모든 문자를 대문자로 변환한다.
                        //마찬가지로 사용자로부터 입력받은 name도 toUpperCase()를 통해 대문자로 변환한다.
                        //이 둘을 String클래스에 정의된 equals()메소드를 통해서 문자열 내용을 비교하고 일치하면 true를 반환한다.
                        //그렇지 않으면 false를 반환한다.
                        if(pe.getName().toUpperCase().equals(name.toUpperCase())) return true;
                        else return false;
                    });
                }else if(modeNumber==4) {
                    System.out.print("weight>>");
                    //사용자로부터 weight를 입력받는다. (UserInput클래스의 static메소드 getDouble()을 이용하여)
                    double weight = UserInput.getDouble();
                    //앞서 name을 이용한 것과 마찬가지로 람다식을 이용하여 작성하였고, 이를 findElement의 인자로 전달하여 주고 있다.
                    //findElement의 인자로 전달된 Predicate(를 구현한 인스턴스)의 test를 참으로 만든 PeriodicElement를 findPE가 참조하게 된다.
                    findPE = plist.findElement(pe -> {
                        //인자로 전달된 pe의 getWeight()를 통해 반환되는 weight와 사용자로부터 입력받은 weight의 값이 동일하면
                        //true를 반환하고 그렇지 않으면 false를 반환한다.
                        if (pe.getWeight() == weight) return true;
                        else return false;
                    });
                }
            }
            //dataNumber가 2인경우에 if문 내부{}의 문장을 실행한다.
            if(dataNumber==2){
                //다중 if-else문을 통해 modeNumber가 저장하고 있는 정수값에 따라 실행흐름을 나눈다.
                if(modeNumber==1){
                    System.out.print("number>>");
                    //사용자로부터 number값을 입력받는다.(UserInput클래스의 static메소드 getInteger()를 이용하여)
                    int number=UserInput.getInteger();
                    //ptable.findELement의 인자로 Predicate<PeriodicElement>를 구현한 인스턴스를 전달하여야한다.
                    //Predicate는 자바에서 표준으로 정의하고 있는 달리 말하면 '미리 정의해 놓은' 함수형 인터페이스들을 모아놓은
                    //java.util.function패키지에 있는 함수형 인터페이스로써 전달된 인자를 판단하여 true or false를 판단한다.
                    //익명클래스를 통해 Predicate<PeriodicElement>를 구현하고 이를 인자로 전달하고 있다.(클래스 정의와 생성을 묶음)
                    //findElement의 인자로 전달된 Predicate의 test를 참으로 만든 PeriodicElement를 findPE가 참조하게 된다.
                    findPE=ptable.findElement(new Predicate<PeriodicElement>() {
                        //어노테이션
                        //오버라이딩을 통해 test추상메소드를 구현한다.
                        @Override
                        public boolean test(PeriodicElement periodicElement) {
                            //인자로 전달된 PeriodicElement의 getNumber()를 통해 반환된 값과 사용자로부터 입력받은 number의 값이 동일하면
                            //true를 반환하고 그렇지 않으면 false를 반환한다.
                            if(periodicElement.getNumber()==number)
                                return true;
                            else
                                return false;
                        }
                    });
                }else if(modeNumber==2){
                    System.out.print("symbol>>");
                    //사용자로부터 symbol을 입력받는다.(UserInput클래스의 static메소드 getString()를 이용하여)
                    String symbol=UserInput.getString();
                    //plist.findELement의 인자로 Predicate<PeriodicElement>를 구현한 인스턴스를 전달하여야한다.
                    //Predicate는 자바에서 표준으로 정의하고 있는 달리 말하면 '미리 정의해 놓은' 함수형 인터페이스들을 모아놓은
                    //java.util.function패키지에 있는 함수형 인터페이스로써 전달된 인자를 판단하여 true or false를 판단한다.
                    //익명클래스를 통해 Predicate<PeriodicElement>를 구현하고 이를 인자로 전달하고 있다.(클래스 정의와 생성을 묶음)
                    //findElement의 인자로 전달된 Predicate의 test를 참으로 만든 PeriodicElement를 findPE가 참조하게 된다.
                    findPE=ptable.findElement(new Predicate<PeriodicElement>() {
                        //어노테이션, 오버라이딩을 통해 test추상메소드를 구현한다.
                        @Override
                        public boolean test(PeriodicElement periodicElement) {
                            //인자로 전달된 PeriodicElement의 getSymbol()을 통해 반환된 값과 사용자로부터 입력받은 symbol의 내용이 동일하면
                            //(String의 equals()는 참조값(레퍼런스값)을 비교하지 않고 문자열 내용을 비교하도록 Object의 equals()를 오버라딩하고 있다.)
                            //true를 반환하고 그렇지 않으면 false를 반환한다.
                            if(periodicElement.getSymbol().equals(symbol))
                                return true;
                            else
                                return false;
                        }
                    });
                }else if(modeNumber==3){
                    System.out.print("name>>");
                    //사용자로부터 name을 입력받는다.(UserInput클래스의 static메소드 getString()를 이용하여)
                    String name=UserInput.getString();
                    //findElement의 인자로 전달되는 Predicate<T>는 자바에서 표준으로 정의하고 있는 함수형 인터페이스라고 하였다.
                    //따라서 이 함수형인터페이스(추상메소드를 하나만 가지는 인터페이스)를 기반으로 람다식 작성이 가능하다.
                    //이전에 익명클래스(Anonymous Class)로 작성하였던 내용을 람다식 기반으로 작성하였다.
                    //findElement의 인자로 전달된 Predicate의 test를 참으로 만든 PeriodicElement를 findPE가 참조하게 된다.
                    findPE=ptable.findElement(pe->{
                        //인자로 전달된 pe의 getName()을 통해 반환된 name문자열을 toUpperCase()를 이용하여 모든 문자를 대문자로 변환한다.
                        //마찬가지로 사용자로부터 입력받은 name도 toUpperCase()를 통해 대문자로 변환한다.
                        //이 둘을 String클래스에 정의된 equals()메소드를 통해서 문자열 내용을 비교하고 일치하면 true를 반환한다.
                        //그렇지 않으면 false를 반환한다.
                        if(pe.getName().toUpperCase().equals(name.toUpperCase())) return true;
                        else return false;
                    });
                }else if(modeNumber==4) {
                    System.out.print("weight>>");
                    //사용자로부터 weight를 입력받는다. (UserInput클래스의 static메소드 getDouble()을 이용하여)
                    double weight = UserInput.getDouble();
                    //앞서 name을 이용한 것과 마찬가지로 람다식을 이용하여 작성하였고, 이를 findElement의 인자로 전달하여 주고 있다.
                    //findElement의 인자로 전달된 Predicate의 test를 참으로 만든 PeriodicElement를 findPE가 참조하게 된다.
                    findPE = ptable.findElement(pe -> {
                        //인자로 전달된 pe의 getWeight()를 통해 반환되는 weight와 사용자로부터 입력받은 weight의 값이 동일하면
                        //true를 반환하고 그렇지 않으면 false를 반환한다.
                        if (pe.getWeight() == weight) return true;
                        else return false;
                    });
                }
            }
            //만약 이전 if문들을 통해서 plist든지 ptable이든지 findElement가 값을 정상적으로 반환하였다면 null이 아닐 것이다.
            //다음은 findPE가 null이 아닌 경우 실행된다.
            if(findPE!=null){
                System.out.println("찾은 내용입니다.");
                //사용자에게 찾은 내용을 출력하여 준다.
                System.out.println(findPE);
                //findPE는 PeriodicElement이다. saveSCV는 List<PeriodicElement>형 데이터를 원하므로
                //findPE를 Arrays.asList()메소드를 통하여 List<PeriodicElement>가 참조가능한 형태로 변환하여준다.
                List<PeriodicElement> findPEList = Arrays.asList(findPE);
                System.out.println("해당 내용을 파일로 저장하시겠습니까?");
                System.out.print("Y/N >>");
                //UserInput의 static메소드 getString()을 통해 문자열을 입력받는다.
                //이를 이전에 선언한 String형 input참조변수를 이용하여 참조한다.
                input = UserInput.getString();
                //toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
                //이렇게 변환한 String에 equals()를 호출하여 "Y"와 같은지 비교한다. 만약 둘이 동일한 내용이라면 if문은 참이된다.
                if (input.toUpperCase().equals("Y")) {
                    System.out.println("저장할 파일의 이름을 입력하시오.(파일의 확장자 제외)");
                    System.out.println("저장할 파일의 경로를 함께 입력하시면 해당 경로에 파일을 생성합니다.");
                    System.out.print(">>");
                    String path = UserInput.getString();
                    //PeriodicElementImporter클래스의 static메소드 saveSCV를 호출한다.
                    //인자로 이전에 입력받은 파일의이름(+경로)와 findPEList를 전달한다.
                    PeriodicElementImporter.saveSCV(path, findPEList);
                } else if (input.toUpperCase().equals("N")) {
                    System.out.println("파일로 저장하지 않습니다.");
                } else {
                    System.out.println("잘못된 입력입니다. 파일로 저장하지 않습니다.");
                }
                System.out.println();
            }else {
                //만약 null이라면 정상적으로 찾은 값이 없는 것이고 이를 사용자에게 알린다.
                System.out.println("nothing find..");
            }
        //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());


        //PeriodicElement[]형 참조변수 findPEArray를 선언하면서 null로 초기화한다.
        PeriodicElement[] findPEArray=null;

        do{
            System.out.println("원소들을 찾습니다.");
            System.out.println("Mode 1.find by period");
            System.out.println("Mode 2.find by group");
            System.out.println("Mode 3.find by type");
            System.out.println("Mode 4.find by state");
            System.out.println("무엇을 통해 원소를 찾을지 선택하십시오.");
            System.out.print(">>");
            //UserInput의 static메소드 getInteger()을 통해 문자열을 입력받는다.
            //이를 int형 변수 modeNumber에 저장한다.
            //어떤 모드로 find할지 결정하는 변수이다.
            int modeNumber=UserInput.getInteger();
            //만약 사용자가 입력한 값(modeNumber에 저장된 값)이 1보다 작거나 4보다 크면
            //적절하지 않은 모드 번호 입력이고 이를 사용자에게 알린다.
            if(modeNumber<1||modeNumber>4){
                System.out.println("Wrong mode number. Please re-enter.");
                //continue를 통해 사용자가 다시 입력할 수 있도록 반복문의 나머지를 생략하고(반복문을 빠져나가지 않으면서) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }
            System.out.println("1. find from plist");
            System.out.println("2. find from ptable");
            System.out.print(">>");
            //UserInput의 static메소드 getInteger()을 통해 문자열을 입력받는다.
            //이를 int형 변수 dataNumber에 저장한다.
            //plist,ptable 어떤 데이터 형식으로부터 find할지를 결정하는 변수이다.
            int dataNumber=UserInput.getInteger();
            //만약 dataNumber가 1보다 작거나 2보다 크면 적절하지 않은 사용자입력이므로 이를 사용자에게 알린다.
            if(dataNumber<1||dataNumber>2){
                System.out.println("Wrong dataType number. Please re-enter.");
                //continue를 통해 사용자가 다시 입력할 수 있도록 반복문의 나머지를 생략하고(반복문을 빠져나가지 않으면서) 반복문의 조건식을 검사하는 과정으로 분기한다.
                continue;
            }
            //dataNumber가 1인경우에 if문 내부{}의 문장을 실행한다.
            if(dataNumber==1){
                if(modeNumber==1){
                    System.out.print("period>>");
                    //사용자로부터 period를 문자열로 입력받는다.
                    String periodStr=UserInput.getString();
                    //다음의 getInteger()은 UserInput에 인자를 전달받지 않는 메소드와 오버로딩되어있다.
                    //여기서는 따로 입력을 받지 않고 이전에 입력받아 생성한 periodStr이 참조하는 String인스턴스를 전달하여 주고 이를 기반으로 int형 데이터를 생성한다.
                    //이와 같은 메소드를 추가롤 정의하고 사용하는 이유는 " "와 같은 입력이 있을 시, period가 비어있는 원소를 출력하고자 하였는데, 만약 인자를 받지 않는 getInteger()으로
                    //사용자입력을 받고 단순히 -1과 비교하는 경우 "wfqfqw"와 같은 입력도 period가 비어있는 원소를 Predicate에서 참으로 판별하고 이를 출력하는 문제가 있었다.
                    //이는 적절하지 않다고 판단하여 부득이하게 다음과 같은 메소드를 추가로 이용하고 있다.(사용자 입력을 따로 받지 않으므로 UserInput에 정의하는 것은 어떻게 보면 적절치 않을 수 있지만..)
                    int period=UserInput.getInteger(periodStr);
                    //period가 -1인 경우
                    if(period==-1){
                        //다음과 같이 사용자가 어떤 내용을 입력했는지 검사하지 않으면 사용자가 잘못입력하여 단순히 null일 때 모두 type이 ' '과 같은 원소가 출력되는 문제가 발생하였다.
                        //따라서 다음과 같이 사용자의 입력이 " "와 같은지 한 번 더 검사하여 준다.
                        if(periodStr.equals(" ")){
                            //findElements의 인자로 다음 람다식을 전달한다.
                            findPEArray = plist.findElements(pe -> {
                                //인자로 전달된 pe의 getPeriod()이 반환하는 period와 사용자 입력으로부터 받은 period를 비교한다.
                                if (period == pe.getPeriod()) return true;
                                else return false;
                            });
                        }
                        //만약 -1이긴 하지만 사용자가 입력한 값이 " "이 아니었던 경우 findPEArray에 null을 대입하여 준다.
                        else{
                            findPEArray=null;
                        }
                    }else {
                        //만약 period가 -1이 아니면 다음을 진행한다.
                        //findElements의 인자로 Predicate를 구현한 인스턴스를 전달한다.(익명클래스를 통해 클래스의 정의와 생성을 묶어서 인자로 전달한다.)
                        //findElements의 인자로 전달된 Predicate의 test를 참으로 만드는 모든 PeriodicElement를 담은 배열을 findPEArray가 참조하게된다.
                        findPEArray = plist.findElements(new Predicate<PeriodicElement>() {
                            //어노테이션 추상메소드 test를 오버라이딩을 통해 구현한다.
                            @Override
                            //인자로 전달된 PeriodicElement의 getPeriod()을 통해 반환된 값과 사용자로부터 입력받은 period 값이 같으면
                            //true를 반환하고 그렇지 않으면 false를 반환한다.
                            public boolean test(PeriodicElement periodicElement) {
                                if (periodicElement.getPeriod() == period)
                                    return true;
                                else
                                    return false;
                            }
                        });
                    }
                }else if(modeNumber==2){
                    System.out.print("group>>");
                    //사용자로부터 UserInput클래스의 getInteger()를 통해서 입력받는다.
                    //이를 int형 group변수에 저장한다.
                    int group=UserInput.getInteger();
                        //findElements의 인자로 Predicate를 구현한 인스턴스를 전달한다.(익명클래스를 통해 클래스의 정의와 생성을 묶어서 인자로 전달한다.)
                        //findElements의 인자로 전달된 Predicate의 test를 참으로 만드는 모든 PeriodicElement를 담은 배열을 findPEArray가 참조하게된다.
                        findPEArray = plist.findElements(new Predicate<PeriodicElement>() {
                            @Override
                            public boolean test(PeriodicElement periodicElement) {
                                if (periodicElement.getGroup() == group)
                                    return true;
                                else
                                    return false;
                            }
                        });
                }else if(modeNumber==3){
                    System.out.print("type>>");
                    //사용자로부터 type의 이름을 입력받는다. (UserInput클래스에 static으로 정의된 getString을 이용하여)
                    String typeName=UserInput.getString();
                    //다음의 getType()은 UserInput에 인자를 전달받지 않는 메소드와 오버로딩되어있다.
                    //여기서는 따로 입력을 받지 않고 이전에 입력받아 생성한 typeName이 참조하는 String인스턴스를 전달하여 주고 이를 기반으로 Type을생성한다.
                    //이와 같은 메소드를 추가롤 정의하고 사용하는 이유는 " "와 같은 입력이 있을 시, type이 비어있는 원소를 출력하고자 하였는데, 만약 인자를 받지 않는 getType()으로
                    //사용자입력을 받고 단순히 null과 비교하는 경우 "wfqfqw"와 같은 입력도 type이 비어있는 원소를 Predicate에서 참으로 판별하고 이를 출력하는 문제가 있었다.
                    //이는 적절하지 않다고 판단하여 부득이하게 다음과 같은 메소드를 추가로 이용하고 있다.(사용자 입력을 따로 받지 않으므로 UserInput에 정의하는 것은 어떻게 보면 적절치 않을 수 있지만..)
                    Type type=UserInput.getType(typeName);

                    //type이 null인경우 다음 문장을 실행한다.
                    if(type==null){
                        //다음과 같이 사용자가 어떤 문자열을 입력했는지 검사하지 않으면 사용자가 잘못입력하여 단순히 null일 때 모두 type이 ' '과 같은 원소가 출력되는 문제가 발생하였다.
                        //따라서 다음과 같이 사용자의 입력이 " "와 같은지 한 번 더 검사하여 준다.
                        if(typeName.equals(" ")) {
                            //findElements의 인자로 다음 람다식을 전달한다.
                            findPEArray = plist.findElements(pe -> {
                                //인자로 전달된 pe의 getType()이 반환하는 Type과 사용자 입력으로부터 받은 type을 비교한다.
                                //null을 통해서 equals()를 호출하는 것은 적절치 못하므로 '=='로 비교
                                //어차피 여기서 찾으려고 하는 것은(즉 true를 기대하는 것은) pe.getType()이 null인 경우 이므로 참조값을 비교하여도 무관
                                if (type == pe.getType()) return true;
                                else return false;
                            });
                        //type이 null이긴 하지만 사용자가 입력한 값이 " "이 아닌경우
                        }else{
                            //findPEArray가 null을 참조하도록 한다.
                            findPEArray=null;
                        }
                    }else {
                        //만약 type이 null이 아니면 다음 문장을 실행한다.
                        //findElements의 인자로 전달된 Predicate의 test를 참으로 만드는 모든 PeriodicElement를 담은 배열을 findPEArray가 참조하게된다.
                        findPEArray = plist.findElements(pe -> {
                            //다음의 경우 pe.getType().equals(type)이면 오류가 발생할 수 있다.
                            //pe.getType()이 널일 가능성이 있기 때문이다. null을 통해서 equals()를 호출하는 것은 적절치 못하다.
                            //따라서 type을 통해 equals()를 호출한다. 이 때 type은 앞선 if문을 통해서 검사하므로 null인 경우
                            //다음의 equals()가 진행되지 않으므로 문제가 되지 않는다.
                            if (type.equals(pe.getType())) return true;
                            else return false;
                        });
                    }
                }else if(modeNumber==4) {
                    System.out.print("state>>");
                    //UserInput에 static으로 정의된 getState()를 이용하여 반환되는 State를 state가 참조하도록한다.
                    State state=UserInput.getState();
                    //만약 UserInput.getState()가 반환한 값이 null이면
                    if(state==null){
                        //findPEArray에 null을 대입한다.
                        findPEArray=null;
                        /*
                        null을 대상으로 equals()는 NullPointerException을 일으키므로 다음과 같이 ==를 통해 pe.getState()가 반환하는 값이 null인 경우를 Predicate를 통해 판별하고
                        참이되게 하는 PeriodicElement를 모은 배열을 findPEArray가 참조하도록하여도 될 것이다.
                        하지만 현재의 프로그램에서는 state가 null인경우는 정상적이지 않은 경우이기 때문에 이를 아래와 같이 처리하지 않도 단순히 null을 대입하여 주도록하였다.
                        (findElements는 내부적으로 반복자를 통해 혹은 for-each문을 통해 모든 요소에 대해서 반복을 진행하는데 현재 프로그램에서는 state가 null인 경우가 존재하지 않으므로 불필요한 복잡도만 생기게 될 뿐이다.)
                        findPEArray=ptable.findElements(pe->{
                            if(state==pe.getState())return true;
                            else return false;
                        });
                         */
                    }else {
                        //findElements의 인자로 전달된 Predicate의 test를 참으로 만드는 모든 PeriodicElement를 담은 배열을 findPEArray가 참조하게된다.
                        findPEArray = plist.findElements(pe -> {
                            if (state.equals(pe.getState())) return true;
                            else return false;
                        });
                    }
                }
            }
            if(dataNumber==2) {
                if(modeNumber==1){
                    System.out.print("period>>");
                    //사용자로부터 period를 문자열로 입력받는다.
                    String periodStr=UserInput.getString();
                    //다음의 getInteger()은 UserInput에 인자를 전달받지 않는 메소드와 오버로딩되어있다.
                    //여기서는 따로 입력을 받지 않고 이전에 입력받아 생성한 periodStr이 참조하는 String인스턴스를 전달하여 주고 이를 기반으로 int형 데이터를 생성한다.
                    //이와 같은 메소드를 추가롤 정의하고 사용하는 이유는 " "와 같은 입력이 있을 시, period가 비어있는 원소를 출력하고자 하였는데, 만약 인자를 받지 않는 getInteger()으로
                    //사용자입력을 받고 단순히 -1과 비교하는 경우 "wfqfqw"와 같은 입력도 period가 비어있는 원소를 Predicate에서 참으로 판별하고 이를 출력하는 문제가 있었다.
                    //이는 적절하지 않다고 판단하여 부득이하게 다음과 같은 메소드를 추가로 이용하고 있다.(사용자 입력을 따로 받지 않으므로 UserInput에 정의하는 것은 어떻게 보면 적절치 않을 수 있지만..)
                    int period=UserInput.getInteger(periodStr);
                    //period가 -1인 경우
                    if(period==-1){
                        //다음과 같이 사용자가 어떤 내용을 입력했는지 검사하지 않으면 사용자가 잘못입력하여 단순히 null일 때 모두 type이 ' '과 같은 원소가 출력되는 문제가 발생하였다.
                        //따라서 다음과 같이 사용자의 입력이 " "와 같은지 한 번 더 검사하여 준다.
                        if(periodStr.equals(" ")){
                            //findElements의 인자로 다음 람다식을 전달한다.
                            findPEArray = ptable.findElements(pe -> {
                                //인자로 전달된 pe의 getPeriod()이 반환하는 period와 사용자 입력으로부터 받은 period를 비교한다.
                                if (period == pe.getPeriod()) return true;
                                else return false;
                            });
                        }
                        //만약 -1이긴 하지만 사용자가 입력한 값이 " "이 아니었던 경우 findPEArray에 null을 대입하여 준다.
                        else{
                            findPEArray=null;
                        }
                    }else {
                        //만약 period가 -1이 아니면 다음을 진행한다.
                        //findElements의 인자로 Predicate를 구현한 인스턴스를 전달한다.(익명클래스를 통해 클래스의 정의와 생성을 묶어서 인자로 전달한다.)
                        //findElements의 인자로 전달된 Predicate의 test를 참으로 만드는 모든 PeriodicElement를 담은 배열을 findPEArray가 참조하게된다.
                        findPEArray = ptable.findElements(new Predicate<PeriodicElement>() {
                            //어노테이션 추상메소드 test를 오버라이딩을 통해 구현한다.
                            @Override
                            //인자로 전달된 PeriodicElement의 getPeriod()을 통해 반환된 값과 사용자로부터 입력받은 period 값이 같으면
                            //true를 반환하고 그렇지 않으면 false를 반환한다.

                            public boolean test(PeriodicElement periodicElement) {
                                if (periodicElement.getPeriod() == period)
                                    return true;
                                else
                                    return false;
                            }
                        });
                    }
                }else if(modeNumber==2){
                    System.out.print("group>>");
                    //사용자로부터 UserInput클래스의 getInteger()를 통해서 입력받는다.
                    //이를 int형 group변수에 저장한다.
                    int group=UserInput.getInteger();
                    //findElements의 인자로 Predicate를 구현한 인스턴스를 전달한다.(익명클래스를 통해 클래스의 정의와 생성을 묶어서 인자로 전달한다.)
                    //findElements의 인자로 전달된 Predicate의 test를 참으로 만드는 모든 PeriodicElement를 담은 배열을 findPEArray가 참조하게된다.
                    findPEArray = ptable.findElements(new Predicate<PeriodicElement>() {
                        @Override
                        public boolean test(PeriodicElement periodicElement) {
                            if (periodicElement.getGroup() == group)
                                return true;
                            else
                                return false;
                        }
                    });
                }else if(modeNumber==3){
                    System.out.print("type>>");
                    //사용자로부터 type의 이름을 입력받는다. (UserInput클래스에 static으로 정의된 getString을 이용하여)
                    String typeName=UserInput.getString();
                    //다음의 getType()은 UserInput에 인자를 전달받지 않는 메소드와 오버로딩되어있다.
                    //여기서는 따로 입력을 받지 않고 이전에 입력받아 생성한 typeName이 참조하는 String인스턴스를 전달하여 주고 이를 기반으로 Type을생성한다.
                    //이와 같은 메소드를 추가롤 정의하고 사용하는 이유는 " "와 같은 입력이 있을 시, type이 비어있는 원소를 출력하고자 하였는데, 만약 인자를 받지 않는 getType()으로
                    //사용자입력을 받고 단순히 null과 비교하는 경우 "wfqfqw"와 같은 입력도 type이 비어있는 원소를 Predicate에서 참으로 판별하고 이를 출력하는 문제가 있었다.
                    //이는 적절하지 않다고 판단하여 부득이하게 다음과 같은 메소드를 추가로 이용하고 있다.(사용자 입력을 따로 받지 않으므로 UserInput에 정의하는 것은 어떻게 보면 적절치 않을 수 있지만..)
                    Type type=UserInput.getType(typeName);

                    //type이 null인경우 다음 문장을 실행한다.
                    if(type==null){
                        //다음과 같이 사용자가 어떤 문자열을 입력했는지 검사하지 않으면 사용자가 잘못입력하여 단순히 null일 때 모두 type이 ' '과 같은 원소가 출력되는 문제가 발생하였다.
                        //따라서 다음과 같이 사용자의 입력이 " "와 같은지 한 번 더 검사하여 준다.
                        if(typeName.equals(" ")) {
                            //findElements의 인자로 다음 람다식을 전달한다.
                            findPEArray = ptable.findElements(pe -> {
                                //인자로 전달된 pe의 getType()이 반환하는 Type과 사용자 입력으로부터 받은 type을 비교한다.
                                //null을 통해서 equals()를 호출하는 것은 적절치 못하므로 '=='로 비교
                                //어차피 여기서 찾으려고 하는 것은(즉 true를 기대하는 것은) pe.getType()이 null인 경우 이므로 참조값을 비교하여도 무관
                                if (type == pe.getType()) return true;
                                else return false;
                            });
                            //type이 null이긴 하지만 사용자가 입력한 값이 " "이 아닌경우
                        }else{
                            //findPEArray가 null을 참조하도록 한다.
                            findPEArray=null;
                        }
                    }else {
                        //만약 type이 null이 아니면 다음 문장을 실행한다.
                        //findElements의 인자로 전달된 Predicate의 test를 참으로 만드는 모든 PeriodicElement를 담은 배열을 findPEArray가 참조하게된다.
                        findPEArray = ptable.findElements(pe -> {
                            //다음의 경우 pe.getType().equals(type)이면 오류가 발생할 수 있다.
                            //pe.getType()이 널일 가능성이 있기 때문이다. null을 통해서 equals()를 호출하는 것은 적절치 못하다.
                            //따라서 type을 통해 equals()를 호출한다. 이 때 type은 앞선 if문을 통해서 검사하므로 null인 경우
                            //다음의 equals()가 진행되지 않으므로 문제가 되지 않는다.
                            if (type.equals(pe.getType())) return true;
                            else return false;
                        });
                    }
                }else if(modeNumber==4) {
                    System.out.print("state>>");
                    State state=UserInput.getState();
                    //만약 UserInput.getState()가 반환한 값이 null이면
                    if(state==null){
                        //findPEArray에 null을 대입한다.
                        findPEArray=null;
                        /*
                        null을 대상으로 equals()는 NullPointerException을 일으키므로 다음과 같이 ==를 통해 pe.getState()가 반환하는 값이 null인 경우를 Predicate를 통해 판별하고
                        참이되게 하는 PeriodicElement를 모은 배열을 findPEArray가 참조하도록하여도 될 것이다.
                        하지만 현재의 프로그램에서는 state가 null인경우는 정상적이지 않은 경우이기 때문에 이를 아래와 같이 처리하지 않도 단순히 null을 대입하여 주도록하였다.
                        (findElements는 내부적으로 반복자를 통해 혹은 for-each문을 통해 모든 요소에 대해서 반복을 진행하는데 현재 프로그램에서는 state가 null인 경우가 존재하지 않으므로 불필요한 복잡도만 생기게 될 뿐이다.)
                        findPEArray=ptable.findElements(pe->{
                            if(state==pe.getState())return true;
                            else return false;
                        });
                         */
                    }else{
                        //findElements의 인자로 전달된 Predicate의 test를 참으로 만드는 모든 PeriodicElement를 담은 배열을 findPEArray가 참조하게된다.
                        findPEArray = ptable.findElements(pe -> {
                            if (state.equals(pe.getState())) return true;
                            else return false;
                        });
                    }
                }
            }

            //findPEArray가 null이 아니고 findPEArray배열의 크기가 0보다 크면(findElements가 반환하는 배열이 아무런 요소도 가지고 있지 않은 배열인 경우 배열의 크기는 0이될 것이다.)
            if(findPEArray!=null&&findPEArray.length>0){
                System.out.println("찾은 내용입니다.");
                //사용자에게 find한 내용을 출력하여 준다.
                //이 때 Arrays.toString()을 통해서 배열의 모든 요소에 대해서 toString()을 호출할 수 있도록한다.
                //(findPEArray가 참조하는 배열인스턴스의 모든 요소인 PeriodicElement에 대해서 toString()을 호출한다.)
                System.out.println(Arrays.toString(findPEArray));
                //findPEArray가 참조하는 인스턴스는 PeriodicElement[]배열 인스턴스이다. saveSCV는 List<PeriodicElement>형 데이터를 원하므로
                //findPE를 Arrays.asList()메소드를 통하여 List<PeriodicElement>가 참조가능한 형태로 변환하여준다.
                List<PeriodicElement> findPEList = Arrays.asList(findPEArray);
                System.out.println("해당 내용을 파일로 저장하시겠습니까?");
                System.out.print("Y/N >>");
                //UserInput의 static메소드 getString()을 통해 문자열을 입력받는다.
                //이를 이전에 선언한 String형 input참조변수를 이용하여 참조한다.
                input = UserInput.getString();
                //toUpperCase()를 호출하여 모두 대문자로 만든 String인스턴스를 반환한다.
                //이렇게 변환한 String에 equals()를 호출하여 "Y"와 같은지 비교한다. 만약 둘이 동일한 내용이라면 if문은 참이된다.
                if (input.toUpperCase().equals("Y")) {
                    System.out.println("저장할 파일의 이름을 입력하시오.(파일의 확장자 제외)");
                    System.out.println("저장할 파일의 경로를 함께 입력하시면 해당 경로에 파일을 생성합니다.");
                    System.out.print(">>");
                    String path = UserInput.getString();
                    //PeriodicElementImporter클래스의 static메소드 saveSCV를 호출한다.
                    //인자로 이전에 입력받은 파일의이름(+경로)와 findPEList를  전달한다.
                    PeriodicElementImporter.saveSCV(path, findPEList);
                } else if (input.toUpperCase().equals("N")) {
                    System.out.println("파일로 저장하지 않습니다.");
                } else {
                    System.out.println("잘못된 입력입니다. 파일로 저장하지 않습니다.");
                }
                System.out.println();
            }else{
                //만약 if조건식을 만족시키지 못했다면 find에서 해당 조건에 맞는 원소가 없었다는 것이고 사용자에게
                //아무런 원소도 찾을 수 없었음을 알린다.
                System.out.println("nothing find..");
            }
        //UserInput클래스의 static으로 정의된 getExitKey()메소드를 호출한다. getExitKey()가 반환하는 값이 참이면 반복문을 빠져나온다.
        }while(!UserInput.getExitKey());

        //프로그램을 종료함을 알린다.
        System.out.println("Program Termination");
    }
}