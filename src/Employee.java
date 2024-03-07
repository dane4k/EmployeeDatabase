import java.util.*;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private int year_of_birth;
    private String place_of_birth;
    private double salary;
    private String family_status;

    public Employee(int id, String name, String surname, int year_of_birth,
                    String place_of_birth, double salary, String family_status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.year_of_birth = year_of_birth;
        this.place_of_birth = place_of_birth;
        this.salary = salary;
        this.family_status = family_status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year_of_birth=" + year_of_birth +
                ", place_of_birth='" + place_of_birth + '\'' +
                ", salary=" + salary +
                ", family_status='" + family_status + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee(1, "Ivan", "Gordonov",
                2000, "USA", 1000, "married");
        Employee employee2 = new Employee(22, "Turet", "Portok",
                1999, "Russia", 1100, "single");
        Employee employee3 = new Employee(55, "Croma", "Steeck",
                1997, "Russia", 1500, "married");
        Employee employee4 = new Employee(3, "Alex", "Cropenson",
                1997, "Finland", 1300, "single");
        Employee employee5 = new Employee(112, "Samuel", "Wild",
                2001, "Turkey", 1111, "married");
        Employee employee6 = new Employee(13, "Dean", "Fritz",
                2002, "Italy", 1110, "single");
        Employee employee7 = new Employee(111, "Alex", "Witt",
                2003, "France", 1200, "married");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);


        if (employees.size() > 100) {
            System.out.println("Error: more than 100 employees found");
            System.exit(1);
        }
        Set<Integer> uniqueIDs = new HashSet<>();
        for (Employee employee : employees) {
            if (!uniqueIDs.add(employee.getId())) {
                System.out.println("Error: found matching ids");
                System.exit(1);
            }
        }
        Employee random_employee = findEmployeeById(employees, 22);
        if (random_employee != null) {
            System.out.println("Employee with this id:");
            System.out.println(random_employee);
            random_employee.setName("Gregory");
            System.out.println("Employee with edited name:");
            System.out.println(random_employee);
        } else {
            System.out.println("Employee with this id is not found");
        }
        Employee random_employee1 = findEmployeebyBirthday(employees, 1997);
        if (random_employee1 != null) {
            System.out.println("Employee with this year of Birth:");
            System.out.println(random_employee1);
        } else {
            System.out.println("Employee with this birth year is not found");
        }
        Employee random_employee2 = findEmployeeByName(employees, "Samuel");
        if (random_employee2 != null) {
            System.out.println("Employee with this name:");
            System.out.println(random_employee2);
        } else {
            System.out.println("Employee with this name is not found");
        }
        List<Employee> employeesWithSameName = findEmployeesByName(employees, "Alex");
        for (Employee employee : employeesWithSameName) {
            System.out.println("Employees with this matching name:");
            System.out.println(employee);
        }
        List<Employee> employeesWithSameBirthday = findEmployeesByBirthday(employees, 1997);
        for (Employee employee : employeesWithSameBirthday) {
            System.out.println("Employees with this matching year of birth:");
            System.out.println(employee);
        }
        System.out.println("Total amount of salary paid:");
        System.out.println(getSumSalaries(employees));

    }

    public int getId() {
        return id;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public String getName() {
        return name;
    }

    public static Employee findEmployeeById(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public static Employee findEmployeeByName(List<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (Objects.equals(employee.getName(), name)) {
                return employee;
            }
        }
        return null;
    }

    public static Employee findEmployeebyBirthday(List<Employee> employees, int year_of_birth) {
        for (Employee employee : employees) {
            if (employee.getYear_of_birth() == year_of_birth) {
                return employee;
            }
        }
        return null;
    }

    public static List<Employee> findEmployeesByName(List<Employee> employees, String name) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (Objects.equals(employee.getName(), name)) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    public static List<Employee> findEmployeesByBirthday(List<Employee> employees, int year_of_birth) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getYear_of_birth() == year_of_birth) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setFamily_status(String family_status) {
        this.family_status = family_status;
    }

    public static double getSumSalaries(List<Employee> employees) {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.salary;
        }
        return total;
    }
}


