package example.exception.myfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired MyService myService;
	
	@GetMapping("/")
	public ResponseEntity<Employee> getEmployee(){
		Employee emp = new Employee(1, "Randhir", "Kumar");
//		myService.getEmployee();
		return new ResponseEntity<Employee>(emp,HttpStatus.OK); 
	}
}

record Employee(int id, String firstname, String lastname) {}
