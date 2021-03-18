public class StandardGearboxStrategy implements GearboxStrategy{
    @Override
    public void ensureCorrectGear(Engine engine,int speed){
        System.out.println("Working out correct gear at "+speed+"mph for a STANDARD gearbox");
    }
}
