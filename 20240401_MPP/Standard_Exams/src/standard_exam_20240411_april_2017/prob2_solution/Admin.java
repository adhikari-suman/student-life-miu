package standard_exam_20240411_april_2017.prob2_solution;


public class Admin {
    //implement

    private Department[] departments;

    public Admin(Department[] departments) {
        this.departments = departments;
    }

    public String format(String name, String message) {
        return name + ": " + message;
    }

    public String hourlyCompanyMessage() {
        StringBuilder sb = new StringBuilder();

        for (Department d : departments) {
            try {
                sb.append(format(d.getName(), d.nextMessage()) + "\n");
            } catch (EmptyQueueException e) {
                // Do nothing for now
            }
        }

        return sb.toString();
    }
}
