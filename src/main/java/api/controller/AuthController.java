package api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
	
	@RequestMapping(value = "/public/{idUser}", method = RequestMethod.GET)
	public String getPublicUserByID(HttpServletRequest request, 
			@PathVariable int idUser) {
	 	try {
	 		return "Public User ID is: "+idUser;
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return "Error";
	 	} 	
	}
	
	@RequestMapping(value = "/private/{idUser}", method = RequestMethod.GET)
	public String getPrivateUserByID(HttpServletRequest request, 
			@PathVariable int idUser) {
	 	try {
	 		return "Private User ID is: "+idUser;
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return "Error";
	 	} 	
	}

}
