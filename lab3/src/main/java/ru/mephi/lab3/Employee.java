package ru.mephi.lab3;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String givenName;
    private String surName;
    private int age;
    private genders gender;
    private roles role;
    private String dept;
    private String eMail;
    private long phone;
    private String address;
    private String city;
    private String state;
    private short code;
    private int salary;

    protected boolean checkPhone(long phone) {
        return phone <= 99999999999L && phone >= 10000000000L;
    }

    public static class Builder {
        private Employee createEmployee;

        public Builder() {
            createEmployee = new Employee();
        }

        public Builder setName(String name) {
            createEmployee.givenName = name;
            return this;
        }

        public Builder setSurName(String surName) {
            createEmployee.surName = surName;
            return this;
        }

        public Builder setAge(int age) {
            if (age > 0) {
                if (age > 85) {
                    createEmployee.age = 85;
                    return this;
                } else {
                    createEmployee.age = age;
                    return this;
                }
            } else {
                throw new IllegalArgumentException("Age should be more than 0!");
            }
        }

        public Builder setGender(genders gender) {
            createEmployee.gender = gender;
            return this;
        }

        public Builder setRole(roles role) {
            createEmployee.role = role;
            return this;
        }

        public Builder setDept(String dept) {
            createEmployee.dept = dept;
            return this;
        }

        public Builder seteMail(String eMail) {
            createEmployee.eMail = eMail;
            return this;
        }

        public Builder setPhone(long phone) {
            if (createEmployee.checkPhone(phone)) {
                createEmployee.phone = phone;
                return this;
            } else {
                throw new IllegalArgumentException("Phone must contain 11 digits!");
            }
        }

        public Builder setAddress(String address) {
            createEmployee.address = address;
            return this;
        }

        public Builder setCity(String city) {
            createEmployee.city = city;
            return this;
        }

        public Builder setState(String state) {
            createEmployee.state = state;
            return this;
        }

        public Builder setCode(short code) {
            if (code > 0 && code < 1000) {
                createEmployee.code = code;
                return this;
            } else {
                throw new IllegalArgumentException("Code of state should be more than 0 and less than 1000!");
            }
        }

        public Builder setSalary(int salary) {
            if (salary > 0) {
                createEmployee.salary = salary;
                return this;
            } else {
                throw new IllegalArgumentException("Salary should be more than 0!");
            }
        }

        public Employee build() {
            return createEmployee;
        }
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = Math.min(age, 85);
        } else {
            throw new IllegalArgumentException("Age should be more than 0!");
        }
    }

    public void setGender(genders gender) {
        this.gender = gender;
    }

    public void setRole(roles role) {
        this.role = role;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhone(long phone) {
        if (checkPhone(phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone must contain 11 digits");
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCode(short code) {
        if (code > 0 && code < 1000) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("Code of state should be more than 0 and less than 1000!");
        }
    }

    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary should be more than 0!");
        }
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public genders getGender() {
        return gender;
    }

    public roles getRole() {
        return role;
    }

    public String getDept() {
        return dept;
    }

    public String geteMail() {
        return eMail;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public short getCode() {
        return code;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee(" + givenName +
                " " + surName +
                ", " + age +
                " years, " + gender +
                ", " + role +
                ", " + dept + " departament" +
                ", " + eMail +
                ", " + phone +
                ", Address: " + address +
                ", " + city +
                ", " + state +
                ", State code: " + code + ", Salary: " + salary +
                ')';
    }

    public static List<Employee> createShortList() {
        List<Employee> shortList = new ArrayList<>();
        String[] names = {"Ivan", "Olga", "Artem", "Anna", "Dmitriy", "Oleg", "Anastasia"};
        String[] surNames = {"Ivanov", "Kostuhina", "Petrov", "Petriga", "Morgunov", "Sidyakin", "Kolpakova"};
        int[] ages = {25, 35, 40, 18, 50, 84, 20};
        genders[] gender = {genders.MALE, genders.FEMALE, genders.MALE, genders.FEMALE, genders.MALE, genders.MALE, genders.FEMALE};
        roles[] role = {roles.STAFF, roles.EXECUTIVE, roles.EXECUTIVE, roles.MANAGER, roles.STAFF, roles.STAFF, roles.MANAGER};
        String[] depts = {"Human Resources", "Laboratory", "Building", "Bookkeeping", "IT", "Design", "IT"};
        String[] eMails = {"qwe@as.com", "dhbh@as.com", "fjhv@as.com", "apo@as.com", "oooo@as.com", "12345@as.com", "9870@as.com"};
        long[] phones = {60385912347L, 85789621475L, 12369874501L, 45632897126L, 14263987521L, 81428409267L, 75693410098L};
        String[] addresses = {"Red street, 1", "Orange street, 12", "Yellow street, 32", "Green street, 9", "Blue street, 2", "Pink street, 25", "Purple street, 4"};
        String[] cities = {"Saint-Petersburg", "Moscow", "Vladimir", "Rome", "Kaluga", "Saint-Petersburg", "Moscow"};
        String[] states = {"Saint-Petersburg", "Moscow", "Vladimirskaya", "Rome", "Kalugskaya", "Saint-Petersburg", "Moscow"};
        short[] codes = {178, 777, 33, 12, 40, 98, 197};
        int[] salaries = {50000, 100000, 120000, 70000, 45000, 40000, 80000};

        for (int i = 0; i < 7; i++) {
            Employee employee = new Builder().setName(names[i]).setSurName(surNames[i]).setAge(ages[i]).setGender(gender[i]).setRole(role[i]).setDept(depts[i]).seteMail(eMails[i]).setPhone(phones[i]).setAddress(addresses[i]).setCity(cities[i]).setState(states[i]).setCode(codes[i]).setSalary(salaries[i]).build();
            shortList.add(employee);
        }
        return shortList;
    }
}
