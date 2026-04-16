import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RobotsMain {

    public static void main(String[] args) {

        List<Robot> robotsList = createRobots();
        System.out.println("=== ROBOTS LIST ===");
        printRobots(robotsList);
        System.out.println("------------------------------------------");
        List<GroundRobot> filteredList = filterByGroundRobotsWithHighSpeed(robotsList);
        System.out.println("=== FAST GROUND ROBOTS (>30 km/h) ===");
        printRobots(filteredList);
        System.out.println("------------------------------------------");
        List<Robot> filteredListByManufactured = filterByManufactured(robotsList);
        System.out.println("=== ROBOTS MANUFACTURED BY AUTOMECH, HYDROWORKD AND SKYTECH ===");
        printRobots(filteredListByManufactured);
        System.out.println("------------------------------------------");
        List<ResistanceEvaluable> evaluable = filterResistanceEvaluableRobots(robotsList);
        ResistanceReportPrinter printer = new ResistanceReportPrinter();
        printer.printReport(evaluable);
        System.out.println("------------------------------------------");
    }

    private static List<ResistanceEvaluable> filterResistanceEvaluableRobots(List<Robot> robotsList) {
        List<ResistanceEvaluable> resistanceEvaluablesList = new ArrayList<>();
        for (Robot robot : robotsList) {
            if (robot instanceof ResistanceEvaluable) {
                resistanceEvaluablesList.add((ResistanceEvaluable) robot);
            }
        }
        return resistanceEvaluablesList;
    }

    private static List<Robot> filterByManufactured(List<Robot> robotsList) {
        return robotsList.stream()
                .filter(robot -> robot.getBrand().equalsIgnoreCase("AutoMech")
                        || robot.getBrand().equalsIgnoreCase("HydroWorks")
                        || robot.getBrand().equalsIgnoreCase("SkyTech"))
                .collect(Collectors.toList());
    }

    private static List<GroundRobot> filterByGroundRobotsWithHighSpeed(List<Robot> robotsList) {
        return robotsList.stream()
                .filter(robot -> robot instanceof GroundRobot)
                .map(robot -> (GroundRobot) robot)
                .filter(robot -> robot.getMaxSpeed() > 30)
                .collect(Collectors.toList());
    }

    private static void printRobots(List<? extends Robot> robotsList) {
        for (Robot robot : robotsList) {
            System.out.println(robot.getTechnicalDescription());
        }
    }

    private static List<Robot> createRobots() {

        List<Robot> robotsList = new ArrayList<>();

        GroundRobot groundRobot1 = new GroundRobot("TankBot", "RoboCorp", 2022, 40, TractionType.TRACKS);
        GroundRobot groundRobot2 = new GroundRobot("TerraMax", "RoboCorp", 2021, 35, TractionType.TRACKS);
        GroundRobot groundRobot3 = new GroundRobot("SpeedRunner", "AutoMech", 2023, 25, TractionType.WHEELS);
        GroundRobot groundRobot4 = new GroundRobot("HeavyTank", "RoboCorp", 2020, 25, TractionType.TRACKS);

        AquaticRobot aquaticRobot1 = new AquaticRobot("AquaRunner", "AquaTech", 2021, 500, PropulsionType.HELIX);
        AquaticRobot aquaticRobot2 = new AquaticRobot("DeepBlue", "AquaTech", 2019, 500, PropulsionType.HELIX);
        AquaticRobot aquaticRobot3 = new AquaticRobot("JetStream", "HydroWorks", 2022, 300, PropulsionType.JET);
        AquaticRobot aquaticRobot4 = new AquaticRobot("OceanExplorer", "AquaTech", 2024, 800, PropulsionType.HELIX);

        AerialRobot aerialRobot1 = new AerialRobot("SkyDancer", "AeroDynamics", 2023, 3000, 90);
        AerialRobot aerialRobot2 = new AerialRobot("SkyMaster", "AeroDynamics", 2024, 5000, 100);
        AerialRobot aerialRobot3 = new AerialRobot("FlyLite", "SkyTech", 2022, 1500, 45);
        AerialRobot aerialRobot4 = new AerialRobot("StormRider", "AeroDynamics", 2021, 3000, 120);


        robotsList.add(groundRobot1);
        robotsList.add(groundRobot2);
        robotsList.add(groundRobot3);
        robotsList.add(groundRobot4);
        robotsList.add(aquaticRobot1);
        robotsList.add(aquaticRobot2);
        robotsList.add(aquaticRobot3);
        robotsList.add(aquaticRobot4);
        robotsList.add(aerialRobot1);
        robotsList.add(aerialRobot2);
        robotsList.add(aerialRobot3);
        robotsList.add(aerialRobot4);
        return robotsList;
    }

}
