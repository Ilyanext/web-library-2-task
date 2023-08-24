package ru.skypro.lessons.springboot.weblibrary.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.awt.print.Pageable;
import java.util.List;

public interface PaginEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

}
