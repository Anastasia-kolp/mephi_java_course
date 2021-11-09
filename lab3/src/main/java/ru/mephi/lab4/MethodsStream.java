package ru.mephi.lab4;

import ru.mephi.lab3.*;

import java.util.List;
import java.util.stream.Collectors;

public class MethodsStream {
    public static void main(String... args) {
        List<Employee> myEmployees = Employee.createShortList();

        //2 examples of map
        List<String> emails = myEmployees.stream().map(Employee::geteMail).collect(Collectors.toList());
        System.out.println("Emails for newsletter:");
        emails.forEach(System.out::println);

        System.out.println("================================================");

        System.out.println("List of employees:");
        myEmployees.stream().map(x -> x.getGivenName() + ' ' + x.getSurName() + ", " + x.getAge()).forEach(System.out::println);

        System.out.println("================================================");

        //2 examples of peek
        System.out.println("Salary increase for IT department:");
        myEmployees.stream().filter(x -> x.getDept().equals("IT")).peek(x -> x.setSalary((int) (x.getSalary() * 1.2))).forEach(System.out::println);

        System.out.println("================================================");

        System.out.println("Increase age:");
        myEmployees.stream().peek(x -> x.setAge(x.getAge() + 1)).map(x -> x.getGivenName() + ' ' + x.getSurName() + ", " + x.getAge()).forEach(System.out::println);

        System.out.println("================================================");

        //2 examples of findFirst
        System.out.println("Executive: " + myEmployees.stream().filter(x -> x.getRole().equals(roles.EXECUTIVE)).findFirst().get());

        System.out.println("================================================");

        System.out.println("Male and staff: " + myEmployees.stream().filter(x -> x.getRole().equals(roles.STAFF)).filter(x -> x.getGender().equals(genders.MALE)).findFirst().get());

        System.out.println("================================================");

        //2 examples of allMatch
        System.out.println("All employees over 18: " + myEmployees.stream().allMatch(x -> x.getAge() > 18));

        System.out.println("================================================");

        System.out.println("All employees have a salary above 60,000: " + myEmployees.stream().allMatch(x -> x.getSalary() > 60000));

        System.out.println("================================================");

        //2 examples of max
        System.out.println("Max age in IT department: " + myEmployees.stream().filter(x -> x.getDept().equals("IT")).mapToInt(x -> x.getAge()).max().getAsInt());

        System.out.println("================================================");

        System.out.println("Max salary in company: " + myEmployees.stream().mapToInt(x -> x.getSalary()).max().getAsInt());

        System.out.println("================================================");

        //2 examples of min
        System.out.println("Min age in company: " + myEmployees.stream().mapToInt(x -> x.getAge()).min().getAsInt());

        System.out.println("================================================");

        System.out.println("Min salary in IT department: " + myEmployees.stream().filter(x -> x.getDept().equals("IT")).mapToInt(x -> x.getSalary()).min().getAsInt());

        System.out.println("================================================");

        //2 examples of average
        System.out.println("Average salary in company: " + Math.round(myEmployees.stream().mapToInt(x -> x.getSalary()).average().getAsDouble()));

        System.out.println("================================================");

        System.out.println("Average age in company: " + Math.round(myEmployees.stream().mapToInt(x -> x.getAge()).average().getAsDouble()));

        System.out.println("================================================");

        //2 examples of sum
        System.out.println("Sum salaries: " + myEmployees.stream().mapToInt(x -> x.getSalary()).sum());

        System.out.println("================================================");

        System.out.println("Sum salaries of STAFF: " + myEmployees.stream().filter(x -> x.getRole().equals(roles.STAFF)).mapToInt(x -> x.getSalary()).sum());
    }
}
