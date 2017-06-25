package hello.controllers;

import org.springframework.web.bind.annotation.RestController;

import hello.exception.BaseException;
import hello.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloController {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	
	// Handled by the global exception handler, except it shouldn't throw one ever
    @RequestMapping("/")
    public String index() {
    	LOGGER.info("Sending greetings");
        return "Greetings from Spring Boot!";
    }
    
    // Example of an optional query parameter
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    // Example of a required path parameter
    @RequestMapping("/hello/{name}")
    public Greeting hello(@PathVariable(value = "name", required = true) String name) {
    	return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    
	// Handled by the global exception handler
	@RequestMapping(value = "/global", method = RequestMethod.GET)
	public String alwaysBad() throws BaseException{
		throw new BaseException("This endpoint always throws a BaseException!");
	}
	

    
}
