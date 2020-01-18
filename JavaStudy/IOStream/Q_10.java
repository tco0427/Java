import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class Q_10 {
    public static void main(String[] args) {
        File f=new File("phone.txt");
        Scanner sc=new Scanner(System.in);

        try(BufferedReader fr=new BufferedReader(new FileReader(f))){
            ArrayList<String> arr=new ArrayList<>();

            while(true){
                String buf=fr.readLine();
                if(buf==null)
                    break;
                arr.add(buf);
            }

            System.out.println("총 "+arr.size()+"개의 전화번호를 읽었습니다.");

            HashMap<String,String> map=new HashMap<>();
            for(String s:arr){
                String buf[]=s.split(" ");
                String str1=buf[0];
                String str2=buf[1];

                map.put(str1,str2);
            }

            Set<String> set=map.keySet();
            int count=0;
            while(true){
                System.out.print("이름>> ");
                String name=sc.nextLine();

                if(name.equals("그만")){
                    System.out.println("프로그램 종료");
                    break;
                }

                for(String s:set){
                    if(s.equals(name)){
                        System.out.println(map.get(s));
                        count=0;
                        break;
                    }
                    else
                        count++;
                }
                if(count!=0)
                    System.out.println("전화번호 목록에 존재하지 않습니다.");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
