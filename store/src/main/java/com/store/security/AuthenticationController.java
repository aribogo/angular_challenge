package com.store.security;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.security.dto.AuthenticationDTO;
import com.store.security.dto.TokenDTO;
import com.store.security.service.AuthenticationService;

@RestController
@RequestMapping("v1/auth")
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	/**
	 * Authenticates user and gives a token or gives an unauthorized exception.
	 * @param authForm
	 * @return
	 */
	@PostMapping
	public ResponseEntity<TokenDTO> authenticate(@RequestBody AuthenticationDTO authForm) {

		try {
			return ResponseEntity.ok(authenticationService.authenticate(authForm));
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

	}

	
}
