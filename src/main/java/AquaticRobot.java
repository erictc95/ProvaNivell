public class AquaticRobot extends Robot {

    private int maxDepth;
    private PropulsionType propulsionSystem ;

    public AquaticRobot(String name, String brand, int yearDate, int maxDepth, PropulsionType propulsionSystem) {
        super(name, brand, yearDate);
        this.maxDepth = maxDepth;
        this.propulsionSystem = propulsionSystem;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public PropulsionType getPropulsionSystem() {
        return propulsionSystem;
    }

    public void setPropulsionSystem(PropulsionType propulsionSystem) {
        this.propulsionSystem = propulsionSystem;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + " reaches depth of " + getMaxDepth() + " m using "
                + getPropulsionSystem() + " propulsion. Manufactured by " + getBrand() + " in " + getYearDate();
    }

}
