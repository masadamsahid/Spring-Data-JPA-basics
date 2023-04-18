package site.masadamsahid.spring.data.jpa.tutorial.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
  
  @Test
  public void findAllPagination(){
    Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
    Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
    
    List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
    
    long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
    long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
    
    System.out.println("courses = " + courses);
    System.out.println("totalElements = " + totalElements);
    System.out.println("totalPages = " + totalPages);
  }
  
  @Test
  public void findAllSorting(){
    Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
    Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());
    Pageable sortByTitleAndCreditDesc =
      PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));
    
    List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
    
    System.out.println("courses = " + courses);
  }
  
}