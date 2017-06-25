package hello.exception;

import org.springframework.http.HttpStatus;  
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * ConrollerAdvice is the global way to handle exceptions
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(value = BaseException.class)  
    public String handleBaseException(BaseException e){  
        return e.getMessage();
    }  
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = ObjectNotFoundException.class)
	public String handleObjectNotFound(ObjectNotFoundException e){
		return e.getMessage();
	}
  
    @ExceptionHandler(value = Exception.class)  
    public String handleException(Exception e){
    	return e.getMessage();
    }

}
