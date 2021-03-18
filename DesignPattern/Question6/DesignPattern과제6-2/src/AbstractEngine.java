//Engine인터페이스를 구현하는 (추상)클래스
//엔진에 관련된 속성(필드)들을 추가하였다.
//엔진에 관한 기능(메소드)을 구체화하였다.
//이를 상속하는 StandardEngine과 TurboEngine을 통해 표준엔진과 터보엔진 인스턴스를 생성하도록 하였다.
public abstract class AbstractEngine implements Engine {
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
}
