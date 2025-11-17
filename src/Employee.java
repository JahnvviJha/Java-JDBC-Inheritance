public class Employee extends Person {
    int id;
    double salary;

    Employee(int id, String name, double salary) {
        super(name);
        this.id = id;
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}
