package texnologia.logismikou;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AppController {
	
//	User us;
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private CoursesRepository repo2;
	@Autowired
	private StudentsIDRepository repo3;
	
	@Autowired
	private CoursesService service;
	@Autowired
	private StudentsService service1;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	  @ResponseBody
	  public String currentUserName(Authentication authentication) {
	     return authentication.getName();
	  }
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
//		this.us = user;
		return "register_success";
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public String process_createCourse(Model model) {
//		CoursesID course1 = new CoursesID();
//		model.addAttribute("course1",  course1);
//		return "create_course";
//	}
	//STUDENTS PART

	
//	@RequestMapping("/searchCourseStudents")
//	public String searchCourseStudentse(Model model) {
//		
//		
//		
//		
//
//	    StudentsID studentt;
//	    
//	    model.addAttribute("studentt", studentt);
//	    StudentsID student1 = getStudent_name(studentt);
//	    return "show_students_per_course";
//	}
	@RequestMapping(path = {"/search"})
	 public String search(StudentsID student, Model model, String keyword) {
	  if(keyword!=null) {
	   List<StudentsID> list = service1.getByKeyword(keyword);
	   model.addAttribute("list", list);
	  }else {
	  List<StudentsID> list = service1.listAll();
	  model.addAttribute("list", list);}
	  return "student_courses";
	 }
	
	@RequestMapping("/deleteS/{student_id}")
	public String deleteStudent(@PathVariable(name = "student_id")long student_id){
		
	    service1.deleteS(student_id);
	    return "redirect:/search";       
	}
	
//	@RequestMapping("/showStudentsPerCourse")
//	public String showStudentsPerCourse(Model model) {
//		
//		
//		
//
//	    List<StudentsID> student =  service1.proxiro3("mathimatika");
//	    
//	    model.addAttribute("student", student);
//	     
//	    return "show_students_per_course";
//	}
//	
//	@RequestMapping("/showStudentsPerCourse/{course_name}")
//	public String viewStudentList(Model model) {
//		
//		
//		List<StudentsID> listStudents =  repo3.findAll();
//		model.addAttribute("listStudents", listStudents);
//		return "show_students_per_course";
//		
//	}

//
//	@RequestMapping(value = "/saveS", method = RequestMethod.POST)
//	public String saveCourse(@ModelAttribute("course1") CoursesID course1) {
//	    service.save(course1);
//	     
//	    return "redirect:/list_courses";
//	}
//	
//	
	@RequestMapping("/create_student")
	public String process_createStudent(Model model) {
		StudentsID stud = new StudentsID();
		model.addAttribute("stud",  stud);
		return "create_student";
	}
	@RequestMapping("/redirect")
	public String processRedirect(Model model) {;
		return "redirect:/list_courses";
	}
	@RequestMapping(value = "/saveS", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("stud") StudentsID stud) {
	    service1.saveS(stud);
	     
	    return "redirect:/search";
	}
//	
//	
//	

//	
//	
//	
//	
	@RequestMapping("/editS/{student_id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "student_id") long student_id) {
		
	    ModelAndView mav = new ModelAndView("edit_student");
	    StudentsID stud = service1.get(student_id);
	    mav.addObject("stud", stud);
	     
	    return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//this is Courses part
	
	@RequestMapping("/list_courses")
	public String viewCourseList(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		List<CoursesID> listCourses =  service.proxiro(currentPrincipalName);
		model.addAttribute("listCourses", listCourses);
		return "courses_id";
		
	}
	
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course1") CoursesID course1) {
	    service.save(course1);
	     
	    return "redirect:/list_courses";
	}
	@RequestMapping("/delete/{course_id}")
	public String deleteCourse(@PathVariable(name = "course_id") long course_id){
	    service.delete(course_id);
	    return "redirect:/list_courses";       
	}
	
	
	
	
	@RequestMapping("/edit/{course_id}")
	public ModelAndView showEditCoursePage(@PathVariable(name = "course_id") long course_id) {
	    ModelAndView mav = new ModelAndView("edit_course");
	    CoursesID course = service.get(course_id);
	    mav.addObject("course", course);
	     
	    return mav;
	}
	
	

	
	@RequestMapping("/create_course")
	public String process_createCourse(Model model) {
		CoursesID course1 = new CoursesID();
		model.addAttribute("course1",  course1);
		return "create_course";
	}
	
	
}
