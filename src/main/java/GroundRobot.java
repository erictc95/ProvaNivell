public class GroundRobot extends Robot implements ResistanceEvaluable {
    private int maxSpeed;
    private TractionType typeOfTraction;

    public GroundRobot (String name, String brand, int yearDate, int maxSpeed, TractionType typeOfTraction) {
        super(name, brand, yearDate);
        this.maxSpeed = maxSpeed;
        this.typeOfTraction = typeOfTraction;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public TractionType getTypeOfTraction() {
        return typeOfTraction;
    }

    public void setTypeOfTraction(TractionType typeOfTraction) {
        this.typeOfTraction = typeOfTraction;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + ", manufactured by " + getBrand() + " in " + getYearDate()
                + ", uses " + getTypeOfTraction() + " and reaches up to " + getMaxSpeed()  + " km/h.";
    }

    @Override
    public String getResistanceReport() {
        if (getTypeOfTraction() == TractionType.TRACKS) {
            return getName() + ": " + getTypeOfTraction() + " traction confirmed. Suitable for the competition.";
        } else {
            return getName() + ": traction type " + getTypeOfTraction() + ". Not suitable for the competition.";
        }
    }
}
