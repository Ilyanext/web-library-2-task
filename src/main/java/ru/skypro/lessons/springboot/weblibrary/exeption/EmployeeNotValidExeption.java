package ru.skypro.lessons.springboot.weblibrary.exeption;

import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

public class EmployeeNotValidExeption extends RuntimeException{
    private final Employee employee;
    public EmployeeNotValidExeption(Employee employee){
        this.employee = employee;
    }

    public EmployeeNotValidExeption(Employee employee, Employee employee1) {
        this.employee = employee1;
    }

    public Employee getEmployee(){
        return employee;
    }
}
