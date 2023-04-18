package site.masadamsahid.spring.data.jpa.tutorial.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.masadamsahid.spring.data.jpa.tutorial.entity.Course;
import site.masadamsahid.spring.data.jpa.tutorial.entity.CourseMaterial;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
  
  @Autowired
  private CourseMaterialRepository repository;
  
  @Test
  public void saveCourseMaterial (){
  
    Course course = Course.builder()
      .title(".net")
      .credit(6)
      .build();
    
    CourseMaterial courseMaterial = CourseMaterial.builder()
      .url("www.masadamsahid.site")
      .course(course)
      .build();
    
    repository.save(courseMaterial);
  }
  
  @Test
  public void printAllCourseMaterials(){
    List<CourseMaterial> courseMaterials = repository.findAll();
    System.out.println("courseMaterials = " + courseMaterials);
  }
  
}