import java.lang.reflect.Method;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // Retrieve the class object for Student
        Class<Student> studentClass = Student.class;

        // Get all declared methods of the Student class
        Method[] methods = studentClass.getDeclaredMethods();

        // Sort the methods by their names in alphabetical order
        Arrays.sort(methods, (Method m1, Method m2) -> m1.getName().compareTo(m2.getName()));

        // Print the name of each method
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}

class Student {
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void anothermethod() { }

    // ... Other methods
}
