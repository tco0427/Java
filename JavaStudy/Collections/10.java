import java.util.Scanner;
import java.util.Vector;

abstract class Shape{
    public abstract void draw();
}
class Line extends Shape{
    public void draw(){
        System.out.println("Line");
    }
}
class Rect extends Shape{
    public void draw(){
        System.out.println("Rect");
    }
}
class Circle extends Shape{
    public void draw(){
        System.out.println("Circle");
    }
}
public class Study{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Vector<Shape> vec=new Vector<>();
        System.out.println("그래픽 에디터 beauty을 실행합니다.");

        while(true){
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            Integer menu=sc.nextInt();
            if(menu==1){
                System.out.print("Line(1),Rect(2),Circle(3)>>");
                int sh=sc.nextInt();
                if(sh==1){
                    vec.add(new Line());
                }
                else if(sh==2){
                    vec.add(new Rect());
                }
                else if(sh==3){
                    vec.add(new Circle());
                }
                else
                    System.out.println("잘못된 입력입니다.");
            }
            else if(menu==2){
                System.out.print("삭제할 도형의 위치>>");
                int loc=sc.nextInt();
                loc=loc-1;
                int size=vec.size();
                if(loc>size)
                    System.out.println("삭제할 수 없습니다.");
                else {
                    vec.remove(loc);
                    System.out.println("삭제 완료");
                }
            }
            else if(menu==3){
                int size=vec.size();

                for(int i=0;i<size;i++){
                    vec.get(i).draw();
                }
            }
            else if(menu==4){
                System.out.println("beauty를 종료합니다.");
                break;
            }
            else
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }
}
