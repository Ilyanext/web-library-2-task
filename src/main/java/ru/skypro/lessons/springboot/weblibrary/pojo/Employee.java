package ru.skypro.lessons.springboot.weblibrary.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("salary")
    private int salary;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    @JsonBackReference
    @JsonProperty("position")
    private Position position;
    private int counter =0;
    public Employee() {
    }
    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Employee( String name, int salary) {
        this.id = counter++;
        this.name = name;
        this.salary = salary;
    }
    public Employee(String name, int salary, Position position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }
    public Employee(String name) {
        this.name = name;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Employee(Integer id, String name, int salary, Position position) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }
    public Integer getId() {
        return id;
    }

    public int setId(Integer id) {
        this.id = id;
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}