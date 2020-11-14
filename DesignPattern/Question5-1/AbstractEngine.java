//Engine인터페이스를 구현하는 (추상)클래스
//엔진에 관련된 속성(필드)들을 추가하였다.
//이를 상속하는 StandardEngine과 TurboEngine을 통해 표준엔진과 터보엔진 인스턴스를 생성하도록 하였다.
public abstract class AbstractEngine implements Engine {
    //인스턴스 변수 size와 turbo에 대해서 private로 정의해주었고 이에 대한 접근자를 정의해주었다.
    //캡슐화의 원칙을 지키기 위해 가능하면 필드에 대해서 접근 범위를 작게하는 것이 좋다.
    private int size;
    private boolean turbo;
    public AbstractEngine(int size,boolean turbo){
        this.size=size;
        this.turbo=turbo;
    }
    @Override
    public int getSize(){
        return this.size;
    }
    @Override
    public boolean isTurbo(){
        return this.turbo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+
                " ("+size+")";
    }
}
