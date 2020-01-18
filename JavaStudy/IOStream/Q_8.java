import java.io.*;

class Q_8 {
    public static void main(String[] args) {
        File f=new File("/Users");

        File farr[]=f.listFiles();
        System.out.println(farr.length);

        long max=0;
        for(int i=1;i<farr.length;i++){
            File buf=farr[i];
            if(buf.length()>farr[(int)max].length())
                max=i;
        }


        File result=farr[(int)max];

        System.out.println("가장 큰 파일은 "+result+"이고 크기는"+result.length()+"바이트 입니다.");

    }
}

