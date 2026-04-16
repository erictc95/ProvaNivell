public class AerialRobot extends Robot implements ResistanceEvaluable {
    private int maxAltitude;
    private int flightAutonomy;

    public AerialRobot (String name, String brand, int yearDate, int maxAltitude, int flightAutonomy) {
        super(name, brand, yearDate);
        this.maxAltitude = maxAltitude;
        validateFlightAutonomy(flightAutonomy);
        this.flightAutonomy = flightAutonomy;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public int getFlightAutonomy() {
        return flightAutonomy;
    }

    public void setFlightAutonomy(int flightAutonomy) {
        validateFlightAutonomy(flightAutonomy);
        this.flightAutonomy = flightAutonomy;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + " flies up to " + getMaxAltitude() + " m for " + getFlightAutonomy()
                + " minutes. Manufactured by " + getBrand() + " in " + getYearDate() + ".";
    }

    private void validateFlightAutonomy(int flightAutonomy) {
        if (flightAutonomy < 0 ) {
            throw new IllegalArgumentException("Invalid Flight Autonomy");
        }
    }

    @Override
    public String getResistanceReport() {
        if (getFlightAutonomy() >= 60) {
            return getName() + ": " + getFlightAutonomy() + " minutes of autonomy. Suitable for the competition.";
        } else {
            return getName() + ": " + getFlightAutonomy() + " minutes of autonomy. Not suitable for the competition.";
        }
    }
}
