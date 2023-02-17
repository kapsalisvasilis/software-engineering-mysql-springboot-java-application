package texnologia.logismikou;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentsIDRepository extends JpaRepository<StudentsID, Long>{
	@Query("SELECT u FROM StudentsID u WHERE u.course_chosen = ?1")///users = User 
	List<StudentsID> findByCourse(String course_chosen);
	
	
	
	@Query("SELECT u FROM StudentsID u WHERE u.student_name = ?1")///users = User 
	List<StudentsID> findByStudent(String student_name);

	@Query(value = "select * from students_id s where s.course_chosen like %:keyword% ", nativeQuery = true)
	List<StudentsID> findByKeyword(@Param("keyword") String keyword);
}