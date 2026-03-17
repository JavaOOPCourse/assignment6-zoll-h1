import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        students.put("111", new Student("Baby", 4.0, 19));
        students.put("222", new Student("Black", 3.0, 18));
        students.put("333", new Student("Shampoo", 4.0, 19));
        students.put("444", new Student("Iphone", 5.0, 18));
        students.put("555", new Student("Abracadabra", 3.5, 100));

        // TODO: Напечатай всех студентов (ID + объект)
        System.out.println("============ ALl Students ============");
        for(Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println("Id: " + entry.getKey() + entry.getValue());
        }

            // TODO: Найди студента по ID и выведи его
            System.out.println("\n===== Found =====");
            String id1 = "111";
            Student student1 = students.get(id1);
            if (student1 != null) {
                System.out.println("Found: " + student1.getName());
            } else {
                System.out.println("Student not found");
            }

            // TODO: Удали одного студента по ID
            System.out.println("\n===== Removed =====");
            String id2 = "555";
            Student student2 = students.remove(id2);
            if (student2 != null) {
                System.out.println("Removed: " + student2.getName());
            } else {
                System.out.println("Not found");
            }

            // TODO: Обнови GPA у одного студента
        System.out.println("\n===== Update Gpa =====");
            String id3 = "444";
            double newGpa = 2.5;

            Student student3 = students.get(id3);
            if (student3 != null) {
                student3.setGpa(newGpa);
                System.out.println("Set gpa to : " + student3.getName() + " | " + "New Gpa: " + student3.getGpa());
            } else {
                System.out.println("Not found");
            }

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> list = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        System.out.println("\n===== Sorted By Gpa");
        Collections.sort(list);
        for(Student s : list) {
            System.out.println("Student :" + s);
        }
        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        System.out.println("\n===== Sorted By Name =====");
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.getName().compareTo(b.getName());
            }
        });
        for(Student s : list)
        System.out.println("Student: " + s);


        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        System.out.println("=====  List =====");
        ArrayList<Student> topList = new ArrayList<>(students.values());

        Collections.sort(topList, new Comparator<Student>() {
            @Override
            public int compare(Student b, Student a) {
                return Double.compare(b.getGpa(), a.getGpa());
            }
        });
        for(int i = 0; i < 3 && i < topList.size(); i++) {
            System.out.println(topList.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> gpaList = new HashMap<>();
        for(Student s : students.values()) {
            double gpa = s.getGpa();
            if(!gpaList.containsKey(gpa)) {
                gpaList.put(gpa, new ArrayList<>());
            }
            gpaList.get(gpa).add(s.getName());
        }
        for(Map.Entry<Double, List<String>> entry : gpaList.entrySet()) {
            Double gpa = entry.getKey();
            List<String> name = entry.getValue();
            if(name.size() > 1) {
                System.out.println("Gpa: " + gpa + name);
            }
        }
        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course webdev = new Course("Web-Dev");
        Course java = new Course("Java");

        courseMap.put(webdev, new ArrayList<Student>());
        courseMap.put(java, new ArrayList<Student>());

        courseMap.get(webdev).add(students.get("111"));
        courseMap.get(java).add(students.get("222"));
        courseMap.get(webdev).add(students.get("333"));
        courseMap.get(java).add(students.get("444"));
        for(Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        Comparator<Student> gpaSort = new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                int gpaCompare = Double.compare(b.getGpa(), a.getGpa());
                if(gpaCompare != 0) return gpaCompare;

                return a.getName().compareTo(b.getName());
            }
        };
        List<Student> list2 = new ArrayList<>(students.values());
        Collections.sort(list2, gpaSort);
        for(Student s : list2) {
            System.out.println(s);
        }
    }
}



