package Composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates; // Tárol egy listát a saját típusából, így valósítva meg a fa struktúrát

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }
    public void add(Employee e){
        this.subordinates.add(e);
    }

    public void remove(Employee e){
        this.subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", subordinates=" + subordinates +

                '}';
    }
}
