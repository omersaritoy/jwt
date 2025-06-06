package cavcav.jwt.service;

import cavcav.jwt.dto.UserLoginDto;
import cavcav.jwt.dto.UserRegistrationDto;
import cavcav.jwt.model.User;
import cavcav.jwt.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static cavcav.jwt.dto.UserRegistrationDto.toDto;
import static cavcav.jwt.dto.UserRegistrationDto.toEntity;

@Service
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);


    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
    }


    public ResponseEntity<UserRegistrationDto> create(UserRegistrationDto dto) {
        User newUser = toEntity(dto);
        newUser.setPassword(encoder.encode(dto.getPassword()));
        newUser = userRepository.save(newUser);

        return ResponseEntity.ok(toDto(newUser));
    }



}
