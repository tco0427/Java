import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Study{
    Scanner sc=new Scanner(System.in);
    HashMap<String,String> hm=new HashMap<>();

    private void input(){
        int size=hm.size();
        System.out.println("현재 "+size+"개 나라와 수도가 입력되어 있습니다.");
        while(true) {
            size=size+1;
            System.out.print("나라와 수도 입력" + size  + ">>");
            String buf1 = sc.next();
            if (buf1.equals("그만"))
                break;

            if (contain(buf1)) {
                sc.nextLine();
                continue;
            }
            String buf2 = sc.next();

            hm.put(buf1,buf2);
        }


    }
    private void quiz(){
        Set<String> set=hm.keySet();
        Object [] array =set.toArray();
        while(true){
            int index = (int)(Math.random()*array.length);

            String q=(String)array[index];
            String a=hm.get(q);

            System.out.print(q+"의 수도는?");
            String buf=sc.next();

            if(buf.equals("그만"))
                break;

            if(a.equals(buf))
                System.out.println("정답!");
            else
                System.out.println("오답!");

        }
    }
    private void finish(){
        System.out.println("게임을 종료합니다.");
    }
    private void error(){
        System.out.println("에러입니다.");
    }

    public void run(){
        System.out.println("*** 수도 맞추기 게임을 시작합니다. ***");
        while(true){
            System.out.print("입력:1, 퀴즈: 2,종료: 3>>");
            int menu=sc.nextInt();
            if(menu==1)
                input();
            else if(menu==2)
                quiz();
            else if(menu==3) {
                finish();
                break;
            }
            else
                error();
        }
    }
    private boolean contain(String buf){
        int s=hm.size();
        Set<String> set=hm.keySet();

        for(Iterator<String> itr=set.iterator();itr.hasNext();){
            if(itr.next().equals(buf)){
                System.out.println(buf+"은/는 이미 있습니다!");
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Study game=new Study();
        game.run();
    }
}
