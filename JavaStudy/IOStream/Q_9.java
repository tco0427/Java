import java.io.*;


public class Q_9 {
    public static void main(String[] args) {
        File f=new File("/Users/dongkyu/IdeaProjects/JavaStudy");

        File farr[]=f.listFiles();

        int count=0;
        for(int i=0;i<farr.length;i++){
            if(!farr[i].isFile()) // 파일이 아니면 다음으로
                continue;

            String buf=farr[i].getName();
            int index = buf.lastIndexOf('.'); // 파일명 문자열에서 제일 마지막에 있는 '.' 의 인덱스
            if(index == -1) // 찾을 수 없음
                continue;

            //substring(int beginIndex) 즉,시작인덱스
            if(buf.substring(index).equals(".txt")){
                File df=new File(buf);
                df.delete();
                count++;
            }
        }

        System.out.println("총 "+count+"개의 .txt 파일을 삭제하였습니다.");

    }
}
