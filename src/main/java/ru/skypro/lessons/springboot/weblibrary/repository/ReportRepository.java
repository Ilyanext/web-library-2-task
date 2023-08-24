package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.pojo.Report;

import java.util.Optional;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {

 static Optional<Integer> findById(Long id){
    return Optional.ofNullable(new Employee().getId());
}

    Optional<Report> findAllById(int id);
}
