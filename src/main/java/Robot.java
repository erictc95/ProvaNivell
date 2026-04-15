import java.time.LocalDateTime;

public abstract class Robot {
    private String name;
    private String brand;
    private int yearDate;
    private LocalDateTime registerDate;

    public Robot (String name, String brand, int yearDate) {
        this.name = name;
        this.brand = brand;
        validateYear(yearDate);
        this.yearDate = yearDate;
        this.registerDate = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearDate() {
        return yearDate;
    }

    public void setYearDate(int yearDate) {
        validateYear(yearDate);
        this.yearDate = yearDate;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", yearDate=" + yearDate +
                ", registerDate=" + registerDate +
                '}';
    }

    public abstract String getTechnicalDescription();

    private void validateYear(int yearDate) {
        int currentYear = LocalDateTime.now().getYear();
        if (yearDate < 0 || yearDate > currentYear) {
            throw new IllegalArgumentException("Invalid manufacturing year");
        }
    }
}
