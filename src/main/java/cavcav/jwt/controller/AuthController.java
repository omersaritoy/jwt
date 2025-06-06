package cavcav.jwt.controller;


import cavcav.jwt.dto.UserLoginDto;
import cavcav.jwt.dto.UserRegistrationDto;
import cavcav.jwt.model.User;
import cavcav.jwt.repository.UserRepository;
import cavcav.jwt.service.AuthService;
import cavcav.jwt.service.JwtService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager manager;
    private final JwtService jwtService;

    public AuthController(AuthService authService, AuthenticationManager manager, JwtService jwtService) {

        this.authService = authService;

        this.manager = manager;

        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationDto> register(@RequestBody UserRegistrationDto userRegistrationDto) {
        return authService.create(userRegistrationDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto login) {
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

        if (authentication.isAuthenticated()) {
            String token=jwtService.generateToken(authentication.getName());
            return ResponseEntity.ok("token:"+token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

    }

}
