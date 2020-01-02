import java.util.Scanner;
import java.util.Vector;

class Nation{
    String country;
    String capital;

    public Nation(String c1,String c2){
        this.country=c1;
        this.capital=c2;
    }
    public String getCountry(){
        return this.country;
    }
    public String getCapital(){
        return this.capital;
    }
}






public class Study{
    Scanner sc=new Scanner(System.in);
    Vector<Nation> vct=new  Vector<>();

    private void input(){
        int size=vct.size();
        System.out.println("현재 "+size+"개 나라와 수도가 입력되어 있습니다.");
        while(true) {
            size=size+1;
            System.out.print("나라와 수도 입력" + size  + ">>");
            String buf1 = sc.next();
            if (buf1.equals("그만"))
                break;

            if (contain(buf1)) {
                sc.nextLine();
                continue;
            }
            String buf2 = sc.next();

            vct.add(new Nation(buf1, buf2));
        }


    }
    private void quiz(){
        while(true){
            int index = (int)(Math.random()*vct.size());
            System.out.print(vct.get(index).getCountry()+"의 수도는?");
            String q=sc.next();

            if(q.equals("그만"))
                break;

            if(vct.get(index).getCapital().equals(q))
                System.out.println("정답!");
            else
                System.out.println("오답!");

        }
    }
    private void finish(){
        System.out.println("게임을 종료합니다.");
    }
    private void error(){
        System.out.println("에러입니다.");
    }

    public void run(){
        System.out.println("*** 수도 맞추기 게임을 시작합니다. ***");
        while(true){
            System.out.print("입력:1, 퀴즈: 2,종료: 3>>");
            int menu=sc.nextInt();
            if(menu==1)
                input();
            else if(menu==2)
                quiz();
            else if(menu==3){
                finish();
                break;
            }
            else
                error();
        }
    }
    private boolean contain(String buf){
        int s=vct.size();
        for(int i=0;i<s;i++) {
            if (vct.get(i).getCountry().equals(buf)) {
                System.out.println(buf+"은/는 이미 있습니다.");
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Study game=new Study();
        game.run();
    }
}
