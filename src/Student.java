public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    // TODO: Task 1 — Создай конструктор, который принимает имя, GPA и возраст
    public Student(String name, double gpa, int age) {
        // заглушка
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    // TODO: Task 1 — Добавь возможность изменить GPA
    public void setGpa(double newGpa) {
        // заглушка
        if(newGpa < 0.0) {
            System.out.println("Can't be negative");
        }else if(newGpa > 5.0) {
            System.out.println("Can't be more than 5");
        }else {
            this.gpa = newGpa;
        }
    }

    // TODO: Task 1 (Sorting) — Реализуй Comparable по GPA (по возрастанию)
    @Override
    public int compareTo(Student other) {
        // заглушка — верни правильное значение сравнения
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        // TODO: Сделай красивый вывод
        return "\nName: " + name + " | " +
                "Gpa: " + gpa + " | " +
                "Age: " + age;
    }
}