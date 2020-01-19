import java.io.*;
import java.util.Scanner;

public class Q_13 {
    File file=new File("/Users");
    Scanner sc=new Scanner(System.in);
    File[] list = file.listFiles();

    public static void main(String[] args) {
        Q_13 q_13=new Q_13();
        System.out.println("****** 파일 탐색기 입니다. ******");
        q_13.out();
        q_13.run();
    }

    void run(){
        while(true){
            System.out.print(">>");
            String str=sc.nextLine();
            if(str.equals("그만")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if(str.equals("..")){
                String result=file.getParent();
                file=new File(result);
            }
            else {
                String result = file.getAbsolutePath() + "/" + str;
                file = new File(result);
            }

            list=file.listFiles();
            out();


        }
    }

    void out(){
        System.out.println(file.getAbsolutePath());

        for (File e : list) {
            if (e.isFile()) {
                System.out.print("file" + "\t");
            } else {
                System.out.print("dir" + "\t\t");
            }
            System.out.printf("%7d",e.length());
            System.out.println("\t\t"+e.getName());
        }
    }
}
