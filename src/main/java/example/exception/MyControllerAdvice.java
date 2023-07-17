package example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<MyError> handler(ResponseStatusException ex){
		MyError error = new MyError(ex.getBody().getStatus(),ex.getBody().getDetail());
		return new ResponseEntity<MyError>(error,ex.getStatusCode());
	}
}

record MyError(int httpCode,String errorMessage) {}
