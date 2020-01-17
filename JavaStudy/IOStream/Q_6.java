import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class Q_6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야합니다.");
        System.out.print("첫번째 파일 이름을 입력하세요>>");
        String str1=sc.nextLine();

        System.out.print("두번째 파일 이름을 입력하세요>>");
        String str2=sc.nextLine();

        File f1=new File(str1);
        File f2=new File(str2);

        FileReader fr1=null;
        FileReader fr2=null;
        FileWriter fw=null;


        try{
            fr1=new FileReader(f1);
            fr2=new FileReader(f2);
            fw=new FileWriter("elvis3.txt");
            int data;
            while(true){
                data=fr1.read();
                if(data==-1)
                    break;

                fw.write(data);
            }
            while(true){
                data=fr2.read();
                if(data==-1)
                    break;

                fw.write(data);
            }


            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
