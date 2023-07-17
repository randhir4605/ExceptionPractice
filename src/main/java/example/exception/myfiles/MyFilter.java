package example.exception.myfiles;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}catch(Exception ex) {
			MyError error = new MyError(HttpStatus.UNAUTHORIZED,"Unauthorised Access");
			ObjectMapper mapper = new ObjectMapper();
			String responseValue = mapper.writeValueAsString(error);
			response.setStatus(401);
			response.getOutputStream().print(responseValue);
			return;
		}
			
	}
}

record MyError(HttpStatus status,String errorMessage) {}

