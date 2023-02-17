package texnologia.logismikou;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class AllCoursesIDTests {

	@Autowired
	private CoursesRepository repo2;
	
	@Autowired
	private TestEntityManager entityManager3;
//	
	
	@Test
	public void testCreateSaveAndEditCourseID() {
		CoursesID course1 = new CoursesID();
		course1.setCourse_description("Description1");
		course1.setCourse_name("Old");
		course1.setCourse_num_participants((long)(99));
		course1.setCourse_professor("99@99");
		course1.setCourse_semester(99);
		CoursesID savedCourse = repo2.save(course1);
		course1.setCourse_description("Description2");
		course1.setCourse_name("new");
		course1.setCourse_num_participants((long)(100));
		course1.setCourse_professor("100@100");
		course1.setCourse_semester(100);
		savedCourse = repo2.save(course1);
		
		
	}
	
	
	@Test
	public void testCreateAndDeleteCourseID() {
		CoursesID course1 = new CoursesID();
		course1.setCourse_description("Description 404");
		course1.setCourse_name("404");
		course1.setCourse_num_participants((long)(404));
		course1.setCourse_professor("404@404");
		course1.setCourse_semester(404);
		CoursesID savedCourse = repo2.save(course1);
		repo2.delete(savedCourse);
		
		
	}
	
	@Test
	public void testCreateAndSaveCoursesID() {
		CoursesID course1 = new CoursesID();
		course1.setCourse_description("Description");
		course1.setCourse_name("testCourse");
		course1.setCourse_num_participants((long)(10));
		course1.setCourse_professor("test@test");
		course1.setCourse_semester(1);
		CoursesID savedCourse = repo2.save(course1);
	}
}
