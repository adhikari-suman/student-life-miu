package lab_20240415_w3d1.level_4;

import java.util.function.Consumer;

public class StudentTypeMain {
    public static void main(String[] args) {
        StudentType studentType1 = StudentType.ON_CAMPUS;
        StudentType studentType2 = StudentType.ONLINE;


       Consumer<StudentType> printStudentType = stdType ->
       {

          String msg =  switch (stdType){
               case ON_CAMPUS -> "On Campus Student";
               case ONLINE -> "Online Student";
           };
           System.out.println(msg);
       };

       printStudentType.accept(studentType1);
       printStudentType.accept(studentType2);

    }
}
