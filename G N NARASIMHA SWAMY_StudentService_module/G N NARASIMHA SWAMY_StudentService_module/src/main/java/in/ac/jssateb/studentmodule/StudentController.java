package in.ac.jssateb.studentmodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	@GetMapping("/students")
	public List<Student> list(){
		return service.listAll();
	}
	
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id){
		try {
			Student student=service.get(id);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/students")
	public void save(@RequestBody Student student) {
		service.save(student);
	}
	
	
	@PutMapping("/students/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Student student){
		try {
			Student existstudent=service.get(id);
			service.save(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("students/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
