package api.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@RequestMapping("/whoami")
	public Principal authentication(HttpServletRequest request, 
			Principal user) {

		System.out.println("Usuário Logado: "+ user.getName());
		return user;
	}

}
