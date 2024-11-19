package Students;

import java.util.Objects;

public class Student {
    private String name;
    private Course[] courses;

    public Student(String name, Course[] courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public Course[] getCourses() {
        return courses;
    }

    public double getAverageGrade() {
        double totalGrade = 0;
        int totalCourses = courses.length;

        for (Course course : courses) {
            totalGrade += course.getGrade();
        }

        if (totalCourses > 0) {
            return totalGrade / totalCourses;
        } else {
            return 0;
        }
    }

    public boolean hasFailingCourses() {
        for (Course course : courses) {
            if (!course.isPassed()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
