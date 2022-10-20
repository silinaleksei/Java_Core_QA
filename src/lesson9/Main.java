package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("Physics");
        Course course2 = new Course("Biology");
        Course course3 = new Course("Mathematics");
        Course course4 = new Course("Philosophy");
        Course course5 = new Course("Chemistry");
        // List<Course> allCourses = new ArrayList<>(List.of(course1, course2, course3, course4, course5));
        List<Course> coursesIvan = new ArrayList<>(List.of(course1, course3,course4, course5));
        List<Course> coursesPetr = new ArrayList<>(List.of(course1, course2, course4));
        List<Course> coursesElena = new ArrayList<>(List.of(course2, course5));
        List<Course> coursesMaria = new ArrayList<>(List.of(course1, course2, course3, course4, course5));
        List<Course> coursesAndrey = new ArrayList<>(List.of(course4));
        Student student1 = new Student("Ivan", coursesIvan);
        Student student2 = new Student("Petr", coursesPetr);
        Student student3 = new Student("Elena", coursesElena);
        Student student4 = new Student("Maria", coursesMaria);
        Student student5 = new Student("Andrey", coursesAndrey);
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5));
        //System.out.println(students);

        System.out.println("Task 1: ");
        /* 1. Написать функцию, принимающую список Student и
              возвращающую список уникальных курсов, на которые подписаны студенты. */
        //  с помощью метода distinct():
        students.stream().flatMap(student -> student.getAllCourses().stream()).distinct().forEach(System.out::println); // Course{Physics'}Course{Mathematics'}Course{Chemistry'}Course{Biology'}Course{Philosophy'}
        //  с помощью создания коллекции уникальных значений Set:
        Set<Course> uniqueSet = students.stream().flatMap(student -> student.getAllCourses().stream()).collect(Collectors.toSet());
        System.out.println(uniqueSet); // [Course{Chemistry}, Course{Mathematics}, Course{Biology}, Course{Physics}, Course{Philosophy}]

        System.out.println("Task 2: ");
        /*2. Написать функцию, принимающую на вход список Student и возвращающую
             список из трех самых любознательных (любознательность определяется количеством курсов).*/
        List<Student> curiousStudents = students.stream().sorted((x, y) -> y.getAllCourses().size() - x.getAllCourses().size()).limit(3).toList();
        System.out.println(curiousStudents); // Maria, Ivan, Petr

        System.out.println("Task 3: ");
        /*3. Написать функцию, принимающую на вход список Student и экземпляр Course,
             возвращающую список студентов, которые посещают этот курс */
        students.stream().filter(e -> e.getAllCourses().contains(course3)).forEach(System.out::println); // Ivan, Maria => course3 = Mathematics

    }
}
