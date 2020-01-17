import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;


public class Q6 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("비교할 파일은 프로젝 폴더에 있어야합니다.(경로명이 아닌 경우)");
        System.out.print("첫번째 파일 이름을 입력하시오.>>");
        String file1=sc.nextLine();
        System.out.print("두번째 파일 이름을 입력하시오.>>");
        String file2=sc.nextLine();

        File f1=new File(file1);
        File f2=new File(file2);

        FileInputStream fi1=null;
        FileInputStream fi2=null;
        try{
            fi1=new FileInputStream(f1);
            fi2=new FileInputStream(f2);

            if(compare(fi1,fi2))
                System.out.println("파일이 같습니다.");
            else
                System.out.println("파일이 다릅니다.");


        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static boolean compare(FileInputStream fi1,FileInputStream fi2){
        int data1,data2;

        try {
            while (true) {
                data1 = fi1.read();
                data2 = fi2.read();

                if(data1==-1&&data2!=-1)
                    return false;

                if(data1==-1)
                    break;

                if(data1!=data2)
                    return false;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }
}
