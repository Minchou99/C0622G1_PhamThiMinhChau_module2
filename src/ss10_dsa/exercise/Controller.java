package ss10_dsa.exercise;

public class Controller {
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "Huy");
        Student b = new Student(2, "Huy1");
        Student c = new Student(3, "Huy2");
        Student d = new Student(4, "Huy3");
        Student e = new Student(5, "Huy4");
        Student f = new Student(5, "Huy41");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);
//        studentMyArrayList.add(f, 2);
        studentMyArrayList.size();
        System.out.println(studentMyArrayList.size());

        System.out.println(studentMyArrayList.get(2).getName());

    }
}

