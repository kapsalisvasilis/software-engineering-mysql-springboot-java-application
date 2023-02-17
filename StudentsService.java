package texnologia.logismikou;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class StudentsService{
 
    @Autowired
    private StudentsIDRepository repo3;
    

    
    public List<StudentsID> listAll() {
        return repo3.findAll();
    }
    public void save(StudentsID student_name) {
        repo3.save(student_name);
    }
    
    public List<StudentsID> proxiro3(String i){
    	return repo3.findByCourse(i);
    }
    
    public StudentsID get(long student_id) {
        return repo3.findById(student_id).get();
    }
    
    
    
    public List<StudentsID> get(String student_name) {
        return repo3.findByStudent(student_name);
    }
    public void saveS(StudentsID student_name) {
        repo3.save(student_name);
    }
    
    
     
   public void deleteS(long student_id) {
	   
        repo3.deleteById(student_id);
   }
   
   
   
   

   public List<StudentsID> getByKeyword(String keyword){
    return repo3.findByKeyword(keyword);
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}