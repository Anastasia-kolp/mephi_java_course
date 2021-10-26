package ru.mephi.hw3;

import ru.mephi.lab3.Employee;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ApplicationLambda {
    public static void main(String... args) {
        BiPredicate<Employee, String> employeeBiPredicate = (t, s) -> t.getDept().equals(s);

        Function<Employee, Integer> employeeFunction = t -> t.getAge();

        Consumer<Employee> employeeConsumer = t -> System.out.println("Name: " + t.getGivenName() + " Surname: " + t.getSurName());

        Supplier<Employee> employeeSupplier = () -> new Employee.Builder().setName("Phill").setSurName("Brown").setAge(32).setDept("Design").setAddress("Brown street, 12").setCity("Moscow").setCode((short) 199).setGender(Employee.genders.MALE).setPhone(12345678901L).build();

        var list = employeeSupplier.get().createShortList();

        list.add(employeeSupplier.get());

        System.out.println("List of employees:");
        list.stream().forEach(t -> employeeConsumer.accept(t));

        System.out.println("Average age of company: ");
        int average = 0;
        for (int i = 0; i < list.size(); i++) {
            average += employeeFunction.apply(list.get(i));
        }
        average /= list.size();
        System.out.println(average);

        System.out.println("Average age of IT departament: ");
        average = 0;
        int m = 0;
        for (int i = 0; i < list.size(); i++) {
            if (employeeBiPredicate.test(list.get(i), "IT")) {
                average += employeeFunction.apply(list.get(i));
                m++;
            }
        }
        average /= m;
        System.out.println(average);
    }
}
