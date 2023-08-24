package ru.skypro.lessons.springboot.weblibrary.dto;

public class ReportDto {
    private String position;
    private long count;
    private int maxSelary;
    private int minSelary;
    private double averageSalary;

    public ReportDto(String position, long count, int maxSelary, int minSelary, double averageSalary) {
        this.position = position;
        this.count = count;
        this.maxSelary = maxSelary;
        this.minSelary = minSelary;
        this.averageSalary = averageSalary;
    }

    public ReportDto() {

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getMaxSelary() {
        return maxSelary;
    }

    public void setMaxSelary(int maxSelary) {
        this.maxSelary = maxSelary;
    }

    public int getMinSelary() {
        return minSelary;
    }

    public void setMinSelary(int minSelary) {
        this.minSelary = minSelary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }
}
