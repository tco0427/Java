package Lab5;
import java.util.Scanner;

enum FigureMode{
    CIRCLE,TRIANGLE,TRAPEZOID,RECTANGLE,PARALLELOGRAM,RHOMBUS
}
enum CalculateMode{
    AREA,PERIMETER,BOTH;
}

class Lab5{
    public static void main(String[] args) {
        Lab5 main=new Lab5();
        main.run();
    }
    void run(){
        FigureCalculator.calculate();
    }
}

abstract class Figure{
    public abstract double area();
    public abstract double perimeter();
    public abstract void getAdditionalUserInput(CalculateMode mode);
}
class FigureCalculator{
    static Figure figure=null;
    public static void calculate(){
        UserInput ui=new UserInput();
        CalculateMode cm=ui.getCalculateMode();
        FigureMode fm=ui.getFigureMode();

        figure=FigureFactory.getInstance(fm);
        figure.getAdditionalUserInput(cm);
        calculate(cm);
    }
    public static void calculate(CalculateMode cm){
        switch(cm){
            case AREA:
                System.out.println("면적: "+figure.area());
                break;
            case PERIMETER:
                System.out.println("길이: "+figure.perimeter());
                break;
            case BOTH:
                System.out.println("면적: "+figure.area()+", "+"길이: "+figure.perimeter());
                break;
        }
    }
}
class FigureFactory{
    public static Figure getInstance(FigureMode mode){
        Figure result=null;
        switch(mode) {
            case CIRCLE:
                result=new Circle();
                break;
            case TRIANGLE:
                result=new Triangle();
                break;
            case TRAPEZOID:
                result=new Trapezoid();
                break;
            case RECTANGLE:
                result=new Rectangle();
                break;
            case PARALLELOGRAM:
                result=new Parallelogram();
                break;
            case RHOMBUS:
                result=new Rhombus();
        }
        return result;
    }
}
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
    CalculateMode getCalculateMode(){
        CalculateMode cm=null;
        boolean check=true;
        while(check){
            try{
                System.out.println("면적:AREA\n길이:PERIMETER\n둘 다:BOTH");
                System.out.print("계산 방법을 입력하시오.");
                String input=sc.nextLine();
                cm=CalculateMode.valueOf(input);
                if(cm!=null){
                    check=false;
                }
            }
            catch(Exception e){
                System.out.println("잘못된 입력입니다.");
                check=true;
            }
        }
        return cm;
    }
    static double inputDouble(){
        return sc.nextDouble();
    }
}
class Circle extends Figure {
    double radius;
    Circle(){};
    double diameter(){return 2*radius; }
    public double area(){return Math.PI*radius*radius; }
    public double perimeter(){return Math.PI*radius; }
    public FigureMode getMode(){return FigureMode.CIRCLE;}
    public void getAdditionalUserInput(CalculateMode mode){
        System.out.print("반지름을 입력하시오: ");
        radius=UserInput.inputDouble();}
}
class Triangle extends Figure{
    double base,height,side;
    Triangle(){};
    public double area(){return base*height/2.0; }
    public double perimeter(){return base+height+side; }
    public FigureMode getMode(){return FigureMode.TRIANGLE;}
    public void getAdditionalUserInput(CalculateMode mode){
        System.out.print("삼각형의 밑변과 높이, 빗변을 입력하시오: ");
        base= UserInput.inputDouble();
        height= UserInput.inputDouble();
        side= UserInput.inputDouble();
    }
}
class Rectangle extends Figure{
    double length,width;
    Rectangle(){};
    public double area(){return length*width; }
    public double perimeter(){return 2*(length+width); }
    public FigureMode getMode(){return FigureMode.RECTANGLE;}
    public void getAdditionalUserInput(CalculateMode mode){
        System.out.print("사각형의 밑변과 높이를 입력하시오: ");
        length= UserInput.inputDouble();
        width= UserInput.inputDouble();
    }
}
class Trapezoid extends Figure{
    double top, bottom, height, side;
    Trapezoid(){};
    public double area(){return (top+bottom)*height/2.0; }
    public double perimeter(){return top+bottom+side+side;}
    public FigureMode getMode(){return FigureMode.TRAPEZOID;}
    public void getAdditionalUserInput(CalculateMode mode){
        System.out.print("사다리꼴의 윗변, 아랫변과 높이,빗변 길를 입력하시오: ");
        top = UserInput.inputDouble();
        bottom = UserInput.inputDouble();
        height = UserInput.inputDouble();
        side = UserInput.inputDouble();
    }
}
class Parallelogram extends Figure{
    double side,base,angle;
    Parallelogram(){};
    double height(){return side*Math.sin(angle);}
    public double area(){return base*height();}
    public double perimeter(){return 2*(side+base);}
    public FigureMode getMode(){return FigureMode.PARALLELOGRAM;}

    public void getAdditionalUserInput(CalculateMode mode){
        System.out.print("평행사변형의 밑변과 높이와 각도를 입력하시오: ");
        base= UserInput.inputDouble();
        side= UserInput.inputDouble();
        angle= UserInput.inputDouble();
    }
}
class Rhombus extends Figure{
    double side1,side2,angle;
    Rhombus(){};
    public double area(){return side1*side2*Math.sin(angle);}
    public double perimeter(){return 2*(side1+side2);}
    public FigureMode getMode(){return FigureMode.RHOMBUS;}
    public void getAdditionalUserInput(CalculateMode mode) {
        System.out.print("마름모의 두 대각선 길이와 각도를 입력하시오: ");
        side1 = UserInput.inputDouble();
        side2= UserInput.inputDouble();
        angle = UserInput.inputDouble();
    }
}
