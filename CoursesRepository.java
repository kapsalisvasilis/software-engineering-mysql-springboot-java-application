package texnologia.logismikou;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface CoursesRepository extends JpaRepository<CoursesID, Long>{
	@Query("SELECT u FROM CoursesID u WHERE u.course_professor = ?1")///users = User 
	List<CoursesID> findByProfessor(String course_professor);

	 
}