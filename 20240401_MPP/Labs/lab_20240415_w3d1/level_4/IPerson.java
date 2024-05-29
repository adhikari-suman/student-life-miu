package lab_20240415_w3d1.level_4;

public interface IPerson {
    default void myDefault() {
        System.out.println("From default method.");
    }

    static void myStatic() {
        System.out.println("From static method.");
    }

    void myMethod();
}
