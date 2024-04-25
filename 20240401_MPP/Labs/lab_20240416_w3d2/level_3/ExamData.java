package lab_20240416_w3d2.level_3;


import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.ArrayList;

public class ExamData {
    private String studentName;
    private double testScore;

    public ExamData(String name, double score) {
        studentName = name;
        testScore = score;
    }

    public static void main(String[] args) {
        List<ExamData> data = new ArrayList<ExamData>() {
            {
                add(new ExamData("George", 91.3));
                add(new ExamData("Tom", 88.9));
                add(new ExamData("Rick", 80));
                add(new ExamData("Harold", 90.8));
                add(new ExamData("Ignatius", 60.9));
                add(new ExamData("Anna", 77));
                add(new ExamData("Susan", 87.3));
                add(new ExamData("Phil", 99.1));
                add(new ExamData("Alex", 84));
            }
        };

        DoubleSummaryStatistics dss = data.stream().mapToDouble(e -> e.testScore).summaryStatistics();
        System.out.printf("Top Score: %.2f\n" +
                        "Lowest test score: %.2f\n" +
                        "Average test score: %.2f\n",
                dss.getMax(),
                dss.getMin(),
                dss.getAverage());
    }
}

