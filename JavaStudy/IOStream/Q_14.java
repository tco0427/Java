import java.io.*;
import java.util.Scanner;

public class Q_14 {
    File file=new File("/Users");
    Scanner sc=new Scanner(System.in);
    File[] list = file.listFiles();

    public static void main(String[] args) {
        Q_14 q_14=new Q_14();
        System.out.println("****** 파일 탐색기 입니다. ******");
        q_14.out();
        q_14.run();
    }

    void run(){
        while(true){
            System.out.print(">>");
            String str=sc.nextLine();
            if(str.equals("그만")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if(str.contains("rename")){
                String buf[]=str.split(" ");
                System.out.println(buf.length);
                if(buf.length==1){
                    System.out.println("기존 파일 이름과 변경할 파일 이름을 입력하시오.");
                    continue;
                }
                else if(buf.length==2){
                    System.out.println("두 개의 파일이 주어지지 않았습니다.");
                    continue;
                }
                else if(buf.length==3){
                    String ap=file.getAbsolutePath();
                    file=new File(ap,buf[1]);
                    file.renameTo(new File(ap,buf[2]));
                    System.out.println(buf[1]+"의 이름을"+buf[2]+"로 변경하였습니다.");
                    file=new File(ap);
                }
            }
            else if(str.contains("mkdir")){
                String buf[]=str.split(" ");
                if(buf.length==1){
                    System.out.println("새로 생성할 디렉토리 이름을 입력하시오.");
                    continue;
                }
                else if(buf.length>2){
                    System.out.println("잘못된 양식입니다.");
                    continue;
                }
                else if(buf.length==2){
                    String newf=file.getAbsolutePath();
                    File newdir=new File(newf,buf[1]);
                    if(newdir.exists()){
                        System.out.println("이미 존재하는 디렉토리 이름입니다.");
                    }
                    else{
                        newdir.mkdir();
                        file=new File(newf);
                        System.out.println(buf[1]+"디렉토리를 생성하였습니다.");
                    }
                }
            }
            else if(str.equals("..")){
                String result=file.getParent();
                file=new File(result);
            }
            else{
                String result = file.getAbsolutePath();
                file = new File(result,str);
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
            System.out.printf("%20d",e.length());
            System.out.println("\t\t"+e.getName());
        }
    }
}
