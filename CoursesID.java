package texnologia.logismikou;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="courses_id")

public class CoursesID {
	
	//primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long course_id;
	
	@Column(nullable = false, unique = true, length = 45)
	private String course_name;
	@Column(nullable = false, length=64)
	private String course_description;
	@Column(nullable = false, length=20)
	private int course_semester;
	@Column(nullable = false, length=20)
	private long course_num_participants;
	@Column(nullable = false, length=64)
	private String course_professor;
//	@ManyToOne
//    @JoinColumn(name="professor_id",nullable = false, foreignKey = @ForeignKey(name = "fk_professor_id" ))
//	private User fk_professor_id;
//	
	
	///////new
//	protected CoursesID() {
//	}
	
	public String getCourse_professor() {
		return course_professor;
	}
	public void setCourse_professor(String course_professor) {
		this.course_professor = course_professor;
	}
	//	public User getProfessor_id() {
//		return fk_professor_id;
//	}
//	public void setProfessor_id(User fk_professor_id) {
//		this.fk_professor_id = fk_professor_id;
//	}
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_description() {
		return course_description;
	}
	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}
	public int getCourse_semester() {
		return course_semester;
	}
	public void setCourse_semester(int course_semester) {
		this.course_semester = course_semester;
	}
	public long getCourse_num_participants() {
		return course_num_participants;
	}
	public void setCourse_num_participants(long course_num_participants) {
		this.course_num_participants = course_num_participants;
	}
}