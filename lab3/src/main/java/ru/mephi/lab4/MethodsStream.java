package ru.mephi.lab4;

import ru.mephi.lab3.*;

import java.util.List;
import java.util.stream.Collectors;

public class MethodsStream {
    public static void main(String... args) {
        List<Employee> myEmployees = Employee.createShortList();

        myEmployees.forEach(System.out::println);

        System.out.println();

        //2 examples of map
        List<String> emails = myEmployees.stream().map(Employee::geteMail).collect(Collectors.toList());
        System.out.println("Emails for newsletter:");
        emails.forEach(System.out::println);

        System.out.println("================================================");

        System.out.println("List of employees:");
        myEmployees.stream().map(x -> x.getGivenName() + ' ' + x.getSurName() + ", " + x.getAge()).forEach(System.out::println);

        System.out.println("================================================");

        //2 examples of peek
        System.out.println("EXAMPLE of lazy");
        List<Employee> result = myEmployees.stream().filter(x -> x.getRole().equals(Roles.STAFF)).peek(x -> System.out.println("After filter STAFF: " + x.getSurName()))
                .filter(x -> x.getAge() > 30).peek(x -> System.out.println("After filter age > 20: " + x.getSurName()))
                .collect(Collectors.toList());
        System.out.println("STAFF with age over 30:");
        result.forEach(x -> System.out.println(x.getSurName() + ", " + x.getRole() + ", " + x.getAge()));

        System.out.println("================================================");

        List<Employee>females = myEmployees.stream().filter(e -> e.getGender().equals(Genders.FEMALE)).peek(e -> Accountant.paySalary(e)).collect(Collectors.toList());//forEach(x -> System.out.println(x.getSurName() + " is female"));
        System.out.println("Female employees:");
        females.forEach(x -> System.out.println(x.getSurName()));

        System.out.println("================================================");

        //2 examples of findFirst
        System.out.println("Executive: " + myEmployees.stream().filter(x -> x.getRole().equals(Roles.EXECUTIVE)).findFirst().get());

        System.out.println("================================================");

        System.out.println("Male and staff: " + myEmployees.stream().filter(x -> x.getRole().equals(Roles.STAFF)).filter(x -> x.getGender().equals(Genders.MALE)).findFirst().get());

        System.out.println("================================================");

        //2 examples of allMatch
        System.out.println("All employees over 18: " + myEmployees.stream().allMatch(x -> x.getAge() > 18));

        System.out.println("================================================");

        System.out.println("All employees have a salary above 60,000: " + myEmployees.stream().allMatch(x -> x.getSalary() > 60000));

        System.out.println("================================================");

        //2 examples of max
        System.out.println("Max age in IT department: " + myEmployees.stream().filter(x -> x.getDept().equals("IT")).mapToInt(Employee::getAge).max().getAsInt());

        System.out.println("================================================");

        System.out.println("Max salary in company: " + myEmployees.stream().mapToInt(Employee::getSalary).max().getAsInt());

        System.out.println("================================================");

        //2 examples of min
        System.out.println("Min age in company: " + myEmployees.stream().mapToInt(Employee::getAge).min().getAsInt());

        System.out.println("================================================");

        System.out.println("Min salary in IT department: " + myEmployees.stream().filter(x -> x.getDept().equals("IT")).mapToInt(Employee::getSalary).min().getAsInt());

        System.out.println("================================================");

        //2 examples of average
        System.out.println("Average salary in company: " + Math.round(myEmployees.stream().mapToInt(Employee::getSalary).average().getAsDouble()));

        System.out.println("================================================");

        System.out.println("Average age in company: " + Math.round(myEmployees.stream().mapToInt(Employee::getAge).average().getAsDouble()));

        System.out.println("================================================");

        //2 examples of sum
        System.out.println("Sum salaries: " + myEmployees.stream().mapToInt(Employee::getSalary).sum());

        System.out.println("================================================");

        System.out.println("Sum salaries of STAFF: " + myEmployees.stream().filter(x -> x.getRole().equals(Roles.STAFF)).mapToInt(Employee::getSalary).sum());
    }
}
