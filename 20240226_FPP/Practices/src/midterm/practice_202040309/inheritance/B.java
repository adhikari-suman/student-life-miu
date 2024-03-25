package midterm.practice_202040309.inheritance;

public class B {
    static {
        System.out.println("Static block of B");
    }

    {
        System.out.println("Initialization block of B");
    }

    public B() {
        System.out.println("Constructor of B");
    }
}
