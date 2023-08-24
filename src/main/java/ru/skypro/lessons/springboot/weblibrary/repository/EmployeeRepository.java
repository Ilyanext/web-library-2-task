package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.dto.ReportDto;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> employees = new ArrayList<>();

    @Query(value = "SELECT * FROM employee",
            nativeQuery = true)
    List<EmployeeDTO> findAllEmployees();

    default Employee add(Employee employee){
        employees.add(employee);
        return employee;
    }
    List<EmployeeDTO> findByIdGreaterThan(int number);

    Page<Employee> findAll(Pageable employeeOfConcretePage);

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.dto." +
            "EmployeeFullInfo(e.id, e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p and e.id= :id")
    List<EmployeeFullInfo> findAllEmployeeFullInfo(@Param("id") int id);


    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.dto." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p and p.name = :position")
    List<EmployeeFullInfo> getEmployeesFullPosition(@Param("position") String position);

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.dto." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e  left join Position p on p.id= e.position.id " +
            "WHERE e.salary = (select  max (e.salary) from  Employee e) ")
    List<EmployeeFullInfo> withHighestSalary();

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.dto." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e  left join Position p on p.id= e.position.id " +
            "WHERE e.salary = (select  min (e.salary) from  Employee e) ")
    List<EmployeeFullInfo> withLowSalary();

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.dto." +
            "ReportDto(e.position.name, count (e.id), max(e.salary), min (e.salary), avg(e.salary)) " +
            "FROM Employee e  group by e.position ")
    List<ReportDto> buildReport();

//    @Query(value = "update employee set name = :name, " +
//            "salary = :salary where id = :id", nativeQuery = true)
//    void updateEmployee(int id, String name, int salary);

    public default void update(int id, Employee oldEmployee) {
        int index = findIndexById(id);
        if (index != -1) {
            employees.set(index, oldEmployee);
        }
    }

    private int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
}
