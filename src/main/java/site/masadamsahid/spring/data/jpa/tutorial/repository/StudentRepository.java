package site.masadamsahid.spring.data.jpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.masadamsahid.spring.data.jpa.tutorial.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  
  List<Student> findByFirstName(String firstName);
  List<Student> findByFirstNameContaining(String name);
  List<Student> findByLastNameNotNull();
  List<Student> findByGuardianName(String name);
  
  Student findByFirstNameAndLastName(String firstName, String lastName);
  
  // Custom Repository Method Using JPQL
  @Query("SELECT s from Student s WHERE s.emailId = ?1")
  Student getStudentByEmailAddress(String emailId);
  
  // JPQL one particular column value
  @Query("SELECT s.firstName from Student s WHERE s.emailId = ?1")
  String getStudentFirstNameByEmailAddress(String emailId);
  
}
