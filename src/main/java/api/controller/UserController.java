package api.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.model.Error;
import api.model.UserDetails;
import api.service.UserDetailsService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> getUsers(HttpServletRequest request,
			@RequestParam(value = "name", required = false) String name) {
	
 		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 	    String name2 = auth.getName(); //get logged in username
 		System.out.println(name2);
	
 	    Iterable<UserDetails> users = new ArrayList<UserDetails>();
//		String source = request.getHeader("Referer");
//		String ip = request.getRemoteAddr();
	 	try {
	 		if (name != null){
//	 			UserDetails userDetails = userDetailsService.findUserByName(name);
//	 			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
	 			
	 		}else{
	 			users = this.userDetailsService.getAll();
	 			
	 		}
	 		return new ResponseEntity<Iterable<UserDetails>>(users, HttpStatus.OK);
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	}	 	
	}
	
	@RequestMapping(value = "/{idUser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> getUserByID(HttpServletRequest request, 
			@PathVariable int idUser) {
	 	try {
	 		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 	    String name = auth.getName(); //get logged in username
	 		System.out.println(name);
	 		
	 		UserDetails user = this.userDetailsService.findByID(idUser);
	 		if (user.getName() == null){
	 			return new ResponseEntity<Error>(new Error(404, "Usuário não encontrado"), HttpStatus.NOT_FOUND); 
	 		}
	 		
	 		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	} 	
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> postUser(HttpServletRequest request, @RequestBody UserDetails userDetails) {
		
	 	try {
	 		
	 		this.userDetailsService.persistUser(userDetails);
	 		
	 		return new ResponseEntity<String>(HttpStatus.OK);
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	}	 	
	}
	
	@RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> deleteUserByID(HttpServletRequest request, 
			@PathVariable int idUser) {
	 	try {
	 		
	 		UserDetails user = this.userDetailsService.findByID(idUser);
	 		if (user.getName() != null){
	 			this.userDetailsService.deleteUser(idUser);
	 			return new ResponseEntity<String>(HttpStatus.OK);
	 			
	 		}
	 		
	 		return new ResponseEntity<Error>(new Error(404, "Usuário não encontrado"), HttpStatus.NOT_FOUND); 
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	} 	
	}
	
	@RequestMapping(value = "/{idUser}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> putUser(HttpServletRequest request, @RequestBody UserDetails userUpdated,
			@PathVariable int idUser) {
		
	 	try {
	 		
	 		UserDetails userDetails = this.userDetailsService.findByID(idUser);
	 		if (userDetails.getName() == null){
	 			return new ResponseEntity<Error>(new Error(404, "Usuário não encontrado"), HttpStatus.NOT_FOUND); 
	 		}

	 		this.userDetailsService.persistUser(userUpdated);
	 		
	 		return new ResponseEntity<String>(HttpStatus.OK);
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	}	 	
	}
}
