package MyClass;
import java.util.ArrayList;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Friend> arr=new ArrayList<>();
        while(true){
            System.out.println("1. 대학친구");
            System.out.println("2. 회사친구");
            System.out.print("그만 입력시 종료>>");
            String menu=sc.nextLine();
            if(menu.equals("그만")){
                System.out.println("프로그램 종료");
                break;
            }
            if(menu.equals("1")){
                System.out.print("이름,전공,전화번호를 공백으로 구분하여 입력하시오>>");
                arr.add(new UnivFriend(sc.next(),sc.next(),sc.next()));
                sc.nextLine();
            }
            else if(menu.equals("2")){
                System.out.print("이름,부서,전화번호를 공백으로 구분하여 입력하시오>>");
                arr.add(new CompFriend(sc.next(),sc.next(),sc.next()));
                sc.nextLine();
            }
            else{
                System.out.println("메뉴를 잘못 선택하셨습니다.\n다시 입력해주세요");
            }
        }

        for(Friend f:arr){
            f.showInfo();
        }
    }
}

class Friend{
    protected String name;
    protected String phone;
    public Friend(String name,String phone){
        this.name=name;
        this.phone=phone;
    }
    public void showInfo(){
        System.out.println("이름: "+this.name);
        System.out.println("전화: "+this.phone);
    }
}
class UnivFriend extends Friend{
    private String major;
    public UnivFriend(String name,String phone,String major){
        super(name,phone);
        this.major=major;
    }
    public void showInfo(){
        super.showInfo();
        System.out.println("전공: "+this.major);
    }
}
class CompFriend extends Friend{
    private String department;
    public CompFriend(String name,String phone,String department){
        super(name,phone);
        this.department=department;
    }
    public void showInfo(){
        super.showInfo();
        System.out.println("부서: "+department);
    }
}
