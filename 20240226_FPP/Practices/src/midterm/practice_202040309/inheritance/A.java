package midterm.practice_202040309.inheritance;

public class A extends B {
    static {
        System.out.println("Static block of A");
    }

    {
        System.out.println("Initialization block of A");
    }

    public A() {
        System.out.println("Constructor of A");
    }
}