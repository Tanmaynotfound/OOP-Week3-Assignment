class Employee {

    private int empId;
    private String empName;
    private double salary;

    // Constructor
    Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    // Returns the basic salary
    double getSalary() {
        return salary;
    }
}


class ManagerEmployee extends Employee {

    private double teamBonus;

    // Constructor
    ManagerEmployee(int empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    // Manager's effective salary
    double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}


class InternEmployee extends Employee {

    private double stipendCap;

    // Constructor
    InternEmployee(int empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    // Intern's effective salary
    double effectiveSalary() {
        if (getSalary() < stipendCap) {
            return getSalary();
        } else {
            return stipendCap;
        }
    }
}


public class EmployeeTest {

    public static void main(String[] args) {

        // Create one Employee
        Employee employee = new Employee(101, "Ravi", 40000);

        // Create one ManagerEmployee
        Employee manager = new ManagerEmployee(102, "Divya", 70000, 8000);

        // Create one InternEmployee
        Employee intern = new InternEmployee(103, "Meera", 12000, 10000);

        // Use instanceof to decide which extra behaviour to invoke
        if (employee instanceof ManagerEmployee) {
            ManagerEmployee managerEmployee = (ManagerEmployee) employee;
            System.out.println("Manager effective pay: Rs " + managerEmployee.effectiveSalary());

        } else if (employee instanceof InternEmployee) {
            InternEmployee internEmployee = (InternEmployee) employee;
            System.out.println("Intern effective pay: Rs " + internEmployee.effectiveSalary());

        } else {
            System.out.println("Plain employee pay: Rs " + employee.getSalary());
        }


        if (manager instanceof ManagerEmployee) {
            ManagerEmployee managerEmployee = (ManagerEmployee) manager;
            System.out.println("Manager effective pay: Rs " + managerEmployee.effectiveSalary());

        } else if (manager instanceof InternEmployee) {
            InternEmployee internEmployee = (InternEmployee) manager;
            System.out.println("Intern effective pay: Rs " + internEmployee.effectiveSalary());

        } else {
            System.out.println("Plain employee pay: Rs " + manager.getSalary());
        }


        if (intern instanceof ManagerEmployee) {
            ManagerEmployee managerEmployee = (ManagerEmployee) intern;
            System.out.println("Manager effective pay: Rs " + managerEmployee.effectiveSalary());

        } else if (intern instanceof InternEmployee) {
            InternEmployee internEmployee = (InternEmployee) intern;
            System.out.println("Intern effective pay: Rs " + internEmployee.effectiveSalary());

        } else {
            System.out.println("Plain employee pay: Rs " + intern.getSalary());
        }
    }
}
