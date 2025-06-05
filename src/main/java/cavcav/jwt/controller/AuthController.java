package cavcav.jwt.controller;


import cavcav.jwt.dto.UserLoginDto;
import cavcav.jwt.dto.UserRegistrationDto;
import cavcav.jwt.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class    AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationDto> register(@RequestBody UserRegistrationDto userRegistrationDto) {
        return authService.create(userRegistrationDto);
    }
    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto login) {
        System.out.println(login.toString());
        return authService.verify(login);
    }

}
