package example.exception.myfiles;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MyService {

	public Employee getEmployee() {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Bad Request Sent !");
	}
}
