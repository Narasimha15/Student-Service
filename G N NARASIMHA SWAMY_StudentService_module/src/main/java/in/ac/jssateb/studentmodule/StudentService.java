package in.ac.jssateb.studentmodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	
	public List<Student> listAll(){
		return repo.findAll();
	}
	
	public Student get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void save(Student student) {
		repo.save(student);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
