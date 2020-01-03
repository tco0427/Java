import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class JavaStudy {
    HashMap<String,String> map=new HashMap<>();
    Scanner sc=new Scanner(System.in);

    void run(){
        while(true) {
            System.out.print("단어 테스트: 1,단어 삽입: 2, 종료:3 >>");
            int menu=sc.nextInt();
            if(menu==1) {
                test();
            }
            else if(menu==2) {
                insert();
            }
            else if(menu==3) {
                exit();
                break;
            }
            else {
                error();
                continue;
            }
        }
    }
    void test(){
        int len=map.size();
        System.out.println("현재 "+len+"개의 단어가 들어 있습니다. 종료하려면 -1을 입력하시오.");
        if(len<4){
            System.out.println("테스트를 하기에는 단어가 부족합니다.");
            return;
        }
        Set<String> set=map.keySet();
        Object[] array=set.toArray();

        while(true) {
            int index=(int)(Math.random()*map.size());
            String select=(String)array[index];
            System.out.println(select+"?");

            String[] Question=new String[4];
            int ind=(int)(Math.random()*4);

            for(int i=0;i<4;i++) {
                while(true){
                    int ibuf=(int)(Math.random()*map.size());
                    String buf=(String)array[ibuf];
                    if(buf!=select){
                        Question[i]=buf;
                        break;
                    }
                }
                for(int j=0;j<i;j++){
                    if(Question[i]==Question[j]){
                        i--;
                    }
                }
            }
            Question[ind]=select;

            for(int i=0;i<4;i++) {
                System.out.print("("+(i+1)+")"+map.get(Question[i])+" ");
            }
            System.out.print(">>");

            String space=sc.next();
            int Answer;
            boolean check=false;

            try{
                Integer.parseInt(space);
                check=true;
            }
            catch(NumberFormatException e){}

            if(check==false) {
                System.out.println("숫자를 입력하세요!!");
                continue;
            }
            else{
                Answer=Integer.parseInt(space);
            }

            if (Answer == -1) {
                break;}

            if((Answer)-1==ind)
                System.out.println("Exellent!!");
            else
                System.out.println("No!!");
        }

    }
    void insert(){
        System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
        while(true) {
            String buf1;
            String buf2;
            System.out.print("영어 한글 입렵 >>");
            buf1 = sc.next();

            if(buf1.equals("그만")) {
                System.out.println('\n');
                break;
            }
            buf2 = sc.next();

            map.put(buf1,buf2);
        }
    }
   void exit(){
        System.out.println("프로그램을 종료합니다.");
    }
    void error() {
        System.out.println("잘못 입력하셨습니다.");
    }
    void show(String s) {
        System.out.println("**** 영어 단어 테스트 " + '"' + s+ '"' + " 명품영어입니다. ****");
    }
    public static void main(String[] args) {
        JavaStudy js=new JavaStudy();
        js.show("명품영어");
        js.run();
    }
}
