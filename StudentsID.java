package texnologia.logismikou;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name="students_id")

public class StudentsID {
	
	//primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long student_id;

	//FOREIGN KEY FROM LONG INT course_id  from courses_id db COURSESID CLASS
	@Column(nullable = false, unique = true, length = 45)
	private String student_name;
	@Column(nullable = false, length=64)
	private int semester_count;
	@Column(nullable = false,length=64)
	private int project_grade;
	@Column(nullable = false,length=64)
	private int exam_grade;
	@Column(nullable = false,length=64)
	private int grade;
	@Column(nullable = false,length=64)
	private String course_chosen;
	
	
	
	
	
	public String getCourse_chosen() {
		return course_chosen;
	}
	public void setCourse_chosen(String course_chosen) {
		this.course_chosen = course_chosen;
	}
	//	@ManyToOne
//	@JoinColumn(name="courses_id",nullable = false, foreignKey = @ForeignKey(name = "fk_student_id" ))
//	private CoursesID fk_student_id;
//	
//	public CoursesID getFk_student_id() {
//		return fk_student_id;
//	}
//	public void setFk_student_id(CoursesID fk_student_id) {
//		this.fk_student_id = fk_student_id;
//	}
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getSemester_count() {
		return semester_count;
	}
	public void setSemester_count(int semester_count) {
		this.semester_count = semester_count;
	}
	public int getProject_grade() {
		return project_grade;
	}
	public void setProject_grade(int project_grade) {
		this.project_grade = project_grade;
	}
	public int getExam_grade() {
		return exam_grade;
	}
	public void setExam_grade(int exam_grade) {
		this.exam_grade = exam_grade;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
//	
//	//date 
//
//   
//	
//	
//	
//	public long getstudent_id() {
//		return student_id;
//	}
//	public void setId(long student_id) {
//		this.student_id = student_id;
//	}
////	public void setyear_join(long year_join) {
////		this.year_join = year_join;
////	}
////	public long getyear_join() {
////		return year_join;
////	}
//	public String getstudent_name() {
//		return student_name;
//	}
//	public void setstudent_name(String student_name) {
//		this.student_name = student_name;
//	}
//	public void setsemester_count(int semester_count) {
//		this.semester_count = semester_count;
//	}
//
//	public long getsemester_count() {
//		return semester_count;
//	}
//	public void setproject_grade(int project_grade) {
//		this.project_grade = project_grade;
//	}
//
//	public long getproject_grade() {
//		return project_grade;
//	}
//	public void setexam_grade(int exam_grade) {
//		this.exam_grade = exam_grade;
//	}
//
//	public long getexam_grade() {
//		return exam_grade;
//	}
//	public void setgrade(int grade) {
//		this.grade = grade;
//	}
//	public long getgrade() {
//		return grade;
//	}
}