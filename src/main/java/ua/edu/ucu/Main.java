package ua.edu.ucu;

import ua.edu.ucu.Student;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getGPA() >= 4;
            }
        };

        MyPredicate pr2 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getYear() == 2;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student)o1).getSurname().compareTo(((Student)o2).getSurname())  ;
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() + " " + ((Student) t).getName();
            }
        };

        // Hint: to convert Object[] to String[] - use the following code
        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new DistinctDecorator(studentSmartArray);
        studentSmartArray = new SortDecorator(studentSmartArray, cmp);
        studentSmartArray = new FilterDecorator(studentSmartArray, pr);
        studentSmartArray = new FilterDecorator(studentSmartArray, pr2);
        studentSmartArray = new MapDecorator(studentSmartArray, func);

        for (Object o :
                studentSmartArray.toArray()) {
            System.out.println(o);
        }

    }
}
