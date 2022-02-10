package org.dboaz.repositories;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.dboaz.models.UserModel;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * User repository to manage users
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 * @see PanacheRepository
 * @see UserModel
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<UserModel> {

    /**
     * Find a user by email, and return in Optional
     * 
     * @param email
     *           the email of the user
     * @return Optional<UserModel>
     * @author Boaz
     * @version 1.0
     * @date Feb 10, 2022
     * @see Optional
     * @see UserModel
     */
    public Optional<UserModel> findByEmail(String email) {
        return Optional.ofNullable(find("email", email).firstResult());
    }
    
}
