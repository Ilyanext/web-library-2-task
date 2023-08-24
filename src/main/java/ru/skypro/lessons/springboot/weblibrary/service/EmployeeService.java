package ru.skypro.lessons.springboot.weblibrary.service;

import jakarta.annotation.Nullable;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    List<Employee> getEmployees();

    public Integer showSalary();

    Integer showAvgSalary();

    public List<EmployeeDTO> showSalaryMin();

    public List<EmployeeDTO> showSalaryMax();

    public List<EmployeeDTO> getEmployeesWithSalaryHigherThan(Integer salary);

    public List<EmployeeDTO> getEmployeesByIdWithRequired(Integer id);

    void deleteEmployeesWithId(int id);


    //    Employee addEmployee(List <Employee> employee);
    List<EmployeeDTO> addEmployee(List<Employee> employee);

    List<EmployeeDTO> findByIdGreaterThan(int number);


    List<EmployeeFullInfo> getEmployeesFull(int id);

    List<EmployeeFullInfo> getEmployeesFullPosition(@Nullable String position);

    List<EmployeeFullInfo> withHighestSalary();

    List<EmployeeFullInfo> withLowSalary();

    List<Employee> getEmployeesWithPaging(int page, int size);

    void uploadFile(@RequestParam("file") MultipartFile file) throws IOException;

    int generateReport();

    Resource findReport(int id);

    File findReportFile(int id);

    String generateReportFile(String content);


    void update(int id, Employee employee);
}

