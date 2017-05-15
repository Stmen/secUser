package api.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.model.Error;


@RestController
public class AuthController {
	
	@RequestMapping(value = "/me", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> getMe(HttpServletRequest request, 
			Principal user) {
	 	try {
	 		System.out.println("Usuário Logado: "+ user.getName());
	 		return new ResponseEntity<Principal>(user, HttpStatus.OK);
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	} 	
	}
	
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
