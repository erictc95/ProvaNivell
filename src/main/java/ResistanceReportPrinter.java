import java.util.List;

public class ResistanceReportPrinter {
    public void printReport(List<ResistanceEvaluable> robots) {
        System.out.println("=== RESISTANCE TEST REPORT ===");
        for (ResistanceEvaluable robot : robots) {
            System.out.println(robot.getResistanceReport());
            System.out.println();
        }
    }
}
