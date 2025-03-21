
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student[] students = {
            new Student("Ali", 2),
            new Student("Zeynep", 1),
            new Student("Mehmet", 3),
            new Student("Ayşe", 2)
        };
        
        System.out.println("Sorting according to name:");
        Student[] nameSorted = Arrays.copyOf(students, students.length); 
        SortComparator.sort(nameSorted, Student.BY_NAME);
        printStudents(nameSorted);

        System.out.println("Sorting according to section:");
        Student[] sectionSorted = Arrays.copyOf(students, students.length); 
        SortComparator.sort(sectionSorted, Student.BY_SECTION);
        printStudents(sectionSorted);
    }

    private static void printStudents(Student[] students) {
        for (Student s : students) {
            System.out.println(s.getName() + " - " + s.getSection());
        }
        System.out.println();
    }
}

