package ru.skypro.lessons.springboot.weblibrary.dto;

public class PositionDto
{
    private int id;
    private String name;

    public PositionDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public PositionDto() {

    }
    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "PositionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
