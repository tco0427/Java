public abstract class AbstractCar extends AbstractVehicle {
    public AbstractCar(Engine engine) {
        super(engine);
        description=getClass().getSimpleName();
    }
    public AbstractCar(Engine engine, Colour colour) {
        super(engine, colour);
        description=getClass().getSimpleName();
    }
    @Override
    public abstract int getPrice();
    public String getDescription(){
        return description;
    }
}
