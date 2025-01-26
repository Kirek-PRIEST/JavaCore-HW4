package hw;

public class Supervisor extends Employee {
    public Supervisor(String position, String name, String date, int salary, Gender gender) {
        super(position, name, date, salary, gender);
    }

    public static void salaryUp(Employee[] emp, int up) {
        for (Employee e : emp) {
            if (!e.getClass().equals(Supervisor.class)) {
                e.setSalary(e.getSalary() + up);
            }
        }
    }


}
