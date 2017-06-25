package hello.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int add(@RequestParam(value = "operand1") int operand1, 
			@RequestParam(value = "operand2") int operand2){
		LOGGER.debug("Adding {} to {}", operand1, operand2);
		return operand1 + operand2;
	}
	
	/*
	 * Here is an example of a controller level exception handler.
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	@ExceptionHandler(value = NumberFormatException.class)  
	 public String nfeHandler(NumberFormatException e){  
		LOGGER.debug("Sending a 400");
	    return e.getMessage();
	 }
	
}
