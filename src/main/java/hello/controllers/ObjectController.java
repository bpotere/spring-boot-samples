package hello.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.exception.ObjectNotFoundException;

@RestController
@RequestMapping("/object")
public class ObjectController {

	@RequestMapping("/")
	public void throwsObjectNotFound() throws ObjectNotFoundException{
		throw new ObjectNotFoundException("Object not found!");
	}
}
