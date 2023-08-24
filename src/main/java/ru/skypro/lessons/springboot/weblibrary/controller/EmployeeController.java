package ru.skypro.lessons.springboot.weblibrary.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> showEmployee() {
        return employeeService.getEmployees();
    }

    @GetMapping("/salary/sum")
    public Integer showSalary() {
        return employeeService.showSalary();
    }

    @GetMapping("/salary/avg")
    public Integer showAvgSalary() {
        return employeeService.showAvgSalary();
    }

    @GetMapping("/salary/min")
    public List<EmployeeDTO> showSalaryMin() {
        return employeeService.showSalaryMin();
    }

    @GetMapping("/salary/max")
    public List<EmployeeDTO> showSalaryMax() {
        return employeeService.showSalaryMax();
    }

    @GetMapping("/salaryHigherThan")
    public List<EmployeeDTO> getEmployeesWithSalaryHigherThan(@RequestParam("salary") Integer salary) {
        return employeeService.getEmployeesWithSalaryHigherThan(salary);
    }


    @GetMapping("/{id}")
    public List<EmployeeDTO> getEmployeesByIdWithRequired(@PathVariable(required = false) Integer id) {
        return employeeService.getEmployeesByIdWithRequired(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeesWithId(@PathVariable(required = false) Integer id) {
        employeeService.deleteEmployeesWithId(id);
    }

    @PostMapping
    public List<EmployeeDTO> addEmployee(@RequestBody List<Employee> employees) {
        return employeeService.addEmployee(employees);
    }

    @PutMapping("/{id}")
    public void editEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }

    @GetMapping("/fullInfo/{id}")
    public List<EmployeeFullInfo> getEmployeesFull( @PathVariable int id) {
        return employeeService.getEmployeesFull(id);
    }

    @GetMapping("/paging")
    public List<Employee> getEmployeesWithPaging(@RequestParam("page") int page, @RequestParam("size") int size) {
        return employeeService.getEmployeesWithPaging(page, size);
    }

    @GetMapping("/withHighestSalary")
    public List<EmployeeFullInfo> withHighestSalary() {
        return employeeService.withHighestSalary();
    }

    @GetMapping("/withLowSalary")
    public List<EmployeeFullInfo> withLowSalary() {
        return employeeService.withLowSalary();
    }

    @GetMapping("/position")
    public List<EmployeeFullInfo> getEmployeesFullPosition(@RequestParam(required = false) String position) {
        return employeeService.getEmployeesFullPosition(position);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFile(@RequestBody MultipartFile file) throws IOException {
        employeeService.uploadFile(file);
    }


}
