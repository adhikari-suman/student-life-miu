package lab_20240401.level2;

public abstract class Person {
    private String name;
    private String phone;
    private int age;

    public Person(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary(){
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %-15s Phone: %-10s Age: %-3d Type: %s",name,phone,age, this.getClass().getSimpleName().toLowerCase());
    }
}
