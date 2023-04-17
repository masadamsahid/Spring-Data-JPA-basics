package site.masadamsahid.spring.data.jpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.masadamsahid.spring.data.jpa.tutorial.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  
  public List<Student> findByFirstName(String firstName);
  
}
