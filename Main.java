package NewLesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Jack", Arrays.asList(new Course("Java"), new Course("testing"), new Course("HR"))),
                new Student("Darya", Arrays.asList(new Course("HR"), new Course("HR_test"))),
                new Student("Kate", Arrays.asList(new Course("HTML"), new Course("Java")))
        ));
        System.out.println(students.stream()
                .map(student -> student.getCourses())
                .flatMap(courses -> courses.stream())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        Course course = new Course("Java");
        System.out.println(students.stream()
                .filter(student -> student.getCourses().contains(course))
                .collect(Collectors.toList()));

    }
}
