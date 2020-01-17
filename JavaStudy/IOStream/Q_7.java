import java.util.Scanner;
import java.io.*;
import java.io.IOException;

public class Q_7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("a.jpg파일을 b.jpg파일로 복사합니다.");

        File ori=new File("a.jpg");
        File copy=new File("b.jpg");
        long len=ori.length();

        InputStream is=null;
        OutputStream os=null;

        try {
            is=new FileInputStream(ori);
            os=new FileOutputStream(copy);


            len=len/10;
            int data,count;
            count=0;
            while (true) {
                data=is.read();
                count++;
                if(data==-1)
                    break;

                os.write(data);

                if(count==len){
                    System.out.print("*");
                    count=0;
                }

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
