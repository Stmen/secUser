package api.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@RequestMapping("/whoami")
	public ResponseEntity<?> authentication(HttpServletRequest request, 
			Principal user) {
		System.out.println("*** Usuário Logado: "+ user.getName() + " em "+ new Date());
		return new ResponseEntity<Principal>(user, HttpStatus.OK);
	}
	
}
