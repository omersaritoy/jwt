package cavcav.jwt.dto;

import cavcav.jwt.model.Role;
import cavcav.jwt.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

    private Long id;

    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    private String password;

    @NotBlank(message = "Password confirmation is required")
    private String confirmPassword;

    @Size(max = 15, message = "Phone must not exceed 15 characters")
    private String phone;

    private Role role;

    public static UserRegistrationDto toDto(User user) {
        return UserRegistrationDto.builder().id(user.getId()).firstName(user.getFirstName()).lastName(user.getLastName())
                .email(user.getEmail()).password(user.getPassword()).role(user.getRole()).phone(user.getPhone()).build();
    }

    public static User toEntity(UserRegistrationDto dto) {
        return User.builder().firstName(dto.getFirstName()).lastName(dto.getLastName())
                .email(dto.getEmail()).password(dto.getPassword()).role(dto.getRole())
                .phone(dto.getPhone()).build();
    }


}
