package site.masadamsahid.spring.data.jpa.tutorial.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.masadamsahid.spring.data.jpa.tutorial.entity.Course;
import site.masadamsahid.spring.data.jpa.tutorial.entity.Teacher;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
  
  @Autowired
  private CourseRepository courseRepository;
  
  @Test
  public void printCourses(){
    List<Course> courses = courseRepository.findAll();
    System.out.println("courses = " + courses);
  }
  
  @Test
  public void saveCourseWithTeacher(){
    Teacher teacher = Teacher.builder()
      .firstName("Retsam")
      .lastName("Nohtyp")
      .build();
    
    Course course = Course.builder()
      .title("Python")
      .credit(6)
      .teacher(teacher)
      .build();
    
    courseRepository.save(course);
  }
  
}