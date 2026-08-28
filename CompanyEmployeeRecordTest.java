class Employee {

    private int empId;
    private String empName;
    private double salary;

    Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }
}


class ManagerEmployee extends Employee {

    private double teamBonus;

    ManagerEmployee(
        int empId,
        String empName,
        double salary,
        double teamBonus
    ) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}


class InternEmployee extends Employee {

    private double stipendCap;

    InternEmployee(
        int empId,
        String empName,
        double salary,
        double stipendCap
    ) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    double effectiveSalary() {

        if (getSalary() < stipendCap) {
            return getSalary();
        } else {
            return stipendCap;
        }
    }
}


class ParkingSlot {

    String slotNo;
    int capacity;
    int occupiedCount;

    ParkingSlot(
        String slotNo,
        int capacity,
        int occupiedCount
    ) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    void allot(String vehicleNo) {

        if (occupiedCount < capacity) {
            occupiedCount++;

            System.out.println(
                vehicleNo + " allotted to slot " + slotNo
            );
        }
    }
}


class CompanyEmployeeRecord {

    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    // Shared counter for all CompanyEmployeeRecord objects.
    static int totalRecords = 0;

    CompanyEmployeeRecord(
        String name,
        String empId,
        Employee employee,
        ParkingSlot slot
    ) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;

        totalRecords++;
    }


    String fullProfile() {

        double effectivePay;

        // Manager gets salary + bonus.
        if (employee instanceof ManagerEmployee) {

            ManagerEmployee manager =
                (ManagerEmployee) employee;

            effectivePay = manager.effectiveSalary();

        // Intern gets the smaller of salary and stipend cap.
        } else if (employee instanceof InternEmployee) {

            InternEmployee intern =
                (InternEmployee) employee;

            effectivePay = intern.effectiveSalary();

        // Plain employee gets normal salary.
        } else {

            effectivePay = employee.getSalary();
        }


        String slotInfo;

        // Check for null before accessing slot.slotNo.
        if (slot != null) {
            slotInfo = slot.slotNo;
        } else {
            slotInfo = "no parking assigned";
        }


        return name
            + " | Pay: Rs " + effectivePay
            + " | Slot: " + slotInfo;
    }
}


public class CompanyEmployeeRecordTest {

    public static void main(String[] args) {

        // Create parking slots.
        ParkingSlot slotA1 =
            new ParkingSlot("A1", 4, 0);

        ParkingSlot slotA2 =
            new ParkingSlot("A2", 5, 0);


        // Create employees.
        Employee divya =
            new ManagerEmployee(
                101,
                "Divya",
                70000,
                8000
            );

        Employee karan =
            new Employee(
                102,
                "Karan",
                40000
            );

        Employee meera =
            new InternEmployee(
                103,
                "Meera",
                12000,
                10000
            );


        // Create three company employee records.
        // Only two employees receive parking.
        CompanyEmployeeRecord record1 =
            new CompanyEmployeeRecord(
                "Divya",
                "E101",
                divya,
                slotA1
            );

        CompanyEmployeeRecord record2 =
            new CompanyEmployeeRecord(
                "Karan",
                "E102",
                karan,
                slotA2
            );

        CompanyEmployeeRecord record3 =
            new CompanyEmployeeRecord(
                "Meera",
                "E103",
                meera,
                null
            );


        // Print the three profiles.
        System.out.println(record1.fullProfile());
        System.out.println(record2.fullProfile());
        System.out.println(record3.fullProfile());

        // Print total number of records.
        System.out.println(
            "Total records: "
            + CompanyEmployeeRecord.totalRecords
        );
    }
}
