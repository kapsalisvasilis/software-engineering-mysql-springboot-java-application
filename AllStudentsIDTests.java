package texnologia.logismikou;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class AllStudentsIDTests {
//	
	@Autowired
	private StudentsIDRepository repo3;
	@Autowired
	private TestEntityManager entityManager2;
	
	@Test
	public void testCreateAndEditStudentsID() {
		StudentsID student1 = new StudentsID();
		student1.setSemester_count(99);
		student1.setStudent_name("TestStudent9999999");
		student1.setProject_grade(999);
		student1.setExam_grade(999);
		student1.setGrade(999);
		student1.setCourse_chosen("99");
		StudentsID savedStudent= repo3.save(student1);
		student1.setSemester_count(100);
		student1.setStudent_name("TestStudent100000");
		student1.setProject_grade(100);
		student1.setExam_grade(100);
		student1.setGrade(100);
		student1.setCourse_chosen("9999");
	
		savedStudent= repo3.save(student1);
		
		StudentsID exisStudent = entityManager2.find(StudentsID.class,savedStudent.getStudent_id());
		assertThat(exisStudent.getStudent_id()).isEqualTo(student1.getStudent_id());
	
	}
	@Test 
	public void testCreateAndDeleteStudentsID() {
		StudentsID student = new StudentsID();
		student.setSemester_count(404);
		student.setStudent_name("User404");
		student.setProject_grade(404);
		student.setExam_grade(404);
		student.setGrade(404);
		student.setCourse_chosen("404");
		
		StudentsID savedStudent = repo3.save(student);
		StudentsID existStudent = entityManager2.find(StudentsID.class,savedStudent.getStudent_id());
		repo3.delete(savedStudent);
		assertThat(existStudent.getStudent_id()).isEqualTo(student.getStudent_id());
		
	}
	
	@Test
	public void testCreateStudentsID() {
		StudentsID student1 = new StudentsID();
		student1.setSemester_count(99);
		student1.setStudent_name("TestStudent9999999");
		student1.setProject_grade(999);
		student1.setExam_grade(999);
		student1.setGrade(999);
		student1.setCourse_chosen("9999");
		
	
		StudentsID savedStudent= repo3.save(student1);
		
		StudentsID exisStudent = entityManager2.find(StudentsID.class,savedStudent.getStudent_id());
		assertThat(exisStudent.getStudent_id()).isEqualTo(student1.getStudent_id());
		 
	}
}
