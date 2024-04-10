package lab_20240403.level2;

public class Zone {
    private int id;
    private String name;
    private State code;

    public Zone(int id, String name, State code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getCode() {
        return code;
    }

    public void setCode(State code) {
        this.code = code;
    }
}
