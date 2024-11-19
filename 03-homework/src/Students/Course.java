package Students;

import java.util.Objects;

public class Course {
    private String name;
    private double grade;  // Оцінка для курсу
    private boolean isPassed;  // Чи здали курс

    public Course(String name, double grade) {
        this.name = name;
        this.grade = grade;
        this.isPassed = grade >= 60;  // Вважати курс зданим, якщо оцінка >= 60
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public boolean isPassed() {
        return isPassed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return name.equals(other.name) && grade == other.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", isPassed=" + isPassed +
                '}';
    }
}
