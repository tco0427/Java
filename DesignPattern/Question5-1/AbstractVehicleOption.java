public abstract class AbstractVehicleOption extends AbstractVehicle {
    protected Vehicle decoratedVehicle;

    public AbstractVehicleOption(Vehicle vehicle) {
        super(vehicle.getEngine(),vehicle.getColour());
        decoratedVehicle = vehicle;
    }
    @Override
    public abstract int getPrice();
    @Override
    public String getDescription(){
        return getClass().getSimpleName()+","+decoratedVehicle.getDescription();
    }
}
