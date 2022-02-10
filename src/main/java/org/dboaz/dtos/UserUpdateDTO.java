package org.dboaz.dtos;

import javax.validation.constraints.NotBlank;

import org.dboaz.models.UserModel;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * User representation to update user in the database
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 * @see UserRegisterDTO
 * @see UserModel
 */
@Schema(name="UserUpdateDTO", description="User representation to update a user information")
public class UserUpdateDTO {

    // User generated
    @Schema(title = "Name", required = true, example = "Your Name")
    private @NotBlank  String name;

    @Schema(title = "Password", required = true, example = "yourpassword")
    private @NotBlank  String password;

    // Constructors
    public UserUpdateDTO() {
    }

    public UserUpdateDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
        user.setPassword(this.password);
        return user;
    }
    
}
