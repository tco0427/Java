import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

public class Q_8 {
    HashMap<String,Integer> map=new HashMap<>();
    Scanner sc=new Scanner(System.in);
    String name;
    Set<String> set;
    Iterator<String> itr;

    public void title(String s){
        this.name=s;
    }
    public void read(){
        while (true){
            System.out.print("이름과 포인트 입력>> ");
            String str=sc.next();
            if(str.equals("그만"))
                break;
            Integer point=sc.nextInt();

            pros(str,point);

            for(itr=set.iterator();itr.hasNext();){
                String buf=itr.next();
                System.out.print("("+buf+","+map.get(buf)+")");
            }
            System.out.println();
        }
    }
    public void pros(String str,Integer point){
        set=map.keySet();
        int check=0;
        for(itr=set.iterator();itr.hasNext();){
            String buf=itr.next();
            if(str.equals(buf)){
                Integer bufi=map.get(buf);
                bufi=bufi+point;
                map.put(buf,bufi);
                check=-1;
            }
        }
        if(check!=-1){
            map.put(str,point);

            set=map.keySet();
        }
    }
    public static void main(String[] args) {
        javastudy js=new javastudy();
        js.title("포인트 관리 프로그램입니다.");
        js.read();
    }
}
