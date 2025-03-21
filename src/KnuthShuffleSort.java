import java.util.Random;

public class KnuthShuffleSort {

     public static class Student {
        private String name;
        private int age;
        private double gpa;

        public Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return name + ": " + age + " years old, GPA: " + gpa;
        }
    }

    public static class Date {
        private int month, day, year;

        public Date(int m, int d, int y) {
            month = m;
            day = d;
            year = y;
        }

        @Override
        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }

    public static void shuffle(Object[] a) {
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(i + 1);  
            exch(a, i, r);                
        }
    }

    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        Student[] students = {
            new Student("Alice", 20, 3.5),
            new Student("Bob", 22, 3.8),
            new Student("Charlie", 19, 3.2),
            new Student("Dave", 21, 3.9)
        };

        Date[] dates = {
            new Date(2, 23, 2004),
            new Date(5, 19, 1974),
            new Date(1, 9, 1965)
        };

        System.out.println("Before shuffle (Students):");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println();
        KnuthShuffleSort.shuffle(students);

        System.out.println("After shuffle (Students):");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("--------------------");

        System.out.println("Before shuffle (Dates):");
        for (Date d : dates) {
            System.out.println(d);
        }

        System.out.println();
        KnuthShuffleSort.shuffle(dates);

        System.out.println("After shuffle (Dates):");
        for (Date d : dates) {
            System.out.println(d);
        }
    }
}
