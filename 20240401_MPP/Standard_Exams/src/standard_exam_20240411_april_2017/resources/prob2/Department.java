package standard_exam_20240411_april_2017.resources.prob2;

public abstract class Department {
    private StringQueue queue = new StringQueue();

    public StringQueue getQueue() {
        return queue;
    }
    //implement

    public abstract String getName();
}
