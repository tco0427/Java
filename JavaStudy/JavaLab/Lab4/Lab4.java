package Lab4;
import org.w3c.dom.css.Rect;

import java.util.Scanner;

enum FigureMode{
    CIRCLE,TRIANGLE,TRAPEZOID,RECTANGLE,PARALLELOGRAM,RHOMBUS,SQUARE,KITE
}
public class Lab4 {
    UserInput ui=new UserInput();

    public static void main(String[] args) {
        Lab4 main=new Lab4();
        main.run();
    }

    void run(){
        while(true) {
            FigureMode mode=ui.getFigureMode();
            System.out.println("1.면적  2.둘레 3.둘다");
            System.out.print("'그만'입력시 종료>>");
            String menu = UserInput.inputString();
            if(menu.equals("그만")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            Shapes model=create(mode);
            if(menu.equals("1")){
                calculate(model);
            }
            else if(menu.equals("2")){
                calculate(model);
            }
            else if(menu.equals("3")){
                calculate(model);
                calculate2(model);
            }
            else{
                System.out.println("메뉴를 잘못 선택하셨습니다.");
            }
        }
    }

    //계산 메소드들
    void calculate(Shapes model){
        double result=model.area();
        System.out.println("도형의 넓이: "+result);
    }
    void calculate2(Shapes model){
        double result=model.perimeter();
        System.out.println("도형의 둘레: "+result);
    }
    Shapes create(FigureMode mode){
        Shapes model=null;
        switch(mode) {
            case CIRCLE:
                model=circleCreate();
                break;
            case TRIANGLE:
                model=triCreate();
                break;
            case TRAPEZOID:
                model=traCreate();
                break;
            case RECTANGLE:
                model=rectCreate();
                break;
            case PARALLELOGRAM:
                model=paraCreate();
                break;
            case RHOMBUS:
                model=rhoCreate();
                break;
        }
        UserInput.inputString();
        return model;
    }

    Shapes rhoCreate(){
        System.out.print("마름모의 두 대각선 길이와 각도를 입력하시오: ");
        double a=UserInput.inputDouble();
        double b=UserInput.inputDouble();
        double c=UserInput.inputDouble();
        Rhombus rho=new Rhombus(a,b,c);
        return rho;
    }
    Shapes paraCreate(){
        System.out.print("평행사변형의 밑변과 높이와 각도를 입력하시오: ");
        double a=UserInput.inputDouble();
        double h=UserInput.inputDouble();
        double c=UserInput.inputDouble();
        Parallelogram par=new Parallelogram(a,h,c);
        return par;
    }
    Shapes rectCreate(){
        System.out.print("사각형의 밑변과 높이를 입력하시오: ");
        double a=UserInput.inputDouble();
        double b=UserInput.inputDouble();
        Rectangle rect=new Rectangle(a,b);
        return rect;
    }
    Shapes traCreate(){
        System.out.print("사다리꼴의 윗변, 아랫변과 높이,빗변 길를 입력하시오: ");
        double a = UserInput.inputDouble();
        double b = UserInput.inputDouble();
        double c = UserInput.inputDouble();
        double h = UserInput.inputDouble();
        Trapezoid tra=new Trapezoid(a,b,h,c);
        return tra;
    }
    Shapes triCreate(){
        System.out.print("삼각형의 밑변과 높이, 빗변을 입력하시오: ");
        double w = UserInput.inputDouble();
        double h = UserInput.inputDouble();
        double l = UserInput.inputDouble();
        Triangle tri=new Triangle(w,h,l);
        return tri;
    }
    Shapes circleCreate(){
        System.out.print("원의 반지름을 입력하시오: ");
        double r=UserInput.inputDouble();
        Circle c=new Circle(r);
        return c;
    }
}

//입력 메소드들을 구현하는 클래스
class UserInput{
    static Scanner sc=new Scanner(System.in);
    FigureMode getFigureMode(){
        FigureMode fm=null;
        boolean check=true;
        //Exception Handling 추가
        //다시 입력받게끔
        while(check){
            try{
                System.out.print("원하는 도형 입력하시오: ");
                String input=sc.nextLine().toUpperCase();
                fm=FigureMode.valueOf(input);
                if(fm!=null) {
                    check = false;
                }
            }
            catch(Exception e){
                System.out.println("잘못된 입력입니다.");
                check=true;
            }
        }
        return fm;
    }
    static double inputDouble(){
        return sc.nextDouble();
    }
    static String inputString(){
        return sc.nextLine();
    }
}
interface Shapes{
    double area();
    double perimeter();
}
class Circle implements Shapes {
    double radius;
    Circle(double r){radius=r; }
    double diameter(){return 2*radius; }
    public double area(){return Math.PI*radius*radius; }
    public double perimeter(){return Math.PI*radius; }
}
class Triangle implements Shapes{
    double base,height,side;
    Triangle(double a,double b,double c){
        base=a;height=b;side=c;}
    public double area(){return base*height/2.0; }
    public double perimeter(){return base+height+side; }
}
class Rectangle implements Shapes{
    double length,width;
    Rectangle(double a,double b){
        length=a;width=b;}
    public double area(){return length*width; }
    public double perimeter(){return 2*(length+width); }
}
class Trapezoid implements Shapes{
    double top, bottom, height, side;
    Trapezoid(double a,double b,double c,double d){
        top=a;bottom=b;height=c;side=d; }
    public double area(){return (top+bottom)*height/2.0; }
    public double perimeter(){return top+bottom+side+side;}
}
class Parallelogram implements Shapes{
    double side,base,angle;
    Parallelogram(double a,double b,double c){
        side=a;base=b;angle=c; }
    double height(){return side*Math.sin(angle);}
    public double area(){return base*height();}
    public double perimeter(){return 2*(side+base);}
}
class Rhombus implements Shapes{
    double side,base,angle;
    Rhombus(double a,double b,double c){
        side=a;angle=b;base=c; }
    double height(){return side*Math.sin(angle);}
    public double area(){return base*height();}
    public double perimeter(){return 4*side;}
}
class Square implements Shapes{
    double length;
    Square(double a){length=a;}
    public double area(){return length*length;}
    public double perimeter(){return 4*length;}
}
class Kite implements Shapes{
    double side1,side2,angle;
    Kite(double a,double b,double c){
        side1=a;side2=b;angle=c; }
    public double area(){return side1*side2*Math.sin(angle);}
    public double perimeter(){return 2*(side1+side2);}
}
