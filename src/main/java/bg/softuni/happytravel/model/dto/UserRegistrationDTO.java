package bg.softuni.happytravel.model.dto;

import bg.softuni.happytravel.model.validation.FieldMatch;
import bg.softuni.happytravel.model.validation.UniqueUserEmail;
import bg.softuni.happytravel.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)
public class UserRegistrationDTO {


    @NotBlank(message = "Username should be provided.")
    @Size(min = 5 , max = 20 , message = "Username must be between 5 and 20 characters")
    @UniqueUsername(message = "Username should be unique.")
    private String username;

    @NotBlank
    @Size(min = 5 , max = 30)
    private String fullName;

    @NotBlank(message = "User email should be provided.")
    @Email(message = "User email should be valid.")
    @UniqueUserEmail(message = "User email should be unique.")
    private String email;

    @NotBlank
    @Size(min = 5 , max = 20)
    private String password;

    @NotBlank
    @Size(min = 5 , max = 20)
    private String confirmPassword;

    public UserRegistrationDTO() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
