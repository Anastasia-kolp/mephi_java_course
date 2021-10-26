package ru.mephi.lab3;

import java.util.List;

public class Accountant {
    public static void payPremium(Employee employee) {
        switch (employee.getRole()) {
            case STAFF:
                System.out.println("Premium 10% (" + employee.getRole().getPremium() + ") is paid for " + employee);
                break;
            case MANAGER:
                System.out.println("Premium 20% (" + employee.getRole().getPremium() + ") is paid for " + employee);
                break;
            case EXECUTIVE:
                System.out.println("Premium 30% (" + employee.getRole().getPremium() + ") is paid for " + employee);
                break;
        }
    }

    public static void paySalary(Employee employee) {
        switch (employee.getRole()) {
            case STAFF:
                System.out.println("Salary (" + employee.getRole().getPremium() * 10 / 2 + ") is paid for " + employee);
                break;
            case MANAGER:
                System.out.println("Salary (" + employee.getRole().getPremium() * 4 + ") is paid for " + employee);
                break;
            case EXECUTIVE:
                System.out.println("Salary (" + employee.getRole().getPremium() * 10 / 3 + ") is paid for " + employee);
                break;
        }
    }

    public static void main(String... args){
        Employee employee = new Employee();
        List<Employee> myList = employee.createShortList();
        myList.stream()
                .filter(x -> x.getGender().equals(Employee.genders.FEMALE))
                .forEach(x -> Accountant.payPremium(x));
        System.out.println("");
        myList.stream()
                .filter(x -> x.getDept().equals("Human Resources"))
                .forEach(x -> Accountant.paySalary(x));
        System.out.println("");
        myList.stream()
                .filter(x -> x.getAge() > 30 && x.getDept().equals("IT"))
                .forEach(x -> Accountant.payPremium(x));
        System.out.println("");
        myList.stream()
                .filter(x -> x.getRole().equals(Employee.roles.MANAGER))
                .forEach(x -> Accountant.paySalary(x));
        System.out.println("");
        myList.stream()
                .filter(x -> x.getRole().equals(Employee.roles.STAFF))
                .forEach(x -> Accountant.payPremium(x));
    }
}
