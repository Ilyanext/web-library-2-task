package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.pojo.Position;

import java.util.ArrayList;
import java.util.List;

public class EmployeeObject {
    public static void EmployeesTest(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Ilya", 100000, new Position(1, "developer")));
        employeeList.add(new Employee(2, "Anna", 90000, new Position(2, "tester")));
        employeeList.add(new Employee(3, "Ilyas", 1100000, new Position(1, "developer")));

    }
}
