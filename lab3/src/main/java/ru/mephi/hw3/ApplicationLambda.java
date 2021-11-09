package ru.mephi.hw3;

import ru.mephi.lab3.*;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ApplicationLambda {
    public static void main(String... args) {
        BiPredicate<Employee, String> employeeBiPredicate = (t, s) -> t.getDept().equals(s);

        Function<Employee, String> employeeFunction1 = t -> "Telephone number: " + t.getPhone();
        Function<Employee, String> employeeFunction2 = t -> "Surname: " + t.getSurName();

        Consumer<Employee> employeeConsumer = t -> System.out.println("Name: " + t.getGivenName() + " Surname: " + t.getSurName());

        Supplier<Employee> employeeSupplier = () -> new Employee.Builder().setName("Phill").setSurName("Brown").setAge(32).setDept("Design").setAddress("Brown street, 12").setCity("Moscow").setCode((short) 199).setGender(genders.MALE).setPhone(12345678901L).build();

        var list = employeeSupplier.get().createShortList();

        list.add(employeeSupplier.get());

        System.out.println("List of employees:");
        list.forEach(employeeConsumer);

        System.out.println("===========================================");

        for (Employee employee : list) {
            System.out.println(employeeFunction2.apply(employee));
            System.out.println(employeeFunction1.apply(employee));
            System.out.println("===========================================");

        }
        System.out.println("Average age of IT departament: ");
        int average = 0;
        int m = 0;
        for (Employee employee : list) {
            if (employeeBiPredicate.test(employee, "IT")) {
                average += employee.getAge();
                m++;
            }
        }
        average /= m;
        System.out.println(average);
    }
}
