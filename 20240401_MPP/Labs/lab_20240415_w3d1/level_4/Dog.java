package lab_20240415_w3d1.level_4;

public final class Dog {
    private final String name;
    public void bark(){
        System.out.println("Bark");
    }

    public String getName() {
        return name;
    }


    public Dog(String name) {
        this.name = name;
    }
}
