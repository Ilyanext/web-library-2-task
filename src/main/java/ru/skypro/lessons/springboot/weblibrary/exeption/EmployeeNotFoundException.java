package ru.skypro.lessons.springboot.weblibrary.exeption;

public class EmployeeNotFoundException extends RuntimeException {
    private final int id;

    public EmployeeNotFoundException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
