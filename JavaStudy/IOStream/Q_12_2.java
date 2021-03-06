import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Q_12_2 {
    Scanner sc=new Scanner(System.in);
    ArrayList<String> list=new ArrayList<>();

    public String input(){
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더 안에 있어야합니다.");
        System.out.print("대상 파일명 입력>>");
        String str=sc.nextLine();

        return str;
    }

    public boolean readfile(String filename){
        int i=0;
        try{
            BufferedReader br=new BufferedReader(new FileReader(filename));
            while(true) {
                StringBuilder lineb=new StringBuilder();

                lineb.append(i);
                lineb.append(": ");
                String str=br.readLine();
                if(str==null)
                    break;
                lineb.append(str);
                String line=lineb.toString();
                list.add(line); // 한 라인을 벡터에 저장
                i++;
            }
        }
        catch(IOException e){
            System.out.println("파일을 읽지 못하였습니다.");
            return false;
        }
        return true;
    }
    public void search(){
        String str;
        int count;
        while(true){
            System.out.print("검색할 단어나 문장>>");
            str=sc.nextLine();

            if(str.equals("그만")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            count=0;
            for(String s:list){
                if(s.contains(str)){
                    System.out.println(s);
                    count++;
                }
            }

            if(count==0)
                System.out.println("찾고자하는 단어 혹은 문장이 없습니다.");
        }
    }

    public void run(){
        boolean bl=readfile(input());
        if(bl==true){
            search();
        }
        else
            System.out.println("프로그램을 종료합니다.");
    }
    public static void main(String[] args) {
        Q_12_2 q=new Q_12_2();
        q.run();
    }
}
