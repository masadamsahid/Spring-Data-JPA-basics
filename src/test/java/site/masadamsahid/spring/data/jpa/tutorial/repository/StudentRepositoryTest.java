package site.masadamsahid.spring.data.jpa.tutorial.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.masadamsahid.spring.data.jpa.tutorial.entity.Guardian;
import site.masadamsahid.spring.data.jpa.tutorial.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
  
  @Autowired
  private StudentRepository studentRepository;
  
  @Test
  public void saveStudent(){
    Student student = Student.builder()
      .emailId("adam@gmail.com")
      .firstName("Adam")
      .lastName("Sahid")
//      .guardianName("Hardi")
//      .guardianEmail("hardi@gmail.com")
//      .guardianMobile("999999")
      .build();
    
    studentRepository.save(student);
    
  }
  
  @Test
  public void saveStudentWithGuardian(){
    Guardian guardian = Guardian.builder()
      .name("Hardi")
      .email("hardi@gmail.com")
      .mobileNumber("999123")
      .build();
    
    Student student = Student.builder()
      .firstName("Mamun")
      .emailId("mamun@gmail.com")
      .lastName("Syuhada")
      .guardian(guardian)
      .build();
    
    studentRepository.save(student);
    
  }
  
  @Test
  public void printAllStudents(){
    List<Student> studentList = studentRepository.findAll();
    System.out.println("studentList = " + studentList);
  }
  
}