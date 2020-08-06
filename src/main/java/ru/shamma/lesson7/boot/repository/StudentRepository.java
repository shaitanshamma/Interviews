package ru.shamma.lesson7.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shamma.lesson7.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
