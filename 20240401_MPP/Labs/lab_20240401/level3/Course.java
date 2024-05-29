package lab_20240401.level3;

public class Course {
    private String title;
    private String number;
    private int units;

    public Course(String number , String title, int units) {
        this.title = title;
        this.number = number;
        this.units = units;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
