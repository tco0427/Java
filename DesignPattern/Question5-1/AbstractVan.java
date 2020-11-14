public abstract class AbstractVan extends AbstractVehicle {
    public AbstractVan(Engine engine) {
        super(engine);
        description=getClass().getSimpleName();
    }

    public AbstractVan(Engine engine, Colour colour) {
        super(engine, colour);
        description=getClass().getSimpleName();
    }
    @Override
    public abstract int getPrice();
    @Override
    public String getDescription(){
        return description;
    }
}
