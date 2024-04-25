package lab_20240415_w3d1.level_4;

public class IPersonMain {
    public static void main(String[] args) {
        Student leeJohnson = new Student("Lee Johnson", "472-6009", 19, 3.65);

        // Tests here for IPerson
        leeJohnson.myDefault();
        IPerson.myStatic();
        leeJohnson.myMethod();
    }
}
