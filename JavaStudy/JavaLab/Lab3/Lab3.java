package Lab3;
import java.util.Scanner;

enum FigureMode{
    CIRCLE,TRIANGLE,TRAPEZOID,RECTANGLE,PARALLELOGRAM,RHOMBUS
}
public class Lab3 {
    double[] circleData = {5.5, 4.5, 3.5, 2.5, 1.5};
    double[][] triangleData = {{6.5,5.5}, {4.5,3.5}, {2.5,1.5}};
    double[][] trapezoidData = {{16.5,15.5,14.5}, {14.5,13.5,12.5}};
    double[][] rectangleData={{3.5,2.5},{2,4},{42.3,19.2}};
    double[][] parallelogramData={{34.5,49.5},{4.5,9.3}};
    double[][] rhombusData={{8.5,2.33},{12.31,26.32},{12.3,20.33}};
    double[][][] Datas={
            {circleData},
            triangleData,
            trapezoidData,
            rectangleData,
            parallelogramData,
            rhombusData
    };
    UserInput ui=new UserInput();

    public static void main(String[] args) {
        Lab3 main=new Lab3();
        main.run();
    }

    void run(){
        FigureMode mode=null;
        while(true) {
            System.out.println("1. 도형번호로 면적 구하기");
            System.out.println("2. 도형이름으로 면적 구하기");
            System.out.println("3. 도형Mode명으로 면적 구하기");
            System.out.println("(단, 입력은 모두 도형의 이름으로 동일하다)");
            System.out.print("메뉴를 선택하시오('그만'입력시 종료)>>");
            String menu = UserInput.inputString();
            if(menu.equals("그만")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (menu.equals("1")) {
                mode = ui.getFigureMode();
                calculate(mode.ordinal());
            } else if (menu.equals("2")) {
                mode = ui.getFigureMode();
                calculate(mode.toString());
            } else if (menu.equals("3")) {
                calculate();
            }
        }
    }

    //계산 메소드들
    void calculate(){
        FigureMode mode=ui.getFigureMode();
        double result=area(mode);
        compare(result);
        System.out.println("도형의 넓이: "+result);
    }
    void calculate(int mode){
        double result=area(mode);
        compare(result);
        System.out.println("도형의 넓이: "+result);
    }
    void calculate(String name){
        double result=area(name);
        compare(result);
        System.out.println("도형의 넓이: "+result);
    }

    //면적 비교 메소드
    void compare(double result){
        if(result<=50){
            System.out.println("도형의 면적이 50이하입니다.");
        }
        else if(50<result&&result<=70){
            System.out.println("도형의 면적이 50초과 70이하입니다.");
        }
        else if(result>70){
            System.out.println("도형의 면적이 70초과입니다.");
        }
    }

    //면적 구하기 메소드들
    double area(String name){
        double result=0;
        switch(name){
            case "CIRCLE":
                result=circleArea();
                break;
            case "TRIANGLE":
                result=triArea();
                break;
            case "TRAPEZOID":
                result=traArea();
                break;
            case "RECTANGLE":
                result=rectArea();
                break;
            case "PARALLELOGRAM":
                result=paraArea();
                break;
            case "RHOMBUS":
                result=rhoArea();
                break;
        }
        return result;
    }
    double area(int value){
        double result=0;
        switch(value){
            case 0:
                result=circleArea();
                break;
            case 1:
                result=triArea();
                break;
            case 2:
                result=traArea();
                break;
            case 3:
                result=rectArea();
                break;
            case 4:
                result=paraArea();
                break;
            case 5:
                result=rhoArea();
                break;
        }
        return result;
    }
    double area(FigureMode mode){
        double result=0;
        switch(mode) {
            case CIRCLE:
                result=circleArea();
                break;
            case TRIANGLE:
                result=triArea();
                break;
            case TRAPEZOID:
                result=traArea();
                break;
            case RECTANGLE:
                result=rectArea();
                break;
            case PARALLELOGRAM:
                result=paraArea();
                break;
            case RHOMBUS:
                result=rhoArea();
                break;
       }
        return result;
    }

    //도형별 면적 계산 메소드들
    double rhoArea(){
        System.out.print("마름모의 두 대각선 길이를 입력하시오: ");
        double a=UserInput.inputDouble();
        double b=UserInput.inputDouble();
        return (a*b)/2;
    }
    double paraArea(){
        System.out.print("평행사변형의 밑변과 높이를 입력하시오: ");
        double a=UserInput.inputDouble();
        double h=UserInput.inputDouble();
        return a*h;
    }
    double rectArea(){
        System.out.print("사각형의 밑변과 높이를 입력하시오: ");
        double a=UserInput.inputDouble();
        double b=UserInput.inputDouble();
        return a*b;
    }
    double traArea(){
        System.out.print("사다리꼴의 윗변, 아랫변과 높이를 입력하시오: ");
        double a = UserInput.inputDouble();
        double b = UserInput.inputDouble();
        double h = UserInput.inputDouble();
        return ((a+b)/2)*h;
    }
    double triArea(){
        System.out.print("밑변과 높이를 입력하시오: ");
        double w = UserInput.inputDouble();
        double h = UserInput.inputDouble();
        return w*h*0.5;
    }
    double circleArea(){
        System.out.print("반지름을 입력하시오: ");
        double r=UserInput.inputDouble();
        return r*r*Math.PI;
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
                System.out.print("도형의 모드(이름)을 입력하시오: ");
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
