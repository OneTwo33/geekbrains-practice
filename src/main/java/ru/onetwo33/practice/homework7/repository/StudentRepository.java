package ru.onetwo33.practice.homework7.repository;

import org.springframework.data.repository.CrudRepository;
import ru.onetwo33.practice.homework7.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
