package texnologia.logismikou;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CoursesService{
 
    @Autowired
    private CoursesRepository repo2;
    

    
    public List<CoursesID> listAll() {
        return repo2.findAll();
    }
    public void save(CoursesID courses_id) {
        repo2.save(courses_id);
    }
    
    public List<CoursesID> proxiro(String i){
    	return repo2.findByProfessor(i);
    }
    
//    public List<CoursesID> findByProfessor(Long fk_professor_id) {
//        return repo2.findByProfessor(fk_professor_id);
//    }
//    public List<CoursesID> findByProfessor() {
//        return repo2.findAll();
//    }
    public CoursesID get(long courses_id) {
        return repo2.findById(courses_id).get();
    }
//    public CoursesID findByProfessor(String course_professor) {
//    	return repo2.findByProfessor(course_professor);
//    }
     
   public void delete(long courses_id) {
        repo2.deleteById(courses_id);
   }
}