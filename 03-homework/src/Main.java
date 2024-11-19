import Human.*;
import Students.*;
import Animals.*;

public class Main {
    public static void main(String[] args) {
        // Human
        Builder builder = new Builder("John", 35, 3, "Construction");
        Sailor sailor = new Sailor("Mike", 40, 2, "Black Pearl");
        Pilot pilot = new Pilot("Sarah", 30, 1, "SkyJet");

        Human[] friends = new Human[3];
        friends[0] = builder;
        friends[1] = sailor;
        friends[2] = pilot;

        for (Human friend : friends) {
            friend.showInfo();
            System.out.println();
        }

        int totalChildren = 0;
        for (Human friend : friends) {
            totalChildren += friend.getChildrenCount();
        }

        System.out.println("Total children of all friends: " + totalChildren);

        System.out.println("\n----------------------------------------\n");

        // Students
        Course course1 = new Course("Math", 85);
        Course course2 = new Course("Physics", 45);  // Незданий курс
        Course course3 = new Course("Chemistry", 92);
        Course course4 = new Course("Biology", 76);

        Student student1 = new Student("Alice", new Course[]{course1, course2});
        Student student2 = new Student("Bob", new Course[]{course3, course4});
        Student student3 = new Student("Charlie", new Course[]{course1, course3});

        Group group = new Group("Group 1", new Student[]{student1, student2, student3});

        System.out.println("Students with failing courses:");
        Student[] failingStudents = group.getFailingStudents();
        for (Student student : failingStudents) {
            System.out.println(student.getName());
        }

        System.out.println("\nStudents without any failures:");
        Student[] studentsWithoutFailures = group.getStudentsWithoutFailures();
        for (Student student : studentsWithoutFailures) {
            System.out.println(student.getName());
        }

        System.out.println("\nCourse with most failures: " + group.getCourseWithMostFails());

        System.out.println("\nStudent ratings:");
        group.printStudentRatings();

        System.out.println("\nCourses for Student 1 in semester 1:");
        System.out.println(group.getCoursesForStudentInSemester(student1, "Semester 1"));

        System.out.println("\n----------------------------------------\n");

        // Animals
        Tiger tiger = new Tiger("Tiggy", 50);
        Rabbit rabbit = new Rabbit("Bunny", 5);
        Wolf wolf = new Wolf("Wolfy", 30);
        Kangaroo kangaroo = new Kangaroo("Jack", 20);

        Zoo zoo = new Zoo(4);

        zoo.addAnimal(tiger);
        zoo.addAnimal(rabbit);
        zoo.addAnimal(wolf);
        zoo.addAnimal(kangaroo);

        zoo.showAnimals();

        System.out.println("Number of predators in the zoo: " + zoo.countPredators());

        System.out.println("Total food amount needed for the zoo: " + zoo.totalFoodAmount() + " kg");
    }
}