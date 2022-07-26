public abstract class AbstractVehicle implements Vehicle {
    protected String description;
    private Engine engine;
    private Vehicle.Colour colour;
    public AbstractVehicle(Engine engine){
        this(engine, Colour.UNPAINTED);
    }
    public AbstractVehicle(Engine engine, Vehicle.Colour colour){
        this.engine=engine;
        this.colour=colour;
    }
    public Engine getEngine(){
        return engine;
    }
    public Vehicle.Colour getColour(){
        return colour;
    }
    public void paint(Vehicle.Colour colour){
        this.colour=colour;
    }

    @Override
    public String toString() {
        return getDescription()+
                "("+engine+", "+colour+
                ", price "+getPrice()+")";
    }
}
