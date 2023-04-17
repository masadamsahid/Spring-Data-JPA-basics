package site.masadamsahid.spring.data.jpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.masadamsahid.spring.data.jpa.tutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
