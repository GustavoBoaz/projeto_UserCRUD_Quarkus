package org.dboaz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class of persistence of User in the database
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 * @see UserRegisterDTO
 * @see UserUpdateDTO
 */
@Entity
@Table(name = "tb_users")
public class UserModel {

    // System generated
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUser;

    // User generated
    private String name;
    private String email;
    private String password;

    // Constructors
    public UserModel() {
    }

    public UserModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserModel(Long idUser, String name, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

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
    
}
