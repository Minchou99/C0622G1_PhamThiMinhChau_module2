package assignment.exercise1.model;

import java.util.Comparator;

public class SortByPointComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getPoint(), o1.getPoint());
    }
}
