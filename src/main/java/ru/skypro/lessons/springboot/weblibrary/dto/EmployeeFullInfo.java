package ru.skypro.lessons.springboot.weblibrary.dto;

import ru.skypro.lessons.springboot.weblibrary.pojo.Position;
import ru.skypro.lessons.springboot.weblibrary.pojo.Report;

public class EmployeeFullInfo {
    private int id;
    private String name;
    // Зарплата сотрудника
    private Integer salary;
    // Название должности сотрудника
    private String position;
    private int count = 0;


    // Конструктор класса EmployeeFullInfo
    public EmployeeFullInfo(int id, String name, Integer salary, String positionName) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = positionName;
    }

    public EmployeeFullInfo(String name, Integer salary, String positionName) {
        this.id = count++;
        this.name = name;
        this.salary = salary;
        this.position = positionName;
    }


    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPositionName() {
        return position;
    }

    public void setPositionName(String positionName) {
        this.position = positionName;
    }

    @Override
    public String toString() {
        return "EmployeeFullInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }
}
