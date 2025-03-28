
public class SelectionSort {
	
	// All the data type should implement  Comparable interface
    public static class Student implements Comparable<Student> {
        private String name;
        private int age;
        private double gpa;

        public Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        // I can choose one property for sorting, disadvantage part.
        @Override
        public int compareTo(Student that) {
           if (gpa < that.gpa)
        	   return -1;
           else if (gpa == that.gpa) 
        	   return +1;
           else 
        	   return 0;
        }

        @Override
        public String toString() {
            return name + ": " + age + " years old, GPA: " + gpa;
        }
    }
    
    public static class Date implements Comparable<Date> {
    	private int month, day, year;
    	
    	public Date(int m, int d, int y) {
    		month = m;
    		day = d;
    		year = y;
    	}
    	
    	@Override
    	public int compareTo(Date that) {
    		if (year < that.year) return -1;
    		if (year > that.year) return +1;
    		if (month < that.month) return-1;
    		if (month > that.month) return +1;
    		if (day < that.day) return -1;
    		if (day > that.day) return +1;
    		return 0;
    	}
    	
        @Override
        public String toString() {
            return month + "/" + day + "/" + year;  
        }
    }
    
    // Make your sorting algorithm class to generic. 
    // However, Comparable class has already implement as generic. So you don't have to implement your sort algorithm as generic.
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
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

        System.out.println("Before sorting:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println();
        SelectionSort.sort(students);

        System.out.println("After sorting by GPA:");
        for (Student s : students) {
            System.out.println(s);
        }
        
        System.out.println("--------------------");
        
        System.out.println("Before sorting:");
        for (Date d : dates) {
        	System.out.println(d);
        }
        
        System.out.println();
        SelectionSort.sort(dates);
        
        System.out.println("After sorting:");
        for (Date d : dates) {
        	System.out.println(d);
        }
	
	}

}
