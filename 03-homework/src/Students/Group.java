package Students;

import java.util.Objects;

public class Group {
    private String groupName;
    private Student[] students;

    public Group(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public Student[] getFailingStudents() {
        int count = 0;
        for (Student student : students) {
            if (student.hasFailingCourses()) {
                count++;
            }
        }
        Student[] failingStudents = new Student[count];
        int index = 0;
        for (Student student : students) {
            if (student.hasFailingCourses()) {
                failingStudents[index++] = student;
            }
        }
        return failingStudents;
    }

    public Student[] getStudentsWithoutFailures() {
        int count = 0;
        for (Student student : students) {
            if (!student.hasFailingCourses()) {
                count++;
            }
        }
        Student[] studentsWithoutFailures = new Student[count];
        int index = 0;
        for (Student student : students) {
            if (!student.hasFailingCourses()) {
                studentsWithoutFailures[index++] = student;
            }
        }
        return studentsWithoutFailures;
    }

    public String getCourseWithMostFails() {
        String[] courseNames = new String[students[0].getCourses().length];
        int[] courseFailCount = new int[students[0].getCourses().length];

        for (int i = 0; i < students[0].getCourses().length; i++) {
            courseNames[i] = students[0].getCourses()[i].getName();
            courseFailCount[i] = 0;
            for (Student student : students) {
                if (!student.getCourses()[i].isPassed()) {
                    courseFailCount[i]++;
                }
            }
        }

        int maxFails = 0;
        String mostFailedCourse = null;
        for (int i = 0; i < courseFailCount.length; i++) {
            if (courseFailCount[i] > maxFails) {
                maxFails = courseFailCount[i];
                mostFailedCourse = courseNames[i];
            }
        }
        return mostFailedCourse;
    }

    public void printStudentRatings() {
        for (Student student : students) {
            System.out.println(student.getName() + " Average Rating: " + student.getAverageGrade());
        }
    }

    public String getCoursesForStudentInSemester(Student student, String semester) {
        StringBuilder sb = new StringBuilder();
        for (Course course : student.getCourses()) {
            sb.append(course.getName()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Group)) return false;
        Group other = (Group) obj;
        return groupName.equals(other.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
