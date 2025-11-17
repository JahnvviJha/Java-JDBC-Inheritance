public class Manager extends Employee {
    String department;

    Manager(int id, String name, double salary, String dept) {
        super(id, name, salary);
        this.department = dept;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + department);
    }
}
