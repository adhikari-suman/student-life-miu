package standard_exam_20240411_april_2017.prob2_solution;

public abstract class Department {
    private StringQueue queue = new StringQueue();

    public StringQueue getQueue() {
        return queue;
    }
    //implement

    public abstract String getName();

    public void addMessage(String message) {
        queue.enqueue(message);
    }

    public String nextMessage() throws EmptyQueueException {
        return queue.dequeue();
    }
}
