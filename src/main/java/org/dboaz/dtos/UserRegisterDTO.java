package org.dboaz.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.dboaz.models.UserModel;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * User representation to register a new user
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 * @see UserUpdateDTO
 * @see UserModel
 */
@Schema(name="UserRegisterDTO", description="User representation to create a new user")
public class UserRegisterDTO {

    // User generated
    @Schema(title = "Name", required = true, example = "Your Name")
    private @NotBlank String name;

    @Schema(title = "Email", required = true, example = "youremail@domain.com")
    private @NotBlank @Email String email;

    @Schema(title = "Password", required = true, example = "yourpassword")
    private @NotBlank String password;

    // Constructors
    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserModel toUserModel(){
        UserModel user = new UserModel();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
    
}
