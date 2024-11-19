package Human;

public class Human {
    protected String name;
    protected int age;
    protected int childrenCount;

    public Human(String name, int age, int childrenCount) {
        this.name = name;
        this.age = age;
        this.childrenCount = childrenCount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Children: " + childrenCount);
    }
}
