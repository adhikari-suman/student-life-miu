package lesson3.immutable;

/** 
 * This is an example of an immutable class.
 * See the Lesson 3 slides for a list of characteristics
 */
public final class Contacts {

    private final String name;
    private final String mobile;

    public Contacts(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }
  
    public String getName(){
        return name;
    }
  
    public String getMobile(){
        return mobile;
    }
    
    //no setters
    
}