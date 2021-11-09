package ru.mephi.lab3;

import java.util.List;

public class Accountant {
    public static void payPremium(Employee employee) {
        switch (employee.getRole()) {
            case STAFF:
                System.out.println("Premium 10% (" + employee.getRole().getProcent() * employee.getSalary() + ") is paid for " + employee.getGivenName() + " " + employee.getSurName());
                break;
            case MANAGER:
                System.out.println("Premium 20% (" + employee.getRole().getProcent() * employee.getSalary() + ") is paid for " + employee.getGivenName() + " " + employee.getSurName());
                break;
            case EXECUTIVE:
                System.out.println("Premium 30% (" + employee.getRole().getProcent() * employee.getSalary() + ") is paid for " + employee.getGivenName() + " " + employee.getSurName());
                break;
        }
    }

    public static void paySalary(Employee employee) {
        switch (employee.getRole()) {
            case STAFF:
                System.out.println("Salary (" + employee.getSalary() + ") is paid for " + employee.getGivenName() + " " + employee.getSurName());
                break;
            case MANAGER:
                System.out.println("Salary (" + employee.getSalary() + ") is paid for " + employee.getGivenName() + " " + employee.getSurName());
                break;
            case EXECUTIVE:
                System.out.println("Salary (" + employee.getSalary() + ") is paid for " + employee.getGivenName() + " " + employee.getSurName());
                break;
        }
    }

    public static void main(String... args) {
        Employee employee = new Employee();
        List<Employee> myList = employee.createShortList();
        myList.stream()
                .filter(x -> x.getGender().equals(Genders.FEMALE))
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
                .filter(x -> x.getRole().equals(Roles.MANAGER))
                .forEach(x -> Accountant.paySalary(x));
        System.out.println("");
        myList.stream()
                .filter(x -> x.getRole().equals(Roles.STAFF))
                .forEach(x -> Accountant.payPremium(x));
    }
}
