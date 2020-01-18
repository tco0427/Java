import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Q_11 {
    Scanner sc=new Scanner(System.in);
    private ArrayList<String> list=new ArrayList<>();

    public boolean readfile(){
        try(BufferedReader br=new BufferedReader(new FileReader("words.txt"))){

            while(true){
                String str=br.readLine();
                if(str==null)
                    break;

                list.add(str);
            }
        }
        catch(IOException e){
            System.out.println("words.txt 파일을 읽는데 실패하였습니다.");
            return false;
        }
        System.out.println("프로젝트 폴더 밑의 words.txt 파일을 읽었습니다...");
        return true;
    }

    public void search(){
        while(true){
            System.out.print("단어>>");
            String st=sc.nextLine();

            if(st.equals("그만")){
                System.out.println("종료합니다.");
                break;
            }

            int len=st.length();
            int count=0;
            for(Iterator<String> itr=list.iterator();itr.hasNext();) {
                String s = itr.next();

                //문자열의 길이가 substring으로 자르려는 문자열의 길이보다 작을 경우->예외 발생
                //ex. st="lov" s="l"이면 오류발생
                if(s.length()<st.length())
                    continue;

                if (s.substring(0,len).equals(st)) {
                    System.out.println(s);
                    count++;
                }
            }
            if(count<=0)
                System.out.println("발견할 수 없음");
        }
    }
    public static void main(String[] args) {
        Q_11 run=new Q_11();

        boolean bl=run.readfile();
        if(bl==true)
            run.search();
        else
            System.out.println("프로그램을 종료합니다.");
    }
}
