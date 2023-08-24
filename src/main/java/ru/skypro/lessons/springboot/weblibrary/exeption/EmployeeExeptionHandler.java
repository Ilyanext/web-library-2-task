package ru.skypro.lessons.springboot.weblibrary.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExeptionHandler {
    // Метод обработки исключений IOException.
    // Срабатывает, когда в контроллере возникает IOException.
   @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handlerNotFound (EmployeeNotFoundException e){
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body("Сотрудник с id = d% не найден".formatted(e.getId()));
   }
    @ExceptionHandler(EmployeeNotValidExeption.class)
    public ResponseEntity<?> handlerBadrequest (EmployeeNotValidExeption e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорректные данные сотрудника: %s".formatted(e.getEmployee()));
    }
}
