import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Q_13 {
    Scanner sc=new Scanner(System.in);
    Vector<String> vec=new Vector<>();
    HashMap<String,Integer> memory=new HashMap<>();
    Integer count=0;

    int readmemory(){
        while(true){
            String buf;
            System.out.print(">>");
            buf=sc.nextLine();
            if(buf.equals("그만"))
                return -1;
            if(buf.equals("go")) {
                programming();
                return 1;
            }
            vec.add(buf);
        }
    }
    void clear(){
        vec.removeAllElements();
        memory.clear();
    }
    void programming(){
        int len=vec.size();
        while(true){
            if(len<=count)
                break;

            String[] com=new String[3];
            String buf=vec.get(count);

            Scanner str=new Scanner(buf);

            for(int i=0;i<3;i++){
                com[i]=str.next();
            }
            if(com[0].equals("mov")) {
                mov(com[1], com[2]);
                count++;
            }
            else if(com[0].equals("add")) {
                add(com[1], com[2]);
                count++;
            }
            else if(com[0].equals("sub")) {
                sub(com[1], com[2]);
                count++;
            }
            else if(com[0].equals("jn0")) {

                int n=jn0(com[1], com[2]);
                if(n!=-1)
                    count=n;
                else
                    count++;
            }
            else if(com[0].equals("prt")) {
                prt(com[1], com[2]);
                count++;
            }
            else{
                System.out.println((count+1)+"번째 라인에서 오류 발생!");
                break;
            }
        }
    }
    void mov(String a,String b){
        int n=getValue(b);
        memory.put(a,n);
    }
    void add(String a,String b){
        int n1=getValue(a);
        int n2=getValue(b);
        memory.put(a,n1+n2);
    }
    void sub(String a,String b){
        int n1=getValue(a);
        int n2=getValue(b);
        memory.put(a,n1-n2);
    }
    int jn0(String a,String b){
        int n=getValue(a);
        int m=getValue(b);
        if(n!=0)
            return m;
        else
            return -1;
    }
    void prt(String a,String b){
        System.out.println("["+"prt "+a+" "+b+"]");

        Set<String> set=memory.keySet();

        Iterator<String> itr=set.iterator();
        while(itr.hasNext()){
            String buf=itr.next();
            int value=memory.get(buf);
            System.out.print(buf+": "+value+"\t");
        }
        System.out.println();
        System.out.println("출력할 결과는"+getValue(a)+". 프로그램 종료");
    }

    private int getValue(String opr) { // opr이 정수이면 수로 리턴. 변수명이면 변수명의 값 리턴.없는 변수이면 새로만들고 0리턴
        int n;
        try {
            n = Integer.parseInt(opr); // opr 피연산자가 정수인 경우
        }
        catch(NumberFormatException e) { // opr 피연산자가 변수인 경우
            Integer value = memory.get(opr); // 변수 값 알아내기
            if(value == null) { // opr 이름의 변수가 없다면
                memory.put(opr, 0); // opr의 값을 0으로 하여 새 변수 생성
                n = 0; // 초기 값 0
            }
            else {
                n = value; // opr 변수의 저장 값
            }
        }
        return n;
    }


    void show(){
        System.out.println("컴퓨터가 동작합니다. 프로그램을 입력해주세요.");
        System.out.println("go입력시 동작");
    }
    void run(){
        while(true) {
            show();
            int bool = readmemory();
            if (bool == -1){
                System.out.println("컴퓨터 동작을 종료합니다.");
                break;
            }
            clear();
        }
    }
    public static void main(String[] args) {
        JavaStudy js=new JavaStudy();
        js.run();
    }
}
