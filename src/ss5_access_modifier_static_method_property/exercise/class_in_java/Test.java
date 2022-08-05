package ss5_access_modifier_static_method_property.exercise.class_in_java;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Jenny");
        student.setClasses("C06");
        System.out.println(student.getName());
        System.out.println(student.getClasses());
    }
}
